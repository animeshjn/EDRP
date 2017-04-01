package dataretrival;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.StrictMode;
import android.util.Log;

public class CT_data {

	public ArrayList<String> getSubName (String branch,int sem ){
		ArrayList<String> subname = new ArrayList<String>();
		String result="";
		InputStream isr=null;
		StrictMode.enableDefaults();
		//Retrieving data from php
		try{
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost("http://10.0.2.2/edrp/subname.php?branch="+branch+"&sem="+sem); 
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
				sb.append(line + "\n");
			}
			isr.close();
			
			result=sb.toString();
			
		}
		catch(Exception e){
	
			Log.e("log tag","converting to string error "+ e.toString());
		}
		;
		
		//Parsing JSON data
		JSONObject job;
		try {
			job = new JSONObject(result);
			subname.add(0, job.getString("SUB1"));
			subname.add(1, job.getString("SUB2"));
			subname.add(2, job.getString("SUB3"));
			subname.add(3, job.getString("SUB4"));
			subname.add(4, job.getString("SUB5"));
			subname.add(5, job.getString("SUB6"));
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return subname;
			
					
	
	}

	public ArrayList<String> getSubMarks(String sid,int sem ,int ctnum){
		
		ArrayList<String> submarks = new ArrayList<String>();
		String result="";
		InputStream isr=null;
		StrictMode.enableDefaults();
		//Retrieving data from php
		try{
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost("http://10.0.2.2/edrp/submarks.php?sid="+sid+"&sem="+sem+"&ctnum="+ctnum); 
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
				sb.append(line + "\n");
			}
			isr.close();
			
			result=sb.toString();
			
		}catch(Exception e){
	
			Log.e("log tag","converting to string error "+ e.toString());
		}
		
		//Parsing JSON data
		JSONObject job;
		try {
			job = new JSONObject(result);
			submarks.add(0, job.getString("SUB1"));
			submarks.add(1, job.getString("SUB2"));
			submarks.add(2, job.getString("SUB3"));
			submarks.add(3, job.getString("SUB4"));
			submarks.add(4, job.getString("SUB5"));
			submarks.add(5, job.getString("SUB6"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return submarks;	
	}
	
}
