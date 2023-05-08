#define _CRT_SECURE_NO_WARNINGS
#ifndef POKEMON_H
#define POKEMON_H

#define MAX_SIZE 6

typedef struct {
    char name[20];      //���ϸ� �̸�
    char nickname[20];
    char type[20];      //���ϸ� Ÿ��
    int  min_attack;
    int min_hp;
    int max_hp;
} Pokemon;

typedef struct {
    int money;
    int ball;
    int potion;
    int mode;       //�������ϋ��� 
    Pokemon my_pokemon_list[6];
    Pokemon enemy_pokemon_list;
}PlayerInfo;    //����������


Pokemon* read_pokemon_list(const char* filename);    //���ϸ� ����Ʈ �б�
void select_pokemon(Pokemon* pokemon_list, Pokemon* my_pokemon);  //���ϸ� ����
int start_game(PlayerInfo myInfo);    //���� ����
void save_game(PlayerInfo myInfo);    //���� ����
PlayerInfo* load_game(PlayerInfo* myInfo);    //���� �̾��ϱ�





void save_my_pokemon_list(Pokemon* my_pokemon_list[]);      //���� ����
void load_my_pokemon_list(Pokemon* my_pokemon_list[]);

void print_pokemon(Pokemon pokemon);
void print_pokemon_list(Pokemon* pokemons, int count);

Pokemon print_select(Pokemon* pokemon_list, int num_pokemon); //���� ���ϸ� ����
int select(PlayerInfo* player);

int add_pokemon(Pokemon* pokemon, Pokemon** pokemon_list, int max_size,int cnt);        //�� ���ϸ� �迭�� �߰��ϱ�
int add(PlayerInfo* player, Pokemon* enemy_pokemon);


int remove_pokemon( Pokemon** pokemon_list, int max_size);                      //�� ���ϸ� �迭�� �����ϱ�
int select_pokemon_list(Pokemon** pokemon_list, int max_size);                  //�� ���ϸ� �迭�� ���ϸ� �����ϱ�
int collect_six(Pokemon* my_pokemon_list[MAX_SIZE],int i);                      //6���� ������ ���� �ʱ�ȭ �Ǵ� ���� ����



float get_damage_multiplier(Pokemon attacker_pokemon, Pokemon defender_pokemon);      //�� �����
int pokemon_battle(PlayerInfo *player, Pokemon enemy_pokemon ); //���ϸ� ��Ʋ
#endif // !POKEMON_H#pragma once
