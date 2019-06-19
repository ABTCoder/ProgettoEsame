package stats;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tasks.Task;

/**
 * <p>Classe destinata al calcolo delle statistiche su un campo contenente stringhe</p>
 * <p>Per ogni elemento unico conta le ricorrenze</p>
 * @author Amal Benson Thaliath
 *
 */
public class StringStatCalculator extends StatCalculator {

	/**
	 * HashMap che ad ogni elemento unico (chiave) associa un valore pari al suo numero di ricorrenze
	 */
	private Map<String, Integer> temp = new HashMap<String, Integer>();
	
	/**
	 * <p>Implementazione del metodo astratto</p>
	 * <p>Scorre lungo la lista degli incarichi, invoca il getter dell'attributo passato, se l'elemento è unico 
	 * viene creata una nuova chiave correlata nella hashmap e il valore viene inzializzato a 1, altrimenti incrementa 
	 * di 1 il valore precedente</p>
	 */
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
