package kagg886.HydrogenPlugin.Message;
import com.QR.MsgApi.PluginMsg;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class FastPluginMsg {
	
	public static final int TYPE_DATA_MSG=-1;//控制台消息
    public static final int TYPE_GROUP_MSG=0;//群消息
    public static final int TYPE_BYDDY_MSG=1;//好友消息
    public static final int TYPE_DIS_MSG=2;//讨论组消息
    public static final int TYPE_SESS_MSG=4;//临时消息
    public static final int TYPE_SYS_MSG=3;//系统消息
    public static final int TYPE_GET_GROUP_LIST=5;//群列表 | 
    public static final int TYPE_GET_GROUP_INFO=6;//群信息 | groupid
    public static final int TYPE_GET_GROUP_MEBMER=7;//群成员 | groupid
    public static final int TYPE_GET_MEMBER_INFO=14;//成员信息 | groupid uin
	public static final int TYPE_GET_MEMBER_INFO2=28;//成员信息 | groupid uin
    public static final int TYPE_FAVORITE=8;//点赞 | uin value
    public static final int TYPE_SET_MEMBER_CARD=9;//设置群名片 | groupid uin uinName
    public static final int TYPE_SET_MEMBER_SHUTUP=10;//成员禁言 | groupid uin time
    public static final int TYPE_SET_GROUP_SHUTUP=11;//群禁言 | groupid time
    public static final int TYPE_DELETE_MEMBER=12;//删除群成员 | groupid uin
    public static final int TYPE_AGREE_JOIN=13;//同意入群 | groupid uin reqid status value strmsg
    public static final int TYPE_GET_LOGIN_ACCOUNT=15;//获取机器人QQ,授权 | |返回 uin value
    public static final int TYPE_T=16;//重载
    public static final int TYPE_QQ_HB=17;//QQ发红包
	public static final int TYPE_QQ_GRABHB=18;//QQ抢红包 | groupid listid authkey skey
	public static final int TYPE_QQ_DETAILHB=29;//QQ查红包 | groupid listid authkey skey

	public static final int TYPE_GROUP_WITH_MSG=19;//群撤回消息
    public static final int TYPE_GET_GROUP_ADMIN=20;//群管理员 | groupid |返回 json
	public static final int TYPE_GROUP_JOIN=21;//申请进群 | groupid addMsg("msg","")
    public static final int TYPE_GROUP_DROPOUT=22;//退出群 | groupid
	public static final int TYPE_MSG_WITHDRAW=23;//撤回消息 | groupid msgbar
	public static final int TYPE_GET_GROUP_SELECT=24;//查询群选择状态 | groupid | 返回 value
	public static final int TYPE_GROUP_SELECT_SETPU=25;//设置群选择状态 | groupid value
	public static final int TYPE_RETREAT_GROUP_MSG=26;//退群消息
	public static final int TYPE_ADMIN_CHANGE_GROUP_MSG=27;//管理改变消息 | value 1上位 2下位
	
	
	protected PluginMsg msg;
	public FastPluginMsg(PluginMsg msg) {
		this.msg = msg;
	}

	public FastPluginMsg setMsg(PluginMsg msg) {
		this.msg = msg;
		return this;
	}

	public ArrayList<String> chooseData(String var1) {
        Iterator<Map<String,ArrayList<String>>> var4 = this.msg.data.iterator();
        while (var4.hasNext()) {
            for (Map.Entry<String,ArrayList<String>> var2 : var4.next().entrySet()) {
                if (var2.getKey().equals(var1)) {
                    ArrayList<String> var5 = var2.getValue();
                    return var5;
				}
			}
		}
		return null;
	}

	public String printData() {
		StringBuilder buf = new StringBuilder();
		for (Map<String,ArrayList<String>> data : msg.data) {
			for (Map.Entry ent : data.entrySet()) {
				buf.append(ent.getKey() + "---" + ent.getValue().toString());
				buf.append("\n");
			}
			buf.append("——————\n");
		}
		return buf.toString();
	}
	
	public String getFieldValue() {
		StringBuilder b = new StringBuilder();
        Class<? extends PluginMsg> rtClass = msg.getClass();
        Field[] fields = rtClass.getFields();
        for (Field field : fields) {
			if (field.getName().startsWith("TYPE_")) continue;
			try {
				b.append(field.getName() + "---" + field.get(msg).toString() + "\n");
			} catch (Exception e) {
				try {
					b.append(field.getName() + "---" + field.get(msg) + "\n");
				} catch (IllegalArgumentException e1) {} catch (IllegalAccessException e1) {}
			}
		}
		return b.toString().substring(0,b.length() - 1);
	}
}
