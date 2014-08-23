package me.incomprehendable.plugins.smmobans.main.core;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class S {
	public static void play(Player p, Sound s) {
		p.playSound(p.getLocation(), s, 1, 1);
	}

	public static void play(Player p, Sound s, float vol, float pitch) {
		p.playSound(p.getLocation(), s, vol, pitch);
	}

	public static Sound get(String s) {
		return Sound.valueOf(s);
	}
}
