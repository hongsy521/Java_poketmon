package PokemonFolder14;

public class Start {
    public static void main(String[] args) {
        // 객체 생성
        PlayerInfo playerInfo = new PlayerInfo();
        SaveLoad saveLoad = new SaveLoad();
        PoDex podex = new PoDex();
        PoCenter pokemonCenter = new PoCenter();
        MonsterData monsterData = new MonsterData();

        Battle_Mode battleMode = new Battle_Mode(monsterData);
        Collection_Mode collectionMode = new Collection_Mode(monsterData);

        // 메뉴 객체 생성 및 실행
        Menu menu = new Menu(playerInfo, saveLoad, podex, pokemonCenter);
        menu.displayMenu();
    }
}