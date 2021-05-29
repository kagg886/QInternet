package kagg886.qinternet.Content;
import kagg886.qinternet.Interface.GroupAPI;
import kagg886.qinternet.Message.MsgCollection;
import kagg886.qinternet.exceptions.PermissionException;

public class Group
{
    protected long groupId;
    protected String groupName;
    protected GroupAPI api;
    
    public Group(long g,String n,GroupAPI a) {
        this.groupId = g;
        this.groupName = n;
        this.api = a;
    }
    
    public long getId() {
        return groupId;
    }
    
    public String getName() {
        return groupName;
    }
	
	public void exit() {
		api.exit(groupId);
	}
	
	public void setMute(boolean status) throws PermissionException {
		api.setAllmute(groupId,status);
	}
    
    public GroupAPI getAPI() {
        return api;
    }
	
	public void sendMsg(MsgCollection co) {
		api.sendMsg(groupId,co);
	}
}
