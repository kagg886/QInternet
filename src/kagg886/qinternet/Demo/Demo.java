package kagg886.qinternet.Demo;
import kagg886.qinternet.Interface.QQMsgListener;
import kagg886.qinternet.Message.GroupMsgPack;
import kagg886.qinternet.Message.GroupMemberEnterPack;

public class Demo implements QQMsgListener
{

	@Override
	public void onGroupEnterApplication(GroupMemberEnterPack pack) {
		pack.agree();
	}

    @Override
    public void onGroupMsg(GroupMsgPack msg) {
        if (msg.getMember().getUin() == 485184047L) {
            msg.getGroup().sendMsg(msg.getMessage());
        }
    }
    
}
