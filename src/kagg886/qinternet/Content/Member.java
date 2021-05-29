package kagg886.qinternet.Content;
import kagg886.qinternet.Interface.MemberAPI;
import kagg886.qinternet.exceptions.PermissionException;
public class Member extends Person
{
    protected MemberAPI api;
    protected String nick;
    public static enum Permission {
        MEMBER,ADMIN,OWNER;
    }
    
    protected Permission p;
    
    public Member(long uin, String uinName,String nick,Permission p,MemberAPI api) {
        this.uin = uin;
        this.uinName = uinName;
        this.p = p;
        this.api = api;
        this.nick = nick;
    }
    
    public String getNick() {
        return nick;
    }
    
    public Permission getPermission() {
        return p;
    }
    
    public MemberAPI getAPI() {
        return api;
    }
}
