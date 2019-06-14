package tasks;

@SuppressWarnings("serial")
public class FieldNotPresent extends Exception {
	
	FieldNotPresent() {
		super();
	}
	
	FieldNotPresent(String msg){
		super(msg);
	}
}
