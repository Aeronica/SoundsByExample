package soundsbyexample.sbe01_basic_sound;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

/*
** User: Paul Boese aka Aeronica
** Date: Sep 11, 2016
**
** Based on MinecraftByExample by TheGreyGhost and others
** https://github.com/TheGreyGhost/MinecraftByExample
*/
public class ItemBasicSound extends Item
{

    public ItemBasicSound()
    {
        this.setMaxDamage(0);
        this.setHasSubtypes(false);
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTabs.MISC);
    }


    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
       if (worldIn.isRemote)
       {
           /**
            ** Client Side
            ** Only the player activating this item will hear a sound
            **/
           playerIn.playSound(StartupCommon.soundEventBasicSound, 1.0F, 1.0F);  
       }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn);
    }


    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
    {
        tooltip.add(TextFormatting.GOLD + I18n.format(this.getUnlocalizedName() + ".tooltip"));
    }

}