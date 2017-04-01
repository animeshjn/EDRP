package dataretrival;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import android.util.Log;

/**
 * Accounts Data Fetching file 
 * */
public class Accounts_data {
	
	public static final String hostIp="10.0.2.2";
	
	public String getAcnts(String sid){
		//JSONObject job = null;
		String result="";		
		InputStream isr=null;
		//Retrieving data from php
		try{
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost("http://"+hostIp+"/edrp/accounts.php?sid="+sid); 
			HttpResponse httpres= httpclient.execute(httppost);
			HttpEntity entity = httpres.getEntity();
			isr=entity.getContent();
			
		}
		catch(Exception e){
	
			Log.e("log tag","connection error "+ e.toString());
		}
		//converting data to string
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(isr,"iso-8859-1"),8);
			StringBuilder sb=new StringBuilder();
			String line = null;
			while((line = br.readLine())!=null){
			//append 
				sb.append(line + "\n");
			}
			isr.close();
			
			result=sb.toString();
			
		}
		catch(Exception e){
	
			Log.e("log tag","converting to string error "+ e.toString());
		}
		return result;
	}
	
}