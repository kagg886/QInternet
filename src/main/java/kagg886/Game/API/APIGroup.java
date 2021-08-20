package kagg886.Game.API;

import java.util.ArrayList;

import kagg886.qinternet.Content.Group;
import kagg886.qinternet.Content.Member;
import kagg886.qinternet.Content.Member.Permission;
import kagg886.qinternet.Content.Person.Sex;
import kagg886.qinternet.Interface.GroupAPI;
import kagg886.qinternet.Message.MsgCollection;
import kagg886.qinternet.exceptions.PermissionException;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.contact.MemberPermission;
import net.mamoe.mirai.contact.NormalMember;
import net.mamoe.mirai.message.data.MessageChain;

public class APIGroup implements GroupAPI {
	
	private Bot bot;
	public static ArrayList<Long> groups;
	public static long stamp;
	public APIGroup(Bot n) {
		this.bot = n;
	}
	
	public long getBotQQ() {
		return bot.getId();
	}

	public void exit(long arg0) {
		// TODO Auto-generated method stub
		bot.getGroup(arg0).quit();
		
	}

	public Group getGroup(long arg0) {
		net.mamoe.mirai.contact.Group group = bot.getGroup(arg0);
		Group g = new Group(getBotQQ(), arg0, group.getName());
		return g;
	}

	public ArrayList<Long> getGroups() {
		ArrayList<Long> longs = new ArrayList<Long>();
		for (net.mamoe.mirai.contact.Group f : bot.getGroups()) {
			longs.add(f.getId());
		}
		return longs;
	}

	public Member getMember(long arg0, long arg1) {
		net.mamoe.mirai.contact.Member member = null;
		for (NormalMember long1 : bot.getGroup(arg0).getMembers()) {
			if (long1.getId() == arg1) {
				member = long1;
				break;
			}
		}
		if (member == null) {
			return null;
		}
		Member.Permission p;
		if (member.getPermission() == MemberPermission.MEMBER) {
			p = Permission.MEMBER;
		} else {
			p = Permission.ADMIN;
		}
		Member member2 = new Member(getBotQQ(),arg0,arg1,member.getNick(),0,Sex.BOY,"幻想乡",member.getNameCard(),p);
		return member2;
	}

	public ArrayList<Long> getMembers(long arg0) {
		ArrayList<Long> longs = new ArrayList<Long>();
		for (NormalMember long1 : bot.getGroup(arg0).getMembers()) {
			longs.add(long1.getId());
		}
		return longs;
	}

	public void sendMsg(long arg0, MsgCollection arg1) {
		MessageChain chain = MessageConverter.MsgCollectionToMessageChain(arg1,bot.getGroup(arg0));
		bot.getGroup(arg0).sendMessage(chain);
	}

	public void setAllmute(long arg0, boolean arg1) throws PermissionException {
		if (bot.getGroup(arg0).getBotPermission() == MemberPermission.MEMBER) {
			throw new PermissionException("不是管理员");
		}
		bot.getGroup(arg0).getSettings().setMuteAll(arg1);
	}

}
