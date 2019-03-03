package ratmod.relics;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import basemod.abstracts.CustomRelic;
import ratmod.RatMod;
import ratmod.powers.KircheisShardPower;

public class KircheisShard extends CustomRelic {

    public static final String ID = RatMod.makeID("KircheisShard");
    public static final String IMG = RatMod.makePath(RatMod.RatRelicPNG);
    public static final String OUTLINE = RatMod.makePath(RatMod.RatRelicOutlinePNG);

    public KircheisShard() {
        super(ID, new Texture(IMG), new Texture(OUTLINE), RelicTier.COMMON, LandingSound.MAGICAL);
    }

    public void onPlayCard(AbstractCard card, AbstractMonster m){

        if (card.type == AbstractCard.CardType.SKILL) {
            this.counter += 1;

        }

        if (this.counter >= 5) {
            beginPulse();
            this.pulse = true;
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new KircheisShardPower(AbstractDungeon.player, 1), 1, true));
        }

        if (card.type == AbstractCard.CardType.ATTACK) {

            this.counter = 0;

        }

        if (this.counter < 5) {
            this.pulse = false;
        }



    }

    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0];
    }


    @Override
    public AbstractRelic makeCopy() {
        return new KircheisShard();

    }
}