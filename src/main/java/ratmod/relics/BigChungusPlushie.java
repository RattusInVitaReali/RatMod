package ratmod.relics;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.SlowPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import basemod.abstracts.CustomRelic;
import ratmod.RatMod;

public class BigChungusPlushie extends CustomRelic {

    public static final String ID = RatMod.makeID("BigChungusPlushie");
    public static final String IMG = RatMod.makePath(RatMod.BigChungusPlushiePNG);
    public static final String OUTLINE = RatMod.makePath(RatMod.BigChunfusPlushieOutlinePNG);

    public BigChungusPlushie() {
        super(ID, new Texture(IMG), new Texture(OUTLINE), RelicTier.SHOP, LandingSound.MAGICAL);
    }

    public void atBattleStart() {
        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new SlowPower(AbstractDungeon.player, 1), 1));
        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new StrengthPower(AbstractDungeon.player, 4), 3));
    }



    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0];
    }


    @Override
    public AbstractRelic makeCopy() {
        return new BigChungusPlushie();

    }
}