package pl.estrix.shopsync.tool.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import pl.estrix.shopsync.tool.AbstractRemapIdDeserializer;

import java.io.IOException;

@SuppressWarnings("serial")
public class StringRemapIdDeserializer extends AbstractRemapIdDeserializer<String> {

    public StringRemapIdDeserializer() {
        super(String.class);
    }

    @Override
    public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return deserialize(jsonParser.getText());
    }

    @Override
    protected AbstractRemapIdDeserializer<String> createInstance() {
        return new StringRemapIdDeserializer();
    }
}
