package PokemonFolder14;

import java.util.ArrayList;

public class MonsterData {
    private ArrayList<Monster> monsters;
    private ArrayList<Monster> collectedMonsters;
    private String saveName;

    public MonsterData() {
        this.monsters = new ArrayList<>();
        this.collectedMonsters = new ArrayList<>();

        // 포켓몬 데이터를 추가하세요.
        // 예시: monsters.add(new Monster("이름", 레벨, "타입", HP, 공격력, 속도, 성장 체력, 성장 공격력, 진화 레벨));
        monsters.add(new Monster("피카츄", 5, "전기", 35, 55, 40, 3, 3, 16));
        monsters.add(new Monster("이상해씨", 5, "풀", 45, 49, 45, 2, 2, 16));
        monsters.add(new Monster("꼬부기", 5, "물", 44, 48, 43, 2, 2, 16));
        monsters.add(new Monster("파이리", 5, "불꽃", 39, 52, 65, 2, 2, 16));
        monsters.add(new Monster("버터플", 5, "벌레", 45, 30, 70, 2, 2, 16));
        monsters.add(new Monster("야도란", 5, "노말", 60, 60, 90, 3, 3, 16));
        // 추가 포켓몬 데이터를 계속해서 추가해주세요.
    }

    // 포켓몬 목록을 반환하는 메서드
    public ArrayList<Monster> getPokemonList() {
        return monsters;
    }

    // 수집한 포켓몬 목록을 반환하는 메서드
    public ArrayList<Monster> getCollectedPokemonList() {
        return collectedMonsters;
    }

    // 수집한 포켓몬 목록에 포켓몬을 추가하는 메서드
    public void addCollectedPokemon(Monster pokemon) {
        collectedMonsters.add(pokemon);
    }

    // 다른 포켓몬을 가져오거나 다른 작업을 수행하는 메서드를 추가하세요.
}

class Monster {
    private String name;
    private int level;
    private String type;
    private int hp;
    private int attack;
    private int speed;
    private int growthHp;
    private int growthAttack;
    private int evolutionLevel;

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

    public String getName() {
        return this.name;
    }

    public int getLevel() {
       return this.level;
    }
}