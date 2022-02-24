package pl.estrix.shopsync.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.estrix.shopsync.tool.CustomObjectMapper;

import java.util.List;

@Configuration
public class JacksonConfig implements WebMvcConfigurer {

    @Bean(name = "jsonMapper")
    @Primary
    public ObjectMapper jsonMapper() {
        return new CustomObjectMapper();
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter mc =
                new MappingJackson2HttpMessageConverter(jsonMapper());

        converters.add(mc);
    }
}
