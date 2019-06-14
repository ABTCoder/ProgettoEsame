package tasks;

public class FieldNotPresent extends Exception {
	
	FieldNotPresent() {
		super();
	}
	
	FieldNotPresent(String msg){
		super(msg);
	}
}
