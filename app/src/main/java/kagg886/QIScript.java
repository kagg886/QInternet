package kagg886;
import kagg886.qinternet.Interface.QQMsgListener;
import kagg886.qinternet.Message.GroupMsgPack;
import kagg886.qinternet.exceptions.PermissionException;
import kagg886.qinternet.Message.MsgCollection;
import kagg886.qinternet.Message.GroupMemberPack;
import kagg886.qinternet.Message.FriendMsgPack;
import kagg886.qinternet.Message.GroupMemberApplicationPack;
import kagg886.qinternet.Message.MsgSpawner;

public class QIScript implements QQMsgListener {

	@Override
	public void onFriendMsg(FriendMsgPack p1) {
		p1.getFriend().sendMsg(p1.getMessage());
	}

	@Override
	public void onGroupEnterApplication(GroupMemberApplicationPack p1) {
	}

	@Override
	public void onMemberMsg(GroupMemberPack p1) {
		if (p1.getType() == GroupMemberPack.Type.kick) {
			
		}
	}
	

	@Override
	public void onGroupMsg(GroupMsgPack msg) {
		String text = msg.getMessage().getTexts();
		
		if (text.startsWith("qaq")) {
			MsgCollection c = new MsgCollection();
			c.putText("我很好 qaq");
			msg.getGroup().sendMsg(c);
		}
	}
    
}
