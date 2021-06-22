package kagg886.qinternet.Message;

public class MsgSpawner
{
	/*
		生成一个纯文本消息。
	*/
	public static MsgCollection newPlainText(String... text) {
		MsgCollection c = new MsgCollection();
		for (String s : text) {
			c.putText(s);
		}
		return c;
	}
	
	/*
	 	生成一个带AT的消息
	*/
	public static MsgCollection newAtToast(long qq,String... text) {
		MsgCollection c = new MsgCollection();
		c.putAt(qq);
		c.putText("\n");
		for (String s : text) {
			c.putText(s);
		}
		return c;
	}
	
	/*
		生成一个回复消息
	*/
	public static MsgCollection newReply(MsgCollection source,String... text) {
		MsgCollection c = new MsgCollection(source.getFromReplyId());
		for (String s : text) {
			c.putText(s);
		}
		return c;
	}
}
