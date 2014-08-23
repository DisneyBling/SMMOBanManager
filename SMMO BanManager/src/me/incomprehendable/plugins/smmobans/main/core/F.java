package me.incomprehendable.plugins.smmobans.main.core;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class F {

	public static String cDarkBlue = "§1";
	public static String cDarkGreen = "§2";
	public static String cDarkAqua = "§3";
	public static String cDarkRed = "§4";
	public static String cDarkPurple = "§5";
	public static String cGold = "§6";
	public static String cGray = "§7";
	public static String cDarkGray = "§8";
	public static String cBlue = "§9";
	public static String cBlack = "§0";
	public static String cGreen = "§a";
	public static String cAqua = "§b";
	public static String cRed = "§c";
	public static String cPurple = "§d";
	public static String cYellow = "§e";
	public static String cWhite = "§f";
	public static String fReset = "§r";
	public static String fMagic = "§k";
	public static String fBold = "§l";
	public static String fItalics = "§o";
	public static String fUnderline = "§n";
	public static String fStrike = "§m";
	public static String fSpace = "§r ";
	public static String fLinerule = "§7§m----------------------------------------------";
	public static String MUST_BE_PLAYER = F.error("Console",
			"You must be a player to use this commmand!");
	public static String NO_PERMISSION = F.error("Permissions",
			"You have no permission for that!");
	public static String CANNOT_FIND_PLAYER = F.error("Player Search",
			"That player is not online!");

	public static String info(String module, String body) {
		return cBlue + module + ">" + fSpace + cGray + body;
	}

	public static String warning(String module, String body) {
		return cRed + module + ">" + fSpace + cGray + body;
	}

	public static String alert(String module, String body) {
		return cGold + module + ">" + fSpace + cGray + body;
	}

	public static String error(String module, String body) {
		return cDarkRed + module + ">" + fSpace + cGray + body;
	}

	public static String pVar(String s) {
		return cGreen + s;
	}

	public static String sVar(String s) {
		return cYellow + s;
	}

	public static void send(Player p, String m) {
		p.sendMessage(m);
	}

	public static void send(CommandSender sender, String m) {
		sender.sendMessage(m);
	}

	public static void warn(Player p, String m) {
		p.sendMessage(cRed + "WARNING:" + fSpace + cGray + m);
	}

	public static void warn(Player p, String m, Player warner) {
		p.sendMessage(new String[] { cRed + "WARNING:" + fSpace + cGray + m,
				cDarkGray + "Issued by:" + fSpace + warner.getName() });
	}

	public static void sendStaffMsg(Player receiver, String msg, Player sender) {
		receiver.sendMessage(cRed + "[Staff]" + fSpace + sender.getName() + ":"
				+ fSpace + cAqua + msg);
		receiver.playSound(receiver.getLocation(), Sound.WOOD_CLICK, 1, 1);
	}

	public static void broadcastInfo(String s) {
		for (Player p : Bukkit.getOnlinePlayers()) {
			p.sendMessage(s);
		}
	}

	public static void clear(int linesToClear) {
		for (Player p : Bukkit.getOnlinePlayers()) {
			for (int i = 0; i < linesToClear; i++) {
				p.sendMessage(fSpace);
			}
		}
	}

	public static void clear(Player p, int linesToClear) {
		for (int i = 0; i < linesToClear; i++) {
			p.sendMessage(fSpace);
		}
	}

	public static void send(Player p, String msg, Sound s) {
		F.send(p, msg);
		S.play(p, s);
	}

	public static String color(String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}
}
