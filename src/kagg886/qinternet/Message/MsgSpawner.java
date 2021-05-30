package kagg886.qinternet.Message;

public class MsgSpawner
{
	
	public static MsgCollection newPlainText(String... text) {
		MsgCollection c = new MsgCollection();
		for (String s : text) {
			c.putText(s);
		}
		return c;
	}
	
	public static MsgCollection newAtToast(long qq,String... text) {
		MsgCollection c = new MsgCollection();
		c.putAt(qq);
		c.putText("\n");
		for (String s : text) {
			c.putText(s);
		}
		return c;
	}
	
}
