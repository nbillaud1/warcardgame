package warcardgame.model.material.deck;

import java.util.ArrayList;
import java.util.Objects;

import warcardgame.model.material.Card;

public class Deck {
	
	private ArrayList<Card> cards;
	
	public Deck() {
		this.cards = new ArrayList<>();
	}

	@Override
	public int hashCode() {
		return Objects.hash(cards);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deck other = (Deck) obj;
		return Objects.equals(cards, other.cards);
	}
	
	public Boolean isEmpty() {
		return this.cards.isEmpty();
	}
	
	public Boolean put(Card card) {
		if(this.cards.size() < 52) {
			this.cards.add(card);
			return true;
		}
		else {
			return false;
		}
	}
	
	public Integer remainingCards() {
		return this.cards.size();
	}
}
