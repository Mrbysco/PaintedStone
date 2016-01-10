package juuxel.paintedstone.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static juuxel.paintedstone.init.ModBlocks.*;

public final class ModCrafting
{
    public static void init()
    {
        for (int i = 0; i < 16; i++)
        {
            GameRegistry.addSmelting(new ItemStack(coloredCobble, 1, i), new ItemStack(coloredStone, 1, i), 0.2F);
            GameRegistry.addRecipe(new ItemStack(coloredStoneBrick, 4, i), "##", "##", '#', new ItemStack(coloredStone, 1, i));
        }
    }
}
