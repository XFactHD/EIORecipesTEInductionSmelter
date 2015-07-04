package com.XFactHD.eiorteis.helper;

import com.XFactHD.eiorteis.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTab_eiorteis
{
    public static final CreativeTabs TAB_eiorteis = new CreativeTabs("tabeiorteis")
    {
        @Override
        public Item getTabIconItem()
        {
            return ModItems.GRMix;
        }
    };
}