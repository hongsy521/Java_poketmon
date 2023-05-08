#define _CRT_SECURE_NO_WARNINGS
#include "pokemon.h"
#include <string.h>
#include <stdlib.h>
#include <stdio.h>
#include <time.h>
#include <Windows.h>


void print_menu() {
    printf("=======================================\n");
    printf("               포켓몬스터\n");
    printf("          press enter key to start\n");
    printf("=======================================\n");
    printf("\n");
    printf("1. 새로하기   2. 이어하기\n");
}


void store(PlayerInfo* player) {
    int choice, item_count;
    char ch;

    while (1) {
        printf("=======================================\n");
        printf("        현재 소유금액: %d\n\n", player->money);
        printf("1. 몬스터볼: 1000\n");
        printf("2. 회복물약: 2500\n");
        printf("3. 떠난다\n\n");

        scanf("%d", &choice);

        switch (choice) {
        case 1:
            printf("몇개를 구매하시겠습니까?\n");
            scanf("%d", &item_count);
            getchar();  // 개행 문자 제거
            printf("구매 하시겠습니까 Y/N\n");
            scanf("%c", &ch);
            if (ch == 'Y' || ch == 'y') {
                if (player->money >= 1000 * item_count) {
                    player->money -= 1000 * item_count;
                    player->ball += item_count;
                    printf("성공적으로 몬스터볼을 %d개 구매하셨습니다.\n", item_count);
                    printf("현재 소유금액: %d\n", player->money);
                    printf("현재 몬스터볼 갯수: %d\n\n", player->ball);
                }
                else {
                    printf("돈이 부족하여 살 수 없습니다.\n");
                }
            }
            break;
        case 2:
            printf("몇개를 구매하시겠습니까?\n");
            scanf("%d", &item_count);
            getchar();  // 개행 문자 제거
            printf("구매 하시겠습니까 Y/N\n");
            scanf("%c", &ch);
            if (ch == 'Y' || ch == 'y') {
                if (player->money >= 2500 * item_count) {
                    player->money -= 2500 * item_count;
                    player->potion += item_count;
                    printf("성공적으로 회복물약을 %d개 구매하셨습니다.\n", item_count);
                    printf("현재 소유금액: %d\n", player->money);
                    printf("현재 회복물약 갯수: %d\n\n", player->potion);
                }
                else {
                    printf("돈이 부족하여 살 수 없습니다.\n");
                }
            }
            break;
        case 3:
            return;
        default:
            printf("옳지 않은 숫자를 입력하였습니다. 다시 입력해주세요.\n\n");
            break;
        }
    }
}

void show_bag(PlayerInfo* player) {
    printf("현재 돈: %d\n", player->money);
    printf("현재 몬스터볼: %d\n", player->ball);
    printf("현재 회복물약: %d\n", player->potion);
}

