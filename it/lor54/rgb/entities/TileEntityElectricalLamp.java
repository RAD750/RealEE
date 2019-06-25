package it.lor54.rgb.entities;

import ic2.api.Direction;
import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.event.EnergyTileUnloadEvent;
import ic2.api.energy.tile.IEnergyConductor;
import ic2.api.energy.tile.IEnergySink;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.EventBus;

public class TileEntityElectricalLamp extends TileEntity implements IEnergySink
{
  public int energy = 0;
  public int maxEnergy = 1;
  private boolean initialized = false;
  public boolean added = false;
  
  public TileEntityElectricalLamp() {}
  
  public void readFromNBT(NBTTagCompound nbttagcompound) { super.readFromNBT(nbttagcompound);
    
    if (nbttagcompound.hasKey("energy"))
    {
      energy = nbttagcompound.getInteger("energy");
    }
  }
  
  public void writeToNBT(NBTTagCompound nbttagcompound)
  {
    super.writeToNBT(nbttagcompound);
    nbttagcompound.setInteger("energy", energy);
  }
  
  public void onLoaded()
  {
    if ((!initialized) && (!added))
    {
      MinecraftForge.EVENT_BUS.post(new EnergyTileLoadEvent(this));
      added = true;
    }
    
    initialized = true;
  }
  
  public void onUnloaded()
  {
    if ((initialized) && (added))
    {
      MinecraftForge.EVENT_BUS.post(new EnergyTileUnloadEvent(this));
      added = false;
    }
  }
  

  public void onChunkUnload()
  {
    super.onChunkUnload();
    
    if (initialized)
    {
      onUnloaded();
    }
  }
  

  public void updateEntity()
  {
    super.updateEntity();
    onLoaded();
  }
  


  public void invalidate()
  {
    EnergyTileUnloadEvent unloadEvent = new EnergyTileUnloadEvent(this);
    MinecraftForge.EVENT_BUS.post(unloadEvent);
    
    super.invalidate();
  }
  

  public boolean acceptsEnergyFrom(TileEntity emitter, Direction direction)
  {
    return emitter instanceof IEnergyConductor;
  }
  

  public boolean isAddedToEnergyNet()
  {
    return added;
  }
  

  public int demandsEnergy()
  {
    return maxEnergy - energy;
  }
  

  public int injectEnergy(Direction directionFrom, int amount)
  {
    if (energy >= maxEnergy)
    {
      return amount;
    }
    
    int openEnergy = maxEnergy - energy;
    
    if (openEnergy >= amount)
    {
      energy += amount;
      return 0;
    }
    if (amount > openEnergy)
    {
      energy = maxEnergy;
      return amount - openEnergy;
    }
    
    return 0;
  }
  

  public int getMaxSafeInput()
  {
    return 32;
  }
}
