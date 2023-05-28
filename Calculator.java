package PokemonFolder14;
import java.util.*;
import java.io.*;

public class Calculator {
	public Calculator() {
		
	}
	
	public static double calculate(String attack_type, String defense_type) {	//메서드임
		String ad=attack_type;
		String de=defense_type;
		switch (ad) {
			case "노말":
				switch (de){
                    case "바위":
                    case "고스트":
                    case "강철":
                    return 0.8;

                    default:
                    return 1.0;
                }
			case "격투":
                switch (de){
                    case "노말":
                    case "바위":
                    case "강철":
                    case "얼음":
                    case "악":
                    return 1.25;

                    case "비행":
                    case "독":
                    case "벌레":
                    case "고스트":
                    case "에스퍼":
                    case "페어리":
                    return 0.8;

                    default:
                    return 1.0;
                }
			
			case "비행":
				switch (de){
                    case "격투":
                    case "벌레":
                    case "풀":
                    return 1.25;

                    case "바위":
                    case "강철":
                    case "전기":
                    return 0.8;

                    default:
                    return 1.0;
                }
			case "독":
                switch (de){
                    case "풀":
                    case "페어리":
                    return 1.25;

                    case "독":
                    case "땅":
                    case "바위":
                    case "고스트":
                    case "강철":
                    case "전기":
                    return 0.8;

                    default:
                    return 1.0;
                }
			case "땅":
                switch (de){
                    case "독":
                    case "바위":
                    case "강철":
                    case "불꽃":
                    case "전기":
                    return 1.25;

                    case "비행":
                    case "벌레":
                    case "풀":
                    return 0.8;

                    default:
                    return 1.0;
                }
            case "바위":
                switch (de){
                    case "비행":
                    case "벌레":
                    case "불꽃":
                    case "얼음":
                    return 1.25;

                    case "격투":
                    case "땅":
                    case "강철":
                    return 0.8;

                    default:
                    return 1.0;
                }
            case "벌레":
                switch (de){
                    case "풀":
                    case "에스퍼":
                    case "악":
                    return 1.25;

                    case "격투":
                    case "비행":
                    case "독":
                    case "고스트":
                    case "강철":
                    case "불꽃":
                    case "페어리":
                    return 0.8;

                    default:
                    return 1.0;
                }

            case "고스트":
                switch (de){
                    case "고스트":
                    case "에스퍼":
                    return 1.25;

                    case "노말":
                    case "악":
                    return 0.8;

                    default:
                    return 1.0;
                }

            case "강철":
                switch(de){
                    case "바위":
                    case "얼음":
                    return 1.25;

                    case "강철":
                    case "불꽃":
                    case "물":
                    case "전기":
                    return 0.8;

                    default:
                    return 1.0;
                }

            case "불꽃":
                switch(de){
                    case "벌레":
                    case "강철":
                    case "풀":
                    case "얼음":
                    return 1.25;

                    case "바위":
                    case "불꽃":
                    case "물":
                    case "드래곤":
                    
                    return 0.8;

                    default:
                    return 1.0;
                }
            case "물":
                 switch(de){
                    case "땅":
                    case "바위":
                    case "불꽃":
                    return 1.25;

                    case "물":
                    case "풀":
                    case "드래곤":
                    return 0.8;

                    default:
                    return 1.0;
                }
            
            case "풀":
                switch(de){
                    case "땅":
                    case "바위":
                    case "물":
                    return 1.25;

                    case "비행":
                    case "독":
                    case "벌레":
                    case "강철":
                    case "불꽃":
                    case "풀":
                    case "드래곤":
                    return 0.8;

                    default:
                    return 1.0;
                }
            case "전기":
              switch(de){
                    case "비행":
                    case "물":
                    return 1.25;

                    case "땅":
                    case "풀":
                    case "전기":
                    case "드래곤":
                    return 0.8;

                    default:
                    return 1.0;
                }

            case "에스퍼":
                  switch(de){
                    case "격투":
                    case "독":
                    return 1.25;

                    case "강철":
                    case "에스퍼":
                    case "악":
                    return 0.8;

                    default:
                    return 1.0;
                }

            case "얼음":
                  switch(de){
                    case "비행":
                    case "땅":
                    case "풀":
                    case "드래곤":
                    return 1.25;

                    case "강철":
                    case "불꽃":
                    case "물":
                    case "얼음":
                    return 0.8;

                    default:
                    return 1.0;
                }

            case "드래곤":
              switch(de){
                    case "드래곤":
                    return 1.25;

                    case "강철":
                    case "페어리":
                    return 0.8;

                    default:
                    return 1.0;
                }

            case "악":
                  switch(de){
                    case "고스트":
                    case "에스퍼":
                    return 1.25;
                    
                    case "격투":
                    case "악":
                    case "페어리":
                    return 0.8;

                    default:
                    return 1.0;
                }
            case "페어리":
              switch(de){
                    case "격투":
                    case "드래곤":
                    case "악":
                    return 1.25;

                    case "독":
                    case "강철":
                    case "불꽃":
                    return 0.8;

                    default:
                    return 1.0;
                }
            
            default:
            return 1;
		}
	}	
}