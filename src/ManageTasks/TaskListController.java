package ManageTasks;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import stats.Statistics;
import tasks.Field;
import tasks.Task;
import tasks.TaskList;

@RestController
public class TaskListController {

    
    @RequestMapping("/data")
    public List<Task> data() throws FileNotFoundException {
    	return TaskList.getList();
    }
    
    @RequestMapping("/stats")
    public List<Statistics> stats(@RequestParam(value="field",defaultValue="Tipologia incarico") String field){
    	return TaskList.calc(field);
    }
    
  
    @RequestMapping("/metadata")
    public List<Field> metadata() {
    	return TaskList.getMetadata();
    }
    
}
