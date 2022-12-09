package se.lexicon.exceptions.workshop;

public class DuplicateNameException extends Exception{

    private String message;
    private Integer errorCode;
    private String param;

    public DuplicateNameException(String message, Integer errorCode, String param){
        super(message);
        this.errorCode=errorCode;
        this.param = param;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getParam() {
        return param;
    }
}
