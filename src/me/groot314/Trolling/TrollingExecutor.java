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
	
	public TrollingExecutor(Trolling plugin){
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable,String[] args) {
		Player player = null;
        if (sender instanceof Player) {
            player = (Player) sender;
        }
		
		if (cmd.getName().equalsIgnoreCase("Trolling")){
			sender.sendMessage(ChatColor.DARK_BLUE + "Trolling----------");
			sender.sendMessage(ChatColor.DARK_BLUE + "/trollKill - Troll kills a player(wont really kill them)");
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("trollKill")){
			if (args.length == 0){
				return false;
			}
			if (Bukkit.getServer().getPlayer(args[0]) != null){
				Player targetplayer = player.getServer().getPlayer(args[0]);
				targetplayer.playEffect(EntityEffect.DEATH);
				Bukkit.getServer().broadcast(targetplayer.getDisplayName() + "has died", null);
			} else {
				sender.sendMessage("No player with this username Online!");
			}
		}
		
		return false;
	}

}
