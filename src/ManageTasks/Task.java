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
}
