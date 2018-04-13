/*  Copyright (C) <2018>  <XFactHD>

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see http://www.gnu.org/licenses. */

package XFactHD.eiorteis;

import XFactHD.eiorteis.common.*;
import XFactHD.eiorteis.common.util.*;
import cofh.thermalexpansion.util.managers.machine.SmelterManager;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, dependencies = Reference.DEPENDENCIES)
public class EIORecipesTEInductionSmelter
{
    @Mod.Instance("eiorteis")
    public static EIORecipesTEInductionSmelter INSTANCE;

    static { MinecraftForge.EVENT_BUS.register(Content.class); }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        LogHelper.init(event.getModLog());
        LogHelper.info("Hello Minecraft!");
        ConfigHandler.init(event.getSuggestedConfigurationFile());
        MinecraftForge.EVENT_BUS.register(new ConfigHandler());
        LogHelper.info("PreInit complete");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        MetaItemGetter.init();
        SmelterManager.addRecipe(ConfigHandler.energyEnergeticAlloy , new ItemStack(Items.GOLD_INGOT), new ItemStack(Content.itemGRMix), MetaItemGetter.energeticAlloy);
        SmelterManager.addRecipe(ConfigHandler.energyElectricalSteel, MetaItemGetter.ingotSteel,       MetaItemGetter.itemSilicon,       MetaItemGetter.electricalSteel);
        SmelterManager.addRecipe(ConfigHandler.energyRedstoneAlloy  , MetaItemGetter.itemSilicon,      new ItemStack(Items.REDSTONE),    MetaItemGetter.redstoneAlloy);
        SmelterManager.addRecipe(ConfigHandler.energyDarkSteel      , MetaItemGetter.ingotSteel,       new ItemStack(Blocks.OBSIDIAN),   MetaItemGetter.darkSteel);
        LogHelper.info("Init complete");
    }
}
