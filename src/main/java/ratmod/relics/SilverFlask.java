package ratmod.relics;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import basemod.abstracts.CustomRelic;
import ratmod.RatMod;
import ratmod.powers.SilveredPower;

public class SilverFlask extends CustomRelic {

    public static final String ID = RatMod.makeID("SilverFlask");
    public static final String IMG = RatMod.makePath(RatMod.RatRelicPNG);
    public static final String OUTLINE = RatMod.makePath(RatMod.RatRelicOutlinePNG);

    public SilverFlask() {
        super(ID, new Texture(IMG), new Texture(OUTLINE), RelicTier.BOSS, LandingSound.MAGICAL);
    }

    public void onEquip() {
        AbstractDungeon.player.energy.energyMaster += 1;
    }

    public void onUnequip() {
        AbstractDungeon.player.energy.energyMaster -= 1;
    }

    public void onShuffle() {
        this.flash();
        this.counter += 1;
        if (this.counter == 2) {
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new SilveredPower(AbstractDungeon.player, AbstractDungeon.player, 1), 1));
            this.counter = 0;

        }
    }

    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0];
    }


    @Override
    public AbstractRelic makeCopy() {
        return new SilverFlask();

    }
}