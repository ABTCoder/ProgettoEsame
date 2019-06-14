package stats;

public class IntegerStatistics extends Statistics {
	
	private int avg;
	private int min;
	private int max;
	private int std;
	private int sum;
	
	public IntegerStatistics(String field, int count, double avg, double min, double max, double std, double sum) {
		super(field, count);
		this.avg = (int)avg;
		this.min = (int)min;
		this.max = (int)max;
		this.std = (int)std;
		this.sum = (int)sum;
	}
	
	public int getAvg() {
		return avg;
	}
	public int getMin() {
		return min;
	}
	public int getMax() {
		return max;
	}
	public int getStd() {
		return std;
	}
	public int getSum() {
		return sum;
	}
	
}
