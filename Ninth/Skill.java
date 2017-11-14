import java.util.Random;

public class Skill {
    private String name;
    private String effect;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }
}

class GarenSkill extends Skill {

    public void CastPlusDefence(Garen garen) {
        PlusDefence skill = new PlusDefence(garen);
        System.out.println(garen.getName() + "使用了" + skill.getName() + "。效果是" + skill.getEffect());
    }

    public void CastBigTerasureSword(Garen garen, TIMO timo) {
        BigTerasureSword skill = new BigTerasureSword(timo);
        System.out.println(garen.getName() + "使用了" + skill.getName() + "。效果是" + skill.getEffect());
    }

    public void CastSilence(Garen garen, TIMO timo) {
        Silence skill = new Silence(timo);
        System.out.println(garen.getName() + "使用了" + skill.getName() + "。效果是" + skill.getEffect());
    }
}

class TIMOSkill extends Skill {
    public void CastReduceDefence(Garen garen, TIMO timo) {
        if (timo.isSilent()) {
            System.out.println(timo.getName() + "想要释放技能，可是被沉默啦！");
        } else {
            ReduceDefence skill = new ReduceDefence(garen);
            System.out.println(timo.getName() + "使用了" + skill.getName() + "。效果是" + skill.getEffect());
        }
    }

    public void CastMushroom(Garen garen, TIMO timo) {
        if (timo.isSilent()) {
            System.out.println(timo.getName() + "想要释放技能，可是被沉默啦！");
        } else {
            Mushroom skill = new Mushroom(garen);
            System.out.println(timo.getName() + "使用了" + skill.getName() + "。效果是" + skill.getEffect() + "。" + garen.getName() + "的生命值还剩" + garen.getHP());
        }
    }

    public void CastBlind(Garen garen, TIMO timo) {
        if (timo.isSilent()) {
            System.out.println(timo.getName() + "想要释放技能，可是被沉默啦！");
        } else {
            Blind skill = new Blind(garen);
            System.out.println(timo.getName() + "使用了" + skill.getName() + "。效果是" + skill.getEffect());
        }
    }
}

class PlusDefence extends GarenSkill {
    public PlusDefence(Garen garen) {
        this.setName("加防御");
        this.setEffect("获得5点防御力");
        garen.setDefence(garen.getDefence() + 5);
    }
}

class BigTerasureSword extends GarenSkill {
    public BigTerasureSword(TIMO timo) {
        this.setName("大宝剑(作弊型)！！");
        this.setEffect("有50%几率直接秒杀掉敌方英雄");
        Random dead = new Random(System.currentTimeMillis());
        int num = dead.nextInt(10) + 1;
        if (num <= 5)
            timo.setHP(0);
    }
}

class Silence extends GarenSkill {
    public Silence(TIMO timo) {
        this.setName("沉默");
        this.setEffect("使对方英雄本回合无法使用技能");
        timo.setSilent(true);
    }
}

class ReduceDefence extends TIMOSkill {
    public ReduceDefence(Garen garen) {
        this.setName("减甲");
        this.setEffect("减少敌方英雄护甲5点");
        garen.setDefence(garen.getDefence() - 5);
    }
}

class Mushroom extends TIMOSkill {
    public Mushroom(Garen garen) {
        this.setName("种蘑菇");
        this.setEffect("对敌方英雄造成25%当前生命值的伤害");
        garen.setHP((garen.getHP() * 3 / 4));
    }
}

class Blind extends TIMOSkill {
    public Blind(Garen garen) {
        this.setName("致盲");
        this.setEffect("本回合内的普通攻击落空");
        garen.setBlind(true);
    }
}
