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

public class Student {

	public String verifyPassword(String sid,String pwd){
		String s= "";
		String result="";
		InputStream isr=null;
		//Retrieving data from php
		try{
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost("http://10.0.2.2/edrp/password.php?sid="+sid); 
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
	
			Log.e("log tag","convertin to string error "+ e.toString());
		}
		
		//Parsing JSON data
		
		try{
			
			
			JSONObject job= new JSONObject(result);
			
				s=job.getString("PASSWORD");
				
				if(s.equals(pwd)){
					
					s="loggin";
				}
				else
					s="Wrong Password";
							
		}
		catch(Exception e){
			
			s = "ID doesn't exist!";
		}
		
		
		return s;
	
	}

	
	public String getName(String sid){
		
		String s= "";
		String result="";		
		InputStream isr=null;
		//Retrieving data from php
		try{
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost("http://10.0.2.2/edrp/student.php?sid="+sid); 
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
	
			Log.e("log tag","convertin to sting error "+ e.toString());
		}
		
	// parsing JASON data

		try{		
			
			JSONObject job= new JSONObject(result);
			s=job.getString("FNAME")+" "+job.getString("LNAME");
		}catch(Exception e){
			
			s = "error has occured";
		}
		
		return s;
	}
	
        public ArrayList<String> getStudentInfo(String sid){
		ArrayList<String> al = new ArrayList<String>();
		String result="";
		InputStream isr=null;
		StrictMode.enableDefaults();
		//Retrieving data from php
		try{
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost("http://10.0.2.2/edrp/student.php?sid="+sid); 
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
			al.add(0, job.getString("COLLEGE"));
			al.add(1, job.getString("BRANCH"));
			al.add(2, job.getString("SEM"));
			al.add(3, job.getString("DOB"));
			al.add(4, job.getString("PHONE"));
			al.add(5, job.getString("EMAIL"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
			
					
	
	}
	

}
