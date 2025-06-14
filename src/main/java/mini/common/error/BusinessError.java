package mini.common.error;

public class BusinessError extends RuntimeException implements ErrorInterface {
    private String message;
    public String getMessage(){
        return this.message;
    }

    public BusinessError(String message) {
        this.message = message;
    }
}
