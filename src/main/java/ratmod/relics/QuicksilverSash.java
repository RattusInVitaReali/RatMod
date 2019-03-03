package ratmod.relics;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import basemod.abstracts.CustomRelic;
import ratmod.RatMod;

public class QuicksilverSash extends CustomRelic {

    public static final String ID = RatMod.makeID("QuicksilverSash");
    public static final String IMG = RatMod.makePath(RatMod.QuicksilverSashPNG);
    public static final String OUTLINE = RatMod.makePath(RatMod.QuicksilverSashOutlinePNG);

    public QuicksilverSash() {
        super(ID, new Texture(IMG), new Texture(OUTLINE), RelicTier.COMMON, LandingSound.MAGICAL);
    }

    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0];
    }


    @Override
    public AbstractRelic makeCopy() {
        return new QuicksilverSash();
    }
}