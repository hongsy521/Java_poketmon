package PokemonFolder14;

import java.util.Scanner;

public class Menu {
    private PlayerInfo playerInfo;
    private SaveLoad saveLoad;
    private PoDex podex;
    private PoCenter pokemonCenter;
    private Battle_Mode battleMode;
    private Collection_Mode collectionMode;

    public Menu(PlayerInfo playerInfo, SaveLoad saveLoad, PoDex podex, PoCenter pokemonCenter, Battle_Mode battleMode, Collection_Mode collectionMode) {
        this.playerInfo = playerInfo;
        this.saveLoad = saveLoad;
        this.podex = podex;
        this.pokemonCenter = pokemonCenter;
        this.battleMode = battleMode;
        this.collectionMode = collectionMode;
    }

    // 메뉴를 출력하고 사용자의 선택에 따라 다른 기능을 실행하는 메소드
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("메뉴를 선택하세요:");
            System.out.println("1. 내 정보 보기");
            System.out.println("2. 게임 저장");
            System.out.println("3. 게임 로드");
            System.out.println("4. 포켓몬 도감");
            System.out.println("5. 포켓몬 센터");
            System.out.println("6. 대전 모드");
            System.out.println("7. 수집 모드");
            System.out.println("8. 종료");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    playerInfo.showInfo();
                    break;
                case 2:
                    saveLoad.saveGame();
                    break;
                case 3:
                    saveLoad.loadGame();
                    break;
                case 4:
                    podex.displayPoDex();
                    break;
                case 5:
                    pokemonCenter.visitCenter();
                    break;
                case 6:
                    battleMode.startBattle();
                    break;
                case 7:
                    collectionMode.collectPokemon();
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 시도하세요.");
            }
        }
    }
}
