package com.QR.Plugin.Utils;

import com.QR.MsgApi.*;
import com.QR.Plugin.*;
import java.util.*;

public class PluginMsgUtil
{
	/*
	 *发送 日志
	 *@parameter
	 *String msg 文本
	 *
	 */
	public static void send_Data_Msg(String msg)
	{
		PluginMsg pluginMsg=new PluginMsg();

		pluginMsg.addMsg("msg", msg);

		send_Data_Msg(pluginMsg);
	}
	public static void send_Data_Msg(PluginMsg pluginMsg)
	{
		try
		{
			pluginMsg = (PluginMsg) pluginMsg.clone();

			pluginMsg.type = PluginMsg.TYPE_DATA_MSG;

			PluginProcessing.send(pluginMsg);
		}
		catch (CloneNotSupportedException e)
		{}
	}

	/*
	 *发送 群消息
	 *@parameter
	 *long groupid 群号
	 *String msg 文本
	 *
	 */
	public static void send_Group_Msg(long groupid, String msg)
	{
		PluginMsg pluginMsg=new PluginMsg();

		pluginMsg.groupid = groupid;

		pluginMsg.addMsg("msg", msg);

		send_Group_Msg(pluginMsg);
	}
	public static void send_Group_Msg(PluginMsg pluginMsg)
	{
		try
		{
			pluginMsg = (PluginMsg) pluginMsg.clone();

			pluginMsg.type = PluginMsg.TYPE_GROUP_MSG;

			PluginProcessing.send(pluginMsg);
		}
		catch (CloneNotSupportedException e)
		{}
	}

	/*
	 *发送 好友消息
	 *@parameter
	 *long uin QQ
	 *String msg 文本
	 *
	 */
	public static void send_Byddy_Msg(long uin, String msg)
	{
		PluginMsg pluginMsg=new PluginMsg();

		pluginMsg.uin = uin;

		pluginMsg.addMsg("msg", msg);

		send_Byddy_Msg(pluginMsg);
	}
	public static void send_Byddy_Msg(PluginMsg pluginMsg)
	{
		try
		{
			pluginMsg = (PluginMsg) pluginMsg.clone();

			pluginMsg.type = PluginMsg.TYPE_BYDDY_MSG;

			PluginProcessing.send(pluginMsg);

		}
		catch (CloneNotSupportedException e)
		{}

	}

	/*
	 *发送 讨论组消息 (已报废)
	 *@parameter
	 *long groupid 群号
	 *String msg 文本
	 *
	 */
	public static void send_Dis_Msg(long groupid, String msg)
	{
		PluginMsg pluginMsg=new PluginMsg();

		pluginMsg.groupid = groupid;

		pluginMsg.addMsg("msg", msg);

		send_Dis_Msg(pluginMsg);
	}
	public static void send_Dis_Msg(PluginMsg pluginMsg)
	{
		try
		{
			pluginMsg = (PluginMsg) pluginMsg.clone();

			pluginMsg.type = PluginMsg.TYPE_DIS_MSG;

			PluginProcessing.send(pluginMsg);
		}
		catch (CloneNotSupportedException e)
		{}
	}

	/*
	 *发送 临时消息
	 *@parameter
	 *long groupid 群号
	 *long uin QQ
	 *String msg 文本
	 *
	 */
	public static void send_Sess_Msg(long groupid, long uin, String msg)
	{
		PluginMsg pluginMsg=new PluginMsg();

		pluginMsg.groupid = groupid;

		pluginMsg.uin = uin;

		pluginMsg.addMsg("msg", msg);

		send_Sess_Msg(pluginMsg);
	}
	public static void send_Sess_Msg(PluginMsg pluginMsg)
	{
		try
		{
			pluginMsg = (PluginMsg) pluginMsg.clone();

			pluginMsg.type = PluginMsg.TYPE_SESS_MSG;

			PluginProcessing.send(pluginMsg);
		}
		catch (CloneNotSupportedException e)
		{}
	}

	/*
	 *请求 群列表
	 *@parameter
	 *long groupid 群号
	 *
	 */
	public static List<String> get_Group_List(long groupid)
	{
		PluginMsg pluginMsg=new PluginMsg();

		pluginMsg.groupid = groupid;

		return get_Group_List(pluginMsg);
	}
	public static List<String> get_Group_List(PluginMsg pluginMsg)
	{
		try
		{
			pluginMsg = (PluginMsg) pluginMsg.clone();

			pluginMsg.type = PluginMsg.TYPE_GET_GROUP_LIST;

			PluginMsg pm= PluginProcessing.send(pluginMsg);

			return pm.getMsg("troop");

		}
		catch (CloneNotSupportedException e)
		{}
		return null;
	}

	/*
	 *请求 群成员列表
	 *@parameter
	 *long groupid 群号
	 *
	 */
	public static List<String> get_Group_Mebmer(long groupid)
	{
		PluginMsg pluginMsg=new PluginMsg();

		pluginMsg.groupid = groupid;

		return get_Group_Mebmer(pluginMsg);
	}
	public static List<String> get_Group_Mebmer(PluginMsg pluginMsg)
	{
		try
		{
			pluginMsg = (PluginMsg) pluginMsg.clone();

			pluginMsg.type = PluginMsg.TYPE_GET_GROUP_LIST;

			PluginMsg pm= PluginProcessing.send(pluginMsg);

			return pm.getMsg("member");
		}
		catch (CloneNotSupportedException e)
		{}
		return null;
	}

	/*
	 *发送 点赞
	 *@parameter
	 *long uin QQ
	 *int num 点赞次数
	 *
	 */
	public static void send_Favorite(long uin, int num)
	{
		PluginMsg pluginMsg=new PluginMsg();

		pluginMsg.uin = uin;

		pluginMsg.value = num;

		send_Favorite(pluginMsg);
	}
	public static void send_Favorite(PluginMsg pluginMsg)
	{
		try
		{
			pluginMsg = (PluginMsg) pluginMsg.clone();

			pluginMsg.type = PluginMsg.TYPE_FAVORITE;

			PluginProcessing.send(pluginMsg);
		}
		catch (CloneNotSupportedException e)
		{}

	}



}
