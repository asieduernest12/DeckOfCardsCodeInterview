
public class Card {

	private final String face; //hold face value of the card
	private final String suit; // hold suit value of the card

	public Card(String cardFace, String cardSuit){
		this.face = cardFace;//init face
		this.suit = cardSuit;//init suite
	}

	public String toString(){
		return String.format("%s of %s", face, suit); //return formated String
	}
}
