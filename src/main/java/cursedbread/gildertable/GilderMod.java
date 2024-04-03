package cursedbread.gildertable;

import cursedbread.gildertable.blocks.GilderBlock;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.render.block.model.BlockModelRenderBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockTorch;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.item.block.ItemBlock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.util.ConfigHandler;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;

import java.util.Properties;


public class GilderMod implements ModInitializer, GameStartEntrypoint {
	public static final String MOD_ID = "gildertable";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Put some gold on this sh*t");
	}

	public static BlockBuilder fullBlock = new BlockBuilder(MOD_ID)
		.setBlockModel(new BlockModelRenderBlocks(0));

	public static int blockId;

	static {
		Properties prop = new Properties();
		prop.setProperty("starting_block_id", "2000");
		ConfigHandler config = new ConfigHandler(MOD_ID, prop);

		blockId = config.getInt("starting_block_id");

		config.updateConfig();
	}

	public static Block gildingTable;

	@Override
	public void beforeGameStart() {
		gildingTable = fullBlock
			.setTextures("gilding_table.png")
			.setTopBottomTexture(17, 4)
			.setBottomTexture(8, 14)
			.build(new GilderBlock("gilder", blockId++));
	}

	@Override
	public void afterGameStart() {

	}
}
