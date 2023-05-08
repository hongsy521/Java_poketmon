#define _CRT_SECURE_NO_WARNINGS
#ifndef POKEMON_H
#define POKEMON_H

#define MAX_SIZE 6

typedef struct {
    char name[20];      //포켓몬 이름
    char nickname[20];
    char type[20];      //포켓몬 타입
    int  min_attack;
    int min_hp;
    int max_hp;
} Pokemon;

typedef struct {
    int money;
    int ball;
    int potion;
    int mode;       //전투중일떄는 
    Pokemon my_pokemon_list[6];
    Pokemon enemy_pokemon_list;
}PlayerInfo;    //저장정보들


Pokemon* read_pokemon_list(const char* filename);    //포켓몬 리스트 읽기
void select_pokemon(Pokemon* pokemon_list, Pokemon* my_pokemon);  //포켓몬 선택
int start_game(PlayerInfo myInfo);    //게임 시작
void save_game(PlayerInfo myInfo);    //게임 저장
PlayerInfo* load_game(PlayerInfo* myInfo);    //게임 이어하기





void save_my_pokemon_list(Pokemon* my_pokemon_list[]);      //구현 에러
void load_my_pokemon_list(Pokemon* my_pokemon_list[]);

void print_pokemon(Pokemon pokemon);
void print_pokemon_list(Pokemon* pokemons, int count);

Pokemon print_select(Pokemon* pokemon_list, int num_pokemon); //시작 포켓몬 고르기
int select(PlayerInfo* player);

int add_pokemon(Pokemon* pokemon, Pokemon** pokemon_list, int max_size,int cnt);        //내 포켓몬 배열에 추가하기
int add(PlayerInfo* player, Pokemon* enemy_pokemon);


int remove_pokemon( Pokemon** pokemon_list, int max_size);                      //내 포켓몬 배열에 제거하기
int select_pokemon_list(Pokemon** pokemon_list, int max_size);                  //내 포켓몬 배열에 포켓몬 선택하기
int collect_six(Pokemon* my_pokemon_list[MAX_SIZE],int i);                      //6마리 모으면 게임 초기화 또는 게임 종료



float get_damage_multiplier(Pokemon attacker_pokemon, Pokemon defender_pokemon);      //상성 대미지
int pokemon_battle(PlayerInfo *player, Pokemon enemy_pokemon ); //포켓몬 배틀
#endif // !POKEMON_H#pragma once
