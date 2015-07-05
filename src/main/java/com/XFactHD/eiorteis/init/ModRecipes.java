package com.XFactHD.eiorteis.init;

import com.XFactHD.eiorteis.helper.LogHelper;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.OreDictionary;

public class ModRecipes
{
    public static void init()
    {
        LogHelper.info("Registering crafting recipes");

        GameRegistry.addShapelessRecipe(new ItemStack(GameRegistry.findItem("eiorteis", "itemGRMix")), new ItemStack(Items.redstone), new ItemStack(Items.glowstone_dust));

        LogHelper.info("Registering Induction Smelter recipes");

        addSmelterRecipe(10000, new ItemStack(Items.iron_ingot), new ItemStack(Items.redstone), new ItemStack(GameRegistry.findItem("EnderIO", "ingotConductiveIron")));
        addSmelterRecipe(10000, new ItemStack(Items.iron_ingot), new ItemStack(Items.ender_pearl), new ItemStack(GameRegistry.findItem("EnderIO", "ingotPhasedIron")));
        addSmelterRecipe(16000, new ItemStack(Items.gold_ingot), new ItemStack(GameRegistry.findItem("eiorteis", "itemGRMix")), new ItemStack(GameRegistry.findItem("EnderIO", "ingotEnergeticAlloy")));
        addSmelterRecipe(16000, new ItemStack(GameRegistry.findItem("EnderIO", "ingotEnergeticAlloy")), new ItemStack(Items.ender_pearl), new ItemStack(GameRegistry.findItem("EnderIO", "ingotPhasedGold")));
        addSmelterRecipe(10000, new ItemStack(GameRegistry.findItem("ThermalExpansion", "ingotSteel")), new ItemStack(GameRegistry.findItem("EnderIO", "itemSilicon")), new ItemStack(GameRegistry.findItem("eiorteis", "ingotElectricalSteel")));
        addSmelterRecipe(16000, new ItemStack(Items.redstone), new ItemStack(GameRegistry.findItem("EnderIO", "itemSilicon")), new ItemStack(GameRegistry.findItem("eiorteis", "ingotRedstoneAlloy")));
        addSmelterRecipe(20000, new ItemStack(GameRegistry.findItem("ThermalExpansion", "ingotSteel")), new ItemStack(Blocks.obsidian), new ItemStack(GameRegistry.findItem("eiorteis", "ingotDarkSteel")));
        addSmelterRecipe(10000, new ItemStack(Items.gold_ingot), new ItemStack(Blocks.soul_sand), new ItemStack(GameRegistry.findItem("eiorteis", "ingotSoularium")));
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