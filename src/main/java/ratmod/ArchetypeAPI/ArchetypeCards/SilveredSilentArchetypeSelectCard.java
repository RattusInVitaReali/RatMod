package ratmod.ArchetypeAPI.ArchetypeCards;

import archetypeAPI.cards.AbstractArchetypeCard;
import com.evacipated.cardcrawl.modthespire.Loader;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import ratmod.ArchetypeAPI.Archetypes.silveredSilent;
import ratmod.RatMod;

import static archetypeAPI.patches.ArchetypeCardTags.SINGLE;

public class SilveredSilentArchetypeSelectCard extends AbstractArchetypeCard {


    public static final String ID = RatMod.makeID("SilveredSilentArchetypeSelectCard");
    public static final String IMG = RatMod.makePath(RatMod.EchoingStrikesPNG);
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;

    private static final CardType TYPE = CardType.ATTACK;
    public static final CardColor COLOR = CardColor.GREEN;

    public SilveredSilentArchetypeSelectCard() {
        super(ID, NAME, IMG, DESCRIPTION, TYPE, COLOR);
        if (Loader.isModLoaded("archetypeapi")) { // Make sure to check for the API before adding a tag from it
            tags.add(SINGLE); // Explanation of tags is just below
        }
    }

    @Override
    public void archetypeEffect() { // This is the important necessary bit that adds your archetype.
         silveredSilent silveredSilent = new silveredSilent(); // Simply create a new instance of the archetype class you made in step 2.
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.initializeDescription();
        }
    }
}