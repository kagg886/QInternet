package kagg886.qinternet.Interface;
import java.util.ArrayList;
import kagg886.qinternet.Content.Member;
import kagg886.qinternet.Message.MsgCollection;
import kagg886.qinternet.exceptions.PermissionException;
import kagg886.qinternet.Content.Group;

public interface GroupAPI extends API
{
    void exit(long gid);
	void setAllmute(long gid,boolean status) throws PermissionException;
    void sendMsg(long gid,MsgCollection ary);
	Member getMember(long gid,long qq);
	ArrayList<Long> getMembers(long gid);
	ArrayList<Long> getGroups();
	Group getGroup(long groupid);
}
