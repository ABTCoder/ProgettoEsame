package stats;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import tasks.Task;

public abstract class StatCalculator {
	
	protected List<Statistics> result = new ArrayList<Statistics>();
	
	//Effettua il calcolo
	public abstract void calc(List<Task> elems, String field);
	
	//Restituisce i risultati (Nel caso di numeri la lista avrà un solo elemento)
	public List<Statistics> getResults(){
		return result;
	}
	
	protected Object invokeMethod(Object x, String name) {
		Object temp = null;
		//Il try-catch è obbligatorio ma l'eccezione NoSuchMethod è già gestita nella funzione di TaskList
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
