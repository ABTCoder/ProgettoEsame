package stats;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import tasks.Task;

public abstract class StatCalculator {
	
	protected List<Statistics> result = new ArrayList<Statistics>();
	
	//Effettua il calcolo
	public abstract void calc(List<Task> elems, String field);
	
	public abstract List<Statistics> getResults();
	
	protected Object invokeMethod(Object x, String name) {
		Object temp = null;
		try {
			temp = x.getClass().getMethod("get"+name.substring(0, 1).toUpperCase()+name.substring(1)).invoke(x);
			return temp;
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			
			e.printStackTrace();
			return temp;
		} 
	}
}
