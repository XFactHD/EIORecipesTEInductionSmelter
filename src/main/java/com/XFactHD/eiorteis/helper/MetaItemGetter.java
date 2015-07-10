package com.XFactHD.eiorteis.helper;

import com.XFactHD.eiorteis.init.ModItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MetaItemGetter
{
    public static ItemStack electricalSteel;
    public static ItemStack energeticAlloy;
    public static ItemStack phasedGold;
    public static ItemStack redstoneAlloy;
    public static ItemStack conductiveIron;
    public static ItemStack phasedIron;
    public static ItemStack darkSteel;
    public static ItemStack soularium;

    public static ItemStack itemSilicon;

    public static ItemStack dustCoal;

    public static ItemStack ingotSteelBase;
    public static ItemStack grMix;

    public static void init()
    {
        Item alloyItem = GameRegistry.findItem("EnderIO", "itemAlloy");
        electricalSteel = new ItemStack(alloyItem, 1, 0);
        energeticAlloy = new ItemStack(alloyItem, 1, 1);
        phasedGold = new ItemStack(alloyItem, 1, 2);
        redstoneAlloy = new ItemStack(alloyItem, 1, 3);
        conductiveIron = new ItemStack(alloyItem, 1, 4);
        phasedIron = new ItemStack(alloyItem, 1, 5);
        darkSteel = new ItemStack(alloyItem, 1, 6);
        soularium = new ItemStack(alloyItem, 1, 7);

        Item materialItem = GameRegistry.findItem("EnderIO", "itemMaterial");
        itemSilicon = new ItemStack(materialItem, 1, 0);

        Item dustItem = GameRegistry.findItem("ThermalFoundation", "material");
        dustCoal = new ItemStack(dustItem, 1, 2);

        if (GameRegistry.findItem(null, "ingotSteel") == null)
        {
            ingotSteelBase = new ItemStack(ModItems.ingotSteelBase);
        }
        else
        {
            ingotSteelBase = new ItemStack(GameRegistry.findItem(null, "ingotSteel"));
        }

        grMix = new ItemStack(GameRegistry.findItem("eiorteis", "itemGRMix"));
    }
}
