package kagg886.api;
import kagg886.qinternet.Interface.MemberAPI;
import kagg886.qinternet.exceptions.PermissionException;
import com.QR.MsgApi.PluginMsg;
import com.QR.Plugin.PluginProcessing;

public class QRMemberAPI implements MemberAPI {

	private long qq;
	@Override
	public long getBotQQ() {
		return qq;
	}
	
	public QRMemberAPI(long qq) {
		this.qq = qq;
	}


	@Override
	public void kick(long p1, long p2) throws PermissionException {
		PluginMsg m = new PluginMsg();
		m.type = 12;
		m.groupid = p1;
		m.uin = p2;
		PluginProcessing.send(m);
	}

	@Override
	public void mute(long p1, long p2, int p3) throws PermissionException {
		PluginMsg m = new PluginMsg();
		m.type = 10;
		m.groupid = p1;
		m.uin = p2;
		m.time = p3 * 60000;
		PluginProcessing.send(m);
	}

	@Override
	public void sendLike(long p1, long p2, int p3) {
		PluginMsg m = new PluginMsg();
		m.type = 8;
		m.groupid = p1;
		m.uin = p2;
		m.value = p3;
		PluginProcessing.send(m);
	}

	@Override
	public void setNick(long p1, long p2, String p3) throws PermissionException {
		PluginMsg m = new PluginMsg();
		m.type = 9;
		m.groupid = p1;
		m.uin = p2;
		m.uinName = p3;
		PluginProcessing.send(m);
	}

    
}
