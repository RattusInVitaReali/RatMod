package ratmod.relics;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import basemod.abstracts.CustomRelic;
import ratmod.RatMod;

public class RedSneckoSkull extends CustomRelic {

    public static final String ID = ratmod.RatMod.makeID("RedSneckoSkull");
    public static final String IMG = RatMod.makePath(RatMod.RedSneckoSkullPNG);
    public static final String OUTLINE = RatMod.makePath(RatMod.RedSneckoSkullOutlinePNG);

    public RedSneckoSkull() {
        super(ID, new Texture(IMG), new Texture(OUTLINE), RelicTier.COMMON, LandingSound.MAGICAL);
    }

    public String getUpdatedDescription()
    {
        return this.DESCRIPTIONS[0];
    }


    @Override
    public AbstractRelic makeCopy() {
        return new RedSneckoSkull();
    }
}