package tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import stats.StringStatCalculator;

public class TaskList {

	static private List<Task> mList = new ArrayList<Task>();
	static private List<String> header;
	static private List<Field> metadata = new ArrayList<Field>();
	
	public TaskList(BufferedReader br) throws IOException {
		//Lettura dell'header del file csv
		//Lettura di una linea e suddivisione dei singoli elementi delimitati dalla virgola
		String firstline = br.readLine();
		header = Stream.of(firstline.split(","))
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
			
			String[] values = line.split(",");
			List<Object> temp = new ArrayList<Object>();
			temp.add(values[0]);
			temp.add(values[1]);
			temp.add(values[2]);
			temp.add(Double.parseDouble(values[3]));
			temp.add(values[4]);
			temp.add(values[5]);
			temp.add(values[6]);
			if (values.length < 8) temp.add("");
			else temp.add(Integer.parseInt(values[7]));
			
			//Variabili temporanee per inizializzare un oggetto di tipo Task
			/*
			int n_atto = Integer.parseInt(temp.get(0));
			int anno = Integer.parseInt(temp.get(1));
			String tip = temp.get(2);
			Double comp = Double.parseDouble(temp.get(3));
			String sogg = temp.get(4);
			String in = temp.get(5);
			String fin = temp.get(6); 
			
			int dur = 0;
			//Visionando il dataset l'unico campo che potrebbe mancare � la durata
			//Quindi lo si assegna a 0 nel caso non fosse presente
			if(temp.size() < 8) dur = 0;
			//else dur = Integer.parseInt(temp.get(7));*/
			
			//mList.add(new Task(n_atto, anno, tip, comp, sogg, in, fin, dur)); //Aggiunta dell'incarico
			mList.add(new Task(header, temp));
		}
		
	}
	
	//Salva tutti i dati in formato json
	/*
	public void saveData(FileWriter writer) throws IOException {
		

		JSONWriter json = new JSONWriter(writer);
		
		json.array();
		
		for(Task x : mList) {
			
			json.object();
			json.key(header.get(0)).value(x.getnPGAtto());
			json.key(header.get(1)).value(x.getnPGAnno());
			json.key(header.get(2)).value(x.getTipologia());
			json.key(header.get(3)).value(x.getCompenso());
			json.key(header.get(4)).value(x.getSoggettoConferente());
			json.key(header.get(5)).value(x.getDataInizio());
			json.key(header.get(6)).value(x.getDataFine());
			if(x.getDurata()!=0) json.key(header.get(7)).value(x.getDurata());
			json.endObject();
			
		}
		json.endArray();
	}
	*/
	
	public void print() {
		for(Task x : mList) {
			System.out.println(x);
		}
	}
	
	static public List<Task> getList(){
		return mList;
	}
	
	static public Map<String,Integer> calc(String field){
		StringStatCalculator cl = new StringStatCalculator();
		cl.calc(getList(), field);
		return cl.getResult();
	}
	
	static public List<Field> getMetadata() {
		return metadata;
	}
	
}
