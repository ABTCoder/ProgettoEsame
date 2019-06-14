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
		//Inizializzo il minimo e il massimo con il campo del primo elemento della lista
		double init = (Double) invokeMethod(elems.get(0), field);
		max = min = init;
		
		for(Task x : elems) {
			double num = (Double) invokeMethod(x, field);
			sum+= num; //Somma
			count++; //Conteggio
			min = (num < min) ? num:min;
			max = (num > max) ? num:max;
			
		}
		avg = sum / count; //Media
		
		//Secondo ciclo per il calcolo della deviazione standard
		double partial = 0; //Somma necessaria per la formula
		for(Task x : elems) {
			double num = (Double) invokeMethod(x, field);
			partial+= num - avg;
		}
		
		std =  Math.sqrt(partial / count);
		
		//Aggiunta di un oggetto alla lista dei risulati DoubleStatistics o IntegerStatistics che ereditano da Statistics
		if(type.equals("Integer")) result.add(new IntegerStatistics(field, count, avg, min, max, std, sum));
		else result.add(new DoubleStatistics(field, count, avg, min, max, std, sum));
	}


}
