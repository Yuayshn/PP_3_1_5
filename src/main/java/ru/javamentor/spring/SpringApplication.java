package ru.javamentor.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;

@SpringBootApplication
public class SpringApplication {

    public static void main(String[] args) throws IOException {
        org.springframework.boot.SpringApplication.run(SpringApplication.class, args);
        openHomePage();
    }
    private static void openHomePage() throws IOException {
        Runtime rt = Runtime.getRuntime();
        rt.exec("rundll32 url.dll,FileProtocolHandler " + "http://localhost:8080/");
    }
}