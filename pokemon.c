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
        printf("Error: %s ������ ã�� �� �����ϴ�\n", filename);
        return NULL;
    }

    if (fscanf(fp, "%d\n", &num_pokemon) != 1) {
        printf("Error: ���ϸ� ���� �д� �� ������ �߻��߽��ϴ�\n");
        fclose(fp);
        return NULL;
    }

    pokemon_list = (Pokemon*)malloc(num_pokemon * sizeof(Pokemon));
    if (pokemon_list == NULL) {
        printf("Error: pokemon_list�� �����ϴ� �� ������ �߻��߽��ϴ�\n");
        fclose(fp);
        return NULL;
    }

    for (int i = 0; i < num_pokemon; i++) {
        if (fgets(line, sizeof(line), fp) == NULL) {
            printf("Error: ���ϸ� ������ �д� �� ������ �߻��߽��ϴ�\n");
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
        printf("������ �� �� �����ϴ�.\n");
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
        printf("������ �� �� �����ϴ�.\n");
        return;
    }
    fwrite(&myInfo, sizeof(PlayerInfo), 1, fp);
    fclose(fp);
}

PlayerInfo* load_game(PlayerInfo* myInfo) {
    FILE* fp = NULL;
    fp = fopen("pokemonekknock.dat", "r");
    if (fp == NULL) {
        printf("������ �� �� �����ϴ�.\n");
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
        printf("����� ���ϸ��� �����ϼ���\n");
        for (i = 0; i < size + 1; i++) {
            printf("%d. %s (%s) - Attack: %d / HP: %d / %d\n", i + 1, player->my_pokemon_list[i].name, player->my_pokemon_list[i].type,
                player->my_pokemon_list[i].min_attack, player->my_pokemon_list[i].min_hp, player->my_pokemon_list[i].max_hp);
        }
        scanf("%d", &choice);       //�ٽ�¥

        if (player->my_pokemon_list[choice - 1].min_hp <= 0) {
            printf("������ �� �����ϴ�. �ٽ� ������ �ּ���. \n");
            continue;
        }
        if (choice < 1 || choice > size) {
            printf("�߸��� �����Դϴ�. �ٽ� �������ּ���.\n");
            continue;
        }

        // while �������� ������ ��ȣ�� ��ȯ
        return (choice - 1);
    }
}


Pokemon print_select(Pokemon* pokemon_list, int num_pokemon) {                  //���� ���ϸ� ����
    srand(time(NULL));
    int choice;
    Pokemon selected_pokemon;
    printf("=======================================\n");
    printf("��� ���ϸ��� ���ðڽ��ϱ�?\n\n");
    printf("1. ���̸�  2. ���α�  3. �̻��ؾ�\n");
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
        printf("�߸��� �����Դϴ�. 1-3 �߿��� �������ּ���.\n");
        selected_pokemon = print_select(pokemon_list, num_pokemon);
        break;
    }

    selected_pokemon.min_hp = rand() % 501 + 500;
    selected_pokemon.max_hp = selected_pokemon.min_hp;
    selected_pokemon.min_attack = rand() % 51 + 100;
    selected_pokemon.max_hp = selected_pokemon.min_hp;
    printf("����� ���ϸ��� %s �Դϴ�.\n", selected_pokemon.name);
    return selected_pokemon;
}



float get_damage_multiplier(Pokemon attacker_pokemon, Pokemon defender_pokemon) {                       //��ǥ
    if (strcmp(attacker_pokemon.type, "FIRE") == 0 && strcmp(defender_pokemon.type, "GRASS") == 0) {
        printf("ȿ���� �����ߴ�.\n");
        return 1.5f;  // ������ Ÿ������ ����
    }
    else if (strcmp(attacker_pokemon.type, "GRASS") == 0 && strcmp(defender_pokemon.type, "WATER") == 0) {
        printf("ȿ���� �����ߴ�.\n");
        return 1.5f;  // ������ Ÿ������ ����
    }
    else if (strcmp(attacker_pokemon.type, "WATER") == 0 && strcmp(defender_pokemon.type, "FIRE") == 0) {
        printf("ȿ���� �����ߴ�.\n");
        return 1.5f;  // ������ Ÿ������ ����
    }
    else if (strcmp(attacker_pokemon.type, "GRASS") == 0 && strcmp(defender_pokemon.type, "FIRE") == 0) {
        printf("ȿ���� �����ε� �ϴ�.\n");
        return 0.5f;  // �Ҹ��� Ÿ������ ����
    }
    else if (strcmp(attacker_pokemon.type, "WATER") == 0 && strcmp(defender_pokemon.type, "GRASS") == 0) {
        printf("ȿ���� �����ε� �ϴ�.\n");
        return 0.5f;  // �Ҹ��� Ÿ������ ����
    }
    else if (strcmp(attacker_pokemon.type, "FIRE") == 0 && strcmp(defender_pokemon.type, "WATER") == 0) {
        printf("ȿ���� �����ε� �ϴ�.\n");
        return 0.5f;  // �Ҹ��� Ÿ������ ����
    }
    else if (strcmp(attacker_pokemon.type, "ELECTRIC") == 0 && strcmp(defender_pokemon.type, "WATER") == 0) {
        printf("ȿ���� �����ߴ�.\n");
        return 1.5f;  // ������ Ÿ������ ����
    }
    else {
        return 1.0f;  // �Ϲ����� ����
    }
}


int pokemon_battle(PlayerInfo* player,Pokemon enemy_pokemon) {

    printf("�� ���ϸ� : %s (%s) - Attack: %d / HP: %d\n\n\n", enemy_pokemon.name, enemy_pokemon.type, enemy_pokemon.min_attack, enemy_pokemon.min_hp);
    int choice;
    int run;
    int num=0;

    Pokemon my_pokemon;             

    num = (select(player));
    my_pokemon = player->my_pokemon_list[num];
    
    while (1) {
       
        s2:
        printf("1. ���� 2. ��ü�ϱ� 3. ���� ���� 4. ��������\n");
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
            printf("���� ����\n");
            int gabang;
            printf("1.���ͺ� : %d��\n2.��ó�� : %d��\n��� ����ϰڽ��ϱ�? :", player->ball, player->potion);
            scanf("%d", &gabang);
            switch (gabang) {
                case 1:
                    if (player->ball <= 0) {
                        printf("���ͺ��� �����մϴ�\n");
                        goto s2;
                    }
                    else {
                        if (enemy_pokemon.min_hp > enemy_pokemon.max_hp * 0.5) {
                            printf("ü���� �� ����ּ���...\n");
                            goto enemy_turn;
                        }
                        else if (enemy_pokemon.min_hp <= enemy_pokemon.max_hp * 0.5 && enemy_pokemon.min_hp > enemy_pokemon.max_hp * 0.3) {
                            int catch_probability = rand() % 100 + 1;  // 1���� 100���� ������ ���� ����
                            if (catch_probability <= 70) {  // 50%�� Ȯ���� ����

                                add(player, &enemy_pokemon);    
                                printf("�����մϴ�!!!! %s�� ��ҽ��ϴ�!\n", enemy_pokemon.name);
                                player->ball--;
                                goto end_battle_add_pokemon;
                            }
                            else {  // ����
                                printf("���ϸ��� ���ͺ����� �������Խ��ϴ�.\n");
                                player->ball--;
                                goto enemy_turn;
                            }
                        }
                        else if (enemy_pokemon.min_hp <= enemy_pokemon.max_hp * 0.3 && enemy_pokemon.min_hp > enemy_pokemon.max_hp * 0.1) {
                            int catch_probability = rand() % 100 + 1;  // 1���� 100���� ������ ���� ����
                            if (catch_probability <= 50) {  // 50%�� Ȯ���� ����
                                printf("�����մϴ�!!! %s�� ��ҽ��ϴ�!\n", enemy_pokemon.name);
                                add(player, &enemy_pokemon);
                                player->ball--;
                                goto end_battle_add_pokemon;
                            }
                            else {  // ����
                                printf("���ϸ��� ���ͺ����� �������Խ��ϴ�.\n");
                                player->ball--;
                                goto enemy_turn;
                            }
                        }
                        else if (enemy_pokemon.min_hp <= enemy_pokemon.max_hp * 0.1 && enemy_pokemon.min_hp > enemy_pokemon.max_hp * 0) {
                            int catch_probability = rand() % 100 + 1;  // 1���� 100���� ������ ���� ����
                            if (catch_probability <= 90) {  // 50%�� Ȯ���� ����
                                printf("�����մϴ�!!! %s�� ��ҽ��ϴ�!\n", enemy_pokemon.name);
                                add(player, &enemy_pokemon);
                                player->ball--;
                                goto end_battle_add_pokemon;
                            }
                            else {  // ����
                                printf("���ϸ��� ���ͺ����� �������Խ��ϴ�.\n");
                                player->ball--;
                                goto enemy_turn;
                            }
                        }
                    }
                    break;
                case 2:
                    if (player->potion <= 0) {
                        printf("��ó���� �����մϴ�\n");
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
                    printf("�߸��� �Է��Դϴ�.\n");
                    break;
            }

            break;

        case 4:
            run = rand() % 100 + 1;  // 1���� 100���� ������ ���� ����
            if (run >=20) {         //  80% Ȯ���� ���ּ���
                printf("������ �����ƴ�!!\n");
                goto end_battle;
            }
            else {
                printf("���ֿ� �����ߴ�!!\n");
                printf("���� �����Ѵ�!!\n");
                goto enemy_turn;
            }
            break;
        default:
            printf("�߸��� �����Դϴ�. �ٽ� �������ּ���.\n");
            continue;
        }
    }
        
        int damage = 0;
        fight:
        printf("�� ���ϸ� ����: %s (%s) - Attack: %d / HP: %d\n", my_pokemon.name, my_pokemon.type, my_pokemon.min_attack, my_pokemon.min_hp);
        printf("�� ���ϸ� ����: %s (%s) - Attack: %d / HP: %d\n\n\n", enemy_pokemon.name, enemy_pokemon.type, enemy_pokemon.min_attack, enemy_pokemon.min_hp);
        printf("�� ���ϸ� %s ��(��) �߻� ���ϸ� %s ��(��) ����!.\n", my_pokemon.name, enemy_pokemon.name);
        get_damage_multiplier(my_pokemon, enemy_pokemon);
        damage = (int)(my_pokemon.min_attack * get_damage_multiplier(my_pokemon, enemy_pokemon));
        printf("%d�� ������!!!\n", damage);
        enemy_pokemon.min_hp -= damage;
        if (enemy_pokemon.min_hp < 0) {
            enemy_pokemon.min_hp = 0;
            printf("�� ���ϸ� %s ��(��) �����ƴ�!\n", enemy_pokemon.name);
            printf("3000���� ȹ���ߴ�!!\n");
            player->money += 3000;
            printf("���� ������ �ִ� ��: %d\n\n", player->money);
            
            return 1;                                                           //���������� ��Ʋ�� ����
        }
        printf("�� %s   %d / %d\n\n", enemy_pokemon.name, enemy_pokemon.min_hp, enemy_pokemon.max_hp);
        Sleep(2000);

        enemy_turn:
        printf("�� ���ϸ� %s ��(��) �� ���ϸ� %s ��(��) ����!.\n", enemy_pokemon.name, my_pokemon.name);
        get_damage_multiplier(enemy_pokemon, my_pokemon);
        damage = (int)(enemy_pokemon.min_attack * get_damage_multiplier(enemy_pokemon, my_pokemon));
        printf("%d�� ������!!!\n", damage);
        my_pokemon.min_hp -= damage;
        if (my_pokemon.min_hp <= 0) {
            my_pokemon.min_hp = 0;
            printf("�� ���ϸ� %s �� ��������\n", my_pokemon.name);
            printf("� ���ϸ��� ���ڽ��ϱ�?\n");
            goto select;
        }
        printf("�� %s   %d / %d \n\n", my_pokemon.name, my_pokemon.min_hp, my_pokemon.max_hp);
        Sleep(2000);
        goto s2;

    end_battle_add_pokemon:
        return 1;                               // ���ϸ� 6���� �ƴϰ� ���ϸ� ���� ��Ʈ
    if (&player->my_pokemon_list[5] == NULL)    // ���ϸ� 6���� �ٸ��� ��Ʈ
        return 2;

    end_battle:                     //�� �����°�
        return 0;
    }
    