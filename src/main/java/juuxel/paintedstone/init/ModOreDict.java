package juuxel.paintedstone.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import static juuxel.paintedstone.init.ModBlocks.*;

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
