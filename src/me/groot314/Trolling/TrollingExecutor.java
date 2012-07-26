package me.groot314.Trolling;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.EntityEffect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TrollingExecutor implements CommandExecutor {

	private Trolling plugin;

	public TrollingExecutor(Trolling plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable,
			String[] args) {
		Player player = null;
		if (sender instanceof Player) {
			player = (Player) sender;
		}
 
		//on command trolling
		if (cmd.getName().equalsIgnoreCase("Trolling")) {
			sender.sendMessage(ChatColor.DARK_BLUE + "Trolling----------");
			sender.sendMessage(ChatColor.DARK_BLUE
					+ "/trollKill - Troll kills a player(wont really kill them)");
			return true;
		}
		
		//on command trollKill
		if (cmd.getName().equalsIgnoreCase("trollKill")) {

			if (player.hasPermission("trolling.kill")) {

				if (args.length == 0) {
					return false;
				} else if (args.length == 1) {
					if (Bukkit.getServer().getPlayer(args[0]) != null) {
						Player targetplayer = player.getServer().getPlayer(
								args[0]);
						targetplayer.playEffect(EntityEffect.DEATH);
						Bukkit.getServer().broadcast(
								targetplayer.getDisplayName() + "has died",
								null);
						return true;
					} else {
						player.sendMessage("No player with this username Online!");
						return true;
					}
				} else {
					player.sendMessage(ChatColor.RED
							+ "You dont have Permissions to that command");
				}
			} else if (args.length > 1) {
				return false;
			}

		}

		// on Command "trollKick"
		if (cmd.getName().equalsIgnoreCase("trollkick")) {
			if ((sender instanceof Player)) {

				if (player.hasPermission("trolling.kick")) {
					if (args.length == 0) {
						return false;
					} else if (args.length == 1) {
						if (Bukkit.getServer().getPlayer(args[0]) != null) {
							Player targetplayer = player.getServer().getPlayer(
									args[0]);
							targetplayer
									.kickPlayer("You have been troll kicked, you can now log back in");
							Bukkit.getServer().broadcastMessage(
									targetplayer.getDisplayName()
											+ ChatColor.GRAY
											+ " has been troll kicked");
							return true;
						} else {
							sender.sendMessage(ChatColor.RED
									+ "There is no player Online with this name.");
							return true;
						}
					} else if (args.length > 1) {
						return false;
					}
				} else {
					player.sendMessage(ChatColor.RED
							+ "You dont have Permissions to that command");
					return true;
				}
			} else {
				sender.sendMessage(ChatColor.RED
						+ "You have to be in the game to use this command you N00B");
				return true;

			}
		}

		return false;
	}

}
