package kagg886.qinternet.Message;

import kagg886.qinternet.Content.Group;
import kagg886.qinternet.Content.Member;
import org.json.JSONException;
import org.json.JSONObject;

public class GroupMsgPack {
    protected Group g;

    protected Member m;

    protected MsgCollection ary;

    public GroupMsgPack(Group g, Member m, MsgCollection ary) {
        this.g = g;
        this.m = m;
        this.ary = ary;
    }

    public GroupMsgPack(String source) throws JSONException {
        JSONObject object = new JSONObject(source);
        this.g = new Group(object.getJSONObject("group").toString());
        this.m = new Member(object.getJSONObject("member").toString());
        this.ary = new MsgCollection(object.getJSONArray("msg").toString());
    }

    public Group getGroup() {
        return this.g;
    }

    public Member getMember() {
        return this.m;
    }

    public MsgCollection getMessage() {
        return this.ary;
    }

    public String toString() {
        JSONObject object = new JSONObject();
        try {
            object.put("group", this.g);
            object.put("member", this.m);
            object.put("msg", this.ary);
        } catch (JSONException jSONException) {}
        return object.toString();
    }
}
