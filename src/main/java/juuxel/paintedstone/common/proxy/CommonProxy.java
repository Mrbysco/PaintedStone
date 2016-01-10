package juuxel.paintedstone.common.proxy;

import juuxel.paintedstone.common.PaintedStone;
import juuxel.paintedstone.common.TabPaintedStone;
import juuxel.paintedstone.common.config.Config;
import juuxel.paintedstone.common.handler.PlayerHandler;
import juuxel.paintedstone.common.init.ModBlocks;
import juuxel.paintedstone.common.init.ModCrafting;
import juuxel.paintedstone.common.init.ModOreDict;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.*;

public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent event)
    {
        Config.init(event.getSuggestedConfigurationFile());
        MinecraftForge.EVENT_BUS.register(Config.config);
        MinecraftForge.EVENT_BUS.register(new PlayerHandler());
        PaintedStone.tab = new TabPaintedStone("paintedstone");
        ModBlocks.init();
        ModCrafting.init();
    }

    public void init(FMLInitializationEvent event)
    {
        ModOreDict.init();
    }

    public void postInit(FMLPostInitializationEvent event)
    {
    }
}
