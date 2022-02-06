package pl.estrix.shopsync.commons.core.model;

import com.google.common.base.Preconditions;
import org.apache.commons.lang.StringUtils;

/**
 * Creation Date: 2016-06-17
 */
public class UtilsException extends RuntimeException {


    public UtilsException(String message) {
        this(message, null);
    }

    public UtilsException(String message, Throwable cause) {
        super(message, cause);
        Preconditions.checkArgument(StringUtils.isNotBlank(message), "Message can't be blank");
    }

}