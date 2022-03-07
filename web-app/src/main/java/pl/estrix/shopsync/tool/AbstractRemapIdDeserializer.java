package pl.estrix.shopsync.tool;

import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import pl.estrix.shopsync.commons.annotation.RemapId;

import static org.apache.commons.lang3.ArrayUtils.isEmpty;


public abstract class AbstractRemapIdDeserializer<T> extends StdDeserializer<T> implements ContextualDeserializer {

    private transient RemapId remapId;

    protected AbstractRemapIdDeserializer(Class<T> t) {
        super(t);
    }

    protected abstract AbstractRemapIdDeserializer<T> createInstance();

    private void init(RemapId remapId) {
        this.remapId = remapId;
    }

    public JsonDeserializer<T> createContextual(DeserializationContext ctxt,
                                                BeanProperty beanProperty){
        RemapId remapId = beanProperty == null ? null : beanProperty.getAnnotation(RemapId.class);

        AbstractRemapIdDeserializer<T> deserializer = createDeserializerForRemap(remapId);
        if (deserializer!= null) {
            return deserializer;
        }

        return this;
    }

    public AbstractRemapIdDeserializer<T> createDeserializerForRemap(RemapId remapId) {
        if (remapId == null) {
            return null;
        }
        AbstractRemapIdDeserializer<T> serializer = createInstance();
        serializer.init(remapId);
        return serializer;
    }

    protected String deserialize(String message) {
        if (shouldBeDecrypted()) {
            return message.substring(4);
//            return decrypt(message, getCryptConf(getSessionKey()));
        } else {
            return message;
        }
    }

    private boolean shouldBeDecrypted() {
        return remapId != null && isEmpty(remapId.supportedValues());
    }
}
