package kagg886.qinternet.Content;
import kagg886.qinternet.Interface.GroupAPI;
import kagg886.qinternet.QInternet;
import kagg886.qinternet.Interface.MemberAPI;
import kagg886.qinternet.Interface.FriendAPI;
import org.json.JSONObject;
import org.json.JSONException;

public class Content extends JSONObject
{
	public Content(QQBot botQQ) {
		try {
			super.put("botQQ", botQQ.getId());
		} catch (JSONException e) {}
	}
	
	public Content(String source) throws JSONException {
		super(source);
	}
	
	public long getBotQQ() {
		return optLong("botQQ");
	}
}
