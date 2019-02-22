/*  Copyright (C) <2017>  <XFactHD>

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

package XFactHD.eiorteis;

import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.List;

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
    
    public static ItemStack blockClearGlass;

    public static ItemStack ingotSteel;

    public static ItemStack compSandDouble;
    public static ItemStack compSandTripple;

    public static ItemStack clearGlass;

    public static ItemStack xpShard;
    public static FluidStack xpJuice;

    @SuppressWarnings("ConstantConditions")
    public static void init()
    {
        Item alloyItem = Item.REGISTRY.getObject(new ResourceLocation("EnderIO", "itemAlloy"));
        electricalSteel = new ItemStack(alloyItem, 1, 0);
        energeticAlloy = new ItemStack(alloyItem, 1, 1);
        phasedGold = new ItemStack(alloyItem, 1, 2);
        redstoneAlloy = new ItemStack(alloyItem, 1, 3);
        conductiveIron = new ItemStack(alloyItem, 1, 4);
        phasedIron = new ItemStack(alloyItem, 1, 5);
        darkSteel = new ItemStack(alloyItem, 1, 6);
        soularium = new ItemStack(alloyItem, 1, 7);

        Item materialItem = Item.REGISTRY.getObject(new ResourceLocation("EnderIO", "itemMaterial"));
        itemSilicon = new ItemStack(materialItem, 1, 0);
        
        Block clearGlassBase = Block.REGISTRY.getObject(new ResourceLocation("EnderIO", "blockFusedQuartz_fusedGlass"));
        blockClearGlass = new ItemStack(clearGlassBase, 1, 7);

        ingotSteel = getFirstOrNull("ingotSteel");

        compSandDouble = getFirstOrNull("compressed1xSand");
        compSandTripple = getFirstOrNull("compressed2xSand");

        Block glass = Block.REGISTRY.getObject(new ResourceLocation("EnderIO", "blockFusedQuartz"));
        clearGlass = new ItemStack(glass, 1, 1);

        Item shard = Item.REGISTRY.getObject(new ResourceLocation("Woot", "xpShard"));
        xpShard = shard != null ? new ItemStack(shard) : null;
        xpJuice = FluidRegistry.getFluidStack("xpjuice", 320);
    }

    private static ItemStack getFirstOrNull(String oreID)
    {
        List<ItemStack> ores = OreDictionary.getOres(oreID);
        return ores.isEmpty() ? null : ores.get(0);
    }
}
