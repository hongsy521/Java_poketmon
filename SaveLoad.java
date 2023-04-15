package PokemonFolder14;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveLoad {
    private static final String SAVE_FILE = "pokemon_save.dat";

    public void saveGame() {
        try {
            FileOutputStream fos = new FileOutputStream(SAVE_FILE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            // 게임 데이터를 저장하세요.
            // 예를 들어, PlayerInfo, PoDex, MonsterData 등을 저장합니다.

            oos.close();
            fos.close();
            System.out.println("게임이 성공적으로 저장되었습니다.");
        } catch (Exception e) {
            System.out.println("게임 저장 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }

    public void loadGame() {
        try {
            FileInputStream fis = new FileInputStream(SAVE_FILE);
            ObjectInputStream ois = new ObjectInputStream(fis);

            // 저장된 게임 데이터를 로드하세요.
            // 예를 들어, PlayerInfo, PoDex, MonsterData 등을 로드합니다.

            ois.close();
            fis.close();
            System.out.println("게임이 성공적으로 로드되었습니다.");
        } catch (Exception e) {
            System.out.println("게임 로드 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }
}