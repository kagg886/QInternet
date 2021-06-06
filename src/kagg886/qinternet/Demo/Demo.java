package kagg886.qinternet.Demo;
import kagg886.qinternet.Interface.QQMsgListener;
import kagg886.qinternet.Message.GroupMsgPack;
import kagg886.qinternet.Message.GroupMemberApplicationPack;
import kagg886.qinternet.exceptions.PermissionException;
import kagg886.qinternet.Message.MsgCollection;
import kagg886.qinternet.Message.MsgSpawner;
import kagg886.qinternet.Message.GroupMemberPack;
import kagg886.qinternet.Message.FriendMsgPack;

public class Demo implements QQMsgListener
{

	@Override
	public void onFriendMsg(FriendMsgPack msg) {
		msg.getFriend().sendMsg(msg.getMessage());
	}


	@Override
	public void onMemberMsg(GroupMemberPack msg) {
		
	}
	

	@Override
	public void onGroupEnterApplication(GroupMemberApplicationPack pack) {
		pack.agree();
	}

    @Override
    public void onGroupMsg(GroupMsgPack msg) {
		String text = msg.getMessage().getTexts(); //获取文字消息
		if (text.matches("muteme")) {
			try {
				msg.getMember().mute(1);
			} catch (PermissionException e) {}
		}
		
		if (text.matches("kick")) {
			try {
				msg.getMember().kick();
			} catch (PermissionException e) {}
		}
		
		if (text.matches(".ts")) {
			String a = "waq";
			String b = "awa";
			MsgCollection c = MsgSpawner.newPlainText("颜文字1:",a,"\n颜文字2",b);
			msg.getGroup().sendMsg(c);
		}
    }
    
}
