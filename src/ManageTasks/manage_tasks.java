package ManageTasks;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;


import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

public class manage_tasks {

	private static String readAll(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	  }

	  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
	    InputStream is = new URL(url).openStream();
	    try {
	        BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	        String jsonText = readAll(rd);
	        JSONObject json = new JSONObject(jsonText);
	        return json;
	    } finally {
	        is.close();
	    }
	  }

	  public static void main(String[] args) throws IOException, JSONException {
		  System.setProperty("http.agent", "Chrome"); //QUESTA ISTRUZIONE RISOLVE: server returned http response code 403 for url
	      JSONObject json = readJsonFromUrl("https://www.dati.gov.it/api/3/action/package_show?id=d75a0f5f-729b-4b3c-8c5a-f70e6ff112a2");
	      JSONObject result = json.getJSONObject("result");
	      JSONArray resources = result.getJSONArray("resources");
	      System.out.println(resources.toString());
	      //System.out.println(resources.get("));

	  }

}
