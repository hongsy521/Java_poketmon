package PokemonFolder14;

public class Monster {

    public Monster() {
        System.out.println("플레이어");
    }

    public Monster(String name, int level, String type, int hp, int attack, int speed, int growthHp, int growthAttack, int evolutionLevel) {
        this.name = name;
        this.level = level;
        this.type = type;
        this.hp = hp;
        this.attack = attack;
        this.speed = speed;
        this.growthHp = growthHp;
        this.growthAttack = growthAttack;
        this.evolutionLevel = evolutionLevel;
    }

    private String name;
    private int level;
    private String type;
    private int hp;
    private int attack;
    private int speed;
    private int growthHp;
    private int growthAttack;
    private int evolutionLevel;

   

   

    // 게터 메서드들
    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public String getType() {
        return type;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getSpeed() {
        return speed;
    }

    public int getGrowthHp() {
        return growthHp;
    }

    public int getGrowthAttack() {
        return growthAttack;
    }

    public int getEvolutionLevel() {
        return evolutionLevel;
    }

    // 세터 메서드들
    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setGrowthHp(int growthHp) {
        this.growthHp = growthHp;
    }

    public void setGrowthAttack(int growthAttack) {
        this.growthAttack = growthAttack;
    }

    public void setEvolutionLevel(int evolutionLevel) {
        this.evolutionLevel = evolutionLevel;
    }

    // 필요한 추가 메서드들을 구현하세요.
}
