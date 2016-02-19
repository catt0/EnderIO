package crazypants.enderio.item.darksteel.upgrade;

import crazypants.enderio.config.Config;
import crazypants.enderio.item.darksteel.DarkSteelItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class NaturalistEyeUpgrade extends AbstractUpgrade {

  private static String UPGRADE_NAME = "naturalistEye";

  public static final NaturalistEyeUpgrade INSTANCE = new NaturalistEyeUpgrade();

  public static ItemStack getNaturalistEye() {
    Item i = GameRegistry.findItem("Forestry", "naturalistHelmet");
    if(i != null) {
      return new ItemStack(i);
    }
    return null;
  }

  public static NaturalistEyeUpgrade loadFromItem(ItemStack stack) {
    if(stack == null) {
      return null;
    }
    if(stack.getTagCompound() == null) {
      return null;
    }
    if(!stack.getTagCompound().hasKey(KEY_UPGRADE_PREFIX + UPGRADE_NAME)) {
      return null;
    }
    return new NaturalistEyeUpgrade((NBTTagCompound) stack.getTagCompound().getTag(KEY_UPGRADE_PREFIX + UPGRADE_NAME));
  }

  public static boolean isUpgradeEquipped(EntityPlayer player) {
    ItemStack helmet = player.getEquipmentInSlot(4);
    return NaturalistEyeUpgrade.loadFromItem(helmet) != null;
  }

  public NaturalistEyeUpgrade(NBTTagCompound tag) {
    super(UPGRADE_NAME, tag);
  }

  public NaturalistEyeUpgrade() {
    super(UPGRADE_NAME, "enderio.darksteel.upgrade.naturalistEye",getNaturalistEye(), Config.darkSteelApiaristArmorCost);
  }

  @Override
  public boolean canAddToItem(ItemStack stack) {
    if(stack == null || stack.getItem() != DarkSteelItems.itemDarkSteelHelmet || getUpgradeItem() == null) {
      return false;
    }
    NaturalistEyeUpgrade up = loadFromItem(stack);
    return up == null;
  }

  @Override
  public void writeUpgradeToNBT(NBTTagCompound upgradeRoot) {
  }

  @Override
  public ItemStack getUpgradeItem() {
    if(upgradeItem != null) {
      return upgradeItem;
    }
    upgradeItem = getNaturalistEye();
    return upgradeItem;
  }

  @Override
  public String getUpgradeItemName() {
    if(getUpgradeItem() == null) {
      return "Naturalist Helmet";
    }
    return super.getUpgradeItemName();
  }
}
