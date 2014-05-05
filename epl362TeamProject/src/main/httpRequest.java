package main;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


public class httpRequest  {
	private final String USER_AGENT = "Mozilla/5.0";
	 
	/**
	 * Launch application
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
 
		httpRequest http = new httpRequest();
 
		System.out.println("Testing 1 - Send Http GET request");
		http.sendGet("http://localhost:8080/RESTfulProject/REST/WebService/GetClients");
 
		System.out.println("Testing 2 - Send Http GET request");
		http.sendGet("http://localhost:8080/RESTfulProject/REST/WebService/GetClient");
		
		System.out.println("\nTesting 3 - Send Http POST request");
		http.sendPost("http://localhost:8080/RESTfulProject/REST/WebService/GetClients", "lon=33&peaks=666&UID=kostis&time_to=02&time_from=01&lat=35");
	}
 
	/**
	 *  HTTP GET request
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public String sendGet(String url) throws Exception { 
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
		// optional default is GET
		con.setRequestMethod("GET");
 
		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);
 
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		//print result
		System.out.println(response.toString());
		return response.toString();
 
	}
 
	/**
	 *  HTTP POST request
	 * @param url
	 * @param param
	 * @throws Exception
	 */
	public void sendPost(String url, String param) throws Exception {
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
 
		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
 
		String urlParameters = param;
 
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();
 
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		//print result
		System.out.println(response.toString());
	}
	
	/**
	 * Put request
	 * @param url
	 * @throws Exception
	 */
	public void sendPut(String url) throws Exception{
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		
		con.setRequestMethod("PUT");
		con.setDoOutput(true);
		OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());
		out.write("Resource content");
		out.close();con.getInputStream();
		//require params?
	}
	
	/**
	 * Delete request
	 * @param url
	 * @throws Exception
	 */
	public void sendDelete(String url) throws Exception{
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		
		con.setRequestMethod("DELETE");
		con.setDoOutput(true);
		con.connect();
	}
	
}