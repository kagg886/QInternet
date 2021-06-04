package kagg886.qinternet;

import kagg886.qinternet.Interface.API;
import kagg886.qinternet.Interface.GroupAPI;
import kagg886.qinternet.Interface.MemberAPI;

public final class QInternet 
{
	public static final String Author =  "kagg886";
	public static final String Version = "dev-20210604";
	private static API groupAPI,memberAPI;
	
	public static void initGroupAPI(GroupAPI api1) {
		groupAPI = api1;
	}
	
	public static void initMemberAPI(GroupAPI api1) {
		memberAPI = api1;
	}
	
	public static GroupAPI getGroupAPI() {
		return (GroupAPI) groupAPI;
	}
	
	public static MemberAPI getMemberAPI() {
		return (MemberAPI) memberAPI;
	}
}
