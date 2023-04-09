import java.util.Scanner;
public class Pokemon_center {
    public int candy; //사탕
    public int money; //돈
    public int pokemonBall; //포켓몬볼
    public int remedy; //상처약

    public Pokemon_center(int candy, int remedy,int pokemonBall, int money) {
        this.candy = candy;
        this.remedy = remedy;
        this.pokemonBall = pokemonBall;
        this.money = money;
        System.out.println("사탕을" + candy + "개 구매하여" + money + "원이 지갑에 있습니다.");
    }
    Pokemon_center center=new Pokemon_center(0,0,0,10000);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("무엇을 구매하시겠습니까? 1)사탕 2)상처약 3)포켓몬볼");
        int purchase = scanner.nextInt();
        switch (purchase) {
            case 1:
                System.out.println("구매할 사탕의 수량을 선택하세요. 3개(Lv1상승):1000원/ 6개(Lv3상승):2000원/ 10개(Lv5상승):4000원");
                int candy = scanner.nextInt();

                System.out.println("사탕을"+candy+"개 구매하였고 현재 지갑에 돈이"+"원 있습니다.");
                break;

            case 2:
                System.out.println("구매할 상처약의 수량을 입력하세요. 1개:500원/ 3개:1000원/ 5개:2000원");
                int remedy = scanner.nextInt();
                System.out.println("상처약을"+remedy+"개 구매하였고 현재 지갑에 돈이"+"원 있습니다.");
                break;

            case 3:
                System.out.println("구매할 포켓몬볼의 수량을 입력하세요. 1개:500원/ 3개:1000원/ 5개:2000원");
                int pokemonBall = scanner.nextInt();
                System.out.println("포켓몬볼을"+pokemonBall+"개 구매하였고 현재 지갑에 돈이"+"원 있습니다.");
                break;


        }
    }
}
