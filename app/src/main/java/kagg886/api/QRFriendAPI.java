package kagg886.api;
import com.QR.MsgApi.PluginMsg;
import com.QR.Plugin.PluginProcessing;
import kagg886.qinternet.Interface.FriendAPI;
import kagg886.qinternet.Interface.MsgIterator;
import kagg886.qinternet.Message.MsgCollection;

public class QRFriendAPI implements FriendAPI {
	private long qq;
	public QRFriendAPI(long qq) {
		this.qq = qq;
	}

	@Override
	public long getBotQQ() {
		return qq;
	}

	@Override
	public void delete(long p1) {
		
	}

	@Override
	public void sendMsg(long p1, MsgCollection p2) {
		final PluginMsg m = new PluginMsg();
		m.type = 1;
		m.uin = p1;
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

    
}
