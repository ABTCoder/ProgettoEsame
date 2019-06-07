package stats;

public class IntegerStatistics extends Statistics {
	public IntegerStatistics(String field, int count, int avg, int min, int max, int std, int sum) {
		super(field, count);
		this.avg = avg;
		this.min = min;
		this.max = max;
		this.std = std;
		this.sum = sum;
	}
	private int avg;
	private int min;
	private int max;
	private int std;
	private int sum;
	
	public int getAvg() {
		return avg;
	}
	public int getMin() {
		return min;
	}
	public int getMax() {
		return max;
	}
}
