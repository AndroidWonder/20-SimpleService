package com.course.example.simpleservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.SlidingDrawer;

public class LogService extends Service {
	
	private final static String tag = "LogService";

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Log.i (tag, "Service created");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		super.onStartCommand(intent, flags, startId);	  
		Log.i (tag, "Service started");
		return Service.START_STICKY;
	}
	
	
	@Override 
	public void onDestroy() {
		super.onDestroy();
		Log.i (tag, "Service destroyed");
	}
	
}//LogService