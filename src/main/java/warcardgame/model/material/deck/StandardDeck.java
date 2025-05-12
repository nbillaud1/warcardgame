package warcardgame.model.material.deck;

import warcardgame.model.material.Card;
import warcardgame.model.material.Rank;
import warcardgame.model.material.Suit;

public class StandardDeck extends Deck{
	public StandardDeck() {
		super();
		this.putAllCardsTogether();
	}

	private void putAllCardsTogether() {
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				super.put(new Card(rank, suit));
			}
		}
	}
}
