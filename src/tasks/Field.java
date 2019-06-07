package tasks;

public class Field {
	private String field;
	private String type;
	private String alias;
	
	public Field(String field, String type, String alias) {
		this.field = field;
		this.type = type;
		this.alias = alias;
	}
	
	public String getField() {
		return field;
	}
	
	public String getType() {
		return type;
	}
	
	public String getAlias() {
		return alias;
	}
}
