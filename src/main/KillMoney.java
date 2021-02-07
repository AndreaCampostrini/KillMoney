package main;

import com.earth2me.essentials.api.Economy;
import com.earth2me.essentials.api.NoLoanPermittedException;
import com.earth2me.essentials.api.UserDoesNotExistException;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;


public class KillMoney extends JavaPlugin implements Listener{

	public void onEnable() {
	this.getServer().getPluginManager().registerEvents(this, this);
	}

	public void onDisable() {
		System.out.println("Il plugin KillMoney è stato disabilitato");
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDeath(PlayerDeathEvent event)throws NoLoanPermittedException, UserDoesNotExistException {
    	Player killer = event.getEntity().getKiller();
        Player killed = event.getEntity().getPlayer();
        String kl = killer.getName();
        String kd = killed.getName();

	if(killer instanceof Player && killed instanceof Player) {
            killer.sendMessage(ChatColor.AQUA + "Hai ottenuto 1000$ killando" + kd);
            killed.sendMessage(ChatColor.AQUA + "Sei stato killato da " + kl + " e hai perso 500$");
	    Economy.add(kl, 1000);
            Economy.subtract(kd, 500);
	}
    }
}
