package me.incomprehendable.plugins.smmobans.main.core;

import java.util.UUID;
import java.util.logging.Level;

import me.incomprehendable.plugins.smmobans.main.Main;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import com.comphenix.packetwrapper.WrapperPlayServerWorldParticles;
import com.comphenix.packetwrapper.WrapperPlayServerWorldParticles.ParticleEffect;

public class UtilP {
	private static JavaPlugin jPlugin = Main.getJavaPlugin();

	public static UUID getUUID(Player p) {
		return p.getUniqueId();
	}

	public static Player getPlayer(String name) {
		return Bukkit.getPlayer(name);
	}

	public static Player getPlayer(UUID id) {
		return Bukkit.getPlayer(id);
	}

	public static void kick(Player p, String reason) {
		p.kickPlayer(F.color(reason));
	}

	public static void setGamemode(Player p, GameMode gm) {
		p.setGameMode(gm);
	}

	public static void heal(Player p) {
		p.setHealth(p.getMaxHealth());
	}

	public static void kill(Player p) {
		p.setHealth(0.0);
	}

	// Some NMS stuff here. Should work on all 1.7 versions...

	public static void respawn(Player p) {
		try {
			Object nmsPlayer = p.getClass().getMethod("getHandle").invoke(p);
			Object packet = Class.forName(
					nmsPlayer.getClass().getPackage().getName()
							+ ".PacketPlayInClientCommand").newInstance();
			Class<?> enumClass = Class.forName(nmsPlayer.getClass()
					.getPackage().getName()
					+ ".EnumClientCommand");

			for (Object ob : enumClass.getEnumConstants()) {
				if (ob.toString().equals("PERFORM_RESPAWN")) {
					packet = packet.getClass().getConstructor(enumClass)
							.newInstance(ob);
				}
			}
			Object con = nmsPlayer.getClass().getField("playerConnection")
					.get(nmsPlayer);
			con.getClass().getMethod("a", packet.getClass())
					.invoke(con, packet);
		} catch (Exception e) {
			Main.log(Level.SEVERE,
					"ERROR! An error occurred whilst trying to force an auto-respawn.");
			Main.log(Level.SEVERE,
					"Most likely, this was caused by an outdated version.");
			e.printStackTrace();
		}
	}

	public static void sendBloodEffect(Location l) {
		WrapperPlayServerWorldParticles bloodPacket = new WrapperPlayServerWorldParticles(
				ParticleEffect.RED_DUST, 3, l, new Vector());
		for (Player p : Bukkit.getOnlinePlayers()) {
			bloodPacket.sendPacket(p);
		}
	}

}
