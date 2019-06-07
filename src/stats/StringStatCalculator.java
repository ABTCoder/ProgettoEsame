package stats;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tasks.Task;

public class StringStatCalculator implements StatCalculator {

	
	private Map<String, Integer> result = new HashMap<String, Integer>();
	
	@Override
	public void calc(List<Task> elems, String field) {
		for(Task x : elems) {
			if(x.getFields().containsKey(field)) {
				int count = result.containsKey(x.getFields().get(field)) ? result.get(x.getFields().get(field)) : 0;
				result.put((String)x.getFields().get(field), count + 1);
					
			}
		}

	}
	
	public Map<String, Integer> getResult(){
		return result;
	}

}
