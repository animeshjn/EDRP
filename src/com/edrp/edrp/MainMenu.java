package com.edrp.edrp;
import dataretrival.Student;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class MainMenu extends Activity {

	TextView tv;
	GridView gd;
	Intent it;
	Student s;
	SharedPreferences pref;
	static int count=0;
	String sid;
	
	public String [] str = {"My info","Attendance","Search library books","News/Notice",
							"CT marks","Accounts","Library Transaction"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		pref = getSharedPreferences("edrp",0);
		
		if(pref.contains("uid"))
		{
			sid = pref.getString("uid",null);
		}
		else{
			
			Toast.makeText(this, "Logged Out!", Toast.LENGTH_LONG).show();
			it = new Intent(getApplicationContext(),Login.class);
			it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
			it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(it);
		}		
		s = new Student();
		
		tv = (TextView)findViewById(R.id.txtv);
		tv.setText("Welcome: "+s.getName(sid));
		gd = (GridView)findViewById(R.id.gdv);
		
		gd.setAdapter(new ImageAdapter(this,str));
		
		gd.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position,
					long id) {
				
				switch(position){
				
				case 0:
				{
					 Intent i = new Intent(getApplicationContext(), MyInfo.class);            
		                startActivity(i); 
				}
					break;
				
				case 1:
					
					Intent ati = new Intent(getApplicationContext(), AttendanceActivity.class);
					startActivity(ati);
					break;
					
				case 2:
					
					Intent bookIt = new Intent(getApplicationContext(), BookSearch.class);
					startActivity(bookIt);
					break;
				
				case 3:
					
					Intent noticeIt = new Intent(getApplicationContext(), Notice.class);
					startActivity(noticeIt);
					break;
				
				case 4:
	
					Intent ctMain = new Intent(getApplicationContext(), CT_Main.class);
					startActivity(ctMain);
					break;
				
				case 5:
					
					Intent nit = new Intent(getApplicationContext(), Accounts_main.class);
					startActivity(nit);
					break;
				
				case 6:
					Intent lit = new Intent(getApplicationContext(), Book_fine_Main.class);
					startActivity(lit);
					break;
				
				}
				
			}
			
		});
		
	}

	public void onBackPressed(){
		
		if(count==0){
			
			Toast.makeText(this, "Press Again to Log Out!", Toast.LENGTH_SHORT).show();
			count++;
		}
		else{
		
			pref = getSharedPreferences("edrp", 0);
		Editor edit = pref.edit();
		edit.clear();
		edit.commit();
		Toast.makeText(this, "Logged Out!", Toast.LENGTH_LONG).show();
		
		it = new Intent(getApplicationContext(),Login.class);
		it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
		it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(it);
		finish();
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}

}
