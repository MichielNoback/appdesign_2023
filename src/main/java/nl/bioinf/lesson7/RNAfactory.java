package nl.bioinf.lesson7;

public class RNAfactory extends SequenceFactory{

    @Override
    public Sequence createSequence(String sequence) {
        checkSequence(sequence);
        return new RNA(sequence);
    }

    @Override
    public String getSequenceRegex() {
        return "^[ACGUacgt]+$";
    }
}
