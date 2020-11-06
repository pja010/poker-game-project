/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2020
 * Instructor: Prof. Brian King *
 * Name: Callie Valenti
 * Section: 11:30
 * Date: 11/2/20
 * Time: 11:59 AM
 *
 * Project: csci205FinalProject
 * Package: main * Class: Player
 *
 * Description:
 *
 * ****************************************
 */
package main;

import java.util.ArrayList;

enum PlayerAction {
    FOLD,
    CHECK,
    BET,
    RAISE
}

public class Player {
    private int playerNum;
    private boolean isDealer;
    public ArrayList<Card> playerHand = new ArrayList<Card>();
    private Card card1;
    private Card card2;
    private PlayerAction action;
    private double actionAmount;
    private Chips chips;
    private Score score;
    public boolean isPlaying;

    public Player(int playerNum) {
        this.playerNum = playerNum;
        this.chips = new Chips();
        this.isPlaying = true;

    }

    public void move(PlayerAction action, double actionAmount) {
        this.action = action;
        this.actionAmount = actionAmount;
        chips.subtractAmount(actionAmount);
    }

    public void setChips(double initAmount) {
        this.chips.initAmount = initAmount;
        this.chips.currAmount = initAmount;
    }

    public void setCard1(Card card1){
        this.card1 = card1;
        this.playerHand.add(card1);
    }

    public void setCard2(Card card2){
        this.card2 = card2;
        this.playerHand.add(card2);
    }

    public void addCard(Card card) {
        this.playerHand.add(card);
    }

    public int getScore() {
        score = new Score(playerHand);
        return score.getScore();
    }

    public void addChips(double amount){
        chips.currAmount += amount;
    }

    public void subChips(double amount){
        chips.currAmount -= amount;
    }

    public double getChips(){
        return chips.currAmount;
    }

    public int getPlayerNum(){
        return playerNum;
    }

    public void setIsPlaying(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }

    public ArrayList<Card> getPlayerHand() {
        return playerHand;
    }
}
    