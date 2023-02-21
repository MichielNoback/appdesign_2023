package nl.bioinf.lesson4;

import java.util.Objects;

public class BaseURL {
    //private static BaseURL DEFAULT_BASE_URL;
    public static final int DEFAULT_PORT = 80;
    public static final Protocol DEFAULT_PROTOCOL = Protocol.HTTPS;
    private String domain;
    private Protocol protocol;
    private int port; //defaults to 80

//    static {
//        BaseURL.DEFAULT_BASE_URL = new BaseURL("www.example.com", Protocol.HTTPS, 80);
//    }

    public BaseURL(String domain, Protocol protocol, int port) {
        this.domain = domain;
        this.protocol = protocol;
        this.port = port;
    }

    public BaseURL(String domain, Protocol protocol) {
        this(domain, protocol, DEFAULT_PORT); //literal 80 = code smell: magical number
    }

    public BaseURL(String domain) {
        this(domain, DEFAULT_PROTOCOL, 80);
    }


    public String getURL() {
        //https://www.example.com:8080/
//        if (this.port == 80) {
//            return this.protocol + "://" + this.domain;
//        } else {
//            return this.protocol + "://" + this.domain + ":" + this.port;
//        }

        String portStr = (this.port == 80 ? "" : ":" + this.port);
        return this.protocol + "://" + this.domain + portStr;
    }

    public String getDomain() {
        return domain;
    }

    public Protocol getProtocol() {
        return protocol;
    }

    public int getPort() {
        return port;
    }

    @Override
    public String toString() {
        return "BaseURL{" +
                "domain='" + domain + '\'' +
                ", protocol=" + protocol +
                ", port=" + port +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseURL baseURL = (BaseURL) o;

        if (port != baseURL.port) return false;
        if (!Objects.equals(domain, baseURL.domain)) return false;
        return protocol == baseURL.protocol;
    }

    @Override
    public int hashCode() {
        int result = domain != null ? domain.hashCode() : 0;
        result = 31 * result + (protocol != null ? protocol.hashCode() : 0);
        result = 31 * result + port;
        return result;
    }
}