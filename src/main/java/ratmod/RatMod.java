package ratmod;

import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.unlock.UnlockTracker;

import basemod.BaseMod;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.EditKeywordsSubscriber;
import basemod.interfaces.EditStringsSubscriber;
import basemod.interfaces.PostInitializeSubscriber;

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


    private static final String DEFAULT_MOD_ASSETS_FOLDER = "defaultModResources/images";

    public static final String DEFAULT_UNCOMMON_ATTACK = "cards/Attack.png";



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
        BaseMod.addCard(new Lunge());
        BaseMod.addCard(new Disembowel());
        BaseMod.addCard(new OpeningStrike());
        BaseMod.addCard(new ColdBlood());
        BaseMod.addCard(new MimicPod());
        BaseMod.addCard(new Shadowstep());
        BaseMod.addCard(new Sprint());


        logger.info("Making sure the cards are unlocked.");
        // Unlock the cards
        UnlockTracker.unlockCard(FanOfKnives.ID);
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
        logger.info("Begin editting strings");

        // CardStrings
        BaseMod.loadCustomStringsFile(CardStrings.class,
                "defaultModResources/localization/DefaultMod-Card-Strings.json");


        logger.info("Done edittting strings");
    }

    // ================ /LOAD THE TEXT/ ===================

    // ================ LOAD THE KEYWORDS ===================

    @Override
    public void receiveEditKeywords() {
        final String[] keywordCombo = {"combo"};
        BaseMod.addKeyword(keywordCombo, "Has an additional effect if you played enough cards this turn.");

    }

    // ================ /LOAD THE KEYWORDS/ ===================    

    // this adds "ModName: " before the ID of any card/relic/power etc.
    // in order to avoid conflics if any other mod uses the same ID.
    public static String makeID(String idText) {
        return "rat:" + idText;
    }

}
