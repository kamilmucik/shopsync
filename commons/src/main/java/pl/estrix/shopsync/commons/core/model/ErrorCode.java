package pl.estrix.shopsync.commons.core.model;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by grpl on 2015-12-15.
 */
public enum ErrorCode {



    NO_ERROR(0),
    EXTERNAL_SERVICE_ERROR(100),
    INVALID_NEW_PASSWORD(101),
    CHANNEL_BLOCKED(102),
    INVALID_LOGIN_PASS(103),
    INVALID_NEW_PIN(104),
    SERVER_ERROR(105),
    PUSH_AUTHORIZATION_ORDER_ERROR(106),
    INVALID_PRODUCT_ID(107),
    INVALID_INPUT_DATA(108),
    INVALID_EXTERNAL_DATA(109),
    PREPARE_ORDER_ERROR(110),
    PUSH_ORDER_ERROR(111),
    EXPORT_TOO_MANY_ROWS(113),
    // error returned by ESB service which returned message to be presented to the end user
    ESB_USER_MESSAGE_ERROR(114),
    SECURITY_ALERT_ERROR(115),
    SMS_COUNTER_EXCEEDED(116),

    AUTH_LACK_SECURE_DEVICE(150),
    AUTH_USE_FIST_LOGIN(151),

    // 201-300 - calendar
    INVALID_OPERATION(201),
    INVALID_USER(202),
    // 301-400 - transfers
    ACCOUNT_CACHE_ERROR(302),
    ZUS_EXECUTION_DATE_TOO_LATE(303),
    GET_TRANSFER_CONFIRMATION_ERROR(307),
    GET_TRANSFER_PARAMS_ERROR(308),
    UNIQUE_CACHE(310), // history of transaction
    INVALID_TRANSFER_DATA(311),
    INVALID_TRANSFER_CHARACTERS(312),
    EXPRESS_TRANSFER_NOT_AVAILABLE_ERROR(315),
    SORBNET_TRANSFER_NOT_AVAILABLE_ERROR(323),
    STANDING_ORDER_NOT_AVAILABLE_ERROR(320),
    DOMESTIC_TRANSFER_AMOUNT_LIMIT_EXCEED_ERROR(324),
    FUTURE_TRANSFER_NOT_EXISTS_ERROR(339),
    PUSH_TAX_TRANSFER_INCORRECT_US_NRB(342), // ok
    PUSH_ZUS_TRANSFERS_FAILED_ALL_ERROR(343), // ok
    PUSH_ZUS_TRANSFERS_FAILED_FEW_ERROR(344), // ok
    LOAD_CUSTOMER_DATA_ERROR(349),
    GET_PBL_DATA_ERROR(361),
    GET_PBL_INVALID_PARTNER_ERROR(362),
    GET_PBL_DATA_ALREADY_EXISTS_ERROR(363),
    PBL_INVALID_ERROR(364),
    PBL_EXPIRY_TIME_ERROR(365),
    PUSH_FUTURE_TRANSFER_CANCELLATION_ERROR(366), // ok
    IBAN_NOT_EXISTS_OR_BIC_NOT_ASSOCIATED(367),
    BIC_NOT_EXISTS(368),

    NO_UNIQUE_ACCOUNT(369),
    NO_UNIQUE_SHORT_NAME(370),

    UNAVAILABLE_CURRENCY_ERROR(371),  // exchange rates

    GET_OPERATOR_DATA_ERROR(391),
    VERIFY_TOPUP_PREPARE_ORDER_ERROR(392),
    FINGERPRINT_ASSERT(393),
    TRANSFER_FINGERPRINT_ASSERT_AMOUNT(394),

    // 4xx Client Error
    FORBIDDEN_ACCESS(403),
    NOT_FOUND(404),

    // 5xx Server Error
    ERROR(500),

    //601-620 - history
    HISTORY_INVALID_CURSOR(601),
    HISTORY_CURSOR_CHANGED(602),
    HISTORY_STATEMENT_UNCLOSED_PERIOD(603),
    HISTORY_AGE_LIMIT_EXCEEDED(604),
    HISTORY_SPAN_LIMIT_EXCEEDED(605),
    //621-640 - account
    MODIFY_STATEMENT_FOR_ALL_OWNERS_ERROR(622),
    MODIFY_STATEMENT_FOR_ONLY_FEW_OWNERS_ERROR(623),

    //661-680 - widget
    WIDGET_MAX_ITEMS_EXCEEDED(661),

    //681-700 - bundle
    BND_INVALID_CURSOR(681),
    BND_FILTER_CHANGED(682),
    BND_DATA_CHANGED(683),

    //701-800 - invoice
    INVOICE_NOT_FOUND(701),
    INVOICE_UPLOAD_ERROR(702);


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
