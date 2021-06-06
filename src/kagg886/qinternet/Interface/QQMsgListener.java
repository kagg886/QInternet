package kagg886.qinternet.Interface;
import kagg886.qinternet.Message.GroupMsgPack;
import kagg886.qinternet.Message.GroupMemberApplicationPack;
import kagg886.qinternet.Message.GroupMemberPack;
import kagg886.qinternet.Message.FriendMsgPack;

public interface QQMsgListener
{
	void onFriendMsg(FriendMsgPack msg);
	void onMemberMsg(GroupMemberPack msg);
    void onGroupMsg(GroupMsgPack msg);
	void onGroupEnterApplication(GroupMemberApplicationPack msg);
}
