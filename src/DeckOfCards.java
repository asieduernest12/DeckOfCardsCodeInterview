import java.security.SecureRandom;


public class DeckOfCards {

	private Card[] deck;//hold our cards
	private int currentCard;//index of next card to be dealt
	public static final int NUMBER_OF_CARDS = 52;//total cards in deck

	private static final SecureRandom randomNumbers = new SecureRandom();//random number generator

	public DeckOfCards(){
		String[] faces = {
				"Ace", "Deuce", "Three", "Four", "Five", "Six",
				"Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"
		};

		String[] suits = {
				"Hearts", "Diamonds", "Clubs", "Spades"
		};

		deck = new Card[NUMBER_OF_CARDS];//create cards array

		for(int count = 0; count < deck.length; count++){
			deck[count] =
					new Card(faces[count % 13], suits[count / 13]);
		}

	}

	public void shuffle(){

		currentCard = 0;

		for(int first = 0; first < deck.length; first++){
			int second = randomNumbers.nextInt(NUMBER_OF_CARDS);

			swapCards(deck,first,second);
		}
	}

	public Card dealOneCard(){
		if(currentCard < deck.length)
			return deck[currentCard++];
		else
			return null;
	}

	private void swapCards(Card[] deck, int firstCard, int secondCard){
		Card temp = deck[firstCard];
		deck[firstCard] = deck[secondCard];
		deck[secondCard] = temp;
	}

}
