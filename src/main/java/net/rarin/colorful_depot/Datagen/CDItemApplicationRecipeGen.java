package net.rarin.colorful_depot.Datagen;

import com.ninni.dye_depot.registry.DDDyes;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.api.data.recipe.ItemApplicationRecipeGen;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import net.neoforged.neoforge.common.conditions.NotCondition;
import net.rarin.colorful_depot.Colorful_Depot;
import net.rarin.colorful_depot.compat.Mods;
import net.rarin.colorfulpipes.CCPBlocks;
import net.rarin.colorfulpipes.CCPPaletteBlocks;

import java.util.EnumMap;
import java.util.concurrent.CompletableFuture;

public class CDItemApplicationRecipeGen extends ItemApplicationRecipeGen {

	final EnumMap<DyeColor, GeneratedRecipe> COLORFUL_FLUID_PIPES = new EnumMap<>(DyeColor.class);
	final EnumMap<DyeColor, GeneratedRecipe> COLORFUL_SMART_FLUID_PIPES = new EnumMap<>(DyeColor.class);
	final EnumMap<DyeColor, GeneratedRecipe> COLORFUL_PUMPS = new EnumMap<>(DyeColor.class);
	final EnumMap<DyeColor, GeneratedRecipe> COLORFUL_FLUID_VALVES = new EnumMap<>(DyeColor.class);
	final EnumMap<DyeColor, GeneratedRecipe> COLORFUL_FLUID_TANKS = new EnumMap<>(DyeColor.class);
	final EnumMap<DyeColor, GeneratedRecipe> COLORFUL_SPOUTS = new EnumMap<>(DyeColor.class);
	final EnumMap<DyeColor, GeneratedRecipe> COLORFUL_DRAINS = new EnumMap<>(DyeColor.class);
	final EnumMap<DyeColor, GeneratedRecipe> COLORFUL_FLUID_INTERFACES = new EnumMap<>(DyeColor.class);
	final EnumMap<DyeColor, GeneratedRecipe> COLORFUL_HOSE_PULLEY = new EnumMap<>(DyeColor.class);
	final EnumMap<DyeColor, GeneratedRecipe> COLORFUL_EXPERIENCE_HATCHES = new EnumMap<>(DyeColor.class);
	final EnumMap<DyeColor, GeneratedRecipe> COLORFUL_COPPER_CASING = new EnumMap<>(DyeColor.class);
	final EnumMap<DyeColor, GeneratedRecipe> COLORFUL_COPPER_GLASS_CASING = new EnumMap<>(DyeColor.class);
	final EnumMap<DyeColor, GeneratedRecipe> COLORFUL_COPPER_TINTED_GLASS_CASING = new EnumMap<>(DyeColor.class);
	final EnumMap<DyeColor, GeneratedRecipe> COLORFUL_COPPER_SCAFFOLD = new EnumMap<>(DyeColor.class);
	final EnumMap<DyeColor, GeneratedRecipe> COLORFUL_FLUID_VESSELS = new EnumMap<>(DyeColor.class);

	{
		for (DDDyes color : DDDyes.values()) {
//			COLORFUL_FLUID_PIPES.put(color.get(), create(color.get().getName() + "_fluid_pipe",
//					b -> b.require(AllBlocks.FLUID_PIPE.asItem())
//							.require(color.get().getTag())
//							.output(CCPBlocks.COLORFUL_FLUID_PIPES.get(color.get()))));

//			COLORFUL_SMART_FLUID_PIPES.put(color.get(), create(color.get().getName() + "_smart_fluid_pipe",
//					b -> b.require(AllBlocks.SMART_FLUID_PIPE.asItem())
//							.require(color.get().getTag())
//							.output(CCPBlocks.COLORFUL_SMART_FLUID_PIPES.get(color.get()))));

//			COLORFUL_PUMPS.put(color.get(), create(color.get().getName() + "_mechanical_pump",
//					b -> b.require(AllBlocks.MECHANICAL_PUMP.asItem())
//							.require(color.get().getTag())
//							.output(CCPBlocks.COLORFUL_PUMPS.get(color.get()))));
//
//			COLORFUL_FLUID_VALVES.put(color.get(), create(color.get().getName() + "_fluid_valve",
//					b -> b.require(AllBlocks.FLUID_VALVE.asItem())
//							.require(color.get().getTag())
//							.output(CCPBlocks.COLORFUL_FLUID_VALVES.get(color.get()))));

			COLORFUL_FLUID_TANKS.put(color.get(), create(color.get().getName() + "_fluid_tank",
					b -> b.require(AllBlocks.FLUID_TANK)
							.require(color.get().getTag())
							.output(CCPBlocks.COLORFUL_FLUID_TANKS.get(color.get()))
							.withCondition(new NotCondition(new ModLoadedCondition(Mods.BITS_N_BOBS.id())))));

//			COLORFUL_FLUID_VESSELS.put(color.get(), create(color.get().getName() + "_fluid_vessel",
//					b -> b.require(com.hlysine.create_connected.CCBlocks.FLUID_VESSEL)
//							.require(color.get().getTag())
//							.output(CCBlocks.COLORFUL_FLUID_VESSELS.get(color.get()))
//							.withCondition(new ModLoadedCondition(Mods.CREATE_CONNECTED.id()))));

			COLORFUL_SPOUTS.put(color.get(), create(color.get().getName() + "_spout",
					b -> b.require(AllBlocks.SPOUT.asItem())
							.require(color.get().getTag())
							.output(CCPBlocks.COLORFUL_SPOUTS.get(color.get()))));

			COLORFUL_DRAINS.put(color.get(), create(color.get().getName() + "_item_drain",
					b -> b.require(AllBlocks.ITEM_DRAIN.asItem())
							.require(color.get().getTag())
							.output(CCPBlocks.COLORFUL_DRAINS.get(color.get()))));

//			COLORFUL_FLUID_INTERFACES.put(color.get(), create(color.get().getName() + "_portable_fluid_interface",
//					b -> b.require(AllBlocks.PORTABLE_FLUID_INTERFACE.asItem())
//							.require(color.get().getTag())
//							.output(CCPBlocks.COLORFUL_FLUID_INTERFACES.get(color))));

//			COLORFUL_HOSE_PULLEY.put(color, create(color.getName() + "_hose_pulley",
//					b -> b.require(AllBlocks.HOSE_PULLEY.asItem())
//							.require(color.getTag())
//							.output(CCPBlocks.COLORFUL_HOSE_PULLEYS.get(color))));

//			COLORFUL_STEAM_WHISTLES.put(color, create(color.getName() + "_steam_whistle",
//					b -> b.require(AllBlocks.STEAM_WHISTLE.asItem())
//							.require(color.getTag())
//							.output(CCPPaletteBlocks.COLORFUL_STEAM_WHISTLES.get(color))));

			COLORFUL_COPPER_CASING.put(color.get(), create(color.getName() + "_copper_casing",
					b -> b.require(AllBlocks.COPPER_CASING.asItem())
							.require(color.get().getTag())
							.output(CCPPaletteBlocks.COLORFUL_COPPER_CASING.get(color.get()))));

			COLORFUL_COPPER_GLASS_CASING.put(color.get(), create(color.getName() + "_copper_glass_casing",
					b -> b.require(CCPPaletteBlocks.COLORFUL_COPPER_CASING.get(color.get()))
							.require(Tags.Items.GLASS_BLOCKS_COLORLESS)
							.output(CCPPaletteBlocks.COLORFUL_COPPER_GLASS_CASING.get(color.get()))));

			COLORFUL_COPPER_GLASS_CASING.put(color.get(), create(color.getName() + "_copper_glass_casing_other",
					b -> b.require(CCPPaletteBlocks.COPPER_GLASS_CASING.asItem())
							.require(color.get().getTag())
							.output(CCPPaletteBlocks.COLORFUL_COPPER_GLASS_CASING.get(color.get()))));

			COLORFUL_COPPER_GLASS_CASING.put(color.get(), create(color.getName() + "_copper_tinted_glass_casing",
					b -> b.require(CCPPaletteBlocks.COLORFUL_COPPER_CASING.get(color.get()))
							.require(Items.TINTED_GLASS)
							.output(CCPPaletteBlocks.COLORFUL_COPPER_TINTED_GLASS_CASING.get(color.get()))));

			COLORFUL_COPPER_TINTED_GLASS_CASING.put(color.get(), create(color.getName() + "_copper_tinted_glass_casing_other",
					b -> b.require(CCPPaletteBlocks.COPPER_TINTED_GLASS_CASING.asItem())
							.require(color.get().getTag())
							.output(CCPPaletteBlocks.COLORFUL_COPPER_TINTED_GLASS_CASING.get(color.get()))));

//			COLORFUL_COPPER_ENCASED_SHAFT.put(color, create(color.getName() + "_copper_encased_shaft",
//					b -> b.require(CCPBlocks.COPPER_ENCASED_SHAFT.get())
//							.require(color.getTag())
//							.output(CCPBlocks.COLORFUL_COPPER_ENCASED_SHAFT.get(color))));

			COLORFUL_COPPER_SCAFFOLD.put(color.get(), create(color.getName() + "_copper_scaffolding",
					b -> b.require(/*ColorfulItemTags.COPPER_SCAFFOLDS.tag*/AllBlocks.COPPER_SCAFFOLD.asItem())
							.require(color.get().getTag())
							.output(CCPPaletteBlocks.COLORFUL_COPPER_SCAFFOLD.get(color.get()))));

//			COLORFUL_COPPER_LADDER.put(color, create(color.getName() + "_copper_ladder",
//					b -> b.require(ColorfulItemTags.COPPER_LADDERS.tag)
//							.require(color.getTag())
//							.output(CCPBlocks.COLORFUL_COPPER_LADDER.get(color))));

//			COLORFUL_EXPERIENCE_HATCHES.put(color, create(color.getName() + "_experience_hatch",
//					b -> b.require(CDPBlocks.COLORFUL_FLUID_HATCHES.get(color))
//							.require(AllBlocks.EXPERIENCE_BLOCK)
//							.output(CEIBlocks.COLORFUL_EXPERIENCE_HATCHES.get(color))
//							.withCondition(new ModLoadedCondition(Mods.CREATE_ENCHANTMENT_INDUSTRY.id()))));
		}
	}

	public CDItemApplicationRecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
		super(output, registries, Colorful_Depot.ID);
	}
}
