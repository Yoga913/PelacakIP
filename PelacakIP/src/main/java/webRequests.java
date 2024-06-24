import java.net.*;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.awt.desktop.*;

public class webRequests {
	
	
	// GLOBALS
	String ip;
    String url;
	ipObject ipobj;
	

	//GETTERS AND SETTERS
	public String getIp() {
		return ip;
	}

	public void setIp(String tip) {
		ip = tip;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ipObject getIpobj() {
		return ipobj;
	}

	public void setIpobj(ipObject ipobj) {
		this.ipobj = ipobj;
	}

	
	//Set the URI for the rest API
	public URI setURI(String ip) {
		
		URI uri = URI.create("https://ipapi.co/"+ip+"/json/");
		
		return uri;
	}
	
	
	//Sends the actual web requests, returns a string of the JSON file.
	public String requestJson(URI uri) throws IOException, InterruptedException {
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest ipRequest = HttpRequest.newBuilder()
				.GET()
				.uri(uri)
				//.header(null, null)
				.build();
		
		HttpResponse<String> response = client.send(ipRequest, BodyHandlers.ofString());
		return response.body();
	
	}
	
	
	//@JsonIgnoreProperties(ignoreUnknown = true)
	//Maps the JSON response to an POJO (ipObject class)
	public void MapObjects(String jsonFile) throws JsonMappingException, JsonProcessingException {
		
				ObjectMapper mapper = new ObjectMapper();
				
				JsonNode node = mapper.readTree(jsonFile);
		
				ipobj = mapper.treeToValue(node, ipObject.class);
		
	}
	
	
	//The constructor that creates all of the required.
	public webRequests(String ip) throws IOException, InterruptedException {
		
	setIp(ip);
	URI uriNeeded =setURI(ip);
	String jsonFile = requestJson(uriNeeded);
	MapObjects(jsonFile);
		
	}
	
	//THe actual object after its been initialized with the mapped response JSON file.
	public ipObject CreateObject() {
		
		return ipobj;
	}
	
}
/* 
 * Berikut ini adalah penjelasan dari setiap kode dan alur pada kode program yang diberikan, berupa komentar:

```java
import java.net.*;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.awt.desktop.*;

public class webRequests {

    // Variabel global untuk menyimpan data IP dan URL
	String ip;
    String url;
	ipObject ipobj;

	// Getter dan Setter untuk variabel global IP
	public String getIp() {
		return ip;
	}

	public void setIp(String tip) {
		ip = tip;
	}

	// Getter dan Setter untuk variabel global URL
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	// Getter dan Setter untuk variabel global ipObject
	public ipObject getIpobj() {
		return ipobj;
	}

	public void setIpobj(ipObject ipobj) {
		this.ipobj = ipobj;
	}

	// Metode untuk mengatur URI untuk REST API berdasarkan IP yang diberikan
	public URI setURI(String ip) {
		// Membuat URI menggunakan template URL dengan IP yang diberikan
		URI uri = URI.create("https://ipapi.co/"+ip+"/json/");
		return uri;
	}

	// Metode untuk mengirimkan permintaan web dan mengembalikan respons JSON sebagai string
	public String requestJson(URI uri) throws IOException, InterruptedException {
		// Membuat HttpClient baru
		HttpClient client = HttpClient.newHttpClient();
		// Membuat HttpRequest dengan metode GET dan URI yang diberikan
		HttpRequest ipRequest = HttpRequest.newBuilder()
				.GET()
				.uri(uri)
				//.header(null, null) // Baris ini dikomentari dan tidak digunakan
				.build();
		
		// Mengirimkan permintaan dan mendapatkan respons
		HttpResponse<String> response = client.send(ipRequest, BodyHandlers.ofString());
		// Mengembalikan isi respons sebagai string
		return response.body();
	}

	// Metode untuk memetakan respons JSON ke objek POJO (ipObject)
	public void MapObjects(String jsonFile) throws JsonMappingException, JsonProcessingException {
		// Membuat ObjectMapper baru
		ObjectMapper mapper = new ObjectMapper();
		// Membaca JSON dan mengubahnya menjadi JsonNode
		JsonNode node = mapper.readTree(jsonFile);
		// Mengubah JsonNode menjadi objek ipObject
		ipobj = mapper.treeToValue(node, ipObject.class);
	}

	// Konstruktor untuk membuat objek webRequests dengan IP yang diberikan
	public webRequests(String ip) throws IOException, InterruptedException {
		// Mengatur IP yang diberikan ke variabel global
		setIp(ip);
		// Membuat URI berdasarkan IP yang diberikan
		URI uriNeeded = setURI(ip);
		// Mengirimkan permintaan dan mendapatkan file JSON
		String jsonFile = requestJson(uriNeeded);
		// Memetakan JSON ke objek ipObject
		MapObjects(jsonFile);
	}

	// Metode untuk membuat dan mengembalikan objek ipObject setelah diinisialisasi
	public ipObject CreateObject() {
		return ipobj;
	}
}
```

Penjelasan:
1. **Import Statements**: Bagian ini mengimpor berbagai paket yang diperlukan untuk menangani jaringan, HTTP, JSON, dan input/output.
2. **Class Declaration (`webRequests`)**: Mendefinisikan kelas `webRequests` yang akan menangani permintaan web dan pemrosesan respons JSON.
3. **Global Variables**: Mendeklarasikan variabel global `ip`, `url`, dan `ipobj`.
4. **Getters and Setters**: Menyediakan metode untuk mengakses dan memodifikasi variabel global.
5. **`setURI` Method**: Membuat URI untuk API berdasarkan IP yang diberikan.
6. **`requestJson` Method**: Mengirimkan permintaan HTTP GET ke URI yang diberikan dan mengembalikan respons JSON sebagai string.
7. **`MapObjects` Method**: Memetakan JSON yang diterima ke objek `ipObject` menggunakan `ObjectMapper` dari Jackson.
8. **Constructor (`webRequests`)**: Konstruktor untuk kelas `webRequests` yang menginisialisasi objek dengan IP yang diberikan, membuat URI, mengirimkan permintaan, dan memetakan respons JSON.
9. **`CreateObject` Method**: Mengembalikan objek `ipObject` yang telah diinisialisasi.

Alur program dimulai dengan pembuatan objek `webRequests` menggunakan IP tertentu, kemudian mengatur URI, mengirimkan permintaan web, menerima dan memetakan respons JSON, hingga mengembalikan objek `ipObject` yang sesuai.
 */