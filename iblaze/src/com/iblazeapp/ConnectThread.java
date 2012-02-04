package com.iblazeapp;

import java.io.InputStream;



import java.io.IOException;

import java.io.UnsupportedEncodingException;

import android.app.Activity;
import android.app.Dialog;

import android.os.Handler;


import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import java.net.Socket;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.io.*;
import android.util.Log;
import android.app.AlertDialog;

import android.content.DialogInterface;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


import java.net.InetAddress;

import java.util.Timer;
import java.util.TimerTask;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;




import com.iblazeapp.json.JSONException;
import com.iblazeapp.json.JSONObject;

public class ConnectThread extends Thread 
{

	public static final int XFIRE_CLAN_BUDDYS_NAMES_ID = 159;
	public static final int XFIRE_CLAN_PACKET = 158;
	public static final int XFIRE_CONTACT_STATUS_MSG = 154;
	
	public static final int XFIRE_PONG_REPLY = 144;

	public static final int XFIRE_VERSION_MISMATCH_ID = 134;
	public static final int XFIRE_RECV_IM_ID = 133;
	public static final int XFIRE_RECV_NICKNAMECHANGE_ID = 161;
	public static final int XFIRE_BUDDY_STATUS_ID = 0x84;
	public static final int XFIRE_LOGIN_FAILED_ID = 0x81;
	public static final int XFIRE_LOGIN_SUCCESS_ID = 130;
	public static final int XFIRE_PACKET_AUTH_ID = 0x80;
	public static final int XFIRE_PACKET_CONTACTS = 0x83;
	public static final int XFIRE_PACKET_CONTACTS_ONLINE = 0x82;
	public static final int DEF_XSOCKSTATUS_READINGHEADER = 11;
	public static final int DEF_XSOCKSTATUS_READINGBODY = 12;
	public static final int XFIRE_OBJECT_TYPE_ID = 0x01;
	public static final int DEF_MSGBUFFERSIZE = 0xFFFF;
	public static final int DEF_MSGFROM_XFIRESERVER = 5;

	private static final String TAG = "iBlazeLOG";

	private DataInputStream _in=null;
	private DataOutputStream _out=null;
	Socket _socket;

	private int _uStatus;
	private int _dwReadSize;
	private int _dwTotalReadSize;
	private byte[] _pRcvBuffer;
	public static boolean _isThreadRunning;
	static boolean _isdisconnect = false;
	int _nIndex;
	Timer _timer = new Timer();
	String _username;
	String _password;
	static String _myNickname = new String("Me");
	boolean _isTringToConnect;
	public static final int DEF_MSGQUENESIZE = 256;
	int m_iQueneHead;
	int m_iQueneTail;

	boolean _isMsgPending = false;
	static final Handler _uiThreadCallback = new Handler();
	public static Activity _activeActivity_object = null;

	static String s_img_url;
	static String s_redirect_url;
	static String s_metrics_url;
	static String s_ad_text;
	Timer _KAtimer = new Timer();

	private EventListener  FriendsListener = null;
	
	
	MsgQue[] m_pMsgQuene = new MsgQue[DEF_MSGQUENESIZE];

	public ConnectThread() {

		
		
		_pRcvBuffer = new byte[DEF_MSGBUFFERSIZE];

		_uStatus = DEF_XSOCKSTATUS_READINGHEADER;

		_dwReadSize = 2;

		_dwTotalReadSize = 0;

		_isThreadRunning = false;

		_nIndex = 0;

		

		m_iQueneHead = 0;
		m_iQueneTail = 0;
		_isdisconnect = false;

		int i;
		for (i = 0; i < DEF_MSGQUENESIZE; i++) {
			
			m_pMsgQuene[i] = null;
		}

		_timer.schedule(new MsgTask(), 100, 100);
		_KAtimer.schedule(new KeepAliveTask(), 0, 1000 * 240);
		
		this.FriendsListener=ContactScreen._ContactScreen_object;
		
        
       
	}
	
	
	public void Connect(String user, String pass)
	{
			
			_username = user;
			_password = pass;
			start();
			
	}
	
	
	public EventListener getFriendsEventListener() {
		
		 
		return FriendsListener;
	}
	

	class MsgTask extends TimerTask {
		public void run() {

			

			   bGetMsgQuene();

		

		}
	}

	

	class KeepAliveTask extends TimerTask {
		public void run() {

			try {

			
				System.out.println("sending ping...");

				

			 	KeepAlive();

			}

			catch (Exception e) {

				System.err.println(e.toString());
			} finally {

			}

		}
	}
	boolean bGetMsgQuene() // /:(char*)pFrom Data:(char*)pData Size:(unsigned
							// short*)szMsgSize Index:(int*)pIndex
							// Key:(char*)pKey
	{

		if (m_pMsgQuene[m_iQueneHead] == null) {

			return false;

		}
		
		if (m_pMsgQuene[m_iQueneHead].bGet_data()==null)
			return false;

	
		ParsePacket(m_pMsgQuene[m_iQueneHead].bGet_data());

		m_pMsgQuene[m_iQueneHead] = null;

		m_iQueneHead++;
		if (m_iQueneHead >= DEF_MSGQUENESIZE)
			m_iQueneHead = 0;

		
		return true;
	}

	boolean bPutMsgQuene(byte[] pData, int szMsgSize) {

		if (m_pMsgQuene[m_iQueneTail] != null) {

			return false;

		}

		m_pMsgQuene[m_iQueneTail] = new MsgQue();

		if (m_pMsgQuene[m_iQueneTail].bPut(pData, szMsgSize) == false) {

			return false;
		}

		m_iQueneTail++;
		if (m_iQueneTail >= DEF_MSGQUENESIZE)
			m_iQueneTail = 0;

		return true;

	}

	

	void quit() throws IOException 
	{

		_isThreadRunning = false;

		_socket.setSoTimeout(100);
		_socket.shutdownInput();
	}

	

	String cryptPassword(String username, String password, char[] salt) {

		String result = new String();

		String code = username + password + "UltimateArena";

		result = SHA1.calcSHA1(code);

		char[] saltcode = new char[40];

		System.arraycopy(salt, 0, saltcode, 0, 40);

		result += new String(saltcode);

		result = SHA1.calcSHA1(result);

		return result;

	}

	void handleContactPlayingGame(byte[] pBuffer, int MsgSize) {

		int gameid;
		short usercount;

		int ptr = 0;

		ptr += 6;

		if (pBuffer[ptr + 0] == 's' && pBuffer[ptr + 1] == 'i'
				&& pBuffer[ptr + 2] == 'd') {

			ptr += 5;

			usercount = (short) pBuffer[(ptr + 1)]; // 16
			usercount <<= 8;
			usercount |= (short) (0xFF & pBuffer[(ptr)]); // 15

			ptr += 2;
			byte[] sid = new byte[16 * usercount];

			for (int k = 0; k < usercount; k++) {

				System.arraycopy(pBuffer, ptr, sid, k * 16, 16);
				ptr += 16;

			}

			ptr += 1;

			// 
			if (pBuffer[ptr + 0] == 'g' && pBuffer[ptr + 1] == 'a'
					&& pBuffer[ptr + 2] == 'm' && pBuffer[ptr + 3] == 'e'
					&& pBuffer[ptr + 4] == 'i' && pBuffer[ptr + 5] == 'd') {

				ptr += 8;

				short gameidscount;

				gameidscount = (short) pBuffer[(ptr + 1)]; // 16
				gameidscount <<= 8;
				gameidscount |= (short) (0xFF & pBuffer[(ptr)]); // 15

				ptr += 2;

				for (int i = 0; i < gameidscount; i++) {

					gameid = (int) pBuffer[(ptr + 3)] & 0xFF; // 16
					gameid <<= 8;
					gameid |= (int) (0xFF & pBuffer[(ptr + 2)]); // 15

					gameid <<= 8;
					gameid |= (int) (0xFF & pBuffer[(ptr + 1)]); // 15

					gameid <<= 8;
					gameid |= (int) (0xFF & pBuffer[(ptr)]); // 15

					byte[] usersid = new byte[16];

					System.arraycopy(sid, i * 16, usersid, 0, 16);
	
					getFriendsEventListener().friendGameStateChanged(usersid, gameid);

				}

			}

		}

		// Log.v(TAG,"leave handleContactPlayingGame");

	}

	void handleContactStatusMessagePacket(byte[] pBuffer, int MsgSize) {

		int ptr = 0;

		byte[] status_msg;// =new byte[0x100];

		ptr += 6;

		if (pBuffer[ptr + 0] == 's' && pBuffer[ptr + 1] == 'i'
				&& pBuffer[ptr + 2] == 'd') {

			ptr += 3;

			ptr += 2;

			short sids_count = (short) (pBuffer[ptr + 1] & 0xFF); // 16
			sids_count <<= 8;
			sids_count |= (short) (0xFF & pBuffer[(ptr)]); // 15

			byte[] sid = new byte[16 * sids_count];

			ptr += 2;

			for (int k = 0; k < sids_count; k++) {

				System.arraycopy(pBuffer, ptr, sid, k * 16, 16);

				ptr += 16;

			}

			ptr += 1;

			if (pBuffer[ptr + 0] == 'm' && pBuffer[ptr + 1] == 's'
					&& pBuffer[ptr + 2] == 'g') {

				ptr += 3;

				ptr += 2;

				short msgs_count = (short) (pBuffer[ptr + 1] & 0xFF); // 16
				msgs_count <<= 8;
				msgs_count |= (short) (0xFF & pBuffer[(ptr)]); // 15

				ptr += 2;

				for (int i = 0; i < msgs_count; i++) {

					short msg_len = (short) pBuffer[ptr + 1]; // 16
					msg_len <<= 8;
					msg_len |= (short) (0xFF & pBuffer[ptr]); // 15

					ptr += 2;

					status_msg = new byte[msg_len];

					System.arraycopy(pBuffer, ptr, status_msg, 0, msg_len);

					ptr += msg_len;

					byte[] usersid = new byte[16];

					System.arraycopy(sid, i * 16, usersid, 0, 16);
					
					if (msg_len==0) continue;

					String smsg;
					try {

						smsg = new String(status_msg, "UTF-8");
						
						getFriendsEventListener().friendStatusChanged(usersid, smsg);

					} catch (UnsupportedEncodingException e) {

						Log.v(TAG, "handleContactStatusMessagePacket ERROR");
						e.printStackTrace();
					}

				}

			}

		} else {

			Log.v(TAG, "ERROR 2!!!\n");
			// Log.v(TAG,byteArrayToHexString(new
			// String(pBuffer).getBytes(),MsgSize));

		}
		// Log.v(TAG,"leave handleContactStatusMessagePacket "+MsgSize);

	}

	void HandleAuth(byte[] pBuffer, int MsgSize) throws Exception {

		char[] salt = new char[5];

		// 2 bytes length
		// 1 byte type
		// 2 byte length

		StringBuffer stringBuffer = new StringBuffer(new String(pBuffer));
		stringBuffer.getChars(6, 11, salt, 0);

		byte[] cPacket = new byte[0x400];

		if (salt[0] == 's' && salt[1] == 'a' && salt[2] == 'l'
				&& salt[3] == 't') {

			char[] saltcode = new char[41];

			stringBuffer.getChars(13, 54, saltcode, 0);

			cPacket[0] = (byte) (_username.length() + 0x61);
			cPacket[1] = 0x00;
			cPacket[2] = 0x01;
			cPacket[3] = 0x00;
			cPacket[4] = 0x03;
			cPacket[5] = 0x04;

			byte[] name = { 'n', 'a', 'm', 'e' };

			System.arraycopy(name, 0, cPacket, 6, 4);

			cPacket[10] = 0x01;

			cPacket[11] = (byte) (_username.length());

			cPacket[12] = 0;

			System.arraycopy(_username.getBytes(), 0, cPacket, 13, _username
					.length());

			cPacket[12 + _username.length() + 1] = 0x08;

			byte[] password = { 'p', 'a', 's', 's', 'w', 'o', 'r', 'd' };

			System.arraycopy(password, 0, cPacket, 12 + _username.length() + 2,
					8);

			cPacket[12 + _username.length() + 2 + 8] = 0x01;
			cPacket[12 + _username.length() + 2 + 8 + 1] = 0x28;
			cPacket[12 + _username.length() + 2 + 8 + 1 + 1] = 0x00;

			String cryptPass = cryptPassword(_username, _password, saltcode);

			System.arraycopy(cryptPass.getBytes(), 0, cPacket, 12
					+ _username.length() + 2 + 8 + 1 + 1 + 1, 40);

			_out.write(cPacket, 0, (_username.length() + 0x61));
			_out.flush();

		}

	}

	private void Login()
	{

		byte[] uat = { 0x55, 0x41, 0x30, 0x31 };

		byte[] version = { 0x12, 0x00, 0x03, 0x00, 0x01, 0x07, 0x76, 0x65,
				0x72, 0x73, 0x69, 0x6f, 0x6e, // version
				0x02, 0x77, 0x77, // 1.87
				0x77, 0x77 };

		try {

			_out.write(uat, 0, 4);
			_out.flush();
			_out.write(version, 0, 18);
			_out.flush();

		} catch (Exception e)

		{

		}

	}

	private void HandleFriendsOfFriends(byte[] pBuffer, int MsgSize) {

		Log.v(TAG, "Enter HandleFriendsOfFriends");
		int ptr = 0;
		ptr += 5;

		if (pBuffer[ptr] != 5)
			return;

		ptr += 1;

		if (pBuffer[ptr] == 'f' && pBuffer[ptr + 1] == 'n'
				&& pBuffer[ptr + 2] == 's' && pBuffer[ptr + 3] == 'i'
				&& pBuffer[ptr + 4] == 'd') {

			ptr += 5;

			ptr += 2;

			int nsids = (short) pBuffer[ptr + 1] & 0xFF; // 16
			nsids <<= 8;
			nsids |= (short) (0xFF & pBuffer[(ptr)]); // 15

			ptr += 2;
			Log.v(TAG, "FSID was found " + nsids);

			ptr += 16 * nsids;

			if (pBuffer[ptr] != 6)
				return;

			ptr += 1;

			if (pBuffer[ptr] == 'u' && pBuffer[ptr + 1] == 's'
					&& pBuffer[ptr + 2] == 'e' && pBuffer[ptr + 3] == 'r'
					&& pBuffer[ptr + 4] == 'i' && pBuffer[ptr + 5] == 'd') {

				ptr += 6;

				ptr += 2;

				int nuserid = (short) pBuffer[ptr + 1] & 0xFF; // 16
				nuserid <<= 8;
				nuserid |= (short) (0xFF & pBuffer[(ptr)]); // 15

				ptr += 2;
				Log.v(TAG, "USERID was found " + nuserid);

				ptr += 4 * nuserid;

				if (pBuffer[ptr] != 4)
					return;

				ptr += 1;

				if (pBuffer[ptr] == 'n' && pBuffer[ptr + 1] == 'a'
						&& pBuffer[ptr + 2] == 'm' && pBuffer[ptr + 3] == 'e') {

					ptr += 4;

					ptr += 2;

					int nnames = (short) pBuffer[ptr + 1] & 0xFF; // 16
					nnames <<= 8;
					nnames |= (short) (0xFF & pBuffer[(ptr)]); // 15

					Log.v(TAG, "NAME was found " + nnames);

					ptr += 2;

					for (int i = 0; i < nnames; i++) {

						int namelen = (short) pBuffer[ptr + 1] & 0xFF; // 16
						namelen <<= 8;
						namelen |= (short) (0xFF & pBuffer[(ptr)]); // 15

						ptr += 2;
						/*
						 * if (namelen>0){
						 * 
						 * char []cUsername=new char[namelen];
						 * System.arraycopy(pBuffer,ptr,cUsername,0,namelen);
						 * 
						 * Log.v(TAG,"NAME = "+new String(cUsername));
						 * 
						 * }
						 */

						ptr += namelen;

					}

					if (pBuffer[ptr] != 4)
						return;

					ptr += 1;

					if (pBuffer[ptr] == 'n' && pBuffer[ptr + 1] == 'i'
							&& pBuffer[ptr + 2] == 'c'
							&& pBuffer[ptr + 3] == 'k') {

						ptr += 4;
						ptr += 2;

						int nnicks = (short) pBuffer[ptr + 1] & 0xFF; // 16
						nnicks <<= 8;
						nnicks |= (short) (0xFF & pBuffer[(ptr)]); // 15

						ptr += 2;

						for (int i = 0; i < nnicks; i++) {

							int namelen = (short) pBuffer[ptr + 1] & 0xFF; // 16
							namelen <<= 8;
							namelen |= (short) (0xFF & pBuffer[(ptr)]); // 15

							ptr += 2;

							ptr += namelen;

						}

						Log.v(TAG, "NICK was found " + nnames);
						if (pBuffer[ptr] != 7)
							return;

						ptr += 1;
						Log.v(TAG, "friends was found " + nnames);

					}

				}

			}

		}

	}

	private void HandleBuddyStatus(byte[] pBuffer, int MsgSize) {

		// Log.v(TAG,"Enter HandleBuddyStatus "+pBuffer.length);

		int dwNumOfUserid, dwNumOfSid;
		int dwUserID;
		
		byte[] sid = new byte[16];

		int ptr;
		ptr = 6;

		if (pBuffer[ptr + 0] == 'u' && pBuffer[ptr + 1] == 's'
				&& pBuffer[ptr + 2] == 'e' &&

				pBuffer[ptr + 3] == 'r' && pBuffer[ptr + 4] == 'i'
				&& pBuffer[ptr + 5] == 'd') {

			ptr += 6;

			ptr += 2;

			dwNumOfUserid = (short) pBuffer[ptr + 1] & 0xFF; // 16
			dwNumOfUserid <<= 8;
			dwNumOfUserid |= (short) (0xFF & pBuffer[(ptr)]); // 15

			ptr += 2;

			int[] pUsersid = new int[dwNumOfUserid + 1];

			for (int i = 0; i < dwNumOfUserid; i++) {

				dwUserID = (int) pBuffer[(ptr + 3)] & 0xFF; // 16

				dwUserID <<= 8;
				dwUserID |= (int) (0xFF & pBuffer[(ptr + 2)]); // 15

				dwUserID <<= 8;
				dwUserID |= (int) (0xFF & pBuffer[(ptr + 1)]); // 15

				dwUserID <<= 8;
				dwUserID |= (int) (0xFF & pBuffer[(ptr)]); // 15

				pUsersid[i] = dwUserID;

				ptr += 4;

			}

			ptr += 1;

			if (pBuffer[ptr + 0] == 's' && pBuffer[ptr + 1] == 'i'
					&& pBuffer[ptr + 2] == 'd') {

				ptr += 3;

				ptr += 2;
				dwNumOfSid = (short) pBuffer[(ptr + 1)]; // 16
				dwNumOfSid <<= 8;
				dwNumOfSid |= (short) (0xFF & pBuffer[(ptr)]); // 15

				ptr += 2;

				for (short j = 0; j < dwNumOfSid; j++) {

					for (int t = 0; t < 16; t++) {

						sid[t] = 0;

					}

					System.arraycopy(pBuffer, ptr, sid, 0, 16);

					boolean isZero = true;

					for (int t = 0; t < 16; t++) {
						if (sid[t] != 0) {

							isZero = false;
							break;

						}

					}

					XfireContact xcontact = null;
					xcontact = CoreService.getContactByID(pUsersid[j]);

					if (xcontact == null) {

						System.out
								.println("call to get Clan memberrrrrr return NULL");

						return;

					}

					xcontact._imindex = 0;
					System.arraycopy(pBuffer, ptr, xcontact._sid, 0, 16);

					if (isZero) {

						
							
							getFriendsEventListener().Removefriend( pUsersid[j], "");
							

					} else {

						
							getFriendsEventListener().Addfriend(pUsersid[j], "", "");
							
						

					}

					ptr += 16;
				}
			}

		}

		// Log.v(TAG,"Leave HandleBuddyStatus "+pBuffer.length);
	}

	@SuppressWarnings("unchecked")
	private void handleContactsPacket(byte[] pBuffer, short MsgSize) 
	{

		Log.v(TAG, "Enter handleContactsPacket " + MsgSize + " VS "+ pBuffer.length);

		short uNumOfFriends, uFriendNameLength, uNumOfNicks, uNickNameLength, uNumOfUserID;

		short cp = 6;

		if (pBuffer[cp] == 'f' && pBuffer[cp + 1] == 'r'
				&& pBuffer[cp + 2] == 'i' && pBuffer[cp + 3] == 'e'
				&& pBuffer[cp + 4] == 'n' && pBuffer[cp + 5] == 'd'
				&& pBuffer[cp + 6] == 's') {

			cp += 7;

			uNumOfFriends = (short) (pBuffer[cp + 3] & 0xFF); // 16
			uNumOfFriends <<= 8;
			uNumOfFriends |= (short) (0xFF & pBuffer[cp + 2]); // 15

			CoreService._nTotalContacts = uNumOfFriends;

			cp += 2;
			short i = 0;

			for (i = 0; i < uNumOfFriends; i++) {

				short ptr = (short) ((i + 1) * 2 + cp);

				uFriendNameLength = (short) pBuffer[(ptr + 1)]; // 18
				uFriendNameLength <<= 8;
				uFriendNameLength |= (short) (0xFF & pBuffer[(ptr)]); // 17

				byte[] cFriend = new byte[uFriendNameLength];

				for (short t = 0; t < uFriendNameLength; t++) {

					cFriend[t] = pBuffer[ptr + 2 + t];

				}

				CoreService._FriendsList.add(new XfireContact());

				XfireContact xcontact = (XfireContact) CoreService._FriendsList
						.get(i);

				xcontact._cNickname = null;

				xcontact._cUsername = new byte[uFriendNameLength];

				System.arraycopy(cFriend, 0, xcontact._cUsername, 0,
						uFriendNameLength);

				CoreService._FriendsList.set(i, xcontact);

				cp += uFriendNameLength;

			}

			cp += ((i + 1) * 2);

			cp += 1;

			if (pBuffer[cp] == 'n' && pBuffer[cp + 1] == 'i'
					&& pBuffer[cp + 2] == 'c' && pBuffer[cp + 3] == 'k') {

				cp += 4;

				cp += 2;

				uNumOfNicks = (short) (pBuffer[(cp + 1)] & 0xFF); // 16
				uNumOfNicks <<= 8;
				uNumOfNicks |= (short) (0xFF & pBuffer[cp]); // 15

				cp += 2;

				for (i = 0; i < uNumOfNicks; i++) {

					short ptr = (short) (i * 2 + cp);

					uNickNameLength = (short) ((short) pBuffer[ptr + 1] & 0xFF); // 18
					uNickNameLength <<= 8;
					uNickNameLength |= (short) (0xFF & pBuffer[ptr]); // 17

					byte[] nickname = new byte[uNickNameLength];

					for (short t = 0; t < uNickNameLength; t++) {

						nickname[t] = (byte) pBuffer[ptr + 2 + t];

					}

					XfireContact xcontact = (XfireContact) CoreService._FriendsList
							.get(i);

					if (uNickNameLength != 0) {

						xcontact._cNickname = new byte[uNickNameLength];

						System.arraycopy(nickname, 0, xcontact._cNickname, 0,
								uNickNameLength);
					} else {

						xcontact._cNickname = new byte[xcontact._cUsername.length];
						

						System.arraycopy(new String(xcontact._cUsername)
								.getBytes(), 0, xcontact._cNickname, 0,
								xcontact._cUsername.length);

					}

					CoreService._FriendsList.set(i, xcontact);

					cp += uNickNameLength;

				}

				cp += i * 2;

				cp += 1;

				if (pBuffer[cp + 0] == 'u' && pBuffer[cp + 1] == 's'
						&& pBuffer[cp + 2] == 'e' && pBuffer[cp + 3] == 'r'
						&& pBuffer[cp + 4] == 'i' && pBuffer[cp + 5] == 'd') {

					cp += 6;

					cp += 2;

					uNumOfUserID = (short) pBuffer[(cp + 1)]; // 16
					uNumOfUserID <<= 8;
					uNumOfUserID |= (short) (0xFF & pBuffer[(cp)]); // 15

					cp += 2;

					for (i = 0; i < uNumOfUserID; i++) {

						int dwUserID = (int) pBuffer[(cp + 3)] & 0xFF; // 16

						dwUserID <<= 8;
						dwUserID |= (int) (0xFF & pBuffer[(cp + 2)]); // 15

						dwUserID <<= 8;
						dwUserID |= (int) (0xFF & pBuffer[(cp + 1)]); // 15

						dwUserID <<= 8;
						dwUserID |= (int) (0xFF & pBuffer[(cp)]); // 15

						XfireContact xcontact = (XfireContact) CoreService._FriendsList
								.get(i);

						xcontact._userid = dwUserID;
						xcontact._uStatus = 0;
						CoreService._FriendsList.set(i, xcontact);

						cp += 4;

					}

				}

			}

		}
		Log.v(TAG, "Leave handleContactsPacket 444");

	}

	void sendChangeNickPacket(char[] nickname) throws IOException {

		byte[] nick_pkt = new byte[0x100];

		int ptr = 2;
		nick_pkt[ptr++] = 0x0e;
		nick_pkt[ptr++] = 0x00;
		nick_pkt[ptr++] = 0x01;
		nick_pkt[ptr++] = 0x04;// nick strlen
		nick_pkt[ptr++] = 0x6e;// n
		nick_pkt[ptr++] = 0x69;// i
		nick_pkt[ptr++] = 0x63;// c
		nick_pkt[ptr++] = 0x6b;// k
		nick_pkt[ptr++] = 0x01;
		nick_pkt[ptr++] = (byte) nickname.length;
		nick_pkt[ptr++] = 0x00;

		System.arraycopy(new String(nickname).getBytes(), 0, nick_pkt, ptr,
				nickname.length);

		ptr += nickname.length;

		nick_pkt[0] = (byte) ptr;
		nick_pkt[1] = 0x00;

		_out.write(nick_pkt, 0, ptr);
		_out.flush();

	}

	void sendMyStatusMessagePacket(char[] pStatusMsg) throws IOException {

		byte[] cMyStatusPkt = new byte[0x100];

		int ptr = 2;

		cMyStatusPkt[ptr++] = 0x20;
		cMyStatusPkt[ptr++] = 0x00;

		cMyStatusPkt[ptr++] = 0x01;
		cMyStatusPkt[ptr++] = 0x2E;
		cMyStatusPkt[ptr++] = 0x01;

		cMyStatusPkt[ptr++] = (byte) pStatusMsg.length;
		cMyStatusPkt[ptr++] = 0x00;

		System.arraycopy(new String(pStatusMsg).getBytes(), 0, cMyStatusPkt,
				ptr, pStatusMsg.length);

		ptr += pStatusMsg.length;

		cMyStatusPkt[0] = (byte) (pStatusMsg.length + 9);
		cMyStatusPkt[1] = 0x00;

		_out.write(cMyStatusPkt, 0, (pStatusMsg.length + 9));
		_out.flush();

	}

	/*
	 * 000001DA 6d 00 05 00 01 03 73 69 64 04 03 06 00 16 a3 a8 m.....si
	 * d....... 000001EA 51 6b 92 f5 c8 ec f5 6b 0f 2a 23 38 27 16 c6 40
	 * Qk.....k .*#8'..@ 000001FA b1 b4 c3 ce 1b 7c bc 85 d8 36 2e f7 32 16 96
	 * 87 .....|.. .6..2... 0000020A fd ad b8 e4 74 a6 a3 a6 22 b1 bb 40 6c 16
	 * 35 ac ....t... "..@l.5. 0000021A 8f 0c 6e e8 e8 84 2f fd 37 07 37 08 d0
	 * 16 97 55 ..n.../. 7.7....U 0000022A 15 58 a0 29 57 4c 30 37 3e 31 df 74
	 * 6b 16 46 12 .X.)WL07 >1.tk.F. 0000023A a4 95 5c df 15 6a 11 3e b7 b1 ec
	 * 66 aa ..\..j.> ...f.
	 */

	void sendRequestForFriendPacket(byte[] pSid) throws IOException {

		return;
		/*
		 * byte []pkt=new byte[0x400]; int ptr=2; pkt[ptr++]=5; //packet id
		 * pkt[ptr++]=0;
		 * 
		 * pkt[ptr++]=1; pkt[ptr++]=3; pkt[ptr++]='s'; pkt[ptr++]='i';
		 * pkt[ptr++]='d'; pkt[ptr++]=4; pkt[ptr++]=3; pkt[ptr++]=1;
		 * pkt[ptr++]=0;
		 * 
		 * System.arraycopy(pSid,0,pkt,ptr,16); ptr+=16;
		 * 
		 * pkt[0]=(byte)ptr; pkt[1]=0;
		 * 
		 * _out.write(pkt, 0,ptr); _out.flush();
		 */

	}

	/*
	 * 00000000 29 00 0c 00 04 04 6e 61 6d 65 01 01 00 78 05 66 ).....na
	 * me...x.f 00000010 6e 61 6d 65 01 00 00 05 6c 6e 61 6d 65 01 00 00
	 * name.... lname... 00000020 05 65 6d 61 69 6c 01 00 00
	 */

	void sendSearchPacket(char[] pBuffer) throws IOException 
	{
		byte[] pkt = new byte[0x400];
		Log.v(TAG, "Enter sendSearchPacket");

		int ptr = 2;

		pkt[ptr++] = 0x0C; // packet id
		pkt[ptr++] = 0;
		pkt[ptr++] = 4; // attrib number

		pkt[ptr++] = 4;
		pkt[ptr++] = 'n';
		pkt[ptr++] = 'a';
		pkt[ptr++] = 'm';
		pkt[ptr++] = 'e';
		pkt[ptr++] = 1;

		int msg_len = pBuffer.length;
		pkt[ptr++] = (byte) (msg_len >> 0 & 0xFF);
		pkt[ptr++] = (byte) ((msg_len >> 8) & 0xFF);

		System.arraycopy(new String(pBuffer).getBytes(), 0, pkt, ptr,
				pBuffer.length);

		ptr += pBuffer.length;

		pkt[ptr++] = 5;
		pkt[ptr++] = 'f';
		pkt[ptr++] = 'n';
		pkt[ptr++] = 'a';
		pkt[ptr++] = 'm';
		pkt[ptr++] = 'e';
		pkt[ptr++] = 1; // packet id
		pkt[ptr++] = 0;
		pkt[ptr++] = 0; // attrib number

		pkt[ptr++] = 5;
		pkt[ptr++] = 'l';
		pkt[ptr++] = 'n';
		pkt[ptr++] = 'a';
		pkt[ptr++] = 'm';
		pkt[ptr++] = 'e';
		pkt[ptr++] = 1; // packet id
		pkt[ptr++] = 0;
		pkt[ptr++] = 0; // attrib number

		pkt[ptr++] = 5;
		pkt[ptr++] = 'e';
		pkt[ptr++] = 'm';
		pkt[ptr++] = 'a';
		pkt[ptr++] = 'i';
		pkt[ptr++] = 'l';
		pkt[ptr++] = 1; // packet id
		pkt[ptr++] = 0;
		pkt[ptr++] = 0; // attrib number

		msg_len = ptr;
		pkt[0] = (byte) (msg_len >> 0 & 0xFF);
		pkt[1] = (byte) ((msg_len >> 8) & 0xFF);

		_out.write(pkt, 0, ptr);
		_out.flush();

	}

	void sendIMPacket(byte[] pSid, char[] pBuffer) throws IOException {

		Log.v(TAG, "Enter sendIMPacket");

		byte[] pkt = new byte[0x400];

		int ptr = 2;
		pkt[ptr++] = 2; // packet id
		pkt[ptr++] = 0;
		pkt[ptr++] = 2; // attrib number

		// SID
		pkt[ptr++] = 3;
		pkt[ptr++] = 's';
		pkt[ptr++] = 'i';
		pkt[ptr++] = 'd';
		pkt[ptr++] = 3;

		System.arraycopy(pSid, 0, pkt, ptr, 16);
		ptr += 16;

		// PEERMSG
		pkt[ptr++] = 7;
		pkt[ptr++] = 'p';
		pkt[ptr++] = 'e';
		pkt[ptr++] = 'e';
		pkt[ptr++] = 'r';
		pkt[ptr++] = 'm';
		pkt[ptr++] = 's';
		pkt[ptr++] = 'g';

		pkt[ptr++] = 5;
		pkt[ptr++] = 3;

		// /MSGTYPE
		pkt[ptr++] = 7;

		pkt[ptr++] = 'm';
		pkt[ptr++] = 's';
		pkt[ptr++] = 'g';
		pkt[ptr++] = 't';
		pkt[ptr++] = 'y';
		pkt[ptr++] = 'p';
		pkt[ptr++] = 'e';

		pkt[ptr++] = 2;

		pkt[ptr++] = 0;
		pkt[ptr++] = 0;
		pkt[ptr++] = 0;
		pkt[ptr++] = 0;

		// IMINDEX
		pkt[ptr++] = 7;
		pkt[ptr++] = 'i';
		pkt[ptr++] = 'm';
		pkt[ptr++] = 'i';
		pkt[ptr++] = 'n';
		pkt[ptr++] = 'd';
		pkt[ptr++] = 'e';
		pkt[ptr++] = 'x';

		pkt[ptr++] = 2;

		XfireContact xcontact = null;

		xcontact = CoreService.getContactBySID(pSid);

		if (xcontact == null)
			return;

		int imindex = 0;

		imindex = xcontact._imindex;
		xcontact._imindex++;

		// imindex data
		pkt[ptr++] = (byte) (imindex >> 0 & 0xFF);
		pkt[ptr++] = (byte) ((imindex >> 8) & 0xFF);
		pkt[ptr++] = (byte) ((imindex >> 16) & 0xFF);
		;
		pkt[ptr++] = (byte) ((imindex >> 24) & 0xFF);
		;

		pkt[ptr++] = 2;

		pkt[ptr++] = 'i';
		pkt[ptr++] = 'm';

		pkt[ptr++] = 1;

		int msg_len = pBuffer.length;
		pkt[ptr++] = (byte) (msg_len >> 0 & 0xFF);
		pkt[ptr++] = (byte) ((msg_len >> 8) & 0xFF);

		System.arraycopy(new String(pBuffer).getBytes(), 0, pkt, ptr,
				pBuffer.length);

		ptr += pBuffer.length;

		msg_len = ptr;
		pkt[0] = (byte) (msg_len >> 0 & 0xFF);
		pkt[1] = (byte) ((msg_len >> 8) & 0xFF);

		/*
		 * pkt[ptr++]=(byte)pBuffer.length; pkt[ptr++]=0;
		 * 
		 * System.arraycopy(new
		 * String(pBuffer).getBytes(),0,pkt,ptr,pBuffer.length);
		 * 
		 * ptr+=pBuffer.length;
		 * 
		 * 
		 * pkt[0]=(byte)ptr; pkt[1]=0;
		 */

		try {

			String XfMobile = _myNickname;

			XfMobile += "[XFMobile]";
			ModifyNick(XfMobile);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		_out.write(pkt, 0, ptr);
		_out.flush();

		try {
			Thread.currentThread().sleep(10);
			ModifyNick(_myNickname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Log.v(TAG, "Leave sendIMPacket");

	}

	/*
	 * void sendIMPacket(byte []pSid,char[]pBuffer) throws IOException {
	 * 
	 * 
	 * 
	 * 
	 * 
	 * Log.v(TAG,"Enter sendIMPacket");
	 * 
	 * byte []pkt=new byte[0x400];
	 * 
	 * int ptr=2; pkt[ptr++]=2; //packet id pkt[ptr++]=0; pkt[ptr++]=2; //attrib
	 * number
	 * 
	 * 
	 * //SID pkt[ptr++]=3; pkt[ptr++]='s'; pkt[ptr++]='i'; pkt[ptr++]='d';
	 * pkt[ptr++]=3;
	 * 
	 * System.arraycopy(pSid,0,pkt,ptr,16); ptr+=16;
	 * 
	 * //PEERMSG pkt[ptr++]=7; pkt[ptr++]='p'; pkt[ptr++]='e'; pkt[ptr++]='e';
	 * pkt[ptr++]='r'; pkt[ptr++]='m'; pkt[ptr++]='s'; pkt[ptr++]='g';
	 * 
	 * pkt[ptr++]=5; pkt[ptr++]=3;
	 * 
	 * ///MSGTYPE pkt[ptr++]=7;
	 * 
	 * pkt[ptr++]='m'; pkt[ptr++]='s'; pkt[ptr++]='g'; pkt[ptr++]='t';
	 * pkt[ptr++]='y'; pkt[ptr++]='p'; pkt[ptr++]='e';
	 * 
	 * pkt[ptr++]=2;
	 * 
	 * pkt[ptr++]=0; pkt[ptr++]=0; pkt[ptr++]=0; pkt[ptr++]=0;
	 * 
	 * 
	 * //IMINDEX pkt[ptr++]=7; pkt[ptr++]='i'; pkt[ptr++]='m'; pkt[ptr++]='i';
	 * pkt[ptr++]='n'; pkt[ptr++]='d'; pkt[ptr++]='e'; pkt[ptr++]='x';
	 * 
	 * pkt[ptr++]=2;
	 * 
	 * XfireContact xcontact=null;
	 * 
	 * xcontact=CoreService.getContactBySID(pSid);
	 * 
	 * 
	 * if (xcontact==null){
	 * 
	 * 
	 * 
	 * xcontact=ContactScreen.getClanMemberbySID(pSid); } if (xcontact==null) {
	 * 
	 * System.out.print("no contact was found to send IM"); return; }
	 * 
	 * 
	 * int imindex=0 ;
	 * 
	 * 
	 * 
	 * 
	 * if (xcontact._imindex!=0){
	 * 
	 * xcontact._imindex++; } imindex=xcontact._imindex;
	 * 
	 * //imindex data pkt[ptr++]=(byte)(imindex>>0&0xFF);
	 * pkt[ptr++]=(byte)((imindex>>8)&0xFF);
	 * pkt[ptr++]=(byte)((imindex>>24)&0xFF);;
	 * 
	 * 
	 * 
	 * pkt[ptr++]=2;
	 * 
	 * 
	 * pkt[ptr++]='i'; pkt[ptr++]='m';
	 * 
	 * pkt[ptr++]=1;
	 * 
	 * int msg_len=pBuffer.length; pkt[ptr++]=(byte)(msg_len>>0&0xFF);
	 * pkt[ptr++]=(byte)((msg_len>>8)&0xFF);
	 * 
	 * System.arraycopy(new
	 * String(pBuffer).getBytes(),0,pkt,ptr,pBuffer.length);
	 * 
	 * ptr+=pBuffer.length;
	 * 
	 * 
	 * 
	 * msg_len=ptr; pkt[0]=(byte)(msg_len>>0&0xFF);
	 * pkt[1]=(byte)((msg_len>>8)&0xFF);
	 * 
	 * 
	 * 
	 * 
	 * try {
	 * 
	 * String XfMobile=_myNickname;
	 * 
	 * XfMobile+="[XFMobile]"; ModifyNick(XfMobile);
	 * 
	 * } catch (Exception e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * 
	 * _out.write(pkt, 0,ptr); _out.flush();
	 * 
	 * try { Thread.currentThread().sleep(10); ModifyNick(_myNickname); } catch
	 * (Exception e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * 
	 * 
	 * 
	 * Log.v(TAG,"Leave sendIMPacket");
	 * 
	 * 
	 * 
	 * }
	 */
	//	
	void handleReciveIMPacket(byte[] pBuffer, int MsgSize) throws IOException {

		byte[] output = new byte[0x100];
		byte[] cMsg;
		byte[] sid = new byte[16];
		int msgtype;

		int imIndex;

		int ptr = 0;

		ptr += 6;

		Log.v(TAG, "Enter  handleReciveIMPacket");
		if (pBuffer[ptr + 0] == 's' && pBuffer[ptr + 1] == 'i'
				&& pBuffer[ptr + 2] == 'd') {

			ptr += 3;
			ptr += 1;

			System.arraycopy(pBuffer, ptr, sid, 0, 16);

			ptr += 16;

			ptr += 1;

			/* get peer message */
			if (pBuffer[ptr + 0] == 'p' && pBuffer[ptr + 1] == 'e'
					&& pBuffer[ptr + 2] == 'e' && pBuffer[ptr + 3] == 'r'
					&& pBuffer[ptr + 4] == 'm' && pBuffer[ptr + 5] == 's'
					&& pBuffer[ptr + 6] == 'g') {

				ptr += 7;

				ptr += 1;

				ptr += 2;

				if (pBuffer[ptr + 0] == 'm' && pBuffer[ptr + 1] == 's'
						&& pBuffer[ptr + 2] == 'g' && pBuffer[ptr + 3] == 't'
						&& pBuffer[ptr + 4] == 'y' && pBuffer[ptr + 5] == 'p'
						&& pBuffer[ptr + 6] == 'e') {

					ptr += 7;// "strlen("msgtype_type")

					ptr += 1;

					msgtype = (int) pBuffer[(ptr + 3)] & 0xFF; // 16

					msgtype <<= 8;
					msgtype |= (int) (0xFF & pBuffer[(ptr + 2)]); // 15

					msgtype <<= 8;
					msgtype |= (int) (0xFF & pBuffer[(ptr + 1)]); // 15

					msgtype <<= 8;
					msgtype |= (int) (0xFF & pBuffer[(ptr + 0)]); // 15

					if (msgtype == 3) {

					
						//getFriendsEventListener().switchToTypingMode();
						return;
					}

					if (msgtype == 0) {// IM MSG

						ptr += 4;

						ptr += 1;

						if (pBuffer[ptr + 0] == 'i' && pBuffer[ptr + 1] == 'm'
								&& pBuffer[ptr + 2] == 'i'
								&& pBuffer[ptr + 3] == 'n'
								&& pBuffer[ptr + 4] == 'd'
								&& pBuffer[ptr + 5] == 'e'
								&& pBuffer[ptr + 6] == 'x') {

							ptr += 7;

							ptr += 1;

							imIndex = (int) pBuffer[(ptr + 3)] & 0xFF; // 16

							imIndex <<= 8;
							imIndex |= (int) (0xFF & pBuffer[(ptr + 2)]); // 15

							imIndex <<= 8;
							imIndex |= (int) (0xFF & pBuffer[(ptr + 1)]); // 15

							imIndex <<= 8;
							imIndex |= (int) (0xFF & pBuffer[(ptr)]); // 15

							ptr += 4;

							ptr += 1;

							if (pBuffer[ptr + 0] == 'i'
									&& pBuffer[ptr + 1] == 'm') {

								ptr += 2;
								ptr += 1;

								short msg_len = (short) pBuffer[(ptr + 1)]; // 16
								msg_len <<= 8;
								msg_len |= (short) (0xFF & pBuffer[(ptr)]); // 15

								ptr += 2;

								cMsg=new byte[msg_len];
								
							
									System.arraycopy(pBuffer, ptr, cMsg, 0,
											msg_len);

									

							
									 getFriendsEventListener().messageReceived(sid,"",new String(cMsg, "UTF-8"));

								

								XfireContact xcontact = CoreService
										.getContactBySID(sid);

								xcontact._imindex = imIndex;

								System.arraycopy(pBuffer, 0, output, 0, 62);

								output[0] = 62;
								output[1] = 0;
								output[2] = 2;
								output[3] = 0;

								output[35] = 0x02;
								output[45] = 0x01;

								_out.write(output, 0, 62);
								_out.flush();

							}

						}

					}

				}

			}

		}

		Log.v(TAG, "Enter  handleReciveIMPacket");

	}

	/*
	 * 
	 * 00000035 0c 01 82 00 10 06 75 73 65 72 69 64 02 9f 85 6d ......us
	 * erid...m 00000045 00 03 73 69 64 03 21 af 55 11 d9 99 1d a1 f6 8c
	 * ..sid.!. U....... 00000055 6b 6c 2e 80 5f 46 04 6e 69 63 6b 01 0b 00 78
	 * 78 kl.._F.n ick...xx 00000065 78 78 78 78 78 78 78 78 78 06 73 74 61 74
	 * 75 73 xxxxxxxx x.status 00000075 02 7f 03 00 00 05 64 6c 73 65 74 01 00
	 * 00 06 70 ......dl set....p 00000085 32 70 73 65 74 01 00 00 07 63 6c 6e
	 * 74 73 65 74 2pset... .clntset 00000095 01 00 00 07 6d 69 6e 72 65 63 74
	 * 02 01 00 00 00 ....minr ect..... 000000A5 07 6d 61 78 72 65 63 74 02 84
	 * 03 00 00 04 63 74 .maxrect ......ct 000000B5 72 79 02 fa 00 00 00 02 6e
	 * 31 02 93 28 dc ce 02 ry...... n1..(... 000000C5 6e 32 02 94 28 dc ce 02
	 * 6e 33 02 95 28 dc ce 03 n2..(... n3..(... 000000D5 70 69 70 02 d5 77 a9
	 * 55 04 73 61 6c 74 01 2a 00 pip..w.U .salt.*. 000000E5 34 35 62 32 61 33
	 * 63 64 62 39 66 64 39 65 39 32 45b2a3cd b9fd9e92 000000F5 66 65 61 38 34
	 * 34 33 30 31 37 66 34 37 37 38 65 fea84430 17f4778e 00000105 37 33 63 63
	 * 31 30 63 38 33 63 06 72 65 61 73 6f 73cc10c8 3c.reaso 00000115 6e 01 28
	 * 00 68 6e 69 57 70 53 44 72 51 58 79 70 n.(.hniW pSDrQXyp 00000125 7a 51
	 * 75 70 72 34 64 62 6f 37 79 52 45 4e 46 58 zQupr4db o7yRENFX 00000135 63
	 * 6e 59 45 49 47 52 43 31 56 32 41 cnYEIGRC 1V2A
	 * 
	 * void CXfireCore::ModifyNick(char *pNickName) {
	 * 
	 * unsigned char cPkt[0x100]; int ptr=0; ptr+=2; cPkt[ptr++]=0x0E;
	 * cPkt[ptr++]=0x00; cPkt[ptr++]=0x01; cPkt[ptr++]=0x04;
	 * 
	 * 
	 * memcpy(&cPkt[ptr],"nick",4);
	 * 
	 * ptr+=4; cPkt[ptr++]=0x01;
	 * 
	 * cPkt[ptr++]=strlen(pNickName); cPkt[ptr++]=0;
	 * 
	 * 
	 * memcpy(&cPkt[ptr],pNickName,strlen(pNickName));
	 * 
	 * ptr+=strlen(pNickName); cPkt[0]=(char)ptr; cPkt[1]=0x00;
	 * 
	 * 
	 * AsyncSendBuff(cPkt,ptr);
	 * 
	 * 
	 * 
	 * 
	 * }
	 */

	private void ModifyNick(String nickname) throws Exception

	{

		byte[] cPkt = new byte[0x100];
		int ptr = 0;
		ptr += 2;

		cPkt[ptr++] = 0x0E;
		cPkt[ptr++] = 0x00;
		cPkt[ptr++] = 0x01;
		cPkt[ptr++] = 0x04;

		cPkt[ptr++] = 'n';
		cPkt[ptr++] = 'i';
		cPkt[ptr++] = 'c';
		cPkt[ptr++] = 'k';

		cPkt[ptr++] = 0x01;

		cPkt[ptr++] = (byte) (nickname.length());

		cPkt[ptr++] = 0;

		System.arraycopy(nickname.getBytes(), 0, cPkt, ptr, nickname.length());

		ptr += (byte) (nickname.length());
		cPkt[0] = (byte) ptr;
		cPkt[1] = 0x00;

		_out.write(cPkt, 0, ptr);
		_out.flush();

	}

	private void handleLoginSuccessPacket(byte[] pBuffer, int MsgSize) {

		int ptr = 0;

		ptr += 5; // header

		ptr += 7; // "userid"

		ptr += 4;

		ptr += 5; // sid

		ptr += 18;

		_myNickname = "Me";
		byte[] cNickname = new byte[0x100];

		for (int j = 0; j < 0x100; j++)
			cNickname[j] = 0;

		if (pBuffer[ptr] == 'n' && pBuffer[ptr + 1] == 'i'
				&& pBuffer[ptr + 2] == 'c' && pBuffer[ptr + 3] == 'k') {

			ptr += 4;

			ptr += 1;

			short nUserLen = (short) pBuffer[(ptr + 1)]; // 16
			nUserLen <<= 8;
			nUserLen |= (short) (0xFF & pBuffer[(ptr)]); // 15

			ptr += 2;

			System.arraycopy(pBuffer, ptr, cNickname, 0, nUserLen);
			Log.v(TAG, "NICK FOUND  cNickname= "
					+ new String(cNickname, 0, nUserLen));

			_myNickname = new String(cNickname, 0, nUserLen);

			if (nUserLen == 0) {

				_myNickname = new String("Me");
			}

		}

		ptr += 5;

	}

	private void HandleMismatchVersion(byte[] pBuffer, int MsgSize)
			throws Exception

	{

		byte[] version = { 0x12, 0x00, 0x03, 0x00, 0x01, 0x07, 0x76, 0x65,
				0x72, 0x73, 0x69, 0x6f, 0x6e, // version
				0x02, 0x00, 0x00, // 1.87
				0x00, 0x00 };

		char[] version_type = new char[8];
		StringBuffer stringBuffer = new StringBuffer(new String(pBuffer));
		stringBuffer.getChars(6, 14, version_type, 0);

		if (version_type[0] == 'v' && version_type[1] == 'e'
				&& version_type[2] == 'r' && version_type[3] == 's'
				&& version_type[4] == 'i' && version_type[5] == 'o'
				&& version_type[6] == 'n') {

			version[14] = (byte) (pBuffer[6 + 7 + 4]);

			_out.write(version, 0, version.length);
			_out.flush();

		}

	}

	private void handleClanBuddyNamesPacket(byte[] pBuffer)

	{
		// TODO Auto-generated method stub

		Log.v(TAG, "ENTER  handleClanBuddyNamesPacket");
		int ptr = 0;

		if (CoreService._nTotalClans>10) return;
		ptr += 7;

		int clanID = (int) pBuffer[(ptr + 3)] & 0xFF; // 16

		clanID <<= 8;
		clanID |= (int) (0xFF & pBuffer[(ptr + 2)]); // 15

		clanID <<= 8;
		clanID |= (int) (0xFF & pBuffer[(ptr + 1)]); // 15

		clanID <<= 8;
		clanID |= (int) (0xFF & pBuffer[(ptr)]); // 15

		int nClanIndex = CoreService.getClanIndexByID(clanID);
		
		if (nClanIndex==-1) return;
		
		ptr += 4;

		ptr += 3;

		short clan_friends_count = (short) pBuffer[(ptr + 1)]; // 16
		clan_friends_count <<= 8;
		clan_friends_count |= (short) (0xFF & pBuffer[(ptr)]); // 15

		CoreService._ClansList[nClanIndex]._usercount = clan_friends_count;

		CoreService._ClansList[nClanIndex]._listContacts.clear();
		ptr += 2;

		int userid;
		for (int i = 0; i < clan_friends_count; i++) {

			userid = (int) pBuffer[(ptr + 3)] & 0xFF; // 16

			userid <<= 8;
			userid |= (int) (0xFF & pBuffer[(ptr + 2)]); // 15

			userid <<= 8;
			userid |= (int) (0xFF & pBuffer[(ptr + 1)]); // 15

			userid <<= 8;
			userid |= (int) (0xFF & pBuffer[(ptr)]); // 15

			ptr += 4;

			CoreService._ClansList[nClanIndex]._listContacts.add(new XfireContact());

			XfireContact xcontact = (XfireContact) CoreService._ClansList[nClanIndex]._listContacts
					.get(i);

			xcontact._userid = userid;

			CoreService._ClansList[nClanIndex]._listContacts.set(i, xcontact);

		}

		ptr += 5;

		byte[] cUsername = new byte[0x100];

		for (int i = 0; i < clan_friends_count; i++) {

			for (int j = 0; j < 0x100; j++) {
				
				cUsername[j] = 0;

			}

			short nUserLen = (short) pBuffer[(ptr + 1)]; // 16
			nUserLen <<= 8;
			nUserLen |= (short) (0xFF & pBuffer[(ptr)]); // 15

			ptr += 2;

			System.arraycopy(pBuffer, ptr, cUsername, 0, nUserLen);

			XfireContact xcontact = (XfireContact) CoreService._ClansList[nClanIndex]._listContacts
					.get(i);

		
			xcontact._cUsername = new byte[nUserLen + 1];
			System.arraycopy(cUsername, 0, xcontact._cUsername, 0, nUserLen);

			CoreService._ClansList[nClanIndex]._listContacts.set(i, xcontact);

			ptr += nUserLen;

		}

		ptr += 5;

		byte[] cNickname = new byte[0x100];

		for (int i = 0; i < clan_friends_count; i++) {

			for (int j = 0; j < 0x100; j++) {
				cNickname[j] = 0;
			}

			short nNickLen = (short) pBuffer[(ptr + 1)]; // 16
			nNickLen <<= 8;
			nNickLen |= (short) (0xFF & pBuffer[(ptr)]); // 15

			ptr += 2;

			System.arraycopy(pBuffer, ptr, cNickname, 0, nNickLen);

			XfireContact xcontact = (XfireContact) CoreService._ClansList[nClanIndex]._listContacts
					.get(i);

			xcontact._cNickname = new byte[nNickLen + 1];
			if (nNickLen==0) xcontact._cNickname[0]=0;
			System.arraycopy(cNickname, 0, xcontact._cNickname, 0, nNickLen);

			CoreService._ClansList[nClanIndex]._listContacts.set(i, xcontact);

			ptr += nNickLen;

		}

		Log.v(TAG, "LEAVE  handleClanBuddyNamesPacket");

	}

	private void handleClanPacket(byte[] pBuffer, int size)

	{

		System.out.println("Enter handleClansPacket ");

		int ptr = 0;

		ptr += 5;

		short clan_count = (short) pBuffer[(ptr + 4)]; // 16
		clan_count <<= 8;
		clan_count |= (short) (0xFF & pBuffer[(ptr + 3)]); // 15

		
		
		CoreService._nTotalClans = clan_count;
		
		if (CoreService._nTotalClans>10) return;
		
		int i;
		
		for (i=0; i<clan_count; i++)
    	{
			CoreService._ClansList[i]=new XfireClan();
			CoreService._ClansList[i]._listContacts.clear();
    	}

		ptr = ptr + 5;

		for (i = 0; i < clan_count; i++) {

			int clanID = (int) pBuffer[(ptr + 3)] & 0xFF; // 16

			clanID <<= 8;
			clanID |= (int) (0xFF & pBuffer[(ptr + 2)]); // 15

			clanID <<= 8;
			clanID |= (int) (0xFF & pBuffer[(ptr + 1)]); // 15

			clanID <<= 8;
			clanID |= (int) (0xFF & pBuffer[(ptr)]); // 15

			CoreService._ClansList[i]._id = clanID;

			ptr += 4;

		}
		ptr += 5;

		byte[] cClanName = new byte[0x100];

		for (i = 0; i < clan_count; i++) {

			for (int j = 0; j < 0x100; j++) {

				cClanName[j] = 0;

			}

			short clan_name_len = (short) pBuffer[(ptr + 1)]; // 16
			clan_name_len <<= 8;
			clan_name_len |= (short) (0xFF & pBuffer[(ptr)]); // 15

			ptr += 2;

			System.arraycopy(pBuffer, ptr, cClanName, 0, clan_name_len);

			System.arraycopy(cClanName, 0, CoreService._ClansList[i]._name, 0,
					clan_name_len);

			ptr += clan_name_len;
			
			getFriendsEventListener().addClanGroup(CoreService._ClansList[i]._name);

		}

		
	
		System.out.println("Leave handleClansPacket");

		ptr += 5;

	}

	public void KeepAlive() throws Exception {

		byte[] pkt = new byte[0x100];
		int ptr = 0;

		ptr += 2;

		pkt[ptr++] = 13;
		pkt[ptr++] = 0;
		pkt[ptr++] = 2;

		pkt[ptr++] = 0x05;
		pkt[ptr++] = 'v';
		pkt[ptr++] = 'a';
		pkt[ptr++] = 'l';
		pkt[ptr++] = 'u';
		pkt[ptr++] = 'e';

		pkt[ptr++] = 0x02;
		pkt[ptr++] = 0x00;
		pkt[ptr++] = 0x00;
		pkt[ptr++] = 0x00;
		pkt[ptr++] = 0x00;

		pkt[ptr++] = 0x05;
		pkt[ptr++] = 's';
		pkt[ptr++] = 't';
		pkt[ptr++] = 'a';
		pkt[ptr++] = 't';
		pkt[ptr++] = 's';

		pkt[ptr++] = 0x04;
		pkt[ptr++] = 0x02;
		pkt[ptr++] = 0x00;
		pkt[ptr++] = 0x00;

		pkt[0] = (byte) ptr;
		pkt[1] = 0x00;

		if (_out==null) return;
		_out.write(pkt, 0, ptr);
		_out.flush();

	}

	void AddBuddyPacket(byte[] pBuddyName) throws IOException {

		Log.v(TAG, "Enter  sendAddBuddyPacket  " + new String(pBuddyName));

		byte[] pkt = new byte[200];
		int ptr = 0;

		ptr += 2;

		pkt[ptr++] = 6;
		pkt[ptr++] = 0;
		pkt[ptr++] = 2;

		pkt[ptr++] = 4;
		pkt[ptr++] = 'n';
		pkt[ptr++] = 'a';
		pkt[ptr++] = 'm';
		pkt[ptr++] = 'e';

		pkt[ptr++] = 0x01;

		pkt[ptr++] = (byte) pBuddyName.length;

		pkt[ptr++] = 0;

		System.arraycopy(pBuddyName, 0, pkt, ptr, pBuddyName.length);
		ptr += pBuddyName.length;

		pkt[ptr++] = 3;// strlen(msg)

		pkt[ptr++] = 'm';
		pkt[ptr++] = 's';
		pkt[ptr++] = 'g';

		pkt[ptr++] = 1;
		pkt[ptr++] = 0;
		pkt[ptr++] = 0;

		pkt[0] = (byte) ptr;
		pkt[1] = 0x00;

		_out.write(pkt, 0, ptr);
		_out.flush();

		Log.v(TAG, "Leave  sendAddBuddyPacket  ");

	}

	private void HandleSearchFriends(byte[] pBuffer) {

		int ptr = 0;
		ptr += 5;

		if (pBuffer[ptr++] != 4)
			return;

		ptr += 4;// name

		ptr += 2;

		short friends_count = (short) pBuffer[(ptr + 1)]; // 16
		friends_count <<= 8;
		friends_count |= (short) (0xFF & pBuffer[(ptr)]); // 15

		ptr += 2;

		Log.v(TAG, "HandleSearchFriends count  " + friends_count);

		AddfriendsController._countfriendslist = friends_count;

		short i = 0;

		for (i = 0; i < friends_count; i++) {

			short uFriendNameLength = (short) pBuffer[(ptr + 1)]; // 18
			uFriendNameLength <<= 8;
			uFriendNameLength |= (short) (0xFF & pBuffer[(ptr)]); // 17

			ptr += 2;

			// byte []cFriend=new byte[uFriendNameLength];

			// AddfriendsController._friendsList[i].

			AddfriendsController._friendsList[i].username = new byte[uFriendNameLength];
			System.arraycopy(pBuffer, ptr,
					AddfriendsController._friendsList[i].username, 0,
					uFriendNameLength);

			// Log.v(TAG,"NAME "+new String(cFriend));

			ptr += uFriendNameLength;

		}
		if (pBuffer[ptr++] != 5)
			return;

		ptr += 5;// name

		ptr += 2;

		friends_count = (short) pBuffer[(ptr + 1)]; // 16
		friends_count <<= 8;
		friends_count |= (short) (0xFF & pBuffer[(ptr)]); // 15

		ptr += 2;
		Log.v(TAG, "FNAME_COUNT " + friends_count);

		for (i = 0; i < friends_count; i++) {

			short uFriendNameLength = (short) pBuffer[(ptr + 1)]; // 18
			uFriendNameLength <<= 8;
			uFriendNameLength |= (short) (0xFF & pBuffer[(ptr)]); // 17

			ptr += 2;
			if (uFriendNameLength != 0) {

				// byte []cFriend=new byte[uFriendNameLength];

				// AddfriendsController._friendsList[i].fname=new
				// byte[uFriendNameLength];
				System.arraycopy(pBuffer, ptr,
						AddfriendsController._friendsList[i].fname, 0,
						uFriendNameLength);
				// Log.v(TAG,"FNAME "+new String(cFriend));
			}

			ptr += uFriendNameLength;

		}
		if (pBuffer[ptr++] != 5)
			return;

		ptr += 5;// name

		ptr += 2;

		friends_count = (short) pBuffer[(ptr + 1)]; // 16
		friends_count <<= 8;
		friends_count |= (short) (0xFF & pBuffer[(ptr)]); // 15
		ptr += 2;
		Log.v(TAG, "LNAME_COUNT " + friends_count);

		for (i = 0; i < friends_count; i++) {

			short uFriendNameLength = (short) pBuffer[(ptr + 1)]; // 18
			uFriendNameLength <<= 8;
			uFriendNameLength |= (short) (0xFF & pBuffer[(ptr)]); // 17

			ptr += 2;
			if (uFriendNameLength != 0) {

				// byte []cFriend=new byte[uFriendNameLength];
				// AddfriendsController._friendsList[i].lname=new
				// byte[uFriendNameLength];
				System.arraycopy(pBuffer, ptr,
						AddfriendsController._friendsList[i].lname, 0,
						uFriendNameLength);
				// Log.v(TAG,"LNAME "+new String(cFriend));
			}

			ptr += uFriendNameLength;

		}

		AddfriendsController.SearchDone();

	}

	protected Dialog onCreateDialog(int id) {

		switch (id) {
		case 999:
			return new AlertDialog.Builder(_activeActivity_object).setTitle(
					"Confirm invitation?").setPositiveButton("Accept",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int whichButton) {

							   // User clicked OK so do some stuff

						}
					}).setNegativeButton("Deny",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int whichButton) {

							// User clicked Cancel so do some stuff

							System.out.println("cancel clicked.");
						}
					}).create();
		}
		return null;
	}

	void HandleAddFriendRequest(byte[] pBuffer) {

		int ptr = 0;

		ptr += 5;

		if (pBuffer[ptr++] != 4)
			return; // name

		ptr += 4;
		ptr += 2;

		short friends_count = (short) pBuffer[(ptr + 1)]; // 16
		friends_count <<= 8;
		friends_count |= (short) (0xFF & pBuffer[(ptr)]); // 15

		ptr += 2;

		short i = 0;

		for (i = 0; i < friends_count; i++) {

			short uFriendNameLength = (short) pBuffer[(ptr + 1)]; // 18
			uFriendNameLength <<= 8;
			uFriendNameLength |= (short) (0xFF & pBuffer[(ptr)]); // 17

			ptr += 2;

			ptr += uFriendNameLength;

		}
		if (pBuffer[ptr++] != 4)
			return; // nick
		ptr += 4;
		ptr += 2;

		friends_count = (short) pBuffer[(ptr + 1)]; // 16
		friends_count <<= 8;
		friends_count |= (short) (0xFF & pBuffer[(ptr)]); // 15
		ptr += 2;

		for (i = 0; i < friends_count; i++) {

			short uFriendNameLength = (short) pBuffer[(ptr + 1)]; // 18
			uFriendNameLength <<= 8;
			uFriendNameLength |= (short) (0xFF & pBuffer[(ptr)]); // 17

			ptr += 2;

			ptr += uFriendNameLength;

		}

		if (pBuffer[ptr++] != 3)
			return; // nick

		ptr += 3;

		ptr += 2;
		
		final Runnable runInUIThread = new Runnable() {

			public void run() {

				Log.v(TAG, "HandleAddFriendRequest onCreateDialog");
				onCreateDialog(999);

			}
		};

		_uiThreadCallback.post(runInUIThread);

	}

	/*
	 * 00000000 4b 00 8a 00 03 04 6e 61 6d 65 04 01 01 00 09 00 K.....na
	 * me...... 00000010 69 78 66 69 72 65 67 75 79 04 6e 69 63 6b 04 01
	 * ixfiregu y.nick.. 00000020 01 00 02 00 4d 65 03 6d 73 67 04 01 01 00 1b
	 * 00 ....Me.m sg...... 00000030 41 64 64 20 6d 65 20 74 6f 20 79 6f 75 72
	 * 20 66 Add me t o your f 00000040 72 69 65 6e 64 73 20 6c 69 73 74 riends
	 * l ist
	 */

	 public void GetHouseAD(String url) {

		System.out.println("Enter get ad");

		StringBuffer b = new StringBuffer();

		DefaultHttpClient client = new DefaultHttpClient();

		HttpGet method = new HttpGet(url);
		HttpResponse res;
		try {

			System.out.println("Enter get ad execute");
			res = client.execute(method);

			if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {

				InputStream data = res.getEntity().getContent();

				int ch;
				while ((ch = data.read()) != -1) {

					b.append((char) ch);
				}

				System.out.println(b);
				try {

					JSONObject json = new JSONObject(b.toString());

					ConnectThread.s_img_url = json.getString("img_url");
					ConnectThread.s_redirect_url = json
							.getString("redirect_url");
					ConnectThread.s_metrics_url = json.getString("metrics_url");
					ConnectThread.s_ad_text = json.getString("ad_text");

					System.out.println(ConnectThread.s_img_url);
					System.out.println(ConnectThread.s_redirect_url);
					System.out.println(ConnectThread.s_metrics_url);
					System.out.println(ConnectThread.s_ad_text);
					DownloadHouseAD(ConnectThread.s_img_url);

				}

				catch (JSONException e) {

				}
			}

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			System.out.println(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return;
	}
	
	 void DownloadHouseAD(String fileUrl) {

		if (fileUrl == null)
			return;
		System.out.println(fileUrl);
		
		Log.v(TAG, "Enter DownloadHouseAD");

		URL myFileUrl = null;

	
		try {

			myFileUrl = new URL(fileUrl);

			try {

				HttpURLConnection conn = (HttpURLConnection) myFileUrl
						.openConnection();
				conn.setDoInput(true);
				conn.connect();
				int length = conn.getContentLength();

				if (length == -1)
					return;
				InputStream is = conn.getInputStream();

				Bitmap bmImg = BitmapFactory.decodeStream(is);

				if (bmImg == null)
					return;

				Log.v(TAG, "call SetHouseAD");
				getFriendsEventListener().SetHouseAD(bmImg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void SendMetricImpressionsNotificatio() {

		String url = "http://met.adwhirl.com/exmet.php?appid=1f407c50c3674a3d87a59abe1527b3aa &type=9&nid=b390f1f6a43945d8852c72f1a8fa0352&uuid=00000000000000000000000000000000&country_code=en_US&appver=200&client=2";

		DefaultHttpClient client = new DefaultHttpClient();
		URI uri;
		try {
			uri = new URI(url);

			HttpGet method = new HttpGet(uri);
			HttpResponse res;
			try {
				res = client.execute(method);
				if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {

					System.out.println("SendMetricImpressionsNotificatio OK");

				}
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void SendMetricClickNotification() {

		String url = "http://met.adwhirl.com/exclick.php?appid=1f407c50c3674a3d87a59abe1527b3aa &type=9&nid=b390f1f6a43945d8852c72f1a8fa0352&&uuid=00000000000000000000000000000000&country_code=en_US&appver=200&client=2";

		DefaultHttpClient client = new DefaultHttpClient();
		URI uri;
		try {
			uri = new URI(url);

			HttpGet method = new HttpGet(uri);
			HttpResponse res;
			try {
				res = client.execute(method);
				if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {

					System.out.println("SendMetricClickNotification OK");

				}
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return;
	}
	
	
	private void ParsePacket(byte[] pBuffer)
	{

		int dwMsgSize;

		dwMsgSize = (0xFF & ((byte) pBuffer[1]) << 8)
				| (0xFF & ((byte) pBuffer[0]));

		int ptr = 0;

		short msgsize = (short) pBuffer[(ptr + 1)]; // 16
		msgsize <<= 8;
		msgsize |= (short) (0xFF & pBuffer[(ptr)]); // 15

		byte cPacketID;

		cPacketID = (byte) pBuffer[2];

		int nID = (int) cPacketID & 0xFF;


		if (nID == 0x8A) {

			Log.v(TAG, "HandleAddFriendRequest");

			//HandleAddFriendRequest(pBuffer);
		}
		if (nID == 0x8f) {

			Log.v(TAG, "return list of searched friends ");
			HandleSearchFriends(pBuffer);
		}
		if (nID == 136) {

			Log.v(TAG, "***Enter HandleFriendsOfFriends");
			// HandleFriendsOfFriends(pBuffer,msgsize);
		}

		if (nID == XFIRE_RECV_IM_ID) {

			try {

				handleReciveIMPacket(pBuffer, msgsize);

			} catch (Exception e) {
				System.err.println(e.toString());
			}

		}

		if (nID == 135) {

			try {

				// Log.v(TAG,"switch call to  handleContactPlayingGame");
				handleContactPlayingGame(pBuffer, msgsize);

			}

			catch (Exception e) {

				Log.v(TAG, "handleContactPlayingGame ERROR");

				System.err.println(e.toString());
			}
		}

		if (nID == XFIRE_BUDDY_STATUS_ID) {

			try {
				Log.v(TAG, "HandleBuddyStatus XFIRE_BUDDY_STATUS_ID");
				HandleBuddyStatus(pBuffer, msgsize);
			} catch (Exception e) {

				Log.v(TAG, "HandleBuddyStatus ERROR");

				System.err.println(e.toString());
			}

		}

		if (nID == XFIRE_PACKET_CONTACTS) {

			Log.v(TAG, "XFIRE_PACKET_CONTACTS SIZE=" + msgsize);

			try {

				handleContactsPacket(pBuffer, msgsize);

			} catch (Exception e) {

				Log.v(TAG, "XFIRE_PACKET_CONTACTS ERROR");

				System.err.println(e.toString());
			}

		}

		if (nID == XFIRE_VERSION_MISMATCH_ID) {

			Log.v(TAG, "XFIRE_VERSION_MISMATCH_ID");

			try {

				HandleMismatchVersion(pBuffer, msgsize);

			} catch (Exception e) {
				System.err.println(e.toString());
			}

		}

		if (nID == XFIRE_CONTACT_STATUS_MSG) {

			try {

				handleContactStatusMessagePacket(pBuffer, msgsize);

			} catch (Exception e) {
				Log.v(TAG, "XFIRE_CONTACT_STATUS_MSG ERROR");
				System.err.println(e.toString());
			}

		}

		if (nID == XFIRE_LOGIN_SUCCESS_ID) {

			Log.v(TAG, "XFIRE_LOGIN_SUCCESS_ID");

			handleLoginSuccessPacket(pBuffer, msgsize);
			
			getFriendsEventListener().connectionEstablished();

			_isTringToConnect = false;

		

		}

		if (nID == XFIRE_PONG_REPLY) {

			System.out.println("PONG PONG POOOOOOOOOOOOOOOOOONG");

		//	ContactScreen.get_keywords("http://www.xf-mobile.com/download/keywords_bb.php");
			//GetHouseAD("http://cus.adwhirl.com/custom.php?appid=1f407c50c3674a3d87a59abe1527b3aa&uuid=00000000000000000000000000000000&country_code=en_US&appver=200&client=2");

		}

		if (nID == 145) {

			
			getFriendsEventListener().connectionError("You were logged off because you logged in on a different computer");

			//Log.v(TAG, "ERROR: someone is online with our account");

		}

		if (nID == XFIRE_LOGIN_FAILED_ID) {

			Log.v(TAG, "XFIRE_LOGIN_FAILED_ID");

			getFriendsEventListener().connectionError("Your Xfire Name and password were not recongnised.\nPlease try again.");

		}
		if (nID == XFIRE_CLAN_PACKET) {

			Log.v(TAG, "XFIRE_CLAN_PACKET");
			handleClanPacket(pBuffer, dwMsgSize - 2);

		}

		if (nID == XFIRE_CLAN_BUDDYS_NAMES_ID) {
			Log.v(TAG, "XFIRE_CLAN_BUDDYS_NAMES_ID");

			handleClanBuddyNamesPacket(pBuffer);
		}

		if (nID == XFIRE_PACKET_AUTH_ID) {

			Log.v(TAG, "XFIRE_PACKET_AUTH_ID");

			try {

				HandleAuth(pBuffer, dwMsgSize - 2);

			} catch (Exception e) {

				Log.v(TAG, "XFIRE_PACKET_AUTH_ID ERROR");

				System.err.println(e.toString());
			}

		}

	}

	private void onread() throws Exception {

		if (_uStatus == DEF_XSOCKSTATUS_READINGHEADER) {

			int nBytesRead = _in.read(_pRcvBuffer, _dwTotalReadSize,
					_dwReadSize);
			if (nBytesRead == -1) {
				_isThreadRunning = false;
				return;
			}

			_dwReadSize -= nBytesRead;
			_dwTotalReadSize += nBytesRead;

			if (_dwReadSize == 0) {

				_uStatus = DEF_XSOCKSTATUS_READINGBODY;

				int wp;// (0xFF & ((byte)_pRcvBuffer[1]) << 8) | (0xFF &
						// ((byte)_pRcvBuffer[0]));

				wp = _pRcvBuffer[1];
				wp <<= 8;

				wp |= (0xFF & ((byte) _pRcvBuffer[0]));

				_dwReadSize = wp - 2;

				if (_dwReadSize == 0) {

					_uStatus = DEF_XSOCKSTATUS_READINGHEADER;
					_dwReadSize = 2;
					_dwTotalReadSize = 0;

				}
			}
		}

		if (_uStatus == DEF_XSOCKSTATUS_READINGBODY) {

			int nBytesRead = _in.read(_pRcvBuffer, _dwTotalReadSize,
					_dwReadSize);

			if (nBytesRead == -1) {

				_isThreadRunning = false;
				return;
			}

			_dwReadSize -= nBytesRead;
			_dwTotalReadSize += nBytesRead;

			if (_dwReadSize == 0) {

				bPutMsgQuene(_pRcvBuffer, _dwTotalReadSize + 2);

				_dwReadSize = 2;
				_dwTotalReadSize = 0;

				_uStatus = DEF_XSOCKSTATUS_READINGHEADER;

			}

			return;
		}

	}

	public void run() {

		try {

			 InetAddress serverAddr = InetAddress.getByName("cs.xfire.com");

			_socket = new Socket(serverAddr, 25999);

			_in = new DataInputStream(_socket.getInputStream());
			_out = new DataOutputStream(_socket.getOutputStream());

			Login();

			_isThreadRunning = true;

			while (_isThreadRunning) {

				onread();

			}

			_in.close();
			_out.close();
			_socket.close();
			_isdisconnect = true;

		}

		catch (Exception e) {

			System.out.println("SOCKET TIMEOUTTTT");
			_isdisconnect = true;
			_isThreadRunning = false;

		}

	}

	public static void Disconnect() {
		// TODO Auto-generated method stub

		// if (_socket==null) return false;

		System.out.println("Calling  Disconnect");
		_isThreadRunning = false;

	}

	public static boolean isConnected() {
		// TODO Auto-generated method stub
		// if (_socket==null) return false;

		return _isThreadRunning;

	}
}