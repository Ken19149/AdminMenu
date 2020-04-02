package me.Ken980.AdminMenu;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;

public class Main extends JavaPlugin implements Listener{
    
    private MenuInv menu;
    
    @Override
    public void onEnable(){
        menu = new MenuInv(this);
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        Bukkit.getServer().getLogger().info("[AdminMenu]-This plugin has been Enabled");
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
    
    @Override
    public void onDisable(){
        Bukkit.getServer().getLogger().info("[AdminMenu]-This plugin has been Disabled");
    }
    
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e){
        Player p = e.getPlayer();
        Material m = Material.valueOf(getConfig().getString("material").toUpperCase());
        if(p.isOp()){
        if(p.getItemInHand().getType() == m){
            if(e.getAction() == Action.RIGHT_CLICK_AIR){
                menu.show(e.getPlayer());
            }
        }
        }
    }
    
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        
        if(cmd.getName().equalsIgnoreCase("AdminMenu") && sender instanceof Player && sender.isOp()){
            Player p = (Player) sender;
            menu.show(p);
        }
        return false;
        
    }
    
}
