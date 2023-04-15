package PokemonFolder14;

import java.util.Scanner;
import java.util.Random;

public class Collection_Mode {
    private MonsterData monsterData;

    public Collection_Mode(MonsterData monsterData) {
        this.monsterData = monsterData;
    }

    public void collectPokemon() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("수집 모드에 오신 것을 환영합니다!");

        // 포켓몬 발견
        int foundPokemonIndex = random.nextInt(monsterData.getPokemonList().size());
        Monster foundPokemon = monsterData.getPokemonList().get(foundPokemonIndex);
        System.out.println("포켓몬이 발견되었습니다! " + foundPokemon.getName() + "이(가) 나타났습니다.");

        System.out.println("1. 포켓몬을 잡는다. 2. 포켓몬을 쓰러뜨린다.");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // 포켓몬을 잡는 경우
                System.out.println(foundPokemon.getName() + "을(를) 잡았습니다!");
                monsterData.addCollectedPokemon(foundPokemon);
                break;
            case 2:
                // 포켓몬을 쓰러뜨리는 경우
                System.out.println(foundPokemon.getName() + "을(를) 쓰러뜨렸습니다!");
                break;
            default:
                System.out.println("잘못된 입력입니다. 다시 시도하세요.");
        }
    }
}