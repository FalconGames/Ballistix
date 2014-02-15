package net.swordsofvalor.Ballistix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.swordsofvalor.Ballistix.Listeners.PlayerJoinListener;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Ballistix extends JavaPlugin {
	
	private static PluginManager pm;
	private static Ballistix instance;
	private static List<BallistixGun> primaryList;
	
	@Override
	public void onEnable() {
		pm = getServer().getPluginManager();
		
		instance = this;
		
		this.saveDefaultConfig();
		
		pm.registerEvents(new PlayerJoinListener(), this);
		
		primaryList = new ArrayList<>();
		Map<String, Object> primaries = getConfig().getConfigurationSection("Primary").getValues(false);
		Iterator<Entry<String, Object>> it = primaries.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> pairs = (Map.Entry<String, Object>)it.next();
			String name = pairs.getKey();
			Bukkit.getLogger().info("Gun found: " + name);
			String ammoType = getConfig().getString("Primary." + name + ".Ammo");
			int ammoAmount = getConfig().getInt("Primary." + name + ".Amount");
			primaryList.add(new BallistixGun(name, ammoType, ammoAmount));
			it.remove();
		}
	}
	
	@Override
	public void onDisable() {
		instance = null;
	}
	
	public static Ballistix inst() {
		return instance;
	}
	
	public static List<BallistixGun> getPrimaries() {
		return primaryList;
	}
}
