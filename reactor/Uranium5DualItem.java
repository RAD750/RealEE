package it.lor54.rgb.reactor;
import ic2.api.IReactor;
import ic2.api.IReactorComponent;
import it.lor54.rgb.RGBCore;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import ic2.api.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class Uranium5DualItem extends Item implements IReactorComponent
{
    public final static String name = "Sligthly Enriched Uranium Dual Cell";
    public int damage = 7450;

	public Uranium5DualItem(int id)
	{
	    super(id);
	    this.maxStackSize = 1;
	    this.iconIndex = 14;
		this.setItemName(name);
		this.setCreativeTab(RGBCore.RealEETab);
		this.setMaxDamage(damage);
	}

	@Override
	public void processChamber(IReactor reactor, ItemStack yourStack, int x, int y)
	{
		if (!reactor.produceEnergy()) { // CONTROLLO ACCENSIONE REATTORE
		      return;
		}

	    int pulses = 1;
	    acceptUraniumPulse(reactor, yourStack, yourStack, x, y, x, y);
	    int heat = (pulses * 4) * 2; // Doppio dell'uranio singolo

	    if(heat > 0) // CALORE AGGIORNATO AD OGNI ITERAZIONE
	    	reactor.addHeat(heat);

	    if(yourStack.getItemDamage() >= damage) // COMPLETATO IL CICLO DI VITA
	    {
	    	reactor.setItemAt(x, y, null);
	    }
	    else
	    {
	    	yourStack.damageItem(1, null); // LO DANNEGGIO
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

	@Override
	public boolean acceptUraniumPulse(IReactor reactor, ItemStack yourStack, ItemStack pulsingStack, int youX, int youY, int pulseX, int pulseY) {
		reactor.addOutput(8); // PRODUZIONE DOPPIA RISPETTO A DUAL URANIO NORMALE
	    return true;
	}

	@Override
	public boolean canStoreHeat(IReactor reactor, ItemStack yourStack, int x, int y) {
		return false;
	}

	@Override
	public int getMaxHeat(IReactor reactor, ItemStack yourStack, int x, int y) {
		return 0;
	}

	@Override
	public int getCurrentHeat(IReactor reactor, ItemStack yourStack, int x, int y) {
		return 0;
	}

	@Override
	public int alterHeat(IReactor reactor, ItemStack yourStack, int x, int y, int heat) {
		return heat;
	}

	@Override
	public float influenceExplosion(IReactor reactor, ItemStack yourStack) {
		return 4;
	}

	public String getTextureFile()
	{
		return "/rgbmod/rgb.png";
	}
}