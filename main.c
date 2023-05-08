#define _CRT_SECURE_NO_WARNINGS
#include "pokemon.h"
#include "store.h"
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <Windows.h>


#define NUM_POKEMON 8
#define MAX_SIZE 6
//14�� ��ǻ�� ���к� ��μ� kknock ���ϸ���� �Ӵϴ�~
int main(void) {
    int a;
    int cnt = 0;                            //���� ���� ���ϸ� �� 0~5
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
    //1��
    if (!pokemon_list) {
        return 1;
    }
    print_menu();
    scanf("%d", &choice);
    switch (choice)
    {
    case 1:
        start_game(player);
        my_pokemon= print_select(pokemon_list, NUM_POKEMON);    //���ϸ� ����Ʈ ��Ÿ�� ���ϸ��� my_pokemon_list�� ���� ++ ù�����̹Ƿ� 0�� �ε���
        player.my_pokemon_list[0] = my_pokemon;

        break;
    case 2:
        load_game(&player);
        break;
    }
    //2��
 
    //3��
menu:
    printf("=======================================\n");
    printf("������ �����ðڽ��ϱ�?\n\n");
    printf("1. �� 2. �ƴϿ� 3. �������� 4.����\n");
    scanf("%d", &choice);
    switch (choice) {
    case 1:
        break;
    case 2:                                                                         //�����ϱ�
        printf("���� �Ͻðڽ��ϱ�?(Y/N)\n");
       
        
        while (1) {
            char choic;
            getchar();    // ������ �Է��� ����Ű�� ����
            scanf("%c", &choic);
      
            if (choic == 'Y' || choic == 'y') {
                printf("�����մϴ�\n");
                printf("������ �÷��� ���ּż� �����մϴ� ^^7");
                save_game(player);
                return 0;
                break;
            }
            else if (choic == 'N' || choic == 'n') {
                printf("�������� �ʽ��ϴ�!\n");
                printf("������ �÷��� ���ּż� �����մϴ� ^^7");
                return 0;      //����
                break;
            }
            else {
                printf("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է��ϼ���.\n");
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
            printf("��ó���� �����մϴ�\n");
            break;
        }
        my_pokemon.min_hp += (int)my_pokemon.max_hp * 0.6;      //������ ������ ȸ������ ȿ���� 2�谡 ��
        if (my_pokemon.min_hp >= my_pokemon.max_hp) {
            my_pokemon.min_hp = my_pokemon.max_hp;

        }
        player.potion--;
    }


    //5��-���ϸ� ��Ʋ
    printf("=======================================\n");
    printf("���� �ȴ� �� ... ... ...\n\n");
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

    printf("�߻��� ���ϸ��� ��Ÿ����!\n\n");
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