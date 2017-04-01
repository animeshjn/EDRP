package dataretrival;

import beans.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import android.net.Uri;
import android.util.Log;

public class Books {
	
	ArrayList<BookData> arList;
	
	public ArrayList<String> book(String criteria){
		ArrayList<String> arry = new ArrayList<String>();
		String result="";
		InputStream isr=null;
		//Retrieving data from php
		try{
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost("http://10.0.2.2/edrp/"+criteria+".php"); 
			HttpResponse httpres= httpclient.execute(httppost);
			HttpEntity entity = httpres.getEntity();
			isr=entity.getContent();
			
		}
		catch(Exception e){
	
			Log.e("log tag","connection kjmerror "+ e.toString());
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
	
			Log.e("log tag","convertin to sting error "+ e.toString());
		}
		
		//Parsing JSON data
		
		try{
			
			JSONArray jr = new JSONArray(result);
			JSONObject job;
			
			for(int i=0;i<jr.length();i++){
			
			job = jr.getJSONObject(i);
			
				arry.add(job.getString(criteria.toUpperCase()));
				
			}
							
		}
		catch(Exception e){
			arry.add("ujjawal");
			e.printStackTrace();
		}
	
		return arry;
	}

	
// get book by author
	
	public ArrayList<BookData> authBook(String auth){
		ArrayList<BookData> arry = new ArrayList<BookData>();
		String result="";
		InputStream isr=null;
		//Retrieving data from php
		try{
			HttpClient httpclient = new DefaultHttpClient();
			auth=Uri.encode(auth);
			HttpPost httppost = new HttpPost("http://10.0.2.2/EDRP/authorbook.php?auth="+auth); 
			HttpResponse httpres= httpclient.execute(httppost);
			HttpEntity entity = httpres.getEntity();
			isr=entity.getContent();
			
		}
		catch(Exception e){
	
			Log.e("log tag","connection kjmerror "+ e.toString());
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
	
			Log.e("log tag","convertin to sting error "+ e.toString());
		}
		
		//Parsing JSON data
		
		try{
			
			JSONArray jr = new JSONArray(result);
			JSONObject job;
			
			for(int i=0;i<jr.length();i++){
			
			job = jr.getJSONObject(i);
			
			char ch = job.getString("STATUS").charAt(0);
			
				arry.add(new BookData((job.getString("AUTHOR")),(job.getString("PUBLISHER")),(job.getString("EDITION")),(job.getString("TITLE")),ch,(job.getInt("ACCNO"))));
			}			
		}
		catch(Exception e){
			arry.add(null);
			e.printStackTrace();
		}
		
		return arry;
	}

	public ArrayList<BookData> publisherBook(String publisher){
		ArrayList<BookData> arry = new ArrayList<BookData>();
		String result="";
		InputStream isr=null;
		//Retrieving data from php
		try{
			HttpClient httpclient = new DefaultHttpClient();
			publisher=Uri.encode(publisher);
			HttpPost httppost = new HttpPost("http://10.0.2.2/EDRP/publisherbook.php?publish="+publisher); 
			HttpResponse httpres= httpclient.execute(httppost);
			HttpEntity entity = httpres.getEntity();
			isr=entity.getContent();
			
		}
		catch(Exception e){
	
			Log.e("log tag","connection kjmerror "+ e.toString());
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
	
			Log.e("log tag","convertin to sting error "+ e.toString());
		}
		
		//Parsing JSON data
		
		try{
			
			JSONArray jr = new JSONArray(result);
			JSONObject job;
			
			for(int i=0;i<jr.length();i++){
			
			job = jr.getJSONObject(i);
			
			char ch = job.getString("STATUS").charAt(0);
			
				arry.add(new BookData((job.getString("AUTHOR")),(job.getString("PUBLISHER")),(job.getString("EDITION")),(job.getString("TITLE")),ch,(job.getInt("ACCNO"))));
			}			
		}
		catch(Exception e){
			arry.add(null);
			e.printStackTrace();
		}
		
		return arry;
	}

	public ArrayList<BookData> titleBook(String title){
		ArrayList<BookData> arry = new ArrayList<BookData>();
		String result="";
		InputStream isr=null;
		//Retrieving data from php
		try{
			HttpClient httpclient = new DefaultHttpClient();
			title=Uri.encode(title);
			HttpPost httppost = new HttpPost("http://10.0.2.2/EDRP/titlebook.php?title="+title); 
			HttpResponse httpres= httpclient.execute(httppost);
			HttpEntity entity = httpres.getEntity();
			isr=entity.getContent();
			
		}
		catch(Exception e){
	
			Log.e("log tag","connection kjmerror "+ e.toString());
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
	
			Log.e("log tag","convertin to sting error "+ e.toString());
		}
		
		//Parsing JSON data
		
		try{
			
			JSONArray jr = new JSONArray(result);
			JSONObject job;
			
			for(int i=0;i<jr.length();i++){
			
			job = jr.getJSONObject(i);
			
			char ch = job.getString("STATUS").charAt(0);
			
				arry.add(new BookData((job.getString("AUTHOR")),(job.getString("PUBLISHER")),(job.getString("EDITION")),(job.getString("TITLE")),ch,(job.getInt("ACCNO"))));
			}			
		}
		catch(Exception e){
			arry.add(null);
			e.printStackTrace();
		}
		
		return arry;
	}

	
	
}
