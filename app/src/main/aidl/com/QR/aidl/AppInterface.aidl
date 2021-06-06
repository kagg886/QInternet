package com.QR.aidl;
import com.QR.MsgApi.PluginMsg;
interface AppInterface
{
	String author();
	String info();
	byte[] icon();
	void onMessageHandler(in PluginMsg msg);
}
