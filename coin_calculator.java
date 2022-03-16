/*
Filename: coin_calculator
Filetype: Java file
Author: Michael Salton
Created on: 02/15/22
Description: calculate the minimum number of coins needed to make a certain amount of chance
*/

import java.util.Scanner;

public class coinc_calculator{
    
    public static int change_calculator(int v, int[] coins){

        int remaining = v;
        int coins_required = 0;
        int i = 0;
        int[] coin_count = new int[coins.length];

        while(remaining != 0){
            if(coins[i] == remaining){
                coin_count[i]++;
                return coins_required+1;
            }
            if(coins[i] < remaining){
                coin_count[i]++;
                remaining -= coins[i];
                coins_required++;
            }
            if(coins[i] > remaining && i+1 < coins.length){
                coin_count[i]++;
                i++;
            }
            else{
                return -1;
            } 
        }
        return coins_required; 
    }

    public static void main (String[] args){

        Scanner scan = new Scanner(System.in);

        System.out.println("How many different types of coins: ");
        int numOfUniqueCoins = scan.nextInt();

        int[] coins = new int[numOfUniqueCoins];

        for(int i = 0; i < numOfUniqueCoins; i++){
            System.out.println("Value of coin "+ i+1 +": ");
            coins[i] = scan.nextInt();
        }

        System.out.println("How many cents do you want to make cents for: ");
        int v = scan.nextInt();

        System.out.print("Minimum "+change_calculator(v, coins)+" coins required\n");

        scan.close();    
    }  
}
