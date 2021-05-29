package kagg886.qinternet.Interface;
import kagg886.qinternet.Message.GroupMsgPack;
import kagg886.qinternet.Message.GroupMemberEnterPack;

public interface QQMsgListener
{
    void onGroupMsg(GroupMsgPack msg);
	void onGroupEnterApplication(GroupMemberEnterPack pack)
}
