package kagg886.qinternet;

import kagg886.qinternet.Interface.API;
import kagg886.qinternet.Interface.GroupAPI;
import kagg886.qinternet.Interface.MemberAPI;
import java.util.HashMap;
import kagg886.qinternet.Interface.FriendAPI;

public final class QInternet 
{
	public static final String Author =  "kagg886";
	public static final String Version = "dev-20210606";
	private static HashMap<Long,HashMap<String,API>> apis = new HashMap<Long,HashMap<String,API>>();  
	
	public static enum APIType {
		GROUPAPI,MEMBERAPI,FRIENDAPI;
	}
	
	public static void initGroupAPI(long QQ,GroupAPI api1) {
		putAPI(APIType.GROUPAPI,QQ,api1);
	}
	
	public static void initMemberAPI(long QQ,GroupAPI api1) {
		putAPI(APIType.MEMBERAPI,QQ,api1);
	}
	
	public static void initFriendAPI(long QQ,FriendAPI api1) {
		putAPI(APIType.FRIENDAPI,QQ,api1);
	}
	
	public static GroupAPI getGroupAPI(long QQ) {
		return (GroupAPI) getAPI(QQ,APIType.GROUPAPI);
	}
	
	public static MemberAPI getMemberAPI(long QQ) {
		return (MemberAPI) getAPI(QQ,APIType.MEMBERAPI);
	}
	
	public static FriendAPI getFriendAPI(long QQ) {
		return (FriendAPI) getAPI(QQ,APIType.FRIENDAPI);
	}
	
	private static void putAPI(APIType key,long QQ,API api1) {
		HashMap<String,API> api;
		if (apis.containsKey(QQ)) {
			api = apis.get(QQ);
		} else {
			api = new HashMap<String,API>();
		}
		api.put(key.toString(),api1);
		apis.put(QQ,api);
	}
	
	private static API getAPI(long QQ,APIType type) {
		HashMap<String,API> api;
		if (apis.containsKey(QQ)) {
			api = apis.get(QQ);
		} else {
			return null;
		}
		
		return api.get(type.toString());
	}
	
}
