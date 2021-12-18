package kagg886.qinternet.Content;
import kagg886.qinternet.Interface.GroupAPI;
import kagg886.qinternet.Message.MsgCollection;
import kagg886.qinternet.QInternet;
import org.json.JSONException;

public class Group extends Content
{
	public Group(String source) throws JSONException {
		super(source);
	}
    public Group(QQBot BotQQ,long g,String n) {
		super(BotQQ);
        try {
			super.put("groupid", g);
			super.put("groupname", n);
		} catch (JSONException e) {}
    }
    
    public long getId() {
        return super.optLong("groupid");
    }
    
    public String getName() {
        return super.optString("groupname");
    }
	
	public void exit() {
		QInternet.findBot(getBotQQ()).getGroupAPI().exit(getId());
	}
	
	public boolean setMute(boolean status){
		return QInternet.findBot(getBotQQ()).getGroupAPI().setAllmute(getId(),status);
	}
	
	public void sendMsg(MsgCollection co) {
		QInternet.findBot(getBotQQ()).getGroupAPI().sendMsg(getId(),co);
	}
}
