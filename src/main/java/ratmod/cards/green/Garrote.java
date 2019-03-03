package ratmod.cards.green;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.*;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.vfx.combat.ClashEffect;
import ratmod.RatMod;
import ratmod.powers.BleedingPower;

public class Garrote extends CustomCard {

    public static final String ID = RatMod.makeID("Garrote");
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String IMG = RatMod.makePath(RatMod.EchoingStrikesPNG);

    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;

    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    private static final CardType TYPE = CardType.ATTACK;
    public static final CardColor COLOR = CardColor.GREEN;

    private static int COST = 1;
    private static int DAMAGE = 3;
    private static int AMT = 2;

    public Garrote() {
        super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
            this.exhaust = true;
            this.baseMagicNumber = AMT;
            this.magicNumber = this.baseMagicNumber;
            this.baseDamage = DAMAGE;
            this.damage = this.baseDamage;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if (m != null) {
            AbstractDungeon.actionManager.addToBottom(new VFXAction(new ClashEffect(m.hb.cX, m.hb.cY), 0.1F));
        }
        AbstractDungeon.actionManager.addToBottom(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.NONE));

        if (AbstractDungeon.actionManager.cardsPlayedThisTurn.size() >= 2) {
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(m, p, new VulnerablePower(m, 1, false), 1));
        }
        if (AbstractDungeon.actionManager.cardsPlayedThisTurn.size() >= 2) {
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(m, p, new BleedingPower(m, p, (this.magicNumber)), this.magicNumber));
            if (AbstractDungeon.player.hasRelic("rat:RedSneckoSkull")) {
                AbstractDungeon.player.getRelic("rat:RedSneckoSkull").flash();
                AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(m, p, new BleedingPower(m, p, 1), 1));
            }
        }
        if (AbstractDungeon.actionManager.cardsPlayedThisTurn.size() >= 3) {
            if (this.upgraded == true) {
                AbstractCard s = new Garrote();
                s.upgrade();
                AbstractDungeon.actionManager.addToBottom(new MakeTempCardInHandAction(s, 1));

            } else {
                AbstractDungeon.actionManager.addToBottom(new MakeTempCardInHandAction(new Garrote(), 1));
            }
        }

    }

    public AbstractCard makeCopy() {
        return new Garrote();

    }

    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            this.initializeDescription();
            this.upgradeDamage(2);
            this.upgradeMagicNumber(1);
        }
    }
}            