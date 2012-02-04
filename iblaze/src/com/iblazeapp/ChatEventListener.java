package com.iblazeapp;

public interface ChatEventListener 


{
	
	
	void updateChatTitle(String title);

	void AppendMessage(int userid,String msg);
	
	
}