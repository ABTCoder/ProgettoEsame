package ManageTasks;

public class Task {
	
	private final int nPGAtto;
	private final int nPGAnno;
	private final String tipologia;
	private final double compenso;
	private final String soggettoConferente;
	private final String dataInizio;
	private final String dataFine;
	private final int durata;
	
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
}
