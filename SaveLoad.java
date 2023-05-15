package PokemonFolder14;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;

public class SaveLoad {
    private static final String SAVE_FILE = "pokemon_save.dat";

    public void saveGame(PlayerInfo playerInfo, PoDex podex, MonsterData monsterData) {
        try {
            String homeDirectory = System.getProperty("user.home");
            File saveFile = new File(homeDirectory, SAVE_FILE);

            FileOutputStream fos = new FileOutputStream(saveFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(playerInfo);
            oos.writeObject(podex);
            oos.writeObject(monsterData);

            oos.close();
            fos.close();
            System.out.println("게임이 성공적으로 저장되었습니다.");
        } catch (Exception e) {
            System.out.println("게임 저장 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }
  
    public void loadGame(PlayerInfo playerInfo, PoDex podex, MonsterData monsterData) {
        try {
            String homeDirectory = System.getProperty("user.home");
            File saveFile = new File(homeDirectory, SAVE_FILE);

            FileInputStream fis = new FileInputStream(saveFile);
            ObjectInputStream ois = new ObjectInputStream(fis);

            playerInfo.copy((PlayerInfo) ois.readObject());
            podex.copy((PoDex) ois.readObject());
            monsterData.copy((MonsterData) ois.readObject());

            ois.close();
            fis.close();
            System.out.println("게임이 성공적으로 로드되었습니다.");
        } catch (Exception e) {
            System.out.println("게임 로드 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }
}
