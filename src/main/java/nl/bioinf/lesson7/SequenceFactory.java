package nl.bioinf.lesson7;

public abstract class SequenceFactory {

    public Sequence createSequence(String sequence){
        throw new UnsupportedOperationException("abstract!");
    }

    public boolean checkSequence(String sequence) {
        if (null == sequence || sequence.isEmpty() || sequence.isBlank()) {
            throw new IllegalArgumentException("empty sequence");
        }
        if (! sequence.matches(getSequenceRegex())) {
            throw new IllegalArgumentException("sequence is not DNA");
        }
        return true;
    }

    public abstract String getSequenceRegex();
}
