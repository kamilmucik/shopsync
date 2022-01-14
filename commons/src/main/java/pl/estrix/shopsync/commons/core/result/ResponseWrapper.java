package pl.estrix.shopsync.commons.core.result;

import lombok.Getter;
import pl.estrix.shopsync.commons.core.model.ErrorCode;

import java.io.Serializable;

@Getter
@SuppressWarnings("serial")
public class ResponseWrapper<T> implements Serializable {

    /**
     * Generic data Result
     */
    transient T data;

    /**
     * Error code
     */
    ErrorCode errorCode;

    public ResponseWrapper(T data, ErrorCode errorCode) {
        this.data = data;
        this.errorCode = errorCode;
    }
}
