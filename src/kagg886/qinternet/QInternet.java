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
	
	public static void initAPI(APIType type,long QQ,API api1) {
		HashMap<Class,API> api = apis.get(QQ);
		if (api == null) {
			api = new HashMap<Class,API>();
		}
		api.put(type.getDefaulClass(),api1);
		apis.put(QQ,api);
	}
	
	public static <T extends API> T getAPI(long QQ,APIType type) {
		HashMap <Class,API> api = apis.get(QQ);
		return api==null ? null : (T) api.get(type.getDefaulClass());
	}
}
