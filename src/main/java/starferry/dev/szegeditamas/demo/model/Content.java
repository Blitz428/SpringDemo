package starferry.dev.szegeditamas.demo.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.apache.logging.log4j.message.StringFormattedMessage;

import java.io.ObjectInputFilter;
import java.time.LocalDateTime;

public record Content(Integer id,
                      @NotBlank
                      String title,
                      String desc,
                      Status status,
                      Type contentType,
                      LocalDateTime dateCreated,
                      LocalDateTime dateUpdated,
                      String url) {
}
