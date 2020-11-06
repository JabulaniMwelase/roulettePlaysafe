/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.playsafe.www;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Jabulani
 */
public class RouletteService
{
    
    private static final String EVEN_VALUE = "EVEN";
    private static final String ODD_VALUE = "ODD";
    private static final String WIN_RESULT = "WON";
    private static final String LOSE_RESULT = "LOST";
    
    public static void main(String[] args)
    {
        //Create input values
        Scanner input = new Scanner(System.in);
        int randomNumber = randomiseNumber();
        String option = "yes";
        List<Player> players = new ArrayList<>();
        
        while (option.equalsIgnoreCase("yes")){
        
            System.out.print("Please insert your name: ");
            String playerName =   input.next();input.nextLine();
            System.out.println("Name:"+ playerName);

            System.out.print("Please place bet: ");
            String bet =   input.next();
            System.out.println("Bet:"+ bet);

            System.out.print("Please insert bet amount: ");
            double amount = input.nextDouble();
            System.out.println("Amount "+ amount);

            //Set values into Player object:
            Player player = new Player();
            player.setPlayerName(playerName);
            player.setBet(bet);
            player.setAmount(amount);
            players.add(player);

            rouletteBusinessLogic(player, randomNumber);
            System.out.print("Player: " + player);

            finaliseWinnings(player, randomNumber);
            
            System.out.print("Do you wish to add more players? Yes or No: ");
          
            option =  input.next();
        }
        
        
        displayResults(players, randomNumber);
    }
    
    public static Integer randomiseNumber(){
        Random random = new Random();
        int randNum = random.nextInt(37);
        
        if(randNum < 1){
            random.nextInt(37);
        }
        else{
            return randNum;
        }
        return null;
    }
    
    public static void rouletteBusinessLogic(Player player, int randomNumber){
        boolean numeric = true;

        try {
            Double num = Double.parseDouble(player.getBet());
        } catch (NumberFormatException e) {
            numeric = false;
        }
        
        if(numeric){
            if(Integer.parseInt(player.getBet())== randomNumber){
                player.setOutcome(WIN_RESULT);
            }
            else{
                player.setOutcome(LOSE_RESULT);
            }
        }
        else{ 
            if(randomNumber % 2 == 0){
                if(player.getBet().equalsIgnoreCase(EVEN_VALUE)){
                    player.setOutcome(WIN_RESULT);
                }
                else{
                    player.setOutcome(LOSE_RESULT);
                }
            }
            else{
                
                if(player.getBet().equalsIgnoreCase(ODD_VALUE)){
                    player.setOutcome(WIN_RESULT);
                }
                else{
                   player.setOutcome(LOSE_RESULT); 
                }
            }
        }
        
        
    }
    
    public static void finaliseWinnings(Player player, int randomNumber){
        
        if(player.getOutcome().equals(LOSE_RESULT)){
            player.setAmount(player.getAmount() - player.getAmount());
        }
        else{
            if(player.getBet().equalsIgnoreCase(EVEN_VALUE)||player.getBet().equalsIgnoreCase(ODD_VALUE)){
                player.setAmount(player.getAmount()*2);
            }
            else if (Integer.parseInt(player.getBet()) == randomNumber){
                player.setAmount(player.getAmount()*36);
            }
        }
    }
    
    public static void displayResults(List<Player> players, int randomNumber){
        
        System.out.println("Number: "+ randomNumber);
        System.out.println("Player\tBet\tOutcome\tWinnings");
        
        for(Player player: players){
          System.out.println(player.getPlayerName()+"\t"+player.getBet()+"\t"+player.getOutcome()+"\t"+player.getAmount());
        }
    }
}
