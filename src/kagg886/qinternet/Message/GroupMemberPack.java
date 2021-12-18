package kagg886.qinternet.Message;
import kagg886.qinternet.Content.Group;
import kagg886.qinternet.Content.Person;

public class GroupMemberPack
{
	protected Group group;
	protected Person[] member;
	protected Type p;
	
	public static enum Type {
		enter,leave,kick,adminChange;
	}
	
	public GroupMemberPack(Group g,Type p,Person... var) throws IllegalArgumentException {
		this.group = g;
		this.p = p;
		
		if ((p == Type.kick|| p == Type.adminChange) && var.length == 1) {
			throw new IllegalArgumentException("If this pack's type is Type.kick or Type.adminChange, you must input two variables: the receiver and the original");
		} else if ((p == Type.kick && var.length > 2) || (p != Type.kick && var.length >= 2)) {
			throw new IllegalArgumentException("We don't allow this type to input multiple variables");
		}
		
		this.member = var;
	}
	
	public Group getGroup() {
		return group;
	}
	
	public Person getMember() {
		return member[0];
	}
	
	public Type getType() {
		return p;
	}
	
	public Person getOriginal() {
		if (member.length == 1) {
			return null;
		}
		return member[1];
	}
}
