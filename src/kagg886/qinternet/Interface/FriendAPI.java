package kagg886.qinternet.Interface;
import kagg886.qinternet.Message.MsgCollection;

public interface FriendAPI extends API
{
	void delete(long qq);
	void sendMsg(long qq,MsgCollection msg);
}
