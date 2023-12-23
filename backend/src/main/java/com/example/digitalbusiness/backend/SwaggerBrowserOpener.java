// SwaggerBrowserOpener.java
package com.example.digitalbusiness.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SwaggerBrowserOpener implements CommandLineRunner {

    @Override
    public void run(String... args) {
        String swaggerUrl = "http://localhost:8080/swagger-ui.html";
        LaunchUtil.openBrowser(swaggerUrl);
    }
}
