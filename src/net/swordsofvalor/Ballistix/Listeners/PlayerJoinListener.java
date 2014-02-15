package net.swordsofvalor.Ballistix.Listeners;

import java.util.List;
import java.util.Random;

import net.swordsofvalor.Ballistix.Ballistix;
import net.swordsofvalor.Ballistix.BallistixGun;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.shampaggon.crackshot.CSUtility;

public class PlayerJoinListener implements Listener {
	
	CSUtility cs = new CSUtility();
	Random rand = new Random();
	
	@EventHandler(priority=EventPriority.LOW)
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		List<BallistixGun> primaryList = Ballistix.getPrimaries();
		p.getInventory().clear();
		
		for (int i = 0; i < 5; i++) {
			int j = rand.nextInt(primaryList.size() - 1);
			cs.giveWeapon(p, primaryList.get(j).getName(), 1);
		}
	}
	
}
