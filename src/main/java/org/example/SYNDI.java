package org.example;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@SpringBootApplication
@EnableWebSecurity

@OpenAPIDefinition(
        info = @Info(
                title = "Mon API",
                version = "1.0",
                description = "Description de mon API"

        )
)
public class SYNDI {
    private final static Logger LOGGER= LoggerFactory.getLogger(SYNDI.class);
    public static void main(String[] args) {
        SpringApplication.run(SYNDI.class);
        LOGGER.debug("start application log 1");
        LOGGER.warn("start application log 2 ");
        LOGGER.info("start application log 3 ");
        LOGGER.error("start application log 4 ");}
}

