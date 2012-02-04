package com.iblazeapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;

import android.app.ProgressDialog;
import android.app.AlertDialog.Builder;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
/**
 * 
 */

import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;

import android.view.View;
import android.view.View.OnClickListener;

import android.widget.AdapterView;
import android.widget.Button;

import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;


/**
 * @author Moti
 *
 */


class FriendInfo
{
	
	byte                [] username;
	byte                [] fname=new byte[50];
	byte                [] lname=new byte[50];
    int                    userid;
    
}


public class AddfriendsController extends Activity  {

	private static IService                   m_service;
	static  FriendInfo                     []_friendsList=new FriendInfo[0x80];  
	static  int                               _countfriendslist;
	
	public  static AddfriendsController                 _AddfriendsController_object = null; 
	
	static ListView                                   _listView=null;
	static List<Map<String, String>> _list = new ArrayList<Map<String, String>>();
	  
	static final Handler _uiThreadCallback = new Handler();
	static SimpleAdapter _adapter;
	static int x=0;
	static ProgressDialog	                   _mySearchProgress;
	TextView _mSearchInput;
	int DIALOG_YES_NO_MESSAGE = 999; 

	static  int                                _selectedpos=-1;
	private static  ICallback m_callback = new ICallback.Stub(){

		@Override
			public
			void OnMessage(int nID)
		   {





		   }

	};
	
	
	private OnClickListener searchFriends = new OnClickListener()
	{



		@Override
			public void onClick(View v)
		{
			
			_selectedpos=-1;
        	//_mySearchProgress.show(); 
			
			if (_mSearchInput.getText().toString().length()>=1)
				
			{
			try {
				m_service.searhcontacts(_mSearchInput.getText().toString().toCharArray());
				_mSearchInput.setText("");
				
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}

			
		}
		
	};
	private static ServiceConnection m_connection = new ServiceConnection(){

		@Override
			public void onServiceConnected(ComponentName name, IBinder service) {
				// TODO Auto-generated method stub


				m_service = IService.Stub.asInterface(service);


				try 
				{
					m_service.registerCallback(m_callback);
				} 
				catch (RemoteException e)
				{
					// TODO Auto -generated catch block
					e.printStackTrace();
				}


		}

		@Override
			public void onServiceDisconnected(ComponentName name) {
				// TODO Auto-generated method stub

		}



	};
	@Override
	protected void onDestroy () 

{

	unbindService (m_connection);
	super.onDestroy();

}
	public AddfriendsController()
	{
		
		for (int i=0; i<0x80; i++){
			
			_friendsList[i]=new FriendInfo();
		}
		
	}
	

	protected Dialog onCreateDialog(int id) 
    { 

	
		

        switch (id) 
        { 
         case 999: 
            return new AlertDialog.Builder(this) 
                .setTitle("Add Friend?") 
                .setPositiveButton("OK", new DialogInterface.OnClickListener() { 
                    public void onClick(DialogInterface dialog, int whichButton) { 


                        // User clicked OK so do some stuff 
                     
                     try {
	    					m_service.addfriend(_friendsList[_selectedpos].username);
	    					
	    					  
	                        Builder builder = new AlertDialog.Builder(_AddfriendsController_object); 
	                		builder.setTitle("Add friend  success"); 

	                		builder.setMessage("Your invitation has been sent.\nWhen they accept your invitation, they will automatically be added to your friends list."); 
	                		builder.setPositiveButton("OK", null); 
	                		builder.show(); 
	                       
	    					
	    					
	    				} catch (RemoteException e) {
	    					// TODO Auto-generated catch block
	    					e.printStackTrace();
	    				}
                     
                    } 
                }) 
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() { 
                    public void onClick(DialogInterface dialog, int whichButton) { 


                        // User clicked Cancel so do some stuff 


                     System.out.println("cancel clicked."); 
                    } 
                }) 
                .create(); 
        } 
        return null; 
        } 



	@Override
	public void onCreate(Bundle savedInstanceState) 
	{

		
		   super.onCreate(savedInstanceState);
		    setContentView(R.layout.addfriends_controller);
	         
		   _AddfriendsController_object=this;
		   ConnectThread._activeActivity_object=this;
		 
		 /*
			_mySearchProgress = new ProgressDialog(this); 
			_mySearchProgress.setTitle("Please wait..."); 
			_mySearchProgress.setMessage("Searching ..."); 
			_mySearchProgress.setIcon(R.drawable.logo); 
			*/
			
			final String[] from = {"username", "realname"};
			 
			// the to array specifies the TextViews from the xml layout
			// on which we want to display the values defined in the from array
			final int[] to = {R.id.addfriends_username, R.id.addfriends_realname};
			 
		     bindService(new Intent(this, CoreService.class),m_connection, Context.BIND_AUTO_CREATE);

		    setTitle("add friends...");
		    
		    
		     _listView=(ListView)_AddfriendsController_object.findViewById(R.id.add_friends_result);
			
		    
		  
			 
		    	 _adapter = new SimpleAdapter(_AddfriendsController_object.getApplicationContext(), _list, R.layout.addfriend_item, from, to);
			 
			      _listView.setAdapter(_adapter);
		     
		     _listView.setOnItemClickListener(new OnItemClickListener() {
					@SuppressWarnings("unchecked")
					public void onItemClick(AdapterView arg0, View arg1, int position,
							long id) {
						
						

						_selectedpos=position;
						showDialog(DIALOG_YES_NO_MESSAGE); 



					
					}
				});
		     
	        

		     
		     _mSearchInput=(TextView )findViewById(R.id.add_friendname);
		     
		     Button _searchButton=(Button)this.findViewById(R.id.search_friends);
		 	_searchButton.setOnClickListener(searchFriends);
		 	
		 	 AnimUtils.setLayoutAnim_slidedownfromtop(_listView, this);
		 	

		   /* 
		    * String screenshotUrl = "http://screenshot.xfire.com/screenshot/large/"
			+ getIntent().getStringExtra("guid") + ".jpg";
		
		WebView wv = (WebView)findViewById(R.id.wvScreenshot);
		wv.setBackgroundColor(Color.BLACK);
		wv.getSettings().setBuiltInZoomControls(true);
		wv.loadUrl(screenshotUrl);
		    *  
		    *  	Notification n = new Notification(R.drawable.xfire_notif, ticker,
				System.currentTimeMillis());
		
		n.flags |= Notification.FLAG_AUTO_CANCEL;
		n.defaults |= Notification.DEFAULT_ALL;
		
		Intent i = new Intent(this, ConvoWindow.class);
		i.putExtras(extras);
		i.setFlags(Intent.FLAG_FROM_BACKGROUND
				| Intent.FLAG_ACTIVITY_SINGLE_TOP);
		
		PendingIntent pi = PendingIntent.getActivity(this, 0, i, 0);
		
		n.setLatestEventInfo(this, title, message, pi);
		nm.notify(id, n);
		    *  _mSearchInput.setOnEditorActionListener(new TextView.OnEditorActionListener() { 
		    	    @Override 
		    	    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) { 
		    	        if (actionId == EditorInfo.IME_ACTION_SEARCH||
		    	        		actionId == EditorInfo.IME_ACTION_DONE) { 
		    	            
		    	        	
		    				
		    				
		    				
		    	        	return true;
		    	        } 
		    	        return false;
		    	       
		    	    } 
		    	}); */

			
		
		
	
	
	}
	
	
	static void refresh() {

	
		final Runnable runInUIThread = new Runnable() {
			public void run() {

				 _adapter.notifyDataSetChanged();
				 _adapter.notifyDataSetInvalidated();
				

			}
		};

		_uiThreadCallback.post(runInUIThread);
	}
	
	public static void SearchDone() {
		// TODO Auto-generated method stub
		

		
			

		final Runnable runInUIThread = new Runnable() 
		{
			
			public void run() {
			
				
				 // initialize the List of Maps
				
				 // iterate over all messages 
				 // create a map for each message
				 // fill the map with data
				
				//_mySearchProgress.dismiss();
				
				_list.clear();
				 for (int i=0; i<_countfriendslist; i++) {
					 
				 	Map<String, String> map = new HashMap<String, String>();
				 
				 	map.put("username",new String(_friendsList[i].username));
				 	map.put("realname", new String(_friendsList[i].fname)+" "+new String(_friendsList[i].lname));
				 	_list.add(map);
				 }

				 
				 

				
				

			}
		};

		_uiThreadCallback.post(runInUIThread);

	
		refresh();
	
	
	
	}



	
	
}
