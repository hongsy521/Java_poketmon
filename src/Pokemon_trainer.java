import java.util.Scanner;

public class Pokemon_trainer {
	
	public int t_level;
	public int money;
	public int experience;
	
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		Trainer trainer = new Trainer();
		
		System.out.println("당신의 이름을 입력해주세요: ");
		String t_name = sc.next();
		System.out.println(t_name+"님의 모험이 시작됩니다.");
	
	}
	
}
}
