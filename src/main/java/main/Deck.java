/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2020
 * Instructor: Prof. Brian King
 * Name: Callie Valenti
 * Section: 11:30
 * Date: 11/2/20
 * Time: 1:04 PM
 *
 * Project: csci205FinalProject
 * Package: main
 * Class: Deck
 *
 * Description: Deck of cards object
 * consisting of 52 playing card objects.
 *
 * ****************************************
 */
package main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;


/**
 * Class that encapsulates a deck of playing cards.
 * It consists of 52 total cards stored in an arraylist.
 * There are 4 suits, each with 13 cards of different ranks.
 * Design based on: http://www.mathcs.emory.edu/~cheung/Courses/170/Syllabus/10/deck-of-cards.html
 */
public class Deck implements Serializable {

    //private static final long serialVersionUID = 42L;

    public static final int NUMBER_OF_CARDS_IN_DECK = 52;
    /**
     * The list that stores the playing cards.
     */
    private ArrayList<Card> deckOfCards;

    /**
     * Counter of the number of cards dealt from the deck.
     */
    private int cardsDealt;


    /**
     * Constructor that instantiates a new deck from a list of given cards.
     * @param deckOfCards the deck as a list of cards objects.
     */
    public Deck(ArrayList<Card> deckOfCards) {
        this.deckOfCards = deckOfCards;
    }

    /**
     * No argument constructor instantiates a new deck by creating a list
     * and fills it with cards from each suit and rank.
     */
    public Deck() {
        deckOfCards = new ArrayList<>();
        for (int suit = Card.DIAMOND; suit <= Card.SPADE; suit ++) {
            for (int rank = Card.TWO; rank <= Card.ACE; rank ++) {
                deckOfCards.add(new Card(rank,suit));
            }
        }

        for(int i = 0; i < 100; i++){
            shuffle();
        }
    }

    /**
     * Shuffles the deck.
     * Algorithm design based on: https://introcs.cs.princeton.edu/java/15inout/Shuffle.java.html
     */
    public void shuffle() {
        int numTimesShuffled = 0;
        while(numTimesShuffled < 10) {
            for (int currCard = 0; currCard < deckOfCards.size(); currCard++) {
                Random randomInt = new Random();
                int index = randomInt.nextInt(deckOfCards.size());
                Card card = deckOfCards.get(currCard);
                deckOfCards.remove(currCard);
                deckOfCards.add(index, card);
            }
            numTimesShuffled += 1;
        }
        cardsDealt = 0;
    }

    /**
     * Deals all cards in the deck.
     * @return 1 card.
     */
    public Card deal() {
        if (cardsDealt <= NUMBER_OF_CARDS_IN_DECK) {
            Card card = deckOfCards.get(0);
            deckOfCards.remove(0);
            deckOfCards.add(card);
            cardsDealt += 1;
            return card;
        }
        else {
            return null;
        }
    }

    /**
     * Returns the list deck of cards
     * @return - Array List of card deck
     */
    public ArrayList<Card> getDeckOfCards() {
        return deckOfCards;
    }
}