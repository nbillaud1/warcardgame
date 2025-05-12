package warcardgame.model.material.deck;

import java.util.ArrayList;
import java.util.Collection;
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
	
	public ArrayList<Card> cards() {
		return cards;
	}

	public Boolean put(Card...otherCards) {
		if(otherCards.length == 0) {
			return false;
		}
		
		for(Card card:otherCards) {
			if(card != null) {
				this.cards.add(card);
			}
		}
		return true;
	}
	
	public Integer remainingCards() {
		return this.cards.size();
	}
	
	public void clear() {
		this.cards.clear();
	}

	public Boolean put(Collection<Card> cards) {
		if(cards.size() == 0) {
			return false;
		}
		for(Card card: cards) {
			this.cards.add(card);
		}
		return true;
	}
	
	public Card draw() {
		if(this.cards.size() != 0) {
			Card drawnCard = this.cards.get(0);
			this.cards.remove(0);
			return drawnCard;
		}
		else {
			return null;
		}
	}
}
