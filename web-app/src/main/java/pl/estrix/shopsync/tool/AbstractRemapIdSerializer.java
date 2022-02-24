package pl.estrix.shopsync.tool;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import pl.estrix.shopsync.commons.annotation.RemapId;

import java.io.IOException;

import static com.google.common.base.Preconditions.checkArgument;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public abstract class AbstractRemapIdSerializer<T> extends StdSerializer<T>  implements ContextualSerializer {

    protected AbstractRemapIdSerializer(Class<T> t) {
        super(t);
    }

    private transient RemapId remapId;

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
            String session = SessionUtil.getSessionKey();
            jsonGenerator.writeString(session+"_"+value);
        } else {
            jsonGenerator.writeString(value);
        }
    }

    private boolean shouldBeEncrypted() {
        return remapId != null;
    }
}