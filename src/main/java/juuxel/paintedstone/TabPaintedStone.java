package juuxel.paintedstone;

import juuxel.paintedstone.init.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TabPaintedStone extends CreativeTabs
{
    public TabPaintedStone(String label)
    {
        super(label);
    }

    @Override
    public ItemStack getIconItemStack()
    {
        return new ItemStack(ModBlocks.coloredStone, 1, 13);
    }

    @Override
    public Item getTabIconItem()
    {
        return new ItemStack(ModBlocks.coloredCobble).getItem();
    }
}