package stats;

import java.util.List;

import tasks.Task;

public interface StatCalculator {

	public void calc(List<Task> elems, String field);
	
}
