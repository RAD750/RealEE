package it.lor54.rgb.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class Blocks
{
  public static Block waterGenerator;
  public static Block emergencyFlare;
  public static Block emergencyFlareLit;
  public static Block caloriferoBlock;
  public static Block CaloriferoOvest;
  public static Block CaloriferoNord;
  public static Block CaloriferoSud;
  public static Block CaloriferoEst;
  public static Block electricalLamp;
  public static Block electricalLampLit;
  public static Block AATCable;
  public static Block blockWindmill;
  public static Block blockWindmillGround;
  
  public Blocks() {}
  
  public static void init()
  {
    emergencyFlare = new EmergencyFlareBlock(3001, 0);
    GameRegistry.registerBlock(emergencyFlare, "Emergency Flare");
    emergencyFlareLit = new EmergencyFlareLitBlock(3002, 0);
    GameRegistry.registerBlock(emergencyFlareLit, "Emergency Flare Lit");
    GameRegistry.addShapelessRecipe(new net.minecraft.item.ItemStack(emergencyFlare, 4), new Object[] { Item.stick, Item.gunpowder });
    












    CaloriferoOvest = new CaloriferoOvestBlock(3003, 0);
    GameRegistry.registerBlock(CaloriferoOvest, "Calorifero Ovest");
    GameRegistry.registerTileEntity(it.lor54.rgb.entities.TileEntityCaloriferoOvest.class, "CaloriferoOvestTileEntity");
    
    CaloriferoEst = new CaloriferoEstBlock(3004, 0);
    GameRegistry.registerBlock(CaloriferoEst, "Calorifero Est");
    GameRegistry.registerTileEntity(it.lor54.rgb.entities.TileEntityCaloriferoEst.class, "CaloriferoEstTileEntity");
    
    CaloriferoSud = new CaloriferoSudBlock(3005, 0);
    GameRegistry.registerBlock(CaloriferoSud, "Calorifero Sud");
    GameRegistry.registerTileEntity(it.lor54.rgb.entities.TileEntityCaloriferoSud.class, "CaloriferoSudTileEntity");
    
    CaloriferoNord = new CaloriferoNordBlock(3006, 0);
    GameRegistry.registerBlock(CaloriferoNord, "Calorifero Nord");
    GameRegistry.registerTileEntity(it.lor54.rgb.entities.TileEntityCaloriferoNord.class, "CaloriferoNordTileEntity");
    
    AATCable = new AATCableBlock(3007, 0);
    GameRegistry.registerBlock(AATCable, "AAT Cable");
    GameRegistry.registerTileEntity(it.lor54.rgb.cables.AATCableTileEntity.class, "AATCableTileEntity");
    
    blockWindmill = new WindmillBlock(3008, 0);
    GameRegistry.registerBlock(blockWindmill, "Windmill Block");
    GameRegistry.registerTileEntity(it.lor54.rgb.entities.WindmillTileEntity.class, "WindmillTileEntity");
    
    blockWindmillGround = new BlockWindmillGround(3009, 0);
    GameRegistry.registerBlock(blockWindmillGround, "Windmill Block Ground");
    GameRegistry.registerTileEntity(it.lor54.rgb.entities.TileEntityWindmillFloor.class, "WindmillFloorTileEntity");
    
    caloriferoBlock = new CaloriferoBlock(3010, 0);
    GameRegistry.registerBlock(caloriferoBlock, "Calorifero");
    GameRegistry.registerTileEntity(it.lor54.rgb.entities.TileEntityCaloriferoBlock.class, "CaloriferoBlockileEntity");
  }
  
  public static void addNames()
  {
    LanguageRegistry.addName(emergencyFlare, "Emergency Flare");
    LanguageRegistry.addName(emergencyFlareLit, "Emergency Flare Lit");
    


    LanguageRegistry.addName(caloriferoBlock, "Calorifero");
    LanguageRegistry.addName(CaloriferoOvest, "Calorifero Ovest");
    LanguageRegistry.addName(CaloriferoNord, "Calorifero Nord");
    LanguageRegistry.addName(CaloriferoSud, "Calorifero Sud");
    LanguageRegistry.addName(CaloriferoEst, "Calorifero Est");
    LanguageRegistry.addName(AATCable, "AAT Cable");
    LanguageRegistry.addName(blockWindmill, "Windmill Block");
    LanguageRegistry.addName(blockWindmillGround, "Windmill Block Ground");
  }
}
