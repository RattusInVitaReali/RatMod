package ratmod.cards.green;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.powers.*;
import com.megacrit.cardcrawl.cards.*;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import basemod.abstracts.CustomCard;
import ratmod.RatMod;

public class Disembowel extends CustomCard {

    public static final String ID = RatMod.makeID("Disembowel");
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String IMG = RatMod.makePath(RatMod.DisembowelPNG);

    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;

    private static final CardRarity RARITY = CardRarity.RARE;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    private static final CardType TYPE = CardType.ATTACK;
    public static final CardColor COLOR = CardColor.GREEN;

    private static int COST = 2;
    private static final int DAMAGE = 12;
    private static final int NUM_DBF = 2;


    public Disembowel() {
        super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        this.baseDamage = DAMAGE;
        this.baseMagicNumber = NUM_DBF;
        this.magicNumber = this.baseMagicNumber;

    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HEAVY));
        if (AbstractDungeon.actionManager.cardsPlayedThisTurn.size() >= 2) {
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(m, p, new WeakPower(m, this.magicNumber, false), this.magicNumber));
        }
        if (AbstractDungeon.actionManager.cardsPlayedThisTurn.size() >= 3) {
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(m, p, new VulnerablePower(m, this.magicNumber, false), this.magicNumber));
        }
        if (AbstractDungeon.actionManager.cardsPlayedThisTurn.size() >= 5) {
            AbstractDungeon.actionManager.addToBottom(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HEAVY));
        }
        if (AbstractDungeon.actionManager.cardsPlayedThisTurn.size() >= 6) {
            if (this.upgraded == true) {
                AbstractCard s = new Disembowel();
                s.upgrade();
                AbstractDungeon.actionManager.addToBottom(new MakeTempCardInHandAction(s, 1));

            } else {
                AbstractDungeon.actionManager.addToBottom(new MakeTempCardInHandAction(new Disembowel(), 1));
            }
        }

    }

    public AbstractCard makeCopy() {
        return new Disembowel();

    }

    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            this.initializeDescription();
            this.upgradeMagicNumber(1);
            this.upgradeDamage(3);
        }
    }
}            