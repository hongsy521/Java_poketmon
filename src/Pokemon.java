public class Pokemon {
    public final String name;
    public final String type;
    public int HP;
    public int level;
    public int speed;
    public int attack;

    public Pokemon(String name, String type, int HP, int level, int speed, int attack){
        this.name=name;
        this.type=type;
        this.HP=HP;
        this.level=level;
        this.speed=speed;
        this.attack=attack;
        System.out.println("이름:"+this.name+", 타입:"+this.type+", HP:"+this.HP+", 레벨:"+this.level+", 속도:"+this.speed+", 공격:"+this.attack);
    }
    public static void main(String[] args){
        Pokemon pokemon1=new Pokemon("파이리","불",100, 1,10,10);
        Pokemon pokemon1_1=new Pokemon("리자드","불",100, 1,20,20);
        Pokemon pokemon2=new Pokemon("불꽃숭이","불",100, 1,10,10);
        Pokemon pokemon3=new Pokemon("뚜꾸리","불",100, 1,10,10);
        Pokemon pokemon4=new Pokemon("꼬부기","물",100, 1,10,10);
        Pokemon pokemon4_1=new Pokemon("어니부기","물",100, 1,20,20);
        Pokemon pokemon5=new Pokemon("물짱이","물",100, 1,10,10);
        Pokemon pokemon6=new Pokemon("팽도리","물",100, 1,10,10);
        Pokemon pokemon7=new Pokemon("이상해씨","풀",100, 1,10,10);
        Pokemon pokemon7_1=new Pokemon("이상해풀","풀",100, 1,20,20);
        Pokemon pokemon8=new Pokemon("치코리타","풀",100, 1,10,10);
        Pokemon pokemon9=new Pokemon("나무지기","풀",100, 1,10,10);
        Pokemon pokemon10=new Pokemon("메타몽","노말",100, 3,20,20);
        Pokemon pokemon11=new Pokemon("잠만보","노말",100, 3,20,20);
        Pokemon pokemon12=new Pokemon("이브이","노말",100, 3,20,20);

    }
}
