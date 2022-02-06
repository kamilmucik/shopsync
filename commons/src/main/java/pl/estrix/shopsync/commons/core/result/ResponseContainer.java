package pl.estrix.shopsync.commons.core.result;

public class ResponseContainer {
    private String serviceName;
    private Object responseHeaders;
    private long elapsedTime;
    private Object body;
    private String message;

    public long getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(long elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Object getResponseHeaders() {
        return responseHeaders;
    }

    public void setResponseHeaders(Object responseHeaders) {
        this.responseHeaders = responseHeaders;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
