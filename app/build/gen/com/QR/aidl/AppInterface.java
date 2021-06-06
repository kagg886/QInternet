/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /storage/emulated/0/AppProjects/QRPlugin/app/src/main/aidl/com/QR/aidl/AppInterface.aidl
 */
package com.QR.aidl;
public interface AppInterface extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.QR.aidl.AppInterface
{
private static final java.lang.String DESCRIPTOR = "com.QR.aidl.AppInterface";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.QR.aidl.AppInterface interface,
 * generating a proxy if needed.
 */
public static com.QR.aidl.AppInterface asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.QR.aidl.AppInterface))) {
return ((com.QR.aidl.AppInterface)iin);
}
return new com.QR.aidl.AppInterface.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
java.lang.String descriptor = DESCRIPTOR;
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(descriptor);
return true;
}
case TRANSACTION_author:
{
data.enforceInterface(descriptor);
java.lang.String _result = this.author();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_info:
{
data.enforceInterface(descriptor);
java.lang.String _result = this.info();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_icon:
{
data.enforceInterface(descriptor);
byte[] _result = this.icon();
reply.writeNoException();
reply.writeByteArray(_result);
return true;
}
case TRANSACTION_onMessageHandler_PluginMsg:
{
data.enforceInterface(descriptor);
com.QR.MsgApi.PluginMsg _arg0;
if ((0!=data.readInt())) {
_arg0 = com.QR.MsgApi.PluginMsg.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.onMessageHandler(_arg0);
reply.writeNoException();
return true;
}
default:
{
return super.onTransact(code, data, reply, flags);
}
}
}
private static class Proxy implements com.QR.aidl.AppInterface
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public java.lang.String author() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_author, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.lang.String info() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_info, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public byte[] icon() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
byte[] _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_icon, _data, _reply, 0);
_reply.readException();
_result = _reply.createByteArray();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void onMessageHandler(com.QR.MsgApi.PluginMsg msg) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((msg!=null)) {
_data.writeInt(1);
msg.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_onMessageHandler_PluginMsg, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_author = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_info = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_icon = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_onMessageHandler_PluginMsg = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
}
public java.lang.String author() throws android.os.RemoteException;
public java.lang.String info() throws android.os.RemoteException;
public byte[] icon() throws android.os.RemoteException;
public void onMessageHandler(com.QR.MsgApi.PluginMsg msg) throws android.os.RemoteException;
}
