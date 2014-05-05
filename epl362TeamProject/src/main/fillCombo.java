package main;

import javax.swing.JComboBox;

import org.json.JSONException;
import org.json.JSONObject;

public class fillCombo {
	/**
	 * Load clients
	 * @param cmb
	 */
	public static void fillClient(JComboBox<String> cmb){
		httpRequest http = new httpRequest();
		String url = constants.getUrl() + "GetClients/";
		String result = "";
		//String result = "{\"id\": 10,\"pass\": \"1234\",\"type\": \"legal\"}";
		try {
			result = http.sendGet(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			JSONObject obj = new JSONObject(result);
			for (int i = 0; i < obj.length(); i++){
				//needs key to seperate each json record
				JSONObject res = obj.getJSONArray("key").getJSONObject(i);
				cmb.addItem(res.getString("ID") + " " + res.getString("Name") + " " + res.getString("Surname"));
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Load lawyers
	 * @param cmb
	 */
	public static void fillLawyer(JComboBox<String> cmb){
		httpRequest http = new httpRequest();
		String url = constants.getUrl() + "GetLawyers/";
		String result = "";
		//String result = "{\"id\": 10,\"pass\": \"1234\",\"type\": \"legal\"}";
		try {
			result = http.sendGet(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			JSONObject obj = new JSONObject(result);
			for (int i = 0; i < obj.length(); i++){
				//needs key to seperate each json record
				JSONObject res = obj.getJSONArray("key").getJSONObject(i);
				cmb.addItem(res.getString("ID") + " " + res.getString("Name") + " " + res.getString("Surname"));
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Load type
	 * @param cmb
	 */
	public static void fillType(JComboBox<String> cmb){
		httpRequest http = new httpRequest();
		String url = constants.getUrl() + "GetCases/";
		String result = "";
		//String result = "{\"id\": 10,\"pass\": \"1234\",\"type\": \"legal\"}";
		try {
			result = http.sendGet(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			JSONObject obj = new JSONObject(result);
			for (int i = 0; i < obj.length(); i++){
				//needs key to seperate each json record
				JSONObject res = obj.getJSONArray("key").getJSONObject(i);
				cmb.addItem(res.getString("type"));
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Load branches
	 * @param cmb
	 */
	public static void fillBranch(JComboBox<String> cmb){
		//we need branches
		httpRequest http = new httpRequest();
		String url = constants.getUrl() + "GetBranches/";
		String result = "";
		//String result = "{\"id\": 10,\"pass\": \"1234\",\"type\": \"legal\"}";
		try {
			result = http.sendGet(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			JSONObject obj = new JSONObject(result);
			for (int i = 0; i < obj.length(); i++){
				//needs key to seperate each json record
				JSONObject res = obj.getJSONArray("key").getJSONObject(i);
				cmb.addItem(res.getString("branch_id"));
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
