package pl.estrix.shopsync.tool;


//import com.ailleron.evb.util.domain.crypt.CryptConf;
//import com.ailleron.evb.utils.domain.rypt.CryptUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import pl.estrix.shopsync.commons.annotation.RemapId;
//import pl.bpsa.service.cmmons.annotation.RemapId;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public abstract class AbstractRemapIdSerializer<T> extends StdSerializer<T>  implements ContextualSerializer {

    protected AbstractRemapIdSerializer(Class<T> t) {
        super(t);
    }

private transient RemapId remapId;
        Boolean useSalt = false;

    protected abstract AbstractRemapIdSerializer<T> createInstance();

    private void init(RemapId remapId) {
        this.remapId = remapId;
    }

    public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty beanProperty) {
        RemapId remapId = getRemapId(beanProperty);

        if (remapId != null) {
            validateRemapIdAttributes(remapId);
            AbstractRemapIdSerializer<T> serializer = createInstance();
            serializer.init(remapId);
            return serializer;
        }

        return this;
    }

    private RemapId getRemapId(BeanProperty beanProperty) {
        return beanProperty != null ? beanProperty.getAnnotation(RemapId.class) : null;
    }

    protected void validateRemapIdAttributes(RemapId remapId) {
        checkArgument(isNotBlank(remapId.value()));
    }

    protected void serialize(String value, JsonGenerator jsonGenerator) throws IOException, NoSuchFieldException {
        if (shouldBeEncrypted()) {
            jsonGenerator.writeString("test_"+value);
//            jsonGenerator.writeString(encrypt(value, getCryptConf(getSessionKey())));
        } else {
            jsonGenerator.writeString(value);
        }
    }

    private String getSessionKey(){
        try {
            HttpServletRequest request =
            ((ServletRequestAttributes)Objects.requireNonNull(RequestContextHolder.getRequestAttributes()))
            .getRequest();
            return request.getHeader("sessionkey");
        }catch (NullPointerException e){
            return StringUtils.EMPTY;
        }
        }

    private boolean shouldBeEncrypted() {
        return remapId != null;
    }

//    private String encrypt(Object value, CryptConf cryptConf) {
//        CryptUtil cryptUtil = CryptUtil.INSTANCE;
//        return cryptUtil.encryptRemapId(value, cryptConf);
//    }

//    private CryptConf getCryptConf(String session) {
//        return new CryptConf(useSalt, session,session + "productId");
//    }

}