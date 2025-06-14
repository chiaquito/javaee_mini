package mini.domain;

public class SystemErrException extends RuntimeException {
    private String message;
    private Exception e;


    public SystemErrException(String message, Exception e){
        this.message = message;
        this.e = e;
    }

    public String getMessage() {
        return this.message;
    }
    
}
