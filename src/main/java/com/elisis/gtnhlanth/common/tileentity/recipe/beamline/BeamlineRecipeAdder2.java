package com.elisis.gtnhlanth.common.tileentity.recipe.beamline;

import java.util.Arrays;

import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import com.elisis.gtnhlanth.common.beamline.Particle;

import gregtech.api.gui.modularui.GT_UITextures;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.recipe.RecipeMapBackend;
import gregtech.api.recipe.RecipeMapBuilder;
import gregtech.api.util.GT_Utility;

public class BeamlineRecipeAdder2 {

    public static final BeamlineRecipeAdder2 instance = new BeamlineRecipeAdder2();

    public final RecipeMap<RecipeMapBackend> SourceChamberRecipes = RecipeMapBuilder.of("gtnhlanth.recipe.sc")
        .minInputs(0, 0)
        .maxIO(1, 2, 0, 0)
        .amperage(1)
        .frontend(SourceChamberFrontend::new)
        .progressBar(GT_UITextures.PROGRESSBAR_ASSEMBLY_LINE_1)
        .neiSpecialInfoFormatter((recipeInfo) -> {

            RecipeSC recipe = (RecipeSC) recipeInfo.recipe;

            float focus = recipe.focus;
            float maxEnergy = recipe.maxEnergy;

            int amount = recipe.rate;

            Particle particle = Particle.getParticleFromId(recipe.particleId);

            return Arrays.asList(

                // StatCollector.translateToLocal("beamline.particle") + ": " + particle.getLocalisedName(),

                StatCollector.translateToLocal("beamline.energy") + ": <="
                    + GT_Utility.formatNumbers(Math.min(maxEnergy, particle.maxSourceEnergy()))
                    + " keV",

                StatCollector.translateToLocal("beamline.focus") + ": " + GT_Utility.formatNumbers(focus),

                StatCollector.translateToLocal("beamline.rate") + ": " + GT_Utility.formatNumbers(amount)

        );
        })
        // .slotOverlays(null)

        .build();

    public final RecipeMap<RecipeMapBackend> TargetChamberRecipes = RecipeMapBuilder.of("gtnhlanth.recipe.tc")
        .minInputs(0, 0)
        .maxIO(3, 4, 0, 0)
        .frontend(TargetChamberFrontend::new)
        .neiSpecialInfoFormatter(((recipeInfo) -> {

            RecipeTC recipe = (RecipeTC) recipeInfo.recipe;

            float minEnergy = recipe.minEnergy;
            float maxEnergy = recipe.maxEnergy;

            float minFocus = recipe.minFocus;

            float amount = recipe.amount;

            Particle particle = Particle.getParticleFromId(recipe.particleId);

            return Arrays.asList(

                // StatCollector.translateToLocal("beamline.particle") + ": " + particle.getLocalisedName(),

                StatCollector.translateToLocal("beamline.energy") + ": "
                    + GT_Utility.formatNumbers(minEnergy * 1000)
                    + "-"
                    + GT_Utility.formatNumbers(maxEnergy * 1000)
                    + " eV", // Note the eV unit

                StatCollector.translateToLocal("beamline.focus") + ": >=" + GT_Utility.formatNumbers(minFocus),

                StatCollector.translateToLocal("beamline.amount") + ": " + GT_Utility.formatNumbers(amount)

        );
        }))
        // .slotOverlays(null)
        .progressBar(GT_UITextures.PROGRESSBAR_ASSEMBLY_LINE_1)
        .progressBarPos(108, 22)
        .neiTransferRect(100, 22, 28, 18)
        .build();

    /***
     *
     * @param itemInputs  - duh
     * @param itemOutputs - duh
     * @param particleId  - The ID of the {@link com.elisis.gtnhlanth.common.beamline.Particle} generated by the recipe.
     *                    It is recommended to use Particle#ordinal()
     * @param rate        - The rate/amount of particles generated
     * @param maxEnergy   - The maximum energy particles generated by this recipe can possess (keV). Set this value >=
     *                    max particle energy to limit it to the latter
     * @param focus       - Focus of the particle generated
     * @param energyRatio - Set high for little-to-no EUt energy scaling, low for the opposite
     * @param minEUt      - Minimum EUt required for the recipe. ! May not output if input energy is equal to minimum !
     */
    public boolean addSourceChamberRecipe(ItemStack[] itemInputs, ItemStack[] itemOutputs, int particleId, int rate,
        float maxEnergy, float focus, float energyRatio, int minEUt) {

        return (SourceChamberRecipes.addRecipe(
            new RecipeSC(
                false,
                itemInputs,
                itemOutputs,
                null,
                new int[] {},
                null,
                null,
                20,
                minEUt,
                particleId,
                rate,
                maxEnergy,
                focus,
                energyRatio))
            != null);
    }

    /***
     *
     * @param itemInput   - The item to be used as a target. Should have durability
     * @param itemOutput  - duh
     * @param particleId  - The ID of the {@link com.elisis.gtnhlanth.common.beamline.Particle} used by the recipe. It
     *                    is recommended to use Particle#ordinal()
     * @param amount      - The total amount of particles required for the recipe to come to completion. The duration of
     *                    the recipe will be determined by this and the input particle rate.
     * @param minEnergy   - The minimum energy amount required by this recipe in keV (inclusive)
     * @param maxEnergy   - The maximum energy amount allowed by this recipe in keV (inclusive)
     * @param minFocus    - Minimum focus allowed by the recipe
     * @param energyRatio - Set high for little-to-no EUt energy scaling, low for the opposite
     * @param minEUt      - Minimum EUt required for the recipe to start
     */

    public boolean addTargetChamberRecipe(ItemStack itemInput, ItemStack itemOutput, ItemStack itemFocus,
        int particleId, int amount, float minEnergy, float maxEnergy, float minFocus, float energyRatio, int minEUt) {

        return (TargetChamberRecipes.addRecipe(
            new RecipeTC(
                false,
                itemInput,
                itemOutput,
                itemFocus,
                particleId,
                amount,
                minEnergy,
                maxEnergy,
                minFocus,
                energyRatio,
                minEUt),
            false,
            false,
            false) != null);

    }

}
