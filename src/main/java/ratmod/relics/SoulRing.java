package ratmod.relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.evacipated.cardcrawl.mod.stslib.relics.ClickableRelic;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.vfx.combat.OfferingEffect;
import ratmod.RatMod;

public class SoulRing
        extends CustomRelic
        implements ClickableRelic
{
    public static final String ID = RatMod.makeID("SoulRing");
    public static final String IMG = RatMod.makePath(RatMod.SoulRingPNG);
    public static final String OUTLINE = RatMod.makePath(RatMod.SoulRingOutlinePNG);
    private boolean usedThisTurn = false;

    public SoulRing()
    {
        super(ID, new Texture(IMG), new Texture(OUTLINE), RelicTier.SHOP, LandingSound.MAGICAL);
    }

    public String getUpdatedDescription()
    {
        return CLICKABLE_DESCRIPTIONS()[0] + this.DESCRIPTIONS[0];
    }

    public void onRightClick()
    {
        if ((!this.isObtained) || (this.usedThisTurn)) {
            return;
        }
        if ((AbstractDungeon.getCurrRoom() != null) && (AbstractDungeon.getCurrRoom().phase == AbstractRoom.RoomPhase.COMBAT))
        {
            this.usedThisTurn = true;
            flash();
            stopPulse();
            AbstractDungeon.actionManager.addToBottom(new VFXAction(new OfferingEffect(), 0.2F));
            AbstractDungeon.actionManager.addToBottom(new LoseHPAction(AbstractDungeon.player, AbstractDungeon.player, 3));
            AbstractDungeon.actionManager.addToBottom(new GainEnergyAction(1));
        }
    }

    public void atPreBattle()
    {
        this.usedThisTurn = false;
        beginLongPulse();
    }

    public void atTurnStart()
    {
        this.usedThisTurn = false;
        beginLongPulse();
    }

    public void onVictory()
    {
        stopPulse();
    }

    public AbstractRelic makeCopy()
    {
        return new SoulRing();
    }
}
