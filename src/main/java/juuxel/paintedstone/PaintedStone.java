package juuxel.paintedstone;

import juuxel.paintedstone.lib.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import juuxel.paintedstone.proxy.CommonProxy;
import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.ID, name = Reference.NAME, version = Reference.VERSION)
public class PaintedStone
{
    @SidedProxy(clientSide = "juuxel.paintedstone.proxy.ClientProxy", serverSide = "juuxel.paintedstone.proxy.ServerProxy")
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
