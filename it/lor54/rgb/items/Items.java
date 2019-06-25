package it.lor54.rgb.items;

import cpw.mods.fml.common.registry.GameRegistry;

public class Items {
  public static net.minecraft.item.Item tornPaper;
  public static net.minecraft.item.Item windmillItem;
  public static net.minecraft.item.Item crumpledPlant;
  public static net.minecraft.item.Item charredPlant;
  public static net.minecraft.item.Item savaraDisk;
  public static net.minecraft.item.Item arrakisDisk;
  public static net.minecraft.item.Item windmillGround;
  public static net.minecraft.item.Item daggerfallDik;
  public static net.minecraft.item.Item moxItem;
  public static net.minecraft.item.Item moxDualItem;
  public static net.minecraft.item.Item moxQuadItem;
  public static net.minecraft.item.Item ura5Item;
  public static net.minecraft.item.Item ura5DualItem;
  public static net.minecraft.item.Item ura5QuadItem;
  public static net.minecraft.item.Item anemometerItem;
  public static net.minecraft.item.Item nacelleItem;
  public static net.minecraft.item.Item palaItem;
  public static net.minecraft.item.Item paloItem;
  
  public Items() {}
  
  public static void init() {
    tornPaper = new TornPaperItem(3010);
    GameRegistry.registerItem(tornPaper, "Torn Paper");
    GameRegistry.addShapelessRecipe(new net.minecraft.item.ItemStack(tornPaper, 2), new Object[] { net.minecraft.item.Item.paper });
    GameRegistry.addShapelessRecipe(new net.minecraft.item.ItemStack(tornPaper, 6), new Object[] { net.minecraft.item.Item.book });
    
    charredPlant = new CharredPlantItem(3011);
    GameRegistry.registerItem(charredPlant, "Charred Plant");
    
    crumpledPlant = new CrumpledPlantItem(3012);
    GameRegistry.registerItem(crumpledPlant, "Crumpled Plant");
    GameRegistry.addSmelting(crumpledPlant.itemID, new net.minecraft.item.ItemStack(charredPlant, 1), 1.0F);
    GameRegistry.addShapelessRecipe(new net.minecraft.item.ItemStack(crumpledPlant, 2), new Object[] { net.minecraft.block.Block.cactus });
    
    GameRegistry.registerFuelHandler(new it.lor54.rgb.FuelHandler());
    
    savaraDisk = new it.lor54.rgb.sounds.SavaraDisk(3013);
    GameRegistry.registerItem(savaraDisk, "Inno Savara");
    
    moxItem = new it.lor54.rgb.reactor.MoxItem(3014);
    GameRegistry.registerItem(moxItem, "MOX Cell");
    
    moxDualItem = new it.lor54.rgb.reactor.MoxDualItem(3015);
    GameRegistry.registerItem(moxDualItem, "MOX Dual Cell");
    
    moxQuadItem = new it.lor54.rgb.reactor.MoxQuadItem(3016);
    GameRegistry.registerItem(moxQuadItem, "MOX Quad Cell");
    
    ura5Item = new it.lor54.rgb.reactor.Uranium5Item(3017);
    GameRegistry.registerItem(ura5Item, " Sligthly Enriched Uranium Cell");
    
    ura5DualItem = new it.lor54.rgb.reactor.Uranium5DualItem(3018);
    GameRegistry.registerItem(ura5DualItem, "Sligthly Enriched Uranium Dual Cell");
    
    ura5QuadItem = new it.lor54.rgb.reactor.Uranium5QuadItem(3019);
    GameRegistry.registerItem(ura5QuadItem, "Sligthly Enriched Uranium Quad Cell");
    
    arrakisDisk = new it.lor54.rgb.sounds.ArrakisDisk(3020);
    GameRegistry.registerItem(arrakisDisk, "Inno Arrakis");
    
    daggerfallDik = new it.lor54.rgb.sounds.DaggerfallDisk(3021);
    GameRegistry.registerItem(daggerfallDik, "Inno Daggerfall");
    
    nacelleItem = new NacelleItem(3025);
    GameRegistry.registerItem(nacelleItem, "Wind Generator");
    GameRegistry.addRecipe(new net.minecraft.item.ItemStack(nacelleItem, 1), new Object[] { "BBB", "BCI", "BCB", Character.valueOf('B'), net.minecraft.block.Block.blockSteel, Character.valueOf('C'), ic2.api.Items.getItem("doubleInsulatedGoldCableItem"), Character.valueOf('I'), net.minecraft.item.Item.ingotIron });
    
    palaItem = new PalaItem(3026);
    GameRegistry.registerItem(palaItem, "Wind Turbine Blades");
    GameRegistry.addRecipe(new net.minecraft.item.ItemStack(palaItem, 1), new Object[] { "I  ", " I ", "  I", Character.valueOf('I'), net.minecraft.block.Block.blockSteel });
    
    paloItem = new PaloItem(3027);
    GameRegistry.registerItem(paloItem, "Wind Turbine Tower");
    GameRegistry.addRecipe(new net.minecraft.item.ItemStack(paloItem, 1), new Object[] { " I ", " I ", " I ", Character.valueOf('I'), net.minecraft.block.Block.blockSteel });
    
    windmillItem = new WindmillItem(3022);
    GameRegistry.registerItem(windmillItem, "Wind Turbine");
    GameRegistry.addRecipe(new net.minecraft.item.ItemStack(windmillItem, 1), new Object[] { "   ", " AP", " B ", Character.valueOf('A'), nacelleItem, Character.valueOf('P'), palaItem, Character.valueOf('B'), paloItem });
    
    windmillGround = new WindmillGroundItem(3023);
    GameRegistry.registerItem(windmillGround, "Wind Turbine Baseplate");
    GameRegistry.addRecipe(new net.minecraft.item.ItemStack(windmillGround, 1), new Object[] { "CIC", "ICI", "CBC", Character.valueOf('I'), net.minecraft.block.Block.blockSteel, Character.valueOf('C'), net.minecraft.block.Block.blockClay, Character.valueOf('B'), ic2.api.Items.getItem("doubleInsulatedGoldCableItem") });
    
    anemometerItem = new AnemometerItem(3024);
    GameRegistry.registerItem(anemometerItem, "Anemometer");
    GameRegistry.addRecipe(new net.minecraft.item.ItemStack(anemometerItem, 1), new Object[] { " L ", "LBL", "LCL", Character.valueOf('L'), net.minecraft.item.Item.ingotIron, Character.valueOf('B'), net.minecraft.item.Item.compass, Character.valueOf('C'), ic2.api.Items.getItem("electronicCircuit") });
  }
  

  public static void addNames()
  {
    cpw.mods.fml.common.registry.LanguageRegistry.addName(tornPaper, "Torn Paper");
    
    cpw.mods.fml.common.registry.LanguageRegistry.addName(crumpledPlant, "Crumpled Plant");
    
    cpw.mods.fml.common.registry.LanguageRegistry.addName(charredPlant, "Charred Plant");
    
    cpw.mods.fml.common.registry.LanguageRegistry.addName(savaraDisk, "Inno Savara");
    
    cpw.mods.fml.common.registry.LanguageRegistry.addName(moxItem, "MOX Cell");
    
    cpw.mods.fml.common.registry.LanguageRegistry.addName(moxDualItem, "MOX Dual Cell");
    
    cpw.mods.fml.common.registry.LanguageRegistry.addName(moxQuadItem, "MOX Quad Cell");
    
    cpw.mods.fml.common.registry.LanguageRegistry.addName(ura5Item, " Sligthly Enriched Uranium Cell");
    
    cpw.mods.fml.common.registry.LanguageRegistry.addName(ura5DualItem, "Sligthly Enriched Uranium Dual Cell");
    
    cpw.mods.fml.common.registry.LanguageRegistry.addName(ura5QuadItem, "Sligthly Enriched Uranium Quad Cell");
    
    cpw.mods.fml.common.registry.LanguageRegistry.addName(arrakisDisk, "Inno Arrakis");
    
    cpw.mods.fml.common.registry.LanguageRegistry.addName(daggerfallDik, "Inno Daggerfall");
    
    cpw.mods.fml.common.registry.LanguageRegistry.addName(windmillItem, "Wind Turbine");
    
    cpw.mods.fml.common.registry.LanguageRegistry.addName(windmillGround, "Wind Turbine Baseplate");
    
    cpw.mods.fml.common.registry.LanguageRegistry.addName(anemometerItem, "Anemometer");
    
    cpw.mods.fml.common.registry.LanguageRegistry.addName(nacelleItem, "Wind Generator");
    
    cpw.mods.fml.common.registry.LanguageRegistry.addName(palaItem, "Wind Turbine Blades");
    
    cpw.mods.fml.common.registry.LanguageRegistry.addName(paloItem, "Wind Turbine Tower");
  }
}
