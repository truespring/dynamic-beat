package dynamic_beat_15;

public class Beat {

	private int time;
	private String noteName;
//	노트가 어느 버튼에 해당하는지, 언제 떨어질 지를 구성하는 클래스
	public Beat(int time, String noteName) {
		super();
		this.time = time;
		this.noteName = noteName;
	}
	
	public int getTime() {
		return time;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	
	public String getNoteName() {
		return noteName;
	}
	
	public void setNoteName(String noteName) {
		this.noteName = noteName;
	}
}
