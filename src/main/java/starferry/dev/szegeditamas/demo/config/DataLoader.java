package starferry.dev.szegeditamas.demo.config;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import starferry.dev.szegeditamas.demo.model.Content;
import starferry.dev.szegeditamas.demo.model.User;
import starferry.dev.szegeditamas.demo.repository.ContentRepository;
import starferry.dev.szegeditamas.demo.repository.UserRepository;

import java.io.InputStream;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final ContentRepository contentRepository;
    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    public DataLoader(ContentRepository repository, UserRepository userRepository, ObjectMapper objectMapper) {
        this.contentRepository = repository;
        this.userRepository = userRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        try(InputStream inputStream = TypeReference.class.getResourceAsStream("/data/content.json"))
        {
            contentRepository.saveAll(objectMapper.readValue(inputStream, new TypeReference<List<Content>>() {}));
        }
        try(InputStream inputStream = TypeReference.class.getResourceAsStream("/data/users.json"))
        {
            userRepository.saveAll(objectMapper.readValue(inputStream, new TypeReference<List<User>>() {}));
        }
    }
}
