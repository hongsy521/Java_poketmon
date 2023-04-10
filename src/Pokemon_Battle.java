import java.util.Scanner;

public class Battle {
	
	private Pokemon MyPokemon;
	private Pokemon EnemyPokemon;
	
	public Battle(Pokemon MyPokemon, Pokemon EnemyPokemon) {
		this.MyPokemon=MyPokemon;
		this.EnemyPokemon=EnemyPokemon;
	}
	
	
	public static void PokemonBattle() {
		System.out.println("상대 트레이너가 나타났다!!");
		while(true) {
			 if (MyPokemon.getSpeed() >= EnemyPokemon.getSpeed()) {
                MyTurn();
                if (BattleEnd()==0) {
                    break;
                }
                EnemyTurn();
                if (BattleEnd()==0) {
                    break;
                }
            }
			 else {
                EnemyTurn();
                if (BattleEnd()==0) {
                    break;
                }

                MyTurn();
                if (BattleEnd()==0) {
                    break;
                }
            }
		}
		if() {
			Win();
		}
		else(){
			Lose();
		}
	}
	
	public static void MyTurn() {
		while(true) {
			System.out.println("1.공격하기 2.아이템 사용 3.교체 4.기권");
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			if(choice>5) {
				System.out.println("다시 선택하세요");
				break;
			}
			switch(choice) {
			case 1:
				Attack();
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
        		BattleEnd();
        		Lose();
			}
		}
	}
	
	public static void EnemyTurn() {
		System.out.println("적이 공격합니다.");
		Attack();
	}
	
	public static void Attack() {
		
	}
	
	public static void UseItem() {
		
	}
	
	public static void ChangePokemon() {
		
	}
	
	public static int BattleEnd() {
		
		return 0;
	}
	
	public static void Win() {
		System.out.println("축하합니다! 배틀에서 승리했습니다!");
	}
	
	public static void Lose() {
		System.out.println("배틀에서 졌습니다...");
		System.out.println("돈을 일부 잃어버립니다...");
	}

	
	
}
