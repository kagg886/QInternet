package kagg886.qinternet.Message;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Random;
import kagg886.qinternet.Interface.MsgIterator;
import java.util.ArrayList;

public class MsgCollection extends JSONArray implements Cloneable
{
    private static final Random r = new Random();
	private long fromReplyId = -1;
	/*
		fromReplyId->当此对象由转接器发送时，我们约定该值为此消息对应的id；
		当此对象发送到转接器时，则约定该值为此消息将要回复的id
	*/
	public static enum MsgType {
		text,img,xml,json,ptt,at;
	}
	
	public MsgCollection() {
		super();
	}

	@Override
	public boolean equals(Object o){
		if (!(o instanceof MsgCollection)) {
			return false;
		}
		MsgCollection clone = null,
					  sample = (MsgCollection) o;
		
		try {
			clone = (MsgCollection) this.clone();
		} catch (CloneNotSupportedException e) {}
		
		if (clone.length() != sample.length()) {
			return false;
		}
		for (int i = 0; i < clone.length(); i++) {
			for (String b : new String[] {"type","value"}) {
				if (clone.optJSONObject(i).opt(b).equals(sample.optJSONObject(i).opt(b))) {
					continue;
				}
				return false;
			}
		}
		return true;
	}
	
	public boolean containMsgType(MsgType type) {
        for (int i = 0; i < this.length(); i++) {
            if (this.optJSONObject(i).optString("type").equals(type)) {
            	return true;
            }
        }
        return false;
	}
	
	public MsgCollection(long ReplyId) {
		super();
		this.fromReplyId = ReplyId;
	}
	
    public MsgCollection(String json) throws JSONException {
        super(json);
    }
	
	public void setFromReplyId(long rid) {
		this.fromReplyId = rid;
	}

	public long getFromReplyId() {
		return fromReplyId;
	}
	
	public int putAt(long at) {
		return putElement(MsgType.at,String.valueOf(at));
	}
    
	public int putPtt(String pttUrl) {
		return putElement(MsgType.ptt,pttUrl);
	}
	
    public int putText(String Text) {
        return putElement(MsgType.text,Text);
    }
    
	public int putJson(String json) {
		return putElement(MsgType.json,json);
	}
	
	public int putxml(String xml) {
		return putElement(MsgType.xml,xml);
	}
	
    public int putImage(String imgUrl) {
        return putElement(MsgType.img,imgUrl);
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
                switch (MsgType.valueOf(obj.getString("type"))) {
                    case text:
						it.onText(obj.getString("value"));
                        break;
                    case img:
						it.onImage(obj.getString("value"));
                        break;
                    case xml:
						it.onXml(obj.getString("value"));
                        break;
                    case json:
						it.onJson(obj.getString("value"));
						break;
					case ptt:
						it.onPtt(obj.getString("value"));
						break;
					case at:
						it.onAt(Long.parseLong(obj.getString("value")));
                }

            } catch (JSONException e) {}
        }
        obj = null;
    }
	
	public void removeMsg(int HashTag) {
		JSONObject obj;
        for (int i = 0; i < this.length(); i++) {
            try {
                obj = this.getJSONObject(i);
                if (obj.optInt("HashTag") == HashTag) {
					this.remove(i);
				}

            } catch (JSONException e) {}
        }
	}
    
	private int putElement(MsgType type,String Text) {
		JSONObject obj = new JSONObject();
		int tag = r.nextInt();
        try {
            obj.put("type", type.toString());
            obj.put("value",Text);
            obj.put("HashTag",tag);
            this.put(obj);
        } catch (JSONException e) {
			return -1;
		}
		obj = null;
		return tag;
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
