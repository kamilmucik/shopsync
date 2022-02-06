package pl.estrix.shopsync.commons.core.model;


import com.google.common.base.Preconditions;
import lombok.Getter;
import lombok.Setter;

@Getter
@SuppressWarnings("serial")
public class ErrorResultException extends UtilsException {
    /**
     * log full stack exception, default enabled
     */
    @Setter
    protected boolean faultException = true;
    private ErrorCode errorCode;

    @Deprecated
    public ErrorResultException(int code, String message){
        this(ErrorCode.fromCode(code), message, null);
    }

    public ErrorResultException(ErrorCode errorCode, String message) {
        this(errorCode, message, null);
    }

    public ErrorResultException(ErrorCode errorCode, String message, Throwable cause) {
        this(errorCode, message, cause, true);
    }

    public ErrorResultException(ErrorCode errorCode, String message, boolean fault) {
        this(errorCode, message, null, fault);
    }

    /**
     * Creates result exception
     *
     * @param errorCode the error code
     * @param message   the error message
     * @param cause     the cause of error
     * @param fault     if {@code false} (default TRUE) error is logged on INFO level, not on ERROR by the BaseRestHandler
     */
    public ErrorResultException(ErrorCode errorCode, String message, Throwable cause, boolean fault) {
        super(message, cause);
        Preconditions.checkNotNull(errorCode,"ErrorCode can't be null");
        this.errorCode = errorCode;
        this.faultException = fault;
    }



}

