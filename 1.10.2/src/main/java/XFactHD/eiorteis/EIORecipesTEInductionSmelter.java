/*  Copyright (C) <2017>  <XFactHD>

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

import cofh.thermalexpansion.util.managers.machine.FurnaceManager;
import cofh.thermalexpansion.util.managers.machine.PulverizerManager;
import cofh.thermalexpansion.util.managers.machine.SmelterManager;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, dependencies = Reference.DEPENDENCIES)
public class EIORecipesTEInductionSmelter
{
    @Mod.Instance("eiorteis")
    public static EIORecipesTEInductionSmelter instance;

    @SidedProxy(serverSide = "XFactHD.eiorteis.CommonProxy", clientSide = "XFactHD.eiorteis.ClientProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        LogHelper.info("Hello Minecraft!");
        GameRegistry.register(new ItemGRMix());
        proxy.registerModels();
        ConfigHandler.init(event.getSuggestedConfigurationFile());
        MinecraftForge.EVENT_BUS.register(new ConfigHandler());
        LogHelper.info("PreInit complete");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        MetaItemGetter.init();

        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ItemGRMix.INSTANCE), "dustRedstone", "dustGlowstone"));

        SmelterManager.addRecipe(ConfigHandler.energyConductiveIron       , new ItemStack(Items.IRON_INGOT), new ItemStack(Items.REDSTONE), MetaItemGetter.conductiveIron);
        SmelterManager.addRecipe(ConfigHandler.energyPhasedIron           , new ItemStack(Items.IRON_INGOT), new ItemStack(Items.ENDER_PEARL), MetaItemGetter.phasedIron);
        SmelterManager.addRecipe(ConfigHandler.energyEnergeticAlloy       , new ItemStack(Items.GOLD_INGOT), new ItemStack(ItemGRMix.INSTANCE), MetaItemGetter.energeticAlloy);
        SmelterManager.addRecipe(ConfigHandler.energyPhasedGold           , MetaItemGetter.energeticAlloy, new ItemStack(Items.ENDER_PEARL), MetaItemGetter.phasedGold);
        SmelterManager.addRecipe(ConfigHandler.energyElectricalSteel      , MetaItemGetter.ingotSteel, MetaItemGetter.itemSilicon, MetaItemGetter.electricalSteel);
        SmelterManager.addRecipe(ConfigHandler.energyRedstoneAlloy        , MetaItemGetter.itemSilicon, new ItemStack(Items.REDSTONE), MetaItemGetter.redstoneAlloy);
        SmelterManager.addRecipe(ConfigHandler.energyDarkSteel            , MetaItemGetter.ingotSteel, new ItemStack(Blocks.OBSIDIAN), MetaItemGetter.darkSteel);
        SmelterManager.addRecipe(ConfigHandler.energySoularium            , new ItemStack(Items.GOLD_INGOT), new ItemStack(Blocks.SOUL_SAND), MetaItemGetter.soularium);
    
        FurnaceManager.addRecipe(ConfigHandler.energyClearGlass           , new ItemStack(Blocks.GLASS), MetaItemGetter.blockClearGlass);
        
        if (ConfigHandler.addSiliconRecipe)
        {
            PulverizerManager.addRecipe(ConfigHandler.energySiliconSingle , new ItemStack(Blocks.SAND), MetaItemGetter.itemSilicon);

            if (MetaItemGetter.compSandDouble != null)
            {
                ItemStack siliconDouble = ItemStack.copyItemStack(MetaItemGetter.itemSilicon);
                siliconDouble.stackSize = 9;
                PulverizerManager.addRecipe(ConfigHandler.energySiliconDouble , MetaItemGetter.compSandDouble, siliconDouble);
            }

            if (MetaItemGetter.compSandTripple != null)
            {
                ItemStack siliconTripple = ItemStack.copyItemStack(MetaItemGetter.itemSilicon);
                siliconTripple.stackSize = 27;
                PulverizerManager.addRecipe(ConfigHandler.energySiliconTripple, MetaItemGetter.compSandTripple, siliconTripple);
            }
        }

        LogHelper.info("Init complete");
    }
}
