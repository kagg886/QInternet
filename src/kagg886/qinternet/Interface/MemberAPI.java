package kagg886.qinternet.Interface;
import kagg886.qinternet.exceptions.PermissionException;
import kagg886.qinternet.Message.MsgCollection;

public interface MemberAPI extends API
{
    void kick(long gid,long qq) throws PermissionException;
    void setNick(long gid,long qq,String nick) throws PermissionException;
    void mute(long gid,long qq,int second) throws PermissionException;
	void sendLike(long gid,long qq,int count);
	void sendTempMsg(long gid,long qq,MsgCollection co);
}
