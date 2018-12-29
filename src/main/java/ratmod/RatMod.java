package ratmod;

import basemod.interfaces.*;
import com.badlogic.gdx.graphics.Texture;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.localization.RelicStrings;
import com.megacrit.cardcrawl.unlock.UnlockTracker;
import basemod.BaseMod;
import ratmod.cards.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@SpireInitializer
public class RatMod
        implements
        EditCardsSubscriber,
        EditKeywordsSubscriber,
        EditStringsSubscriber,
        PostInitializeSubscriber {

    public static final Logger logger = LogManager.getLogger(RatMod.class.getName());


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

    public static final String BleedingPNG = "powers/Bleeding.png";
    public static final String VenomousWoundsPNG = "powers/VenomousWounds.png";
    public static final String BloodPactPNG = "powers/BloodPact.png";
    public static final String SilveredPNG = "powers/Silvered.png";
    public static final String SilverCoatingPNG = "powers/SilverCoating.png";





    public static Texture getBleedingTexture() { return new Texture(makePath(BleedingPNG)); }
    public static Texture getVenomousWoundsTexture() { return new Texture (makePath(VenomousWoundsPNG)); }
    public static Texture getBloodPactTexture() { return new Texture (makePath(BloodPactPNG)); }
    public static Texture getSilveredTexture() { return new Texture(makePath(SilveredPNG)); }
    public static Texture getSilverCoatingTexture() { return new Texture(makePath(SilverCoatingPNG)); }



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


        


       }

    // =============== / POST-INITIALIZE/ =================

       



    
    
    // ================ ADD CARDS ===================

    @Override
    public void receiveEditCards() {

        
        logger.info("Add Cards");
        // Add the cards
        BaseMod.addCard(new FanOfKnives());
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


        logger.info("Making sure the cards are unlocked.");
        // Unlock the cards
        UnlockTracker.unlockCard(MoondustBomb.ID);
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


        logger.info("Cards - added!");
    }
    // ================ /ADD CARDS/ ===================


    
    
    // ================ LOAD THE TEXT ===================

    @Override
    public void receiveEditStrings() {
        logger.info("Begin editing strings");

        // CardStrings
        BaseMod.loadCustomStringsFile(CardStrings.class,
                "rat/localization/cardStrings.json");
        BaseMod.loadCustomStringsFile(PowerStrings.class,
                "rat/localization/powerStrings.json");
        BaseMod.loadCustomStringsFile(RelicStrings.class,
                "rat/localization/relicStrings.json");

        logger.info("Done editing strings");
    }

    // ================ /LOAD THE TEXT/ ===================

    // ================ LOAD THE KEYWORDS ===================

    @Override
    public void receiveEditKeywords() {
        final String[] keywordCombo = {"combo"};
        final String[] keywordEcho = {"echo"};
        final String[] keywordBleed = {"bleed","bleeding","bleeds"};
        final String[] keywordSilvered = {"silvered", "silver"};
        BaseMod.addKeyword(keywordCombo, "Has an additional effect if you played enough cards this turn.");
        BaseMod.addKeyword(keywordEcho, "Adds a copy of the card to your hand.");
        BaseMod.addKeyword(keywordBleed, "Bleeding enemies take damage at the end of every turn");
        BaseMod.addKeyword(keywordSilvered, "After receiving 3 stacks of Silvered, taking damage activates the Silver, dealing 30 additional damage and cleansing it.");
    }


    // ================ /LOAD THE KEYWORDS/ ===================    

    // this adds "ModName: " before the ID of any card/relic/power etc.
    // in order to avoid conflicts if any other mod uses the same ID.
    public static String makeID(String idText) {
        return "rat:" + idText;
    }

}
