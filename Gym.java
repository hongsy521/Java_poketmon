import java.util.Scanner;

public class Gym {
	
	public class FireGymLeader {
	    private String name;
	    private Pokemon[] pokemons;

	    public FireGymLeader(String name) {
	        this.name = name;
	        this.pokemons = new Pokemon[] {
	            new Pokemon("리자드", "불", 100, 1, 20, 20),
	            new Pokemon("불꽃숭이", "불", 100, 1, 10, 10),
	            new Pokemon("뚜꾸리", "불", 100, 1, 10, 10)
	        };
	    }
	    public String getName() {
	        return name;
	    }

	    public Pokemon[] getPokemons() {
	        return pokemons;
	    }
	}
	    
	    public class WaterGymLeader {
	    	private String name;
	    	private Pokemon[] pokemons;

	    	public WaterGymLeader(String name) {
	    		this.name = name;
	    		this.pokemons = new Pokemon[] {
	    				new Pokemon("꼬부기", "물", 100, 1, 10, 10),
	    				new Pokemon("물짱이", "물", 100, 1, 10, 10),
	    				new Pokemon("팽도리", "물", 100, 1, 10, 10)
	    		};
	    		
	    	}

	    public String getName() {
	        return name;
	    }

	    public Pokemon[] getPokemons() {
	        return pokemons;
	    }
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
		
		public static void getBadge() {
			
		}

		
		public static void main(String[] args) {
			System.out.println("상대 트레이너가 나타났다!!");
			System.out.println("상대 트레이너는 "+ FireGymLeader.pokemons[0] +"을 내보냈다!!");
			
			while(true) {
				System.out.println("1.공격하기 2.아이템 사용 3.교체 4.기권");
				Scanner scanner = new Scanner(System.in);
				int choice = scanner.nextInt();
				if(choice>5) {
					System.out.println("다시 선택하세요");
					continue;
				}
				switch(choice) {
				case 1:
					System.out.println(MyPokemon+"이/가 공격합니다.");
					Attack();
					break;
				case 2:
					UseItem();
					break;
				case 3:
					ChangePokemon();
					break;
				case 4:
	        		BattleEnd();
	        		Lose();
	        		break;
				}
				
			}
			
			if(FireGymLeader.pokemons==0) {
				Win();
			}
			else(MyPokemon==0){
				Lose();
			}
		}

}
