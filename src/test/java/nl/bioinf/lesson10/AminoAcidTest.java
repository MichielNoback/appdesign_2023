package nl.bioinf.lesson10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AminoAcidTest {
    @Test
    void testAminoAcid() {
        var aa = new AminoAcid('K', 342.9, "AAA");
        System.out.println(aa);
        System.out.println(aa.codon());
        System.out.println(aa.hashCode());
    }
}