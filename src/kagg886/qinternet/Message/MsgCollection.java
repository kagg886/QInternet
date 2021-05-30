package kagg886.qinternet.Message;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Random;
import kagg886.qinternet.Interface.MsgIterator;
import java.util.ArrayList;

public class MsgCollection extends JSONArray
{
    private static final Random r = new Random();
	
	public static enum MsgType {
		text,img,xml,json,ptt,at;
	}
	
	public MsgCollection() {
		super();
	}
	
    public MsgCollection(String json) throws JSONException {
        super(json);
    }
	
	public void putAt(long at) {
		putElement(MsgType.at,String.valueOf(at));
	}
    
	public void putPtt(String pttUrl) {
		putElement(MsgType.ptt,pttUrl);
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
	
	public String getPtt() {
		return search(MsgType.ptt);
	}
    
    public String getJSON() {
        return search(MsgType.json);
    }
    
    public String getXml() {
        return search(MsgType.xml);
    }
	
	public ArrayList<Long> getAt() {
		ArrayList<Long> in = new ArrayList<Long>();
		JSONObject obj;
        for (int i = 0; i < this.length(); i++) {
            try {
                obj = this.getJSONObject(i);
                if (obj.getString("type").equals(MsgType.at.toString())) {
                    in.add(Long.parseLong(obj.getString("value")));
                }

            } catch (JSONException e) {}
        }
        obj = null;
        return in;
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
					case "ptt":
						it.onPtt(obj.getString("value"));
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
