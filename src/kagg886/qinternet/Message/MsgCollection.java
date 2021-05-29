package kagg886.qinternet.Message;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Random;
import kagg886.qinternet.Interface.MsgIterator;

public class MsgCollection extends JSONArray
{
    private static final Random r = new Random();
	
	public static enum MsgType {
		text,img,xml,json;
	}
	
	public MsgCollection() {
		super();
	}
	
    public MsgCollection(String json) throws JSONException {
        super(json);
    }
    
    public void putText(String Text) {
        putElement(MsgType.text,Text);
    }
    
	public void putJson(String json) {
		putElement(MsgType.json,json);
	}
	
	public void putxml(String xml) {
		putElement(MsgType.xml,xml);
	}
	
    public void putImage(String imgUrl) {
        putElement(MsgType.img,imgUrl);
    }
    
    public String getJSON() {
        return search(MsgType.json);
    }
    
    public String getXml() {
        return search(MsgType.xml);
    }
    
    public String getTexts() {
        return search(MsgType.text);
    }
    
    public void iterator(MsgIterator it) {
        JSONObject obj;
        for (int i = 0; i < this.length(); i++) {
            try {
                obj = this.getJSONObject(i);
                switch (obj.getString("type")) {
                    case "text":
						it.onText(obj.getString("value"));
                        break;
                    case "json":
						it.onJson(obj.getString("value"));
                        break;
                    case "xml":
						it.onXml(obj.getString("value"));
                        break;
                    case "img":
						it.onImage(obj.getString("value"));
						break;
                }

            } catch (JSONException e) {}
        }
        obj = null;
    }
    
	private void putElement(MsgType type,String Text) {
		JSONObject obj = new JSONObject();
        try {
            obj.put("type", type.toString());
            obj.put("value",Text);
            obj.put("HashTag",r.nextInt());
            this.put(obj);
        } catch (JSONException e) {}
		obj = null;
	}
    
    private String search(MsgType msgType) {
        StringBuilder build = new StringBuilder();
        JSONObject obj;
        for (int i = 0; i < this.length(); i++) {
            try {
                obj = this.getJSONObject(i);
                if (obj.getString("type").equals(msgType.toString())) {
                    build.append(obj.getString("value"));
                }

            } catch (JSONException e) {}
        }
        obj = null;
        return build.toString();
    }
}
