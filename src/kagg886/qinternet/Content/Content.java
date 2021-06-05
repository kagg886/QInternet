package kagg886.qinternet.Content;
import kagg886.qinternet.Interface.GroupAPI;
import kagg886.qinternet.QInternet;
import kagg886.qinternet.Interface.MemberAPI;

public class Content
{
	protected long BotQQ;
	public Content(long botQQ) {
		this.BotQQ = botQQ;
	}
	
	public GroupAPI getGroupAPI() {
		return QInternet.getGroupAPI(BotQQ);
	}
	
	public MemberAPI getMemberAPI() {
		return QInternet.getMemberAPI(BotQQ);
	}
}
