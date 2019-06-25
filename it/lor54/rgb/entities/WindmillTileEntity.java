package it.lor54.rgb.entities;

import java.util.Random;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;


public class WindmillTileEntity extends TileEntity
{
  private boolean enabled = true;
  public float rotation = 0.0F;
  private boolean checkBiome = true; private boolean first = true;
  private String biome;
  public int maxPower = 100;
  int countMedio = 0; int countBasso = 0; int countAlto = 0; int old = 1;
  int tick = 100;
  private boolean cambia = false; private boolean day = true;
  public double var = 0.0D; public double vento = 1.0D;
  private int random = 3;
    
  public void updateEntity()
  {
    if (enabled)
    {
      if (worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) == null)
      {
        if ((startDay()) && (day))
        {
          random = randomInteger(1, 5);
          day = false;
        }
        if (endDay())
        {
          day = true;
        }
        
        if (checkBiome)
        {
          biome = worldObj.getBiomeGenForCoordsBody(xCoord, zCoord).biomeName;
          checkBiome = false;
        }
        
        if ((biome == "Forest") || (biome == "ForestHills"))
        {
          if (!thermalInversion())
          {
            if (isRaining())
            {
              vento = randomInt(5, 6, "medium");


            }
            else if (isThundering())
            {
              vento = randomInt(5, 6, "medium");


            }
            else if (!isNight())
            {
              vento = randomInt(1, 3, "medium");
            }
            else
            {
              vento = randomInt(0, 2, "medium");

            }
            


          }
          else if (isRaining())
          {
            vento = randomInt(5, 6, "medium");


          }
          else if (isThundering())
          {
            vento = randomInt(5, 6, "medium");
          }
          else
          {
            vento = randomInt(0, 1, "low");

          }
          


        }
        else if ((biome == "Desert") || (biome == "DesertHills"))
        {
          if (!thermalInversion())
          {
            if (isRaining())
            {
              vento = randomInt(6, 7, "low");


            }
            else if (isThundering())
            {
              vento = randomInt(6, 7, "low");


            }
            else if (!isNight())
            {
              vento = randomInt(0, 1, "low");
            }
            else
            {
              vento = randomInt(0, 1, "low");

            }
            


          }
          else if (isRaining())
          {
            vento = randomInt(6, 7, "low");


          }
          else if (isThundering())
          {
            vento = randomInt(6, 7, "low");
          }
          else
          {
            vento = randomInt(0, 1, "low");

          }
          


        }
        else if ((biome == "Plains") || (biome == "River"))
        {
          if (!thermalInversion())
          {
            if (isRaining())
            {
              vento = randomInt(2, 4, "low");


            }
            else if (isThundering())
            {
              vento = randomInt(3, 5, "low");


            }
            else if (!isNight())
            {
              vento = randomInt(0, 2, "low");
            }
            else
            {
              vento = randomInt(0, 2, "low");

            }
            


          }
          else if (isRaining())
          {
            vento = randomInt(2, 4, "low");


          }
          else if (isThundering())
          {
            vento = randomInt(3, 5, "low");
          }
          else
          {
            vento = randomInt(0, 1, "low");

          }
          


        }
        else if (biome == "Swampland")
        {
          vento = randomInt(0, 1, "low");


        }
        else if ((biome == "Jungle") || (biome == "JungleHills"))
        {
          if (!thermalInversion())
          {
            if (isRaining())
            {
              vento = randomInt(7, 9, "low");


            }
            else if (isThundering())
            {
              vento = randomInt(7, 9, "low");


            }
            else if (!isNight())
            {
              vento = randomInt(0, 1, "low");
            }
            else
            {
              vento = randomInt(0, 1, "low");

            }
            


          }
          else if (isRaining())
          {
            vento = randomInt(7, 9, "low");


          }
          else if (isThundering())
          {
            vento = randomInt(7, 9, "low");
          }
          else
          {
            vento = randomInt(0, 1, "low");

          }
          


        }
        else if ((biome == "Tundra") || (biome == "Ice Mountains") || (biome == "Ice Plains") || (biome == "FrozenOcean") || (biome == "FrozenRiver"))
        {
          if (isRaining())
          {
            vento = randomInt(6, 7, "medium");


          }
          else if (isThundering())
          {
            vento = randomInt(8, 10, "medium");


          }
          else if (!isNight())
          {
            vento = randomInt(4, 5, "medium");
          }
          else
          {
            vento = randomInt(4, 5, "medium");

          }
          


        }
        else if ((biome == "Taiga") || (biome == "TaigaHills"))
        {
          if (!thermalInversion())
          {
            if (isRaining())
            {
              vento = randomInt(5, 6, "medium");


            }
            else if (isThundering())
            {
              vento = randomInt(5, 6, "medium");


            }
            else if (!isNight())
            {
              vento = randomInt(1, 3, "medium");
            }
            else
            {
              vento = randomInt(0, 2, "medium");

            }
            


          }
          else if (isRaining())
          {
            vento = randomInt(5, 6, "medium");


          }
          else if (isThundering())
          {
            vento = randomInt(5, 6, "medium");
          }
          else
          {
            vento = randomInt(0, 1, "low");

          }
          


        }
        else if ((biome == "Extreme Hills") || (biome == "Extreme Hills Edge"))
        {
          if (!thermalInversion())
          {
            if (isRaining())
            {
              vento = randomInt(4, 6, "medium");


            }
            else if (isThundering())
            {
              vento = randomInt(4, 6, "medium");


            }
            else if (!isNight())
            {
              vento = randomInt(3, 4, "medium");
            }
            else
            {
              vento = randomInt(3, 4, "medium");

            }
            


          }
          else if (isRaining())
          {
            vento = randomInt(4, 6, "medium");


          }
          else if (isThundering())
          {
            vento = randomInt(4, 6, "medium");
          }
          else
          {
            vento = randomInt(0, 1, "low");

          }
          


        }
        else if (biome == "Ocean")
        {
          if (isRaining())
          {
            vento = randomInt(6, 8, "low");


          }
          else if (isThundering())
          {
            vento = randomInt(8, 11, "low");


          }
          else if (!isNight())
          {
            vento = randomInt(4, 6, "low");
          }
          else
          {
            vento = randomInt(4, 6, "low");

          }
          


        }
        else if ((biome == "MushroomIsland") || (biome == "MushroomIslandShore"))
        {
          if (isRaining())
          {
            vento = randomInt(6, 8, "low");


          }
          else if (isThundering())
          {
            vento = randomInt(8, 11, "low");


          }
          else if (!isNight())
          {
            vento = randomInt(4, 6, "low");
          }
          else
          {
            vento = randomInt(4, 6, "low");

          }
          


        }
        else if (biome == "Beach")
        {
          if (!thermalInversion())
          {
            if (isRaining())
            {
              vento = randomInt(6, 7, "high");


            }
            else if (isThundering())
            {
              vento = randomInt(7, 10, "high");


            }
            else if (!isNight())
            {
              vento = randomInt(2, 4, "high");
            }
            else
            {
              vento = randomInt(1, 3, "high");

            }
            


          }
          else if (isRaining())
          {
            vento = randomInt(6, 7, "high");


          }
          else if (isThundering())
          {
            vento = randomInt(7, 10, "high");
          }
          else
          {
            vento = randomInt(0, 1, "low");
          }
        }
        












        if (random == 1)
        {
          var = (vento / 100.0D * 15.0D);
          vento -= var;
          rotation = ((float)(rotation + vento));


        }
        else if (random == 2)
        {
          var = (vento / 100.0D * 7.0D);
          vento -= var;
          rotation = ((float)(rotation + vento));


        }
        else if (random == 3)
        {
          rotation = ((float)(rotation + vento));


        }
        else if (random == 4)
        {
          var = (vento / 100.0D * 7.0D);
          vento += var;
          rotation = ((float)(rotation + vento));
        }
        else
        {
          var = (vento / 100.0D * 15.0D);
          vento += var;
          rotation = ((float)(rotation + vento));
        }
      }
    }
  }
  







  private int randomInt(int min, int max, String variation)
  {
    int vento = randomInteger(min, max);
    if (first)
    {
      old = vento;
      first = false;
    }
    
    if (variation == "high")
    {
      if (countAlto < 60)
      {
        vento = old;
        countAlto += 1;
      }
      else
      {
        vento = randomInteger(min, max);
        old = vento;
        countAlto = 0;
      }
      

    }
    else if (variation == "medium")
    {
      if (countMedio < 170)
      {
        vento = old;
        countMedio += 1;
      }
      else
      {
        vento = randomInteger(min, max);
        old = vento;
        countMedio = 0;
      }
      

    }
    else if (countBasso < 300)
    {
      vento = old;
      countBasso += 1;
    }
    else
    {
      vento = randomInteger(min, max);
      old = vento;
      countBasso = 0;
    }
    




    return vento;
  }
  
  private int randomInteger(int min, int max)
  {
    Random rand = new Random();
    return rand.nextInt(max - min + 1) + min;
  }
  
  private boolean isNight() {
    long time = worldObj.getWorldTime();
    if (time > 12500L)
    {
      return true;
    }
    return false;
  }
  
  private boolean isRaining()
  {
    if (worldObj.isRaining())
    {
      return true;
    }
    return false;
  }
  
  public void setInactive()
  {
    enabled = false;
    worldObj.removeBlockTileEntity(xCoord, yCoord, zCoord);
    invalidate();
  }
  
  private boolean isThundering()
  {
    if (worldObj.isThundering())
    {
      return true;
    }
    return false;
  }
  
  private boolean thermalInversion()
  {
    long time = worldObj.getWorldTime();
    if (((time >= 23500L) && (time <= 24500L)) || (time <= 500L))
      return true;
    return false;
  }
  
  private boolean startDay()
  {
    long time = worldObj.getWorldTime();
    if ((time == 0L) || (time == 24000L))
    {
      return true;
    }
    return false;
  }
  
  private boolean endDay()
  {
    long time = worldObj.getWorldTime();
    if (time == 23999L)
    {
      return true;
    }
    return false;
  }
}
