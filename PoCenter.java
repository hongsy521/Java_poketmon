package PokemonFolder14;

import java.util.Scanner;
public class Pocenter {
    private int store_candy; //사탕
    private int player_money; //돈
    private int store_pokemonBall; //포켓몬볼
    private int store_remedy; //상처약
    private String player_changedName; //이름변경

    public Pocenter(int store_candy, int store_remedy,int store_pokemonBall, int player_money) {
        this.store_candy = store_candy;
        this.store_remedy = store_remedy;
        this.store_pokemonBall = store_pokemonBall;
        this.player_money = player_money;
        System.out.println("사탕을" + this.store_candy + "개 구매하여" + this.player_money + "원이 지갑에 있습니다.");
    }
    public void change_Name(String player_changedName){  //이름 변경 메소드 - 변경할 이름 입력 받은 후 변경
        Scanner scanner=new Scanner(System.in);
        System.out.println("변경할 이름을 작성해주세요.");
        this.player_changedName = scanner.next();
        System.out.println(player_changedName+"로 이름이 변경되었습니다.");
    }
    Pocenter center=new Pocenter( 0,0,0,10000);
    Pocenter purchase=new Pocenter();
    Pocenter price=new Pocenter();
    public void center_Store() {  //상점에서 구매할 물품 선택 메소드 - case 나눠 사탕/상처약/포켓몬볼 각각의 경우 선택 후 진행
        Scanner scanner = new Scanner(System.in);
        System.out.println("무엇을 구매하시겠습니까? 1)사탕:2000원 2)상처약:1000원 3)포켓몬볼:500원");
        int purchase = scanner.nextInt();
        System.out.println("구매할 수량을 입력해주세요.");
        int count=scanner.nextInt(System.in);
        switch (purchase) {
            case 1:
                int price1=2000*count;
                System.out.println("사탕을"+count+"개 구매하였습니다. "+price1+"원을 지불합니다.");
                break;

            case 2:
                int price2=1000*count;
                System.out.println("상처약을"+count+"개 구매하였습니다. "+price2+"원을 지불합니다.");
                break;

            case 3:
                int price3=500*count;
                System.out.println("포켓몬볼을"+count+"개 구매하였습니다. "+price3+"원을 지불합니다.");
                break;

        }
    }
    public void change_Money(){  //지갑 메소드 - 상점에서 물품 구매 후 지갑에 남는 돈 계산
        player_money-=price;
        System.out.println("현재 지갑에"+player_money+"원이 있습니다.");
    }
    public void change_Level(){  //레벨업 메소드 - 사탕으로 레벨업
        Pocenter newLevel=new Pocenter();
        System.out.println("사탕을 먹고 레벨업하시겠습니까? Y/N");
        float choice1=scanner.next();
        switch(choice1){
            case Y:
                newLevel+=level;
                level=newLevel;
                System.out.println("레벨이"+level+"이 되었습니다.");
                break;
        }
            case N:
                break;
    }
    public void change_HP(){  //HP회복 메소드 - 상처약으로 HP회복
        Pocenter newHP=new Pocenter();
        System.out.println("상처약으로 HP를 회복하시겠습니까? Y/N");
        float choice2=scanner.next();
        switch(choice2){
            case Y:

                System.out.println("HP가"+newHP+"되었습니다.");
                break;
            case N:
                break;

        }
    }
}

