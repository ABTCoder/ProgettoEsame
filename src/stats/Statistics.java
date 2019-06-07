package stats;

public class Statistics {
	protected String field;
	protected int count;
	
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
