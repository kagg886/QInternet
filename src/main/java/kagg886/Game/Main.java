package kagg886.Game;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

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

	public static QQMsgListener listener;

	public static void main(String[] args) throws Exception {
		read();
		Login();
	}

	private static void read() throws Exception {
		String jarFile = new File(new Main().getClass().getProtectionDomain().getCodeSource().getLocation().getPath())
				.getParent() + "\\Game.jar";
		File file = new File(jarFile);
		System.out.println(file.toString());
		URL url = file.toURL();
		URLClassLoader loader = new URLClassLoader(new URL[] {url});
		listener = (QQMsgListener) loader.loadClass("kagg886.game.Game").newInstance();
	}

	private static void Login() {
		BotConfiguration c = new BotConfiguration();
		c.setProtocol(MiraiProtocol.ANDROID_PHONE);
		c.fileBasedDeviceInfo();
		Bot bot = BotFactory.INSTANCE.newBot(1693256674L, "baleitem103", c);
		QInternet.initAPI(APIType.GROUPAPI, bot.getId(), new APIGroup(bot));
		QInternet.initAPI(APIType.FRIENDAPI, bot.getId(), new APIFriend(bot));
		bot.login();
		bot.getEventChannel().registerListenerHost(new EventHandler());
	}
}
