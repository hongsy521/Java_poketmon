package PokemonFolder14;

import java.util.Scanner;

public class Battle_Mode {
	static int MyPokemon[] = new int[3];
	static int EnemyPokemon[]= new int[3];
	
	
	public static int choosePokemon() {			//내 포켓몬중 배틀에 사용할 포켓몬 3마리 선택
		
		return 
	}
	
	public static void MyTurn() {
		while(true) {
			System.out.println("1.공격하기 2.아이템 사용 3.교체 4.기권");	//내 턴에 할 일 선택
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			if(choice>5) {
				System.out.println("다시 선택하세요");
				continue;
			}
			switch(choice) {
			case 1:		//공격
				Attack();
				break;
			case 2:		//회복약 사용
				UseItem();
				break;
			case 3:		//교체
				if() {		//교체할 포캣몬이 남은 경우
					ChangePokemon();
					break;
				}
				else {		//교체할 포켓몬이 없는 경우
					System.out.println("교체할 수 있는 포켓몬이 없습니다.");
					continue;
				}	
			case 4:		//기권
        		BattleEnd();
        		Lose();
        		break;
			}
		}
	}
	
	public static void EnemyTurn() {				//상대는 공격만 가능
		System.out.println("적 포켓몬이 공격합니다.");
		if() {			//상성 우위

			MyPokemon.hp -= (EnemyPokemon.attack)*1.5;		//데미지 1.5배
			System.out.println("데미지가 굉장합니다!");
		}	
		else if() {		//상성 보통

			MyPokemon.hp -= EnemyPokemon.attack;			//데미지 1배
			System.out.println("데미지가 평범합니다.");
		}	
		else {			//상성 열위

			MyPokemon.hp -= (EnemyPokemon.attack)*0.5;		//데미지 0.5배
			System.out.println("데미지가 별로입니다...");
		}
	}
	
	public static void Attack() {
		System.out.println(MyPokemon+"이/가 공격합니다.");
		if() {			//상성 우위

			EnemyPokemon.hp -= (MyPokemon.attack)*1.5;		//데미지 1.5배
			System.out.println("데미지가 굉장합니다!");
		}	
		else if() {		//상성 보통

			EnemyPokemon.hp -= MyPokemon.attack;			//데미지 1배
			System.out.println("데미지가 평범합니다.");
		}	
		else {			//상성 열위

			EnemyPokemon.hp -= (MyPokemon.attack)*0.5;		//데미지 0.5배
			System.out.println("데미지가 별로입니다...");
		}	
	}
	
	public static void UseItem() {
		Pokemon_center item = new Pokemon_center();
		System.out.println("체력이 30회복합니다.");				//체력 회복(회복 수치 변경할 수도)
		item.remedy--;										//회복약 개수 -1
	}
	
	public static void ChangePokemon() {
		System.out.println("교체할 포켓몬을 골라주세요.");			
	}
	
	public static int BattleEnd() {							//상대,내 포켓몬 없는 경우 전투 종료
		
		return 0;
	}
	
	public static void Win() {
		Pokemon_center item = new Pokemon_center();
		System.out.println("축하합니다! 배틀에서 승리했습니다!");
		System.out.println("보상으로 아이템을 얻습니다!");			//승리 보상
		item.candy++;										//이상한 사탕 얻기
		item.money+=1000;									//돈 얻기
	}
	
	public static void Lose() {
		Pokemon_center item = new Pokemon_center();
		System.out.println("배틀에서 졌습니다...");
		System.out.println("돈을 일부 잃어버립니다...");
		item.money-=500;									//패배시돈 잃음
		
	}

	
	public static void main(String[] args) {
		
		System.out.println("배틀에 이용할 포켓몬 3마리를 골라주세요");		//배틀에 이용할 포켓몬 선택
		for(int i=0;i<3;i++) {
			MyPokemon[i]=choosePokemon();
		}
		
		
		System.out.println("상대 트레이너가 나타났다!!");
		System.out.println("상대 트레이너는 "+ EnemyPokemon +"을 내보냈다!!");
		
		while(true) {
			 if (MyPokemon.getSpeed() >= EnemyPokemon.getSpeed()) {		//스피드 빠른 포켓몬부터 턴 시작
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
		
		if(EnemyPokemon==0) {		//상대 포켓몬 없으면 승리
			Win();
		}
		else(MyPokemon==0){			//내 포켓몬 없으면 패배
			Lose();
		}
	}
}
