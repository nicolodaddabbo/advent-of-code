#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#define MAX_RED 12
#define MAX_GREEN 13
#define MAX_BLUE 14
#define MAX_LINE 200
#define INFINITE 100

int validate_game_data(char line[], int part);

int main(int argc, char *argv[])
{
    FILE *fp;
    char line[MAX_LINE];
    int possible_games = 0;
    int id;
    int power = 0;

    fp = fopen("input.txt", "r");

    if (fp == NULL)
    {
        printf("Error opening file\n");
        exit(1);
    }

    while (fgets(line, MAX_LINE, fp) != NULL)
    {
        power += validate_game_data(line, 1);
        // id = validate_game_data(line, 0);
        // if (id != -1) {
        //     possible_games += id;
        // }
    }

    printf("\nPossible games: %d\n", possible_games);
    printf("\nGame power: %d\n", power);
    fclose(fp);
    return 0;
}

int validate_game_data(char line[], int part)
{
    if (part >= 2) {
        printf("\nPart must be 0 (part 1) or 1 (part 2)");
        return -1;
    }
    char *game_id;
    char *token = strtok(line, " :,;");
    char *tokenized_line[MAX_LINE];
    int tokenized_size = 0;
    int red = 0;
    int green = 0;
    int blue = 0;

    while (token != NULL)
    {
        token = strtok(NULL, " ");
        tokenized_line[tokenized_size] = token;
        tokenized_size++;
    }

    game_id = tokenized_line[0];
    game_id[strlen(game_id) - 1] = '\0';

    for (int i = 2; i < tokenized_size; i+=2)
    {
        if (strstr(tokenized_line[i], "red") != NULL)
        {
            red = atoi(tokenized_line[i - 1]) > red ? atoi(tokenized_line[i - 1]) : red;
        }
        else if (strstr(tokenized_line[i], "green") != NULL)
        {
            green = atoi(tokenized_line[i - 1]) > green ? atoi(tokenized_line[i - 1]) : green;
        }
        else
        {
            blue = atoi(tokenized_line[i - 1]) > blue ? atoi(tokenized_line[i - 1]) : blue;
        }
    }

    if (part == 0) {
       return red <= MAX_RED && green <= MAX_GREEN && blue <= MAX_BLUE ? atoi(game_id) : -1;
    } else {
        return red * green * blue;
    }
}
