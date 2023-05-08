#define _CRT_SECURE_NO_WARNINGS
#include "pokemon.h"
#include <string.h>
#include <stdlib.h>
#include <stdio.h>
#include <time.h>
#include <Windows.h>


void print_menu() {
    printf("=======================================\n");
    printf("               ���ϸ���\n");
    printf("          press enter key to start\n");
    printf("=======================================\n");
    printf("\n");
    printf("1. �����ϱ�   2. �̾��ϱ�\n");
}


void store(PlayerInfo* player) {
    int choice, item_count;
    char ch;

    while (1) {
        printf("=======================================\n");
        printf("        ���� �����ݾ�: %d\n\n", player->money);
        printf("1. ���ͺ�: 1000\n");
        printf("2. ȸ������: 2500\n");
        printf("3. ������\n\n");

        scanf("%d", &choice);

        switch (choice) {
        case 1:
            printf("��� �����Ͻðڽ��ϱ�?\n");
            scanf("%d", &item_count);
            getchar();  // ���� ���� ����
            printf("���� �Ͻðڽ��ϱ� Y/N\n");
            scanf("%c", &ch);
            if (ch == 'Y' || ch == 'y') {
                if (player->money >= 1000 * item_count) {
                    player->money -= 1000 * item_count;
                    player->ball += item_count;
                    printf("���������� ���ͺ��� %d�� �����ϼ̽��ϴ�.\n", item_count);
                    printf("���� �����ݾ�: %d\n", player->money);
                    printf("���� ���ͺ� ����: %d\n\n", player->ball);
                }
                else {
                    printf("���� �����Ͽ� �� �� �����ϴ�.\n");
                }
            }
            break;
        case 2:
            printf("��� �����Ͻðڽ��ϱ�?\n");
            scanf("%d", &item_count);
            getchar();  // ���� ���� ����
            printf("���� �Ͻðڽ��ϱ� Y/N\n");
            scanf("%c", &ch);
            if (ch == 'Y' || ch == 'y') {
                if (player->money >= 2500 * item_count) {
                    player->money -= 2500 * item_count;
                    player->potion += item_count;
                    printf("���������� ȸ�������� %d�� �����ϼ̽��ϴ�.\n", item_count);
                    printf("���� �����ݾ�: %d\n", player->money);
                    printf("���� ȸ������ ����: %d\n\n", player->potion);
                }
                else {
                    printf("���� �����Ͽ� �� �� �����ϴ�.\n");
                }
            }
            break;
        case 3:
            return;
        default:
            printf("���� ���� ���ڸ� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.\n\n");
            break;
        }
    }
}

void show_bag(PlayerInfo* player) {
    printf("���� ��: %d\n", player->money);
    printf("���� ���ͺ�: %d\n", player->ball);
    printf("���� ȸ������: %d\n", player->potion);
}

