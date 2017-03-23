package me.AlexLander123.ExoticGardenFruitDrop;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class ExoticGardenFruitDrop extends JavaPlugin{
	
	public Logger logger = Logger.getLogger("Minecraft");
	EGFDListener egfdListener = new EGFDListener(); 
	
	@Override
	public void onEnable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Version "  + pdfFile.getVersion() + " by " + pdfFile.getAuthors() + " Has Been Enabled!");
		getServer().getPluginManager().registerEvents(egfdListener, this);
	}
	
	@Override
	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Has Been Disabled!");
	}

}
