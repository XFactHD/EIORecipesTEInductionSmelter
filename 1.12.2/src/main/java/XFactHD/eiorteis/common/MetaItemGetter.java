/*  Copyright (C) <2018>  <XFactHD>

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

package XFactHD.eiorteis.common;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.List;

public class MetaItemGetter
{
    public static ItemStack electricalSteel;
    public static ItemStack energeticAlloy;
    public static ItemStack redstoneAlloy;
    public static ItemStack darkSteel;
    public static ItemStack itemSilicon;
    public static ItemStack ingotSteel;

    public static ItemStack compSandDouble;
    public static ItemStack compSandTripple;

    @SuppressWarnings("ConstantConditions")
    public static void init()
    {
        electricalSteel = OreDictionary.getOres("ingotElectricalSteel").get(0);
        energeticAlloy = OreDictionary.getOres("ingotEnergeticAlloy").get(0);
        redstoneAlloy = OreDictionary.getOres("ingotRedstoneAlloy").get(0);
        darkSteel = OreDictionary.getOres("ingotDarkSteel").get(0);
        itemSilicon = OreDictionary.getOres("itemSilicon").get(0);
        ingotSteel = OreDictionary.getOres("ingotSteel").get(0);

        compSandDouble = getFirstOrNull("compressed1xSand");
        compSandTripple = getFirstOrNull("compressed2xSand");
    }

    private static ItemStack getFirstOrNull(String oreID)
    {
        List<ItemStack> ores = OreDictionary.getOres(oreID);
        return ores.isEmpty() ? null : ores.get(0);
    }
}
