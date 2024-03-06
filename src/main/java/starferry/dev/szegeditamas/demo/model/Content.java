package starferry.dev.szegeditamas.demo.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.ObjectInputFilter;
import java.time.LocalDateTime;

public record Content(@Id
                        Integer id,
                      @NotBlank
                      String title,
                      @Column(value = "description")
                      String desc,
                      Status status,
                      Type contentType,
                      LocalDateTime dateCreated,
                      LocalDateTime dateUpdated,
                      String url) {
}
