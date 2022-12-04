package kagg886.qinternet.Message;

public class MsgSpawner {
	public static MsgCollection newPlainText(String... text) {
		MsgCollection c = new MsgCollection();
		byte b;
		int i;
		String[] arrayOfString;
		for (i = (arrayOfString = text).length, b = 0; b < i; ) {
			String s = arrayOfString[b];
			c.putText(s);
			b++;
		}
		return c;
	}

	public static MsgCollection newAtToast(long qq, String... text) {
		MsgCollection c = new MsgCollection();
		c.putAt(qq);
		c.putText("\n");
		byte b;
		int i;
		String[] arrayOfString;
		for (i = (arrayOfString = text).length, b = 0; b < i; ) {
			String s = arrayOfString[b];
			c.putText(s);
			b++;
		}
		return c;
	}

	public static MsgCollection newReply(MsgCollection source, String... text) {
		MsgCollection c = new MsgCollection(source.getFromReplyId());
		byte b;
		int i;
		String[] arrayOfString;
		for (i = (arrayOfString = text).length, b = 0; b < i; ) {
			String s = arrayOfString[b];
			c.putText(s);
			b++;
		}
		return c;
	}
}
