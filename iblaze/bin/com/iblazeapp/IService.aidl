package com.iblazeapp;


import  com.iblazeapp.ICallback;



interface IService{
	

  

   
    void connect(in char []user,in char[]pass);

    void disconnet();
    void addfriend(in byte []pBuddyName);
    void searhcontacts(in char []msg);
    void setmystatus(in char []msg);
    void setmynickname(in char []msg);
    void sendim(in byte []sid,in char []msg);
    void registerCallback(ICallback cb); 
    void unregisterCallback(ICallback cb);
    boolean isconnected(); 
    void keepalive();

}