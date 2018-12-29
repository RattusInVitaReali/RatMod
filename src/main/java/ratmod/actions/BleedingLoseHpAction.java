package ratmod.actions;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.utility.WaitAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BleedingLoseHpAction
        extends AbstractGameAction
{
    private static final Logger logger = LogManager.getLogger(BleedingLoseHpAction.class.getName());
    private static final float DURATION = 0.33F;

    public BleedingLoseHpAction(AbstractCreature target, AbstractCreature source, int amount, AbstractGameAction.AttackEffect effect)
    {
        setValues(target, source, amount);
        this.actionType = AbstractGameAction.ActionType.DAMAGE;
        this.attackEffect = effect;
        this.duration = DURATION;
    }

    public void update()
    {
        if (AbstractDungeon.getCurrRoom().phase != AbstractRoom.RoomPhase.COMBAT)
        {
            this.isDone = true;
            return;
        }
        if ((this.duration == 0.33F) && (this.target.currentHealth > 0))
        {
            logger.info(this.target.name + " HAS " + this.target.currentHealth + " HP.");
            this.target.damageFlash = true;
            this.target.damageFlashFrames = 4;
        }
        tickDuration();
        if (this.isDone)
        {
            if (this.target.currentHealth > 0)
            {
                this.target.tint.color = Color.SCARLET.cpy();
                this.target.tint.changeColor(Color.WHITE.cpy());
                this.target.damage(new DamageInfo(this.source, this.amount, DamageInfo.DamageType.HP_LOSS));

            }
            AbstractPower p = this.target.getPower("Bleeding");
            if (p != null)
            {
                if (p.amount == 0) {
                    this.target.powers.remove(p);
                } else {
                    p.updateDescription();
                }
            }
            if (AbstractDungeon.getCurrRoom().monsters.areMonstersBasicallyDead()) {
                AbstractDungeon.actionManager.clearPostCombatActions();
            }
            AbstractDungeon.actionManager.addToTop(new WaitAction(0.1F));
        }
    }
}
