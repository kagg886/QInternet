package kagg886.qinternet.Content;
import kagg886.qinternet.Interface.GroupAPI;
import kagg886.qinternet.Message.MsgCollection;
import kagg886.qinternet.exceptions.PermissionException;
import kagg886.qinternet.QInternet;

public class Group
{
    protected long groupId;
    protected String groupName;
    
    public Group(long g,String n) {
        this.groupId = g;
        this.groupName = n;
    }
    
    public long getId() {
        return groupId;
    }
    
    public String getName() {
        return groupName;
    }
	
	public void exit() {
		QInternet.getGroupAPI().exit(groupId);
	}
	
	public void setMute(boolean status) throws PermissionException {
		QInternet.getGroupAPI().setAllmute(groupId,status);
	}
	
	public void sendMsg(MsgCollection co) {
		QInternet.getGroupAPI().sendMsg(groupId,co);
	}
}
