package com.XFactHD.eiorteis.init;

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

        addSmelterRecipe(2000, new ItemStack(Items.iron_ingot), new ItemStack(Items.redstone), MetaItemGetter.conductiveIron);
        addSmelterRecipe(2000, new ItemStack(Items.iron_ingot), new ItemStack(Items.ender_pearl), MetaItemGetter.phasedIron);
        addSmelterRecipe(4000, new ItemStack(Items.gold_ingot), MetaItemGetter.grMix, MetaItemGetter.energeticAlloy);
        addSmelterRecipe(4000, MetaItemGetter.energeticAlloy, new ItemStack(Items.ender_pearl), MetaItemGetter.phasedGold);
        addSmelterRecipe(2000, MetaItemGetter.ingotSteelBase, MetaItemGetter.itemSilicon, MetaItemGetter.electricalSteel);
        addSmelterRecipe(2000, new ItemStack(Items.redstone), MetaItemGetter.itemSilicon, MetaItemGetter.redstoneAlloy);
        addSmelterRecipe(6000, MetaItemGetter.ingotSteelBase, new ItemStack(Blocks.obsidian), MetaItemGetter.darkSteel);
        addSmelterRecipe(2000, new ItemStack(Items.gold_ingot), new ItemStack(Blocks.soul_sand), MetaItemGetter.soularium);
        addSmelterRecipe(1000, new ItemStack(Items.iron_ingot), MetaItemGetter.dustCoal, MetaItemGetter.ingotSteelBase);
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