package kagg886.qinternet.Content;
import kagg886.qinternet.Message.MsgCollection;

public class Friend extends Person
{
	public Friend(long botQQ,long uin,String uinName,int age,Sex sex,String area) {
		super(botQQ,uin,uinName,age,sex,area);
	}
	
	public void delete() {
		getFriendAPI().delete(uin);
	}
	
	public void sendMsg(MsgCollection msg) {
		getFriendAPI().sendMsg(uin,msg);
	}
}
