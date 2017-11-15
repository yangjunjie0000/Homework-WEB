
/**
 * @Author zhang
 * @Date 2017/11/9 15:55
 * @Content 对战舞台类
 */
public class Stage {
    //盖伦的武器名字
    public String garenWeaponName[] = {"风暴之剑", "冰锤", "海克斯手枪", "饮血剑"};
    //盖伦的武器攻击力
    public int garenWeaponAttack[] = {30, 20, 24, 25};

    //提莫的武器名字
    public String timoWeaponName[] = {"电刀", "饮血剑", "破败王者", "杀戮之剑"};
    //提莫的武器攻击力
    public int timoWeaponAttack[] = {32, 30, 22, 24};


    public void startWar(Garen garen, TIMO timo) {

        System.out.println("---战斗开始----");

        while (true) {

            //如果有任何一个英雄血量<=0 游戏结束
            if (garen.getHP() <= 0 || timo.getHP() <= 0) {
                if (garen.getHP() <= 0) {
                    System.out.println(timo.getName() + "战胜了" + garen.getName());
                } else {
                    System.out.println(garen.getName() + "战胜了" + timo.getName());
                }
                break;
            }

            //实例化武器类 并且赋值给一个叫 garenWeapon的引用
            //这是属于盖伦的武器
            Weapon garenWeapon = new Weapon();
            //java中的随机数类
            //随机一个0~10的浮点数出来
            double garenNumber = Math.random();
            //给盖伦的武器设置名字和攻击力
            if(garenNumber>0.8){
                garenWeapon.setWeaponName(garenWeaponName[0]);
                garenWeapon.setWeaponAttact(garenWeaponAttack[0]);
            }
            else if(garenNumber>0.5){
                garenWeapon.setWeaponName(garenWeaponName[3]);
                garenWeapon.setWeaponAttact(garenWeaponAttack[3]);
            }
            else if(garenNumber>0.2){
                garenWeapon.setWeaponName(garenWeaponName[2]);
                garenWeapon.setWeaponAttact(garenWeaponAttack[2]);
            }
            else{
                garenWeapon.setWeaponName(garenWeaponName[1]);
                garenWeapon.setWeaponAttact(garenWeaponAttack[1]);
            }


            //实例化武器类 并且赋值给一个叫 timoWeapon的引用
            //这是属于提莫的武器
            Weapon timoWeapon = new Weapon();
            double timoNumber = Math.random();
            if(timoNumber>0.8){
                timoWeapon.setWeaponName(timoWeaponName[0]);
                timoWeapon.setWeaponAttact(timoWeaponAttack[0]);
            }
            else if(timoNumber>0.6){
                timoWeapon.setWeaponName(timoWeaponName[1]);
                timoWeapon.setWeaponAttact(timoWeaponAttack[1]);
            }
            else if(timoNumber>0.3){
                timoWeapon.setWeaponName(timoWeaponName[3]);
                timoWeapon.setWeaponAttact(timoWeaponAttack[3]);
            }
            else{
                timoWeapon.setWeaponName(timoWeaponName[2]);
                timoWeapon.setWeaponAttact(timoWeaponAttack[2]);
            }

            Skill castSkill = null;
            //盖伦有四种状态 获取武器 攻击提莫 使用技能 什么也不做
            double garenAction =Math.random();
            castSkill = new GarenSkill();
            if(garenAction>0.6)
                garen.attack(timo);
            else if(garenAction>0.3)
                garen.getWeapon(garenWeapon);
            else if(garenAction>0.2)
                castSkill.cast(garen,timo);
            else
                System.out.println(garen.getName() + "什么也没做");

            //如果有任何一个英雄血量<=0 游戏结束
            if (garen.getHP() <= 0 || timo.getHP() <= 0) {
                if (garen.getHP() <= 0) {
                    System.out.println(timo.getName() + "战胜了" + garen.getName());
                } else {
                    System.out.println(garen.getName() + "战胜了" + timo.getName());
                }
                break;
            }
            if (garen.isBlind())
                garen.setBlind(false);
            //提莫有五种状态 获取武器 攻击盖伦 嘲讽盖伦 释放技能 什么也不做
            double timoAction =Math.random();
            castSkill = new TIMOSkill();
            if(timoAction>0.8)
                castSkill.cast(garen, timo);
            else if(timoAction>0.6)
                timo.getWeapon(timoWeapon);
            else if(timoAction>0.4)
                timo.attack(garen);
            else if(timoAction>0.1)
                timo.chaofeng();
            else
                System.out.println(timo.getName() + "什么也没有做");

            if (timo.isSilent())
                timo.setSilent(false);
        }
    }

    public static void main(String[] args) {
        //实例化一个盖伦
        Garen garen = new Garen();
        garen.setName("gay伦");
        garen.setAttack(100);
        garen.setHP(1000);
        //实例化一个提莫
        TIMO timo = new TIMO();
        timo.setName("提莫");
        timo.setHP(800);
        timo.setAttack(150);
        //实例化一个对战舞台 调用打架方法
        Stage stage = new Stage();
        stage.startWar(garen, timo);
    }
}
