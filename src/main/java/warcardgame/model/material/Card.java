package warcardgame.model.material;

import java.util.Objects;

public class Card {
	@Override
	public int hashCode() {
		return Objects.hash(rank, suit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return rank == other.rank && suit == other.suit;
	}

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