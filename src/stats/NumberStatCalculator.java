package stats;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

import tasks.Task;

public class NumberStatCalculator extends StatCalculator {


	private double sum = 0;
	private double avg;
	private double std;
	private double min;
	private double max;
	private int count;
	
	@Override
	public void calc(List<Task> elems, String field) {
		double init = (Double) invokeMethod(elems.get(0), field);
		//Inizializzo il minimo e il massimo con il campo del primo elemento della lista
		max = min = init;
		for(Task x : elems) {
			double num = (Double) invokeMethod(x, field);
			sum+= num;
			count++;
			avg = sum / count;
			min = (num < min) ? num:min;
			max = (num > max) ? num:max;
			
		}
		
		//Secondo ciclo per il calcolo della deviazione standard
		double partial = 0;
		for(Task x : elems) {
			double num = (Double) invokeMethod(x, field);
			partial+= num - avg;
		}
		
		std =  Math.sqrt(partial / count);
		
		result.add(new DoubleStatistics(field, count, avg, min, max, std, sum));
	}

	@Override
	public List<Statistics> getResults() {
		return result;
	}

}
