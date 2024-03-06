package starferry.dev.szegeditamas.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import starferry.dev.szegeditamas.demo.config.ContentCalendarProperties;
import starferry.dev.szegeditamas.demo.model.Content;
import starferry.dev.szegeditamas.demo.model.Status;
import starferry.dev.szegeditamas.demo.model.Type;
import starferry.dev.szegeditamas.demo.repository.ContentRepository;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.Arrays;

@EnableConfigurationProperties(ContentCalendarProperties.class)
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class,args);


	}




}
