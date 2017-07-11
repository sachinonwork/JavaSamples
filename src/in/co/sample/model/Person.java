package in.co.sample.model;

import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by sdanayak on 7/7/17.
 */
public class Person {

    public Person(PersonBuilder personBuilder) {
        this.name = personBuilder.name;
        this.dateOfBirth = personBuilder.birthDate;
        this.address = personBuilder.address;
    }

    private String name;
    private Date dateOfBirth;
    private Address address;

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }


    public static List<Person> filter(List<Person> personList, Predicate<Person> predicate) {
        return personList.stream().filter(predicate).collect(Collectors.<Person>toList());
    }

    public List<Person> filterByName(List<Person> personList) {
       return filter(personList, (p -> p.getName().equals(getName())));
    }

    public List<Person> filterByCity(List<Person> personList) {
        return filter(personList, (p -> p.getAddress().getCity().equals(getAddress().getCity())));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (!name.equals(person.name)) return false;
        if (!dateOfBirth.equals(person.dateOfBirth)) return false;
        return address.equals(person.address);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + dateOfBirth.hashCode();
        result = 31 * result + address.hashCode();
        return result;
    }

    public static class PersonBuilder {
        private String name;
        private Date birthDate;
        private Address address;

        public PersonBuilder() {
        }

        public PersonBuilder(String name, Date birthDate, Address address) {
            this.name = name;
            this.birthDate = birthDate;
            this.address = address;
        }

        public PersonBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder setBirthDate(Date birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public PersonBuilder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public Person build() {
            Person person = new Person(this);
            return person;
        }
    }
}
