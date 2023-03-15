package nl.bioinf.lesson7;

public class DNAfactory extends SequenceFactory{
    @Override
    public Sequence createSequence(String sequence) {
        checkSequence(sequence);
        return new DNA(sequence);
    }

    @Override
    public String getSequenceRegex() {
        return "^[ACGTacgt]+$";
    }
}
