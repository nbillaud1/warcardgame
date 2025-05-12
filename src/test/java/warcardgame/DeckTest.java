package warcardgame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import warcardgame.model.material.Card;
import warcardgame.model.material.Rank;
import warcardgame.model.material.Suit;
import warcardgame.model.material.deck.Deck;

class DeckTest {
	private static final Card ACE_OF_HEART = new Card(Rank.ACE, Suit.HEARTS);

	@Test
	void the_deck_is_empty_at_the_beginning(){
		Deck deck = new Deck();
		assertTrue(deck.isEmpty());
	}
	
	@Test
	void the_deck_is_not_empty_when_we_put_a_card() {
		Deck deck = new Deck();
		Boolean isPut = deck.put(ACE_OF_HEART);
		
		assertTrue(isPut);
		assertFalse(deck.isEmpty());
		assertEquals(1, deck.remainingCards());
	}
}
