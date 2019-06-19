package stats;

/**
 * Classe usata per salvare le statistiche su stringhe
 * @author Amal Benson Thaliath
 *
 */
public class Statistics {
	/**
	 * Elemento unico nel caso di stringhe, attributo (colonna dei dati) nel caso di numeri nelle classi figlie 
	 */
	protected String field;
	/**
	 * Numero di ricorrenze di field nel caso di stringhe, numero totale di dati non vuoti presenti nel csv per i numeri
	 */
	protected int count;
	
	/**
	 * Costruttore di Statistics
	 * @param field elemento unico o nome della colonna dei dati
	 * @param count ricorrenze o righe di dati non vuoti
	 */
	public Statistics(String field, int count) {
		this.field = field;
		this.count = count;
	}


	public String getField() {
		return field;
	}

	public int getCount() {
		return count;
	}
	
	
}
