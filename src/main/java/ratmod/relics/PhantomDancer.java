package ratmod.relics;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.BlurPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import basemod.abstracts.CustomRelic;
import ratmod.RatMod;

public class PhantomDancer extends CustomRelic {

    public static final String ID = RatMod.makeID("PhantomDancer");
    public static final String IMG = RatMod.makePath(RatMod.PhantomDancerPNG);
    public static final String OUTLINE = RatMod.makePath(RatMod.PhantomDancerOutlinePNG);

    public PhantomDancer() {
        super(ID, new Texture(IMG), new Texture(OUTLINE), RelicTier.COMMON, LandingSound.MAGICAL);
    }

    public void atTurnStart() {

        this.counter = 0;
    }


    public void onPlayCard(AbstractCard card, AbstractMonster m) {

        if (card.type == AbstractCard.CardType.ATTACK)
        {
            this.counter +=1;
        }

        if (this.counter >= 3)
        {
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new BlurPower(AbstractDungeon.player, 1),1));
            this.counter = 0;
        }


    }

    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0];
    }


    @Override
    public AbstractRelic makeCopy() {
        return new PhantomDancer();
    }
}
