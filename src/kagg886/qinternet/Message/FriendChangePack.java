package kagg886.qinternet.Message;
import kagg886.qinternet.Content.Person;
import kagg886.qinternet.Interface.FriendChangeAPI;

public class FriendChangePack
{
	public static enum Type {
		addRequest,addSuccess,del;
		//添加好友申请，好友添加成功，好友将你删除
	}
	
	private Person friend; //不知道是好友还是陌生人
	private Type type;
	private FriendChangeAPI api; //type为后两个时请传为null
	
	public FriendChangePack(Person f,Type t,FriendChangeAPI api) {
		this.friend = f;
		this.type = t;
		this.api = api;
	}
	
	public Type getType() {
		return type;
	}
	
	public Person getPerson() { //可以强转为好友
		return friend;
	}
	
	public void agree(){
		if (type != Type.addRequest) {
			throw new IllegalArgumentException("This msg isn't belong to AddFriend!");
		}
		
		api.agree();
	}
	
	public void reject(){
		if (type != Type.addRequest) {
			throw new IllegalArgumentException("This msg isn't belong to AddFriend!");
		}

		api.reject();
	}
}
