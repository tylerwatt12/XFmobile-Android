package com.iblazeapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ExpandableListActivity;
import android.app.ListActivity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import android.app.ExpandableListActivity;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.widget.SimpleExpandableListAdapter;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ExpandableListView.ExpandableListContextMenuInfo;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import com.iblazeapp.ICallback;
import com.iblazeapp.IService;



import android.view.ViewGroup;
import android.view.ContextMenu.ContextMenuInfo;

import java.util.Random;
import java.util.Random;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.ByteArrayBuffer;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;


import com.google.ads.GoogleAdView;
import com.google.ads.AdSenseSpec;
import com.google.ads.AdSenseSpec.AdType;
public class ContactScreen extends ExpandableListActivity implements
		View.OnClickListener, EventListener {

	private static IService m_service;

	static boolean _init;
	private AlertDialog ad = null;
	static String _mystatus = new String("Xfire by Tylerwatt12");
	static String _mynickname = new String();
	static int _selecteduserid;
	@SuppressWarnings("unchecked")
	static ArrayList _result = new ArrayList();
	@SuppressWarnings("unchecked")
	static ArrayList _groupSections = new ArrayList();
	static ArrayList _onlineList = new ArrayList();
	@SuppressWarnings("unchecked")
	static ArrayList _convList = new ArrayList();
	@SuppressWarnings("unchecked")
	static ArrayList[] _clanList = new ArrayList[10];
	static SimpleExpandableListAdapter expListAdapter;
	public static ContactScreen _ContactScreen_object = null;
	static final Handler uiThreadCallback = new Handler();

	private Drawable awayIcon, onlineIcon, personIcon;
	private Resources res;
	static private List<Drawable> modeIcons;

	private static final String TAG = null;

	static private NotificationManager nm = null;

	static boolean _islogged = true;

	static String sections[] = { "Conversation", "Friends Online" };

	ProgressDialog pd = null;
	
	static public ChatEventListener  chatEventListener=null;
	
	
	//ImageView _ivAdHouse;
	private static final String KEYWORDS = "hotels+san+francisco";
	
	static GoogleAdView adView=null ;

	static AdSenseSpec adSenseSpec=null;
	
	static String keywords[] = {"game","game", "xbox360", "wii","playstation","iphone+application","HTC","android+game","iphone+game",
		"video+games","movies"};
	
	
	public ChatEventListener getChatEventListener() {
		
		return chatEventListener;
	}
	
	
	
	private void showSigninProgress()

	{
		pd = new ProgressDialog(this);
		pd.setTitle("Please wait.");
		pd.setMessage("Logging in...");
		pd.setCancelable(false);
		pd.show();
	}

	private void hideSigninProgress() {

		if (pd != null) {
			pd.dismiss();
			pd = null;

		}

	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	/*if (_ivAdHouse==v){
			
			ConnectThread.SendMetricClickNotification();
			
			
			System.out.println("click addd");
			
			Intent viewIntent = new Intent("android.intent.action.VIEW", Uri
					.parse(ConnectThread.s_redirect_url));
			startActivity(viewIntent);
		}
	*/

	}
	
	

	
	@Override
	public void onGroupCollapse(int groupPosition) {

		// System.out.println("onGroupCollapse");

		if (groupPosition == 1) {

			getExpandableListView().expandGroup(groupPosition);
		}
	}

	@Override
	public void onGroupExpand(int groupPosition) {

		// System.out.println("onGroupExpand");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		super.onCreateOptionsMenu(menu);

		MenuInflater inflater = new MenuInflater(this);
		inflater.inflate(R.menu.friends_menu, menu);

		return true;
	}

	public boolean onContextItemSelected(MenuItem item) {

		switch (item.getItemId()) {

		case R.id.view_profile:

			openProfile(_selecteduserid);
			break;

		default:
			break;
		}
		return true;

	}

	private void openProfile(int userid)

	{

		XfireContact xcontact = CoreService.getContactByID(userid);

		if (xcontact == null)
			return;

		Intent viewIntent = new Intent("android.intent.action.VIEW", Uri
				.parse("http://www.xfire.com/profile/"
						+ new String(xcontact._cUsername)));
		startActivity(viewIntent);

	}

	private void showSetStatusDialog(String statustext) {
		DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {

				
				EditText et = (EditText) ad.findViewById(R.id.etStatusText);
				
				
					 
					  _mystatus = et.getText().toString();
					  
					  try {
						m_service.setmystatus(et.getText().toString().toCharArray());
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 
				 
			
				 

			}
		};

		

		View v = getLayoutInflater().inflate(R.layout.setstatus_dialog, null);

		ad = new AlertDialog.Builder(this).setView(v).setPositiveButton(
				R.string.ok, listener).setTitle(R.string.set_status).create();
		ad.show();

		EditText et = (EditText) ad.findViewById(R.id.etStatusText);
		et.setText(statustext);
	}

	private void showSetNickDialog(String nick) {

		DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) 
			
			{
				EditText etNickname = (EditText) ad.findViewById(R.id.etNickname);
				
				
				 
				  _mynickname = etNickname.getText().toString(); //
				  
				  
				  try {
					  
					m_service.setmynickname(etNickname.getText().toString().toCharArray());
					
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  
				 
				 

			}
		};

		View v = getLayoutInflater().inflate(R.layout.setnick_dialog, null);

		ad = new AlertDialog.Builder(this).setView(v).setPositiveButton(
				R.string.ok, listener).setTitle(R.string.new_nickname).create();

		ad.show();
		((EditText) ad.findViewById(R.id.etNickname)).setText(nick);
	}

	private void logoff() {
		try {

			_islogged = false;
			ConnectThread.Disconnect();
			m_service.disconnet();

			Intent i = new Intent(_ContactScreen_object, iblaze.class);
			startActivity(i);

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean onOptionsItemSelected(MenuItem item) {

		Intent myIntent = null;
		switch (item.getItemId()) {

		case R.id.add_friend:

			myIntent = new Intent(this, AddfriendsController.class);
			startActivity(myIntent);

			break;
		case R.id.preference:

			myIntent = new Intent(this, Preference.class);
			startActivity(myIntent);

			break;

		case R.id.set_status:

			showSetStatusDialog(_mystatus);
			break;

		case R.id.log_off:

			logoff();

			break;

		case R.id.set_nick:

			showSetNickDialog(_mynickname);

			break;

		}

		return true;

	}

	static public void refresh() {

		if (_init == false)
			return;

		
		
		final Runnable runInUIThread = new Runnable() {
			
			public void run() {

				_ContactScreen_object.getExpandableListView().setVisibility(View.GONE); 
				_ContactScreen_object.getExpandableListView().expandGroup(0);
				_ContactScreen_object.getExpandableListView().expandGroup(1);

				expListAdapter.notifyDataSetChanged();
				expListAdapter.notifyDataSetInvalidated();
				_ContactScreen_object.getExpandableListView().setVisibility(View.VISIBLE); 

			}
		};

		uiThreadCallback.post(runInUIThread);
	}

	void setIcon(View v, int n) {

		ImageView imgV = (ImageView) v.findViewById(R.id.mode);
		if (imgV != null) {

			imgV.setImageDrawable(modeIcons.get(n));

		}

	}

	void AddConversation(XfireContact xcontact) 
	{

		String name = null;

		try {
			name = new String(xcontact._cNickname, "UTF-8");

		}

		catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (xcontact._bIsPendingMessages == false) {

			HashMap child = new HashMap();

			child.put("userid", new Integer(xcontact._userid));
			child.put("friendName", name);
			child.put("status", "");
			_convList.add(child);
			xcontact._bIsPendingMessages = true;
			refresh();
			return;
		}

		for (int i = 0; i < _convList.size(); i++) {
			HashMap conv_child = (HashMap) _convList.get(i);

			Integer conv_userid = (Integer) conv_child.get("userid");

			if (conv_userid == xcontact._userid) {

				try {
					if (xcontact._nTotalPendingMessages == 0) {

						conv_child.put("friendName", new String(
								xcontact._cNickname, "UTF-8"));

					} else {
						conv_child.put("friendName", new String(
								xcontact._cNickname, "UTF-8")
								+ " (" + xcontact._nTotalPendingMessages + ")");
					}

				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				_convList.set(i, conv_child);
				refresh();
				break;

			}
		}

	}

	@Override
	public boolean onChildClick(ExpandableListView parent, View v,
			int groupPosition, int childPosition, long id) {

		System.out.print("enter onChildClick");
		Integer userid;
		XfireContact xcontact = null;
		HashMap child;

		if (groupPosition == 0) {

			// _mAd.requestFreshAd();

			child = (HashMap) _convList.get(childPosition);
			userid = (Integer) child.get("userid");

			xcontact = CoreService.getContactByID(userid);

			if (xcontact == null)
				return true;

			xcontact._nTotalPendingMessages = 0;

			AddConversation(xcontact);

			ChatScreen._userid = userid;

			_selecteduserid = userid;
			Intent myIntent = new Intent(ContactScreen.this, ChatScreen.class);
			startActivity(myIntent);

		}

		if (groupPosition == 1) {

			// _mAd.requestFreshAd();
			child = (HashMap) _onlineList.get(childPosition);

			userid = (Integer) child.get("userid");

			xcontact = CoreService.getContactByID(userid);

			if (xcontact == null)
				return true;

			xcontact._nTotalPendingMessages = 0;

			AddConversation(xcontact);

			ChatScreen._userid = userid;

			Intent myIntent = new Intent(ContactScreen.this, ChatScreen.class);
			startActivity(myIntent);

		}

		if (groupPosition > 1) {

			// _mAd.requestFreshAd();
			child = (HashMap) _clanList[groupPosition - 2].get(childPosition);
			userid = (Integer) child.get("userid");
			ChatScreen._userid = userid;
			Intent myIntent = new Intent(ContactScreen.this, ChatScreen.class);
			startActivity(myIntent);

		}

		return true;

	}

	private static ICallback m_callback = new ICallback.Stub() {

		@Override
		public void OnMessage(int nID) {

		}

	};

	@Override
	protected void onDestroy()

	{
		
		logoff();
		unbindService(m_connection);
		super.onDestroy();

	}

	private static ServiceConnection m_connection = new ServiceConnection() {

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub

			m_service = IService.Stub.asInterface(service);

			try {
				m_service.registerCallback(m_callback);
				m_service.connect(CoreService._username.toCharArray(),
						CoreService._password.toCharArray());
			} catch (RemoteException e) {
				// TODO Auto -generated catch block
				e.printStackTrace();
			}

		}
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub

		}

	};

	static public void reset() {

		_convList.clear();

		_onlineList.clear();

		createGroupList();

		for (int i = 0; i < 10; i++) {

			_clanList[i] = new ArrayList();
			_clanList[i].clear();
		}

	}

	static void postNotification(String ticker, String title, String message,
			Bundle extras, int id) {

		Notification n = new Notification(R.drawable.gfire, ticker, System
				.currentTimeMillis());

		n.flags |= Notification.FLAG_AUTO_CANCEL;
		n.defaults |= Notification.DEFAULT_LIGHTS;

		// n.icon=R.drawable.gfire;

		Intent i = new Intent(_ContactScreen_object, ChatScreen.class);

		i.setFlags(Intent.FLAG_FROM_BACKGROUND
				| Intent.FLAG_ACTIVITY_SINGLE_TOP);

		i.putExtras(extras);
		PendingIntent pi = PendingIntent.getActivity(_ContactScreen_object, 0,
				i, 0);

		n.setLatestEventInfo(_ContactScreen_object, title, message, pi);
		nm.notify(id, n);

	}
	   private  static String convertStreamToString(InputStream is) {
	        /*
	         * To convert the InputStream to String we use the BufferedReader.readLine()
	         * method. We iterate until the BufferedReader return null which means
	         * there's no more data to read. Each line will appended to a StringBuilder
	         * and returned as String.
	         */
	        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	        StringBuilder sb = new StringBuilder();
	 
	        String line = null;
	        try {
	            while ((line = reader.readLine()) != null) {
	                sb.append(line + "\n");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                is.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        return sb.toString();
	    }
	 public static void get_keywords(String url)
	    {
	 
		     if (adSenseSpec==null) return;
	        HttpClient httpclient = new DefaultHttpClient();
	 
	        // Prepare a request object
	        HttpGet httpget = new HttpGet(url); 
	 
	        // Execute the request
	        HttpResponse response;
	        try {
	            response = httpclient.execute(httpget);
	            // Examine the response status
	            Log.i("Praeda",response.getStatusLine().toString());
	 
	            // Get hold of the response entity
	            HttpEntity entity = response.getEntity();
	            // If the response does not enclose an entity, there is no need
	            // to worry about connection release
	 
	            if (entity != null) {
	 
	                // A Simple JSON Response Read
	                InputStream instream = entity.getContent();
	                String result= convertStreamToString(instream);
	                Log.i("Praeda-keywords",result);
	                
                      
	                adSenseSpec.setKeywords(result);
	                adView.showAds(adSenseSpec);
	 	             instream.close();
	            }
	 
	 
	        } catch (ClientProtocolException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }

	 
	 
	 @Override
	 public void onConfigurationChanged(Configuration newConfig) {
	     super.onConfigurationChanged(newConfig);
	     InitializeUI();
	 }
	 
	 
	 public void InitializeUI()
		{
		 
		 _ContactScreen_object = this;
			ConnectThread._activeActivity_object = this;
			
			
		    
			
			
			
			chatEventListener=ChatScreen._ChatScreen_object;

			setTitle("Xfire friends");
			res = this.getResources();

			awayIcon = (Drawable) res.getDrawable(R.drawable.away);
			onlineIcon = (Drawable) res.getDrawable(R.drawable.online);
			personIcon = (Drawable) res.getDrawable(R.drawable.person);

			modeIcons = new ArrayList<Drawable>();
			modeIcons.add(awayIcon);
			modeIcons.add(onlineIcon);
			modeIcons.add(personIcon);

			nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

			setContentView(R.layout.main_contacts);
			
			adView= (GoogleAdView) findViewById(R.id.adview);
			
		     get_keywords("http://www.xf-mobile.com/download/keywords_bb.php");
			
			 adSenseSpec =
			    new AdSenseSpec("ca-mb-app-pub-5531202394163433")     // required
			    .setCompanyName("XFMOBILE")  // required
			    .setAppName("XFMOBILE")          // required
			    .setChannel("5523329122")
			    .setAdTestEnabled(true)       // Keep true while testing
			    .setAdType(AdType.TEXT_IMAGE);
			
			    adView.showAds(adSenseSpec);
			    
			
			    
			    
		}
	@Override
	public void onCreate(Bundle icicle) {

		super.onCreate(icicle);

		
		InitializeUI();
	
		bindService(new Intent(ContactScreen.this,
				CoreService.class), m_connection, Context.BIND_AUTO_CREATE);

		View.OnCreateContextMenuListener listener = new View.OnCreateContextMenuListener() {

			@Override
			public void onCreateContextMenu(ContextMenu menu, View v,
					ContextMenuInfo menuInfo) {
				// TODO Auto-generated method stub

				ExpandableListContextMenuInfo info = (ExpandableListContextMenuInfo) menuInfo;

				int groupPos = ExpandableListView
						.getPackedPositionGroup(info.packedPosition);
				int childPos = ExpandableListView
						.getPackedPositionChild(info.packedPosition);

				Log.v(TAG, "childPos " + childPos);
				Log.v(TAG, "groupPos " + groupPos);

				if (groupPos > 1 && childPos != -1) {

					Integer userid;
					XfireContact xcontact = null;
					HashMap child;
					child = (HashMap) _clanList[groupPos - 2].get(childPos);
					userid = (Integer) child.get("userid");
					xcontact = CoreService.getClanMember(userid);
					if (xcontact == null)
						return;

					_selecteduserid = xcontact._userid;

					getMenuInflater().inflate(R.menu.menu_friendslist_context,
							menu);

				}
				if (groupPos == 1 && childPos != -1) {

					Integer userid;
					XfireContact xcontact = null;
					HashMap child;

					child = (HashMap) _onlineList.get(childPos);
					userid = (Integer) child.get("userid");

					xcontact = CoreService.getContactByID(userid);

					if (xcontact == null)
						return;

					_selecteduserid = xcontact._userid;

					getMenuInflater().inflate(R.menu.menu_friendslist_context,
							menu);

				}

				if (groupPos == 0 && childPos != -1) {

					Integer userid;
					XfireContact xcontact = null;
					HashMap child;

					child = (HashMap) _convList.get(childPos);
					userid = (Integer) child.get("userid");

					xcontact = CoreService.getContactByID(userid);
					if (xcontact!=null){
					
						 xcontact._nTotalPendingMessages = 0;
					}
					RemoveConversation(userid);

				}

			}

		};
		getExpandableListView().setOnCreateContextMenuListener(listener);

		AnimUtils.setLayoutAnim_slidedownfromtop(getExpandableListView(), this);

		update();

		showSigninProgress();
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {

		if (_init) {
			_ContactScreen_object.getExpandableListView().expandGroup(0);
			_ContactScreen_object.getExpandableListView().expandGroup(1);
		}

	}

	static void RemoveConversation(int userid) {

		XfireContact xcontact = CoreService.getContactByID(userid);

		if (xcontact == null)
			return;

		xcontact._bIsPendingMessages = false;
		for (int i = 0; i < _convList.size(); i++) {
			HashMap child = (HashMap) _convList.get(i);

			Integer id = (Integer) child.get("userid");

			if (id == xcontact._userid) {

				// _convList.set(i, child);
				_convList.remove(i);
				refresh();
				break;

			}

		}
	}

	public static void RemoveFromFriendsMembers(int userid)

	{

		XfireContact xcontact = CoreService.getContactByID(userid);

		if (xcontact == null)
			return;
		for (int i = 0; i < _onlineList.size(); i++) {
			HashMap child = (HashMap) _onlineList.get(i);

			Integer id = (Integer) child.get("userid");

			if (id == xcontact._userid) {

				_onlineList.remove(i);

				refresh();

				break;

			}

		}
	}

	public void AddAsFriendsMember(int userid)
	{

		XfireContact xcontact = CoreService.getContactByID(userid);

		if (xcontact == null)
			return;
		
		HashMap child = new HashMap();

		String name=null;
		try {

			name = new String(xcontact._cNickname, "UTF-8");

			child.put("friendName", name);

			child.put("status", "");

			child.put("userid", new Integer(xcontact._userid));

			_onlineList.add(child);

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		refresh();
	}

	void update() 
	
	{

		_result.clear();

		// Collections.sort(_onlineList);

		_result.add(_convList);
		_result.add(_onlineList);

		_result.add(_clanList[0]);
		_result.add(_clanList[1]);
		_result.add(_clanList[2]);
		_result.add(_clanList[3]);
		_result.add(_clanList[4]);
		_result.add(_clanList[5]);
		_result.add(_clanList[6]);
		_result.add(_clanList[7]);
		_result.add(_clanList[8]);
		_result.add(_clanList[9]);

		expListAdapter = new SimpleExpandableListAdapter(_ContactScreen_object,
				_groupSections, // groupData describes the first-level entries
				R.layout.group_row, // Layout for the first-level entries
				new String[] { "sectionName" }, // Key in the groupData maps to
				// display
				new int[] { R.id.groupname }, // Data under "friendName" key
				// goes into this TextView
				_result, // childData describes second-level entries
				R.layout.child_row, // Layout for second-level entries
				new String[] { "friendName", "status" }, // Keys in childData
				// maps to display
				new int[] { R.id.childname, R.id.rgb } // Data under the keys
		// above go into these
		// TextViews
		) {

			@Override
			public View getChildView(int groupPosition, int childPosition,
					boolean isLastChild, View convertView, ViewGroup parent) {
				final View v = super.getChildView(groupPosition, childPosition,
						isLastChild, convertView, parent);
				// Populate your custom view here

				if (groupPosition == 0) {

					setIcon(v, 2);

					return v;

				}

				if (groupPosition > 1) {

					HashMap child = (HashMap) _clanList[groupPosition - 2]
							.get(childPosition);
					Integer userid = (Integer) child.get("userid");
					final XfireContact xcontact = CoreService
							.getClanMember(userid);

					if (xcontact._uStatus == 1) {

						setIcon(v, 0);

					} else {

						setIcon(v, 1);

					}

					if (xcontact._gameid != 0 && xcontact._gameid >= 4096
							&& xcontact._gameid <= 6046) {

						System.out.println("game id=" + xcontact._gameid);
						ImageView imgV = (ImageView) v.findViewById(R.id.mode);
						if (imgV != null) {

							/*
							 * Drawable
							 * x=_ContactScreen_object.getResources().getDrawable
							 * (R.drawable.gameid_4096-4096+xcontact._gameid);
							 * if (x!=null){ imgV.setImageDrawable(x); }
							 */
						}

					}
					// showX(v, 1);

				}

				if (groupPosition == 1) {

					// showX(v, 1);
					HashMap child = (HashMap) _onlineList.get(childPosition);

					Integer userid = (Integer) child.get("userid");

					final XfireContact xcontact = CoreService
							.getContactByID(userid);

					if (xcontact != null) {

						if (xcontact._uStatus == 1) {

							setIcon(v, 0);

						} else {

							setIcon(v, 1);

						}

						if (xcontact._gameid != 0 && xcontact._gameid >= 4096
								&& xcontact._gameid <= 6046) {

							// System.out.println("game id="+xcontact._gameid);
							ImageView imgV = (ImageView) v
									.findViewById(R.id.mode);
							if (imgV != null) {

								/*
								 * Drawable
								 * x=_ContactScreen_object.getResources(
								 * ).getDrawable
								 * (R.drawable.gameid_4096-4096+xcontact
								 * ._gameid); if (x!=null){
								 * imgV.setImageDrawable(x); }
								 */
							}

						}

					}

				}

				return v;
			}

		};

		_ContactScreen_object.setListAdapter(expListAdapter);

		_init = true;

	}

	/**
	 * Creates the group list out of the colors[] array according to the
	 * structure required by SimpleExpandableListAdapter. The resulting List
	 * contains Maps. Each Map contains one entry with key "colorName" and value
	 * of an entry in the colors[] array.
	 */

	private static void createGroupList() {

		_groupSections.clear();

		for (int i = 0; i < sections.length; ++i) {

			HashMap m = new HashMap();
			m.put("sectionName", sections[i]);
			_groupSections.add(m);

		}

	}

	public static XfireContact getClanMemberbySID(byte sid[]) {

		boolean bOK = false;
		for (int i = 0; i < CoreService._nTotalClans; i++) {

			for (int j = 0; j < CoreService._ClansList[i]._usercount; j++) {

				XfireContact xcontact = (XfireContact) CoreService._ClansList[i]._listContacts
						.get(j);
				bOK = false;

				for (int x = 0; x < 16; x++) {

					if (xcontact._sid[x] != sid[x]) {

						bOK = true;

						break;

					}

				}

				if (!bOK)
					return xcontact;

			}

		}
		return null;

	}

	public void removeFromClanMembers(int userid) {

		for (int i = 0; i < CoreService._nTotalClans; i++) {

			for (int j = 0; j < _clanList[i].size(); j++) {

				HashMap child = (HashMap) _clanList[i].get(j);

				Integer id = (Integer) child.get("userid");

				if (id == userid) {
					_clanList[i].remove(j);
					refresh();
					return;
				}

			}

		}

	}

	public static void addAsClanMember(int userid) 
	{

		for (int i = 0; i < CoreService._nTotalClans; i++) {

			for (int j = 0; j < CoreService._ClansList[i]._usercount; j++) {

				XfireContact xcontact = (XfireContact) CoreService._ClansList[i]._listContacts.get(j);

				
				if (xcontact._userid == userid) 
				{

					HashMap child = new HashMap();

					child.put("userid", new Integer(xcontact._userid));

					
					if (xcontact._cNickname[0] == 0) {

						child.put("friendName", new String(xcontact._cUsername));

					} else {

						try {
							String name = new String(xcontact._cNickname,
									"UTF-8");

							child.put("friendName", name);

						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}

					child.put("status", "");

					_clanList[i].add(child);
					
					

					refresh();

					return;

				}

			}
		}

	}

	public void PlayIMSound() {

		MediaPlayer player = MediaPlayer.create(_ContactScreen_object,
				R.raw.imsound);
		player.start();

	}

	public void AddConversions(byte[] sid, final String cMsg, boolean b) {

		
		
		System.out.println("Enter AddConversions");
		
		String name = null;

		XfireContact contact = CoreService.getContactBySID(sid);

		if (contact == null)
			return;

		if (Preference._isSoundNotifyEnabled) {

			PlayIMSound();

		}

		try {
			name = new String(contact._cNickname, "UTF-8");

		}

		catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		final String friend_name = name;

		final XfireContact xcontact = contact;

		System.out.println("Enter AddConversation");
		AddConversation(xcontact);
		
		
		xcontact._messages_count++;

		if (xcontact._messages_count >= 20) {

			xcontact._messages_count = 1;

		}

		SimpleDateFormat date = new SimpleDateFormat("HH:mm");

		Date d = new Date();

		
		name = new String(xcontact._cNickname);
		
		name += new String(" [" + date.format(d) + "] says:\n");

		xcontact._messages[xcontact._messages_count - 1] = new String(name+ "\n" + cMsg + "\n");
		
		//
		
		final String message=name + cMsg + "\n";

		final Runnable runInUIThread = new Runnable() {
			public void run() 
			{

				xcontact._nTotalPendingMessages++;
			
					if (Preference._isBackgroundNotifyEnabled) {

						final Bundle bundle = new Bundle();
						bundle.putInt("userid", xcontact._userid);

						postNotification("Message from Xfire.", friend_name,
								cMsg, bundle, 0);

					}

				

				
				if (chatEventListener!=null){
				
					getChatEventListener().AppendMessage(xcontact._userid, message);
				
					getChatEventListener().updateChatTitle("");
				}

			}
		};

		uiThreadCallback.post(runInUIThread);

		refresh();
		
		System.out.println("Leave AddConversions");

	}



	

	@Override
	public void Removefriend(final int userid, String email) {
		// TODO Auto-generated method stub
		
		
		final Runnable runInUIThread = new Runnable() {
			public void run() {

				
				removeFromClanMembers(userid);
                RemoveFromFriendsMembers(userid);
	            RemoveConversation(userid);

			}
		};

		uiThreadCallback.post(runInUIThread);
		
		
		
		
	
	}

	@Override
	public void connectionClosed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void connectionError(final String err) {
		// TODO Auto-generated method stub
		hideSigninProgress();
		
		
		final Runnable runInUIThread = new Runnable() {
			public void run() {

			

				AlertDialog alertDialog = new AlertDialog.Builder(
						ContactScreen._ContactScreen_object).create();
				alertDialog.setTitle("XFMobile");
				alertDialog
						.setMessage(err);
				alertDialog.setButton("OK",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int which) {
								
								Intent myIntent = new Intent(ContactScreen.this, iblaze.class);
								startActivity(myIntent);
								
								return;
							}
						});
				alertDialog.show();
				
				
				


			}
		};

		uiThreadCallback.post(runInUIThread);
	}

	@Override
	public void connectionEstablished() {
		// TODO Auto-generated method stub
		hideSigninProgress();
	}

	@Override
	public void Addfriend(final int userid, String email, String name) {
		// TODO Auto-generated method stub

		
		final Runnable runInUIThread = new Runnable() {
			public void run() {

				
				    addAsClanMember(userid);
		            AddAsFriendsMember(userid);

			}
		};

		uiThreadCallback.post(runInUIThread);
		
		
		
	

	}

	@Override
	public void friendGameStateChanged(final byte[] usersid, final int gameid) {
		// TODO Auto-generated method stub

		
		final Runnable runInUIThread = new Runnable() {
			public void run() {
				
		
		XfireContact xcontact = CoreService.getContactBySID(usersid);

		if (xcontact == null) {

			return;

		}

		String gamename = Utility.getGameNameFromID(gameid);

		if (gamename == null) {
		
			return;
		}
		
		
		if (gamename.length()<1) return;
		
		xcontact._cGamename=new byte[gamename.length()];
		
		System.arraycopy(gamename.getBytes(), 0, xcontact._cGamename, 0, gamename.length());
		
		
		
	
		

		for (int i = 0; i < _onlineList.size(); i++) {
			HashMap child = (HashMap) _onlineList.get(i);

			Integer userid = (Integer) child.get("userid");

			if (userid == xcontact._userid) {

				child.put("status", gamename);

				_onlineList.set(i, child);

			}

		}
		
		if (CoreService._nTotalClans>=20) return;
		

		for (int i = 0; i < CoreService._nTotalClans; i++) {

			for (int j = 0; j < _clanList[i].size(); j++) {
			
				HashMap child = (HashMap) _clanList[i].get(j);

				Integer id = (Integer) child.get("userid");

				if (id == xcontact._userid) {

					child.put("status", gamename);
					_clanList[i].set(j, child);

				}

			}

		}


		refresh();
	}
		};

		uiThreadCallback.post(runInUIThread);
		

	}

	@Override
	public void friendStateChanged(String email, int state) {
		// TODO Auto-generated method stub

	}

	@Override
	public void friendStatusChanged(final byte[] usersid, final String smsg) {
		// TODO Auto-generated method stub

		
		final Runnable runInUIThread = new Runnable() {
			public void run() {
				
				
	
		XfireContact xcontact = CoreService.getContactBySID(usersid);

		if (xcontact == null || smsg==null) {

			System.out.println("friendStatusChanged no contact was found !");
			return;
		}

		xcontact._gameid = 0;
		xcontact._uStatus = 0;

		if (smsg.length() > 5) {
			if (smsg.charAt(0) == '(' && smsg.charAt(1) == 'A'
					&& smsg.charAt(2) == 'F' && smsg.charAt(3) == 'K') {

				xcontact._uStatus = 1;
				
				xcontact._cStatusMsg=new byte[smsg.length()];
				
				System.arraycopy(smsg.getBytes(), 0, xcontact._cStatusMsg, 0, smsg.length());
				
				
				

			}
		}

		if (smsg.length()<1) return;
		
		xcontact._cStatusMsg=new byte[smsg.length()];
		
		System.arraycopy(smsg.getBytes(), 0, xcontact._cStatusMsg, 0, smsg.length());
		
		for (int i = 0; i < _onlineList.size(); i++) {

			HashMap child = (HashMap) _onlineList.get(i);

			Integer userid = (Integer) child.get("userid");

			if (userid == xcontact._userid) {

				child.put("status", smsg);

			}

		}
		
		if (CoreService._nTotalClans>=20) return;

		
		for (int i = 0; i < CoreService._nTotalClans; i++) {

			for (int j = 0; j < _clanList[i].size(); j++) {
				HashMap child = (HashMap) _clanList[i].get(j);

				Integer id = (Integer) child.get("userid");

				if (id == xcontact._userid) {

					child.put("status", smsg);

					_clanList[i].set(j, child);

				}

			}

		}
		
		

		refresh();

			}
		};

		uiThreadCallback.post(runInUIThread);
		
	}

	@Override
	public void messageError(final String id) {
		// TODO Auto-generated method stub
		

	}
	
	

	

	@Override
	public void messageReceived(final byte[] usersid, String email, final String message) {
		// TODO Auto-generated method stub
		final Runnable runInUIThread = new Runnable() {
			public void run() {
		
				AddConversions(usersid,message,false);
			}
		};

		uiThreadCallback.post(runInUIThread);
		


	}

	@Override
	public void addClanGroup(final byte[] name) {
		// TODO Auto-generated method stub
		final Runnable runInUIThread = new Runnable() {
			public void run() {

			
		HashMap m = new HashMap();

		m.put("sectionName", new String(name).substring(0, new String(name)
				.indexOf(0)));

		_groupSections.add(m);

			}
		};

		uiThreadCallback.post(runInUIThread);


	}

	@Override
	public void switchToTypingMode() {
		// TODO Auto-generated method stub

		final Runnable runInUIThread = new Runnable() {
			public void run() {

				
				getChatEventListener().updateChatTitle(" is typing...");

			}
		};

		uiThreadCallback.post(runInUIThread);

	}



	@Override
	public void SetHouseAD(final Bitmap bm) {
		// TODO Auto-generated method stub
		
		
		final Runnable runInUIThread = new Runnable() {
			public void run() {

				
				//_ivAdHouse.setImageBitmap(bm);
				//_ivAdHouse.setScaleType(ImageView.ScaleType.FIT_CENTER);

			}
		};

		uiThreadCallback.post(runInUIThread);
		
	}

}
