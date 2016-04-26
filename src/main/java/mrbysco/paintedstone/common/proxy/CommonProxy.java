package mrbysco.paintedstone.common.proxy;

import mrbysco.paintedstone.common.PaintedStone;
import mrbysco.paintedstone.common.TabPaintedStone;
import mrbysco.paintedstone.common.config.Config;
import mrbysco.paintedstone.common.handler.PlayerHandler;
import mrbysco.paintedstone.common.init.ModBlocks;
import mrbysco.paintedstone.common.init.ModCrafting;
import mrbysco.paintedstone.common.init.ModOreDict;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

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
