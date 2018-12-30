package ratmod.cards;

import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.*;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import basemod.abstracts.CustomCard;
import ratmod.RatMod;

public class ArgentInfusion extends CustomCard {

    public static final String ID = RatMod.makeID("ArgentInfusion");
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String IMG = RatMod.makePath(RatMod.ColdBloodPNG);

    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;

    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.ALL_ENEMY;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = CardColor.GREEN;

    private static int COST = 2;
    private static int BLOCK = 7;
    private static int AMT = 0;

    public ArgentInfusion() {
        super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        this.baseBlock = BLOCK;
        this.block = this.baseBlock;

    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        AMT = 0;
        for (AbstractMonster monster : AbstractDungeon.getMonsters().monsters)
        {
            if (monster.hasPower("Silvered"))
            {
                AMT += monster.getPower("Silvered").amount;
            }
        }
        for (int i = 0; i < AMT; ++i)
        {
            AbstractDungeon.actionManager.addToBottom(new GainBlockAction(p, p, this.block));
        }
    }

    public AbstractCard makeCopy() {
        return new ArgentInfusion();
    }

    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            this.upgradeBaseCost(1);
            this.initializeDescription();
        }
    }
}            