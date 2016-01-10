package juuxel.paintedstone.handler;

import juuxel.paintedstone.block.BlockPaintedStone;
import juuxel.paintedstone.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;

import java.util.List;

public final class PlayerHandler
{
    public static final String[] DYES = {
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

    @SubscribeEvent
    public void onPlayerInteract(PlayerInteractEvent event)
    {
        World world = event.world;
        EntityPlayer player = event.entityPlayer;

        if (event.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK)
        {
            ItemStack stack = player.getCurrentEquippedItem();
            for (int i = 0; i < 16; i++)
            {
                List<ItemStack> stacks = OreDictionary.getOres("dye" + DYES[i]);
                for (ItemStack stack1 : stacks)
                {
                    if (stack1.getItem() == stack.getItem() && stack1.getItemDamage() == stack.getItemDamage())
                    {
                        if (colorStoneBlocks(event.world, event.pos, i))
                        {
                            if (!player.capabilities.isCreativeMode)
                            {
                                stack.stackSize--;
                                if (stack.stackSize <= 0)
                                    player.destroyCurrentEquippedItem();
                            }

                            player.swingItem();
                            if (!world.isRemote)
                            {
                                Block block = Blocks.stone;
                                world.playSoundEffect((double) event.pos.getX() + 0.5, (double) event.pos.getY() + 0.5, (double) event.pos.getZ() + 0.5, block.stepSound.getPlaceSound(),
                                    (block.stepSound.getVolume() + 1F) / 2F, world.rand.nextFloat() * 0.1F + 0.9F);
                            }
                        }
                        break;
                    }
                }
            }
        }
    }

    private boolean colorStoneBlocks(World world, BlockPos pos, int inputMeta)
    {
        boolean changed = false;

        IBlockState block = world.getBlockState(pos);
        if (block.getBlock() == Blocks.stone)
        {
            changed = true;
            world.setBlockState(pos, ModBlocks.coloredStone.getStateFromMeta(15 - inputMeta), 3);
        }
        else if (block.getBlock() instanceof BlockPaintedStone && block.getValue(BlockPaintedStone.COLOR).getDyeDamage() != inputMeta)
        {
            changed = true;
            world.setBlockState(pos, block.getBlock().getStateFromMeta(15 - inputMeta), 3);
        }
        else if (block.getBlock() == Blocks.cobblestone)
        {
            changed = true;
            world.setBlockState(pos, ModBlocks.coloredCobble.getStateFromMeta(15 - inputMeta), 3);
        }
        else if (block.getBlock() == Blocks.mossy_cobblestone)
        {
            changed = true;
            world.setBlockState(pos, ModBlocks.coloredMossCobble.getStateFromMeta(15 - inputMeta), 3);
        }
        else if (block.getBlock() == Blocks.stonebrick)
        {
            changed = true;
            int meta = block.getValue(BlockStoneBrick.VARIANT).getMetadata();

            if (meta == 0)
                world.setBlockState(pos, ModBlocks.coloredStoneBrick.getStateFromMeta(15 - inputMeta), 3);
            else if (meta == 1)
                world.setBlockState(pos, ModBlocks.coloredCrackedStoneBrick.getStateFromMeta(15 - inputMeta), 3);
            else if (meta == 2)
                world.setBlockState(pos, ModBlocks.coloredMossStoneBrick.getStateFromMeta(15 - inputMeta), 3);
            else if (meta == 3)
                world.setBlockState(pos, ModBlocks.coloredStoneSquareBrick.getStateFromMeta(15 - inputMeta), 3);

        }

        return changed;
    }
}