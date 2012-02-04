package com.iblazeapp;
import android.app.Activity;



import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.res.Configuration;

import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;

import android.widget.Button;
import android.widget.EditText;

import android.widget.ImageView;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import android.view.View.OnClickListener;


public class iblaze extends Activity 

{


	SharedPreferences _myPrefs;

	private static IService m_service;
	final Handler uiThreadCallback = new Handler();
	
	EditText _username;
	EditText _password;

	// Create an anonymous class to act as a button click listener.
	private OnClickListener goLogin = new OnClickListener() {

		@Override
		public void onClick(View v) {

			if (_username.getText().toString().length() > 0
					&& _password.getText().toString().length() > 0) {

				try {
					
					
					CoreService.reset();
					ContactScreen.reset();
					
					_myPrefs = getPreferences(MODE_PRIVATE);

					SharedPreferences.Editor editor = _myPrefs.edit();

					editor.putString("username", _username.getText().toString());
					editor.putString("password", _password.getText().toString());
					editor.commit();
					
					CoreService._username=_username.getText().toString();
					
					CoreService._password=_password.getText().toString();
					
					
					Intent myIntent = new Intent(iblaze.this, ContactScreen.class);
					startActivity(myIntent);


				}

				catch (ClassCastException e) {

				}
			}

		}
	};

	
	private static ServiceConnection m_connection = new ServiceConnection() {

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub

			m_service = IService.Stub.asInterface(service);

		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub

		}

	};
	
	
	/** hook into menu button for activity */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		menu.setQwertyMode(true);

		MenuItem item1 = menu.add(0, R.id.log_off, 0, "Log off");
		{

			item1.setIcon(R.drawable.logoff);

		}

		return super.onCreateOptionsMenu(menu);
	}

	
	
	
	/** when menu button option selected */
	@Override
	public boolean onOptionsItemSelected(MenuItem item)

	{
		switch (item.getItemId()) {

		case R.id.log_off:

			return true;

		}
		return super.onOptionsItemSelected(item);
	}

	

	@Override
	public void onConfigurationChanged(Configuration newConfig)
	{
	    super.onConfigurationChanged(newConfig);
	    
	    System.out.println("XXXXXXXXXXXXXXXXXXXXXX");
	    setContentView(R.layout.main);
	    InitializeUI();
	    // manage redrawing of your activity here
	    // ...
	}
	
	
	
	
	public void InitializeUI()
	{
	   
		
		
		
		final Button _loginButton = (Button) findViewById(R.id.Button_Login);
		_loginButton.setOnClickListener(goLogin);
		
		

		_username = (EditText) findViewById(R.id.username);
		_password = (EditText) findViewById(R.id.password);

		 setTitle("Login");

		_myPrefs = getPreferences(MODE_PRIVATE);

		if (_myPrefs.contains("username") && _myPrefs.contains("password")) {

			_username.setText(_myPrefs.getString("username", ""));

			_password.setText(_myPrefs.getString("password", ""));

		}
		
	}

	
	
	@Override
	public void onCreate(Bundle savedInstanceState) 
	
	{
		super.onCreate(savedInstanceState);

		
	
		setContentView(R.layout.main);
		InitializeUI();
		

		
		 bindService(new Intent(iblaze.this, CoreService.class),m_connection,
		  Context.BIND_AUTO_CREATE);

	}
}