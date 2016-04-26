package mrbysco.paintedstone.common.init;

import static mrbysco.paintedstone.common.init.ModBlocks.coloredCobble;
import static mrbysco.paintedstone.common.init.ModBlocks.coloredCrackedStoneBrick;
import static mrbysco.paintedstone.common.init.ModBlocks.coloredMossCobble;
import static mrbysco.paintedstone.common.init.ModBlocks.coloredMossStoneBrick;
import static mrbysco.paintedstone.common.init.ModBlocks.coloredStone;
import static mrbysco.paintedstone.common.init.ModBlocks.coloredStoneBrick;
import static mrbysco.paintedstone.common.init.ModBlocks.coloredStoneFancyBrick;
import static mrbysco.paintedstone.common.init.ModBlocks.coloredStoneRoad;
import static mrbysco.paintedstone.common.init.ModBlocks.coloredStoneSquareBrick;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public final class ModCrafting
{
    private static final String[] DYES = {
        "Black",
        "Red",
        "Green",
        "Brown",
        "Blue",
        "Purple",
        "Cyan",
        "LightGray",
        "Gray",
        "Pink",
        "Lime",
        "Yellow",
        "LightBlue",
        "Magenta",
        "Orange",
        "White"
    };

    public static void init()
    {
        for (int i = 0; i < 16; i++)
        {
            // Conversion recipes
            GameRegistry.addSmelting(new ItemStack(coloredCobble, 1, i), new ItemStack(coloredStone, 1, i), 0.2F);
            GameRegistry.addRecipe(new ItemStack(coloredStoneBrick, 4, i), "##", "##", '#', new ItemStack(coloredStone, 1, i));
            GameRegistry.addRecipe(new ItemStack(coloredStoneRoad, 4, i), "##", "##", '#', new ItemStack(coloredStoneBrick, 1, i));
            GameRegistry.addRecipe(new ItemStack(coloredStoneFancyBrick, 4, i), "##", "##", '#', new ItemStack(coloredStoneRoad, 1, i));
            GameRegistry.addRecipe(new ItemStack(coloredStoneSquareBrick, 2, i), "#", "#", '#', new ItemStack(coloredStoneBrick, 1, i));

            // Dyeing recipes
            String dye = "dye" + DYES[15 - i];

            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(coloredCobble, 1, i), "cobblestone", dye));
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(coloredStone, 1, i), "stone", dye));
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(coloredMossCobble, 1, i), new ItemStack(Blocks.mossy_cobblestone), dye));
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(coloredStoneBrick, 1, i), new ItemStack(Blocks.stonebrick), dye));
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(coloredMossStoneBrick, 1, i), new ItemStack(Blocks.stonebrick, 1, 1), dye));
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(coloredCrackedStoneBrick, 1, i), new ItemStack(Blocks.stonebrick, 1, 2), dye));
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(coloredStoneSquareBrick, 1, i), new ItemStack(Blocks.stonebrick, 1, 3), dye));
        }
    }
}
