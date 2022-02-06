package pl.estrix.shopsync.commons.core.result;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.ToString;
import org.codehaus.jackson.annotate.JsonIgnore;
import pl.estrix.shopsync.commons.annotation.ConfigJsonIgnore;
import pl.estrix.shopsync.commons.core.model.ErrorCode;

import java.io.Serializable;

import static java.util.Objects.nonNull;

/**
 * Web API result object
 * <p>
 * Creation Date: 2015-10-29
 *
 * @author Marcin Slowik
 */
@Getter
@ToString
@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
@SuppressWarnings("serial")
public class Result<T> implements Serializable {

    /**
     * Generic data Result
     */
    transient T data;
    /**
     * The error message
     */
    @ConfigJsonIgnore
    @JsonIgnore
    String message;
    /**
     * Error code
     */
    ErrorCode errorCode;

    Result() {
    }

    /**
     * @return TRUE if error descriptor is set
     */
    @JsonIgnore
    public boolean isError() {
        return nonNull(errorCode) && !errorCode.equals(ErrorCode.NO_ERROR);
    }
}
