package com.iblazeapp;

import android.app.Activity;
/**
 * 
 */
import android.os.Bundle;
import android.util.Log;

import android.widget.CheckBox;
import android.widget.CompoundButton;

/**
 * @author Moti
 *
 */
public class Preference extends Activity {

	
	static          boolean              _isSoundNotifyEnabled=false;
	static          boolean              _isBackgroundNotifyEnabled=true;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {

		
		setContentView(R.layout.options);
	        
		 final CheckBox  soundchk = (CheckBox ) findViewById(R.id.enable_sound_notify);    
		  soundchk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
			  @Override
			  public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) 
			  {
			                 // TODO Auto-generated method stub
				  
				             if (isChecked){
				            	 
				            	 Log.v("ContactScreen","SOUND on!\n");
				            	 _isSoundNotifyEnabled=true;
				             }else{
				            	 
				            	 _isSoundNotifyEnabled=false;
				            	 Log.v("ContactScreen","SOUND OFF!\n");
				            	 
				             }
			   }
			  });
		  
		  
		  final CheckBox  backgroundchk = (CheckBox ) findViewById(R.id.bk_sound_notify);    
		  backgroundchk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
			  @Override
			  public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) 
			  {
			                 // TODO Auto-generated method stub
				  
				             if (isChecked){
				            	 
				            	
				            	 _isBackgroundNotifyEnabled=true;
				             }else{
				            	 
				            	 _isBackgroundNotifyEnabled=false;
				            	
				            	 
				             }
			   }
			  });

		
		  soundchk.setChecked(_isSoundNotifyEnabled);
		  backgroundchk.setChecked(_isBackgroundNotifyEnabled);
		  
		super.onCreate(savedInstanceState);
	
	
	}
	
	
}
