package stats;

import java.util.List;
import java.lang.Math;

import tasks.Task;

/**
 * <p>Classe destinata al calcolo delle statistiche su attributi contenenti numeri, sia per Integer che per Double</p>
 * <p>Calcola la somma, conteggio, media, minimo, massimo e deviazione standard per l'attributo passato (colonna di dati)</p>
 * @author Amal Benson Thaliath
 *
 */
public class NumberStatCalculator extends StatCalculator {

	/**
	 * <p>Specifica il tipo di numero, integer o double. Se è un intero i valori saranno approssimati</p>
	 * <p>Questo è dovuto perchè avvolte una media o una deviazione con valori decimali avrebbe poco senso per
	 *  certi dati interi (es: popolazione)</p>
	 */
	private String type;
	/**
	 * Costruttore invocato in {@link tasks.TaskList#calc(String)}
	 * @param type Integer o Double
	 */
	public NumberStatCalculator(String type) {
		this.type = type;
	}
	
	/**
	 * Somma di tutti i dati della colonna
	 */
	private double sum = 0;
	/**
	 * Media di tutti i dati della colonna
	 */
	private double avg;
	/**
	 * Deviazione standard
	 */
	private double std;
	/**
	 * Minimo valore presente nella colonna dei dati
	 */
	private double min;
	/**
	 * Massimo valore presente nella colonna dei dati
	 */
	private double max;
	/**
	 * Conteggio elementi non nulli
	 */
	private int count;
	
	/**
	 * <p>Calcola le statistiche numeriche</p>
	 * <p>Se un dato non fosse presente nel csv esso durante il parsing verrà inizializzato come una stringa vuota 
	 * e verrà ignorato durante il calcolo</p>
	 */
	@Override
	public void calc(List<Task> elems, String field) {
		//Inizializzo il minimo e il massimo con il campo del primo elemento (non nullo) della lista
		//Se l'attributo non era presente nel dataset esso è salvato come una stringa vuota
		int i = 0;
		Object init = invokeMethod(elems.get(0), field);
		while(init instanceof String) {
			i++;
			init = invokeMethod(elems.get(i), field);
		}
		
		if(type.equals("Integer")) min = max = (double) (Integer)init;
		else min = max = (double) init;
		
		for(Task x : elems) {
			
			Object temp = invokeMethod(x, field);
			//Se l'attributo non era presente nel dataset esso è salvato come una stringa vuota
			//Perciò salto il ciclo
			if(temp instanceof String) continue;
			double num = 0;
			if(type.equals("Integer")) num = (double) (Integer)temp;
			else num = (double) temp;
			sum+= num; //Somma
			count++; //Conteggio
			min = (num < min) ? num:min;
			max = (num > max) ? num:max;
			
		}
		avg = sum / count; //Media
		
		//Secondo ciclo per il calcolo della deviazione standard
		double partial = 0; //Somma necessaria per la formula
		for(Task x : elems) {
			Object temp = invokeMethod(x,field);
			if(temp instanceof String) continue; //Se l'attributo non era presente nel dataset esso è salvato come una stringa
			double num = 0;
			if(type.equals("Integer")) num = (double) (Integer)temp;
			else num = (double) temp;
			
			partial+= Math.pow((num - avg),2);
		}
		
		std =  Math.sqrt(partial / count);
		
		//Aggiunta di un oggetto alla lista dei risulati DoubleStatistics o IntegerStatistics che ereditano da Statistics
		if(type.equals("Integer")) result.add(new IntegerStatistics(field, count, avg, min, max, std, sum));
		else result.add(new DoubleStatistics(field, count, avg, min, max, std, sum));
	}


}
