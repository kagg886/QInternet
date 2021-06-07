package kagg886.HydrogenPlugin.Message;
import com.QR.MsgApi.PluginMsg;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONObject;

public class MemberInfo
{
	private String nick,area,title,qName,specialTitle;
	private JSONObject source;
	private int age,permission;
	private long qq;
	public MemberInfo(JSONObject ary) throws Exception {
		ary = ary.getJSONArray("3").getJSONObject(0);
		this.source = ary;
		//通用属性
		permission = ary.getJSONArray("27").getInt(0);
		qq = ary.getJSONArray("1").getLong(0);
		title = decodeFromJSONArray(ary.getJSONArray("13")).getString(0);
		qName = decodeFromJSONArray(ary.getJSONArray("11")).getString(0);
		age = ary.getJSONArray("12").getInt(0);
		
		try {
			area = decodeFromJSONArray(ary.getJSONArray("10")).getString(0);
		} catch (Exception e) {
			area = "幻想乡";
		}
		if (ary.getJSONArray("8").getString(0).length() > 2) {
			nick = decodeFromJSONArray(ary.getJSONArray("8")).getString(0);
		} else {
			nick = qName;
		}
		
		try {
			specialTitle = decodeFromJSONArray(ary.getJSONArray("31")).getString(0);
		} catch (Exception e) {
			specialTitle = title;
		}
		
	}
	
	private static JSONArray decodeFromJSONArray(JSONArray ary) throws Exception {
		JSONArray ar = new JSONArray();
		for (int i = 0; i < ary.length(); i++) {
			ar.put(decode(ary.getString(i)));
		}
		return ar;
	}
	
	public int getPermission() {
		return permission;
	}
	
	public long getQQ() {
		return qq;
	}
	
	public String getName() {
		return qName;
	}
	
	public int getAge() {
		return age;
	}
	
	public JSONObject getSource() {
		return source;
	}
	
	public String getNick() {
		return nick;
	}
	
	public String getArea() {
		return area;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getSpecialTitle() {
		return specialTitle;
	}
	
	private static String decode(String hexStr) {
		String str = "0123456789ABCDEF";
        char[] hexs = hexStr.toCharArray();
        byte[] bytes = new byte[hexStr.length() / 2];
        int n;
        for (int i = 0; i < bytes.length; i++) {
            n = str.indexOf(hexs[2 * i]) * 16;
            n += str.indexOf(hexs[2 * i + 1]);
            bytes[i] = (byte) (n & 0xff);
        }
        return new String(bytes);
	}
}
