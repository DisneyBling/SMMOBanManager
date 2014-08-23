package me.incomprehendable.plugins.smmobans.main.gui.items;

import me.incomprehendable.plugins.smmobans.main.core.F;
import ninja.amp.ampmenus.items.MenuItem;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SelectedPlayer extends MenuItem {
	public SelectedPlayer() {
		super(F.color("&eSelected Player: &f<name>"), new ItemStack(Material.SKULL_ITEM, 1, (short) 3), new String[]{F.color("The player who will receive the punishment."), F.color("&aClick&7 to change.")});	
	}

	@Override
	public ItemStack getFinalIcon(Player p){
		ItemStack finalIcon = super.getFinalIcon(p);
		
		return finalIcon;
	}
}
