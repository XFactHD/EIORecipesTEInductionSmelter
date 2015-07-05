package com.XFactHD.eiorteis;

import com.XFactHD.eiorteis.helper.LogHelper;
import com.XFactHD.eiorteis.helper.Reference;
import com.XFactHD.eiorteis.init.ModItems;
import com.XFactHD.eiorteis.init.ModRecipes;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.VERSION)
public class eiorteis
{
    @Mod.Instance("eiorteis")
    public static eiorteis instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        LogHelper.info("Hello Minecraft!");
        ModItems.init();
        ModRecipes.init();
        LogHelper.info("PreInit complete");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        //LogHelper.info("Init complete");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        //LogHelper.info("PostInit complete");
    }
}
