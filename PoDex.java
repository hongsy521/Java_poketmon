package PokemonFolder14;
import java.util.*;
import java.io.*;

public class PoDex extends Monster {
    HashMap<Integer, Optional<String>> dex = new HashMap<>();

    public PoDex() {
        super();  // Monster의 기본 생성자 호출
        for (int i = 1; i <= 59; i++) {
            dex.put(i, Optional.empty());  // Optional.empty()로 초기화
        }
    }

    public void setEncountered(int number, boolean encountered) {
        if (encountered) {
            dex.put(number, Optional.of("yes"));  // 만났으면 "yes"로 설정
        } else {
            dex.put(number, Optional.ofNullable(null));  // 만나지 않았으면 null로 설정
        }
    }

    public boolean hasEncountered(int number) {
        return dex.get(number).orElse(null) != null;  // 만났는지 여부 확인
    }

    public void displayPodex() {
        System.out.println("=======================");
        System.out.println("포켓몬 도감 정보입니다.");
        int encounteredCount = 0;    // 포켓몬 도감 수

        for (int number : dex.keySet()) {
            Optional<String> optionalEncountered = dex.get(number);
            if (optionalEncountered.isPresent()) {
                String encountered = optionalEncountered.get();
                if (encountered.equals("yes")) {    // 만난 포켓몬인 경우
                    encounteredCount++;
                    String species = getSpeciesByNumber(number);  // 포켓몬 종족명 가져오기
                    System.out.printf("포켓몬 번호: %d 포켓몬 종족: %s // 배틀의 여부: %s\n", number, species, encountered);
                }
            }
        }
        System.out.printf("지금까지 만난 포켓몬은 %d마리 입니다.\n", encounteredCount);
    }

    private String getSpeciesByNumber(int number) {
        // 포켓몬 종족명을 가져오는 로직 구현
        // 여기에서 적절한 방식으로 포켓몬 종족명을 가져와서 반환하세요.
        // 예: return "이상해씨";
        // 실제로는 데이터 파일이나 다른 데이터 저장 방식을 사용하여 종족명을 가져와야 합니다.
        return "미구현";  // 이 부분을 적절한 로직으로 대체해야 합니다.
    }
}





