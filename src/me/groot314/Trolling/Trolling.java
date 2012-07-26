package me.groot314.Trolling;

import org.bukkit.plugin.java.JavaPlugin;

public class Trolling extends JavaPlugin {
	
	private TrollingExecutor trollingExecutor;
	public void onEnable(){
		trollingExecutor = new TrollingExecutor(this);
		getCommand("trolling").setExecutor(trollingExecutor);
		getCommand("trollkill").setExecutor(trollingExecutor);
	}
	
	public void onDisable(){
		
	}
}
