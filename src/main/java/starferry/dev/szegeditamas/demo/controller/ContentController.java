package starferry.dev.szegeditamas.demo.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import starferry.dev.szegeditamas.demo.model.Content;
import starferry.dev.szegeditamas.demo.model.Status;
import starferry.dev.szegeditamas.demo.repository.ContentRepository;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/content")
@CrossOrigin()
public class ContentController {

    private final ContentRepository repository;
    private List<LocalDateTime> reminders;
    private List<Integer> reminderDays = new ArrayList<>();

    public ContentController(ContentRepository repository) {
        this.repository=repository;
        reminderDays.add(1);
        reminderDays.add(5);
        reminderDays.add(14);
    }

    @GetMapping("")
    public List<Content>findAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Content content){
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Content content, @PathVariable Integer id){
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        repository.deleteById(id);
    }

    @GetMapping("/filter/{keyword}")
    public List<Content> findByTitle(@PathVariable String keyword){
        return repository.findAllByTitleContains(keyword);
    }

    @GetMapping("/filter/status/{status}")
    public List<Content> findByStatus(@PathVariable Status status){
        return repository.listByStatus(status);
    }


    @GetMapping("/reminders/{id}")
    public List<LocalDateTime> getDeadLines(@PathVariable Integer id){
        Content content =  repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
            reminders= new ArrayList<LocalDateTime>();
        for (Integer reminderDay : reminderDays) {
            reminders.add(content.deadline().minusDays(reminderDay));
        }

        return reminders;


    }

    @ResponseBody
    @PutMapping("/settings/")
    public List<Integer> setReminders(@RequestBody String reminders){
        if (reminders != null
        ) {
            int[] numbers = Arrays.stream(reminders.split(",")).mapToInt(Integer::parseInt).toArray();
            reminderDays = new ArrayList<>();
            for(Integer nums : numbers)
            {
                reminderDays.add(nums);
            }

        }
     return reminderDays;
    }

    @GetMapping("/settings/")
    public List<Integer> getReminders(){
        if (reminderDays != null
        ) {
            return reminderDays;

        }
        else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @Scheduled(fixedRate = 5000)
    public void updateStatus(){
        for(Content content : repository.findAll()){
            if (LocalDateTime.now().isAfter(content.deadline())&&(content.status().equals(Status.IDEA) || content.status().equals(Status.IN_PROGRESS ))){
                Content temp = new Content(content.id(),content.title(),content.desc(),Status.EXPIRED,content.contentType(),content.dateCreated(),content.dateUpdated(),content.url(),content.progress(),content.deadline());
                repository.save(temp);
            }
        }
    }




}
