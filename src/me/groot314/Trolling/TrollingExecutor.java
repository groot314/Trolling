package me.groot314.Trolling;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TrollingExecutor implements CommandExecutor {

	private Trolling plugin;
	
	public TrollingExecutor(Trolling plugin){
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable,String[] args) {
		if (cmd.getName().equalsIgnoreCase("Trolling")){
			
		}
		return false;
	}

}
