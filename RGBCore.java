package it.lor54.rgb;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import it.lor54.rgb.blocks.Blocks;
import it.lor54.rgb.items.Items;
import it.lor54.rgb.proxies.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;



























@Mod(modid="RealEE", name="RealEE", version="v1.2.4")
@NetworkMod(channels={"RealEE"}, clientSideRequired=true, serverSideRequired=true)
public class RGBCore
{
  @SidedProxy(clientSide="it.lor54.rgb.proxies.ClientProxy", serverSide="it.lor54.rgb.proxies.ServerProxy")
  public static CommonProxy proxy;
  @Mod.Instance("RealEE")
  public static RGBCore instance = new RGBCore();
  
  public static CreativeTabs RealEETab = new RealEETab(CreativeTabs.getNextID(), "RealEE Electronic Objects");
  public static CreativeTabs OthersTab = new OthersTab(CreativeTabs.getNextID(), "RGBCraft Other Objects");
  
  public RGBCore() {}
  
  @Mod.PreInit
  public void preInit(FMLPreInitializationEvent event) { proxy.preInit(event); }
  

  @Mod.Init
  public void init(FMLInitializationEvent event)
  {
    proxy.init(event);
    Blocks.init();
    Blocks.addNames();
    Items.init();
    Items.addNames();
  }
  
  @Mod.PostInit
  public void postInit(FMLPostInitializationEvent event)
  {
    proxy.postInit(event);
  }
}
