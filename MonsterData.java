package PokemonFolder14;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PokemonDataLoader {
    public static List<Monster> loadMonsterData(String filename) {
        List<Monster> monsterList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length >= 9) {
                    String name = tokens[1];
                    int level = Integer.parseInt(tokens[2]);
                    String type = tokens[3];
                    int hp = Integer.parseInt(tokens[4]);
                    int attack = Integer.parseInt(tokens[5]);
                    int speed = Integer.parseInt(tokens[6]);
                    int growthHp = Integer.parseInt(tokens[7]);
                    int growthAttack = Integer.parseInt(tokens[8]);
                    int evolutionLevel = Integer.parseInt(tokens[9]);

                    Monster monster = new Monster(name, level, type, hp, attack, speed, growthHp, growthAttack, evolutionLevel);
                    monsterList.add(monster);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return monsterList;
    }

    public static void main(String[] args) {
        List<Monster> monsterList = loadMonsterData("monster_Info.txt");

        for (Monster monster : monsterList) {
            System.out.println("이름: " + monster.getName());
            System.out.println("레벨: " + monster.getLevel());
            System.out.println("타입: " + monster.getType());
            System.out.println("HP: " + monster.getHp());
            System.out.println("공격력: " + monster.getAttack());
            System.out.println("스피드: " + monster.getSpeed());
            System.out.println("HP 성장도: " + monster.getGrowthHp());
            System.out.println("공격력 성장도: " + monster.getGrowthAttack());
            System.out.println("진화 레벨: " + monster.getEvolutionLevel());
            System.out.println();
        }
    }
}
