package com.XFactHD.eiorteis.helper;

import com.XFactHD.eiorteis.item.itemIngotSteel;
import net.minecraft.item.Item;
import net.minecraft.util.WeightedRandom;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictHelper
{
    public static void init()
    {
        OreDictionary.registerOre("ingotSteel", ingotSteel);

    }

    public static Item ingotSteel = new itemIngotSteel();
}
