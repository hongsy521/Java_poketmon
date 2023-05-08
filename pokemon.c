#define _CRT_SECURE_NO_WARNINGS
#include "pokemon.h"
#include <string.h>
#include <stdlib.h>
#include <stdio.h>
#include <time.h>
#include <Windows.h>

Pokemon* read_pokemon_list(char* filename) {
    FILE* fp;
    int num_pokemon;
    char line[50];
    char* token;
    Pokemon* pokemon_list;

    fp = fopen(filename, "r");
    if (fp == NULL) {
        printf("Error: %s 파일을 찾을 수 없습니다\n", filename);
        return NULL;
    }

    if (fscanf(fp, "%d\n", &num_pokemon) != 1) {
        printf("Error: 포켓몬 수를 읽는 중 오류가 발생했습니다\n");
        fclose(fp);
        return NULL;
    }

    pokemon_list = (Pokemon*)malloc(num_pokemon * sizeof(Pokemon));
    if (pokemon_list == NULL) {
        printf("Error: pokemon_list를 생성하는 중 오류가 발생했습니다\n");
        fclose(fp);
        return NULL;
    }

    for (int i = 0; i < num_pokemon; i++) {
        if (fgets(line, sizeof(line), fp) == NULL) {
            printf("Error: 포켓몬 정보를 읽는 중 오류가 발생했습니다\n");
            fclose(fp);
            free(pokemon_list);
            return NULL;
        }
        token = strtok(line, "|");
        strcpy(pokemon_list[i].name, token);
        token = strtok(NULL, "|");
        strcpy(pokemon_list[i].type, token);    
        token = strtok(NULL, "|");
        pokemon_list[i].min_attack = atoi(token);
        token = strtok(NULL, "|");
        pokemon_list[i].min_hp = atoi(token);
    }

    fclose(fp);
    return pokemon_list;
}

int start_game(PlayerInfo myInfo) {
    FILE* fp = NULL;
    fp = fopen("pokemonekknock.dat", "w");
    if (fp == NULL) {
        printf("파일을 열 수 없습니다.\n");
        return 0;
    }
    fwrite(&myInfo, sizeof(PlayerInfo), 1, fp);
    fclose(fp);
    return 1;
}

void save_game(PlayerInfo myInfo) {
    FILE* fp = NULL;
    fp = fopen("pokemonekknock.dat", "a");
    if (fp == NULL) {
        printf("파일을 열 수 없습니다.\n");
        return;
    }
    fwrite(&myInfo, sizeof(PlayerInfo), 1, fp);
    fclose(fp);
}

PlayerInfo* load_game(PlayerInfo* myInfo) {
    FILE* fp = NULL;
    fp = fopen("pokemonekknock.dat", "r");
    if (fp == NULL) {
        printf("파일을 열 수 없습니다.\n");
        return NULL;
    }
    fread(myInfo, sizeof(PlayerInfo), 1, fp);
    fclose(fp);
    return myInfo;
}




int end(PlayerInfo* player) {

}

void print_pokemon(Pokemon pokemon) {
    printf("%s (%s) - Attack: %d / HP: %d\n", pokemon.name, pokemon.type, pokemon.min_attack, pokemon.min_hp);
}

void print_pokemon_list(Pokemon* pokemons, int count) {
    for (int i = 0; i < count; i++) {
        printf("%d: ", i + 1);
        print_pokemon(pokemons[i]);
    }
}



int add(PlayerInfo* player, Pokemon* enemy_pokemon) {
    
    for (int i = 0; i < 6; i++) {
        if (&player->my_pokemon_list[i] == NULL) {
            strcpy(player->my_pokemon_list[i].name, enemy_pokemon->name);
            strcpy(player->my_pokemon_list[i].nickname, enemy_pokemon->nickname);
            strcpy(player->my_pokemon_list[i].type, enemy_pokemon->type);
            player->my_pokemon_list[i].min_attack = enemy_pokemon->min_attack;
            player->my_pokemon_list[i].min_hp = enemy_pokemon->min_hp;
            player->my_pokemon_list[i].max_hp = enemy_pokemon->max_hp;
            return i;
        }
       
    }
}



int select(PlayerInfo* player) {
    int i, size, choice;
    int cnt = 0;
    size = strlen(player->my_pokemon_list);
  
    while (1) {
        printf("사용할 포켓몬을 선택하세요\n");
        for (i = 0; i < size + 1; i++) {
            printf("%d. %s (%s) - Attack: %d / HP: %d / %d\n", i + 1, player->my_pokemon_list[i].name, player->my_pokemon_list[i].type,
                player->my_pokemon_list[i].min_attack, player->my_pokemon_list[i].min_hp, player->my_pokemon_list[i].max_hp);
        }
        scanf("%d", &choice);       //다시짜

        if (player->my_pokemon_list[choice - 1].min_hp <= 0) {
            printf("선택할 수 없습니다. 다시 선택해 주세요. \n");
            continue;
        }
        if (choice < 1 || choice > size) {
            printf("잘못된 선택입니다. 다시 선택해주세요.\n");
            continue;
        }

        // while 루프에서 선택한 번호를 반환
        return (choice - 1);
    }
}


Pokemon print_select(Pokemon* pokemon_list, int num_pokemon) {                  //시작 포켓몬 선택
    srand(time(NULL));
    int choice;
    Pokemon selected_pokemon;
    printf("=======================================\n");
    printf("어느 포켓몬을 고르시겠습니까?\n\n");
    printf("1. 파이리  2. 꼬부기  3. 이상해씨\n");
    scanf("%d", &choice);
    switch (choice) {
    case 1:
        selected_pokemon = pokemon_list[1];
        break;
    case 2:
        selected_pokemon = pokemon_list[2];
        break;
    case 3:
        selected_pokemon = pokemon_list[3];
        break;
    default:
        printf("잘못된 선택입니다. 1-3 중에서 선택해주세요.\n");
        selected_pokemon = print_select(pokemon_list, num_pokemon);
        break;
    }

    selected_pokemon.min_hp = rand() % 501 + 500;
    selected_pokemon.max_hp = selected_pokemon.min_hp;
    selected_pokemon.min_attack = rand() % 51 + 100;
    selected_pokemon.max_hp = selected_pokemon.min_hp;
    printf("당신의 포켓몬은 %s 입니다.\n", selected_pokemon.name);
    return selected_pokemon;
}



float get_damage_multiplier(Pokemon attacker_pokemon, Pokemon defender_pokemon) {                       //상성표
    if (strcmp(attacker_pokemon.type, "FIRE") == 0 && strcmp(defender_pokemon.type, "GRASS") == 0) {
        printf("효과는 굉장했다.\n");
        return 1.5f;  // 유리한 타입으로 공격
    }
    else if (strcmp(attacker_pokemon.type, "GRASS") == 0 && strcmp(defender_pokemon.type, "WATER") == 0) {
        printf("효과는 굉장했다.\n");
        return 1.5f;  // 유리한 타입으로 공격
    }
    else if (strcmp(attacker_pokemon.type, "WATER") == 0 && strcmp(defender_pokemon.type, "FIRE") == 0) {
        printf("효과는 굉장했다.\n");
        return 1.5f;  // 유리한 타입으로 공격
    }
    else if (strcmp(attacker_pokemon.type, "GRASS") == 0 && strcmp(defender_pokemon.type, "FIRE") == 0) {
        printf("효과는 별로인듯 하다.\n");
        return 0.5f;  // 불리한 타입으로 공격
    }
    else if (strcmp(attacker_pokemon.type, "WATER") == 0 && strcmp(defender_pokemon.type, "GRASS") == 0) {
        printf("효과는 별로인듯 하다.\n");
        return 0.5f;  // 불리한 타입으로 공격
    }
    else if (strcmp(attacker_pokemon.type, "FIRE") == 0 && strcmp(defender_pokemon.type, "WATER") == 0) {
        printf("효과는 별로인듯 하다.\n");
        return 0.5f;  // 불리한 타입으로 공격
    }
    else if (strcmp(attacker_pokemon.type, "ELECTRIC") == 0 && strcmp(defender_pokemon.type, "WATER") == 0) {
        printf("효과는 굉장했다.\n");
        return 1.5f;  // 유리한 타입으로 공격
    }
    else {
        return 1.0f;  // 일반적인 공격
    }
}


int pokemon_battle(PlayerInfo* player,Pokemon enemy_pokemon) {

    printf("적 포켓몬 : %s (%s) - Attack: %d / HP: %d\n\n\n", enemy_pokemon.name, enemy_pokemon.type, enemy_pokemon.min_attack, enemy_pokemon.min_hp);
    int choice;
    int run;
    int num=0;

    Pokemon my_pokemon;             

    num = (select(player));
    my_pokemon = player->my_pokemon_list[num];
    
    while (1) {
       
        s2:
        printf("1. 공격 2. 교체하기 3. 가방 열기 4. 도망가기\n");
        scanf("%d", &choice);
        switch (choice) {
        case 1:
            goto fight;
            break;

        case 2:
            select:
            select(player);
            break;

        case 3:
            printf("가방 열기\n");
            int gabang;
            printf("1.몬스터볼 : %d개\n2.상처약 : %d개\n어떤걸 사용하겠습니까? :", player->ball, player->potion);
            scanf("%d", &gabang);
            switch (gabang) {
                case 1:
                    if (player->ball <= 0) {
                        printf("몬스터볼이 부족합니다\n");
                        goto s2;
                    }
                    else {
                        if (enemy_pokemon.min_hp > enemy_pokemon.max_hp * 0.5) {
                            printf("체력을 더 깍아주세요...\n");
                            goto enemy_turn;
                        }
                        else if (enemy_pokemon.min_hp <= enemy_pokemon.max_hp * 0.5 && enemy_pokemon.min_hp > enemy_pokemon.max_hp * 0.3) {
                            int catch_probability = rand() % 100 + 1;  // 1부터 100까지 랜덤한 숫자 생성
                            if (catch_probability <= 70) {  // 50%의 확률로 잡힘

                                add(player, &enemy_pokemon);    
                                printf("축하합니다!!!! %s를 잡았습니다!\n", enemy_pokemon.name);
                                player->ball--;
                                goto end_battle_add_pokemon;
                            }
                            else {  // 실패
                                printf("포켓몬이 몬스터볼에서 빠져나왔습니다.\n");
                                player->ball--;
                                goto enemy_turn;
                            }
                        }
                        else if (enemy_pokemon.min_hp <= enemy_pokemon.max_hp * 0.3 && enemy_pokemon.min_hp > enemy_pokemon.max_hp * 0.1) {
                            int catch_probability = rand() % 100 + 1;  // 1부터 100까지 랜덤한 숫자 생성
                            if (catch_probability <= 50) {  // 50%의 확률로 잡힘
                                printf("축하합니다!!! %s를 잡았습니다!\n", enemy_pokemon.name);
                                add(player, &enemy_pokemon);
                                player->ball--;
                                goto end_battle_add_pokemon;
                            }
                            else {  // 실패
                                printf("포켓몬이 몬스터볼에서 빠져나왔습니다.\n");
                                player->ball--;
                                goto enemy_turn;
                            }
                        }
                        else if (enemy_pokemon.min_hp <= enemy_pokemon.max_hp * 0.1 && enemy_pokemon.min_hp > enemy_pokemon.max_hp * 0) {
                            int catch_probability = rand() % 100 + 1;  // 1부터 100까지 랜덤한 숫자 생성
                            if (catch_probability <= 90) {  // 50%의 확률로 잡힘
                                printf("축하합니다!!! %s를 잡았습니다!\n", enemy_pokemon.name);
                                add(player, &enemy_pokemon);
                                player->ball--;
                                goto end_battle_add_pokemon;
                            }
                            else {  // 실패
                                printf("포켓몬이 몬스터볼에서 빠져나왔습니다.\n");
                                player->ball--;
                                goto enemy_turn;
                            }
                        }
                    }
                    break;
                case 2:
                    if (player->potion <= 0) {
                        printf("상처약이 부족합니다\n");
                        goto s2;
                    }
                    my_pokemon.min_hp += (int)my_pokemon.max_hp * 0.3;
                    if (my_pokemon.min_hp >= my_pokemon.max_hp) {
                        my_pokemon.min_hp = my_pokemon.max_hp;
                        
                    }
                    player->potion--;
                    goto enemy_turn;
                    break;
                default:
                    printf("잘못된 입력입니다.\n");
                    break;
            }

            break;

        case 4:
            run = rand() % 100 + 1;  // 1부터 100까지 랜덤한 숫자 생성
            if (run >=20) {         //  80% 확률로 도주성공
                printf("무사히 도망쳤다!!\n");
                goto end_battle;
            }
            else {
                printf("도주에 실패했다!!\n");
                printf("적이 공격한다!!\n");
                goto enemy_turn;
            }
            break;
        default:
            printf("잘못된 선택입니다. 다시 선택해주세요.\n");
            continue;
        }
    }
        
        int damage = 0;
        fight:
        printf("내 포켓몬 스탯: %s (%s) - Attack: %d / HP: %d\n", my_pokemon.name, my_pokemon.type, my_pokemon.min_attack, my_pokemon.min_hp);
        printf("적 포켓몬 스탯: %s (%s) - Attack: %d / HP: %d\n\n\n", enemy_pokemon.name, enemy_pokemon.type, enemy_pokemon.min_attack, enemy_pokemon.min_hp);
        printf("내 포켓몬 %s 이(가) 야생 포켓몬 %s 을(를) 공격!.\n", my_pokemon.name, enemy_pokemon.name);
        get_damage_multiplier(my_pokemon, enemy_pokemon);
        damage = (int)(my_pokemon.min_attack * get_damage_multiplier(my_pokemon, enemy_pokemon));
        printf("%d의 데미지!!!\n", damage);
        enemy_pokemon.min_hp -= damage;
        if (enemy_pokemon.min_hp < 0) {
            enemy_pokemon.min_hp = 0;
            printf("적 포켓몬 %s 이(가) 도망쳤다!\n", enemy_pokemon.name);
            printf("3000원을 획득했다!!\n");
            player->money += 3000;
            printf("현재 가지고 있는 돈: %d\n\n", player->money);
            
            return 1;                                                           //정상적으로 배틀이 끝남
        }
        printf("적 %s   %d / %d\n\n", enemy_pokemon.name, enemy_pokemon.min_hp, enemy_pokemon.max_hp);
        Sleep(2000);

        enemy_turn:
        printf("적 포켓몬 %s 이(가) 내 포켓몬 %s 을(를) 공격!.\n", enemy_pokemon.name, my_pokemon.name);
        get_damage_multiplier(enemy_pokemon, my_pokemon);
        damage = (int)(enemy_pokemon.min_attack * get_damage_multiplier(enemy_pokemon, my_pokemon));
        printf("%d의 데미지!!!\n", damage);
        my_pokemon.min_hp -= damage;
        if (my_pokemon.min_hp <= 0) {
            my_pokemon.min_hp = 0;
            printf("내 포켓몬 %s 가 쓰러졌다\n", my_pokemon.name);
            printf("어떤 포켓몬을 내겠습니까?\n");
            goto select;
        }
        printf("내 %s   %d / %d \n\n", my_pokemon.name, my_pokemon.min_hp, my_pokemon.max_hp);
        Sleep(2000);
        goto s2;

    end_battle_add_pokemon:
        return 1;                               // 포켓몬 6마리 아니고 포켓몬 잡은 루트
    if (&player->my_pokemon_list[5] == NULL)    // 포켓몬 6마리 다모은 루트
        return 2;

    end_battle:                     //걍 끝나는거
        return 0;
    }
    