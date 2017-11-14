public class TIMO extends Hero {


    public void attack(Garen garen) {

        int anotherHeroLeftHP = 0;
        //提莫拿自己的攻击力去攻击传入的garen
        if ((getAttack() - garen.getDefence()) <= garen.getHP()) {
            //如果提莫攻击力比盖伦的血量还低 说明这次攻击不足以击杀对方
            //我们就把盖伦的HP减去  减去的值应该是提莫当前的攻击力
            if (getAttack() - garen.getDefence() > 0) {
                anotherHeroLeftHP = garen.getHP() - (getAttack() - garen.getDefence());
                //然后把被攻击的英雄还剩下的血量设置回去
                garen.setHP(anotherHeroLeftHP);
                System.out.println(this.getName() + "攻击了" + garen.getName() + "," + this.getName() + "的攻击力为" + this.getAttack() + "，" + garen.getName() + "防御力为" + garen.getDefence() + "。" + garen.getName() + "实际受到了" + (getAttack() - garen.getDefence()) + "点伤害，" + garen.getName() + "HP还剩" + garen.getHP());
            } else {
                System.out.println(this.getName() + "攻击了" + garen.getName() + "," + this.getName() + "的攻击力为" + this.getAttack() + "，" + garen.getName() + "防御力为" + garen.getDefence() + "。" + garen.getName() + "实际受到了0点伤害，" + garen.getName() + "HP还剩" + garen.getHP());
            }
        } else {
            //如果提莫的攻击力 比garen的血量还高 那garen就死了 游戏就结束了
            //被攻击的英雄血量设置为0
            garen.setHP(0);
            System.out.println(this.getName() + "攻击了" + garen.getName() + "," + this.getName() + "的攻击力为" + this.getAttack() + "，" + garen.getName() + "防御力为" + garen.getDefence() + "。" + garen.getName() + "实际受到了" + (getAttack() - garen.getDefence()) + "点伤害，" + garen.getName() + "HP还剩0");
        }
    }

    //提莫种蘑菇的方法
    public void chaofeng() {
        System.out.println("提莫嘲讽了对面的大傻子");
    }

    //你可以为提莫添加其他有意思的方法 但是记得在调用的时候打印出来
}
