package mrbysco.paintedstone.client;

import mrbysco.paintedstone.common.init.ModBlocks;
import mrbysco.paintedstone.common.proxy.CommonProxy;
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
