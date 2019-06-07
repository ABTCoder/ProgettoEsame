package tasks;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
	private final int durata;
	
	
	
	//private Map<String, Object> fields = new LinkedHashMap<String, Object>();
	
	
	public Task(String n_atto, String anno_atto, String tipologia, double compenso, String soggetto, String inizio, String fine, int durata)
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
	
	/*
	public Task(List<String> header, List<Object> elems) {
		fields.put(header.get(0), elems.get(0));
		fields.put(header.get(1), elems.get(1));
		fields.put(header.get(2), elems.get(2));
		fields.put(header.get(3), elems.get(3));
		fields.put(header.get(4), elems.get(4));
		fields.put(header.get(5), elems.get(5));
		fields.put(header.get(6), elems.get(6));
		if(elems.size() < 8) fields.put(header.get(7), "");
		else fields.put(header.get(7), elems.get(7));
	}*/

	
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

	public int getDurata() {
		return durata;
	}
	
	@Override
	public String toString() {
		return n_atto+","+anno_atto+","+tipologia+","+compenso+","+soggetto+","
				+inizio+","+fine+","+durata;
	}
	
	
	/*
	public Map<String, Object> getFields() {
		return fields;
	}
	
	
	public String toString() {
		return fields.toString();
	}*/
}
