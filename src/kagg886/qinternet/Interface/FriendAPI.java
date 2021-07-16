package kagg886.qinternet.Interface;
import kagg886.qinternet.Message.MsgCollection;
import java.util.ArrayList;
import kagg886.qinternet.Content.Friend;

public interface FriendAPI extends API
{
	void delete(long qq);
	void sendMsg(long qq,MsgCollection msg);
	ArrayList<Long> getFriends();
	Friend getFriend(long qq);
}
