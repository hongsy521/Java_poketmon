package PokemonFolder14;

public class PlayerInfo extends Monster {

    public PlayerInfo(){
        super();
    }
    
    public PlayerInfo(String name, int level, String type, int hp, int attack, int speed, int growthHp, int growthAttack, int evolutionLevel) {
        super(name, level, type, hp, attack, speed, growthHp, growthAttack, evolutionLevel);
        // Additional initialization or logic for the PlayerInfo constructor
    }
    
    private String player_name; // 수정: 배열 대신 단일 String 변수로 변경
    private int player_level;
    private int player_exp;
    private int player_max_exp;
    private int player_money;
    private int ball1;
    private int ball2;
    private int ball3;
    private int ball4;
    private int postion1;
    private int postion2;
    private int postion3;
    private int postion4;
    private int postion5;
    private Monster[] myPokemon_list; // 수정: "PokeMonster" 배열로 변경
    private Monster enemyPokemon_list;

    public void showInfo() { // 수정: 반환 타입이 없는 메서드는 void로 선언
        System.out.println("=======================");
        System.out.printf("%s의 정보를 불러옵니다\n", this.player_name);
        System.out.printf("이름: %s 레벨: %d (%d/%d) \n", this.player_name, this.player_level, this.player_exp, this.player_max_exp);
        System.out.printf("몬스터볼 X %d개\n", this.ball1);
        System.out.printf("슈퍼볼 X %d개\n", this.ball2);
        System.out.printf("하이퍼볼 X %d개\n", this.ball3);
        System.out.printf("마스터볼 X %d개\n", this.ball4);
        System.out.println("=======================");
        System.out.printf("상처약 X %d개\n", this.postion1);
        System.out.printf("고급상처약 X %d개\n", this.postion2);
        System.out.printf("풀회복약 X %d개\n", this.postion3);
        System.out.printf("기력의 조각 X %d개\n", this.postion4);
        System.out.printf("부활초 X %d개\n", this.postion5);
        System.out.println();
    }
}


