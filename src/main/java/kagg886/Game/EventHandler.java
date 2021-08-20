package kagg886.Game;

import kagg886.Game.API.MessageConverter;
import kagg886.qinternet.QInternet;
import kagg886.qinternet.Interface.FriendAPI;
import kagg886.qinternet.Interface.GroupAPI;
import kagg886.qinternet.Interface.QQMsgListener;
import kagg886.qinternet.Message.FriendMsgPack;
import kagg886.qinternet.Message.GroupMsgPack;
import kagg886.qinternet.QInternet.APIType;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.FriendAddEvent;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.event.events.NewFriendRequestEvent;

public class EventHandler extends SimpleListenerHost {
	
	@net.mamoe.mirai.event.EventHandler
	public void onMessage(NewFriendRequestEvent event) {
		event.accept();
	}
	
	@net.mamoe.mirai.event.EventHandler
	public void onMessage(FriendAddEvent event) {
		
	}

	@net.mamoe.mirai.event.EventHandler
	public void onMessage(GroupMessageEvent event) {
		Bot bot = event.getBot();
		GroupMsgPack pack = null;
		try {
			pack = new GroupMsgPack(getAPIGroup(bot).getGroup(event.getGroup().getId()),
					getAPIGroup(bot).getMember(event.getGroup().getId(), event.getSender().getId()),
					MessageConverter.MessageChainToMsgCollection(event.getMessage()));
		} catch (Exception e) {
			event.getBot().getLogger().debug("群消息构建异常");
		}
		for (QQMsgListener listener : Main.pluginList) {
			listener.onGroupMsg(pack);
		}
	}

	@net.mamoe.mirai.event.EventHandler
	public void onMessage(FriendMessageEvent event) {
		Bot bot = event.getBot();
		FriendMsgPack pack = new FriendMsgPack(getAPIFriend(bot).getFriend(event.getSender().getId()),
				MessageConverter.MessageChainToMsgCollection(event.getMessage()));
		for (QQMsgListener listener : Main.pluginList) {
			listener.onFriendMsg(pack);
		}
	}

	private GroupAPI getAPIGroup(Bot b) {
		return (GroupAPI) QInternet.getAPI(b.getId(), APIType.GROUPAPI);
	}

	private FriendAPI getAPIFriend(Bot b) {
		return (FriendAPI) QInternet.getAPI(b.getId(), APIType.FRIENDAPI);
	}
}
