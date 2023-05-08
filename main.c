#define _CRT_SECURE_NO_WARNINGS
#include "pokemon.h"
#include "store.h"
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <Windows.h>


#define NUM_POKEMON 8
#define MAX_SIZE 6
//14기 컴퓨터 공학부 김민성 kknock 포켓몬과제 임니다~
int main(void) {
    int a;
    int cnt = 0;                            //내가 가진 포켓몬 수 0~5
    int choice;
    Pokemon my_pokemon;
    Pokemon enemy_pokemon;
    Pokemon* pokemon_list = read_pokemon_list("pokemon_list.txt");
    Pokemon* my_pokemon_list[MAX_SIZE] = { NULL};

    PlayerInfo player = {NULL};
    player.money = 10000;
    player.ball = 0;
    player.potion = 0;
    player.mode = 0;
    //1번
    if (!pokemon_list) {
        return 1;
    }
    print_menu();
    scanf("%d", &choice);
    switch (choice)
    {
    case 1:
        start_game(player);
        my_pokemon= print_select(pokemon_list, NUM_POKEMON);    //포켓몬 리스트 스타팅 포켓몬을 my_pokemon_list에 저장 ++ 첫게임이므로 0번 인덱스
        player.my_pokemon_list[0] = my_pokemon;

        break;
    case 2:
        load_game(&player);
        break;
    }
    //2번
 
    //3번
menu:
    printf("=======================================\n");
    printf("여행을 떠나시겠습니까?\n\n");
    printf("1. 네 2. 아니요 3. 상점가기 4.가방\n");
    scanf("%d", &choice);
    switch (choice) {
    case 1:
        break;
    case 2:                                                                         //저장하기
        printf("저장 하시겠습니까?(Y/N)\n");
       
        
        while (1) {
            char choic;
            getchar();    // 이전에 입력한 엔터키를 제거
            scanf("%c", &choic);
      
            if (choic == 'Y' || choic == 'y') {
                printf("저장합니다\n");
                printf("게임을 플레이 해주셔서 감사합니다 ^^7");
                save_game(player);
                return 0;
                break;
            }
            else if (choic == 'N' || choic == 'n') {
                printf("저장하지 않습니다!\n");
                printf("게임을 플레이 해주셔서 감사합니다 ^^7");
                return 0;      //종료
                break;
            }
            else {
                printf("잘못 입력하였습니다. 다시 입력하세요.\n");
                continue;
            }
        }
        return 0;
        break;
    case 3:
        store(&player);
        break;
    case 4:
        show_bag;
        if (player.potion <= 0) {
            printf("상처약이 부족합니다\n");
            break;
        }
        my_pokemon.min_hp += (int)my_pokemon.max_hp * 0.6;      //전투가 끝나면 회복약의 효과가 2배가 됨
        if (my_pokemon.min_hp >= my_pokemon.max_hp) {
            my_pokemon.min_hp = my_pokemon.max_hp;

        }
        player.potion--;
    }


    //5번-포켓몬 배틀
    printf("=======================================\n");
    printf("길을 걷는 중 ... ... ...\n\n");
    Sleep(rand() % 2000 + 1000);


    printf("=======================================\n");
    int random = 0;
    srand(time(NULL));
    random = rand() % 8;
    enemy_pokemon = pokemon_list[random];
    player.enemy_pokemon_list = enemy_pokemon;
    enemy_pokemon.min_hp = rand() % 501 + 300;
    enemy_pokemon.max_hp = enemy_pokemon.min_hp;
    enemy_pokemon.min_attack = rand() % 51 + 70;

    printf("야생의 포켓몬이 나타났다!\n\n");
    a = pokemon_battle(&player,enemy_pokemon);
    if (a == 1) {
        cnt++;
        goto menu;
    }
    if (a == 2) {
    goto menu;
    }
    return 0;
}