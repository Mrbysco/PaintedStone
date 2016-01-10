package juuxel.paintedstone.init;

import juuxel.paintedstone.block.BlockPaintedStone;
import juuxel.paintedstone.item.ItemPaintedStone;
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
        coloredStone = new BlockPaintedStone(1.5f, "coloredStone", coloredCobble);
        coloredMossCobble = new BlockPaintedStone(2.0f, "coloredMossStone");
        coloredStoneBrick = new BlockPaintedStone(1.5f, "coloredStoneBrick");
        coloredMossStoneBrick = new BlockPaintedStone(1.5f, "coloredMossBrick");
        coloredCrackedStoneBrick = new BlockPaintedStone(1.5f, "coloredCrackedBrick");
        coloredStoneRoad = new BlockPaintedStone(1.5f, "coloredRoad");
        coloredStoneFancyBrick = new BlockPaintedStone(1.5f, "coloredFancyBrick");
        coloredStoneSquareBrick = new BlockPaintedStone(1.5f, "coloredChiseledBrick");

        GameRegistry.registerBlock(coloredCobble, ItemPaintedStone.class, "coloredCobble");
        GameRegistry.registerBlock(coloredStone, ItemPaintedStone.class, "coloredStone");
        GameRegistry.registerBlock(coloredMossCobble, ItemPaintedStone.class, "coloredMossStone");
        GameRegistry.registerBlock(coloredStoneBrick, ItemPaintedStone.class, "coloredStoneBrick");
        GameRegistry.registerBlock(coloredMossStoneBrick, ItemPaintedStone.class, "coloredMossBrick");
        GameRegistry.registerBlock(coloredCrackedStoneBrick, ItemPaintedStone.class, "coloredCrackedBrick");
        GameRegistry.registerBlock(coloredStoneRoad, ItemPaintedStone.class, "coloredRoad");
        GameRegistry.registerBlock(coloredStoneFancyBrick, ItemPaintedStone.class, "coloredFancyBrick");
        GameRegistry.registerBlock(coloredStoneSquareBrick, ItemPaintedStone.class, "coloredChiseledBrick");
    }

    @SideOnly(Side.CLIENT)
    public static void initModels()
    {
        coloredCobble.initModel();
        coloredStone.initModel();
        coloredMossCobble.initModel();
        coloredStoneBrick.initModel();
        coloredMossStoneBrick.initModel();
        coloredCrackedStoneBrick.initModel();
        coloredStoneRoad.initModel();
        coloredStoneFancyBrick.initModel();
        coloredStoneSquareBrick.initModel();

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
    // all credit to williewillus.
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
