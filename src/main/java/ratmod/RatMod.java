package ratmod;

import archetypeAPI.archetypes.abstractArchetype;
import basemod.helpers.RelicType;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.evacipated.cardcrawl.modthespire.Loader;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.helpers.CardHelper;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.localization.RelicStrings;
import com.megacrit.cardcrawl.unlock.UnlockTracker;
import basemod.BaseMod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ratmod.ArchetypeAPI.ArchetypeCards.BleedingSilentArchetypeSelectCard;
import ratmod.ArchetypeAPI.ArchetypeCards.SilveredSilentArchetypeSelectCard;
import ratmod.cards.green.*;
import ratmod.cards.red.*;
import ratmod.relics.*;

import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.EditKeywordsSubscriber;
import basemod.interfaces.EditRelicsSubscriber;
import basemod.interfaces.EditStringsSubscriber;
import basemod.interfaces.PostInitializeSubscriber;

@SpireInitializer
public class RatMod
        implements
        EditCardsSubscriber,
        EditKeywordsSubscriber,
        EditStringsSubscriber,
        EditRelicsSubscriber,
        PostInitializeSubscriber {

    public static final Logger logger = LogManager.getLogger(RatMod.class.getName());

    public static final Color DEFAULT_GRAY = CardHelper.getColor(64.0f, 70.0f, 70.0f);

    private static final String ATTACK_DEAFULT_GRAY = "512/bg_attack_default_gray.png";
    private static final String POWER_DEAFULT_GRAY = "512/bg_power_default_gray.png";
    private static final String SKILL_DEAFULT_GRAY = "512/bg_skill_default_gray.png";
    private static final String ENERGY_ORB_DEAFULT_GRAY = "512/card_default_gray_orb.png";
    private static final String CARD_ENERGY_ORB = "512/card_small_orb.png";

    private static final String ATTACK_DEAFULT_GRAY_PORTRAIT = "1024/bg_attack_default_gray.png";
    private static final String POWER_DEAFULT_GRAY_PORTRAIT = "1024/bg_power_default_gray.png";
    private static final String SKILL_DEAFULT_GRAY_PORTRAIT = "1024/bg_skill_default_gray.png";
    private static final String ENERGY_ORB_DEAFULT_GRAY_PORTRAIT = "1024/card_default_gray_orb.png";


    private static final String DEFAULT_MOD_ASSETS_FOLDER = "rat/images";

    public static final String AtrophicSteroidsPNG = "cards/AtrophicSteroids.png";
    public static final String ColdBloodPNG = "cards/ColdBlood.png";
    public static final String DisembowelPNG = "cards/Disembowel.png";
    public static final String EchoingStrikesPNG = "cards/EchoingStrikes.png";
    public static final String FanOfKnivesPNG = "cards/FanOfKnives.png";
    public static final String LungePNG = "cards/Lunge.png";
    public static final String MimicPodPNG = "cards/MimicPod.png";
    public static final String OpeningStrikePNG = "cards/OpeningStrike.png";
    public static final String ShadowstepPNG = "cards/Shadowstep.png";
    public static final String SprintPNG = "cards/Sprint.png";
    public static final String WitheringShacklesPNG = "cards/WitheringShackles.png";
    public static final String DecimatePNG = "cards/Decimate.png";

    public static final String BleedingPNG = "powers/Bleeding.png";
    public static final String VenomousWoundsPNG = "powers/VenomousWounds.png";
    public static final String BloodPactPNG = "powers/BloodPact.png";
    public static final String SilveredPNG = "powers/Silvered.png";
    public static final String SilverCoatingPNG = "powers/SilverCoating.png";
    public static final String SiphonSilverPNG = "powers/SiphonSilver.png";
    public static final String KircheisPowerPNG = "powers/KircheisShard.png";
    public static final String EnragedPNG = "powers/Enraged.png";

    public static final String RatRelicPNG = "relics/RatRelic.png";
    public static final String RatRelicOutlinePNG = "relics/RatRelicOutline.png";
    public static final String RedSneckoSkullPNG = "relics/RedSneckoSkull.png";
    public static final String RedSneckoSkullOutlinePNG = "relics/RedSneckoSkullOutline.png";
    public static final String BigChungusPlushiePNG = "relics/BigChungusPlushie.png";
    public static final String BigChunfusPlushieOutlinePNG = "relics/BigChungusPlushieOutline.png";
    public static final String IroncladSkillbookPNG = "relics/IroncladSkillbook.png";
    public static final String SilentSkillbookPNG = "relics/SilentSkillbook.png";
    public static final String DefectSkillbookPNG = "relics/DefectSkillbook.png";
    public static final String SkillbookOutlinePNG = "relics/SkillbookOutline.png";
    public static final String QuicksilverSashPNG = "relics/QuicksilverSash.png";
    public static final String QuicksilverSashOutlinePNG = "relics/QuicksilverSashOutline.png";
    public static final String ZhonyasHourglassPNG = "relics/ZhonyasHourglass.png";
    public static final String ZhonyasHourglassOutlinePNG = "relics/ZhonyasHourglassOutline.png";
    public static final String PhantomDancerPNG = "relics/PhantomDancer.png";
    public static final String PhantomDancerOutlinePNG = "relics/PhantomDancerOutline.png";
    public static final String SoulRingPNG = "relics/SoulRing.png";
    public static final String SoulRingOutlinePNG = "relics/SoulRingOutline.png";




    public static Texture getBleedingTexture() { return new Texture(makePath(BleedingPNG)); }
    public static Texture getVenomousWoundsTexture() { return new Texture (makePath(VenomousWoundsPNG)); }
    public static Texture getBloodPactTexture() { return new Texture (makePath(BloodPactPNG)); }
    public static Texture getSilveredTexture() { return new Texture(makePath(SilveredPNG)); }
    public static Texture getSilverCoatingTexture() { return new Texture(makePath(SilverCoatingPNG)); }
    public static Texture getSiphonSilverTexture() { return new Texture(makePath(SiphonSilverPNG)); }
    public static Texture getKircheisShardTexture() { return new Texture(makePath(KircheisPowerPNG)); }
    public static Texture getEnragedTexture() { return new Texture(makePath(EnragedPNG)); }



    public static final String makePath(String resource) {
        return DEFAULT_MOD_ASSETS_FOLDER + "/" + resource;
    }


    public RatMod() {
        logger.info("Subscribe to basemod hooks");

        BaseMod.subscribe(this);


        logger.info("Done subscribing");

    }

    @SuppressWarnings("unused")
    public static void initialize() {
        logger.info("========================= Initializing Default Mod. Hi. =========================");
        RatMod defaultmod = new RatMod();
        logger.info("========================= /Default Mod Initialized/ =========================");
    }

    
    @Override
    public void receivePostInitialize() {
        if (Loader.isModLoaded("archetypeapi")) {
            abstractArchetype.silentArchetypeSelectCards.addToTop(new BleedingSilentArchetypeSelectCard().makeCopy());
            abstractArchetype.silentArchetypeSelectCards.addToTop(new SilveredSilentArchetypeSelectCard().makeCopy());
        }
    }



    @Override
    public void receiveEditCards() {

        
        logger.info("Add Cards");
        // Green
        BaseMod.addCard(new FanOfKnives());
        BaseMod.addCard(new ArgentInfusion());
        BaseMod.addCard(new SilverDagger());
        BaseMod.addCard(new SiphonSilver());
        BaseMod.addCard(new MoondustBomb());
        BaseMod.addCard(new SilverCoating());
        BaseMod.addCard(new SilveredBlade());
        BaseMod.addCard(new DextrousStrike());
        BaseMod.addCard(new SiphonBlood());
        BaseMod.addCard(new Garrote());
        BaseMod.addCard(new Exsanguinate());
        BaseMod.addCard(new BloodPact());
        BaseMod.addCard(new VenomousWounds());
        BaseMod.addCard(new Dispatch());
        BaseMod.addCard(new RuptureArtery());
        BaseMod.addCard(new EchoingStrikes());
        BaseMod.addCard(new AtrophicSteroids());
        BaseMod.addCard(new WitheringShackles());
        BaseMod.addCard(new Lunge());
        BaseMod.addCard(new Disembowel());
        BaseMod.addCard(new OpeningStrike());
        BaseMod.addCard(new ColdBlood());
        BaseMod.addCard(new MimicPod());
        BaseMod.addCard(new Shadowstep());
        BaseMod.addCard(new Sprint());

        //Red
        BaseMod.addCard(new Decimate());
        BaseMod.addCard(new Execute());

        logger.info("Making sure the cards are unlocked.");
        // Green
        UnlockTracker.unlockCard(ArgentInfusion.ID);
        UnlockTracker.unlockCard(MoondustBomb.ID);
        UnlockTracker.unlockCard(SilverDagger.ID);
        UnlockTracker.unlockCard(SiphonSilver.ID);
        UnlockTracker.unlockCard(SilverCoating.ID);
        UnlockTracker.unlockCard(SilveredBlade.ID);
        UnlockTracker.unlockCard(BloodPact.ID);
        UnlockTracker.unlockCard(DextrousStrike.ID);
        UnlockTracker.unlockCard(SiphonBlood.ID);
        UnlockTracker.unlockCard(Garrote.ID);
        UnlockTracker.unlockCard(Exsanguinate.ID);
        UnlockTracker.unlockCard(Dispatch.ID);
        UnlockTracker.unlockCard(VenomousWounds.ID);
        UnlockTracker.unlockCard(FanOfKnives.ID);
        UnlockTracker.unlockCard(RuptureArtery.ID);
        UnlockTracker.unlockCard(EchoingStrikes.ID);
        UnlockTracker.unlockCard(AtrophicSteroids.ID);
        UnlockTracker.unlockCard(WitheringShackles.ID);
        UnlockTracker.unlockCard(Lunge.ID);
        UnlockTracker.unlockCard(Disembowel.ID);
        UnlockTracker.unlockCard(OpeningStrike.ID);
        UnlockTracker.unlockCard(ColdBlood.ID);
        UnlockTracker.unlockCard(Shadowstep.ID);
        UnlockTracker.unlockCard(MimicPod.ID);
        UnlockTracker.unlockCard(Sprint.ID);

        //Red
        UnlockTracker.unlockCard(Decimate.ID);
        UnlockTracker.unlockCard(Execute.ID);



        logger.info("Cards - added!");
    }

    @Override
    public void receiveEditRelics() {

        BaseMod.addRelic(new RedSneckoSkull(), RelicType.GREEN);
        BaseMod.addRelic(new SilverBolt(), RelicType.GREEN);
        BaseMod.addRelic(new QuicksilverSash(), RelicType.GREEN);
        BaseMod.addRelic(new SilverFlask(), RelicType.GREEN);

        BaseMod.addRelic(new PhantomDancer(), RelicType.SHARED);
        BaseMod.addRelic(new BigChungusPlushie(), RelicType.SHARED);
        BaseMod.addRelic(new KircheisShard(), RelicType.SHARED);
        BaseMod.addRelic(new SoulRing(), RelicType.SHARED);
        BaseMod.addRelic(new ZhonyasHourglass(), RelicType.SHARED);

    }





    @Override
    public void receiveEditStrings() {
        logger.info("Begin editing strings");

        // CardStrings
        BaseMod.loadCustomStringsFile(CardStrings.class,
                "rat/localization/cardStrings.json");
        BaseMod.loadCustomStringsFile(PowerStrings.class,
                "rat/localization/powerStrings.json");
        BaseMod.loadCustomStringsFile(RelicStrings.class,
                "rat/localization/relicsStrings.json");

        logger.info("Done editing strings");
    }



    @Override
    public void receiveEditKeywords() {
        final String[] keywordCombo = {"combo"};
        final String[] keywordEcho = {"echo"};
        final String[] keywordBleed = {"bleed","bleeding","bleeds"};
        final String[] keywordSilvered = {"silvered", "silver"};
        final String[] keywordEnraged = {"enrage", "enraged", "enrages"};
        BaseMod.addKeyword(keywordCombo, "Has an additional effect if you played enough cards this turn.");
        BaseMod.addKeyword(keywordEcho, "Adds a copy of the card to your hand.");
        BaseMod.addKeyword(keywordBleed, "Bleeding enemies take damage at the end of every turn");
        BaseMod.addKeyword(keywordSilvered, "After receiving 3 stacks of Silvered, taking damage activates the Silver, dealing 30 additional damage and cleansing it.");
        BaseMod.addKeyword(keywordEnraged, "Gain Strength and Vulnerable at the start of your turn.");
    }


    // ================ /LOAD THE KEYWORDS/ ===================    

    // this adds "ModName: " before the ID of any card/relic/power etc.
    // in order to avoid conflicts if any other mod uses the same ID.
    public static String makeID(String idText) {
        return "rat:" + idText;
    }

}
