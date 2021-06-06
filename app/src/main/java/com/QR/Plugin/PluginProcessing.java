package com.QR.Plugin;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.os.RemoteException;
import com.QR.MsgApi.PluginMsg;
import com.QR.aidl.AppInterface.Stub;
import java.io.ByteArrayOutputStream;
import java.util.List;
import kagg886.QIScript;
import kagg886.api.QRFriendAPI;
import kagg886.api.QRGroupAPI;
import kagg886.api.QRMemberAPI;
import kagg886.qinternet.Content.Friend;
import kagg886.qinternet.Content.Group;
import kagg886.qinternet.Content.Member;
import kagg886.qinternet.Content.Person;
import kagg886.qinternet.Interface.GroupEnterAPI;
import kagg886.qinternet.Message.FriendMsgPack;
import kagg886.qinternet.Message.GroupMemberApplicationPack;
import kagg886.qinternet.Message.GroupMsgPack;
import kagg886.qinternet.Message.MsgCollection;
import kagg886.qinternet.QInternet;

public class PluginProcessing extends Service
{
	private QIScript q;
	private long bot;
	//AIDL接口实现
	private final Stub stub=new Stub() {
		/**
		 * 由主程序接收消息时调用
		 * @param msg 消息包体
		 */
		@Override
		public void onMessageHandler(final PluginMsg p) throws RemoteException {
			if (p.type == PluginMsg.TYPE_BYDDY_MSG) {
				Friend f = new Friend(bot,p.uin,p.uinName,6,Person.Sex.GIRL,null);
				MsgCollection c = new MsgCollection();
				c.putText(p.getTextMsg());
				FriendMsgPack k = new FriendMsgPack(f,c);
				q.onFriendMsg(k);
			}
		    if (p.type == PluginMsg.TYPE_GROUP_MSG) {
				Group g = new Group(bot,p.groupid,p.groupName);
				Member m = new Member(bot,p.groupid,p.uin,p.uinName,6,Person.Sex.BOY,null,null,Member.Permission.ADMIN);
				MsgCollection c = new MsgCollection();
				c.putText(p.getTextMsg());
				GroupMsgPack gp = new GroupMsgPack(g,m,c);
				q.onGroupMsg(gp);
			}
			
			if (p.type == PluginMsg.TYPE_SYS_MSG) {
				if (p.status == 84) {
					
					Group g = new Group(bot,p.uin,p.groupName);
					Person m = new Person(bot,p.uin,p.uinName,6,Person.Sex.BOY,null);
					GroupEnterAPI a = new GroupEnterAPI() {

						@Override
						public void agree() {
							PluginMsg m = new PluginMsg();
							m.type = PluginMsg.TYPE_AGREE_JOIN;
							m.reqid = p.reqid;
							m.groupid = p.groupid;
							m.uin = p.uin;
							m.status = 2001;
							m.value = 11;
							send(m);
						}

						@Override
						public void reject(String p1) {
							PluginMsg m = new PluginMsg();
							m.type = PluginMsg.TYPE_AGREE_JOIN;
							m.reqid = p.reqid;
							m.groupid = p.groupid;
							m.uin = p.uin;
							m.status = 31;
							m.value = 12;
							if (p1 != null) {
								m.strmsg = p1;
							}
							send(m);
						}

					};
					GroupMemberApplicationPack gmp = new GroupMemberApplicationPack(g,m,p.strmsg,a);
					q.onGroupEnterApplication(gmp);
				}
			}
		}

		/**
		 * 插件相关简要信息说明
		 */
		@Override
		public String info() throws RemoteException
		{
			return "QIScriptDemo";
		}
		/**
		 * 插件图标
		 */
		@Override
		public byte[] icon() throws RemoteException
		{
			Bitmap bit=BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			bit.compress(Bitmap.CompressFormat.PNG, 100, out);
			return out.toByteArray();
		}
		/**
		 * 插件作者信息
		 */
		@Override
		public String author() throws RemoteException
		{
			return "kagg886";
		}
	};

	private static QRConnection connection;
	/**
	 * 对主程序发送一个消息包
	 * @param msg 消息包内容
	 * @return 对于需要返回的消息包如:【获取群列表】时获得返回，否则为null
	 * @throws RemoteException
	 */

	public static PluginMsg send(PluginMsg msg)
	{
		try
		{
			if (connection != null && connection.service != null)
				return connection.service.handlerMessage(msg);
		}
		catch (RemoteException e)
		{
		}

		return null;
	}



	@Override
	public IBinder onBind(Intent intent)
	{
		List<ResolveInfo> Rlist=this.getPackageManager().queryIntentServices(new Intent("com.QR.Speed.service").setPackage("com.QR.Speed"), 0);
		ResolveInfo resolveInfo=Rlist.get(0);
		//回绑
		Intent i = new Intent();
		ComponentName component=new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
		i.setComponent(component);
        this.connection = new QRConnection();
		try
		{
			stopService(i);
			startService(i);
		}
		catch (java.lang.IllegalStateException e)
		{}
		bindService(i, this.connection, Context.BIND_AUTO_CREATE);
        //返回插件接口实现对象
		
		//-----QIAPI实现
		
		new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {}
					PluginMsg m = new PluginMsg();
					m.type = 15;
					m = send(m);
					bot = m.uin;
					QInternet.initAPI(QInternet.APIType.GROUPAPI,m.uin,new QRGroupAPI(m.uin));
					QInternet.initAPI(QInternet.APIType.MEMBERAPI,m.uin,new QRMemberAPI(m.uin));
					QInternet.initAPI(QInternet.APIType.FRIENDAPI,m.uin,new QRFriendAPI(m.uin));
					m.type = -1;
					m.addMsg("msg","init success!,uin:" + m.uin);
					send(m);
				}
			}).start();
		
		q = new QIScript();
		return stub;
	}


}

