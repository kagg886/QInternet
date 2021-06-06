package com.QR.MsgApi;

import android.os.*;
import com.QR.To.*;
import java.io.*;
import java.util.*;
import org.json.*;

public class PluginMsg implements Parcelable,Cloneable
{
	//必须提供一个名为CREATOR的static final属性 该属性需要实现android.os.Parcelable.Creator<T>接口  
    public static final Parcelable.Creator<PluginMsg> CREATOR = new Parcelable.Creator<PluginMsg>() {  

    	@Override
    	public PluginMsg createFromParcel(Parcel source)
		{
    		return new PluginMsg(source);
    	};

        @Override  
        public PluginMsg[] newArray(int size)
		{  
            return new PluginMsg[size];  
        }  
    };
	public static final int TYPE_DATA_MSG=-1;//控制台消息
    public static final int TYPE_GROUP_MSG=0;//群消息
    public static final int TYPE_BYDDY_MSG=1;//好友消息
    public static final int TYPE_DIS_MSG=2;//讨论组消息
    public static final int TYPE_SESS_MSG=4;//临时消息
    public static final int TYPE_SYS_MSG=3;//系统消息
    public static final int TYPE_GET_GROUP_LIST=5;//群列表 | 
    public static final int TYPE_GET_GROUP_INFO=6;//群信息 | groupid
    public static final int TYPE_GET_GROUP_MEBMER=7;//群成员 | groupid
    public static final int TYPE_GET_MEMBER_INFO=14;//成员信息 | groupid uin
	public static final int TYPE_GET_MEMBER_INFO2=28;//成员信息 | groupid uin
    public static final int TYPE_FAVORITE=8;//点赞 | uin value
    public static final int TYPE_SET_MEMBER_CARD=9;//设置群名片 | groupid uin uinName
    public static final int TYPE_SET_MEMBER_SHUTUP=10;//成员禁言 | groupid uin time
    public static final int TYPE_SET_GROUP_SHUTUP=11;//群禁言 | groupid time
    public static final int TYPE_DELETE_MEMBER=12;//删除群成员 | groupid uin
    public static final int TYPE_AGREE_JOIN=13;//同意入群 | groupid uin reqid status value strmsg
    public static final int TYPE_GET_LOGIN_ACCOUNT=15;//获取机器人QQ,授权 | |返回 uin value
    public static final int TYPE_T=16;//重载
    public static final int TYPE_QQ_HB=17;//QQ发红包
	public static final int TYPE_QQ_GRABHB=18;//QQ抢红包 | groupid listid authkey skey
	public static final int TYPE_QQ_DETAILHB=29;//QQ查红包 | groupid listid authkey skey
	
	public static final int TYPE_GROUP_WITH_MSG=19;//群撤回消息
    public static final int TYPE_GET_GROUP_ADMIN=20;//群管理员 | groupid |返回 json
	public static final int TYPE_GROUP_JOIN=21;//申请进群 | groupid addMsg("msg","")
    public static final int TYPE_GROUP_DROPOUT=22;//退出群 | groupid
	public static final int TYPE_MSG_WITHDRAW=23;//撤回消息 | groupid msgbar
	public static final int TYPE_GET_GROUP_SELECT=24;//查询群选择状态 | groupid | 返回 value
	public static final int TYPE_GROUP_SELECT_SETPU=25;//设置群选择状态 | groupid value
	public static final int TYPE_RETREAT_GROUP_MSG=26;//退群消息
	public static final int TYPE_ADMIN_CHANGE_GROUP_MSG=27;//管理改变消息 | value 1上位 2下位

    public int type;
	public int status;
	public int value;
	public int number;
	public long groupid;
	public long code;
	public long uin;
	public long adminuin;
	public long time;
	public long msgbar;
	public long pid;
	public long reqid;
	public String skey;
	public String groupName;
	public String uinName;
	public String adminname;
	public String inviteename;
	public String title;
	public String strmsg;
	public String listid;
	public String authkey;
	public JSONObject json;

	public PluginHbPay hbpay=new PluginHbPay();

	public List<Map<String,ArrayList<String>>> data=new ArrayList<Map<String,ArrayList<String>>>();

	public PluginMsg(Parcel source)
	{
		readFromParcel(source);
	}
	public PluginMsg()
	{
	}
	@Override
	public int describeContents()
	{
		return 0;
	}
	public void clearMsg()
	{
		data = new ArrayList<Map<String, ArrayList<String>>>();
	}
	public List<Map<String, ArrayList<String>>> getData()
	{
		return data;
	}
	public void setData(ArrayList<Map<String, ArrayList<String>>> data)
	{
		if (data != null)
		{
			this.data = data;
		}
	}

	public String getTextMsg()
	{
		return getText("msg");
	}
    public String getText(String str)
	{
		StringBuilder build=new StringBuilder("");
		for (int i=0;i < data.size();i++)
		{
			ArrayList<String> list=data.get(i).get(str);
			if (list != null)
			{
				for (String m:list)
					build.append(m);
			}
		}

		return build.toString();
	}
	public List<String> getMsg(String key)
	{

		List<String> l=new ArrayList<String>();

		for (int i=0;i < data.size();i++)
		{
			List<String> list=data.get(i).get(key);
			if (list != null)
			{
				l.addAll(list);
			}
		}
		return l;

	}
	public void addMsg(String... sarr)
	{

		HashMap<String, ArrayList<String>> hsas=new HashMap<String, ArrayList<String>>();

		for (int i=0;i < sarr.length;i++)
		{

			if (i + 2 <= sarr.length)
			{

				String key = sarr[i], msg = sarr[++i];
				ArrayList<String> index=hsas.get("index");
				if (index == null)
				{
					index = new ArrayList<String>();
					hsas.put("index", index);
				}
				index.add(key);
				ArrayList<String> list=hsas.get(key);
				if (list == null)
				{
					list = new ArrayList<String>();
					hsas.put(key, list);
				}
				list.add(msg);
			}
		}

		data.add(hsas);
	}

	public void addMsg(int position, String... sarr)
	{

		HashMap<String, ArrayList<String>> hsas=new HashMap<String, ArrayList<String>>();
		
		for (int i=0;i < sarr.length;i++)
		{

			if (i + 2 <= sarr.length)
			{

				String key = sarr[i], msg = sarr[++i];
				ArrayList<String> index=hsas.get("index");
				if (index == null)
				{
					index = new ArrayList<String>();
					hsas.put("index", index);
				}
				index.add(key);
				ArrayList<String> list=hsas.get(key);
				if (list == null)
				{
					list = new ArrayList<String>();
					hsas.put(key, list);
				}
				list.add(msg);
			}
		}

		data.add(position, hsas);
	}

	@Override
	public void writeToParcel(Parcel dest, int flags)
	{
		dest.writeInt(type);
		dest.writeInt(status);
		dest.writeInt(value);
		dest.writeInt(number);
		dest.writeLong(groupid);
		dest.writeLong(code);
		dest.writeLong(uin);
		dest.writeLong(adminuin);
		dest.writeLong(time);
		dest.writeLong(msgbar);
		dest.writeLong(pid);
		dest.writeLong(reqid);
		dest.writeString(skey);
		dest.writeString(groupName);
		dest.writeString(uinName);
		dest.writeString(adminname);
		dest.writeString(inviteename);
		dest.writeString(title);
		dest.writeString(strmsg);
		dest.writeString(listid);
		dest.writeString(authkey);
		dest.writeString((json == null) ?null: json.toString());
		dest.writeParcelable(hbpay, flags);
		dest.writeList(data);

	}
	public void readFromParcel(Parcel source)
	{
		type = source.readInt();
		status = source.readInt();
        value = source.readInt();
		number = source.readInt();
        groupid = source.readLong();
        code = source.readLong();
        uin = source.readLong();
		adminuin = source.readLong();
        time = source.readLong();
		msgbar = source.readLong();
		pid = source.readLong();
		reqid = source.readLong();
        skey = source.readString();
        groupName = source.readString();
        uinName = source.readString();
		adminname = source.readString();
		inviteename = source.readString();
        title = source.readString();
		strmsg = source.readString();
		listid = source.readString();
		authkey = source.readString();
		try
		{
			String jsonstr=source.readString();
			json = new JSONObject((jsonstr == null) ?"{}": jsonstr);
		}
		catch (JSONException e)
		{
			json = new JSONObject();
		}
		hbpay = source.readParcelable(getClass().getClassLoader());
        source.readList(data, getClass().getClassLoader());
	}

	@Override
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}

	@Override
	public String toString()
	{
		return ObjToString.toString(this);

	}
}





