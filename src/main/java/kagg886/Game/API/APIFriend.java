package kagg886.Game.API;

import java.util.ArrayList;

import kagg886.qinternet.Content.Friend;
import kagg886.qinternet.Content.Person.Sex;
import kagg886.qinternet.Interface.FriendAPI;
import kagg886.qinternet.Message.MsgCollection;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.message.data.MessageChain;

public class APIFriend implements FriendAPI {
	private Bot bot;
	public APIFriend(Bot n) {
		this.bot = n;
	}

	public long getBotQQ() {
		return bot.getId();
	}

	public void delete(long arg0) {
		bot.getFriend(arg0).delete();
	}

	public Friend getFriend(long arg0) {
		net.mamoe.mirai.contact.Friend friend = bot.getFriend(arg0);
		Friend friend1 = new Friend(getBotQQ(), friend.getId(), friend.getNick(),0, Sex.BOY, "幻想乡");
		return friend1;
	}

	public ArrayList<Long> getFriends() {
		ArrayList<Long> longs = new ArrayList<Long>();
		for (net.mamoe.mirai.contact.Friend f : bot.getFriends()) {
			longs.add(f.getId());
		}
		return longs;
	}

	public void sendMsg(long arg0, MsgCollection arg1) {
		MessageChain chain = MessageConverter.MsgCollectionToMessageChain(arg1);
		bot.getFriend(arg0).sendMessage(chain);
		
	}

}
