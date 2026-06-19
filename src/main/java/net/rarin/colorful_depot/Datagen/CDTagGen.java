package net.rarin.colorful_depot.Datagen;

import com.ninni.dye_depot.registry.DDDyes;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllTags.AllBlockTags;
import com.simibubi.create.AllTags.AllItemTags;
import com.simibubi.create.foundation.data.TagGen;
import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.providers.RegistrateTagsProvider;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.rarin.colorful_depot.Colorful_Depot;
import net.rarin.colorfulpipes.CCPBlocks;
import net.rarin.colorfulpipes.CCPPaletteBlocks;
import net.rarin.colorfulpipes.CCPTags;
import net.rarin.colorfulpipes.CCPTags.ColorfulItemTags;
import net.rarin.colorfulpipes.compat.CreateDragonsPlus.CDPBlocks;
import net.rarin.colorfulpipes.compat.CreateEnchantmentIndustry.CEIBlocks;
import net.rarin.colorfulpipes.compat.Create_Connected.CCBlocks;

public class CDTagGen {
	public static void addGenerators() {
		Colorful_Depot.registrate().addDataGenerator(ProviderType.BLOCK_TAGS, CDTagGen::genBlockTags);
		Colorful_Depot.registrate().addDataGenerator(ProviderType.ITEM_TAGS, CDTagGen::genItemTags);
	}

	private static void genBlockTags(RegistrateTagsProvider<Block> provIn) {
		TagGen.CreateTagsProvider<Block> prov = new TagGen.CreateTagsProvider<>(provIn, Block::builtInRegistryHolder);

		prov.tag(CCPTags.ColorfulBlockTags.LIGHT.tag)
				.addOptionalTag(CCPTags.ColorfulBlockTags.COLORFUL_FLUID_HATCHES.tag);

		prov.tag(CCPTags.ColorfulBlockTags.SUPER_LIGHT.tag)
				.addOptionalTag(CCPTags.ColorfulBlockTags.COLORFUL_COPPER_LADDERS.tag)
				.addOptionalTag(CCPTags.ColorfulBlockTags.COLORFUL_COPPER_DOORS.tag)
				.addOptionalTag(CCPTags.ColorfulBlockTags.COLORFUL_COPPER_BARS.tag);

		prov.tag(CCPTags.ColorfulBlockTags.QUARTER_VOLUMES.tag)
				.addOptionalTag(CCPTags.ColorfulBlockTags.COLORFUL_COPPER_LADDERS.tag)
				.addOptionalTag(CCPTags.ColorfulBlockTags.COLORFUL_COPPER_DOORS.tag)
				.addOptionalTag(CCPTags.ColorfulBlockTags.COLORFUL_COPPER_BARS.tag);

		for (DyeColor color : DyeColor.values()) {

			prov.tag(AllBlockTags.CASING.tag)
					.add(CCPPaletteBlocks.COLORFUL_COPPER_CASING.get(color).get())
					.add(CCPPaletteBlocks.COLORFUL_COPPER_GLASS_CASING.get(color).get())
					.add(CCPPaletteBlocks.COLORFUL_COPPER_TINTED_GLASS_CASING.get(color).get());

			prov.tag(AllBlockTags.FAN_TRANSPARENT.tag)
							.add(CCPPaletteBlocks.COLORFUL_COPPER_BARS.get(color).get());

			prov.tag(AllBlockTags.TABLE_CLOTHS.tag)
							.add(CCPPaletteBlocks.COLORFUL_TABLE_CLOTHS.get(color).get());

			prov.tag(AllBlockTags.WRENCH_PICKUP.tag)
					.add(CCPPaletteBlocks.COLORFUL_COPPER_BARS.get(color).get());
		}
	}

	private static void genItemTags(RegistrateTagsProvider<Item> provIn) {
		TagGen.CreateTagsProvider<Item> prov = new TagGen.CreateTagsProvider<>(provIn, Item::builtInRegistryHolder);

		for (DDDyes color : DDDyes.values()) {

			TagKey<Item> dyed = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", "dyed/" + color.getSerializedName()));

			prov.tag(dyed)
					.add(CCPBlocks.COLORFUL_FLUID_PIPES.get(color.get()).asItem(),
							CCPBlocks.COLORFUL_SMART_FLUID_PIPES.get(color.get()).asItem(),
							CCPBlocks.COLORFUL_PUMPS.get(color.get()).asItem(),
							CCPBlocks.COLORFUL_FLUID_VALVES.get(color.get()).asItem(),
							CCPBlocks.COLORFUL_FLUID_TANKS.get(color.get()).asItem(),
							CCPBlocks.COLORFUL_SPOUTS.get(color.get()).asItem(),
							CCPBlocks.COLORFUL_DRAINS.get(color.get()).asItem(),
							CCPBlocks.COLORFUL_FLUID_INTERFACES.get(color.get()).asItem(),
							CCPBlocks.COLORFUL_HOSE_PULLEYS.get(color.get()).asItem(),
							CCPPaletteBlocks.COLORFUL_STEAM_WHISTLES.get(color.get()).asItem(),
							CCPPaletteBlocks.COLORFUL_TABLE_CLOTHS.get(color.get()).asItem(),
							CCPPaletteBlocks.COLORFUL_COPPER_CASING.get(color.get()).asItem(),
							CCPPaletteBlocks.COLORFUL_COPPER_GLASS_CASING.get(color.get()).asItem(),
							CCPPaletteBlocks.COLORFUL_COPPER_TINTED_GLASS_CASING.get(color.get()).asItem(),
							CCPPaletteBlocks.COLORFUL_COPPER_SCAFFOLD.get(color.get()).asItem(),
							CCPPaletteBlocks.COLORFUL_COPPER_LADDER.get(color.get()).asItem(),
							CCPPaletteBlocks.COLORFUL_COPPER_DOOR.get(color.get()).asItem(),
							CCPPaletteBlocks.COLORFUL_COPPER_BARS.get(color.get()).asItem());
//							CCBlocks.COLORFUL_FLUID_VESSELS.get(color.get()).asItem(),
//							CDPBlocks.COLORFUL_FLUID_HATCHES.get(color.get()).asItem(),
//							CEIBlocks.COLORFUL_EXPERIENCE_HATCHES.get(color.get()).asItem(),
//							CEIBlocks.COLORFUL_EXPERIENCE_LANTERNS.get(color.get()).asItem(),
//							CEIBlocks.COLORFUL_PRINTERS.get(color.get()).asItem());
		}

		for (DyeColor color : DyeColor.values()) {

			prov.tag(ColorfulItemTags.FLUID_PIPES.tag)
					.add(AllBlocks.FLUID_PIPE.get().asItem())
					.add(CCPBlocks.COLORFUL_FLUID_PIPES.get(color).asItem());

			prov.tag(ColorfulItemTags.COLORFUL_PIPES.tag)
					.add(CCPBlocks.COLORFUL_FLUID_PIPES.get(color).asItem());

			prov.tag(ColorfulItemTags.SMART_FLUID_PIPES.tag)
					.add(AllBlocks.SMART_FLUID_PIPE.get().asItem())
					.add(CCPBlocks.COLORFUL_SMART_FLUID_PIPES.get(color).asItem());

			prov.tag(ColorfulItemTags.COLORFUL_SMART_PIPES.tag)
					.add(CCPBlocks.COLORFUL_SMART_FLUID_PIPES.get(color).asItem());

			prov.tag(ColorfulItemTags.FLUID_VALVES.tag)
					.add(AllBlocks.FLUID_VALVE.get().asItem())
					.add(CCPBlocks.COLORFUL_FLUID_VALVES.get(color).asItem());

			prov.tag(ColorfulItemTags.COLORFUL_FLUID_VALVES.tag)
					.add(CCPBlocks.COLORFUL_FLUID_VALVES.get(color).asItem());

			prov.tag(ColorfulItemTags.MECHANICAL_PUMPS.tag)
					.add(AllBlocks.MECHANICAL_PUMP.get().asItem())
					.add(CCPBlocks.COLORFUL_PUMPS.get(color).asItem());

			prov.tag(ColorfulItemTags.COLORFUL_PUMPS.tag)
					.add(CCPBlocks.COLORFUL_PUMPS.get(color).asItem());

			prov.tag(ColorfulItemTags.FLUID_TANKS.tag)
					.add(AllBlocks.FLUID_TANK.get().asItem())
					.add(CCPBlocks.COLORFUL_FLUID_TANKS.get(color).asItem());

			prov.tag(ColorfulItemTags.COLORFUL_FLUID_TANKS.tag)
					.add(CCPBlocks.COLORFUL_FLUID_TANKS.get(color).asItem());

			prov.tag(ColorfulItemTags.SPOUTS.tag)
					.add(AllBlocks.SPOUT.get().asItem())
					.add(CCPBlocks.COLORFUL_SPOUTS.get(color).asItem());

			prov.tag(ColorfulItemTags.COLORFUL_SPOUTS.tag)
					.add(CCPBlocks.COLORFUL_SPOUTS.get(color).asItem());

			prov.tag(ColorfulItemTags.ITEM_DRAINS.tag)
					.add(AllBlocks.ITEM_DRAIN.get().asItem())
					.add(CCPBlocks.COLORFUL_DRAINS.get(color).asItem());

			prov.tag(ColorfulItemTags.COLORFUL_DRAINS.tag)
					.add(CCPBlocks.COLORFUL_DRAINS.get(color).asItem());

			prov.tag(ColorfulItemTags.PORTABLE_FLUID_INTERFACES.tag)
					.add(AllBlocks.PORTABLE_FLUID_INTERFACE.get().asItem())
					.add(CCPBlocks.COLORFUL_FLUID_INTERFACES.get(color).asItem());

			prov.tag(ColorfulItemTags.COLORFUL_PORTABLE_FLUID_INTERFACES.tag)
					.add(CCPBlocks.COLORFUL_FLUID_INTERFACES.get(color).asItem());

			prov.tag(ColorfulItemTags.HOSE_PULLEYS.tag)
					.add(AllBlocks.HOSE_PULLEY.get().asItem())
					.add(CCPBlocks.COLORFUL_HOSE_PULLEYS.get(color).asItem());

			prov.tag(ColorfulItemTags.COLORFUL_HOSE_PULLEYS.tag)
					.add(CCPBlocks.COLORFUL_HOSE_PULLEYS.get(color).asItem());

			prov.tag(ColorfulItemTags.STEAM_WHISTLES.tag)
					.add(AllBlocks.STEAM_WHISTLE.get().asItem())
					.add(CCPPaletteBlocks.COLORFUL_STEAM_WHISTLES.get(color).asItem());

			prov.tag(ColorfulItemTags.COLORFUL_STEAM_WHISTLES.tag)
					.add(CCPPaletteBlocks.COLORFUL_STEAM_WHISTLES.get(color).asItem());

			prov.tag(ColorfulItemTags.COPPER_TABLE_CLOTHS.tag)
					.add(AllBlocks.COPPER_TABLE_CLOTH.get().asItem())
					.add(CCPPaletteBlocks.COLORFUL_TABLE_CLOTHS.get(color).asItem());

			prov.tag(ColorfulItemTags.COLORFUL_TABLE_CLOTHS.tag)
					.add(CCPPaletteBlocks.COLORFUL_TABLE_CLOTHS.get(color).asItem());

			prov.tag(AllItemTags.CASING.tag)
					.add(CCPPaletteBlocks.COLORFUL_COPPER_CASING.get(color).asItem())
					.add(CCPPaletteBlocks.COLORFUL_COPPER_GLASS_CASING.get(color).asItem())
					.add(CCPPaletteBlocks.COLORFUL_COPPER_TINTED_GLASS_CASING.get(color).asItem());

			prov.tag(ColorfulItemTags.COPPER_CASINGS.tag)
					.add(AllBlocks.COPPER_CASING.asItem())
					.add(CCPPaletteBlocks.COLORFUL_COPPER_CASING.get(color).asItem());

			prov.tag(ColorfulItemTags.COLORFUL_COPPER_CASINGS.tag)
					.add(CCPPaletteBlocks.COLORFUL_COPPER_CASING.get(color).asItem());

			prov.tag(ColorfulItemTags.COPPER_GLASS_CASINGS.tag)
					.add(CCPPaletteBlocks.COPPER_GLASS_CASING.asItem())
					.add(CCPPaletteBlocks.COLORFUL_COPPER_GLASS_CASING.get(color).asItem());

			prov.tag(ColorfulItemTags.COLORFUL_COPPER_GLASS_CASINGS.tag)
					.add(CCPPaletteBlocks.COLORFUL_COPPER_GLASS_CASING.get(color).asItem());

			prov.tag(ColorfulItemTags.COPPER_TINTED_GLASS_CASINGS.tag)
					.add(CCPPaletteBlocks.COPPER_TINTED_GLASS_CASING.asItem())
					.add(CCPPaletteBlocks.COLORFUL_COPPER_TINTED_GLASS_CASING.get(color).asItem());

			prov.tag(ColorfulItemTags.COLORFUL_COPPER_TINTED_GLASS_CASINGS.tag)
					.add(CCPPaletteBlocks.COLORFUL_COPPER_TINTED_GLASS_CASING.get(color).asItem());

			prov.tag(ColorfulItemTags.COPPER_SCAFFOLDS.tag)
					.add(AllBlocks.COPPER_SCAFFOLD.get().asItem())
					.add(CCPPaletteBlocks.COLORFUL_COPPER_SCAFFOLD.get(color).asItem());

			prov.tag(ColorfulItemTags.COLORFUL_COPPER_SCAFFOLDS.tag)
					.add(CCPPaletteBlocks.COLORFUL_COPPER_SCAFFOLD.get(color).asItem());

			prov.tag(ColorfulItemTags.COPPER_LADDERS.tag)
					.add(AllBlocks.COPPER_LADDER.get().asItem())
					.add(CCPPaletteBlocks.COLORFUL_COPPER_LADDER.get(color).asItem());

			prov.tag(ColorfulItemTags.COLORFUL_COPPER_LADDERS.tag)
					.add(CCPPaletteBlocks.COLORFUL_COPPER_LADDER.get(color).asItem());

			prov.tag(ColorfulItemTags.COPPER_BARS.tag)
					.add(AllBlocks.COPPER_BARS.get().asItem())
					.add(CCPPaletteBlocks.COLORFUL_COPPER_BARS.get(color).asItem());

			prov.tag(ColorfulItemTags.COLORFUL_COPPER_BARS.tag)
					.add(CCPPaletteBlocks.COLORFUL_COPPER_BARS.get(color).asItem());

			prov.tag(ColorfulItemTags.COPPER_DOORS.tag)
					.add(AllBlocks.COPPER_DOOR.get().asItem())
					.add(CCPPaletteBlocks.COLORFUL_COPPER_DOOR.get(color).asItem());

			prov.tag(ColorfulItemTags.COLORFUL_COPPER_DOORS.tag)
					.add(CCPPaletteBlocks.COLORFUL_COPPER_DOOR.get(color).asItem());

			prov.tag(AllItemTags.CONTRAPTION_CONTROLLED.tag)
					.add(CCPBlocks.COLORFUL_FLUID_INTERFACES.get(color).asItem())
					.add(CCPPaletteBlocks.COLORFUL_COPPER_DOOR.get(color).asItem());

			prov.tag(AllItemTags.TABLE_CLOTHS.tag)
					.add(CCPPaletteBlocks.COLORFUL_TABLE_CLOTHS.get(color).asItem());

			prov.tag(ColorfulItemTags.STEAM_ENGINES.tag)
					.add(AllBlocks.STEAM_ENGINE.get().asItem())
					.add(CCPBlocks.COLORFUL_STEAM_ENGINES.get(color).asItem());

			prov.tag(ColorfulItemTags.COLORFUL_STEAM_ENGINES.tag)
					.add(CCPBlocks.COLORFUL_STEAM_ENGINES.get(color).asItem());

			prov.tag(ColorfulItemTags.FLUID_VESSELS.tag)
					.add(com.hlysine.create_connected.registries.CCBlocks.FLUID_VESSEL.get().asItem())
					.add(CCBlocks.COLORFUL_FLUID_VESSELS.get(color).asItem());

			prov.tag(ColorfulItemTags.COLORFUL_FLUID_VESSELS.tag)
					.add(CCBlocks.COLORFUL_FLUID_VESSELS.get(color).asItem());

			prov.tag(ColorfulItemTags.FLUID_HATCHES.tag)
					.add(plus.dragons.createdragonsplus.common.registry.CDPBlocks.FLUID_HATCH.get().asItem())
					.add(CDPBlocks.COLORFUL_FLUID_HATCHES.get(color).asItem());

			prov.tag(ColorfulItemTags.COLORFUL_FLUID_HATCHES.tag)
					.add(CDPBlocks.COLORFUL_FLUID_HATCHES.get(color).asItem());

			prov.tag(ColorfulItemTags.EXPERIENCE_HATCHES.tag)
					.add(plus.dragons.createenchantmentindustry.common.registry.CEIBlocks.EXPERIENCE_HATCH.get().asItem())
					.add(CEIBlocks.COLORFUL_EXPERIENCE_HATCHES.get(color).asItem());

			prov.tag(ColorfulItemTags.COLORFUL_EXPERIENCE_HATCHES.tag)
					.add(CEIBlocks.COLORFUL_EXPERIENCE_HATCHES.get(color).asItem());

			prov.tag(ColorfulItemTags.EXPERIENCE_LANTERNS.tag)
					.add(plus.dragons.createenchantmentindustry.common.registry.CEIBlocks.EXPERIENCE_LANTERN.get().asItem())
					.add(CEIBlocks.COLORFUL_EXPERIENCE_LANTERNS.get(color).asItem());

			prov.tag(ColorfulItemTags.COLORFUL_EXPERIENCE_LANTERNS.tag)
					.add(CEIBlocks.COLORFUL_EXPERIENCE_LANTERNS.get(color).asItem());

			prov.tag(ColorfulItemTags.PRINTERS.tag)
					.add(plus.dragons.createenchantmentindustry.common.registry.CEIBlocks.PRINTER.get().asItem())
					.add(CEIBlocks.COLORFUL_PRINTERS.get(color).asItem());

			prov.tag(ColorfulItemTags.COLORFUL_PRINTERS.tag)
					.add(CEIBlocks.COLORFUL_PRINTERS.get(color).asItem());

		}
	}
}
