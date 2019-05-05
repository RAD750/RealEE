package it.lor54.rgb.items;

import it.lor54.rgb.RGBCore;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class AnemometerItem
  extends Item
{
  private boolean checkBiome = true; private boolean first = true;
  int countMedio = 0; int countBasso = 0; int countAlto = 0; int old = 1;
  private boolean cambia = false; private boolean day = true;
  private double var = 0.0D; private double vento = 1.0D;
  private int random = 3;
  public static final String name = "Anemometer";
  
  public AnemometerItem(int id) {
    super(id);
    setItemName("Anemometer");
    setCreativeTab(RGBCore.OthersTab);
    iconIndex = 23;
  }
  
  public String getTextureFile()
  {
    return "/rgbmod/rgb.png";
  }
  
  public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
  {
	String biome = world.getBiomeGenForCoordsBody((int)player.posX, (int)player.posZ).biomeName;
    if ((startDay(world)) && (day))
    {
      random = randomInteger(1, 5);
      day = false;
    }
    if (endDay(world))
    {
      day = true;
    }
    
    if ((biome == "Forest") || (biome == "ForestHills"))
    {
      if (!thermalInversion(world))
      {
        if (isRaining(world))
        {
          vento = randomInt(5, 6, "medium");


        }
        else if (isThundering(world))
        {
          vento = randomInt(5, 6, "medium");


        }
        else if (!isNight(world))
        {
          vento = randomInt(1, 3, "medium");
        }
        else
        {
          vento = randomInt(0, 2, "medium");

        }
        


      }
      else if (isRaining(world))
      {
        vento = randomInt(5, 6, "medium");


      }
      else if (isThundering(world))
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
      if (!thermalInversion(world))
      {
        if (isRaining(world))
        {
          vento = randomInt(6, 7, "low");


        }
        else if (isThundering(world))
        {
          vento = randomInt(6, 7, "low");


        }
        else if (!isNight(world))
        {
          vento = randomInt(0, 1, "low");
        }
        else
        {
          vento = randomInt(0, 1, "low");

        }
        


      }
      else if (isRaining(world))
      {
        vento = randomInt(6, 7, "low");


      }
      else if (isThundering(world))
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
      if (!thermalInversion(world))
      {
        if (isRaining(world))
        {
          vento = randomInt(2, 4, "low");


        }
        else if (isThundering(world))
        {
          vento = randomInt(3, 5, "low");


        }
        else if (!isNight(world))
        {
          vento = randomInt(0, 2, "low");
        }
        else
        {
          vento = randomInt(0, 2, "low");

        }
        


      }
      else if (isRaining(world))
      {
        vento = randomInt(2, 4, "low");


      }
      else if (isThundering(world))
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
      if (!thermalInversion(world))
      {
        if (isRaining(world))
        {
          vento = randomInt(7, 9, "low");


        }
        else if (isThundering(world))
        {
          vento = randomInt(7, 9, "low");


        }
        else if (!isNight(world))
        {
          vento = randomInt(0, 1, "low");
        }
        else
        {
          vento = randomInt(0, 1, "low");

        }
        


      }
      else if (isRaining(world))
      {
        vento = randomInt(7, 9, "low");


      }
      else if (isThundering(world))
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
      if (isRaining(world))
      {
        vento = randomInt(6, 7, "medium");


      }
      else if (isThundering(world))
      {
        vento = randomInt(8, 10, "medium");


      }
      else if (!isNight(world))
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
      if (!thermalInversion(world))
      {
        if (isRaining(world))
        {
          vento = randomInt(5, 6, "medium");


        }
        else if (isThundering(world))
        {
          vento = randomInt(5, 6, "medium");


        }
        else if (!isNight(world))
        {
          vento = randomInt(1, 3, "medium");
        }
        else
        {
          vento = randomInt(0, 2, "medium");

        }
        


      }
      else if (isRaining(world))
      {
        vento = randomInt(5, 6, "medium");


      }
      else if (isThundering(world))
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
      if (!thermalInversion(world))
      {
        if (isRaining(world))
        {
          vento = randomInt(4, 6, "medium");


        }
        else if (isThundering(world))
        {
          vento = randomInt(4, 6, "medium");


        }
        else if (!isNight(world))
        {
          vento = randomInt(3, 4, "medium");
        }
        else
        {
          vento = randomInt(3, 4, "medium");

        }
        


      }
      else if (isRaining(world))
      {
        vento = randomInt(4, 6, "medium");


      }
      else if (isThundering(world))
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
      if (isRaining(world))
      {
        vento = randomInt(6, 8, "low");


      }
      else if (isThundering(world))
      {
        vento = randomInt(8, 11, "low");


      }
      else if (!isNight(world))
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
      if (isRaining(world))
      {
        vento = randomInt(6, 8, "low");


      }
      else if (isThundering(world))
      {
        vento = randomInt(8, 11, "low");


      }
      else if (!isNight(world))
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
      if (!thermalInversion(world))
      {
        if (isRaining(world))
        {
          vento = randomInt(6, 7, "high");


        }
        else if (isThundering(world))
        {
          vento = randomInt(7, 10, "high");


        }
        else if (!isNight(world))
        {
          vento = randomInt(2, 4, "high");
        }
        else
        {
          vento = randomInt(1, 3, "high");

        }
        


      }
      else if (isRaining(world))
      {
        vento = randomInt(6, 7, "high");


      }
      else if (isThundering(world))
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


    }
    else if (random == 2)
    {
      var = (vento / 100.0D * 7.0D);
      vento -= var;


    }
    else if (random == 4)
    {
      var = (vento / 100.0D * 7.0D);
      vento += var;


    }
    else if (random == 5)
    {
      var = (vento / 100.0D * 15.0D);
      vento += var;
    }
    


    player.sendChatToPlayer("Wind Speed: " + (int)vento + " Beaufort");
    return item;
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
      if (countAlto < 5)
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
      if (countMedio < 15)
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
    else if (countBasso < 30)
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
  
  private boolean isNight(World world) {
    long time = world.getWorldTime();
    if (time > 12500L)
    {
      return true;
    }
    return false;
  }
  
  private boolean isRaining(World world)
  {
    if (world.isRaining())
    {
      return true;
    }
    return false;
  }
  
  private boolean isThundering(World world)
  {
    if (world.isThundering())
    {
      return true;
    }
    return false;
  }
  
  private boolean thermalInversion(World world)
  {
    long time = world.getWorldTime();
    if (((time >= 23500L) && (time <= 24500L)) || (time <= 500L))
      return true;
    return false;
  }
  
  private boolean startDay(World world)
  {
    long time = world.getWorldTime();
    if ((time == 0L) || (time == 24000L))
    {
      return true;
    }
    return false;
  }
  
  private boolean endDay(World world)
  {
    long time = world.getWorldTime();
    if (time == 23999L)
    {
      return true;
    }
    return false;
  }
}
