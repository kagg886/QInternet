package com.QR.MsgApi;

import android.os.*;
import java.io.*;

public class PluginHbPay implements Parcelable,Cloneable
{
	public PluginHbPay()
	{
	}
	public PluginHbPay(Parcel source)
	{
		readFromParcel(source);
	}

	//必须提供一个名为CREATOR的static final属性 该属性需要实现android.os.Parcelable.Creator<T>接口  
	public static final Parcelable.Creator<PluginHbPay> CREATOR = new Parcelable.Creator<PluginHbPay>() {  

		@Override
		public PluginHbPay createFromParcel(Parcel source)
		{
			return new PluginHbPay(source);
		};

		@Override  
		public PluginHbPay[] newArray(int size)
		{  
			return new PluginHbPay[size];  
		}  
	};
	public int channel=8;//指定专属红包 8不指定 32口令红包 1024指定 65536语音红包

	public int bus_type=2;//红包类型 1普通红包 2拼手气红包

	public int recv_type=3;//发送类型 1好友 3是群 4非好友

	public int total_amount;//红包金额 分为单位 不是元为单位

	public int total_num=1;//红包数量

	public long recv_uin;//接收红包 群号或好友QQ号

	public String wishing="恭喜发财";//红包标题 或 口令

	public String grab_uin_list;//指定发红包用|分割

	@Override
	public int describeContents()
	{
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags)
	{
		dest.writeInt(channel);
		dest.writeInt(bus_type);
		dest.writeInt(recv_type);
		dest.writeInt(total_amount);
		dest.writeInt(total_num);
		dest.writeLong(recv_uin);
		dest.writeString(wishing);
		dest.writeString(grab_uin_list);
	}


	public void readFromParcel(Parcel source)
	{
		channel=source.readInt();
		bus_type=source.readInt();
		recv_type=source.readInt();
		total_amount=source.readInt();
		total_num=source.readInt();
		recv_uin=source.readLong();
		wishing=source.readString();
		grab_uin_list=source.readString();

	}

	@Override
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}

}

