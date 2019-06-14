package stats;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tasks.Task;

public class StringStatCalculator extends StatCalculator {

	private Map<String, Integer> temp = new HashMap<String, Integer>();
	
	@Override
	public void calc(List<Task> elems, String field) {
		for(Task x : elems) {		
			//Ottiene il valore dell'attributo in base al field passato(alias)
			String key = (String) invokeMethod(x, field);
			
			//Aumento del conteggio degli elementi unici
			int count = temp.containsKey(key) ? temp.get(key) : 0;
			temp.put(key, count + 1);
							
		}
		
		//Creazione degli oggetti Statistics in base ai valori della mappa
		for (Map.Entry<String, Integer> entry : temp.entrySet()) {
			result.add(new Statistics(entry.getKey(), entry.getValue()));
		}

	}
	

}
