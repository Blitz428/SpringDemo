package starferry.dev.szegeditamas.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import starferry.dev.szegeditamas.demo.config.ContentCalendarProperties;

import java.util.Map;

@RestController
public class HelloController {

   private final ContentCalendarProperties properties;

    public HelloController(ContentCalendarProperties properties) {
        this.properties = properties;
    }

    @GetMapping("/")
    public ContentCalendarProperties home(){
        return properties;
    }
}
