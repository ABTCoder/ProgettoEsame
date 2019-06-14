package tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import stats.NumberStatCalculator;
import stats.StatCalculator;
import stats.Statistics;
import stats.StringStatCalculator;

public class TaskList {

	static private List<Task> mList = new ArrayList<Task>();
	static private List<Field> metadata = new ArrayList<Field>();
	
	public TaskList(BufferedReader br) throws IOException {
		//Lettura dell'header del file csv
		//Lettura di una linea e suddivisione dei singoli elementi delimitati dalla virgola
		String firstline = br.readLine();
		List<String> header = Stream.of(firstline.split(","))
				 .map (elem -> new String(elem))
			     .collect(Collectors.toList());
		//Creazione metadata
		metadata.add(new Field(header.get(0), "String", "n_atto"));
		metadata.add(new Field(header.get(1), "String", "anno_atto"));
		metadata.add(new Field(header.get(2), "String", "tipologia"));
		metadata.add(new Field(header.get(3), "Double", "compenso"));
		metadata.add(new Field(header.get(4), "String", "soggetto"));
		metadata.add(new Field(header.get(5), "String", "inizio"));
		metadata.add(new Field(header.get(6), "String", "fine"));
		metadata.add(new Field(header.get(7), "Integer", "durata"));
		
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
		
	public void print() {
		for(Task x : mList) {
			System.out.println(x);
		}
	}
	
	static public List<Task> getList(){
		return mList;
	}
	
	static public List<Statistics> calc(String alias){
		StatCalculator cl = null;
		boolean notfound = true;
		
		String type = "";
		
		//Verifica la presenza dell'attributo (passato sotto il suo alias)
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
			return null;
		}
	}
	
	static public List<Field> getMetadata() {
		return metadata;
	}
	
}
