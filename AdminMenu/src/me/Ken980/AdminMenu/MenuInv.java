package me.Ken980.AdminMenu;

import java.util.Arrays;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Wool;
import org.bukkit.plugin.Plugin;
import org.bukkit.World;
import org.bukkit.Material;

public class MenuInv implements Listener{
    
    private ItemStack c, s, a, sp, h, f, d, n;
    private Inventory inv;
    
    public MenuInv(Plugin p){
        inv = Bukkit.getServer().createInventory(null, 36, (ChatColor.RED + "Simple Administrator Tools"));
        
        c = createItem(DyeColor.GREEN, "Creative");
        s = createItem(DyeColor.BLUE, "Survival");
        a = createItem(DyeColor.YELLOW, "Adventure");
        sp = createItem(DyeColor.GRAY, "Spectator");
        h = createItem(DyeColor.RED, "Health");
        f = createItem(DyeColor.ORANGE, "Food");
        d = createItem(DyeColor.ORANGE, "Day");
        n = createItem(DyeColor.BLACK, "Night");
        
        inv.setItem(15, c);
        inv.setItem(16, s);
        inv.setItem(24, a);
        inv.setItem(25, sp);
        inv.setItem(10, h);
        inv.setItem(19, f);
        inv.setItem(12, d);
        inv.setItem(21, n);
        
        Bukkit.getServer().getPluginManager().registerEvents(this, p);
        
    }
    
    private ItemStack createItem(DyeColor dc, String name){
        ItemStack i = new Wool(dc).toItemStack(1);
        ItemMeta im = i.getItemMeta();
        im.setDisplayName(name);
        i.setItemMeta(im);
        return i;
    }
    
    public void show(Player p){
        p.openInventory(inv);
    }
        
    @EventHandler
    
    public void onInventoryClick(InventoryClickEvent e){
        
        Player player = (Player) e.getWhoClicked();
        World world = player.getWorld();
      
        if(!(e.getInventory().getName().equalsIgnoreCase(inv.getName()))) return;
        if(e.getCurrentItem().getItemMeta() == null) return;
        if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Creative")){
            e.setCancelled(true);
            e.getWhoClicked().setGameMode(GameMode.CREATIVE);
        }
        if(!(e.getInventory().getName().equalsIgnoreCase(inv.getName()))) return;
        if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Survival")){
            e.setCancelled(true);
            e.getWhoClicked().setGameMode(GameMode.SURVIVAL);
        }
        if(!(e.getInventory().getName().equalsIgnoreCase(inv.getName()))) return;
        if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Adventure")){
            e.setCancelled(true);
            e.getWhoClicked().setGameMode(GameMode.ADVENTURE);
        }
        if(!(e.getInventory().getName().equalsIgnoreCase(inv.getName()))) return;
        if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Spectator")){
            e.setCancelled(true);
            e.getWhoClicked().setGameMode(GameMode.SPECTATOR);
        }
        if(!(e.getInventory().getName().equalsIgnoreCase(inv.getName()))) return;
        if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Health")){
            e.setCancelled(true);
            e.getWhoClicked().setHealth(20);
        }
        if(!(e.getInventory().getName().equalsIgnoreCase(inv.getName()))) return;
        if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Food")){
            e.setCancelled(true);
            player.setFoodLevel(20);
        }
        if(!(e.getInventory().getName().equalsIgnoreCase(inv.getName()))) return;
        if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Day")){
            e.setCancelled(true);
            world.setTime(1000);
        }
        if(!(e.getInventory().getName().equalsIgnoreCase(inv.getName()))) return;
        if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Night")){
            e.setCancelled(true);
            world.setTime(13000);
        }
    }
    
}
