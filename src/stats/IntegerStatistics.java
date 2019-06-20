package stats;

/**
 * Classe utilizzata per salvare le statistiche su numeri interi in cui media e deviazione non interi abbiano poco senso
 * @author Amal Benson Thaliath
 *
 */
public class IntegerStatistics extends Statistics {
	
	/**
	 * Media
	 */
	private int avg;
	/**
	 * Minimo
	 */
	private int min;
	/**
	 * Massimo
	 */
	private int max;
	/**
	 * Deviazione standard
	 */
	private int std;
	/**
	 * Somma
	 */
	private int sum;
	
	/**
	 * Costruttore semplice di IntegerStatistics
	 * @param field nome dell'attributo (colonna dei dati)
	 * @param count numero totale di dati non vuoti
	 * @param avg media dei dati
	 * @param min minimo valore dei dati
	 * @param max massimo valore dei dati
	 * @param std deviazione standard
	 * @param sum somma dei dati
	 */
	public IntegerStatistics(String field, int count, double avg, double min, double max, double std, double sum) {
		super(field, count);
		this.avg = (int)avg;
		this.min = (int)min;
		this.max = (int)max;
		this.std = (int)std;
		this.sum = (int)sum;
	}
	
	/**
	 * Restituisce la media
	 * @return media
	 */
	public int getAvg() {
		return avg;
	}
	/**
	 * Restituisce il minimo
	 * @return minimo
	 */
	public int getMin() {
		return min;
	}
	/**
	 * Restituisce il massimo
	 * @return massimo
	 */
	public int getMax() {
		return max;
	}
	/**
	 * Restituisce la deviazione
	 * @return deviazione standard
	 */
	public int getStd() {
		return std;
	}
	/**
	 * Restituisce la somma
	 * @return somma
	 */
	public int getSum() {
		return sum;
	}
	
}
