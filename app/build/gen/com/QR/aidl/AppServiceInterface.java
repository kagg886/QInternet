/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /storage/emulated/0/AppProjects/QInternet/app/src/main/aidl/com/QR/aidl/AppServiceInterface.aidl
 */
package com.QR.aidl;
public interface AppServiceInterface extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.QR.aidl.AppServiceInterface
{
private static final java.lang.String DESCRIPTOR = "com.QR.aidl.AppServiceInterface";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.QR.aidl.AppServiceInterface interface,
 * generating a proxy if needed.
 */
public static com.QR.aidl.AppServiceInterface asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.QR.aidl.AppServiceInterface))) {
return ((com.QR.aidl.AppServiceInterface)iin);
}
return new com.QR.aidl.AppServiceInterface.Stub.Proxy(obj);
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
case TRANSACTION_handlerMessage_PluginMsg:
{
data.enforceInterface(descriptor);
com.QR.MsgApi.PluginMsg _arg0;
if ((0!=data.readInt())) {
_arg0 = com.QR.MsgApi.PluginMsg.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.QR.MsgApi.PluginMsg _result = this.handlerMessage(_arg0);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
default:
{
return super.onTransact(code, data, reply, flags);
}
}
}
private static class Proxy implements com.QR.aidl.AppServiceInterface
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
@Override public com.QR.MsgApi.PluginMsg handlerMessage(com.QR.MsgApi.PluginMsg msg) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.QR.MsgApi.PluginMsg _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((msg!=null)) {
_data.writeInt(1);
msg.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_handlerMessage_PluginMsg, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.QR.MsgApi.PluginMsg.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_handlerMessage_PluginMsg = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public com.QR.MsgApi.PluginMsg handlerMessage(com.QR.MsgApi.PluginMsg msg) throws android.os.RemoteException;
}
