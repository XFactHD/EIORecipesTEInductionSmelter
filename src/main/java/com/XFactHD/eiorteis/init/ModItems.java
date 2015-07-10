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

import com.XFactHD.eiorteis.item.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ModItems
{
    public static final Item GRMix = new itemGRMix();
    public static final Item ingotSteelBase = new itemIngotSteelBase();

    public static void init()
    {
        GameRegistry.registerItem(GRMix, "itemGRMix");

        if (GameRegistry.findItem(null, "ingotSteel") == null)
        {
            GameRegistry.registerItem(ingotSteelBase, "itemIngotSteelBase");
        }
        else
        {
            return;
        }
    }
}
