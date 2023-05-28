package PokemonFolder14;

import java.io.*;
import java.util.*;
public class SaveLoad {
    private static final String SAVE_FILE = "pokemon_save.dat";

    public void saveGame(PlayerInfo playerInfo, PoDex podex, MonsterData monsterData) {
        try {
            FileOutputStream fos = new FileOutputStream(SAVE_FILE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(playerInfo);
            oos.writeObject(podex);
            oos.writeObject(monsterData);

            oos.close();
            fos.close();
            System.out.println("게임이 성공적으로 저장되었습니다.");
        } catch (IOException e) {
            System.out.println("게임 저장 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }
  
    public void loadGame(PlayerInfo playerInfo, PoDex podex, MonsterData monsterData) {
        try {
            FileInputStream fis = new FileInputStream(SAVE_FILE);
            ObjectInputStream ois = new ObjectInputStream(fis);

            playerInfo = (PlayerInfo) ois.readObject();
            podex = (PoDex) ois.readObject();
            monsterData = (MonsterData) ois.readObject();

            ois.close();
            fis.close();
            System.out.println("게임이 성공적으로 로드되었습니다.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("게임 로드 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }
}


