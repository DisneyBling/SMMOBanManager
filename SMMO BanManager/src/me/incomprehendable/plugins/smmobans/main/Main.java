package me.incomprehendable.plugins.smmobans.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.bukkit.util.CommandsManagerRegistration;
import com.sk89q.minecraft.util.commands.CommandException;
import com.sk89q.minecraft.util.commands.CommandPermissionsException;
import com.sk89q.minecraft.util.commands.CommandUsageException;
import com.sk89q.minecraft.util.commands.CommandsManager;
import com.sk89q.minecraft.util.commands.MissingNestedCommandException;
import com.sk89q.minecraft.util.commands.WrappedCommandException;

public class Main extends JavaPlugin {
	private static Plugin _plugin;
	private static JavaPlugin _javaPlugin;
	private CommandsManager<CommandSender> commands;
	
	public void onEnable(){
		_plugin = this;
		_javaPlugin = this;
		
		File configFile = new File(this.getDataFolder(), "config.yml");     
		if(!configFile.exists()){
		    configFile.getParentFile().mkdirs();
		    this.copy(this.getResource("config.yml"), configFile);
		}
		
		// reg(Listeners...);
	}
	public void onDisable(){
		_plugin = null;
		_javaPlugin = null;
		
	}
	
	// sk89q's command framework
			private void setupCommands() {
				this.commands = new CommandsManager<CommandSender>() {
					@Override
					public boolean hasPermission(CommandSender sender, String perm) {
						return sender instanceof ConsoleCommandSender
								|| sender.hasPermission(perm);
					}
				};
				CommandsManagerRegistration cmdRegister = new CommandsManagerRegistration(
						this, this.commands);
				// cmdRegister.register(class.class);
			}
			
			private void doConfig(){
				this.getConfig().options().copyDefaults(true);
				this.saveDefaultConfig();
			}

			@Override
			public boolean onCommand(CommandSender sender, Command cmd,
					String commandLabel, String[] args) {
				try {
					this.commands.execute(cmd.getName(), args, sender, sender);
				} catch (CommandPermissionsException e) {
					sender.sendMessage(ChatColor.RED + "You don't have permission.");
				} catch (MissingNestedCommandException e) {
					sender.sendMessage(ChatColor.RED + e.getUsage());
				} catch (CommandUsageException e) {
					sender.sendMessage(ChatColor.RED + e.getMessage());
					sender.sendMessage(ChatColor.RED + e.getUsage());
				} catch (WrappedCommandException e) {
					if (e.getCause() instanceof NumberFormatException) {
						sender.sendMessage(ChatColor.RED
								+ "Number expected, string received instead.");
					} else {
						sender.sendMessage(ChatColor.RED
								+ "An error has occurred. See console.");
						e.printStackTrace();
					}
				} catch (CommandException e) {
					sender.sendMessage(ChatColor.RED + e.getMessage());
				}
				return true;
			}

			public static void reg(Listener... listeners) {
				for (Listener l : listeners) {
					_plugin.getServer().getPluginManager().registerEvents(l, _plugin);
				}
			}

			public static void unReg(Listener... listeners) {
				for (Listener l : listeners) {
					HandlerList.unregisterAll(l);
				}
			}

			public static void unRegPlugin(Plugin p) {
				HandlerList.unregisterAll(p);
			}
			
			public static void log(String s) {
				_plugin.getLogger().info(s);
			}

			public static void log(Level l, String s) {
				_plugin.getLogger().log(l, s);
			}

			public static void stop() {
				_plugin.getServer().shutdown();
			}
			
			public static Plugin getInstance() {
				return _plugin;
			}
			public static JavaPlugin getJavaPlugin(){
				return _javaPlugin;
			}
			public static FileConfiguration config() {
				return _plugin.getConfig();
			}
			private void copy(InputStream in, File file) {
		        try {
		            OutputStream out = new FileOutputStream(file);
		            byte[] buf = new byte[1024];
		            int len;
		            while((len=in.read(buf))>0){
		                out.write(buf,0,len);
		            }
		            out.close();
		            in.close();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
			public static boolean senderIsPlayer(CommandSender sender){
				return (sender instanceof Player);
			}
}
