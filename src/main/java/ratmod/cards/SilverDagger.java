package ratmod.cards;

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
import ratmod.powers.SilveredPower;

public class SilverDagger extends CustomCard {

    public static final String ID = RatMod.makeID("SilverDagger");
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String IMG = RatMod.makePath(RatMod.EchoingStrikesPNG);

    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;

    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    private static final CardType TYPE = CardType.ATTACK;
    public static final CardColor COLOR = CardColor.GREEN;

    private static int COST = 0;
    private static int DAMAGE = 3;
    private static int AMT = 1;

    public SilverDagger() {
        super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        this.baseDamage = DAMAGE;
        this.damage = this.baseDamage;
        this.baseMagicNumber = AMT;
        this.magicNumber = this.baseMagicNumber;

    }

    public void use(AbstractPlayer p, AbstractMonster m) {

        AbstractDungeon.actionManager.addToBottom(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
        if (AbstractDungeon.actionManager.cardsPlayedThisTurn.size() >= 4)
        {
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(m, p, new SilveredPower(m, p, this.magicNumber), this.magicNumber));
        }
    }

    public AbstractCard makeCopy() {
        return new SilverDagger();

    }

    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            this.upgradeDamage(2);
            this.initializeDescription();
        }
    }
}            