package cursedbread.gildertable.blocks;

import com.mojang.nbt.CompoundTag;
import cursedbread.gildertable.GilderMod;
import net.minecraft.client.render.entity.PigRenderer;
import net.minecraft.client.render.tileentity.TileEntityRendererFlag;
import net.minecraft.core.achievement.stat.Stat;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockTileEntity;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.entity.TileEntityChest;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class GilderBlock extends Block {
	public GilderBlock(String key, int id) {
		super(key, id, Material.metal);
	}

	int i;
	int j;
	int q;
	int t;
	int k;

	public boolean blockActivated(World world, int x, int y, int z, EntityPlayer player) {
		ItemStack holdQuiver = player.getHeldItem();
		ItemStack stack = player.getHeldItem();
		ItemStack drop = new ItemStack(Item.armorQuiverGold);
		for (i = -1; i <= 1; i++) {
			for (j = -1; j <= 1; j++) {
				if (world.getBlockId(x + i, y-1, z + j) == Block.blockGold.id) {
					if (world.getBlockId(x, y-1, z) == Block.slate.id) {
						if (player.getHeldItem() != null && player.getHeldItem() == holdQuiver) {
							for (q = -1; q <= 1; q++) {
								for (t = -1; t <= 1; t++) {
									for (k = -1; k <= 1; k++) {
										world.setBlock(x + q, y + t, z + k, 0);
										stack.consumeItem(player);
										world.dropItem(x, y, z, drop);
									}
								}
							}
							break;
						} else {player.addChatMessage("Check if your are holding quiver");}
						break;
					} else {player.addChatMessage("Check if core slate was placed");}
					break;
				} else {player.addChatMessage("Check if golden ring was build correctly");}
				break;
			}
			break;
		}
		return false;
	}
}
