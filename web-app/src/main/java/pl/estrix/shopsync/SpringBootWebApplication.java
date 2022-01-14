package pl.estrix.shopsync;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@SpringBootApplication
@RestController
@PropertySource(value = "file:/application.yml", ignoreResourceNotFound = true)
public class SpringBootWebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        new SpringBootWebApplication().configure(new SpringApplicationBuilder(SpringBootWebApplication.class)).run(args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

    private static Class<SpringBootWebApplication> applicationClass = SpringBootWebApplication.class;
}
