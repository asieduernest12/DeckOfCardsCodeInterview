package com.cards;

public class DeckOfCardsTest {

	public static void main(String[] args){

		DeckOfCards mydeckofCards = new DeckOfCards();

		mydeckofCards.shuffle();

		for(int i=1; i <= DeckOfCards.NUMBER_OF_CARDS; i++){
			System.out.printf("%-19s", mydeckofCards.dealOneCard());

			if(i%4 == 0)
				System.out.println();

		}
	}

}
