package com.reussy.exodus.icecubemenus.menu;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class GUI {

    public static Map<UUID, GUI> inventoriesUUID = new HashMap<>();
    public static Map<UUID, UUID> openInventories = new HashMap<>();
    private final UUID inventoryUUID;
    private final Inventory inventory;
    private final Map<Integer, GUIAction> actions;

    public GUI(int inventorySize, String inventoryName) {
        this.inventoryUUID = UUID.randomUUID();
        this.inventory = Bukkit.createInventory(null, inventorySize, inventoryName);
        this.actions = new HashMap<>();
        inventoriesUUID.put(getUUID(), this);
    }

    public void addItem(int slot, ItemStack itemStack, GUIAction action) {
        inventory.setItem(slot, itemStack);
        if (action != null)
            actions.put(slot, action);
    }

    public void addItem(int slot, ItemStack itemStack) {
        addItem(slot, itemStack, null);
    }


    public void openGUI(Player player) {
        if (getInventory() == null) return;
        player.openInventory(getInventory());
        if (!openInventories.containsKey(player.getUniqueId()))
            openInventories.put(player.getUniqueId(), getUUID());
    }

    public void deleteGUI() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            UUID uuid = openInventories.get(player.getUniqueId());
            if (uuid.equals(getUUID()))
                player.closeInventory();
        }
        inventoriesUUID.remove(getUUID());
    }

    public static Map<UUID, GUI> getInventoryUUID() {
        return inventoriesUUID;
    }

    public static Map<UUID, UUID> getOpenInventories() {
        return openInventories;
    }

    public UUID getUUID() {
        return this.inventoryUUID;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public Map<Integer, GUIAction> getGUIActions() {
        return this.actions;
    }

    public interface GUIAction {
        void onInteract(Player player);
    }
}
