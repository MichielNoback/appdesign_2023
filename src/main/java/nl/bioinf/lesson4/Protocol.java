package nl.bioinf.lesson4;

public enum Protocol {
    HTTP,
    HTTPS,
    FTP,
    SSH;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
