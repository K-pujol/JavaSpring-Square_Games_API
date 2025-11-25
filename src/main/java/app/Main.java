package app;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication

@OpenAPIDefinition(
        info = @Info(
                title = "Square_Games API",
                version = "1.0",
                description = "API documentation for managing Games in Square Games"
        )
)


public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
