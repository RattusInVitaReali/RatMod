package ratmod.powers;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.unique.RemoveDebuffsAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.powers.*;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import ratmod.RatMod;


public class SilveredPower extends AbstractPower {
    public AbstractCreature source;

    public static final String POWER_ID = "Silvered";
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;


    public SilveredPower(final AbstractCreature owner, final AbstractCreature source, final int silveredAmt) {
        this.name = NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = silveredAmt;
        this.updateDescription();
        this.type = PowerType.DEBUFF;
        this.isTurnBased = false;
        this.img = RatMod.getSilveredTexture();
        this.source = source;

    }


    public void updateDescription()
    {
        this.description = (DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1]);
    }

    public int onAttacked(DamageInfo info, int damageAmount) {

        if (this.amount >= 3)
        {
            if (AbstractDungeon.player.hasRelic("rat:SilverBolt")) {
                AbstractDungeon.player.getRelic("rat:SilverBolt").flash();
                AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(this.owner, this.owner, new WeakPower(this.owner, 2, false), 2));
            }

            if (AbstractDungeon.player.hasRelic("rat:QuicksilverSash")) {
                AbstractDungeon.player.getRelic("rat:QuicksilverSash").flash();
                AbstractDungeon.actionManager.addToBottom(new RemoveDebuffsAction(AbstractDungeon.player));
            }

            AbstractDungeon.actionManager.addToBottom(new DamageAction(owner, new DamageInfo(owner, (this.amount * 10), DamageInfo.DamageType.HP_LOSS), AbstractGameAction.AttackEffect.SLASH_HEAVY));
            AbstractPower p = this.owner.getPower("Silvered");
            if (p != null)
            {
                AbstractDungeon.actionManager.addToTop(new RemoveSpecificPowerAction(this.owner, this.owner, SilveredPower.POWER_ID));
            }

        }
        return damageAmount;
    }
}
