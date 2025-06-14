package mini.common.error;

public class InvalidParameterValueError extends RuntimeException implements ErrorInterface {
    private String parameterName;
    private String parameterValue;

    public String getMessage(){
        return String.format("the parameter %s is not permited value %s", parameterName, parameterValue);
    }

    public InvalidParameterValueError(String parameterName, String parameterValue) {
        this.parameterName = parameterValue;
    }
}
