package kagg886.Game;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;

public class JSONStorage extends JSONObject
{
	private String path;
	
	public static String getJSON(String path) throws IOException {
		File file = new File(path);
		if (!file.exists())
		{
			file.getParentFile().mkdirs();
			file.createNewFile();
			return "{}";
		}
		BufferedReader reader = new BufferedReader(new FileReader(path));
		StringBuffer buffer = new StringBuffer();
		String l = null;
		while ((l = reader.readLine()) != null)
		{
			buffer.append(l);
		}
		reader.close();
		reader = null;
		return buffer.toString();
	}
	
	public void save()
	{
		try
		{
			BufferedWriter out = new BufferedWriter(new FileWriter(path));
			out.write(this.toString());
			out.close();
		} catch (IOException e) {
		}
	}
	
	public JSONStorage(String path) throws Exception
	{
		super(getJSON(path));
		this.path = path;
	}
}
