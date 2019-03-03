package ratmod.powers;

import com.megacrit.cardcrawl.powers.PoisonPower;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import ratmod.RatMod;


public class VenomousWoundsPower
        extends AbstractPower
{
    public static final String POWER_ID = "VenomousWounds";
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    public VenomousWoundsPower(AbstractCreature owner, int newAmount)

    {
        this.name = NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = newAmount;
        this.updateDescription();
        this.img = RatMod.getVenomousWoundsTexture();
        this.type = PowerType.BUFF;
    }

    public void updateDescription()
    {
        this.description = (DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1]) +  this.amount + DESCRIPTIONS[2];
    }

    public void onAttack(DamageInfo info, int damageAmount, AbstractCreature target)
    {
        if ((damageAmount > 0) && (target != this.owner) && (info.type == DamageInfo.DamageType.NORMAL))
        {
            if (target.hasPower("Poison")) {
                AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(target, this.owner, new BleedingPower(target, this.owner, this.amount), this.amount, true));
                if (AbstractDungeon.player.hasRelic("rat:RedSneckoSkull")) {
                    AbstractDungeon.player.getRelic("rat:RedSneckoSkull").flash();
                    AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(target, this.owner, new BleedingPower(target, this.owner, 1), 1));
                }

            }

            if (target.hasPower("Bleeding")) {
                AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(target, this.owner, new PoisonPower(target, this.owner, this.amount), this.amount, true));

            }

        }
    }
}
