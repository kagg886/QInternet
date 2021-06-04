package kagg886.qinternet.Content;
import kagg886.qinternet.Interface.MemberAPI;
import kagg886.qinternet.exceptions.PermissionException;
import kagg886.qinternet.QInternet;
public class Member extends Person
{
	protected long groupid;
    protected String nick;
    public static enum Permission {
        MEMBER,ADMIN,OWNER;
    }
    
    protected Permission p;
    
    public Member(long groupid,long uin, String uinName,String nick,Permission p) {
		super(uin,uinName);
        this.p = p;
        this.nick = nick;
		this.groupid = groupid;
    }
    
    public String getNick() {
        return nick;
    }
    
    public Permission getPermission() {
        return p;
    }
    
    public void mute(int second) throws PermissionException {
		QInternet.getMemberAPI().mute(groupid,uin,second);
	}
	
	public void kick() throws PermissionException {
		QInternet.getMemberAPI().kick(groupid,uin);
	}
	
	public void sendLike(int count) {
		QInternet.getMemberAPI().sendLike(0L,uin,count);
	}
	
	public void setNick(String nick) throws PermissionException {
		QInternet.getMemberAPI().setNick(groupid,uin,nick);
	}
}
