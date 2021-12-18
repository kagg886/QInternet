package kagg886.qinternet.Content;
import kagg886.qinternet.Interface.MemberAPI;
import kagg886.qinternet.QInternet;
import org.json.JSONException;
public class Member extends Person
{
    public static enum Permission {
        MEMBER,ADMIN,OWNER;
    }
	
	public Member(String source) throws JSONException {
		super(source);
	}
    
    
    public Member(QQBot bot,long groupid,long uin, String uinName,int age,Sex sex,String area,String nick,Permission p) {
		super(bot,uin,uinName,age,sex,area);
		try {
			super.put("groupid", groupid);
			super.put("permission",p.toString());
			super.put("nick",nick);
		} catch (JSONException e) {}
    }
    
    public String getNick() {
        return super.optString("nick");
    }
    
    public Permission getPermission() {
        return Permission.valueOf("permission");
    }
    
    public boolean mute(int second){
		return QInternet.findBot(getBotQQ()).getMemberAPI().mute(super.optLong("group"),super.optLong("uin"),second);
	}
	
	public boolean kick(){
		return QInternet.findBot(getBotQQ()).getMemberAPI().kick(super.optLong("group"),super.optLong("uin"));
	}
	
	
	public boolean setNick(String nick) {
		return QInternet.findBot(getBotQQ()).getMemberAPI().setNick(super.optLong("group"),super.optLong("uin"),nick);
	}
}
