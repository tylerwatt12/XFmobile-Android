/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\XFMOBILE\\ANDROID\\iblaze\\src\\com\\iblazeapp\\IService.aidl
 */
package com.iblazeapp;
public interface IService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.iblazeapp.IService
{
private static final java.lang.String DESCRIPTOR = "com.iblazeapp.IService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.iblazeapp.IService interface,
 * generating a proxy if needed.
 */
public static com.iblazeapp.IService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.iblazeapp.IService))) {
return ((com.iblazeapp.IService)iin);
}
return new com.iblazeapp.IService.Stub.Proxy(obj);
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
case TRANSACTION_connect:
{
data.enforceInterface(DESCRIPTOR);
char[] _arg0;
_arg0 = data.createCharArray();
char[] _arg1;
_arg1 = data.createCharArray();
this.connect(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_disconnet:
{
data.enforceInterface(DESCRIPTOR);
this.disconnet();
reply.writeNoException();
return true;
}
case TRANSACTION_addfriend:
{
data.enforceInterface(DESCRIPTOR);
byte[] _arg0;
_arg0 = data.createByteArray();
this.addfriend(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_searhcontacts:
{
data.enforceInterface(DESCRIPTOR);
char[] _arg0;
_arg0 = data.createCharArray();
this.searhcontacts(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setmystatus:
{
data.enforceInterface(DESCRIPTOR);
char[] _arg0;
_arg0 = data.createCharArray();
this.setmystatus(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setmynickname:
{
data.enforceInterface(DESCRIPTOR);
char[] _arg0;
_arg0 = data.createCharArray();
this.setmynickname(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_sendim:
{
data.enforceInterface(DESCRIPTOR);
byte[] _arg0;
_arg0 = data.createByteArray();
char[] _arg1;
_arg1 = data.createCharArray();
this.sendim(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_registerCallback:
{
data.enforceInterface(DESCRIPTOR);
com.iblazeapp.ICallback _arg0;
_arg0 = com.iblazeapp.ICallback.Stub.asInterface(data.readStrongBinder());
this.registerCallback(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_unregisterCallback:
{
data.enforceInterface(DESCRIPTOR);
com.iblazeapp.ICallback _arg0;
_arg0 = com.iblazeapp.ICallback.Stub.asInterface(data.readStrongBinder());
this.unregisterCallback(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_isconnected:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isconnected();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_keepalive:
{
data.enforceInterface(DESCRIPTOR);
this.keepalive();
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.iblazeapp.IService
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
public void connect(char[] user, char[] pass) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeCharArray(user);
_data.writeCharArray(pass);
mRemote.transact(Stub.TRANSACTION_connect, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
public void disconnet() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_disconnet, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
public void addfriend(byte[] pBuddyName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeByteArray(pBuddyName);
mRemote.transact(Stub.TRANSACTION_addfriend, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
public void searhcontacts(char[] msg) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeCharArray(msg);
mRemote.transact(Stub.TRANSACTION_searhcontacts, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
public void setmystatus(char[] msg) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeCharArray(msg);
mRemote.transact(Stub.TRANSACTION_setmystatus, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
public void setmynickname(char[] msg) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeCharArray(msg);
mRemote.transact(Stub.TRANSACTION_setmynickname, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
public void sendim(byte[] sid, char[] msg) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeByteArray(sid);
_data.writeCharArray(msg);
mRemote.transact(Stub.TRANSACTION_sendim, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
public void registerCallback(com.iblazeapp.ICallback cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_registerCallback, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
public void unregisterCallback(com.iblazeapp.ICallback cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_unregisterCallback, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
public boolean isconnected() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isconnected, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
public void keepalive() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_keepalive, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_connect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_disconnet = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_addfriend = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_searhcontacts = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_setmystatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_setmynickname = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_sendim = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_registerCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_unregisterCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
static final int TRANSACTION_isconnected = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
static final int TRANSACTION_keepalive = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
}
public void connect(char[] user, char[] pass) throws android.os.RemoteException;
public void disconnet() throws android.os.RemoteException;
public void addfriend(byte[] pBuddyName) throws android.os.RemoteException;
public void searhcontacts(char[] msg) throws android.os.RemoteException;
public void setmystatus(char[] msg) throws android.os.RemoteException;
public void setmynickname(char[] msg) throws android.os.RemoteException;
public void sendim(byte[] sid, char[] msg) throws android.os.RemoteException;
public void registerCallback(com.iblazeapp.ICallback cb) throws android.os.RemoteException;
public void unregisterCallback(com.iblazeapp.ICallback cb) throws android.os.RemoteException;
public boolean isconnected() throws android.os.RemoteException;
public void keepalive() throws android.os.RemoteException;
}
