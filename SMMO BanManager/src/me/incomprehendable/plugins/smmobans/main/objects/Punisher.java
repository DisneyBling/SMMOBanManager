package me.incomprehendable.plugins.smmobans.main.objects;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Punisher {
	private Player p;
	private Punishment punishment = new Punishment();
	
	public Punisher(Player p){
		this.p = p;
	}
	public Punisher(Player p, Punishment pun){
		this.p = p;
		this.punishment = pun;
	}
	
	public Player getPlayer(){
		return this.p;
	}
	public Punishment getPunishment(){
		return this.punishment;
	}
	public void setPunishment(Punishment p){
		this.punishment = p;
	}
}
