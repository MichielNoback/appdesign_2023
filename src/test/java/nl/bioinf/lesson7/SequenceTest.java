package nl.bioinf.lesson7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SequenceTest {
    @Test
    void testCreateSequences() {
        String seq = "GAGATCATCAAGCAGCAtcagcatcagagacg";
        Sequence seqObj = new DNAfactory().createSequence(seq);
    }

}