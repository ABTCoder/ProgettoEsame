package stats;

import java.util.List;
import java.lang.Math;

import tasks.Task;

public class NumberStatCalculator extends StatCalculator {

	//Double o Integer
	private String type;
	public NumberStatCalculator(String type) {
		this.type = type;
	}
	
	private double sum = 0;
	private double avg;
	private double std;
	private double min;
	private double max;
	private int count;
	
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
			//Se l'attributo non era presente nel dataset esso è salvato come una stringa
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
