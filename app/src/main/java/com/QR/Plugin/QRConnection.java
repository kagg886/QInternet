package com.QR.Plugin;

import android.content.*;
import android.util.*;
import com.QR.To.*;
import com.QR.aidl.*;

public class QRConnection implements ServiceConnection
{
	public AppServiceInterface service;

	@Override
	public void onServiceConnected(android.content.ComponentName name,
								   android.os.IBinder service)
	{
		this.service = AppServiceInterface.Stub.asInterface(service);
		Log.d("MSG", ObjToString.toString(this.service));
	}

	@Override
	public void onServiceDisconnected(android.content.ComponentName name)
	{
		Log.d("MSG", "连接中断");
	}
}



