package stats;

import java.util.List;

import tasks.Task;

public interface StatCalculator {
	
	//Effettua il calcolo
	public void calc(List<Task> elems, String field);
	
	public List<Statistics> getResults();
}
