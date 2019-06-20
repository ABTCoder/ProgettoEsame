package tasks;

/**
 * Eccezione personalizzata lanciata e gestita nel metodo {@link tasks.TaskList#calc(String)}. 
 * Viene lanciato se la richiesta GET passa un field errato o inesistente
 * @author Amal Benson Thaliath
 *
 */
@SuppressWarnings("serial")
public class FieldNotPresent extends Exception {
	
	FieldNotPresent() {
		super();
	}
	
	FieldNotPresent(String msg){
		super(msg);
	}
}
