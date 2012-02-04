package com.iblazeapp;

import java.io.IOException;
import java.util.ArrayList;

import com.iblazeapp.ICallback;
import com.iblazeapp.IService;



import android.app.Service;


import android.content.Intent;

import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;



class XfireContact  extends Object

{


    int               _messages_count;
    String          []_messages=new String[20];
    byte            []_cUsername;//=new char[0x100];
    byte            []_cNickname;//=new byte [0x100];  
    byte            []_cStatusMsg;//=new char[0x100];
    int               _gameid;
    int               _userid;
    byte            []_sid=new byte[16];
    int               _uStatus;
    boolean           _bIsPendingMessages;
    int               _nTotalPendingMessages;
    byte            []_cGamename;
    int                _nNodeID;
    boolean             _bRecvNewMsg;
    int                 _imindex;


}


class XfireClan
{

	
	
        byte                [] _name=new byte [0x100];
        int                  _id;
        short                _usercount;
        
        @SuppressWarnings("unchecked")
		ArrayList           _listContacts= new ArrayList();
        
        
        int                 _nNodeID;
        
        
        
}


public class CoreService extends Service {

	
	

	
	
	    private static final String TAG = "iBlazeCoreService";
	    
	    
	    ConnectThread                     _connectThread=null;
	    
	     
	    @SuppressWarnings("unchecked")
		static  ArrayList _FriendsList = new ArrayList();
	    
	    static int                              _nTotalClans;
	    static int                              _nTotalChatSessions;

	    static                      int         _nTotalContacts;
	    
	    static  XfireClan                     []_ClansList=new XfireClan[32];          //array of JUST pointers
	    
	    @SuppressWarnings("unchecked")
		public static  RemoteCallbackList   _callbacks = new RemoteCallbackList();
	   
	    public static CoreService     coreServiceObject=null;
	    
	 
	    public static String _username=new String("");
	    public static String _password=new String("");

		
	    public static void reset()
	    {
	    	
	    	
	    	_nTotalClans=0;
	    	_nTotalChatSessions=0;
	   
	    	_nTotalContacts=0;
	    	_FriendsList.clear();
	    	
	    	
	    
	    	
	    	
	    	
	    	
	    }

	    

	    public static XfireContact getClanMemberBySID(byte sid[]) {

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

		public static XfireContact getClanMember(int userid) {

			for (int i = 0; i < CoreService._nTotalClans; i++) {

				for (int j = 0; j < CoreService._ClansList[i]._usercount; j++) {

					XfireContact xcontact = (XfireContact) CoreService._ClansList[i]._listContacts
							.get(j);

					if (xcontact._userid == userid) {

						return xcontact;
					}

				}

			}
			return null;

		}
	    public static XfireContact   getContactBySID(byte[] sid)
	    {

	            boolean bOK=false;
	            
	            for (int i=0; i<_FriendsList.size(); i++)   {

	                    XfireContact xcontact=(XfireContact) _FriendsList.get(i);
	         
	                     bOK=false;

	                    for (int j=0; j<16; j++){



	                            if ( xcontact._sid[j]!=sid[j]){
	 
	                                    bOK=true;

	                                    break;

	                            }



	                    }

	                    if (!bOK) return  xcontact;


	            }

	            return getClanMemberBySID(sid);
	    }
	    
	
	    
	    
	    
	    public static  XfireContact  getContactByID(int userid)
	    {

	            for (int i=0; i<_FriendsList.size(); i++)   {
	                  
	                  
	                  
	                   XfireContact xcontact=(XfireContact) _FriendsList.get(i);
	         

	      
	                    if (xcontact._userid==userid) {


	                            return xcontact; 
	                    } 

	            }

	            return getClanMember(userid);
	    }
	    
	    
	    
	  
	    
	 
	    static int   getClanIndexByID(int nClanID)
	    {

	            for (int i=0; i<_nTotalClans; i++)   {

	                    if (_ClansList[i]._id==nClanID) {


	                            return i; 
	                    } 

	            }

	            return -1;
	    }
	    
	  
	    private final IService.Stub m_binder = new IService.Stub(){
			
	    	  
	    	  
	    	@Override
	    	public void connect(char[]user,char[]pass) throws RemoteException

	    	{
	    	
	    		 Log.v(TAG,"connect");
	    		
	    		
	    		_connectThread= new ConnectThread();
	    		if (_connectThread!=null)
	    		_connectThread.Connect(new String(user),new String(pass));   
	    		
	    	 
	    		 
	    	}
	    	
	    	
			@SuppressWarnings("unchecked")
			@Override
			public void registerCallback(ICallback cb) throws RemoteException {
				if (cb != null) {
					_callbacks.register(cb);
				}

			}

			@SuppressWarnings("unchecked")
			@Override
			public void unregisterCallback(ICallback cb) throws RemoteException {
				if (cb != null) {
					_callbacks.unregister(cb);
				}

			}

              
			@Override
			public void disconnet() throws RemoteException {
				// TODO Auto-generated method stub
				
				
				 Log.v(TAG,":service:disconnect");
			
					try {
						_connectThread.quit();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
				
				
			}


			@Override
			public void setmystatus(char[] msg) throws RemoteException {
				// TODO Auto-generated method stub
				
				try {
					_connectThread.sendMyStatusMessagePacket(new String(msg).toCharArray());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}


			@Override
			public void sendim(byte[] sid, char[] msg) throws RemoteException {
				// TODO Auto-generated method stub
				
				try {
					_connectThread.sendIMPacket(sid,msg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}


			@Override
			public void searhcontacts(char[] msg) throws RemoteException {
				// TODO Auto-generated method stub
				try {
					_connectThread.sendSearchPacket(msg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}


			@Override
			public void addfriend(byte[] pBuddyName) throws RemoteException {
				// TODO Auto-generated method stub
				
			
				try {
					_connectThread.AddBuddyPacket(pBuddyName);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}


			@Override
			public boolean isconnected() throws RemoteException {
				
				
				return true;
			
			}


			@Override
			public void keepalive() throws RemoteException {
				// TODO Auto-generated method stub
				
				try {
					_connectThread.KeepAlive();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}


			@Override
			public void setmynickname(char[] msg) throws RemoteException {
				// TODO Auto-generated method stub
				
				try {
					
					_connectThread.sendChangeNickPacket(new String(msg).toCharArray());
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		};

	     @Override
     	 public void onCreate() 
	     {
		 
	    	 
	        super.onCreate();

	        coreServiceObject=this;

	    	 Log.v(TAG,":iBlazeCoreServiceonCreate");
	    	 
	    	
	     }
	   
	     
	    @Override
	    public void onStart(Intent intent,int startID) {
			  super.onStart(intent,startID);

		}
		@Override
		public void onDestroy() {
		  super.onDestroy();

		}

		@Override
		public IBinder onBind(Intent intent) {
			// TODO Auto-generated method stub
			return m_binder;
		}





}
