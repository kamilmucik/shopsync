package pl.estrix.shopsync.commons.core.model;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public enum ErrorCode {

    NO_ERROR(0),
    INVALID_PRODUCT_ID(1),
    EXTERNAL_SERVICE_ERROR(100),
    SERVER_ERROR(105),

    // 4xx Client Error
    FORBIDDEN_ACCESS(403),
    NOT_FOUND(404),

    // 5xx Server Error
    ERROR(500);


    private int code;

    ErrorCode(int code) {
        this.code = code;
    }

    private static final ConcurrentMap<Integer, ErrorCode> ERROR_CODE_MAPPING = new ConcurrentHashMap<>();

    static {
        Arrays.stream(values()).forEach(errc -> ERROR_CODE_MAPPING.put(errc.getCode(), errc));
    }

    public static ErrorCode fromCode(int code) {
        return fromCode(code, ErrorCode.SERVER_ERROR);
    }

    public static ErrorCode fromCode(int code, ErrorCode defaultErrorCode) {
        return ERROR_CODE_MAPPING.getOrDefault(code, defaultErrorCode);
    }

    public int getCode() {
        return code;
    }


    @Override
    public String toString() {
        return String.format("%s (%s)", name(), code);
    }
}
