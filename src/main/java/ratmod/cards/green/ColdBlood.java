package ratmod.cards.green;

import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.vfx.combat.InflameEffect;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.cards.*;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import basemod.abstracts.CustomCard;
import ratmod.RatMod;

public class ColdBlood extends CustomCard {

    public static final String ID = RatMod.makeID("ColdBlood");
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String IMG = RatMod.makePath(RatMod.ColdBloodPNG);

    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;

    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.SELF;
    private static final CardType TYPE = CardType.POWER;
    public static final CardColor COLOR = CardColor.GREEN;

    public static final int STR_GAIN = 1;


    private static int COST = 2;

    public ColdBlood() {
        super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        this.baseMagicNumber = STR_GAIN;
        this.magicNumber = this.baseMagicNumber;
        this.exhaust = true;

    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if (AbstractDungeon.actionManager.cardsPlayedThisTurn.size() >= 3) {
            AbstractDungeon.actionManager.addToBottom(new VFXAction(p, new InflameEffect(p), 0.3F));
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new StrengthPower(p, this.magicNumber), this.magicNumber));
            AbstractDungeon.actionManager.addToBottom(new VFXAction(p, new InflameEffect(p), 0.3F));
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new StrengthPower(p, (this.magicNumber + 1)), (this.magicNumber + 1)));
        }   else    {
            AbstractDungeon.actionManager.addToBottom(new VFXAction(p, new InflameEffect(p), 0.3F));
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new StrengthPower(p, this.magicNumber), this.magicNumber));
        }

    }

    public AbstractCard makeCopy() {
        return new ColdBlood();

    }

    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            this.initializeDescription();
            this.upgradeBaseCost(1);
        }
    }
}            