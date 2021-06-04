package kagg886.qinternet.Interface;
import kagg886.qinternet.Message.GroupMsgPack;
import kagg886.qinternet.Message.GroupMemberApplicationPack;
import kagg886.qinternet.Message.GroupMemberPack;

public interface QQMsgListener extends API
{
	void onMemberMsg(GroupMemberPack msg)
    void onGroupMsg(GroupMsgPack msg)
	void onGroupEnterApplication(GroupMemberApplicationPack msg)
}
