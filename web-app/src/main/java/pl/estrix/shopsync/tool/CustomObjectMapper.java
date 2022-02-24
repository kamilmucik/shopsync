package pl.estrix.shopsync.tool;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import pl.estrix.shopsync.tool.deserializer.StringRemapIdDeserializer;
import pl.estrix.shopsync.tool.serializer.StringRemapIdSerializer;

@SuppressWarnings("serial")
public class CustomObjectMapper extends ObjectMapper{

    public CustomObjectMapper() {
        super();
        setSerializationInclusion(JsonInclude.Include.NON_NULL);
        setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        SimpleModule module = new SimpleModule("RemapIdModule", new Version(1, 0, 0, null, null, null));

        module.addSerializer(String.class, new StringRemapIdSerializer());
        module.addDeserializer(String.class, new StringRemapIdDeserializer());

        registerModule(module);
    }
}
