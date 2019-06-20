package stats;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import tasks.Task;

/**
 * Classe astratta utilizzata per calcolare le statistiche sui campi
 * @author Amal Benson Thaliath
 *
 */
public abstract class StatCalculator {
	
	/**
	 * La lista contenente i risultati del calcolo
	 */
	protected List<Statistics> result = new ArrayList<Statistics>();
	
	/**
	 * Effettua il calcolo, implementato nelle due classi figlie {@link stats.StringStatCalculator} 
	 * e {@link stats.NumberStatCalculator}
	 * @param elems la lista contenente gli incarichi
	 * @param field la colonna dei dati su cui si vuole effettuare il calcolo
	 */
	public abstract void calc(List<Task> elems, String field);
	
	/**
	 * Restituisce i risultati (Nel caso di numeri la lista avrà un solo elemento)
	 * @return lista contenente la statistica o le statistiche dell'attributo
	 */
	public List<Statistics> getResults(){
		return result;
	}
	
	/**
	 * Metodo utilizzato per ottenere il valore dell'attributo, conoscendone il nome, 
	 * di un qualsiasi oggetto invocando il getter appropriato. 
	 * Utilizzato all'interno del metodo {@link #calc(List, String)} nelle sue due 
	 * implementazioni
	 * @param x l'oggetto da cui verrà invocato il getter
	 * @param name nome dell'attributo
	 * @return l'attributo richiamato di tipo Object
	 */
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
