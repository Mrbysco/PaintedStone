package juuxel.paintedstone.common.item;

import juuxel.paintedstone.common.block.BlockPaintedStone;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemPaintedStone extends ItemBlock
{
    public ItemPaintedStone(Block b)
    {
        super(b);
        setMaxDamage(0);
        setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int meta)
    {
        return meta;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return super.getUnlocalizedName() + "." + BlockPaintedStone.colorNames[stack.getItemDamage()];
    }
}
