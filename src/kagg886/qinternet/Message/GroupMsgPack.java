package kagg886.qinternet.Message;
import kagg886.qinternet.Content.Group;
import kagg886.qinternet.Content.Member;
import org.json.JSONObject;
import kagg886.qinternet.Message.MsgCollection;

public class GroupMsgPack
{
    protected Group g;
    protected Member m;
    protected MsgCollection ary;
    public GroupMsgPack(Group g,Member m,MsgCollection ary) {
        this.g = g;
        this.m = m;
        this.ary = ary;
    }


    public Group getGroup() {
        return g;
    }

    public Member getMember() {
        return m;
    }

    public MsgCollection getMessage() {
        return ary;
    }
}
