package com.reussy.exodus.icecubemenus.listeners;

import com.reussy.exodus.icecubemenus.menu.GUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.UUID;

public class MenuInteract implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e){
        if (!(e.getWhoClicked() instanceof Player)){
            return;
        }
        Player player = (Player) e.getWhoClicked();
        UUID playerUUID = player.getUniqueId();

        UUID inventoryUUID = GUI.openInventories.get(playerUUID);
        if (inventoryUUID != null){
            e.setCancelled(true);
            GUI gui = GUI.getInventoryUUID().get(inventoryUUID);
            GUI.GUIAction action = gui.getGUIActions().get(e.getSlot());

            if (action != null){
                action.onInteract(player);
            }
        }
    }

    @EventHandler
    public void onClose(InventoryCloseEvent e) {

        Player player = (Player) e.getPlayer();
        UUID playerUUID = player.getUniqueId();

        GUI.openInventories.remove(playerUUID);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {

        Player player = e.getPlayer();
        UUID playerUUID = player.getUniqueId();

        GUI.openInventories.remove(playerUUID);

    }
}
