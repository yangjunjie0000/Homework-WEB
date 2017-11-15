
/**
 * @Author zhang
 * @Date 2017/11/9 15:55
 * @Content 对战舞台类
 */
public class Garen extends Hero {

    public void attack(TIMO timo) {
        if (isBlind()) {
            System.out.println(this.getName()+"攻击了"+timo.getName()+"。但是"+this.getName()+"被致盲了，所以此次不造成伤害");
            timo.setBlind(false);
        } else {
            int anotherHeroLeftHP = 0;
            //盖伦拿自己的攻击力去攻击传入的timo
            if ((getAttack() - timo.getDefence()) <= timo.getHP()) {
                //如果盖伦攻击力比被timo的血量还低 说明这次攻击不足以击杀对方
                //我们就把提莫的HP减去  减去的值应该是盖伦的攻击力
                anotherHeroLeftHP = timo.getHP() - (getAttack() - getDefence());
                //然后把timo还剩下的血量设置回去
                timo.setHP(anotherHeroLeftHP);

                System.out.println(this.getName() + "攻击了" + timo.getName() + "," + this.getName() + "的攻击力为" + this.getAttack() + "，" + timo.getName() + "防御力为" + timo.getDefence() + "。" + timo.getName() + "实际受到了" + (getAttack() - timo.getDefence()) + "点伤害，" + timo.getName() + "HP还剩" + timo.getHP());
            } else {
                //如果盖伦攻击力 比timo的血量还高 那timo就死了 游戏就结束了
                //被攻击的英雄血量设置为0
                timo.setHP(0);
                System.out.println(this.getName() + "攻击了" + timo.getName() + "," + this.getName() + "的攻击力为" + this.getAttack() + "，" + timo.getName() + "防御力为" + timo.getDefence() + "。" + timo.getName() + "实际受到了" + (getAttack() - timo.getDefence()) + "点伤害，" + timo.getName() + "HP还剩0");
            }
        }
    }

    //你可以为盖伦添加其他有意思的方法 但是记得在调用的时候打印出来

}
