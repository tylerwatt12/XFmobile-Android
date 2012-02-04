/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\XFMOBILE\\ANDROID\\iblaze\\src\\com\\iblazeapp\\ICallback.aidl
 */
package com.iblazeapp;
public interface ICallback extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.iblazeapp.ICallback
{
private static final java.lang.String DESCRIPTOR = "com.iblazeapp.ICallback";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.iblazeapp.ICallback interface,
 * generating a proxy if needed.
 */
public static com.iblazeapp.ICallback asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.iblazeapp.ICallback))) {
return ((com.iblazeapp.ICallback)iin);
}
return new com.iblazeapp.ICallback.Stub.Proxy(obj);
}
public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_OnMessage:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.OnMessage(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.iblazeapp.ICallback
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
public void OnMessage(int nID) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(nID);
mRemote.transact(Stub.TRANSACTION_OnMessage, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_OnMessage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public void OnMessage(int nID) throws android.os.RemoteException;
}
