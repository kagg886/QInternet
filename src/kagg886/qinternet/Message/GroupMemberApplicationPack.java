package kagg886.qinternet.Message;

import kagg886.qinternet.Content.Group;
import kagg886.qinternet.Content.Person;
import kagg886.qinternet.Interface.GroupEnterAPI;

public class GroupMemberApplicationPack 
{
	protected Group g;
    protected Person p;
	protected GroupEnterAPI api;
	protected String application;
    public GroupMemberApplicationPack(Group g,Person p,String applicationText,GroupEnterAPI api) {
        this.g = g;
        this.p = p;
        this.api = api;
		this.application = applicationText;
    }


    public Group getGroup() {
        return g;
    }

    public Person getOriginal() {
        return p;
    }
	
	public void agree() {
		api.agree();
	}
	
	public void reject(String reason) {
		api.reject(reason);
	}
	
	public String getApplicatonText() {
		return application;
	}
}
