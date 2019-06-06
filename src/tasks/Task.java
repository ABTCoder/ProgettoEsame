package tasks;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Task {
	
	/*
	private final int nPGAtto;
	private final int nPGAnno;
	private final String tipologia;
	private final double compenso;
	private final String soggettoConferente;
	private final String dataInizio;
	private final String dataFine;
	private final int durata;
	*/
	
	private Map<String, Object> fields = new LinkedHashMap<String, Object>();
	
	/*
	public Task(int nPGAtto, int nPGAnno, String tipologia, double compenso, String soggettoConferente, String dataInizio, String dataFine, int durata)
	{
	
		this.nPGAtto = nPGAtto;
		this.nPGAnno = nPGAnno;
		this.tipologia = tipologia;
		this.compenso = compenso;
		this.soggettoConferente = soggettoConferente;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.durata = durata;
		
	}
	*/
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
	}

	/*
	public int getnPGAtto() {
		return nPGAtto;
	}

	public int getnPGAnno() {
		return nPGAnno;
	}

	public String getTipologia() {
		return tipologia;
	}

	public double getCompenso() {
		return compenso;
	}

	public String getSoggettoConferente() {
		return soggettoConferente;
	}

	public String getDataInizio() {
		return dataInizio;
	}

	public String getDataFine() {
		return dataFine;
	}

	public int getDurata() {
		return durata;
	}
	
	@Override
	public String toString() {
		return nPGAtto+","+nPGAnno+","+tipologia+","+compenso+","+soggettoConferente+","
				+dataInizio+","+dataFine+","+durata;
	}
	*/
	
	
	public Map<String, Object> getFields() {
		return fields;
	}
	
	public String toString() {
		return fields.toString();
	}
}
