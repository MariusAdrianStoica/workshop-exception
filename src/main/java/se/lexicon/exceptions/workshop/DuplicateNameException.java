package se.lexicon.exceptions.workshop;

public class DuplicateNameException extends RuntimeException{ //MS extends Exception


    // MJ -> public class DuplicateNameException extends RuntimeException {
    //
    //  public DuplicateNameException(String message) {
    //    super(message);
    //  }
    //
    //}


    private String message;
    private Integer errorCode;
    private String param;

    public DuplicateNameException(String message, Integer errorCode, String param){
        super(message);
        this.errorCode=errorCode;
        this.param = param;
    }
    public DuplicateNameException(String message){
        super(message);
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getParam() {
        return param;
    }
}
