package mainpackage.handlers;

public class baseResponseHandler {
    private final String status;
    private final Integer code;

    public baseResponseHandler(String status, Integer code) {
        this.status = status;
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public Integer getCode() {
        return code;
    }


}