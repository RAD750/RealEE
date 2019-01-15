package it.lor54.rgb.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import ic2.api.Items;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import it.lor54.rgb.entities.TileEntityCaloriferoOvest;
import it.lor54.rgb.cables.AATCableTileEntity;
import it.lor54.rgb.entities.TileEntityCaloriferoBlock;
import it.lor54.rgb.entities.TileEntityCaloriferoEst;
import it.lor54.rgb.entities.TileEntityCaloriferoOvest;
import it.lor54.rgb.entities.TileEntityCaloriferoSud;
import it.lor54.rgb.entities.TileEntityCaloriferoNord;
import it.lor54.rgb.entities.TileEntityElectricalLamp;
import it.lor54.rgb.entities.TileEntityWaterGenerator;
import it.lor54.rgb.entities.TileEntityWindmillFloor;
import it.lor54.rgb.entities.WindmillTileEntity;

public class Blocks
{
    public static Block waterGenerator, emergencyFlare, emergencyFlareLit, caloriferoBlock, CaloriferoOvest, CaloriferoNord, CaloriferoSud, CaloriferoEst, electricalLamp, electricalLampLit, AATCable, blockWindmill, blockWindmillGround;

    public static void init()
    {
        // EMERGENCY FLARE
        emergencyFlare = new EmergencyFlareBlock(3001, 0);
        GameRegistry.registerBlock(emergencyFlare, EmergencyFlareBlock.name);
        emergencyFlareLit = new EmergencyFlareLitBlock(3002, 0);
        GameRegistry.registerBlock(emergencyFlareLit, EmergencyFlareLitBlock.name);
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.emergencyFlare, 4), new Object[] { Item.stick, Item.gunpowder });
        // LAMPADA ELETTRICA
        /*electricalLamp = new ElectricalLampBlock(3004, 0);
        GameRegistry.registerBlock(electricalLamp, ElectricalLampBlock.name);
        GameRegistry.registerTileEntity(TileEntityElectricalLamp.class, "TileEntityElectricalLamp");
        electricalLampLit = new ElectricalLampLitBlock(3005, 0);
        GameRegistry.registerBlock(electricalLampLit, ElectricalLampLitBlock.name);*/
        
        // MINI-HYDRO
        /*waterGenerator = new WaterGeneratorBlock(3000, 0);
        GameRegistry.registerBlock(waterGenerator, WaterGeneratorBlock.name);
        GameRegistry.registerTileEntity(TileEntityWaterGenerator.class, "TileEntityWaterGenerator");*/
        //GameRegistry.addRecipe(new ItemStack(Blocks.waterGenerator, 1), new Object[] { "MMM", "MGM", "MMM", 'M', Items.getItem("waterMill"), 'G', Items.getItem("generator") });
         
        CaloriferoOvest = new CaloriferoOvestBlock(3003, 0);
        GameRegistry.registerBlock(CaloriferoOvest, CaloriferoOvestBlock.name);
        GameRegistry.registerTileEntity(TileEntityCaloriferoOvest.class, "CaloriferoOvestTileEntity");

        CaloriferoEst = new CaloriferoEstBlock(3004, 0);
        GameRegistry.registerBlock(CaloriferoEst, CaloriferoEstBlock.name);
        GameRegistry.registerTileEntity(TileEntityCaloriferoEst.class, "CaloriferoEstTileEntity");

        CaloriferoSud = new CaloriferoSudBlock(3005, 0);
        GameRegistry.registerBlock(CaloriferoSud, CaloriferoSudBlock.name);
        GameRegistry.registerTileEntity(TileEntityCaloriferoSud.class, "CaloriferoSudTileEntity");
        
        CaloriferoNord = new CaloriferoNordBlock(3006, 0);
        GameRegistry.registerBlock(CaloriferoNord, CaloriferoNordBlock.name);
        GameRegistry.registerTileEntity(TileEntityCaloriferoNord.class, "CaloriferoNordTileEntity");
        
        AATCable = new AATCableBlock(3007, 0);
        GameRegistry.registerBlock(AATCable, AATCableBlock.name);
        GameRegistry.registerTileEntity(AATCableTileEntity.class, "AATCableTileEntity");

        blockWindmill = new WindmillBlock(3008, 0);
        GameRegistry.registerBlock(blockWindmill, WindmillBlock.name);
        GameRegistry.registerTileEntity(WindmillTileEntity.class, "WindmillTileEntity");
    
        blockWindmillGround = new BlockWindmillGround(3009, 0);
        GameRegistry.registerBlock(blockWindmillGround, BlockWindmillGround.name);
        GameRegistry.registerTileEntity(TileEntityWindmillFloor.class, "WindmillFloorTileEntity");      
        
        caloriferoBlock = new CaloriferoBlock(3010, 0);
        GameRegistry.registerBlock(caloriferoBlock, CaloriferoBlock.name);
        GameRegistry.registerTileEntity(TileEntityCaloriferoBlock.class, "CaloriferoBlockileEntity");
    }

    public static void addNames()
    {
        LanguageRegistry.addName(emergencyFlare, EmergencyFlareBlock.name);
        LanguageRegistry.addName(emergencyFlareLit, EmergencyFlareLitBlock.name);
        //LanguageRegistry.addName(electricalLamp, ElectricalLampBlock.name);
        //LanguageRegistry.addName(electricalLampLit, ElectricalLampLitBlock.name);
        //LanguageRegistry.addName(waterGenerator, WaterGeneratorBlock.name);
        LanguageRegistry.addName(caloriferoBlock, CaloriferoBlock.name);
        LanguageRegistry.addName(CaloriferoOvest, CaloriferoOvestBlock.name);
        LanguageRegistry.addName(CaloriferoNord, CaloriferoNordBlock.name);
        LanguageRegistry.addName(CaloriferoSud, CaloriferoSudBlock.name);
        LanguageRegistry.addName(CaloriferoEst, CaloriferoEstBlock.name);
        LanguageRegistry.addName(AATCable, AATCableBlock.name);
        LanguageRegistry.addName(blockWindmill, WindmillBlock.name);
        LanguageRegistry.addName(blockWindmillGround, BlockWindmillGround.name);
    }
}
