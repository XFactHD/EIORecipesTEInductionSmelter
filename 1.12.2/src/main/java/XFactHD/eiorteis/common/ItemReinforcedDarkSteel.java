package XFactHD.eiorteis.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemReinforcedDarkSteel extends Item
{
    public ItemReinforcedDarkSteel()
    {
        setMaxStackSize(64);
        setRegistryName("item_reinforced_dark_steel");
        setUnlocalizedName(getRegistryName().toString());
        setCreativeTab(CreativeTabs.MATERIALS);
    }
}