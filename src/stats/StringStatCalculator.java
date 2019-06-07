package stats;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tasks.Task;

public class StringStatCalculator implements StatCalculator {

	private List<Statistics> result = new ArrayList<Statistics>();
	private Map<String, Integer> temp = new HashMap<String, Integer>();
	
	@Override
	public void calc(List<Task> elems, String field) {
		for(Task x : elems) {
			String key = "";
			try {
				//Ottiene l'attributo in base al field passato(alias)
				key = (String) x.getClass().getMethod("get"+field.substring(0, 1).toUpperCase()+field.substring(1)).invoke(x);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
			
			//Aumento del conteggio degli elementi unici
			int count = temp.containsKey(key) ? temp.get(key) : 0;
			temp.put(key, count + 1);
							
		}
		
		//Creazione degli oggetti Statistics in base ai valori della mappa
		for (Map.Entry<String, Integer> entry : temp.entrySet()) {
			result.add(new Statistics(entry.getKey(), entry.getValue()));
		}

	}
	
	public List<Statistics> getResults(){
		return result;
	}

}
