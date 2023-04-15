package PokemonFolder14;

import java.util.ArrayList;

public class MonsterData {
    private ArrayList<Monster> monsters;
    private ArrayList<Monster> collectedMonsters;

    public MonsterData() {
        this.monsters = new ArrayList<>();
        this.collectedMonsters = new ArrayList<>();

        // 포켓몬 데이터를 추가하세요.
        // 예시: monsters.add(new Monster("이름", 레벨, "타입", HP, 공격력, 속도, 성장 체력, 성장 공격력, 진화 레벨));
        monsters.add(new Monster("피카츄", 5, "전기", 35, 55, 40, 3, 3, 16));
        monsters.add(new Monster("이상해씨", 5, "풀", 45, 49, 45, 2, 2, 16));
        // 다른 포켓몬 데이터를 추가하세요.
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