package it.lor54.rgb.models;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;




public class RenderTableCaloriferoSud
  extends TileEntitySpecialRenderer
{
  private ModelCaloriferoNord calorifero;
  
  public RenderTableCaloriferoSud()
  {
    calorifero = new ModelCaloriferoNord();
  }
  
  public void renderTileEntityAt(TileEntity var1, double x, double y, double z, float scale)
  {
    GL11.glPushMatrix();
    
    GL11.glTranslated(x + 0.5D, y + 1.5D, z + 0.5D);
    GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
    bindTextureByName("/rgbmod/calorifero.png");
    GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
    calorifero.render((Entity)null, 0.0F, -0.1F, 0.0F, 0.0F, 0.0F, 0.0625F);
    GL11.glPopMatrix();
  }
}
