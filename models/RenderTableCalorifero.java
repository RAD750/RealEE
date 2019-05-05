package it.lor54.rgb.models;

import it.lor54.rgb.blocks.Blocks;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class RenderTableCalorifero extends TileEntitySpecialRenderer
{
  private ModelCaloriferoBlock calorifero;
  
  public RenderTableCalorifero()
  {
    calorifero = new ModelCaloriferoBlock();
  }
  


  public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float scale)
  {
    int metadata = tileentity.getWorldObj().getBlockMetadata(tileentity.xCoord, tileentity.yCoord, tileentity.zCoord);
    
    int direction = 2;
    if (tileentity.getWorldObj().getBlockId(tileentity.xCoord, tileentity.yCoord, tileentity.zCoord) == Blocks.caloriferoBlock.blockID)
    {
      direction = tileentity.getWorldObj().getBlockMetadata(tileentity.xCoord, tileentity.yCoord, tileentity.zCoord) + 1;
      if (direction == 1) {
        direction = 3;
      }
      else if (direction == 3) {
        direction = 1;
      }
    }
    GL11.glPushMatrix();
    

    GL11.glTranslated(x + 0.5D, y - 0.45D, z + 0.5D);
    
    GL11.glRotatef(direction * 90, 0.0F, 1.0F, 0.0F);
    


    bindTextureByName("/rgbmod/calorifero.png");
    calorifero.render((Entity)null, 0.0F, -0.1F, 0.0F, 0.0F, 0.0F, 0.0625F);
    
    GL11.glPopMatrix();
  }
}
