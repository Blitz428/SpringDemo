package starferry.dev.szegeditamas.demo.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.ObjectInputFilter;
import java.time.LocalDateTime;
public record Content(@Id
                        Integer id,
                      @NotBlank
                      @Column(value = "title")
                      String title,
                      @Column(value = "description")
                      String desc,
                      @Column(value = "status")
                      Status status,
                      @Column(value = "content_type")
                      Type contentType,
                      @Column(value = "date_created")
                      LocalDateTime dateCreated,
                      @Column(value = "date_updated")
                      LocalDateTime dateUpdated,
                      @Column(value = "url")
                      String url,
                      @Column(value = "progress")
                      Double progress

) {
    public Content {
        if (status.equals(Status.COMPLETED) || status.equals(Status.PUBLISHED)){
            progress=100.0;
        }else
        {
            progress=0.0;
        }
    }
}
