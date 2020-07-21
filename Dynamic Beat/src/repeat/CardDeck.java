package repeat;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {
	private List<Card> arr = new ArrayList();
	
	public CardDeck() {
		init();
	}
	
	public void init() {
		for(int i = 0; i < Card.PATTERNS.length; i++) {
			for(int j = 1; j < 14; j++) {
				String pattern = Card.PATTERNS[i];
				String deno = deno(j);
				arr.add(new Card(pattern, deno));
			}
		}
	}
	
	public String deno(int num) {
		switch(num) {
		case 1: return "A";
		case 11: return "J";
		case 12: return "Q";
		case 13: return "K";
		default : return String.valueOf(num);
		}
	}
}
