package kagg886.qinternet.Content;
import kagg886.qinternet.Interface.GroupAPI;
import kagg886.qinternet.QInternet;
import kagg886.qinternet.Interface.MemberAPI;
import kagg886.qinternet.Interface.FriendAPI;

public class Content
{
	protected long BotQQ;
	public Content(long botQQ) {
		this.BotQQ = botQQ;
	}
	
	public GroupAPI getGroupAPI() {
		return QInternet.getAPI(BotQQ,QInternet.APIType.GROUPAPI);
	}
	
	public MemberAPI getMemberAPI() {
		return QInternet.getAPI(BotQQ,QInternet.APIType.MEMBERAPI);
	}
	
	public FriendAPI getFriendAPI() {
		return QInternet.getAPI(BotQQ,QInternet.APIType.FRIENDAPI);
	}
}
