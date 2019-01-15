package it.lor54.rgb;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
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
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import it.lor54.rgb.blocks.Blocks;
import it.lor54.rgb.cables.AATCableTileEntity;
import it.lor54.rgb.entities.TileEntityCaloriferoBlock;
import it.lor54.rgb.entities.TileEntityCaloriferoEst;
import it.lor54.rgb.entities.TileEntityCaloriferoNord;
import it.lor54.rgb.entities.TileEntityCaloriferoOvest;
import it.lor54.rgb.entities.TileEntityCaloriferoSud;
import it.lor54.rgb.entities.TileEntityWindmillFloor;
import it.lor54.rgb.entities.WindmillTileEntity;
import it.lor54.rgb.items.Items;
import it.lor54.rgb.models.RenderTableAATCable;
import it.lor54.rgb.models.RenderTableCalorifero;
import it.lor54.rgb.models.RenderTableCaloriferoEst;
import it.lor54.rgb.models.RenderTableCaloriferoNord;
import it.lor54.rgb.models.RenderTableCaloriferoOvest;
import it.lor54.rgb.models.RenderTableCaloriferoSud;
import it.lor54.rgb.models.RenderTableWindmill;
import it.lor54.rgb.proxies.ClientProxy;
import it.lor54.rgb.proxies.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.Configuration;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION)
@NetworkMod(channels = {ModInfo.CHANNEL}, clientSideRequired = true, serverSideRequired = true)

public class RGBCore
{
    @SidedProxy(clientSide = ModInfo.CLIENT_PROXY, serverSide = ModInfo.SERVER_PROXY)
    public static CommonProxy proxy;

    @Instance(ModInfo.NAME)
    public static RGBCore instance = new RGBCore();
    
    public static CreativeTabs RealEETab = new RealEETab(CreativeTabs.getNextID(), "RealEE Electronic Objects");
    public static CreativeTabs OthersTab = new OthersTab(CreativeTabs.getNextID(), "RGBCraft Other Objects");

    @PreInit
    public void preInit(FMLPreInitializationEvent event)
    {
    	proxy.preInit(event);
    }

    @Init
    public void init(FMLInitializationEvent event)
    {    	
    	proxy.init(event);
        Blocks.init();
        Blocks.addNames();
        Items.init();
        Items.addNames(); 
    }
    
    @PostInit
    public void postInit(FMLPostInitializationEvent event)
    {
    	proxy.postInit(event);
    }
}