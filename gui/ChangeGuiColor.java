package it.lor54.rgb.gui;

import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderEngine;
import net.minecraft.entity.player.EntityPlayer;

public class ChangeGuiColor extends GuiScreen
{
  public final int xSizeOfTexture = 176;
  public final int ySizeOfTexture = 88;
  


  public ChangeGuiColor(EntityPlayer player) {}
  

  public void drawScreen(int x, int y, float f)
  {
    drawDefaultBackground();
    int var4 = mc.renderEngine.getTexture("/rgbmod/LxK33.png");
    org.lwjgl.opengl.GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    mc.renderEngine.bindTexture(var4);
    int posX = (width - 176) / 2;
    int posY = (height - 88) / 2;
    drawTexturedModalRect(posX, posY, 0, 0, 176, 88);
    super.drawScreen(x, y, f);
  }
  
  public void initGui()
  {
    controlList.clear();
    int posX = (width - 176) / 2;
    int posY = (height - 88) / 2;
    controlList.add(new net.minecraft.client.gui.GuiButton(0, posX + 40, posY + 40, 100, 20, "no use"));
  }
}
