
/**
 * @Author zhang
 * @Date 2017/11/9 15:55
 * @Content 对战舞台类
 */
public class Skill {
    private String name;
    private String effect;

    public void cast(Garen garen, TIMO timo) {
    }

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

    public void cast(Garen garen, TIMO timo) {
        double cast = Math.random();
        GarenSkill skill = null;
        if (cast > 0.7)
            skill = new PlusDefence(garen);
        else if (cast > 0.4)
            skill = new Silence(timo);
        else
            skill = new BigTerasureSword(timo);

        System.out.println(garen.getName() + "使用了" + skill.getName() + "。效果是" + skill.getEffect());
    }
}

class TIMOSkill extends Skill {

    public void cast(Garen garen, TIMO timo) {
        if (timo.isSilent()) {
            System.out.println(timo.getName() + "想要释放技能，可是被沉默啦！");
        } else {
            double cast = Math.random();
            TIMOSkill skill = null;
            if (cast > 0.7)
                skill = new ReduceDefence(garen);
            else if (cast > 0.4)
                skill = new Blind(garen);
            else
                skill = new Mushroom(garen);

            System.out.print(garen.getName() + "使用了" + skill.getName() + "。效果是：" + skill.getEffect());
            if (cast > 0.4 && cast <= 0.7)
                System.out.println(garen.getName() + "还剩下" + garen.getHP() + "点生命值");
            else
                System.out.println();
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
        double dead =Math.random();
        if (dead <= 3)
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
