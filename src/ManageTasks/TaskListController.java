package ManageTasks;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import stats.Statistics;
import tasks.Field;
import tasks.Task;
import tasks.TaskList;


/**
 * Classe Controller Rest, gestisce tutte le richieste GET, il service è gestito dalla classe {@link tasks.TaskList}
 * @author Amal Benson Thaliath
 *
 */
@RestController
public class TaskListController {

    /**
     * Restituisce l'intero dataset in formato Json (JsonArray)
     * @return lista contenente oggetti {@link tasks.Task} 
     */
    @RequestMapping("/data")
    public List<Task> data() {
    	return TaskList.getList();
    }
    
    /**
     * <p>Restituisce le statistiche per l'attributo richiesto (in formato JsonArray)</p>
     * <p>Se non si specifica il field il valore di default è "tipologia"</p>
     * @param field l'attributo (colonna dei dati) su cui si vogliono effettuare i calcoli statistici
     * @return lista contenente oggetti {@link stats.Statistics}
     */
    @RequestMapping("/stats")
    public List<Statistics> stats(@RequestParam(value="field",defaultValue="tipologia") String field){
    	return TaskList.calc(field);
    }
    
    /**
     * Restituisce un JsonArray contenente tutti i metadati specificando nome, tipo di variabile e alias
     * @return lista contenente oggetti {@link tasks.Field}
     */
    @RequestMapping("/metadata")
    public List<Field> metadata() {
    	return TaskList.getMetadata();
    }
    
}
