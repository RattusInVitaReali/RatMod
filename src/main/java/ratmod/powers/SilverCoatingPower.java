package ratmod.powers;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import ratmod.RatMod;



public class SilverCoatingPower
        extends AbstractPower
{
    public static final String POWER_ID = "SilverCoating";
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    public SilverCoatingPower(AbstractCreature owner, int newAmount)

    {
        this.name = NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = newAmount;
        this.updateDescription();
        this.img = RatMod.getSilverCoatingTexture();
        this.type = PowerType.BUFF;
    }

    public void updateDescription()
    {
        this.description = DESCRIPTIONS[0];
    }

    public void onAttack(DamageInfo info, int damageAmount, AbstractCreature target)
    {
        if ((damageAmount > 8) && (target != this.owner) && (info.type == DamageInfo.DamageType.NORMAL))
        {
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(target, this.owner, new SilveredPower(target, this.owner, this.amount), this.amount, true));
        }
    }
}
