/*
 * Create service that makes log entries in its lifecycle methods.
 * Button click ends service.
 * Manifest entry  for service.
 */
package com.course.example.simpleservice;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class SimpleService extends Activity {
    TextView txtMsg;
    Button btnStopService;
    ComponentName service;
    Intent intentMyService;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);        
        txtMsg = (TextView) findViewById(R.id.txtMsg);        
        
        //start service
        intentMyService = new Intent(this, LogService.class);
        service = startService(intentMyService);  
        
        txtMsg.setText("MyService started (see Log)");
        
        //stop service when button clicked
        btnStopService = (Button) findViewById(R.id.btnStopService);
        btnStopService.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				try {
					stopService(intentMyService);
					txtMsg.setText("Stopping Service: \n" +
							        service.getClassName());
				} catch (Exception e) {
					Toast.makeText(SimpleService.this, e.getMessage(), Toast.LENGTH_LONG).show();
				}
				
			}
        	
        });
   
    }
}