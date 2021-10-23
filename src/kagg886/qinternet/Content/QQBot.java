package kagg886.qinternet.Content;
import kagg886.qinternet.Interface.GroupAPI;
import kagg886.qinternet.Interface.MemberAPI;
import kagg886.qinternet.Interface.FriendAPI;
import kagg886.qinternet.Interface.API;

public class QQBot {
	private GroupAPI groupapi;
	private MemberAPI memberapi;
	private FriendAPI friendapi;
	private long qid;
	
	public QQBot(long qid) {
		this.qid = qid;
	}
	
	public void setGroupAPI(GroupAPI api) {
		this.groupapi = api;
	}
	
	public void setFriendAPI(FriendAPI api) {
		this.friendapi = api;
	}
	
	public void setMemberAPI(MemberAPI api) {
		this.memberapi = api;
	}
	
	public GroupAPI getGroupAPI() {
		return groupapi;
	}
	
	public FriendAPI getFriendAPI() {
		return friendapi;
	}
	
	public MemberAPI getMemberAPI() {
		return memberapi;
	}
	
	public long getId() {
		return qid;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof QQBot)) {
			return false;
		}
		return ((QQBot) obj).getId() == this.getId();
	}
	
	
}
