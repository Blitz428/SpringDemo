package starferry.dev.szegeditamas.demo.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.relational.core.sql.In;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import starferry.dev.szegeditamas.demo.model.Content;
import starferry.dev.szegeditamas.demo.model.Status;

import java.time.LocalDateTime;
import java.util.List;

public interface ContentRepository extends ListCrudRepository<Content,Integer> {
List<Content> findAllByTitleContains(String keyword);

@Query("""
        SELECT * FROM Content
        where status = :status
        """)
List<Content> listByStatus(@Param("status") Status status);

    @Query("""
        SELECT reminders FROM Content
        where id = :id
        """)
List<LocalDateTime> listContentRemindersById(@Param("id")Integer id);
}
