package com.example.j;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

    ListView nameListView;
    Spinner nameSpinner;
    GridView namesGridView;
    String[] names = {"Dhoni","Kholi","Yuvraj","Pandya","Bhumra","Nehra","Rhoit","Dhawan"};
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        nameListView = (ListView) findViewById(R.id.listViewnames);
        nameSpinner = (Spinner) findViewById(R.id.spinnernames);
        namesGridView = (GridView) findViewById(R.id.gridViewnames);
        
        ArrayAdapter<String> adapter = 
        new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1, names);
        nameListView.setAdapter(adapter);
        
        nameListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3)
			{
				Toast.makeText(MainActivity.this,"You selected "+names[position],
						Toast.LENGTH_SHORT).show();
				
				
			}
		});
      
      nameSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int position,
				long arg3) 
		{

			Toast.makeText(MainActivity.this,"You selected "+names[position],Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
	});  
        
        
        
        
        
        
        
        
        
        
        
        
        nameSpinner.setAdapter(adapter);
        namesGridView.setAdapter(adapter);
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

	
	
	
	
	
	
	
	
	
	
	
	

    
}
