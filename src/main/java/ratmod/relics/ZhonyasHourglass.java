package ratmod.relics;

import com.badlogic.gdx.graphics.Texture;
import com.evacipated.cardcrawl.mod.stslib.relics.ClickableRelic;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.EntanglePower;
import com.megacrit.cardcrawl.powers.IntangiblePlayerPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import basemod.abstracts.CustomRelic;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.vfx.combat.OfferingEffect;
import ratmod.RatMod;

public class ZhonyasHourglass
        extends CustomRelic
        implements ClickableRelic {

    public static final String ID = RatMod.makeID("ZhonyasHourglass");
    public static final String IMG = RatMod.makePath(RatMod.ZhonyasHourglassPNG);
    public static final String OUTLINE = RatMod.makePath(RatMod.ZhonyasHourglassOutlinePNG);
    private boolean Usable = true;



    public ZhonyasHourglass() {
        super(ID, new Texture(IMG), new Texture(OUTLINE), RelicTier.UNCOMMON, LandingSound.MAGICAL);
    }

    public void atPreBattle() {

        beginLongPulse();
        Usable = true;
        usedUp = false;
    }

    public void atTurnStart() {

        beginLongPulse();
        Usable = true;
    }


    public void onPlayCard(AbstractCard card, AbstractMonster monster) {

        Usable = false;
    }

    public void onRightClick() {

        if ((!this.isObtained) || (this.Usable == false) || (this.usedUp == true) ) {
            return;
        }

        if ((AbstractDungeon.getCurrRoom() != null) && (AbstractDungeon.getCurrRoom().phase == AbstractRoom.RoomPhase.COMBAT))
        {
            this.Usable = false;
            this.usedUp = true;
            flash();
            stopPulse();
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new IntangiblePlayerPower(AbstractDungeon.player, 1), 1));
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new EntanglePower(AbstractDungeon.player), 1));
        }
    }




    public String getUpdatedDescription()
    {
        return CLICKABLE_DESCRIPTIONS()[0] + this.DESCRIPTIONS[0];
    }


    @Override
    public AbstractRelic makeCopy() {
        return new ZhonyasHourglass();
    }
}