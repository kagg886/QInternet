package kagg886.HydrogenPlugin.Message;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

public class GroupInfo 
{
	private JSONArray ary;
	private long groupid,ownerQQ;
	private String groupName,latestBroadCastDigest,Descride;
	private int people;
	
	public GroupInfo(JSONObject obj) throws JSONException {
		ary = obj.getJSONArray("0").getJSONObject(3).getJSONArray("3").getJSONObject(0).getJSONArray("0");
		
		groupid = Long.parseLong(getString(1));
		groupName = getString(2);
		latestBroadCastDigest = getString(3);
		ownerQQ = Long.parseLong(getString(4));
		Descride = getString(7);
		people = Integer.parseInt(getString(9));
	}
	
	private String getString(int count) throws JSONException {
		JSONObject ba = ary.getJSONObject(count);
		return decode(ba.getString(String.valueOf(count)));
		
	}
	
	private static String decode(String hexStr) {
		if (hexStr.matches("[0-9]+")) return hexStr;
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
	
	public long getId() {
		return groupid;
	}
	
	public String getName() {
		return groupName;
	}
	
	public String getLatestBroadCastDigest() {
		return latestBroadCastDigest;
	}
	
	public long getOwnerQQ() {
		return ownerQQ;
	}
	
	public String getDescribe() {
		return Descride;
	}
	
	public int getPeopleSize() {
		return people;
	}
}
