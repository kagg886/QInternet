package kagg886.api;
import kagg886.qinternet.Interface.GroupAPI;
import kagg886.qinternet.Content.Member;
import java.util.ArrayList;
import kagg886.qinternet.Message.MsgCollection;
import kagg886.qinternet.exceptions.PermissionException;
import com.QR.MsgApi.PluginMsg;
import com.QR.Plugin.PluginProcessing;
import kagg886.qinternet.Interface.MsgIterator;

public class QRGroupAPI implements GroupAPI {
	
	private long qq;
	@Override
	public long getBotQQ() {
		return qq;
	}
	
	public QRGroupAPI(long qq) {
		this.qq = qq;
	}

	@Override
	public void exit(long p1) {
		PluginMsg m = new PluginMsg();
		m.type = 22;
		m.groupid = p1;
		PluginProcessing.send(m);
	}

	@Override
	public Member getMember(long p1, long p2) {
		return null;
	}

	@Override
	public ArrayList<Long> getMembers(long p1) {
		return null;
	}

	@Override
	public void sendMsg(long p1, MsgCollection p2) {
		final PluginMsg m = new PluginMsg();
		m.type = 0;
		m.groupid = p1;
		p2.iterator(new MsgIterator() {

				@Override
				public void onImage(String p1) {
					m.addMsg("img",p1);
				}

				@Override
				public void onJson(String p1) {
					m.addMsg("json",p1);
				}

				@Override
				public void onPtt(String p1) {
					m.addMsg("ptt",p1);
				}

				@Override
				public void onText(String p1) {
					m.addMsg("msg",p1);
				}

				@Override
				public void onXml(String p1) {
					m.addMsg("xml",p1);
				}
			});
		PluginProcessing.send(m);
	}

	@Override
	public void setAllmute(long p1, boolean p2) throws PermissionException {
	    PluginMsg m = new PluginMsg();
		m.type = 11;
		if (p2) {
			m.time = 1;
		} else {
			m.time = 0;
		}
		m.groupid = p1;
		PluginProcessing.send(m);
		
		
	}

    
}
