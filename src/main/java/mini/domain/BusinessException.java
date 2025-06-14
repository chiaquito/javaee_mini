package mini.domain;

public class BusinessException extends RuntimeException {
    private String message;
    private Exception e;


    public BusinessException(String message, Exception e){
        this.message = message;
        this.e = e;
    }

    public String getMessage() {
        return this.message;
    }
}
