package mrbysco.paintedstone.common.init;

import static mrbysco.paintedstone.common.init.ModBlocks.coloredCobble;
import static mrbysco.paintedstone.common.init.ModBlocks.coloredStone;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public final class ModOreDict
{
    public static void init()
    {
        for (int i = 0; i < 16; i++)
        {
            OreDictionary.registerOre("stone", new ItemStack(coloredStone, 1, i));
            OreDictionary.registerOre("cobblestone", new ItemStack(coloredCobble, 1, i));
        }
    }
}
