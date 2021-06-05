package kagg886.qinternet.Content;
import kagg886.qinternet.Interface.GroupAPI;
import kagg886.qinternet.Message.MsgCollection;
import kagg886.qinternet.exceptions.PermissionException;
import kagg886.qinternet.QInternet;

public class Group extends Content
{
    protected long groupId;
    protected String groupName;
    
    public Group(long BotQQ,long g,String n) {
		super(BotQQ);
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
		getGroupAPI().exit(groupId);
	}
	
	public void setMute(boolean status) throws PermissionException {
		getGroupAPI().setAllmute(groupId,status);
	}
	
	public void sendMsg(MsgCollection co) {
		getGroupAPI().sendMsg(groupId,co);
	}
}
