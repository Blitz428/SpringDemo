package starferry.dev.szegeditamas.demo.repository;

import org.springframework.data.repository.ListCrudRepository;
import starferry.dev.szegeditamas.demo.model.User;

public interface UserRepository extends ListCrudRepository<User,Integer> {
}
