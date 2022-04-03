package pl.estrix.shopsync.tool;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ContextUtil {

    @Value("${node}")
    private String propertyOne;

    public String getConfigProperties(){
        return propertyOne;
    }
}
