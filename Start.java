package PokemonFolder14;

public class Start {
    public static void main(String[] args) {
        // 객체 생성
        PlayerInfo playerInfo = new PlayerInfo();
        SaveLoad saveLoad = new SaveLoad();
        PoDex podex = new PoDex();
        Monster monster= new Monster();
        PoCenter pokemonCenter = new PoCenter();
        MonsterData monsterData = new MonsterData();
        Calculator cal=new Calculator();
        Battle_Mode battleMode = new Battle_Mode();
        Collection_Mode collectionMode = new Collection_Mode(monsterData);

        System.out.println("=======================");
        System.out.println("게임을 시작하겠습니다");
        System.out.println("환영합니다!!!!");

        // 메뉴 객체 생성 및 실행
        Menu menu = new Menu(playerInfo, saveLoad, podex, pokemonCenter,battleMode,collectionMode);
        menu.displayMenu();
        
    }
}