package it.lor54.rgb;

import cpw.mods.fml.common.IFuelHandler;
import it.lor54.rgb.items.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FuelHandler implements IFuelHandler
{
  public FuelHandler() {}
  
  public int getBurnTime(ItemStack fuel)
  {
    Item itemFuel = fuel.getItem();
    
    if (itemFuel == Items.tornPaper)
    {
      return 100;
    }
    

    if (itemFuel == Items.charredPlant)
    {
      return 350;
    }
    

    return 0;
  }
}
