package nl.bioinf.lesson4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseURLTest {

    @Test
    void getURL_normalUse_defaultPort() {
        String expected = "https://www.example.com";
        BaseURL baseURL = new BaseURL("www.example.com");
        String url = baseURL.getURL();
        assertEquals(expected, url);
    }

    @Test
    void getURL_normalUse_otherPort() {
        String expected = "https://www.example.com:8080";
        BaseURL baseURL = new BaseURL("www.example.com", Protocol.HTTPS, 8080);
        String url = baseURL.getURL();
        assertEquals(expected, url);
    }
}