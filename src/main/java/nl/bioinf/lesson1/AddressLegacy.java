package nl.bioinf.lesson1;

import java.util.Objects;

public class AddressLegacy {
    private String street;
    private int number;
    //private String zipCode;
    private ZipCode zipCode;

    public AddressLegacy(String street, int number) {
        this.street = street;
        this.number = number;
    }

//    public void setStreet(String street) {
//        this.street = street;
//    }
//
//    public void setNumber(int number) {
//        this.number = number;
//    }

    public void setZipCode(String zipCode) {
        if (zipCode == null || zipCode.isEmpty()) throw new IllegalArgumentException("invalid zipcode!");
        //this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }

    public String getZipCode() {
        return zipCode.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressLegacy that = (AddressLegacy) o;

        if (number != that.number) return false;
        if (!Objects.equals(street, that.street)) return false;
        return Objects.equals(zipCode, that.zipCode);
    }

    @Override
    public int hashCode() {
        int result = street != null ? street.hashCode() : 0;
        result = 31 * result + number;
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AddressLegacy{" +
                "street='" + street + '\'' +
                ", number=" + number +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
