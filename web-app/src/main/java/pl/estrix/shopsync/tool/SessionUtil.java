package pl.estrix.shopsync.tool;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class SessionUtil {

    private SessionUtil(){}

    public static String getSessionKey(){
        try {
            HttpServletRequest request =
                    ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes()))
                            .getRequest();
            Optional<Cookie> sessionId = Arrays.stream(request.getCookies()).filter(cookie -> cookie.getName().equals("JSESSIONID")).findFirst();
            return sessionId.isPresent() ? sessionId.get().getValue() : "";
        }catch (NullPointerException e){
            return EStringUtils.DEFAULT_MOCK;
        }
    }
}
