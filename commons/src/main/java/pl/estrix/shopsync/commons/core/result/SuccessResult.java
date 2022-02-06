package pl.estrix.shopsync.commons.core.result;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.ToString;
import pl.estrix.shopsync.commons.core.model.ErrorCode;

/**
 * Result class indicating that response was successful.
 */
@ToString(callSuper = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
@SuppressWarnings("serial")
public class SuccessResult<T > extends Result<T > {

    /**
     * This constructor is only for testing and deserializing.
     * It should not be used.
     */
    private SuccessResult() {
    }

    public SuccessResult(T data) {
        this.data = data;
        this.errorCode = null;
        this.message = null;
    }
    public SuccessResult(T data, ErrorCode errorCode) {
        this.data = data;
        this.errorCode = errorCode;
        this.message = null;
    }
    public SuccessResult(T data, ErrorCode errorCode, String errorMessage) {
        this.data = data;
        this.errorCode = errorCode;
        this.message = errorMessage;
    }
    public SuccessResult(T data, String errorMessage) {
        this.data = data;
        this.message = errorMessage;
    }

}