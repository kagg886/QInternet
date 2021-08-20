package kagg886.Game;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.LinkedList;

import kagg886.Game.API.APIFriend;
import kagg886.Game.API.APIGroup;
import kagg886.qinternet.QInternet;
import kagg886.qinternet.Interface.QQMsgListener;
import kagg886.qinternet.QInternet.APIType;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.utils.BotConfiguration;
import net.mamoe.mirai.utils.BotConfiguration.MiraiProtocol;

public class Main {
	
	public static LinkedList<QQMsgListener> pluginList;
	
	public static void main(String[] args) throws Exception {
		pluginList = new LinkedList<QQMsgListener>();
		read();
		Login();
	}

	private static void read() throws Exception {
		File g = new File("Plugin");
		if (g.exists()) {
			g.mkdirs();
		}
		
		for (File plugin: g.listFiles()) {
			URL url = plugin.toURL();
			URLClassLoader loader = new URLClassLoader(new URL[] {url});
			pluginList.add((QQMsgListener) loader.loadClass(plugin.getName().replace(".jar", "")).newInstance());
		}
	}

	private static void Login() {
		BotConfiguration c = new BotConfiguration();
		c.setProtocol(MiraiProtocol.ANDROID_PHONE);
		c.enableContactCache();
		c.setCacheDir(new File("Cache"));
		c.fileBasedDeviceInfo();
		long a = System.currentTimeMillis();
		JSONStorage storage = null;
		try {
			storage = new JSONStorage("Config.json");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Bot bot = BotFactory.INSTANCE.newBot(storage.optLong("qq"), storage.optString("pass"), c);
		QInternet.initAPI(APIType.GROUPAPI, bot.getId(), new APIGroup(bot));
		QInternet.initAPI(APIType.FRIENDAPI, bot.getId(), new APIFriend(bot));
		bot.login();
		bot.getEventChannel().registerListenerHost(new EventHandler());
	}
}
