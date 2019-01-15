package it.lor54.rgb;

import cpw.mods.fml.common.IFuelHandler;
import it.lor54.rgb.items.Items;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FuelHandler implements IFuelHandler
{
    @Override
    public int getBurnTime(ItemStack fuel)
    {
        Item itemFuel = fuel.getItem();

        if (itemFuel == Items.tornPaper)
        {
            return 100;
        }
        else
        {
            if (itemFuel == Items.charredPlant)
            {
                return 350;
            }
        }

        return 0;
    }
}
