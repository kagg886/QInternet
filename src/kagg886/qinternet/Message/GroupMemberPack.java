package kagg886.qinternet.Message;

import kagg886.qinternet.Content.Group;
import kagg886.qinternet.Content.Person;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GroupMemberPack{
    protected Group group;

    protected Person[] member;

    protected Type p;

    public enum Type {
        enter, leave, kick, adminChange;
    }

    @Override
    public String toString() {
        JSONObject object = new JSONObject();
        try {
            object.put("group",group);
            object.put("type",p.toString());
            JSONArray array = new JSONArray();
            for (Person p : member) {
                array.put(p);
            }
            object.put("members",array);
        } catch (JSONException e) {

        }
        return object.toString();
    }

    public GroupMemberPack(String source) throws JSONException {
        JSONObject object = new JSONObject(source);
        this.group = new Group(object.getJSONObject("group").toString());
        this.p = Type.valueOf(object.getString("type"));
        JSONArray members = object.getJSONArray("members");
        member = new Person[members.length()];
        for (int i = 0; i < members.length(); i++) {
            member[i] = new Person(members.getJSONObject(i).toString());
        }
    }

    public GroupMemberPack(Group g, Type p, Person... var) throws IllegalArgumentException {
        this.group = g;
        this.p = p;
        if ((p == Type.kick || p == Type.adminChange) && var.length == 1)
            throw new IllegalArgumentException("If this pack's type is Type.kick or Type.adminChange, you must input two variables: the receiver and the original");
        if ((p == Type.kick && var.length > 2) || (p != Type.kick && var.length >= 2))
            throw new IllegalArgumentException("We don't allow this type to input multiple variables");
        this.member = var;
    }

    public Group getGroup() {
        return this.group;
    }

    public Person getMember() {
        return this.member[0];
    }

    public Type getType() {
        return this.p;
    }

    public Person getOriginal() {
        if (this.member.length == 1)
            return null;
        return this.member[1];
    }
}
