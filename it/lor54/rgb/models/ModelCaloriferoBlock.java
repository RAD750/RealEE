package it.lor54.rgb.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCaloriferoBlock extends ModelBase
{
  ModelRenderer Aletta1;
  ModelRenderer Aletta2;
  ModelRenderer Aletta3;
  ModelRenderer Aletta4;
  ModelRenderer Aletta5;
  ModelRenderer Aletta6;
  ModelRenderer Aletta7;
  ModelRenderer CollMandata;
  ModelRenderer CollRitorno;
  ModelRenderer Valvola;
  ModelRenderer Detentore;
  ModelRenderer Supporto1;
  ModelRenderer Supporto2;
  
  public ModelCaloriferoBlock()
  {
    textureWidth = 32;
    textureHeight = 32;
    
    Aletta1 = new ModelRenderer(this, 0, 0);
    Aletta1.addBox(0.0F, 0.0F, 0.0F, 3, 14, 1);
    Aletta1.setRotationPoint(4.0F, 9.0F, 0.0F);
    Aletta1.setTextureSize(32, 32);
    Aletta1.mirror = true;
    setRotation(Aletta1, 0.0F, 0.0F, 0.0F);
    Aletta2 = new ModelRenderer(this, 0, 0);
    Aletta2.addBox(0.0F, 0.0F, 0.0F, 3, 14, 1);
    Aletta2.setRotationPoint(4.0F, 9.0F, 2.0F);
    Aletta2.setTextureSize(32, 32);
    Aletta2.mirror = true;
    setRotation(Aletta2, 0.0F, 0.0F, 0.0F);
    Aletta3 = new ModelRenderer(this, 0, 0);
    Aletta3.addBox(0.0F, 0.0F, 0.0F, 3, 14, 1);
    Aletta3.setRotationPoint(4.0F, 9.0F, 4.0F);
    Aletta3.setTextureSize(32, 32);
    Aletta3.mirror = true;
    setRotation(Aletta3, 0.0F, 0.0F, 0.0F);
    Aletta4 = new ModelRenderer(this, 0, 0);
    Aletta4.addBox(0.0F, 0.0F, 0.0F, 3, 14, 1);
    Aletta4.setRotationPoint(4.0F, 9.0F, 6.0F);
    Aletta4.setTextureSize(32, 32);
    Aletta4.mirror = true;
    setRotation(Aletta4, 0.0F, 0.0F, 0.0F);
    Aletta5 = new ModelRenderer(this, 0, 0);
    Aletta5.addBox(0.0F, 0.0F, 0.0F, 3, 14, 1);
    Aletta5.setRotationPoint(4.0F, 9.0F, -2.0F);
    Aletta5.setTextureSize(32, 32);
    Aletta5.mirror = true;
    setRotation(Aletta5, 0.0F, 0.0F, 0.0F);
    Aletta6 = new ModelRenderer(this, 0, 0);
    Aletta6.addBox(0.0F, 0.0F, 0.0F, 3, 14, 1);
    Aletta6.setRotationPoint(4.0F, 9.0F, -4.0F);
    Aletta6.setTextureSize(32, 32);
    Aletta6.mirror = true;
    setRotation(Aletta6, 0.0F, 0.0F, 0.0F);
    Aletta7 = new ModelRenderer(this, 0, 0);
    Aletta7.addBox(0.0F, 0.0F, 0.0F, 3, 14, 1);
    Aletta7.setRotationPoint(4.0F, 9.0F, -6.0F);
    Aletta7.setTextureSize(32, 32);
    Aletta7.mirror = true;
    setRotation(Aletta7, 0.0F, 0.0F, 0.0F);
    CollMandata = new ModelRenderer(this, 0, 0);
    CollMandata.addBox(0.0F, 0.0F, 0.0F, 1, 1, 13);
    CollMandata.setRotationPoint(5.0F, 11.0F, -7.0F);
    CollMandata.setTextureSize(32, 32);
    CollMandata.mirror = true;
    setRotation(CollMandata, 0.0F, 0.0F, 0.0F);
    CollRitorno = new ModelRenderer(this, 0, 0);
    CollRitorno.addBox(0.0F, 0.0F, 0.0F, 1, 1, 13);
    CollRitorno.setRotationPoint(5.0F, 21.0F, -7.0F);
    CollRitorno.setTextureSize(32, 32);
    CollRitorno.mirror = true;
    setRotation(CollRitorno, 0.0F, 0.0F, 0.0F);
    Valvola = new ModelRenderer(this, 11, 0);
    Valvola.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1);
    Valvola.setRotationPoint(4.0F, 11.0F, -8.0F);
    Valvola.setTextureSize(32, 32);
    Valvola.mirror = true;
    setRotation(Valvola, 0.0F, 0.0F, 0.0F);
    Detentore = new ModelRenderer(this, 0, 0);
    Detentore.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1);
    Detentore.setRotationPoint(4.0F, 21.0F, -8.0F);
    Detentore.setTextureSize(32, 32);
    Detentore.mirror = true;
    setRotation(Detentore, 0.0F, 0.0F, 0.0F);
    Supporto1 = new ModelRenderer(this, 0, 0);
    Supporto1.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1);
    Supporto1.setRotationPoint(5.0F, 12.0F, 5.0F);
    Supporto1.setTextureSize(32, 32);
    Supporto1.mirror = true;
    setRotation(Supporto1, 0.0F, 0.0F, 0.0F);
    Supporto2 = new ModelRenderer(this, 0, 0);
    Supporto2.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1);
    Supporto2.setRotationPoint(5.0F, 12.0F, -5.0F);
    Supporto2.setTextureSize(32, 32);
    Supporto2.mirror = true;
    setRotation(Supporto2, 0.0F, 0.0F, 0.0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Aletta1.render(f5);
    Aletta2.render(f5);
    Aletta3.render(f5);
    Aletta4.render(f5);
    Aletta5.render(f5);
    Aletta6.render(f5);
    Aletta7.render(f5);
    CollMandata.render(f5);
    CollRitorno.render(f5);
    Valvola.render(f5);
    Detentore.render(f5);
    Supporto1.render(f5);
    Supporto2.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }
}
