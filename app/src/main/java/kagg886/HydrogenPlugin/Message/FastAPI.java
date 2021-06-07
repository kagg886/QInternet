package kagg886.HydrogenPlugin.Message;
import com.QR.MsgApi.PluginMsg;
import java.util.ArrayList;
import org.json.JSONException;
import com.QR.Plugin.PluginProcessing;

public class FastAPI
{
	
	public static GroupInfo getGroupInfo(long groupid) {
		PluginMsg b = new PluginMsg();
		b.type = PluginMsg.TYPE_GET_GROUP_INFO;
		b.groupid = groupid;
		b = PluginProcessing.send(b);
		try {
			return new GroupInfo(b.json);
		} catch (JSONException e) {
			return null;
		}
	}
	
	public static MemberInfo getMemberInfo(long groupid, long qq) {
		PluginMsg m = new PluginMsg();
		m.type = PluginMsg.TYPE_GET_MEMBER_INFO;
		m.groupid = groupid;
		m.uin = qq;
		m = PluginProcessing.send(m);
		try {
			return new MemberInfo(m.json);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static ArrayList<Long> getBotGroups() {
		ArrayList<Long> call = new ArrayList<Long>();
		PluginMsg bl = new PluginMsg();
		bl.type = PluginMsg.TYPE_GET_GROUP_LIST;
		bl = PluginProcessing.send(bl);
		for (String unit : new FastPluginMsg(bl).chooseData("troop")) {
			call.add(Long.parseLong(unit.replace(" ","")));
		}
		//[{troop=[695860025, 716766495, 1087738308]}]
		return call;
	}
}
