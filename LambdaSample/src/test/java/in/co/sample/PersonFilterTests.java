package in.co.sample;

import in.co.sample.model.Address;
import in.co.sample.model.Person;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by sdanayak on 7/7/17.
 */
public class PersonFilterTests {

    @Test
    public void should_get_same_name_person_filtered() {
        Person samplePerson = getSinglePerson("Limca1", "243, Jimbra Lane", " Adjacent to Kirloskar",
                new Date(1980, 1, 12), "Pune");
        List<Person> samplePersonList = getMultiplePersons(10);
        List<Person> response = samplePerson.filterByName(samplePersonList);
        Boolean found = lookupPerson(samplePerson, response);
        Assert.assertTrue(Boolean.TRUE == found);
    }

    @Test
    public void should_get_person_of_specific_city_filtered() {
        Person samplePerson = getSinglePerson("Limca1", "243, Jimbra Lane", " Adjacent to Kirloskar",
                new Date(1980, 1, 12), "Jaipur");
        List<Person> samplePersonList = getMultiplePersons(10);
        List<Person> response = samplePerson.filterByCity(samplePersonList);
        Boolean found = lookupPerson(samplePerson, response);
        Assert.assertFalse(found);
    }

    private Boolean lookupPerson(Person samplePerson, List<Person> response) {
        Boolean found = Boolean.FALSE;
        for(Person record: response) {
            if(samplePerson.getName().equals(record.getName())) {
                found = Boolean.TRUE;
            }
        }
        return found;
    }

    private Person getSinglePerson(String personName, String firstLineAddress, String secondLineAddress, Date birthDate, String city) {
        Person samplePerson;
        Address sampleAddress = new Address();
        sampleAddress.setCity(city);
        sampleAddress.setFirstLineAddress(firstLineAddress);
        sampleAddress.setSecondLineAddress(secondLineAddress);
        samplePerson = new Person.PersonBuilder().setAddress(sampleAddress)
                .setBirthDate(birthDate)
                .setName(personName)
                .build();
        return samplePerson;
    }

    private List<Person> getMultiplePersons(int countOfPerson) {
        List<Person> samplePersons = new ArrayList<>();
        for(int loop=1; loop<=countOfPerson; loop++) {
            samplePersons.add(getSinglePerson("Limca" + loop, "243, Jimbra Lane" + loop,
                    " Adjacent to Kirloskar", new Date(1980, loop, 12), "Pune"));
        }
        return samplePersons;
    }
}
