package PokemonFolder14;

import java.util.*;
import java.io.*;

public class Monster {

    private int number;
    private String name;
    private String realname;
    private int level1;
    private int level;
    private String type;
    private int hp1;
    private int hp;
    private int attack1;
    private int attack;
    private int defense1;
    private int defense;
    private int speed;
    private int growthHp;
    private int growthAttack;
    private int growthDefense;
    private int evolutionLevel;

    public Monster() {
        System.out.println("몬스터 클래스"); // 나중에 지울것 <<
    }

    public Monster(int number, String name, String realname, int level1, int level, String type, int hp1,
            int attack1, int defense1, int speed, int growthHp, int growthAttack, int growthDefense,
            int evolutionLevel) {
        this.number = number;
        this.name = name;
        this.realname = realname;
        this.level1 = level1;
        this.level = level;
        this.type = type;
        this.hp1 = hp1;
        this.hp = hp1 + (level - 1) * growthHp;
        this.attack1 = attack1;
        this.attack = attack1 + (level - 1) * growthAttack;
        this.defense1 = defense1;
        this.defense = defense1 + (level - 1) * growthDefense;
        this.speed = speed;
        this.growthHp = growthHp;
        this.growthAttack = growthAttack;
        this.growthDefense = growthDefense;
        this.evolutionLevel = evolutionLevel;
    }

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

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }

    public int getEvolutionLevel() {
        return evolutionLevel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRealName(String realname) {
        this.realname = realname;
    }

    public void setLevel(int level) {
        this.level = level;
        this.hp = hp1 + (level - 1) * growthHp;
        this.attack = attack1 + (level - 1) * growthAttack;
        this.defense = defense1 + (level - 1) * growthDefense;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setEvolutionLevel(int evolutionLevel) {
        this.evolutionLevel = evolutionLevel;
    }

    public void evolution() {
        if (evolutionLevel == -1) {
            // 더 이상 진화할 수 없는 최종 개체
            return;
        } else {
            if (level == evolutionLevel) {
                // 진화 로직 구현
                // 기존 포켓몬 삭제 및 진화한 포켓몬으로 대체
            }
        }
    }

    public static Monster[] loadMonstersFromFile(String filename) {
        try {
            ArrayList<Monster> monsters = new ArrayList<>();
            Scanner scanner = new Scanner(new File(filename));
            scanner.nextLine(); // 첫 줄은 헤더 (번호,포켓몬,...)이므로 건너뜀

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");
                int number = Integer.parseInt(values[0]);
                String name = values[1];
                String realname = values[2];
                int level1 = Integer.parseInt(values[3]);
                int level = Integer.parseInt(values[4]);
                String type = values[5];
                int hp1 = Integer.parseInt(values[6]);
                int attack1 = Integer.parseInt(values[7]);
                int defense1 = Integer.parseInt(values[8]);
                int speed = Integer.parseInt(values[9]);
                int growthHp = Integer.parseInt(values[10]);
                int growthAttack = Integer.parseInt(values[11]);
                int growthDefense = Integer.parseInt(values[12]);
                int evolutionLevel = Integer.parseInt(values[13]);

                Monster monster = new Monster(number, name, realname, level1, level, type, hp1, attack1, defense1,
                        speed, growthHp, growthAttack, growthDefense, evolutionLevel);
                monsters.add(monster);
            }

            //0번: 넘버 1번: 종족명 2번: 개체이름 3번:1레벨 4번:개체의 레벨 5번:종족
            //6번: 1레벨 체력 7번:1레벨 공격력 체력 8번:1레벨 방어력 9번: 스피드
            //10번: 성장체 11번: 성장공 12번: 성장방 13번 진화레벨
            
            scanner.close();

            Monster[] monsterArray = new Monster[monsters.size()];
            monsters.toArray(monsterArray);
            return monsterArray;
            
            
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}

