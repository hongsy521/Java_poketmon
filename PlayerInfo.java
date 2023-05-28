package PokemonFolder14;

import java.util.*;
import java.io.*;

public class PlayerInfo {
    private String player_name;
    private int player_level;
    private int player_exp;
    private int player_max_exp;
    private int player_money;
    private int ball1;
    private int ball2;
    private int ball3;
    private int ball4;
    private int potion1;
    private int potion2;
    private int potion3;
    private int potion4;
    private int potion5;
    private Monster[] myPokemon_list;			//내 포켓몬 리스트
    private Monster enemyPokemon;				//적 포켓몬
    											//이것들은 전투를 할때 쓰여짐

    public PlayerInfo() {
        // 기본 생성자
    }
    public PlayerInfo(String name, int level, int exp, int maxExp, int money,
                      int ball1, int ball2, int ball3, int ball4,
                      int potion1, int potion2, int potion3, int potion4, int potion5,
                      Monster[] myPokemon_list, Monster enemyPokemon) {
        //초기화하기
    	this.player_name = name;
        this.player_level = level;
        this.player_exp = exp;
        this.player_max_exp = maxExp;
        this.player_money = money;
        this.ball1 = ball1;
        this.ball2 = ball2;
        this.ball3 = ball3;
        this.ball4 = ball4;
        this.potion1 = potion1;
        this.potion2 = potion2;
        this.potion3 = potion3;
        this.potion4 = potion4;
        this.potion5 = potion5;
        this.myPokemon_list = Arrays.copyOf(myPokemon_list, myPokemon_list.length);
        this.enemyPokemon = enemyPokemon;
    }

    
    public void showInfo() {	//플레이어 정보 불러오기
        System.out.println("=======================");
        System.out.printf("%s의 정보를 불러옵니다\n", this.player_name);
        System.out.printf("이름: %s 레벨: %d (%d/%d) \n", this.player_name, this.player_level, this.player_exp, this.player_max_exp);
        System.out.printf("몬스터볼 X %d개\n", this.ball1);
        System.out.printf("슈퍼볼 X %d개\n", this.ball2);
        System.out.printf("하이퍼볼 X %d개\n", this.ball3);
        System.out.printf("마스터볼 X %d개\n", this.ball4);
        System.out.println("=======================");
        System.out.printf("상처약 X %d개\n", this.potion1);
        System.out.printf("고급상처약 X %d개\n", this.potion2);
        System.out.printf("풀회복약 X %d개\n", this.potion3);
        System.out.printf("기력의 조각 X %d개\n", this.potion4);
        System.out.printf("부활초 X %d개\n", this.potion5);
        System.out.println();
    }

    // Getter와 Setter 메서드들
    public String getPlayerName() {
        return player_name;
    }

    public void setPlayerName(String name) {
        this.player_name = name;
    }

    public int getPlayerLevel() {
        return player_level;
    }

    public void setPlayerLevel(int level) {
        this.player_level = level;
    }

    public int getPlayerExp() {
        return player_exp;
    }

    public void setPlayerExp(int exp) {
        this.player_exp = exp;
    }

    public int getPlayerMaxExp() {
        return player_max_exp;
    }

    public void setPlayerMaxExp(int maxExp) {
        this.player_max_exp = maxExp;
    }

    public int getPlayerMoney() {
        return player_money;
    }

    public void setPlayerMoney(int money) {
        this.player_money = money;
    }

    public int getBall1() {
        return ball1;
    }

    public void setBall1(int ball1) {
        this.ball1 = ball1;
    }

    public int getBall2() {
        return ball2;
    }

    public void setBall2(int ball2) {
        this.ball2 = ball2;
    }

    public int getBall3() {
        return ball3;
    }

    public void setBall3(int ball3) {
        this.ball3 = ball3;
    }

    public int getBall4() {
        return ball4;
    }

    public void setBall4(int ball4) {
        this.ball4 = ball4;
    }

    public int getPotion1() {
        return potion1;
    }

    public void setPotion1(int potion1) {
        this.potion1 = potion1;
    }

    public int getPotion2() {
        return potion2;
    }

    public void setPotion2(int potion2) {
        this.potion2 = potion2;
    }

    public int getPotion3() {
        return potion3;
    }

    public void setPotion3(int potion3) {
        this.potion3 = potion3;
    }

    public int getPotion4() {
        return potion4;
    }

    public void setPotion4(int potion4) {
        this.potion4 = potion4;
    }

    public int getPotion5() {
        return potion5;
    }

    public void setPotion5(int potion5) {
        this.potion5 = potion5;
    }

    public Monster[] getMyPokemonList() {
        return Arrays.copyOf(myPokemon_list, myPokemon_list.length);
    }

    public void setMyPokemonList(Monster[] myPokemon_list) {
        this.myPokemon_list = Arrays.copyOf(myPokemon_list, myPokemon_list.length);
    }

    public Monster getEnemyPokemon() {
        return enemyPokemon;
    }

    public void setEnemyPokemon(Monster enemyPokemon) {
        this.enemyPokemon = enemyPokemon;
    }
}