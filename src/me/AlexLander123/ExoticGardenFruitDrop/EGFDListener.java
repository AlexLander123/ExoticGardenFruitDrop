package me.AlexLander123.ExoticGardenFruitDrop;

import me.mrCookieSlime.ExoticGarden.EGPlant;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.HandledBlock;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.BlockStorage;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.LeavesDecayEvent;

public class EGFDListener implements Listener{
	
	@EventHandler
	public void onLeavesDecay(LeavesDecayEvent event){
		if(event.isCancelled()){return;}
		Block leaves = event.getBlock();
		BlockFace[] blockFaces = {BlockFace.DOWN, BlockFace.UP, BlockFace.NORTH, BlockFace.EAST, BlockFace.SOUTH, BlockFace.WEST};
		for(BlockFace blockFace : blockFaces){
			    Block block = leaves.getRelative(blockFace);
				SlimefunItem sfItem = BlockStorage.check(block);
				if(sfItem != null && !(sfItem instanceof HandledBlock) && sfItem instanceof EGPlant){
					block.getWorld().dropItemNaturally(block.getLocation(), BlockStorage.retrieve(block));
					block.setType(Material.AIR);
				}
		}
	}
}
