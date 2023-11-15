package gregtech.api.ModernMaterials;

import static gregtech.api.ModernMaterials.ModernMaterialUtilities.registerMaterial;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraftforge.client.IItemRenderer;

import org.jetbrains.annotations.NotNull;

import gregtech.api.ModernMaterials.Blocks.Registration.BlocksEnum;
import gregtech.api.ModernMaterials.Fluids.FluidEnum;
import gregtech.api.ModernMaterials.Fluids.ModernMaterialFluid;
import gregtech.api.ModernMaterials.Items.PartProperties.TextureType;
import gregtech.api.ModernMaterials.Items.PartsClasses.IEnumPart;
import gregtech.api.ModernMaterials.Items.PartsClasses.ItemsEnum;

@SuppressWarnings("unused")
public final class ModernMaterial {

    private final HashSet<IEnumPart> existingPartsForMaterial = new HashSet<>();
    private final HashSet<ModernMaterialFluid> existingFluids = new HashSet<>();
    private Color color;
    private int materialID;
    private String materialName;
    private long materialTier;
    private double materialTimeMultiplier = 1;
    private TextureType textureType;
    private Consumer<ModernMaterial> recipeGenerator;
    private IItemRenderer customItemRenderer;

    public ModernMaterial(final String materialName) {
        this.materialName = materialName;
    }

    public void setMaterialID(int aID) {
        materialID = aID;
    }

    public Color getColor() {
        return color;
    }

    public int getMaterialID() {
        return materialID;
    }

    public String getMaterialName() {
        return materialName;
    }

    public boolean doesPartExist(BlocksEnum blocksEnum) {
        return blocksEnum.getAssociatedMaterials()
            .contains(this);
    }

    public double getMaterialTimeMultiplier() {
        return materialTimeMultiplier;
    }

    public Set<ModernMaterialFluid> getAssociatedFluids() {
        return Collections.unmodifiableSet(existingFluids);
    }

    public long getMaterialTier() {
        return materialTier;
    }

    public TextureType getTextureType() {
        return textureType;
    }

    private ModernMaterial() {}

    public void registerRecipes(ModernMaterial material) {
        if (recipeGenerator == null) return;
        recipeGenerator.accept(material);
    }

    public IItemRenderer getCustomItemRenderer() {
        return customItemRenderer;
    }

    public boolean hasCustomTextures() {
        return textureType == TextureType.Custom;
    }

    public static class ModernMaterialBuilder {

        public static ModernMaterial materialToBuild;

        public ModernMaterialBuilder(String materialName) {
            materialToBuild = new ModernMaterial(materialName);
        }

        void build() {
            ModernMaterial builtMaterial = materialToBuild;
            materialToBuild = new ModernMaterial();

            registerMaterial(builtMaterial);
        }

        public ModernMaterialBuilder setColor(int red, int green, int blue) {
            materialToBuild.color = new Color(red, green, blue);
            return this;
        }

        public ModernMaterialBuilder setMaterialTimeMultiplier(double materialTimeMultiplier) {
            materialToBuild.materialTimeMultiplier = materialTimeMultiplier;
            return this;
        }

        public ModernMaterialBuilder addParts(IEnumPart... parts) {
            for (IEnumPart part : parts) {
                addPart(part);
            }

            return this;
        }

        public ModernMaterialBuilder addPart(IEnumPart part) {
            part.addAssociatedMaterial(materialToBuild);
            materialToBuild.existingPartsForMaterial.add(part);

            return this;
        }

        private final HashMap<BlocksEnum, TileEntitySpecialRenderer> TESRMap = new HashMap<>();

        public ModernMaterialBuilder addBlockTESR(BlocksEnum block, TileEntitySpecialRenderer TESR) {
            TESRMap.put(block, TESR);
            return this;
        }

        // This will override all existing parts settings and enable ALL possible parts and blocks. Be careful!
        public ModernMaterialBuilder addAllParts() {
            addParts(ItemsEnum.values());
            addParts(BlocksEnum.values());
            return this;
        }

        public ModernMaterialBuilder addFluid(FluidEnum fluidEnum, int temperature) {

            ModernMaterialFluid modernMaterialFluid = new ModernMaterialFluid(fluidEnum, materialToBuild);
            modernMaterialFluid.setTemperature(temperature);
            modernMaterialFluid.setGaseous(fluidEnum.isGas());
            modernMaterialFluid.setFluidEnum(fluidEnum);

            // Add fluid to list in material.
            materialToBuild.existingFluids.add(new ModernMaterialFluid(fluidEnum, materialToBuild));

            return this;
        }

        public ModernMaterialBuilder addCustomFluid(ModernMaterialFluid.Builder modernMaterialFluidBuilder, boolean useMaterialColouringForFluid) {

            ModernMaterialFluid modernMaterialFluid = modernMaterialFluidBuilder.setMaterial(materialToBuild).build();
            materialToBuild.existingFluids.add(modernMaterialFluid);

            if (!useMaterialColouringForFluid) {
                modernMaterialFluid.disableFluidColouring();
            }

            return this;
        }

        public ModernMaterialBuilder setMaterialTier(long tier) {
            materialToBuild.materialTier = tier;
            return this;
        }

        public ModernMaterialBuilder setTextureMode(@NotNull final TextureType textureType) {
            if (textureType == TextureType.Custom) TextureType.registerCustomMaterial(materialToBuild);
            materialToBuild.textureType = textureType;
            return this;
        }

        public ModernMaterialBuilder setRecipeGenerator(@NotNull final Consumer<ModernMaterial> recipeGenerator) {
            materialToBuild.recipeGenerator = recipeGenerator;
            return this;
        }

        public ModernMaterialBuilder setMaterialID(int materialID) {
            materialToBuild.materialID = materialID;
            return this;
        }

        public ModernMaterialBuilder setCustomBlockRenderer(@NotNull final BlocksEnum blocksEnum,
            @NotNull final IItemRenderer itemRenderer,
            @NotNull final TileEntitySpecialRenderer tileEntitySpecialRenderer) {
            blocksEnum.addSpecialBlockRenderAssociatedMaterial(materialToBuild);
            blocksEnum.setItemRenderer(materialToBuild.materialID, itemRenderer);
            blocksEnum.setBlockRenderer(materialToBuild.materialID, tileEntitySpecialRenderer);
            return this;
        }

        public ModernMaterialBuilder setCustomItemRenderer(IItemRenderer customItemRenderer) {
            materialToBuild.customItemRenderer = customItemRenderer;
            return this;
        }
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof ModernMaterial material) {
            return material.materialID == this.materialID;
        }

        return false;
    }

    @Override
    public String toString() {
        return materialName;
    }

}
