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
import org.json.JSONArray;
import org.json.JSONObject;

import beans.NoticePojo;

import android.util.Log;

public class NoticeTask {

	ArrayList<NoticePojo> np;
	
	public ArrayList<NoticePojo> getNotice(String sid){
		np = new ArrayList<NoticePojo>();
		String result="";
		InputStream isr=null;
		
		//Retrieving data from php
		try{
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost("http://10.0.2.2/edrp/studnotice.php?sid="+sid); 
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
			
				np.add(new NoticePojo(job.getString("NOTICE_DATE"),job.getString("SUBJECT"),job.getString("CONTENT"),job.getString("SENDER"),job.getString("READ"),job.getInt("NITICE_ID")));
				
			}
							
		}
		catch(Exception e){
			np.add(null);
			e.printStackTrace();
		}
		
		return np;
	}

	public void setReadYes(String sid,int noticeID){
		
		try{
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost("http://10.0.2.2/edrp/setRead.php?sid="+sid+"&nid="+noticeID); 
			HttpResponse httpres= httpclient.execute(httppost);
			HttpEntity entity = httpres.getEntity();
		} catch(Exception e){
			
			 System.out.println("some server problem");
		}
		
	}
	
	
}
