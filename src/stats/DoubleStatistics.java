package stats;

public class DoubleStatistics extends Statistics{
	
	private double avg;
	private double min;
	private double max;
	private double std;
	private double sum;
	
	public DoubleStatistics(String field, int count, double avg, double min, double max, double std, double sum) {
		super(field, count);
		this.avg = avg;
		this.min = min;
		this.max = max;
		this.std = std;
		this.sum = sum;
	}
	
	public double getAvg() {
		return avg;
	}
	public double getMin() {
		return min;
	}
	public double getMax() {
		return max;
	}
	public double getStd() {
		return std;
	}
	public double getSum() {
		return sum;
	}
}
