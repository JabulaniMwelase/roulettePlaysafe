/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.playsafe.www;

/**
 *
 * @author Jabulani
 */
public class Player
{
    private String playerName;
    private String bet;
    private String outcome;
    private double amount;

    public String getPlayerName()
    {
        return playerName;
    }

    public void setPlayerName(String playerName)
    {
        this.playerName = playerName;
    }

    public String getBet()
    {
        return bet;
    }

    public void setBet(String bet)
    {
        this.bet = bet;
    }

    public String getOutcome()
    {
        return outcome;
    }

    public void setOutcome(String outcome)
    {
        this.outcome = outcome;
    }

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    @Override
    public String toString()
    {
        return "Player{" + "playerName=" + playerName + ", bet=" + bet + ", outcome=" + outcome + ", amount=" + amount + '}';
    }
    
    
    
}
