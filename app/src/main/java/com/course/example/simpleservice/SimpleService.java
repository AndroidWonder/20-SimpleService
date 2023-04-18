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
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class SimpleService extends Activity {
   private EditText txtMsg;
    private Button btnStopService;
    private ComponentName service;
    private Intent intentMyService;
    private final static String tag = "LogService";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);        
        txtMsg = (EditText) findViewById(R.id.txtMsg);
        
        //start service
        intentMyService = new Intent(this, LogService.class);
        service = startService(intentMyService);  
        
        txtMsg.setText("MyService started (see Log)");
        
        //stop service when button clicked
        btnStopService = (Button) findViewById(R.id.btnStopService);
        btnStopService.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
                stopService(intentMyService);
                Log.i (tag, "Service stopped");
                txtMsg.setText("Stopping Service: \n" +
                        service.getClassName());
			}
        });
   
    }
}