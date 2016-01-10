package juuxel.paintedstone.common.block;

import java.util.List;
import java.util.Random;

import juuxel.paintedstone.common.PaintedStone;
import juuxel.paintedstone.common.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockPaintedStone extends Block
{
    public static final PropertyEnum<EnumDyeColor> COLOR = PropertyEnum.create("color", EnumDyeColor.class);
    public static final String[] colorNames = new String[] { "white", "orange", "magenta", "lightblue", "yellow", "lime", "pink", "gray", "silver", "aqua", "purple", "blue", "brown", "green", "red",
            "black" };
    public final String localName;
    Block dropBlock;

    public BlockPaintedStone(float hardness, String name, StoneProperty... properties)
    {
        super(Material.rock);
        this.setHardness(hardness);
        this.setCreativeTab(PaintedStone.tab);
        this.setRegistryName(name);
        this.setUnlocalizedName(Reference.ID_LOWER + ":" + name);

        this.localName = name;
        this.dropBlock = this;

        for (StoneProperty property : properties)
        {
            if (property.getValue() instanceof Block && property.getName().equals("dropBlock"))
                this.dropBlock = (Block) property.getValue();
        }
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(dropBlock);
    }

    @Override
    public void getSubBlocks(Item b, CreativeTabs tab, List<ItemStack> list)
    {
        for (int i = 0; i < 16; i++)
        {
            list.add(new ItemStack(b, 1, i));
        }
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return state.getValue(COLOR).getMetadata();
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(COLOR, EnumDyeColor.byMetadata(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(COLOR).getMetadata();
    }

    @Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, COLOR);
    }


    @SideOnly(Side.CLIENT)
    public void initModel()
    {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
