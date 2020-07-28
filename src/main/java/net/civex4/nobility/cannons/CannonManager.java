package net.civex4.nobility.cannons;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import net.civex4.nobility.Nobility;
import net.civex4.nobility.development.AttributeManager;
import net.civex4.nobility.estate.Estate;
import net.md_5.bungee.api.ChatColor;

public class CannonManager {
	
	public ArrayList<Cannon> activeCannons;

	public CannonManager() {
		this.activeCannons = new ArrayList<Cannon>();
	}
	
	public void addCannon(Cannon c) {
		this.activeCannons.add(c);
	}
	
	public void removeCannon(Cannon c) {
		this.activeCannons.remove(c);
	}
	
	public void dismantleCannon(Location loc) {
		//TODO
	}
	
	public boolean isCannon(Location loc) {
		return false;
		//TODO
	}
	
	public Cannon getCannon(Location loc) {
		return null;
		//TODO
	}
	
	public void damageCannon(Cannon c, int amt) {
		//TODO
	}
	
	private boolean hasCannonPermission(Player p) {
		// TODO Auto-generated method stub
		return true;
	}
	
	public boolean validCannonSpot(Location loc) {
		return true;
	}
	
	public boolean canPlaceCannons(Estate e) {
		return true;
	}
	
	public boolean hasCannons(Estate e) {
			int amt = AttributeManager.getCannons(e);
			if(amt >= 1) {
				return true;
			}else return false;
	}
	
	public void spawnCannon(Location loc) {
		
	}
	
	public void summonCannon(Player p) {
		Estate e = Nobility.getEstateManager().getEstateOfPlayer(p);
		if(e != null) {
			Location loc = p.getLocation();
			if(canPlaceCannons(e)) {
				if(hasCannonPermission(p)) {
					if(hasCannons(e)) {
						if(validCannonSpot(loc)) {
							spawnCannon(loc);
						}else {
							p.sendMessage(ChatColor.RED + "This is not a valid cannon location");
							return;
						}
					}else{
						p.sendMessage(ChatColor.RED + "Your estate has no more cannons.");
					}
					
				}else {
					p.sendMessage(ChatColor.RED + "You don't have permission to summon cannons from your Estate.");
				}
				
			}else {
				p.sendMessage(ChatColor.RED + "Your estate cannon place cannons right now.");
				return;
			}

		}
	}


}