package me.incomprehendable.plugins.smmobans.main.core;

import java.util.Arrays;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class I {

	public static ItemStack create(ItemStack item, String name, String[] lores) {
		ItemMeta im = item.getItemMeta();
		im.setDisplayName(name);
		im.setLore(Arrays.asList(lores));
		item.setItemMeta(im);
		return item;
	}

	public static ItemStack rename(ItemStack item, String name) {
		ItemMeta im = item.getItemMeta();
		im.setDisplayName(name);
		return item;
	}

	public static ItemStack setLore(ItemStack item, String[] lores) {
		ItemMeta im = item.getItemMeta();
		im.setLore(Arrays.asList(lores));
		item.setItemMeta(im);
		return item;
	}

	public static ItemStack addLore(ItemStack item, String l) {
		ItemMeta im = item.getItemMeta();
		im.getLore().add(l);
		item.setItemMeta(im);
		return item;
	}

	public static ItemStack delLore(ItemStack item, String l) {
		ItemMeta im = item.getItemMeta();
		im.getLore().remove(l);
		item.setItemMeta(im);
		return item;
	}

	public static ItemStack delLore(ItemStack item, int index) {
		ItemMeta im = item.getItemMeta();
		im.getLore().remove(index);
		item.setItemMeta(im);
		return item;
	}
}
