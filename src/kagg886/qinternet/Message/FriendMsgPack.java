package kagg886.qinternet.Message;
import kagg886.qinternet.Content.Friend;

public class FriendMsgPack
{
	protected Friend friend;
	protected MsgCollection msg;
	
	public FriendMsgPack(Friend friend,MsgCollection msg) {
		this.friend = friend;
		this.msg = msg;
	}
	
	public Friend getFriend() {
		return friend;
	}
	
	public MsgCollection getMessage() {
		return msg;
	}
}
