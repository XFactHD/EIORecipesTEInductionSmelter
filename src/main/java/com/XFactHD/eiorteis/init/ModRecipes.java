package com.XFactHD.eiorteis.init;

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

        GameRegistry.addShapelessRecipe(new ItemStack(GameRegistry.findItem("eiorteis", "itemGRMix")), new ItemStack(Items.redstone), new ItemStack(Items.glowstone_dust));

        LogHelper.info("Registering Induction Smelter recipes");

        addSmelterRecipe(10000, new ItemStack(Items.iron_ingot), new ItemStack(Items.redstone), new ItemStack(GameRegistry.findItem("enderio", "ingotConductiveIron")));
        addSmelterRecipe(10000, new ItemStack(Items.iron_ingot), new ItemStack(Items.ender_pearl), new ItemStack(GameRegistry.findItem("enderio", "ingotPhasedIron")));
        addSmelterRecipe(16000, new ItemStack(Items.gold_ingot), new ItemStack(GameRegistry.findItem("eiorteis", "itemGRMix")), new ItemStack(GameRegistry.findItem("enderio", "ingotEnergeticAlloy")));
        addSmelterRecipe(16000, new ItemStack(GameRegistry.findItem("enderio", "ingotEnergeticAlloy")), new ItemStack(Items.ender_pearl), new ItemStack(GameRegistry.findItem("enderio", "ingotPhasedGold")));
        addSmelterRecipe(10000, new ItemStack(GameRegistry.findItem(null, "ingotSteel")), new ItemStack(GameRegistry.findItem(null, "itemSilicon")), new ItemStack(GameRegistry.findItem("enderio", "ingotElectricalSteel")));
        addSmelterRecipe(16000, new ItemStack(Items.redstone), new ItemStack(GameRegistry.findItem(null, "itemSilicon")), new ItemStack(GameRegistry.findItem("enderio", "ingotRedstoneAlloy")));
        addSmelterRecipe(20000, new ItemStack(GameRegistry.findItem(null, "ingotSteel")), new ItemStack(Blocks.obsidian), new ItemStack(GameRegistry.findItem("enderio", "ingotDarkSteel")));
        addSmelterRecipe(10000, new ItemStack(Items.gold_ingot), new ItemStack(Blocks.soul_sand), new ItemStack(GameRegistry.findItem("enderio", "ingotSoularium")));
    }

    public static void addSmelterRecipe(int energy, ItemStack primaryInput, ItemStack secondaryInput, ItemStack primaryOutput)
    {
        NBTTagCompound toSend = new NBTTagCompound();

        toSend.setInteger("energy", energy);
        toSend.setTag("primaryInput", new NBTTagCompound());
        toSend.setTag("secondaryInput", new NBTTagCompound());
        toSend.setTag("primaryOutput", new NBTTagCompound());
        toSend.setTag("secondaryOutput", new NBTTagCompound());

        primaryInput.writeToNBT(toSend.getCompoundTag("primaryInput"));
        secondaryInput.writeToNBT(toSend.getCompoundTag("secondaryInput"));
        primaryOutput.writeToNBT(toSend.getCompoundTag("primaryOutput"));

        FMLInterModComms.sendMessage("ThermalExpansion", "SmelterRecipe", toSend);
    }
}