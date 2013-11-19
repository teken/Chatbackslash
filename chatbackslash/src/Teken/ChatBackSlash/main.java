package Teken.ChatBackSlash;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class main extends JavaPlugin implements Listener{
	public static Plugin instance;
	static final String name = "Chat Back Slash";
	static final String textName = "["+name+"] ";

	public main(){
		instance = this;
	}

	@Override
	public void onEnable(){
		getLogger().info(name+" has been enabled");
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(this, this);
	}

	@Override
	public void onDisable(){
		getLogger().info(name+" has been disabled");
	}
	
	@EventHandler
	public void onChat(PlayerChatEvent event){
		String omessage = event.getMessage();
		String[] nmessages = omessage.split("#");
		/*for(String m : nmessages){
			event.s
		}*/
		if(nmessages.length == 3){
			Player newp = null;
			String newm = "";
			
			newp = Bukkit.getPlayer(nmessages[1]);
			newm = nmessages[2];
			if(newp == null){
				newp = event.getPlayer();
				newm = omessage;
			}
			event.setPlayer(newp);
			event.setMessage(newm);
		}else{
			System.out.println(nmessages.length);
		}
		
	}
}
