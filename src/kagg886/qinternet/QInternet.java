package kagg886.qinternet;

import java.util.ArrayList;
import kagg886.qinternet.Content.QQBot;

public final class QInternet {
	public static final String Author = "kagg886";

	public static final String Version = "dev-20230206";

	private static final ArrayList<QQBot> bots = new ArrayList<QQBot>();

	public static boolean addBot(QQBot bot) {
		for (QQBot instance : bots) {
			if (bot.equals(instance))
				return false;
		}
		bots.add(bot);
		return true;
	}

	public static boolean removeBot(QQBot bot) {
		return bots.remove(bot);
	}

	public static QQBot findBot(long botQQ) {
		for (QQBot instance : bots) {
			if (instance.getId() == botQQ)
				return instance;
		}
		return null;
	}

	public static ArrayList<QQBot> getList() {
		return bots;
	}
}
