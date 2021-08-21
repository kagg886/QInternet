package kagg886.qinternet;

import kagg886.qinternet.Interface.API;
import kagg886.qinternet.Interface.GroupAPI;
import kagg886.qinternet.Interface.MemberAPI;
import java.util.HashMap;
import kagg886.qinternet.Interface.FriendAPI;
import java.util.Map;
import java.util.LinkedList;
import java.util.ArrayList;

public final class QInternet 
{
	public static final String Author =  "kagg886";
	public static final String Version = "dev-20210818";
	private static HashMap<Long,HashMap<Class,API>> apis = new HashMap<Long,HashMap<Class,API>>();  
	
	public static enum APIType {
		GROUPAPI(GroupAPI.class),
		MEMBERAPI(MemberAPI.class),
		FRIENDAPI(FriendAPI.class);
		
		private Class clazz;
		
		private APIType(Class clazz) {
			this.clazz = clazz;
		}
		
		public Class getDefaulClass() {
			return clazz;
		}
	}
	
	public Long[] getBots() {
		ArrayList<Long> list = new ArrayList<Long>();
		for (Map.Entry<Long,HashMap<Class,API>> api: apis.entrySet()) {
			list.add(api.getKey());
		}
		
		return list.toArray(new Long[list.size()]);
	}
	
	public static void initAPI(APIType type,long QQ,API api1) {
		HashMap<Class,API> api = apis.get(QQ);
		if (api == null) {
			api = new HashMap<Class,API>();
		}
		api.put(type.getDefaulClass(),api1);
		apis.put(QQ,api);
	}
	
	public static <T extends API> T getAPI(APIType type, long QQ) {
		HashMap <Class,API> api = apis.get(QQ);
		return api==null ? null : (T) api.get(type.getDefaulClass());
	}
}
