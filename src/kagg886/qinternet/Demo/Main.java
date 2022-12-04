package kagg886.qinternet.Demo;

import kagg886.qinternet.Content.Group;
import kagg886.qinternet.Content.Person;
import kagg886.qinternet.Content.QQBot;
import kagg886.qinternet.Message.GroupMemberPack;
import org.json.JSONException;
import org.json.JSONObject;

public class Main {
    //{"msg":"{\"members\":[{\"area\":\"幻想乡\",\"nick\":\"形同虚设\",\"sex\":\"BOY\",\"groupid\":716766495,\"permission\":\"MEMBER\",\"uin\":485184047,\"uinName\":\"形同虚设\",\"botQQ\":1693256674,\"age\":0}],\"type\":\"enter\",\"group\":{\"groupid\":716766495,\"groupname\":\"机器人测群2号\",\"botQQ\":1693256674}}","action":"onMember"}
    public static void main(String[] args) throws JSONException {
		QQBot b = new QQBot(1693256674);
		Group g = new Group(b,572360632,"次元空间");
		Person p = new Person(b,485184047,"1up",3, Person.Sex.BOY,"幻想乡");
        GroupMemberPack pack = new GroupMemberPack(g, GroupMemberPack.Type.enter,p);
		System.out.println(pack);
		GroupMemberPack m = new GroupMemberPack(pack.toString());
		System.out.println(m);
    }
}
