package juuxel.paintedstone.common.init;

import juuxel.paintedstone.common.block.BlockPaintedStone;
import juuxel.paintedstone.common.block.StoneProperty;
import juuxel.paintedstone.common.config.Config;
import juuxel.paintedstone.common.item.ItemPaintedStone;
import net.minecraft.block.Block;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameData;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public final class ModBlocks
{
    public static BlockPaintedStone coloredStone;
    public static BlockPaintedStone coloredCobble;
    public static BlockPaintedStone coloredMossCobble;
    public static BlockPaintedStone coloredStoneBrick;
    public static BlockPaintedStone coloredMossStoneBrick;
    public static BlockPaintedStone coloredCrackedStoneBrick;
    public static BlockPaintedStone coloredStoneRoad;
    public static BlockPaintedStone coloredStoneFancyBrick;
    public static BlockPaintedStone coloredStoneSquareBrick;

    public static void init()
    {
        coloredCobble = new BlockPaintedStone(2.0f, "coloredCobble");
        coloredStone = new BlockPaintedStone(1.5f, "coloredStone", StoneProperty.get("dropBlock", coloredCobble));
        coloredMossCobble = new BlockPaintedStone(2.0f, "coloredMossStone");
        coloredStoneBrick = new BlockPaintedStone(1.5f, "coloredStoneBrick");
        coloredMossStoneBrick = new BlockPaintedStone(1.5f, "coloredMossBrick");
        coloredCrackedStoneBrick = new BlockPaintedStone(1.5f, "coloredCrackedBrick");
        coloredStoneRoad = new BlockPaintedStone(1.5f, "coloredRoad");
        coloredStoneFancyBrick = new BlockPaintedStone(1.5f, "coloredFancyBrick");
        coloredStoneSquareBrick = new BlockPaintedStone(1.5f, "coloredChiseledBrick");

        if (Config.coloredCobble)
            GameRegistry.registerBlock(coloredCobble, ItemPaintedStone.class, "coloredCobble");

        if (Config.coloredStone)
            GameRegistry.registerBlock(coloredStone, ItemPaintedStone.class, "coloredStone");

        if (Config.coloredMossCobble)
            GameRegistry.registerBlock(coloredMossCobble, ItemPaintedStone.class, "coloredMossStone");

        if (Config.coloredStoneBrick)
            GameRegistry.registerBlock(coloredStoneBrick, ItemPaintedStone.class, "coloredStoneBrick");

        if (Config.coloredMossStoneBrick)
            GameRegistry.registerBlock(coloredMossStoneBrick, ItemPaintedStone.class, "coloredMossBrick");

        if (Config.coloredCrackedBrick)
            GameRegistry.registerBlock(coloredCrackedStoneBrick, ItemPaintedStone.class, "coloredCrackedBrick");

        if (Config.coloredStoneRoad)
            GameRegistry.registerBlock(coloredStoneRoad, ItemPaintedStone.class, "coloredRoad");

        if (Config.coloredStoneFancyBrick)
            GameRegistry.registerBlock(coloredStoneFancyBrick, ItemPaintedStone.class, "coloredFancyBrick");

        if (Config.coloredStoneSquareBrick)
            GameRegistry.registerBlock(coloredStoneSquareBrick, ItemPaintedStone.class, "coloredChiseledBrick");
    }

    @SideOnly(Side.CLIENT)
    public static void initModels()
    {
        registerVariants(coloredCobble, EnumDyeColor.class, "color");
        registerVariants(coloredStone, EnumDyeColor.class, "color");
        registerVariants(coloredMossCobble, EnumDyeColor.class, "color");
        registerVariants(coloredStoneBrick, EnumDyeColor.class, "color");
        registerVariants(coloredMossStoneBrick, EnumDyeColor.class, "color");
        registerVariants(coloredCrackedStoneBrick, EnumDyeColor.class, "color");
        registerVariants(coloredStoneRoad, EnumDyeColor.class, "color");
        registerVariants(coloredStoneFancyBrick, EnumDyeColor.class, "color");
        registerVariants(coloredStoneSquareBrick, EnumDyeColor.class, "color");
    }

    // Block rendering code from Botania,
    // all credit to Vazkii and williewillus.
    // https://github.com/williewillus/Botania
    @SideOnly(Side.CLIENT)
    private static <T extends Enum<T> & IStringSerializable> void registerVariants(Block b, Class<T> clazz, String variant) {
        Item item = Item.getItemFromBlock(b);
        for (T e : clazz.getEnumConstants()) {
            String baseName = GameData.getBlockRegistry().getNameForObject(b).toString();
            String variantName = variant + "=" + e.getName();
            ModelLoader.registerItemVariants(item, new ModelResourceLocation(baseName, variantName));
            ModelLoader.setCustomModelResourceLocation(item, e.ordinal(), new ModelResourceLocation(baseName, variantName));
        }
    }
}
