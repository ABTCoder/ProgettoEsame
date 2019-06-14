package ManageTasks;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import stats.Statistics;
import tasks.Field;
import tasks.Task;
import tasks.TaskList;

@RestController
public class TaskListController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping("/data")
    public List<Task> data() throws FileNotFoundException {
    	return TaskList.getList();
    }
    
    @RequestMapping("/stats")
    public List<Statistics> stats(@RequestParam(value="field",defaultValue="Tipologia incarico") String field){
    	return TaskList.calc(field);
    }
    
    @ExceptionHandler (Exception.class)
    public String myExceptionHandler(Exception e) {
      
        return e.getMessage(); 
    }
    
    @RequestMapping("/metadata")
    public List<Field> metadata() {
    	return TaskList.getMetadata();
    }
    
}
