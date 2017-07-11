package in.co.sample.model;

/**
 * Created by sdanayak on 7/7/17.
 */
public class Address {

    private String firstLineAddress;
    private String secondLineAddress;
    private String city;
    private String pincode;


    public String getFirstLineAddress() {
        return firstLineAddress;
    }

    public void setFirstLineAddress(String firstLineAddress) {
        this.firstLineAddress = firstLineAddress;
    }

    public String getSecondLineAddress() {
        return secondLineAddress;
    }

    public void setSecondLineAddress(String secondLineAddress) {
        this.secondLineAddress = secondLineAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address = (Address) o;

        if (firstLineAddress != null ? !firstLineAddress.equals(address.firstLineAddress) : address.firstLineAddress != null)
            return false;
        if (secondLineAddress != null ? !secondLineAddress.equals(address.secondLineAddress) : address.secondLineAddress != null)
            return false;
        if (city != null ? !city.equals(address.city) : address.city != null) return false;
        return pincode != null ? pincode.equals(address.pincode) : address.pincode == null;
    }

    @Override
    public int hashCode() {
        int result = firstLineAddress != null ? firstLineAddress.hashCode() : 0;
        result = 31 * result + (secondLineAddress != null ? secondLineAddress.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (pincode != null ? pincode.hashCode() : 0);
        return result;
    }
}
