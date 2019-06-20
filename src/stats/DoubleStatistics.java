package stats;

/**
 * Classe utilizzata per salvare le statistiche sui numeri che possono assumere qualunque valore reale
 * @author Amal Benson Thaliath
 *
 */
public class DoubleStatistics extends Statistics{
	
	/**
	 * Media
	 */
	private double avg;
	/**
	 * Minimo
	 */
	private double min;
	/**
	 * Massimo
	 */
	private double max;
	/**
	 * Deviazione standard
	 */
	private double std;
	/**
	 * Somma
	 */
	private double sum;
	
	/**
	 * Costruttore semplice di DoubleStatistics
	 * @param field nome dell'attributo (colonna dei dati)
	 * @param count numero totale di dati non vuoti
	 * @param avg media dei dati
	 * @param min minimo valore dei dati
	 * @param max massimo valore dei dati
	 * @param std deviazione standard
	 * @param sum somma dei dati
	 */
	public DoubleStatistics(String field, int count, double avg, double min, double max, double std, double sum) {
		super(field, count);
		this.avg = avg;
		this.min = min;
		this.max = max;
		this.std = std;
		this.sum = sum;
	}
	
	/**
	 * Restituisce la media
	 * @return media
	 */
	public double getAvg() {
		return avg;
	}
	/**
	 * Restituisce il minimo
	 * @return minimo
	 */
	public double getMin() {
		return min;
	}
	/**
	 * Restituisce il massimo
	 * @return massimo
	 */
	public double getMax() {
		return max;
	}
	/**
	 * Restituisce la deviazione
	 * @return deviazione standard
	 */
	public double getStd() {
		return std;
	}
	
	/**
	 * Restituisce la somma
	 * @return somma
	 */
	public double getSum() {
		return sum;
	}
}
