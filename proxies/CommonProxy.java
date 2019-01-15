package it.lor54.rgb.proxies;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import it.lor54.rgb.blocks.Blocks;
import it.lor54.rgb.cables.AATCableTileEntity;
import it.lor54.rgb.entities.TileEntityCaloriferoBlock;
import it.lor54.rgb.entities.TileEntityCaloriferoEst;
import it.lor54.rgb.entities.TileEntityCaloriferoNord;
import it.lor54.rgb.entities.TileEntityCaloriferoOvest;
import it.lor54.rgb.entities.TileEntityCaloriferoSud;
import it.lor54.rgb.entities.WindmillTileEntity;
import it.lor54.rgb.items.Items;
import it.lor54.rgb.models.RenderTableAATCable;
import it.lor54.rgb.models.RenderTableCalorifero;
import it.lor54.rgb.models.RenderTableCaloriferoEst;
import it.lor54.rgb.models.RenderTableCaloriferoNord;
import it.lor54.rgb.models.RenderTableCaloriferoOvest;
import it.lor54.rgb.models.RenderTableCaloriferoSud;
import it.lor54.rgb.models.RenderTableWindmill;
import net.minecraft.block.BlockSand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;

public class CommonProxy
{
	@PreInit
    public void preInit(FMLPreInitializationEvent event)
    {
        
    }

    @Init
    public void init(FMLInitializationEvent event)
    {    	

    }
    
    @PostInit
    public void postInit(FMLPostInitializationEvent event)
    {
    }
}