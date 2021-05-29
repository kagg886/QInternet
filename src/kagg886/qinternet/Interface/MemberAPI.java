package kagg886.qinternet.Interface;
import kagg886.qinternet.exceptions.PermissionException;

public interface MemberAPI
{
    void kick(long gid,long qq) throws PermissionException;
    void setNick(long gid,long qq,String nick) throws PermissionException;
    void mute(long gid,long qq,int second) throws PermissionException;
	void sendLike(long gid,long qq,int count);
}
