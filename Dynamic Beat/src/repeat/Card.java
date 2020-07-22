package repeat;

public class Card {
	public final static String[] PATTERNS = {"스페이드", "클로버", "하트", "다이아몬드"};
	private String pattern;
	private String denomination;
	private int point;
	
	public Card(String pattern, String denomination, int point) {
		super();
		this.pattern = pattern;
		this.denomination = denomination;
		this.point = point;
	}
	
	public String getPattern() {
		return pattern;
	}
	
	public String getDenomination() {
		return denomination;
	}
	
	public int getPoint() {
		return point;
	}

	public String toString() {
		return String.format("P : %s D : %s", getPattern(), getDenomination());
	}
	
}
