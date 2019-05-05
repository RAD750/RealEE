package it.lor54.rgb.entities;

import ic2.api.Direction;
import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.event.EnergyTileSourceEvent;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.EventBus;

public class TileEntityWindmillFloor extends TileEntity implements ic2.api.energy.tile.IEnergySource
{
  private boolean added = false;
  public int power = 0;
  private boolean enabled = true;
  
  public TileEntityWindmillFloor() {}
  
  public void updateEntity() { if (enabled)
    {
      if (!added)
      {
        EnergyTileLoadEvent loadevent = new EnergyTileLoadEvent(this);
        MinecraftForge.EVENT_BUS.post(loadevent);
        added = true;
      }
      
      if ((worldObj.getBlockTileEntity(xCoord, yCoord + 16, zCoord) instanceof WindmillTileEntity))
      {

        WindmillTileEntity tile = (WindmillTileEntity)worldObj.getBlockTileEntity(xCoord, yCoord + 16, zCoord);
        power = ((int)(tile.vento * 10.0D));
        
        EnergyTileSourceEvent sourceEvent = new EnergyTileSourceEvent(this, power);
        MinecraftForge.EVENT_BUS.post(sourceEvent);
      }
    }
  }
  

  public boolean isAddedToEnergyNet()
  {
    return added;
  }
  
  public boolean emitsEnergyTo(TileEntity receiver, Direction direction)
  {
    return true;
  }
  
  public int getMaxEnergyOutput()
  {
    return 130;
  }
  
  public void setInactive()
  {
    enabled = false;
    worldObj.removeBlockTileEntity(xCoord, yCoord, zCoord);
    invalidate();
  }
}
