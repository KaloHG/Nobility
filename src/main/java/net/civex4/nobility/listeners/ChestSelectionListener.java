package net.civex4.nobility.listeners;

import java.util.HashMap;
import java.util.UUID;

import net.civex4.nobility.development.Camp;
import net.civex4.nobility.developments.Inn;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Bed;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;

import net.civex4.nobility.developments.AbstractWorkshop;
import net.md_5.bungee.api.ChatColor;

public class ChestSelectionListener implements Listener{

	public HashMap<UUID, Inn> defaultSpawnQueue;
	public HashMap<UUID, Camp> outputQueueCamp;
	public HashMap<UUID,AbstractWorkshop> outputQueue;
	public HashMap<UUID,AbstractWorkshop> inputQueue;

	/**
	 * Honestly just used as a "selection" Listener.
	 */
	public ChestSelectionListener(){
		defaultSpawnQueue = new HashMap<UUID, Inn>();
		outputQueueCamp = new HashMap<UUID, Camp>();
		outputQueue = new HashMap<UUID,AbstractWorkshop>();
		inputQueue = new HashMap<UUID,AbstractWorkshop>();
	}
	
	@EventHandler
	public void punchChest(BlockDamageEvent event) {
		Player p = event.getPlayer();
		Block b = event.getBlock();
		if(b.getBlockData() instanceof Bed) {
			if(defaultSpawnQueue.containsKey(p.getUniqueId())) {
				defaultSpawnQueue.get(p.getUniqueId()).defaultSpawn = b.getLocation();
				defaultSpawnQueue.remove(p.getUniqueId());
				p.sendMessage(ChatColor.GREEN + "Set estate default spawn.");
			}
		}
		if(b.getType() == Material.CHEST || b.getType() == Material.TRAPPED_CHEST) {
			if(outputQueueCamp.containsKey(p.getUniqueId())) {
				outputQueueCamp.get(p.getUniqueId()).outputChest = b.getLocation();
				outputQueueCamp.remove(p.getUniqueId());
				p.sendMessage(ChatColor.GREEN + "Set camp output chest.");
			}
			if(outputQueue.containsKey(p.getUniqueId())) {
				outputQueue.get(p.getUniqueId()).outputChest = b.getLocation();
				outputQueue.remove(p.getUniqueId());
				p.sendMessage(ChatColor.GREEN + "Added output chest.");
			}
			
			if(inputQueue.containsKey(p.getUniqueId())) {
				inputQueue.get(p.getUniqueId()).inputChest = b.getLocation();
				inputQueue.remove(p.getUniqueId());
				p.sendMessage(ChatColor.GREEN + "Added input chest.");
			}
		}
	}

}
