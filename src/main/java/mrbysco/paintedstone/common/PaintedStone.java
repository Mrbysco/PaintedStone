package mrbysco.paintedstone.common;

import org.apache.logging.log4j.Logger;

import mrbysco.paintedstone.common.lib.Reference;
import mrbysco.paintedstone.common.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
    modid = Reference.ID,
    name = Reference.NAME,
    version = Reference.VERSION,
    guiFactory = "mrbysco.paintedstone.client.gui.ModGuiFactory",
    acceptedMinecraftVersions = Reference.MC_VERSION
)
public class PaintedStone
{
    @SidedProxy(clientSide = "mrbysco.paintedstone.client.ClientProxy", serverSide = "mrbysco.paintedstone.common.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static PaintedStone instance;

    public static Logger logger;

    public static CreativeTabs tab;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }
}
