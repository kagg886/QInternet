package kagg886.Game;

import kagg886.Game.API.MessageConverter;
import kagg886.qinternet.QInternet;
import kagg886.qinternet.Interface.FriendAPI;
import kagg886.qinternet.Interface.GroupAPI;
import kagg886.qinternet.Message.GroupMsgPack;
import kagg886.qinternet.QInternet.APIType;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.GroupMessageEvent;

public class EventHandler extends SimpleListenerHost {
	
	@net.mamoe.mirai.event.EventHandler
	public void onMessage(GroupMessageEvent event) {
		Bot bot = event.getBot();
		GroupMsgPack pack = new GroupMsgPack(
				getAPIGroup(bot).getGroup(event.getGroup().getId()),
				getAPIGroup(bot).getMember(event.getGroup().getId(), event.getSender().getId()),
				MessageConverter.MessageChainToMsgCollection(event.getMessage()));
		
		Main.listener.onGroupMsg(pack);
	}
	
	
	
	
	
	
	
	private GroupAPI getAPIGroup(Bot b) {
		return (GroupAPI) QInternet.getAPI(b.getId(),APIType.GROUPAPI);
	}
	private FriendAPI getAPIFriend(Bot b) {
		return (FriendAPI) QInternet.getAPI(b.getId(),APIType.FRIENDAPI);
	}
}
