package kagg886.qinternet.Interface;
import java.util.ArrayList;
import kagg886.qinternet.Content.Member;
import org.json.JSONArray;
import kagg886.qinternet.Message.MsgCollection;
import kagg886.qinternet.exceptions.PermissionException;

public interface GroupAPI extends API
{
    void exit(long gid);
	void setAllmute(long gid,boolean status) throws PermissionException;
    void sendMsg(long gid,MsgCollection ary);
	Member getMember(long gid,long qq);
	ArrayList<Long> getMembers(long gid);
	
}
