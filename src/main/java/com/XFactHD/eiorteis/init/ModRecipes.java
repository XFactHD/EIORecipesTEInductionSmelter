/*  Copyright (C) <2015>  <XFactHD>

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

package com.XFactHD.eiorteis.init;

import com.XFactHD.eiorteis.helper.ConfigHandler;
import com.XFactHD.eiorteis.helper.MetaItemGetter;
import com.XFactHD.eiorteis.helper.LogHelper;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ModRecipes
{
    public static void init()
    {
        LogHelper.info("Registering crafting recipes");

        GameRegistry.addShapelessRecipe(MetaItemGetter.grMix, new ItemStack(Items.redstone), new ItemStack(Items.glowstone_dust));

        LogHelper.info("Registering Induction Smelter recipes");

        addSmelterRecipe(ConfigHandler.energyConductiveIron, new ItemStack(Items.iron_ingot), new ItemStack(Items.redstone), MetaItemGetter.conductiveIron);
        addSmelterRecipe(ConfigHandler.energyPhasedIron, new ItemStack(Items.iron_ingot), new ItemStack(Items.ender_pearl), MetaItemGetter.phasedIron);
        addSmelterRecipe(ConfigHandler.energyEnergeticAlloy, new ItemStack(Items.gold_ingot), MetaItemGetter.grMix, MetaItemGetter.energeticAlloy);
        addSmelterRecipe(ConfigHandler.energyPhasedGold, MetaItemGetter.energeticAlloy, new ItemStack(Items.ender_pearl), MetaItemGetter.phasedGold);
        addSmelterRecipe(ConfigHandler.energyElectricalSteel, MetaItemGetter.ingotSteel, MetaItemGetter.itemSilicon, MetaItemGetter.electricalSteel);
        addSmelterRecipe(ConfigHandler.energyRedstoneAlloy, new ItemStack(Items.redstone), MetaItemGetter.itemSilicon, MetaItemGetter.redstoneAlloy);
        addSmelterRecipe(ConfigHandler.energyDarkSteel, MetaItemGetter.ingotSteel, new ItemStack(Blocks.obsidian), MetaItemGetter.darkSteel);
        addSmelterRecipe(ConfigHandler.energySoularium, new ItemStack(Items.gold_ingot), new ItemStack(Blocks.soul_sand), MetaItemGetter.soularium);

        if (GameRegistry.findItem(null, "ingotSteel") == null)
        {
            addSmelterRecipe(1000, new ItemStack(Items.iron_ingot), MetaItemGetter.dustCoal, MetaItemGetter.ingotSteel);
        }
    }

    public static void addSmelterRecipe(int paramInt, ItemStack paramItemStack1, ItemStack paramItemStack2, ItemStack paramItemStack3)
    {
        NBTTagCompound toSend = new NBTTagCompound();

        toSend.setInteger("energy", paramInt);
        toSend.setTag("primaryInput", new NBTTagCompound());
        toSend.setTag("secondaryInput", new NBTTagCompound());
        toSend.setTag("primaryOutput", new NBTTagCompound());

        paramItemStack1.writeToNBT(toSend.getCompoundTag("primaryInput"));
        paramItemStack2.writeToNBT(toSend.getCompoundTag("secondaryInput"));
        paramItemStack3.writeToNBT(toSend.getCompoundTag("primaryOutput"));

        FMLInterModComms.sendMessage("ThermalExpansion", "SmelterRecipe", toSend);
    }
}