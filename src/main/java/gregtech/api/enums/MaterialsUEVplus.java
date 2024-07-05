package gregtech.api.enums;

import java.util.Collections;

public class MaterialsUEVplus {

    public static Materials DimensionallyTranscendentCrudeCatalyst = new Materials(
        748,
        TextureSet.SET_FLUID,
        1.0F,
        0,
        2,
        16,
        10,
        20,
        20,
        1,
        "DimensionallyTranscendentCrudeCatalyst",
        "Dimensionally Transcendent Crude Catalyst",
        0,
        0,
        25_000_000,
        1,
        false,
        true,
        1,
        1,
        1,
        Dyes.dyeCyan).setHasCorrespondingFluid(true);
    public static Materials DimensionallyTranscendentProsaicCatalyst = new Materials(
        747,
        TextureSet.SET_FLUID,
        1.0F,
        0,
        2,
        16,
        10,
        20,
        20,
        1,
        "DimensionallyTranscendentProsaicCatalyst",
        "Dimensionally Transcendent Prosaic Catalyst",
        0,
        0,
        50_000_000,
        1,
        false,
        true,
        1,
        1,
        1,
        Dyes.dyeGreen).setHasCorrespondingFluid(true);
    public static Materials DimensionallyTranscendentResplendentCatalyst = new Materials(
        746,
        TextureSet.SET_FLUID,
        1.0F,
        0,
        2,
        16,
        10,
        20,
        20,
        1,
        "DimensionallyTranscendentResplendentCatalyst",
        "Dimensionally Transcendent Resplendent Catalyst",
        0,
        0,
        75_000_000,
        1,
        false,
        true,
        1,
        1,
        1,
        Dyes.dyeLime).setHasCorrespondingFluid(true);
    public static Materials DimensionallyTranscendentExoticCatalyst = new Materials(
        745,
        TextureSet.SET_FLUID,
        1.0F,
        0,
        2,
        16,
        10,
        20,
        20,
        1,
        "DimensionallyTranscendentExoticCatalyst",
        "Dimensionally Transcendent Exotic Catalyst",
        0,
        0,
        100_000_000,
        1,
        false,
        true,
        1,
        1,
        1,
        Dyes.dyeMagenta).setHasCorrespondingFluid(true);
    public static Materials DimensionallyTranscendentStellarCatalyst = new Materials(
        130,
        TextureSet.SET_FLUID,
        1.0F,
        0,
        2,
        16,
        10,
        20,
        20,
        1,
        "DimensionallyTranscendentStellarCatalyst",
        "Dimensionally Transcendent Stellar Catalyst",
        0,
        0,
        100_000_000,
        1,
        false,
        true,
        1,
        1,
        1,
        Dyes.dyeOrange).setHasCorrespondingFluid(true);

    public static Materials ExcitedDTCC = new Materials(
        109,
        TextureSet.SET_FLUID,
        1.0F,
        0,
        2,
        16,
        10,
        20,
        20,
        1,
        "ExcitedDTCC",
        "Excited Dimensionally Transcendent Crude Catalyst",
        -1,
        -1,
        500000000,
        1,
        false,
        true,
        1,
        1,
        1,
        Dyes.dyeCyan);
    public static Materials ExcitedDTPC = new Materials(
        113,
        TextureSet.SET_FLUID,
        1.0F,
        0,
        2,
        16,
        35,
        59,
        41,
        1,
        "ExcitedDTPC",
        "Excited Dimensionally Transcendent Prosaic Catalyst",
        -1,
        -1,
        500000000,
        1,
        false,
        true,
        1,
        1,
        1,
        Dyes.dyeGreen);
    public static Materials ExcitedDTRC = new Materials(
        121,
        TextureSet.SET_FLUID,
        1.0F,
        0,
        2,
        16,
        38,
        20,
        56,
        1,
        "ExcitedDTRC",
        "Excited Dimensionally Transcendent Resplendent Catalyst",
        -1,
        -1,
        500000000,
        1,
        false,
        true,
        1,
        1,
        1,
        Dyes.dyeLime);
    public static Materials ExcitedDTEC = new Materials(
        126,
        TextureSet.SET_FLUID,
        1.0F,
        0,
        2,
        16,
        240,
        240,
        41,
        1,
        "ExcitedDTEC",
        "Excited Dimensionally Transcendent Exotic Catalyst",
        -1,
        -1,
        500000000,
        1,
        false,
        true,
        1,
        1,
        1,
        Dyes.dyeMagenta);
    public static Materials ExcitedDTSC = new Materials(
        127,
        TextureSet.SET_FLUID,
        1.0F,
        0,
        2,
        16,
        126,
        75,
        11,
        1,
        "ExcitedDTSC",
        "Excited Dimensionally Transcendent Stellar Catalyst",
        -1,
        -1,
        500000000,
        1,
        false,
        true,
        1,
        1,
        1,
        Dyes.dyeOrange);

    public static Materials DimensionallyTranscendentResidue = new Materials(
        589,
        TextureSet.SET_FLUID,
        1.0F,
        0,
        2,
        16,
        0,
        0,
        0,
        1,
        "DimensionallyTranscendentResidue",
        "Dimensionally Transcendent Residue",
        -1,
        -1,
        25,
        1,
        false,
        true,
        1,
        1,
        1,
        Dyes.dyeBlack);

    public static Materials SpaceTime = new Materials(
        588,
        new TextureSet("spacetime", true),
        320.0F,
        4 * 2621440,
        25,
        1 | 2 | 64 | 128,
        255,
        255,
        255,
        0,
        "SpaceTime",
        "SpaceTime",
        -1,
        -1,
        0,
        0,
        false,
        true,
        2,
        1,
        1,
        Dyes._NULL,
        Collections.singletonList(new TC_Aspects.TC_AspectStack(TC_Aspects.AQUA, 1)))
            .setProcessingMaterialTierEU(TierEU.RECIPE_UEV)
            .disableAutoGeneratedBlastFurnaceRecipes()
            .disableAutoGeneratedVacuumFreezerRecipe();
    public static Materials TranscendentMetal = new Materials(
        581,
        TextureSet.SET_METALLIC,
        290.0F,
        3 * 2621440,
        22,
        1 | 2 | 64 | 128,
        50,
        50,
        50,
        0,
        "TranscendentMetal",
        "Transcendent Metal",
        -1,
        -1,
        0,
        3000,
        true,
        true,
        200,
        1000,
        1000,
        Dyes.dyeBlack,
        Collections.singletonList(new TC_Aspects.TC_AspectStack(TC_Aspects.AQUA, 1)))
            .disableAutoGeneratedBlastFurnaceRecipes()
            .disableAutoGeneratedVacuumFreezerRecipe()
            .setProcessingMaterialTierEU(TierEU.RECIPE_UHV);
    public static Materials MagnetohydrodynamicallyConstrainedStarMatter = new Materials(
        583,
        new TextureSet("MagnetohydrodynamicallyConstrainedStarMatter", true),
        320.0F,
        4 * 2621440,
        25,
        1 | 2 | 64 | 128,
        255,
        255,
        255,
        0,
        "MagnetohydrodynamicallyConstrainedStarMatter",
        "Magnetohydrodynamically Constrained Star Matter",
        -1,
        -1,
        0,
        0,
        false,
        true,
        2,
        1,
        1,
        Dyes._NULL,
        Collections.singletonList(new TC_Aspects.TC_AspectStack(TC_Aspects.AQUA, 1)))
            .setProcessingMaterialTierEU(TierEU.RECIPE_UIV);
    public static Materials RawStarMatter = new Materials(
        584,
        TextureSet.SET_FLUID,
        1.0F,
        0,
        2,
        16 | 32,
        100,
        1,
        255,
        255,
        "RawStarMatter",
        "Condensed Raw Stellar Plasma Mixture",
        -1,
        -1,
        0,
        0,
        false,
        false,
        200,
        1,
        1,
        Dyes.dyePurple);
    public static Materials WhiteDwarfMatter = new Materials(
        585,
        new TextureSet("WhiteDwarfMatter", true),
        1.0F,
        0,
        2,
        1 | 2 | 64 | 128,
        255,
        255,
        255,
        0,
        "WhiteDwarfMatter",
        "White Dwarf Matter",
        -1,
        -1,
        0,
        0,
        false,
        false,
        200,
        1,
        1,
        Dyes.dyePurple).setHasCorrespondingFluid(true)
            .setProcessingMaterialTierEU(TierEU.RECIPE_UEV)
            .disableAutoGeneratedBlastFurnaceRecipes()
            .disableAutoGeneratedVacuumFreezerRecipe();
    public static Materials BlackDwarfMatter = new Materials(
        586,
        TextureSet.SET_METALLIC,
        1.0F,
        0,
        2,
        1 | 2 | 64 | 128,
        0,
        0,
        0,
        255,
        "BlackDwarfMatter",
        "Black Dwarf Matter",
        -1,
        -1,
        0,
        0,
        false,
        false,
        200,
        1,
        1,
        Dyes.dyePurple).setHasCorrespondingFluid(true)
            .setProcessingMaterialTierEU(TierEU.RECIPE_UEV)
            .disableAutoGeneratedBlastFurnaceRecipes()
            .disableAutoGeneratedVacuumFreezerRecipe();

    public static Materials Time = new Materials(
        587,
        TextureSet.SET_FLUID,
        1.0F,
        0,
        2,
        16 | 32,
        100,
        1,
        255,
        255,
        "temporalFluid",
        "Tachyon Rich Temporal Fluid",
        -1,
        -1,
        0,
        0,
        false,
        false,
        200,
        1,
        1,
        Dyes.dyePurple);
    public static Materials Space = new Materials(
        106,
        TextureSet.SET_FLUID,
        1.0F,
        0,
        2,
        16 | 32,
        100,
        1,
        255,
        255,
        "spatialFluid",
        "Spatially Enlarged Fluid",
        -1,
        -1,
        0,
        0,
        false,
        false,
        200,
        1,
        1,
        Dyes.dyePurple);

    public static Materials Universium = new Materials(
        139,
        new TextureSet("universium", true),
        1.0F,
        4 * 2621440,
        25,
        1 | 2 | 64 | 128,
        38,
        49,
        69,
        255,
        "Universium",
        "Universium",
        -1,
        -1,
        0,
        0,
        false,
        true,
        2,
        1,
        1,
        Dyes._NULL,
        Collections.singletonList(new TC_Aspects.TC_AspectStack(TC_Aspects.AQUA, 1)))
            .setProcessingMaterialTierEU(TierEU.RECIPE_UMV);

    public static Materials Eternity = new Materials(
        141,
        new TextureSet("eternity", true),
        1.0F,
        8 * 2621440,
        26,
        1 | 2 | 64 | 128,
        255,
        255,
        255,
        0,
        "Eternity",
        "Eternity",
        -1,
        -1,
        0,
        14000,
        true,
        false,
        2,
        1,
        1,
        Dyes._NULL,
        Collections.singletonList(new TC_Aspects.TC_AspectStack(TC_Aspects.AQUA, 1)))
            .disableAutoGeneratedBlastFurnaceRecipes()
            .disableAutoGeneratedVacuumFreezerRecipe()
            .setProcessingMaterialTierEU(TierEU.RECIPE_UMV);

    public static Materials PrimordialMatter = new Materials(
        142,
        TextureSet.SET_FLUID,
        1.0F,
        0,
        2,
        16,
        255,
        255,
        255,
        0,
        "PrimordialMatter",
        "Liquid Primordial Matter",
        -1,
        -1,
        2_000_000_000,
        1,
        false,
        true,
        1,
        1,
        1,
        Dyes.dyeBlue);

    public static Materials MagMatter = new Materials(
        143,
        new TextureSet("magmatter", true),
        1.0F,
        64 * 2621440,
        26,
        1 | 2 | 64 | 128,
        255,
        255,
        255,
        0,
        "Magmatter",
        "Magmatter",
        -1,
        -1,
        0,
        25000,
        true,
        false,
        2,
        1,
        1,
        Dyes._NULL,
        Collections.singletonList(new TC_Aspects.TC_AspectStack(TC_Aspects.AQUA, 1)))
            .setProcessingMaterialTierEU(TierEU.RECIPE_UMV);

    public static Materials QuarkGluonPlasma = new Materials(
        144,
        TextureSet.SET_FLUID,
        1.0F,
        0,
        2,
        16,
        255,
        255,
        255,
        0,
        "QuarkGluonPlasma",
        "Degenerate Quark Gluon Plasma",
        -1,
        -1,
        2_000_000_000,
        1,
        false,
        true,
        1,
        1,
        1,
        Dyes._NULL);

    public static Materials PhononMedium = new Materials(
        145,
        TextureSet.SET_FLUID,
        1.0F,
        0,
        2,
        16,
        255,
        255,
        255,
        0,
        "PhononMedium",
        "Lossless Phonon Transfer Medium",
        -1,
        -1,
        500,
        1,
        false,
        true,
        1,
        1,
        1,
        Dyes._NULL);

    public static Materials PhononCrystalSolution = new Materials(
        146,
        TextureSet.SET_FLUID,
        1.0F,
        0,
        2,
        16,
        255,
        255,
        255,
        0,
        "PhononCrystalSolution",
        "Saturated Phononic Crystal Solution",
        -1,
        -1,
        500,
        1,
        false,
        true,
        1,
        1,
        1,
        Dyes._NULL);

    public static Materials SixPhasedCopper = new Materials(
        147,
        TextureSet.SET_SHINY,
        1.0F,
        8 * 2621440,
        26,
        1 | 2 | 64 | 128,
        255,
        120,
        20,
        0,
        "SixPhasedCopper",
        "Six-Phased Copper",
        -1,
        -1,
        0,
        14000,
        true,
        false,
        2,
        1,
        1,
        Dyes._NULL,
        Collections.singletonList(new TC_Aspects.TC_AspectStack(TC_Aspects.ITER, 1)))
            .disableAutoGeneratedBlastFurnaceRecipes()
            .disableAutoGeneratedVacuumFreezerRecipe()
            .setProcessingMaterialTierEU(TierEU.RECIPE_UEV);

    /**
     * called by Materials. Can be safely called multiple times. exists to allow Materials ensure this class is
     * initialized
     */
    public static void init() {
        // no-op. all work is done by <clinit>
    }
}
