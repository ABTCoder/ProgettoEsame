package tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import stats.NumberStatCalculator;
import stats.StatCalculator;
import stats.Statistics;
import stats.StringStatCalculator;

/**
 * Classe service che effettua il parsing del dataset ed esegue le richieste passate al REST Controller.
 * <p>I due unici attributi sono statici in modo da poter essere richiamati dal controller pur essendo stati inizializzati nel main</p>
 * @author Amal Benson Thaliath
 *
 */
public class TaskList {

	/**
	 * Lista contenente tutti i dati, caricati in oggetti {@link tasks.Task}
	 */
	static private List<Task> mList = new ArrayList<Task>();
	/**
	 * Lista contenente tutti i metadati, caricati in oggetti {@link tasks.Field}
	 */
	static private List<Field> metadata = new ArrayList<Field>();
	
	/**
	 * Costruttore di TaskList, effettua il parsing del csv e carica i metadati e gli incarichi nelle rispettive liste
	 * @param br il BufferedReader da cui legge il csv
	 * @throws IOException se avvengono errori di lettura del file
	 */
	public TaskList(BufferedReader br) throws IOException {
		//Lettura dell'header del file csv
		//Lettura di una linea e suddivisione dei singoli elementi delimitati dalla virgola
		String firstline = br.readLine();
		String[] header = firstline.split(",");
		//Creazione della lista dei metadati
		metadata.add(new Field(header[0], "String", "n_atto"));
		metadata.add(new Field(header[1], "String", "anno_atto"));
		metadata.add(new Field(header[2], "String", "tipologia"));
		metadata.add(new Field(header[3], "Double", "compenso"));
		metadata.add(new Field(header[4], "String", "soggetto"));
		metadata.add(new Field(header[5], "String", "inizio"));
		metadata.add(new Field(header[6], "String", "fine"));
		metadata.add(new Field(header[7], "Integer", "durata"));
		
		//Aggiunta degli effettivi elementi presenti nel csv
		String line="";
		while((line=br.readLine())!=null) {
			
			String[] values = line.split(","); //Suddivido la linea letta con il delimitatore ","
			
			//Variabili temporanee per inizializzare un oggetto di tipo Task
			
			String n_atto = "";
			String anno = "";
			String tip = "";
			double comp = 0;
			String sogg = "";
			String in = "";
			String fin = "";
			Object dur = null;
			
			try {
				n_atto = values[0];
				anno = values[1];
				tip = values[2];
				comp = Double.parseDouble(values[3]);
				sogg = values[4];
				in = values[5];
				fin = values[6]; 
			
				//Visionando il dataset l'unico campo che potrebbe causare errori se mancante e' la durata
				//Quindi lo si passa come una stringa vuota nel caso non fosse presente
				if(values.length < 8) dur = "";
				else dur = Integer.parseInt(values[7]);
			} catch(Exception e) {
				continue;
			}
			
			mList.add(new Task(n_atto, anno, tip, comp, sogg, in, fin, dur)); //Aggiunta dell'incarico

		}
		
	}
	
	/**
	 * Stampa su console tutti gli incarichi
	 */
	public void print() {
		for(Task x : mList) {
			System.out.println(x);
		}
	}
	
	/**
	 * Service destinato alla restituzione di tutti gli incarichi sottoforma di lista
	 * @return lista contenente gli incarichi
	 */
	static public List<Task> getList(){
		return mList;
	}
	
	/**
	 * Service destinato al calcolo delle statistiche
	 * <p>Calcola le statistiche sul campo (colonna dei dati) passato sotto il suo alias</p>
	 * <p>Se l'alias è presente ottiene il tipo di dato associato dalla lista di metadati, 
	 * successivamente crea uno {@link stats.StatCalculator} , se il dato è una string lo inizializza come
	 * {@link stats.StringStatCalculator}, se è un numero come {@link stats.NumberStatCalculator} </p>
	 * @param alias alias del campo
	 * @return lista contenente le statistiche o la statistica del campo (sia per stringhe che per numeri)
	 */
	static public List<Statistics> calc(String alias){
		StatCalculator cl = null;
		boolean notfound = true;
		
		String type = "";
		
		//Verifica la presenza dell'attributo (passato come il suo alias)
		for(Field f: metadata) {
			if(f.getAlias().equals(alias)) {
				type = f.getType(); //Tipo di dato
				notfound = false;
				break;
			}
		}
		
		try {
			if(notfound) throw new FieldNotPresent("Il campo richiesto non esiste o è errato!");
			
			if(type.equals("String")) cl = new StringStatCalculator();
			else if(type.equals("Double")) cl = new NumberStatCalculator("Double");
			else if(type.equals("Integer")) cl = new NumberStatCalculator("Integer");
			cl.calc(mList, alias);
			return cl.getResults();
		}
		catch (FieldNotPresent e) {
			e.printStackTrace();
			return null; //Nel caso il campo non sia presente la richiesta GET restituirà un oggetto vuoto
		}
	}
	
	/**
	 * Service della restituzione dei metadati
	 * @return lista contenente i metadati salvati nella classe {@link tasks.Field}
	 */
	static public List<Field> getMetadata() {
		return metadata;
	}
	
}
