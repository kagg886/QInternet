package com.QR.aidl;
import com.QR.MsgApi.PluginMsg;
interface AppServiceInterface
{
	PluginMsg handlerMessage(in PluginMsg msg);
}
