package tasks;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Task {
	
	@JsonProperty("N. PG Atto")
	private final String n_atto;
	@JsonProperty("Anno PG Atto")
	private final String anno_atto;
	@JsonProperty("Tipologia Incarico")
	private final String tipologia;
	@JsonProperty("Compenso presunto (Euro)")
	private final double compenso;
	@JsonProperty("Soggetto conferente")
	private final String soggetto;
	@JsonProperty("Data inizio incarico")
	private final String inizio;
	@JsonProperty("Data fine incarico")
	private final String fine;
	@JsonProperty("Durata incarico (gg)")
	private final Object durata;
	
	
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
	
	
	public String getN_atto() {
		return n_atto;
	}

	public String getAnno_atto() {
		return anno_atto;
	}

	public String getTipologia() {
		return tipologia;
	}

	public double getCompenso() {
		return compenso;
	}

	public String getSoggetto() {
		return soggetto;
	}

	public String getInizio() {
		return inizio;
	}

	public String getFine() {
		return fine;
	}

	public Object getDurata() {
		return durata;
	}
	
	@Override
	public String toString() {
		return n_atto+","+anno_atto+","+tipologia+","+compenso+","+soggetto+","
				+inizio+","+fine+","+durata;
	}
	
	
}
