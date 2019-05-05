package it.lor54.rgb.proxies;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import it.lor54.rgb.cables.AATCableTileEntity;
import it.lor54.rgb.entities.TileEntityCaloriferoBlock;
import it.lor54.rgb.entities.TileEntityCaloriferoEst;
import it.lor54.rgb.entities.TileEntityCaloriferoNord;
import it.lor54.rgb.entities.TileEntityCaloriferoOvest;
import it.lor54.rgb.entities.TileEntityCaloriferoSud;
import it.lor54.rgb.entities.WindmillTileEntity;
import it.lor54.rgb.models.RenderTableAATCable;
import it.lor54.rgb.models.RenderTableCalorifero;
import it.lor54.rgb.models.RenderTableCaloriferoEst;
import it.lor54.rgb.models.RenderTableCaloriferoNord;
import it.lor54.rgb.models.RenderTableCaloriferoOvest;
import it.lor54.rgb.models.RenderTableCaloriferoSud;
import it.lor54.rgb.models.RenderTableWindmill;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy
  extends CommonProxy
{
  public ClientProxy() {}
  
  @Mod.PreInit
  public void preInit(FMLPreInitializationEvent event)
  {
    super.preInit(event);
    MinecraftForgeClient.preloadTexture("/rgbmod/rgb.png");
  }
  
  @Mod.Init
  public void init(FMLInitializationEvent event)
  {
    super.init(event);
    ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCaloriferoBlock.class, new RenderTableCalorifero());
    ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCaloriferoOvest.class, new RenderTableCaloriferoOvest());
    ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCaloriferoEst.class, new RenderTableCaloriferoEst());
    ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCaloriferoSud.class, new RenderTableCaloriferoSud());
    ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCaloriferoNord.class, new RenderTableCaloriferoNord());
    ClientRegistry.bindTileEntitySpecialRenderer(AATCableTileEntity.class, new RenderTableAATCable());
    ClientRegistry.bindTileEntitySpecialRenderer(WindmillTileEntity.class, new RenderTableWindmill());
  }
  
  @Mod.PostInit
  public void postInit(FMLPostInitializationEvent event)
  {
    super.postInit(event);
  }
}
