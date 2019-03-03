package ratmod.ArchetypeAPI.ArchetypeCards;

import archetypeAPI.cards.AbstractArchetypeCard;
import com.evacipated.cardcrawl.modthespire.Loader;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.localization.UIStrings;
import ratmod.ArchetypeAPI.Archetypes.bleedingSilent;
import ratmod.RatMod;

import static archetypeAPI.patches.ArchetypeCardTags.SINGLE;

public class BleedingSilentArchetypeSelectCard extends AbstractArchetypeCard {


    public static final String ID = RatMod.makeID("BleedingSilentArchetypeSelectCard");
    public static final String IMG = RatMod.makePath(RatMod.EchoingStrikesPNG);
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;

    private static final UIStrings uiStrings = CardCrawlGame.languagePack.getUIString("archetypeAPI:Flavor");

    private static final CardType TYPE = CardType.ATTACK;
    public static final CardColor COLOR = CardColor.GREEN;

    public BleedingSilentArchetypeSelectCard() {
        super(ID, NAME, IMG, DESCRIPTION, TYPE, COLOR);
        if (Loader.isModLoaded("archetypeapi")) { // Make sure to check for the API before adding a tag from it
            tags.add(SINGLE); // Explanation of tags is just below
        }
    }

    @Override
    public void archetypeEffect() { // This is the important necessary bit that adds your archetype.
        bleedingSilent bleedingSilent = new bleedingSilent(); // Simply create a new instance of the archetype class you made in step 2.
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.initializeDescription();
        }
    }
}