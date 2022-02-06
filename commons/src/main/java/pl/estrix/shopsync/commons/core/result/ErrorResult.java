package pl.estrix.shopsync.commons.core.result;

import lombok.ToString;
import pl.estrix.shopsync.commons.core.model.ErrorCode;

/**
 * Result class indicating that response was failed. Use it to send response to mobile.
 */
@ToString(callSuper = true)
@SuppressWarnings("serial")
public class ErrorResult<T> extends Result<T> {

    /**
     * This constructor is only for testing and deserializing.
     * It should not be used.
     */
    private ErrorResult() {
    }

    public ErrorResult(ErrorCode errorCode, String errorMessage, T data) {
        this.errorCode = errorCode;
        this.message = errorMessage;
        this.data = data;
    }

    @Override
//    @JsonIgnore
    public boolean isError() {
        return true;
    }
}