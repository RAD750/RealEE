package it.lor54.rgb.reactor;

import ic2.api.IReactor;
import ic2.api.IReactorComponent;
import it.lor54.rgb.RGBCore;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class Uranium5DualItem
  extends Item implements IReactorComponent
{
  public static final String name = "Sligthly Enriched Uranium Dual Cell";
  public int damage = 7450;
  
  public Uranium5DualItem(int id)
  {
    super(id);
    maxStackSize = 1;
    iconIndex = 14;
    setItemName("Sligthly Enriched Uranium Dual Cell");
    setCreativeTab(RGBCore.RealEETab);
    setMaxDamage(damage);
  }
  

  public void processChamber(IReactor reactor, ItemStack yourStack, int x, int y)
  {
    if (!reactor.produceEnergy()) {
      return;
    }
    
    int pulses = 1;
    acceptUraniumPulse(reactor, yourStack, yourStack, x, y, x, y);
    int heat = pulses * 4 * 2;
    
    if (heat > 0) {
      reactor.addHeat(heat);
    }
    if (yourStack.getItemDamage() >= damage)
    {
      reactor.setItemAt(x, y, null);
    }
    else
    {
      yourStack.damageItem(1, null);
    }
  }
  
  private void setDurabilityForStack(ItemStack aStack)
  {
    NBTTagCompound tNBT = aStack.getTagCompound();
    if (tNBT == null)
    {
      tNBT = new NBTTagCompound();
      aStack.setTagCompound(tNBT);
    }
    tNBT.setInteger("durability", aStack.getItemDamage());
  }
  
  public int getDurabilityOfStack(ItemStack aStack)
  {
    NBTTagCompound tNBT = aStack.getTagCompound();
    if (tNBT == null)
    {
      tNBT = new NBTTagCompound();
      aStack.setTagCompound(tNBT);
    }
    return tNBT.getInteger("durability");
  }
  
  public boolean acceptUraniumPulse(IReactor reactor, ItemStack yourStack, ItemStack pulsingStack, int youX, int youY, int pulseX, int pulseY)
  {
    reactor.addOutput(8);
    return true;
  }
  
  public boolean canStoreHeat(IReactor reactor, ItemStack yourStack, int x, int y)
  {
    return false;
  }
  
  public int getMaxHeat(IReactor reactor, ItemStack yourStack, int x, int y)
  {
    return 0;
  }
  
  public int getCurrentHeat(IReactor reactor, ItemStack yourStack, int x, int y)
  {
    return 0;
  }
  
  public int alterHeat(IReactor reactor, ItemStack yourStack, int x, int y, int heat)
  {
    return heat;
  }
  
  public float influenceExplosion(IReactor reactor, ItemStack yourStack)
  {
    return 4.0F;
  }
  
  public String getTextureFile()
  {
    return "/rgbmod/rgb.png";
  }
}
