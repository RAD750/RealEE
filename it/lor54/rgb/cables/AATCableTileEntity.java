package it.lor54.rgb.cables;

import ic2.api.Direction;
import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.event.EnergyTileUnloadEvent;
import ic2.api.energy.tile.IEnergyAcceptor;
import ic2.api.energy.tile.IEnergyConductor;
import ic2.api.energy.tile.IEnergyEmitter;
import it.lor54.rgb.entities.TileEntityWindmillFloor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.EventBus;

public class AATCableTileEntity extends TileEntity implements IEnergyConductor
{
  public ForgeDirection[] connections = new ForgeDirection[6];
  boolean added = false;
  

  public AATCableTileEntity() {}
  
  public void updateEntity()
  {
    if (!added)
    {
      EnergyTileLoadEvent loadevent = new EnergyTileLoadEvent(this);
      MinecraftForge.EVENT_BUS.post(loadevent);
      added = true;
    }
    updateConnections();
  }
  
  public void updateConnections()
  {
    if (((worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof AATCableTileEntity)) || ((worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof IEnergyConductor)) || ((worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof IEnergyAcceptor)) || ((worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof IEnergyEmitter)) || ((worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityWindmillFloor))) connections[0] = ForgeDirection.UP; else
      connections[0] = null;
    if (((worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof AATCableTileEntity)) || ((worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof IEnergyConductor)) || ((worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof IEnergyAcceptor)) || ((worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof IEnergyEmitter)) || ((worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityWindmillFloor))) connections[1] = ForgeDirection.DOWN; else
      connections[1] = null;
    if (((worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof AATCableTileEntity)) || ((worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof IEnergyConductor)) || ((worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof IEnergyAcceptor)) || ((worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof IEnergyEmitter)) || ((worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityWindmillFloor))) connections[2] = ForgeDirection.NORTH; else
      connections[2] = null;
    if (((worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord) instanceof AATCableTileEntity)) || ((worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord) instanceof IEnergyConductor)) || ((worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord) instanceof IEnergyAcceptor)) || ((worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord) instanceof IEnergyEmitter)) || ((worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityWindmillFloor))) connections[3] = ForgeDirection.EAST; else
      connections[3] = null;
    if (((worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof AATCableTileEntity)) || ((worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof IEnergyConductor)) || ((worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof IEnergyAcceptor)) || ((worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof IEnergyEmitter)) || ((worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityWindmillFloor))) connections[4] = ForgeDirection.SOUTH; else
      connections[4] = null;
    if (((worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord) instanceof AATCableTileEntity)) || ((worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord) instanceof IEnergyConductor)) || ((worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord) instanceof IEnergyAcceptor)) || ((worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord) instanceof IEnergyEmitter)) || ((worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityWindmillFloor))) connections[5] = ForgeDirection.WEST; else {
      connections[5] = null;
    }
  }
  
  public boolean onlyOneOpposite(ForgeDirection[] directions) {
    ForgeDirection mainDirection = null;
    boolean isOpposite = false;
    
    for (int i = 0; i < directions.length; i++)
    {
      if ((mainDirection == null) && (directions[i] != null)) { mainDirection = directions[i];
      }
      if ((directions[i] != null) && (mainDirection != directions[i]))
      {
        if (!isOpposite(mainDirection, directions[i])) return false;
        isOpposite = true;
      }
    }
    
    return isOpposite;
  }
  
  public boolean isOpposite(ForgeDirection firstDirection, ForgeDirection secondDirection)
  {
    if (((firstDirection.equals(ForgeDirection.NORTH)) && (secondDirection.equals(ForgeDirection.SOUTH))) || ((firstDirection.equals(ForgeDirection.SOUTH)) && (secondDirection.equals(ForgeDirection.NORTH)))) return true;
    if (((firstDirection.equals(ForgeDirection.EAST)) && (secondDirection.equals(ForgeDirection.WEST))) || ((firstDirection.equals(ForgeDirection.WEST)) && (secondDirection.equals(ForgeDirection.EAST)))) return true;
    if (((firstDirection.equals(ForgeDirection.UP)) && (secondDirection.equals(ForgeDirection.DOWN))) || ((firstDirection.equals(ForgeDirection.DOWN)) && (secondDirection.equals(ForgeDirection.UP)))) { return true;
    }
    return false;
  }
  
  public boolean acceptsEnergyFrom(TileEntity emitter, Direction direction)
  {
    return true;
  }
  
  public boolean isAddedToEnergyNet()
  {
    return added;
  }
  
  public boolean emitsEnergyTo(TileEntity receiver, Direction direction)
  {
    return true;
  }
  
  public double getConductionLoss()
  {
    return 0.0D;
  }
  
  public int getInsulationEnergyAbsorption()
  {
    return 8192;
  }
  
  public int getInsulationBreakdownEnergy()
  {
    return 8256;
  }
  
  public int getConductorBreakdownEnergy()
  {
    return 8256;
  }
  


  public void removeInsulation() {}
  

  public void removeConductor()
  {
    unloadTileEntity();
    worldObj.setBlock(xCoord, yCoord, zCoord, 0);
  }
  
  public void unloadTileEntity()
  {
    if (added)
    {
      EnergyTileUnloadEvent unloadevent = new EnergyTileUnloadEvent(this);
      MinecraftForge.EVENT_BUS.post(unloadevent);
      added = false;
    }
  }
  
  public void setInactive()
  {
    worldObj.removeBlockTileEntity(xCoord, yCoord, zCoord);
    invalidate();
  }
}
