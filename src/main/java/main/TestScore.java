/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2020
 * Instructor: Prof. Brian King *
 * Name: Callie Valenti
 * Section: 11:30
 * Date: 11/10/20
 * Time: 6:27 PM
 *
 * Project: csci205FinalProject
 * Package: main * Class: TestScore
 *
 * Description: Runs simulation to make sure
 * probabilities of getting certain hands in
 * game match actual known probabilities
 *
 * ****************************************
 */
package main;

import java.util.ArrayList;

public class TestScore {

    private static Deck deck;
    private static ArrayList<Card> tableCards;
    private static Player player1;
    private static Player player2;
    private static Player player3;
    private static Player player4;

    public static void main(String[] args) {
        int[] probs = new int[9];
        int i = 0;
        while (i < 10000){
            i += 1;
            deck = new Deck();
            deck.shuffle();
            tableCards = new ArrayList<Card>();

            initPlayers();

            initCards(deck);


            initTableCards();


            ArrayList<Integer> score= new ArrayList<Integer>();
            score.add(new Score(player1.playerHand).getScore().get(0));
            score.add(new Score(player2.playerHand).getScore().get(0));
            score.add(new Score(player3.playerHand).getScore().get(0));
            score.add(new Score(player4.playerHand).getScore().get(0));

            for(int j = 0; j < score.size(); j++){
                if (score.get(j) > 900){
                    probs[8] += 1;
                }
                else if (score.get(j) > 800){
                    probs[7] += 1;
                }
                else if (score.get(j) > 700){
                    probs[6] += 1;
                }
                else if (score.get(j) > 600){
                    probs[5] += 1;
                }
                else if (score.get(j) > 500){
                    probs[4] += 1;
                }
                else if (score.get(j) > 400){
                    probs[3] += 1;
                }
                else if (score.get(j) > 300){
                    probs[2] += 1;
                }
                else if (score.get(j) > 200){
                    probs[1] += 1;
                }
                else if (score.get(j) > 100){
                    probs[0] += 1;
                }
            }

        }
        for (int k = 0; k < probs.length; k++){
            System.out.print(probs[k]*100/40000.00 + ", ");
        }


    }

    private static void initTableCards() {
        deck.deal();
        tableCards.add(deck.deal());
        tableCards.add(deck.deal());
        tableCards.add(deck.deal());
        deck.deal();
        tableCards.add(deck.deal());
        deck.deal();
        tableCards.add(deck.deal());

        for (Card card:tableCards){
            player1.addCard(card);
            player2.addCard(card);
            player3.addCard(card);
            player4.addCard(card);
        }
    }

    private static void initCards(Deck deck) {
        player1.setCard1(deck.deal());
        player2.setCard1(deck.deal());
        player3.setCard1(deck.deal());
        player4.setCard1(deck.deal());
        player1.setCard2(deck.deal());
        player2.setCard2(deck.deal());
        player3.setCard2(deck.deal());
        player4.setCard2(deck.deal());
    }

    private static void initPlayers() {
        player1 = new Player(1);
        player2 = new Player(2);
        player3 = new Player(3);
        player4 = new Player(4);
    }
}
    