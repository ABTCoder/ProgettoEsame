package tasks;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Classe destinata per il parsing dei singoli incarichi presenti nel dataset, utilizzata in {@link tasks.TaskList}
 * @author Amal Benson Thaliath
 *
 */
public class Task {
	
	//JsonProperty permette di serializzare l'oggetto con un nome diverso da quello della variabile stessa
	
	/**
	 * Numero dell'atto
	 */
	@JsonProperty("N. PG Atto")
	private final String n_atto;
	
	/**
	 * Anno dell'atto
	 */
	@JsonProperty("Anno PG Atto")
	private final String anno_atto;
	
	/**
	 * Tipologia dell'incarico
	 */
	@JsonProperty("Tipologia Incarico")
	private final String tipologia;
	
	/**
	 * Compenso in euro dell'atto
	 */
	@JsonProperty("Compenso presunto (Euro)")
	private final double compenso;
	
	/**
	 * Soggetto conferente dell'incarico
	 */
	@JsonProperty("Soggetto conferente")
	private final String soggetto;
	
	/**
	 * Data dell'inizio dell'incarico
	 */
	@JsonProperty("Data inizio incarico")
	private final String inizio;
	
	/**
	 * Data della fine dell'incarico
	 */
	@JsonProperty("Data fine incarico")
	private final String fine;
	
	/**
	 * Durata dell'incarico, se presente nel dataset verrà passato come un intero, altrimenti come una stringa vuota
	 */
	@JsonProperty("Durata incarico (gg)")
	private final Object durata;
	
	/**
	 * Costruttore dell'incarico
	 * @param n_atto numero atto
	 * @param anno_atto anno dell'atto
	 * @param tipologia tipologia dell'incarico
	 * @param compenso compenso in euro
	 * @param soggetto soggetto conferente
	 * @param inizio inizio dell'incarico
	 * @param fine fine dell'incarico
	 * @param durata durata dell'incarico
	 */
	public Task(String n_atto, String anno_atto, String tipologia, double compenso, String soggetto, String inizio, String fine, Object durata)
	{
	
		this.n_atto = n_atto;
		this.anno_atto = anno_atto;
		this.tipologia = tipologia;
		this.compenso = compenso;
		this.soggetto = soggetto;
		this.inizio = inizio;
		this.fine = fine;
		this.durata = durata;
		
	}
	
	/**
	 * Restituisce il numero dell'atto
	 * @return numero atto
	 */
	public String getN_atto() {
		return n_atto;
	}
	/**
	 * Restituisce l'anno dell'atto
	 * @return l'anno dell'atto
	 */
	public String getAnno_atto() {
		return anno_atto;
	}
	/**
	 * Restituisce la tipologia dell'incarico
	 * @return tipologia dell'incarico
	 */
	public String getTipologia() {
		return tipologia;
	}
	/**
	 * Restituisce il compenso dell'atto (in euro)
	 * @return compenso (euro)
	 */
	public double getCompenso() {
		return compenso;
	}
	/**
	 * Restituisce il soggetto conferente dell'incarico
	 * @return soggetto conferente
	 */
	public String getSoggetto() {
		return soggetto;
	}
	/**
	 * Restituisce la data d'inizio incarico
	 * @return data inizio
	 */
	public String getInizio() {
		return inizio;
	}
	/**
	 * Restituisce la data di fine incarico
	 * @return fine incarico
	 */
	public String getFine() {
		return fine;
	}
	/**
	 * Restituisce la durata dell'incarico come un intero, 
	 * se non è presente nel csv invece restituisce una stringa vuota
	 * @return intero pari alla durata o stringa vuota se non presente
	 */
	public Object getDurata() {
		return durata;
	}
	
	@Override
	public String toString() {
		return n_atto+","+anno_atto+","+tipologia+","+compenso+","+soggetto+","
				+inizio+","+fine+","+durata;
	}
	
	
}
