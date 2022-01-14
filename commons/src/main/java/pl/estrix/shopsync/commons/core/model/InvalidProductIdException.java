package pl.estrix.shopsync.commons.core.model;

/**
 * Created by mdabrowski on 4/21/16.
 */
public class InvalidProductIdException extends ErrorResultException {

    public InvalidProductIdException(String message) {
        super(ErrorCode.INVALID_PRODUCT_ID, message);
    }

    public InvalidProductIdException(final String message, final Throwable cause) {
        super(ErrorCode.INVALID_PRODUCT_ID, message, cause);
    }
}
