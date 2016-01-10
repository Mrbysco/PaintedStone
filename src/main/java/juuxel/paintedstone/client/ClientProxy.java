package juuxel.paintedstone.client;

import juuxel.paintedstone.common.init.ModBlocks;
import juuxel.paintedstone.common.proxy.CommonProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public final class ClientProxy extends CommonProxy
{
    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        super.preInit(event);
        ModBlocks.initModels();
    }
}
