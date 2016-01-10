package juuxel.paintedstone.proxy;

import juuxel.paintedstone.PaintedStone;
import juuxel.paintedstone.TabPaintedStone;
import juuxel.paintedstone.config.Config;
import juuxel.paintedstone.handler.PlayerHandler;
import juuxel.paintedstone.init.ModBlocks;
import juuxel.paintedstone.init.ModCrafting;
import juuxel.paintedstone.init.ModOreDict;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.*;

public abstract class CommonProxy
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
