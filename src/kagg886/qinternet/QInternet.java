package kagg886.qinternet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import kagg886.qinternet.Content.QQBot;

public final class QInternet {
	public static final String Author = "kagg886";

	public static final String Version = "dev-20230210";

	private static final List<QQBot> bots = new CopyOnWriteArrayList<>();

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

	public static List<QQBot> getList() {
		return bots;
	}
}
