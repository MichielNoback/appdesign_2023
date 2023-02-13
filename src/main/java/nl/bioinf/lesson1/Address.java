package nl.bioinf.lesson1;

import java.util.zip.ZipEntry;

public record Address(String street, int number, String zipCode) {
    @Override
    public int number() {
        return Math.abs(number);
    }
    public Address setZipCode(String newZip) {
        return new Address(street, number, newZip);
    }
}
