package starferry.dev.szegeditamas.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import starferry.dev.szegeditamas.demo.model.Content;
import starferry.dev.szegeditamas.demo.model.User;
import starferry.dev.szegeditamas.demo.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin()
public class UserController {
    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<User> findAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
