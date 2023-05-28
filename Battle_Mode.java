package PokemonFolder14;

import java.util.*;
import java.io.*;

public class Battle_Mode{
	
	public Battle_Mode() {
		
	}
	
	public Battle_Mode(PlayerInfo playerinfo, MonsterData monsterdata, PoDex podex,
					Calculator cal, Monster monster)
	{
		
	}
	void doBattle(){
    try {
        InputStream is = Battle_Mode.class.getResourceAsStream("/ioEx0521/info.txt");
        Scanner sc = new Scanner(is);

        // 첫 줄은 헤더 정보이므로 읽고 버립니다
        if (sc.hasNextLine()) {
            sc.nextLine();
        }

        int MAX_POKEMON = 60;
        int len = 0; // 포켓몬 수를 추적하는 변수

        String[][] info = new String[MAX_POKEMON][6];
        int[] winner = new int[MAX_POKEMON];

        while (sc.hasNextLine() && len < MAX_POKEMON) {
            String line = sc.nextLine();
            StringTokenizer token = new StringTokenizer(line, ",");

            int infoLen = token.countTokens();
            for (int i = 0; i < infoLen; i++) {
                if (token.hasMoreTokens()) {
                    info[len][i] = token.nextToken();
                }
            }

            if (infoLen == 6) {
                System.out.println(info[len][0] + "번째 포켓몬: " + info[len][1]);
                System.out.println("Attack: " + info[len][2] + " Defense: " + info[len][3] + " HP: " + info[len][4]
                        + " 속성: " + info[len][5]);
                System.out.println();
            }

            len++;
        }

        is.close();
        sc.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
	}