package warcardgame.model;

public class Card {
	private final Suit suit;
	private final Rank rank;
	
	public Card(Rank rank, Suit suit) {
		this.suit = suit;
		this.rank = rank;
	}

	public Suit suit() {
		return suit;
	}

	public Rank rank() {
		return rank;
	}
	
	public String toString() {
		return this.rank() + " of " + this.suit();
	}
	
	public String toText() {
		return this.rank().code() + this.suit().code();
	}
}