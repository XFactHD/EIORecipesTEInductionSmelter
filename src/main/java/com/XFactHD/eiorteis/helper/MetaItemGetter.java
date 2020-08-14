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

package com.XFactHD.eiorteis.helper;

import com.XFactHD.eiorteis.init.ModItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import static net.minecraftforge.oredict.OreDictionary.itemMatches;

import java.util.ArrayList;



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

    public static ItemStack ingotSteel;
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

        if (!(OreDictionary.getOres("ingotSteel").isEmpty()))
        {
            ingotSteel = OreDictionary.getOres("ingotSteel").get(0);
        }
        else
        {
            ingotSteel = new ItemStack(ModItems.ingotSteelBase);
        }

        grMix = new ItemStack(GameRegistry.findItem("eiorteis", "itemGRMix"));
    }
}
