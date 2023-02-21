package nl.bioinf.lesson4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public class WebResource {
    private BaseURL baseURL;
    private String localPath = "";
    private Map<String, String> requestParameters = new HashMap<>();

    public WebResource(BaseURL baseURL) {
        this.baseURL = baseURL;
    }

    public WebResource(BaseURL baseURL, String localPath) {
        this.baseURL = baseURL;
        this.localPath = localPath;
    }

    public String getUrl() {
        //"https://www.example.com:8080?species=roodborst?rating=4"
        //TODO for you to implement
        throw new UnsupportedOperationException("not implemented yet");
    }

    /**
     * Deletes any existing parameters and sets all parameters.
     * @param requestParameters
     */
    public void setRequestParameters (Map<String, String> requestParameters) {
        this.requestParameters = new HashMap<>(requestParameters);
    }

    public void addRequestParameter(String key, String value) {
        this.requestParameters.put(key, value);
    }

    public void addRequestParameter(Map.Entry<String, String> entry) {
        this.requestParameters.put(entry.getKey(), entry.getValue());
    }

    public Iterator<Map.Entry<String, String>> parameterIterator() {
        return this.requestParameters.entrySet().iterator();
    }

    public BaseURL getBaseURL() {
        return baseURL;
    }

    public String getLocalPath() {
        return localPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WebResource that = (WebResource) o;

        if (!Objects.equals(baseURL, that.baseURL)) return false;
        if (!Objects.equals(localPath, that.localPath)) return false;
        return Objects.equals(requestParameters, that.requestParameters);
    }

    @Override
    public int hashCode() {
        int result = baseURL != null ? baseURL.hashCode() : 0;
        result = 31 * result + (localPath != null ? localPath.hashCode() : 0);
        result = 31 * result + (requestParameters != null ? requestParameters.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "WebResource{" +
                "baseURL=" + baseURL +
                ", localPath='" + localPath + '\'' +
                ", requestParameters=" + requestParameters +
                '}';
    }
}
