package llama.administration.tatakei.itemtutorial;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {
    public static void initialize() {
        // Item Group Maker
        ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModItems.EXAMPLE_ITEM); // Adds the Item to the Item Group
            itemGroup.add(ModItems.EXAMPLE_ITEM2); // Adds another Item to the Item Group
        });

        // Register the group.
        Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);
    }
    public static Item register(Item item, String id) {
        // Create the identifier for the item.
        Identifier itemID = Identifier.of(Howtomakeitem.MOD_ID, id);

        // Return the registered item!
        return Registry.register(Registries.ITEM, itemID, item);
    }

    public static final Item EXAMPLE_ITEM = register(new Item(new Item.Settings().maxCount(64)), "test_item");

    public static final Item EXAMPLE_ITEM2 = register(
            new Item(new Item.Settings().maxCount(64)),
            "test_item2"
    );
    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(Howtomakeitem.MOD_ID, "item_group"));
    public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.EXAMPLE_ITEM))
            .displayName(Text.translatable("itemGroup.howtomakeitem"))
            .build();
}