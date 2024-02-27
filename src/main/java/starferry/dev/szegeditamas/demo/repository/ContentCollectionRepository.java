package starferry.dev.szegeditamas.demo.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import starferry.dev.szegeditamas.demo.model.Content;
import starferry.dev.szegeditamas.demo.model.Status;
import starferry.dev.szegeditamas.demo.model.Type;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {

    private final List<Content> contentList = new ArrayList<Content>();

    public ContentCollectionRepository() {
    }

    public List<Content> findAll(){
        return contentList;
    }
    public Optional<Content> findById(Integer id){
        return  contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

@PostConstruct
private void init(){
        Content c = new Content(
                1,
                "My first post",
                "post",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                ""
    );

       contentList.add(c);
}

    public void save(Content content) {
        contentList.removeIf(content1 -> content1.id().equals(content.id()));
        contentList.add(content);
    }

    public boolean existsById(Integer id) {
        return contentList.stream().filter(c->c.id().equals(id)).count()==1;
    }

    public void delete(Integer id) {
        contentList.removeIf(content1 -> content1.id().equals(id));
    }
}
