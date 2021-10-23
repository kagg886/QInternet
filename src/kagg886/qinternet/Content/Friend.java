package kagg886.qinternet.Content;
import kagg886.qinternet.Message.MsgCollection;
import kagg886.qinternet.QInternet;

public class Friend extends Person
{
	public Friend(QQBot botQQ,long uin,String uinName,int age,Sex sex,String area) {
		super(botQQ,uin,uinName,age,sex,area);
	}
	
	public void delete() {
		QInternet.findBot(getBotQQ()).getFriendAPI().delete(getUin());
	}
	
	public void sendMsg(MsgCollection msg) {
		QInternet.findBot(getBotQQ()).getFriendAPI().sendMsg(getUin(),msg);
	}
}
