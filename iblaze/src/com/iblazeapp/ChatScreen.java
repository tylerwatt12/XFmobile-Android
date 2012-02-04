package com.iblazeapp;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//mport com.flurry.android.FlurryAgent;

import com.iblazeapp.IService;



import android.app.ListActivity;

import android.content.ComponentName;
import android.content.Context;

import android.content.Intent;

import android.content.ServiceConnection;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;

import android.os.RemoteException;

import android.widget.ArrayAdapter;
import android.widget.EditText;

import android.widget.ImageView;

import android.widget.TextView;


import android.widget.Button;

import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import android.view.View.OnClickListener;

public class ChatScreen extends ListActivity implements ChatEventListener {

	static int _userid = 0;
	private static IService m_service;
	
	static private List<String> _chats = new ArrayList<String>();
	@SuppressWarnings("unchecked")
	static ArrayAdapter _chatList = null;

	public static ChatScreen _ChatScreen_object = null;

	static final Handler uiThreadCallback = new Handler();

	Bitmap bmImg;

	void downloadAvatar(String fileUrl) {

		URL myFileUrl = null;

		ImageView iv = (ImageView) this.findViewById(R.id.Image_avatar);
		if (iv == null)
			return;

		try {
			myFileUrl = new URL(fileUrl);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			HttpURLConnection conn = (HttpURLConnection) myFileUrl
					.openConnection();
			conn.setDoInput(true);
			conn.connect();
			int length = conn.getContentLength();

			if (length == -1)
				return;
			InputStream is = conn.getInputStream();

			bmImg = BitmapFactory.decodeStream(is);

			if (bmImg == null)
				return;

			int width = bmImg.getWidth();
			int height = bmImg.getHeight();
			int newWidth = 48;
			int newHeight = 48;

			// calculate the scale - in this case = 0.4f
			float scaleWidth = ((float) newWidth) / width;
			float scaleHeight = ((float) newHeight) / height;

			// createa matrix for the manipulation
			Matrix matrix = new Matrix();
			// resize the bit map
			matrix.postScale(scaleWidth, scaleHeight);

			// recreate the new Bitmap
			Bitmap resizedBitmap = Bitmap.createBitmap(bmImg, 0, 0, width,
					height, matrix, true);

			iv.setImageBitmap(resizedBitmap);
			iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/** hook into menu button for activity */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		menu.setQwertyMode(true);

		MenuItem item1 = menu.add(0, 101, 0, "View profile");
		{

			item1.setIcon(R.drawable.profile);

		}

		MenuItem item2 = menu.add(0, 102, 0, "Friends");
		{

			item2.setIcon(R.drawable.friends);

		}

		return super.onCreateOptionsMenu(menu);
	}

	/** when menu button option selected */
	@Override
	public boolean onOptionsItemSelected(MenuItem item)

	{

		switch (item.getItemId()) {

		case 102:

			Intent myIntent = new Intent(this, ContactScreen.class);
			startActivity(myIntent);

			break;
		case 101:

			XfireContact xcontact = null;

			xcontact = CoreService.getContactByID(_userid);

			if (xcontact == null)
				break;

			Intent viewIntent = new Intent("android.intent.action.VIEW", Uri
					.parse("http://www.xfire.com/profile/"
							+ new String(xcontact._cUsername)));
			startActivity(viewIntent);

			break;

		}
		return super.onOptionsItemSelected(item);
	}

	void setAvatarTitle(byte[] cNickname) {
		TextView an = (TextView) this.findViewById(R.id.avatar_name);

		if (an == null)
			return;
		an.setText(new String(cNickname));

	}

	void LoadHistory() {

		XfireContact contact = null;

		contact = CoreService.getContactByID(_userid);

		if (contact == null)
			return;

		// NS(@"name="+name);
		String xname = "http://screenshot.xfire.com/avatar/160/"
				+ new String(contact._cUsername);
		xname += ".jpg";

		downloadAvatar(xname);
		setAvatarTitle(contact._cNickname);
		
		
		
		final XfireContact xcontact = contact;
		final Runnable runInUIThread = new Runnable() 
		{
			public void run() 
			{

				_chats.clear();
				for (int i = 0; i < xcontact._messages_count; i++)
				{

					_chats.add(xcontact._messages[i]);
				}

				_chatList.notifyDataSetChanged();

			}
		};

		uiThreadCallback.post(runInUIThread);

	}

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

	protected View rootView;

	@Override
	public boolean onKeyDown(int i, KeyEvent event) {

		// only intercept back button press
		if (i == KeyEvent.KEYCODE_BACK) {

			System.out.println("runFadeOutAnimationOn KEYCODE_BACK");
			if (rootView != null) {

				return true; // consume this keyevent
			} else {
				super.onKeyDown(i, event);
				return true;
			}
		}

		return false; // propagate this keyevent
	}

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub

		if (keyCode == 66) { // ENTER KEY

			XfireContact contact = null;

			contact = CoreService.getContactByID(_userid);

			if (contact == null)
				super.onKeyUp(keyCode, event);

			final XfireContact xcontact = contact;

			try {

				EditText input_msg = (EditText) findViewById(R.id.input_msg);

				if (input_msg.getText().toString().length() > 0) {

					AppendMessage(xcontact, input_msg.getText().toString(),
							true);

					m_service.sendim(xcontact._sid, input_msg.getText()
							.toString().toCharArray());
					input_msg.setText("");

				}

			} catch (RemoteException e) {

				e.printStackTrace();
			}

		}
		return super.onKeyUp(keyCode, event);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		ContactScreen.chatEventListener=this;
		_ChatScreen_object = this;
		ConnectThread._activeActivity_object = this;
		setContentView(R.layout.chatwindow);

		Button _sendButton = (Button) this.findViewById(R.id.send);
		_sendButton.setOnClickListener(sndMessage);

		EditText input_msg = (EditText) findViewById(R.id.input_msg);

		input_msg.setFocusable(true);

		_chatList = new ArrayAdapter(this, R.layout.chat_raw, R.id.label,
				_chats);

		setListAdapter(_chatList);

		int userid = getIntent().getIntExtra("userid", 0);

		if (userid != 0) {

			System.out.println("set new userid from bundle");
			_userid = userid;
		}

		updateChatTitle("");

		LoadHistory();

		 bindService(new Intent(ChatScreen.this,
				CoreService.class), m_connection, Context.BIND_AUTO_CREATE);

	}

	void AppendMessage(XfireContact xcontact, String msg, boolean me) {


		
		if (me==true){
			
			xcontact._messages_count++;

			if (xcontact._messages_count >= 20) {

				xcontact._messages_count = 1;

			}

			SimpleDateFormat date = new SimpleDateFormat("HH:mm");

			Date d = new Date();

			
			String name = new String(xcontact._cNickname);
			
			name += new String(" [" + date.format(d) + "] says:\n");

			xcontact._messages[xcontact._messages_count - 1] = new String(name+ "\n" + msg + "\n");
		}

		if (_userid == xcontact._userid) {

			_chats.add(msg);
			_chatList.notifyDataSetChanged();
		}

	}

	private OnClickListener sndMessage = new OnClickListener() {

		@Override
		public void onClick(View v) {

			XfireContact contact = null;

			contact = CoreService.getContactByID(_userid);

			if (contact == null)
				return;

			final XfireContact xcontact = contact;

			try {

				EditText input_msg = (EditText) findViewById(R.id.input_msg);

				if (input_msg.getText().toString().length() > 0) {

					AppendMessage(xcontact, input_msg.getText().toString(),
							true);

					m_service.sendim(xcontact._sid, input_msg.getText()
							.toString().toCharArray());
					input_msg.setText("");

				}

			} catch (RemoteException e) {

				e.printStackTrace();
			}

		}

	};

	@SuppressWarnings("unchecked")
	@Override
	public void onNewIntent(android.content.Intent newIntent)

	{

		System.out.println("onNewIntent");

		_ChatScreen_object = this;
		
		ContactScreen.chatEventListener=this;

		setContentView(R.layout.chatwindow);

		Button _sendButton = (Button) this.findViewById(R.id.send);

		_sendButton.setOnClickListener(sndMessage);

		EditText input_msg = (EditText) findViewById(R.id.input_msg);

		input_msg.setFocusable(true);

		_chatList = new ArrayAdapter(this,

		R.layout.chat_raw, R.id.label, _chats);

		System.out.println("ChatScreen:onNewIntent");
		setListAdapter(_chatList);

		int userid = newIntent.getIntExtra("userid", 0);

		if (userid != 0) {

			System.out.println("set new userid from bundle");
			_userid = userid;
		} else {

			System.out.println("failed to get userid");
			return;
		}

		updateChatTitle("");

		LoadHistory();

		 bindService(new Intent(ChatScreen.this,
				CoreService.class), m_connection, Context.BIND_AUTO_CREATE);

	}

	public void updateChatTitle(String title) {
		// TODO Auto-generated method stub

		if (_ChatScreen_object == null)
			return;

		XfireContact contact = null;

		contact = CoreService.getContactByID(_userid);

		if (contact == null)
			return;

		final XfireContact xcontact = contact;

		String name = null;
		try {
			name = new String(xcontact._cNickname, "UTF-8");
			setTitle(name + title);

		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}

	}
	
	@Override
	protected void onDestroy () 

{

	
	
	unbindService (m_connection);
	super.onDestroy();

}

	@Override
	public void AppendMessage(int userid, String msg) {
		// TODO Auto-generated method stub

		if (_ChatScreen_object == null)
			return;

		XfireContact contact = null;

		contact = CoreService.getContactByID(userid);

		if (contact == null)
			return;

		AppendMessage(contact, msg, false);

	}

}