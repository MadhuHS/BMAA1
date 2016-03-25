package com.jspiders.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

   EditText inputEditText;
   Button outputButton,cleartextButton,clearedittextButton;
   TextView outputTextView;
   String s1 = "jspiders";
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        inputEditText = (EditText)findViewById(R.id.editTextinput);
        outputButton = (Button) findViewById(R.id.buttonoutput);
        outputTextView = (TextView) findViewById(R.id.textViewoutput);  
        cleartextButton = (Button) findViewById(R.id.buttonclear);
        clearedittextButton = (Button) findViewById(R.id.buttonclearinput);
        
       /* cleartextButton.setOnClickListener(MainActivity.this);
        clearedittextButton.setOnClickListener(MainActivity.this);*/
        
        outputButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
    }

    
   public void displaymsg(View v)
   {
	   
	  /*Editable e1 = inputEditText.getText();
	  String data = e1.toString();*/
	   
	  String data = inputEditText.getText().toString();
	  
	  if(data.length()==0)
	  {
		  outputTextView.setText("Invalid input");
	  }
	  else
	  {
		 if(data.equals(s1))
		 {
			 outputTextView.setText(data+" "+"match found");
		 }
		 
		 else
		 {
			 outputTextView.setText(data+" "+"match not found");
		 }
		  	  

	  }
	  
   }


/*@Override
public void onClick(View view) 
{
	if(view.getId()==R.id.buttonclear)
	{
	outputTextView.setText("");
	}
	
	else if(view.getId()==R.id.buttonclearinput)
	{
		inputEditText.setText("");
	}
	*/
}
   

