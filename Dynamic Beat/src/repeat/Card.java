package repeat;

public class Card {
	public final String[] PATTERNS = {"스페이드", "클로버", "하트", "다이아몬드"};
	private String pattern;
	private String denomination;
	
	public Card(String pattern, String denomination) {
		super();
		this.pattern = pattern;
		this.denomination = denomination;
	}
	
	public String getPattern() {
		return pattern;
	}
	
	public String getDenomination() {
		return denomination;
	}
	
	
	
}
