package ratmod.powers;

import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.mod.stslib.powers.interfaces.HealthBarRenderPower;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.powers.*;
import ratmod.RatMod;
import ratmod.actions.BleedingLoseHpAction;

public class BleedingPower extends AbstractPower implements HealthBarRenderPower {
    public AbstractCreature source;

    public static final String POWER_ID = "Bleeding";
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    public BleedingPower(final AbstractCreature owner, final AbstractCreature source, final int bleedingAmt) {
        this.name = NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = bleedingAmt;
        this.updateDescription();
        this.type = PowerType.DEBUFF;
        this.isTurnBased = true;
        this.img = RatMod.getBleedingTexture();
        this.source = source;

    }

    public void playApplyPowerSfx()
    {
        CardCrawlGame.sound.play("POWER_POISON", 0.05F);
    }

    @Override
    public void updateDescription()
    {
        if ((this.owner == null) || (this.owner.isPlayer)) {
            this.description = (DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1]);
        } else {
            this.description = (DESCRIPTIONS[2] + this.amount + DESCRIPTIONS[1]);
        }
    }

    public void atStartOfTurn()
    {
        if (AbstractDungeon.getCurrRoom().phase == AbstractRoom.RoomPhase.COMBAT) {
            if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead())
            {
                flashWithoutSound();
                AbstractDungeon.actionManager.addToBottom(new BleedingLoseHpAction(this.owner, this.source, this.amount, AbstractGameAction.AttackEffect.POISON));
            }
        }
    }


    @Override
    public int getHealthBarAmount() {
        return this.amount;
    }

    @Override
    public Color getColor() {
        return Color.SCARLET;
    }
}
