package ratmod.cards.green;

import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.*;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import basemod.abstracts.CustomCard;
import ratmod.RatMod;
import ratmod.powers.BloodPactPower;

public class BloodPact extends CustomCard {

    public static final String ID = RatMod.makeID("BloodPact");
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String IMG = RatMod.makePath(RatMod.ColdBloodPNG);

    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;

    private static final CardRarity RARITY = CardRarity.RARE;
    private static final CardTarget TARGET = CardTarget.SELF;
    private static final CardType TYPE = CardType.POWER;
    public static final CardColor COLOR = CardColor.GREEN;

    private static int COST = 2;
    private static int AMT = 2;

    public BloodPact() {
        super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
            this.baseMagicNumber = AMT;
            this.magicNumber = this.baseMagicNumber;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {

        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new BloodPactPower(p, this.magicNumber), this.magicNumber));

    }

    public AbstractCard makeCopy() {
        return new BloodPact();

    }

    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            this.initializeDescription();
            this.upgradeMagicNumber(1);
        }
    }
}            