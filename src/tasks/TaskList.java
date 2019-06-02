package tasks;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.json.*;

public class TaskList {

	private List<Task> mList = new ArrayList<Task>();
	private List<String> header;
	
	public TaskList(BufferedReader br) throws IOException {
		//Lettura dell'header del file csv (metadati)
		//Lettura di una linea e suddivisione dei singoli elementi delimitati dalla virgola
		String firstline = br.readLine();
		header = Stream.of(firstline.split(","))
				 .map (elem -> new String(elem))
			     .collect(Collectors.toList());
		
		//Aggiunta degli effettivi elementi presenti nel csv
		String line="";
		while((line=br.readLine())!=null) {
			
			List<String> temp = Stream.of(line.split(","))
								.map (elem -> new String(elem))
								.collect(Collectors.toList());
			
			//Variabili temporanee per inizializzare un oggetto di tipo Task
			int n_atto = Integer.parseInt(temp.get(0));
			int anno = Integer.parseInt(temp.get(1));
			String tip = temp.get(2);
			Double comp = Double.parseDouble(temp.get(3));
			String sogg = temp.get(4);
			String in = temp.get(5);
			String fin = temp.get(6);
			int dur = 0;
			//Visionando il dataset l'unico campo che potrebbe mancare è la durata
			//Quindi lo si assegna a 0 nel caso non fosse presente
			if(temp.size() < 8) dur = 0;
			else dur = Integer.parseInt(temp.get(7));
			
			mList.add(new Task(n_atto, anno, tip, comp, sogg, in, fin, dur)); //Aggiunta dell'incarico
		}
		
	}
	
	//Salva tutti i dati in formato json
	public void saveData() throws IOException {
		JSONArray data = new JSONArray();
		
		for(Task x : mList) {
			JSONObject taskObject = new JSONObject();
			taskObject.put(header.get(0), x.getnPGAtto());
			taskObject.put(header.get(1), x.getnPGAtto());
			taskObject.put(header.get(2), x.getTipologia());
			taskObject.put(header.get(3), x.getCompenso());
			taskObject.put(header.get(4), x.getSoggettoConferente());
			taskObject.put(header.get(5), x.getDataInizio());
			taskObject.put(header.get(6), x.getDataFine());
			if(x.getDurata()!=0) taskObject.put(header.get(7), x.getDurata());
			
			data.put(taskObject);
		}
		
		FileWriter writer = new FileWriter("data.json");
		writer.write(data.toString());
		writer.close();
	}
	
	public void print() {
		for(Task x : mList) {
			System.out.println(x);
		}
	}
	
}
