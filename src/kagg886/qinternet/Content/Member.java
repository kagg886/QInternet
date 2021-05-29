package kagg886.qinternet.Content;
import kagg886.qinternet.Interface.MemberAPI;
import kagg886.qinternet.exceptions.PermissionException;
public class Member extends Person
{
	protected long groupid;
    protected MemberAPI api;
    protected String nick;
    public static enum Permission {
        MEMBER,ADMIN,OWNER;
    }
    
    protected Permission p;
    
    public Member(long groupid,long uin, String uinName,String nick,Permission p,MemberAPI api) {
		super(uin,uinName);
        this.p = p;
        this.api = api;
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
		api.mute(groupid,uin,second);
	}
	
	public void kick() throws PermissionException {
		api.kick(groupid,uin);
	}
	
	public void sendLike(int count) {
		api.sendLike(0L,uin,count);
	}
	
	public void setNick(String nick) throws PermissionException {
		api.setNick(groupid,uin,nick);
	}
}
