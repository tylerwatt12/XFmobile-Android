package com.iblazeapp;

import android.os.Handler;
import android.os.Message;

public abstract class ServiceCallbackHandler extends Handler {

	/**
	 * Message handler for a input recived
	 */
	private static final int INPUT_RECIVED = 0;
	
	

	@Override
	public void handleMessage(Message msg) {
		switch(msg.what){
		case INPUT_RECIVED:
			
		default:
			super.handleMessage(msg);
		}
		
	}
	

	
	
	
}
