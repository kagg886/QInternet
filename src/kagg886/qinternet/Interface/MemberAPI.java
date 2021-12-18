package kagg886.qinternet.Interface;

import kagg886.qinternet.Message.MsgCollection;

public interface MemberAPI extends API
{
    boolean kick(long gid,long qq);
    boolean setNick(long gid,long qq,String nick);
    boolean mute(long gid,long qq,int second);
	boolean sendLike(long gid,long qq,int count);
	boolean sendTempMsg(long gid,long qq,MsgCollection co);
}
