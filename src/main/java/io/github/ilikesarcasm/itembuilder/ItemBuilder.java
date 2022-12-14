package io.github.ilikesarcasm.itembuilder;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.kyori.adventure.text.Component;

public class ItemBuilder {

    private ItemStack item;
    private ItemMeta metadata;

    public ItemBuilder(Material material) {
        this.item = new ItemStack(material);
        this.metadata = this.item.getItemMeta();
    }

    public ItemBuilder setName(String name) {
        Component nameComponent = Component.text(name);
        this.metadata.displayName(nameComponent);
        return this;
    }

    public ItemBuilder setLore(String[] lore) {
        List<Component> loreComponent = this.metadata.lore();
        for (String line: lore) {
            loreComponent.add(Component.text(line));
        }
        this.metadata.lore(loreComponent);
        return this;
    }

    public ItemBuilder addLineToLore(String line) {
        List<Component> loreComponent = this.metadata.lore();
        loreComponent.add(Component.text(line));
        this.metadata.lore(loreComponent);
        return this;
    }

    public ItemStack build() {
        this.item.setItemMeta(this.metadata);
        return this.item;
    }

}
