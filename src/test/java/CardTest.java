package test;
import static org.junit.Assert.*;
import com.cards.Card;
import com.cards.DeckOfCards;

import org.junit.Test;


public class CardTest {



	@Test
	public void testCardProperties(){
		Card card = new Card("face","speed");
		assertTrue( "face".matches(card.getFace()) );
		assertTrue( "speed".matches(card.getSuit()) );
		assertFalse( "notface".matches(card.getSuit()) );
	}

	@Test
	public void testDeckShuffle(){
		DeckOfCards deck = new DeckOfCards();
		String[][] dealtDeck = new String[2][];

		for(int set=0; set < 2; set++){
			dealtDeck[set] = new String[DeckOfCards.NUMBER_OF_CARDS];
			deck.shuffle();
			for(int counter=0; counter < DeckOfCards.NUMBER_OF_CARDS; counter++){
				dealtDeck[set][counter] = deck.dealOneCard().toString();
			}
		}

		int counter = 0;
		boolean notsame = true;
		while( (dealtDeck[0].length  == DeckOfCards.NUMBER_OF_CARDS) &&
				( dealtDeck[1].length == DeckOfCards.NUMBER_OF_CARDS) &&
				counter < DeckOfCards.NUMBER_OF_CARDS
				&& notsame){

			if(!dealtDeck[0][counter].matches(dealtDeck[1][counter]))
				notsame = false;
			counter++;
		}

		assertFalse(notsame);

	}

	@Test
	public void testDeckDeal(){
		int counter = 0;
		DeckOfCards deck = new DeckOfCards();
		Card tempDealValue;

		deck.shuffle();

		do {
			tempDealValue = deck.dealOneCard();
			if(counter < DeckOfCards.NUMBER_OF_CARDS)
				assertNotNull(tempDealValue);//assert 52 cards dealt which aren't null

			counter++;

		} while (counter < DeckOfCards.NUMBER_OF_CARDS);

	}

	@Test
	public void testDeskDealExcessCards(){
		int counter = 0;
		DeckOfCards deck = new DeckOfCards();
		Card tempDealValue;

		deck.shuffle();

		do {
			tempDealValue = deck.dealOneCard();
			if(counter < DeckOfCards.NUMBER_OF_CARDS)
				assertNotNull(tempDealValue);//assert 52 cards dealt

			counter++;

		} while (counter <= DeckOfCards.NUMBER_OF_CARDS);

//		assert 53 call to dealOneCard returns null
		assertNull(tempDealValue);

	}

}
