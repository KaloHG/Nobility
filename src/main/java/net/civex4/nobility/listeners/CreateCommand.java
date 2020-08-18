package net.civex4.nobility.listeners;

import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.civex4.nobility.Nobility;

/* This command is to speed up test iterations by making estate creation a simple command
 * 
 */
public class CreateCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You must be a player to use this command!");
			return false;
		}
		
		Player player = (Player) sender;
		
		if(Nobility.getEstateManager().playerHasEstate(player)) {
			player.sendMessage("You already have an estate");
			return true;
		}
		
		Block block = player.getLocation().getBlock();
		
		Nobility.getEstateManager().createEstate(block, player);
		
		return false;
	}

}
