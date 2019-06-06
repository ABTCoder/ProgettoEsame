package ManageTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.MalformedURLException;
import java.nio.charset.Charset;
import java.nio.channels.*;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONTokener;
import org.springframework.boot.SpringApplication;

import tasks.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class manage_tasks {

	public static void downloadFromUrl(String url, String path) throws IOException, MalformedURLException {
		
		//Crea uno stream da cui leggere i contenuti dell'URL
		ReadableByteChannel readChannel = Channels.newChannel(new URL(url).openStream());
		//Crea il file su cui salvare i dati dello stream ed ottiene il channel associato
	    FileOutputStream file = new FileOutputStream(path);  
	    FileChannel writeChannel = file.getChannel(); 
	    //I metodi transferFrom e transferTo sono molto efficienti quando si utilizzano dei buffered stream
	    writeChannel.transferFrom(readChannel, 0, Long.MAX_VALUE);
	    file.close();
	    
		/* TROPPO LENTO
		InputStream is = new URL(url).openStream();
		Files.copy(is, Paths.get(path));
		*/
	}

	public static void main(String[] args) throws MalformedURLException, IOException {
		SpringApplication.run(manage_tasks.class, args);
		System.setProperty("http.agent", "Chrome"); //QUESTA ISTRUZIONE RISOLVE: server returned http response code 403 for url
	    
		String url = "https://www.dati.gov.it/api/3/action/package_show?id=d75a0f5f-729b-4b3c-8c5a-f70e6ff112a2";
		
		boolean ok = false;
		FileInputStream fr = null;
		while(!ok) {
			try {
				fr = new FileInputStream("dataset.csv");
				ok=true;
			}
			catch (FileNotFoundException ex) {
				System.out.println("FILE NON TROVATO! TENTATIVO DI DOWNLOAD DEL DATASET");
				downloadFromUrl(url, "jsonIniziale.json");
				FileInputStream jsonstream = new FileInputStream("jsonIniziale.json");
				InputStreamReader isr = new InputStreamReader(jsonstream, Charset.forName("UTF-8"));
				//Il tokener estrae i tokens da un reader o da un inputstream
				//Bisogna utilizzare un reader in questo caso perch� bisogna specificare che i caratteri utilizzati sono UTF-8
				JSONTokener jt = new JSONTokener(isr);
				JSONObject json = new JSONObject(jt);
				
				//In base alla struttura del json del progetto
				JSONObject result = json.getJSONObject("result");
				JSONArray resources = result.getJSONArray("resources");
				JSONObject dataset = resources.getJSONObject(0); //Scelgo per ora il primo dataset
				downloadFromUrl(dataset.getString("url"), "dataset.csv"); //Scarica il dataset in formato csv dall'url
				System.out.println("DATASET SCARICATO");
			}
		}
		InputStreamReader isr = new InputStreamReader(fr, Charset.forName("UTF-8"));
		BufferedReader br = new BufferedReader(isr);
		
		/*
		String firstline = br.readLine();
	
		List<String> header = Stream.of(firstline.split(","))
	      .map (elem -> new String(elem))
	      .collect(Collectors.toList());
		for(String x : header) System.out.println(x);
		*/
		
		TaskList tasklist = new TaskList(br);
		tasklist.print();
		FileWriter writer = new FileWriter("data.json");
		//tasklist.saveData(writer);
		writer.close();
		fr.close();
		
		
	}

}
