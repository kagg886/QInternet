package kagg886.qinternet.Content;
import org.json.JSONException;
import kagg886.qinternet.Content.QQBot;
import kagg886.qinternet.QInternet;

public class Person extends Content
{
	public static enum Sex {
		BOY,GIRL;
	}
	public Person(String source) throws JSONException {
		super(source);
	}
	public Person(QQBot bot,long uin,String uinName,int age,Sex sex,String area) {
		
		super(bot);
		try {
			super.put("uin", uin);
			super.put("uinName", uinName);
			super.put("age",age);
			super.put("sex",sex.toString());
			super.put("area",area);
		} catch (JSONException e) {}
	}
	
	public void sendLike(int count) {
		QInternet.findBot(getBotQQ()).getMemberAPI().sendLike(0L,getUin(),count);
	}
    
    public long getUin() {
        return super.optLong("uin");
    }
    
    public String getUinName() {
        return super.optString("uinName");
    }
	
	public int getAge() {
		return super.optInt("age");
	}
	
	public Sex getSex() {
		return Sex.valueOf(super.optString("sex"));
	}
	
	public String getArea() {
		return super.optString("area");
	}
}
