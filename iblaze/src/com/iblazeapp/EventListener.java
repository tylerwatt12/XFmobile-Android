package com.iblazeapp;

import android.graphics.Bitmap;

public interface EventListener 


{

    void connectionEstablished();

    void connectionClosed();

    void connectionError(final String err);

    void messageReceived(byte[] usersid,String email, String message);

    void messageError(final String id);

    void Addfriend(int userid,String email, String name);

    void Removefriend(int userid,String email);

    void friendStateChanged(String email, int state);

    void friendStatusChanged(byte[] usersid,String smsg);

    void friendGameStateChanged(byte[] usersid, int gameid);
    
    void addClanGroup(byte[]name);
    
    void switchToTypingMode();
    
    
    void SetHouseAD(final Bitmap bm);

}