import java.util.Scanner;

public class Gym {
	
	public class FireGymLeader {
	    private String name;
	    private Pokemon[] pokemons;

	    public FireGymLeader(String name) {
	        this.name = name;
	        this.pokemons = new Pokemon[] {
	            new Pokemon("���ڵ�", "��", 100, 1, 20, 20),
	            new Pokemon("�Ҳɼ���", "��", 100, 1, 10, 10),
	            new Pokemon("�Ѳٸ�", "��", 100, 1, 10, 10)
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
	    				new Pokemon("���α�", "��", 100, 1, 10, 10),
	    				new Pokemon("��¯��", "��", 100, 1, 10, 10),
	    				new Pokemon("�ص���", "��", 100, 1, 10, 10)
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
			System.out.println("�����մϴ�! ��Ʋ���� �¸��߽��ϴ�!");
		}
		
		public static void Lose() {
			System.out.println("��Ʋ���� �����ϴ�...");
			System.out.println("���� �Ϻ� �Ҿ�����ϴ�...");
		}
		
		public static void getBadge() {
			
		}

		
		public static void main(String[] args) {
			System.out.println("��� Ʈ���̳ʰ� ��Ÿ����!!");
			System.out.println("��� Ʈ���̳ʴ� "+ FireGymLeader.pokemons[0] +"�� �����´�!!");
			
			while(true) {
				System.out.println("1.�����ϱ� 2.������ ��� 3.��ü 4.���");
				Scanner scanner = new Scanner(System.in);
				int choice = scanner.nextInt();
				if(choice>5) {
					System.out.println("�ٽ� �����ϼ���");
					continue;
				}
				switch(choice) {
				case 1:
					System.out.println(MyPokemon+"��/�� �����մϴ�.");
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
