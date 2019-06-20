package tasks;

/**
 * Classe utilizzata per salvare i singoli metadati
 * @author Amal Benson Thaliath
 *
 */
public class Field {
	/**
	 * Nome effettivo del campo
	 */
	private String field;
	
	/**
	 * Tipologia dei dati del campi
	 */
	private String type;
	
	/**
	 * alias utilizzato per la richiesta REST GET
	 */
	private String alias;
	
	/**
	 * Costruttore della classe Field
	 * @param field nome del campo
	 * @param type tipologia di dati del campo
	 * @param alias alias del campo
	 */
	public Field(String field, String type, String alias) {
		this.field = field;
		this.type = type;
		this.alias = alias;
	}
	
	/**
	 * Restituisce il nome completo del campo, estratto dall'header del csv
	 * @return nome completo del campo
	 */
	public String getField() {
		return field;
	}
	
	/**
	 * Restituisce il tipo di dato associato al campo
	 * @return tipo di dato
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Restituisce l'alias utilizzato per le richieste GET
	 * @return alias
	 */
	public String getAlias() {
		return alias;
	}
}
