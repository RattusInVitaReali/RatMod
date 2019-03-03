package ratmod.cards.green;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.*;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import basemod.abstracts.CustomCard;
import ratmod.RatMod;
import ratmod.powers.BleedingPower;

public class Exsanguinate extends CustomCard {

    public static final String ID = RatMod.makeID("Exsanguinate");
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String IMG = RatMod.makePath(RatMod.AtrophicSteroidsPNG);

    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;

    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = CardColor.GREEN;

    private static int COST = 1;
    private static int NUM_TIMES = 3;

    public Exsanguinate() {
        super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        this.baseMagicNumber = NUM_TIMES;
        this.magicNumber = this.baseMagicNumber;

    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if (m.hasPower("Bleeding")) {
            int bleedAmt = m.getPower("Bleeding").amount;
            AbstractDungeon.actionManager.addToBottom(new DamageAction(m, new DamageInfo(p, (bleedAmt * this.magicNumber), this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HEAVY));
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(m, p, new BleedingPower(m, p, -bleedAmt), -bleedAmt));
        }
    }

    public AbstractCard makeCopy() {
        return new Exsanguinate();

    }

    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            this.initializeDescription();
            this.upgradeMagicNumber(1);
        }
    }
}            