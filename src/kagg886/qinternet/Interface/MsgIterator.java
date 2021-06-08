package kagg886.qinternet.Interface;

public interface MsgIterator
{
    void onText(String value);
    void onImage(String imgUrl);
    void onXml(String xml);
    void onJson(String json);
	void onPtt(String pttUrl);
	void onAt(long at);
}
