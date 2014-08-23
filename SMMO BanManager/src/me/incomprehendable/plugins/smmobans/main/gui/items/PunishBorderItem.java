package me.incomprehendable.plugins.smmobans.main.gui.items;

import me.incomprehendable.plugins.smmobans.main.core.F;
import ninja.amp.ampmenus.items.StaticMenuItem;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class PunishBorderItem extends StaticMenuItem {
	public PunishBorderItem() {
		super(F.color("&8Border Item"), new ItemStack(Material.STAINED_GLASS_PANE, 1), new String[]{F.color("&7This item does nothing...")});
	}
}
