package com.example.checkbox;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity implements OnCheckedChangeListener,android.widget.RadioGroup.OnCheckedChangeListener {

    CheckBox option1CheckBox,option2CheckBox;
    RadioGroup radiogroup1;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        option1CheckBox = (CheckBox) findViewById(R.id.checkBoxchoice1);
        option2CheckBox = (CheckBox) findViewById(R.id.checkBoxchoice2);
        radiogroup1 = (RadioGroup) findViewById(R.id.radioGroup1);
        
        option1CheckBox.setOnCheckedChangeListener(MainActivity.this);
        option2CheckBox.setOnCheckedChangeListener(MainActivity.this);
        
        radiogroup1.setOnCheckedChangeListener(MainActivity.this);
    }
	
	@Override
	public void onCheckedChanged(CompoundButton cb, boolean state)
	{
		Log.d("DEBUG","inside onCheckedChanged");
		if(cb.getId()==R.id.checkBoxchoice1)
		{
		    if(state==true)
		    {
				Log.d("DEBUG","option1 was selected");
				Toast.makeText(MainActivity.this,"option1 was selected",Toast.LENGTH_SHORT).show();
		    }
		
		}
		
		else if(cb.getId()==R.id.checkBoxchoice2)
		{
			 if(state==true)
			    {
					Log.d("DEBUG","option2 was selected");
					Toast.makeText(MainActivity.this,"option2 was selected",Toast.LENGTH_SHORT).show();

			    }

		}
			
	}

	@Override
	public void onCheckedChanged(RadioGroup rg, int id) 
	{
		if(id==R.id.radio0)
		{

			Log.d("DEBUG","Radio0 was selected");
			Toast.makeText(MainActivity.this,"Radio0 was selected",Toast.LENGTH_SHORT).show();

		}
		
	}

    
}
