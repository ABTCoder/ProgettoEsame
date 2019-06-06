package stats;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tasks.Task;

public class StringStatCalculator implements StatCalculator {

	
	private Map<String, Integer> result = new HashMap();
	
	@Override
	public void calc(List<Task> elems, String field) {
		for(Task x : elems) {
			System.out.println("lol");
		}

	}

}
