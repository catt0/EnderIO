package crazypants.enderio.fluid;

import crazypants.util.ClientUtil;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Buckets {

  public static ItemBucketEio itemBucketNutrientDistillation;
  public static ItemBucketEio itemBucketHootch;
  public static ItemBucketEio itemBucketRocketFuel;
  public static ItemBucketEio itemBucketFireWater;
  public static ItemBucketEio itemBucketXpJuice;
  
  public static void createBuckets() {
    if(Fluids.fluidXpJuice != null) {
      itemBucketXpJuice = ItemBucketEio.create(Fluids.fluidXpJuice);
    } 
    itemBucketNutrientDistillation = ItemBucketEio.create(Fluids.fluidNutrientDistillation);
    itemBucketHootch = ItemBucketEio.create(Fluids.fluidHootch);
    itemBucketRocketFuel = ItemBucketEio.create(Fluids.fluidRocketFuel);
    itemBucketFireWater = ItemBucketEio.create(Fluids.fluidFireWater);
  }
  
  @SideOnly(Side.CLIENT)
  public static void registerRenderers() {
    ClientUtil.registerRenderer(itemBucketNutrientDistillation, itemBucketNutrientDistillation.getItemName());
    ClientUtil.registerRenderer(itemBucketHootch, itemBucketHootch.getItemName());
    ClientUtil.registerRenderer(itemBucketRocketFuel, itemBucketRocketFuel.getItemName());
    ClientUtil.registerRenderer(itemBucketFireWater, itemBucketFireWater.getItemName());
    if(itemBucketXpJuice != null) {
      ClientUtil.registerRenderer(itemBucketXpJuice, itemBucketXpJuice.getItemName());
    }    
  }
  
}