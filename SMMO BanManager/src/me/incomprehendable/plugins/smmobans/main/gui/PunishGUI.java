package me.incomprehendable.plugins.smmobans.main.gui;

import me.incomprehendable.plugins.smmobans.main.Main;
import me.incomprehendable.plugins.smmobans.main.core.F;
import me.incomprehendable.plugins.smmobans.main.gui.items.PunishBorderItem;
import me.incomprehendable.plugins.smmobans.main.gui.items.SelectedPlayer;
import ninja.amp.ampmenus.menus.ItemMenu;

public class PunishGUI extends ItemMenu {
	public PunishGUI(){
		super(F.color("&1&lPunish GUI"), Size.SIX_LINE, Main.getJavaPlugin());
		this.setItem(3, new SelectedPlayer());
		this.fillEmptySlots(new PunishBorderItem());
	}
}
