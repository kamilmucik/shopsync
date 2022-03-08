package pl.estrix.shopsync.tool.serializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import pl.estrix.shopsync.tool.AbstractRemapIdSerializer;

import java.io.IOException;

public class StringRemapIdSerializer extends AbstractRemapIdSerializer<String>{

    public StringRemapIdSerializer() {
        super(String.class);
    }

    @Override
    public void serialize(String value, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException {
        serialize(value, jsonGenerator);
    }

    @Override
    protected AbstractRemapIdSerializer<String> createInstance() {
        return new StringRemapIdSerializer();
    }
}
