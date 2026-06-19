package net.rarin.colorful_depot;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.simibubi.create.foundation.utility.FilesHelper;
import com.tterrag.registrate.providers.ProviderType;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.rarin.colorful_depot.Datagen.CDRecipeProvider;
import net.rarin.colorful_depot.Datagen.CDStandardRecipeGen;
import net.rarin.colorful_depot.Datagen.CDTagGen;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ColorfulDepotDatagen {
	public static void gatherDataHighPriority(GatherDataEvent event) {
		if (event.getMods().contains(Colorful_Depot.ID))
			addExtraRegistrateData();
	}

	public static void gatherData(GatherDataEvent event) {
		if (!event.getMods().contains(Colorful_Depot.ID))
			return;

		DataGenerator generator = event.getGenerator();
		PackOutput output = generator.getPackOutput();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

		generator.addProvider(event.includeServer(), new CDStandardRecipeGen(output, lookupProvider));

		if (event.includeServer()) {
			CDRecipeProvider.registerAllProcessing(generator, output, lookupProvider);
		}

	}

	private static void addExtraRegistrateData() {
		CDTagGen.addGenerators();

		Colorful_Depot.registrate().addDataGenerator(ProviderType.LANG, provider -> {
			BiConsumer<String, String> langConsumer = provider::add;

			//provideDefaultLang("interface", langConsumer);
			//provideDefaultLang("tooltips", langConsumer);
		});
	}

	private static void provideDefaultLang(String fileName, BiConsumer<String, String> consumer) {
		String path = "assets/colorfulpipes/lang/" + fileName + ".json";
		JsonElement jsonElement = FilesHelper.loadJsonResource(path);
		if (jsonElement == null) {
			throw new IllegalStateException(String.format("Could not find default lang file: %s", path));
		}
		JsonObject jsonObject = jsonElement.getAsJsonObject();
		for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue().getAsString();
			consumer.accept(key, value);
		}
	}
}
