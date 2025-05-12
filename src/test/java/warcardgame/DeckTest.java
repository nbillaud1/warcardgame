package warcardgame;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Test;

import warcardgame.model.material.Card;
import warcardgame.model.material.Rank;
import warcardgame.model.material.Suit;
import warcardgame.model.material.deck.Deck;

class DeckTest {
	private static final Card ACE_OF_HEARTS = new Card(Rank.ACE, Suit.HEARTS);
	private static final Card KING_OF_DIAMONDS = new Card(Rank.KING, Suit.DIAMONDS);
	private static final Card QUEEN_OF_CLUBS = new Card(Rank.QUEEN, Suit.CLUBS);
	private static final Card TEN_OF_SPADES = new Card(Rank.TEN, Suit.SPADES);
	
	@Test
	void the_deck_is_empty_at_the_beginning(){
		Deck deck = new Deck();
		assertTrue(deck.isEmpty());
	}
	
	@Test
	void the_deck_is_not_empty_when_we_put_a_card() {
		Deck deck = new Deck();
		Boolean isPut = deck.put(ACE_OF_HEARTS);
		
		assertTrue(isPut);
		assertFalse(deck.isEmpty());
		assertEquals(1, deck.remainingCards());
	}
	
	@Test 
	void the_deck_has_2_cards() {
		Deck deck = new Deck();
		Boolean isPut = deck.put(ACE_OF_HEARTS, KING_OF_DIAMONDS);
		
		assertTrue(isPut);
		assertFalse(deck.isEmpty());
		assertEquals(2, deck.remainingCards());
	}
	
	@Test
	void return_false_if_no_card_put() {
		Deck deck = new Deck();
		assertFalse(deck.put());
	}
	
	@Test
	void deck_contains_the_right_cards() {
		Deck deck = new Deck();
		Boolean isPut = deck.put(ACE_OF_HEARTS, KING_OF_DIAMONDS, QUEEN_OF_CLUBS, TEN_OF_SPADES);
		Collection<Card> cards = deck.cards();
		assertThat(cards).containsExactly(ACE_OF_HEARTS, KING_OF_DIAMONDS, QUEEN_OF_CLUBS, TEN_OF_SPADES)
						 .containsSequence(ACE_OF_HEARTS, KING_OF_DIAMONDS, QUEEN_OF_CLUBS, TEN_OF_SPADES);
	}
	
	@Test
	void deck_is_empty_when_cleared() {
		Deck deck = new Deck();
		deck.put(ACE_OF_HEARTS, KING_OF_DIAMONDS, QUEEN_OF_CLUBS, TEN_OF_SPADES);
		deck.clear();
		assertTrue(deck.isEmpty());
		assertThat(deck.remainingCards()).isZero();
	}
	
	@Test
	void a_collection_can_be_put_in_once() {
		Deck deck = new Deck();
		Collection<Card> newCards = Arrays.asList(ACE_OF_HEARTS, KING_OF_DIAMONDS, QUEEN_OF_CLUBS, TEN_OF_SPADES);
		deck.put(newCards);
		assertThat(deck.remainingCards()).isEqualTo(4);
		assertThat(deck.cards()).containsExactly(ACE_OF_HEARTS, KING_OF_DIAMONDS, QUEEN_OF_CLUBS, TEN_OF_SPADES)
		 						.containsSequence(ACE_OF_HEARTS, KING_OF_DIAMONDS, QUEEN_OF_CLUBS, TEN_OF_SPADES);
	}
	
	@Test
	void return_false_when_cards_collection_of_deck_does_not_change() {
		Deck deck = new Deck();
		Collection<Card> cards = new ArrayList<>();
		assertFalse(deck.put(cards));
	}
	
	@Test
	void the_deck_is_empty_and_card_is_out() {
		Deck deck = new Deck();
		deck.put(ACE_OF_HEARTS);
		
		Card cardDrawn = deck.draw();
		assertTrue(deck.isEmpty());
		assertThat(cardDrawn).isEqualTo(ACE_OF_HEARTS);
	}
	
	@Test
	void first_card_of_the_deck_is_out_when_drawn() {
		Deck deck = new Deck();
		deck.put(ACE_OF_HEARTS, KING_OF_DIAMONDS, QUEEN_OF_CLUBS, TEN_OF_SPADES);
		
		Card cardDrawn = deck.draw();
		assertThat(cardDrawn).isEqualTo(ACE_OF_HEARTS);
		assertThat(deck.remainingCards()).isEqualTo(3);
	}
	
	@Test
	void return_null_when_empty_deck_is_drawn() {
		Deck deck = new Deck();
		Card cardDrawn = deck.draw();
		assertThat(cardDrawn).isNull();
	}
}
