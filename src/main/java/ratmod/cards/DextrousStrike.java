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

public class DextrousStrike extends CustomCard {

    public static final String ID = RatMod.makeID("DextrousStrike");
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String IMG = RatMod.makePath(RatMod.EchoingStrikesPNG);

    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;

    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    private static final CardType TYPE = CardType.ATTACK;
    public static final CardColor COLOR = CardColor.GREEN;

    private static int COST = 1;
    private static int DAMAGE = 4;
    private int STR_AMT;
    private int DEX_AMT;

    public DextrousStrike() {
        super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        this.baseDamage = DAMAGE;
        this.damage = this.baseDamage;

    }

    public void use(AbstractPlayer p, AbstractMonster m) {

        if (p.hasPower("Strength")) {
            STR_AMT = p.getPower("Strength").amount;
        }

        if (p.hasPower("Dexterity")) {
            DEX_AMT = p.getPower("Dexterity").amount;
        }

        AbstractDungeon.actionManager.addToBottom(new DamageAction(m, new DamageInfo(p, (this.damage - STR_AMT + DEX_AMT), this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
        AbstractDungeon.actionManager.addToBottom(new DamageAction(m, new DamageInfo(p, (this.damage - STR_AMT + DEX_AMT), this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));

    }

    public AbstractCard makeCopy() {
        return new DextrousStrike();

    }

    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            this.initializeDescription();
            this.upgradeDamage(1);
        }
    }
}            