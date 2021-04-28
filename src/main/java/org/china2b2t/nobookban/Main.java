package org.china2b2t.nobookban;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;

public class Main extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
    }
	
	@EventHandler
	public void onInteract(InventoryInteractEvent e) {
		HumanEntity player = e.getWhoClicked();
		
		if(player.isOp()) {
			return;
		}
		if (player.getInventory().getItemInMainHand().getType() == Material.WRITTEN_BOOK && ((BookMeta) player.getInventory().getItemInMainHand().getItemMeta()).getPage(1).contains("\u0800") && ((BookMeta) player.getInventory().getItemInMainHand().getItemMeta()).getPageCount() >= 1) {
            player.sendMessage(ChatColor.RED + "Hey, you...don't do that >:(");
            player.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
        }
	}
}
