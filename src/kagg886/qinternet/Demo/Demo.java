package kagg886.qinternet.Demo;

import kagg886.qinternet.Content.Friend;
import kagg886.qinternet.Interface.QQMsgListener;
import kagg886.qinternet.Message.*;

public class Demo implements QQMsgListener {

    @Override
    public void onFriendChange(FriendChangePack msg) {
        if (msg.getType() == FriendChangePack.Type.addRequest) {
            msg.agree(); //防止非法调用
        }

        if (msg.getType() == FriendChangePack.Type.addSuccess) {
            Friend g = (Friend) msg.getPerson();
            g.sendMsg(MsgSpawner.newPlainText("hi"));
        }

    }


    @Override
    public void onFriendMsg(FriendMsgPack msg) {
        msg.getFriend().sendMsg(msg.getMessage()); //复读
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
            msg.getMember().mute(1);
        }

        if (text.matches("kick")) {
            msg.getMember().kick();
        }

        if (text.matches(".ts")) {
            String a = "waq";
            String b = "awa";
            MsgCollection c = MsgSpawner.newPlainText("颜文字1:", a, "\n颜文字2", b); //自动配置的MsgSpawner
            msg.getGroup().sendMsg(c);
        }
    }

}
