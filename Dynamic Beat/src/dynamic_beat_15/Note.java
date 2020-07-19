package dynamic_beat_15;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread {

	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private int x, y = 580 - (1000 / Main.SLEEP_TIME * Main.NOTE_SPEED) * Main.REACH_TIME;
	private String noteType;
	private boolean proceeded = true; // 노트 판정을 위한 변수
	
	public String getNoteType() {
		return noteType;
	}
	
	public boolean isProceeded() {
		return proceeded;
	}
	
	public void close() {
		proceeded = false;
	} // 노트 입력을 하고 그 이후 처리를 위한 메소드
//	키에 해당하는 노트가 어디서(x좌표) 시작하는 지 설정하는 메소드
	public Note(String noteType) {
		if(noteType.equals("S")) {
			x = 228;
		} else if(noteType.equals("D")) {
			x = 332;
		} else if(noteType.equals("F")) {
			x = 436;
		} else if(noteType.equals("Space")) {
			x = 540;
		} else if(noteType.equals("J")) {
			x = 744;
		} else if(noteType.equals("K")) {
			x = 848;
		} else if(noteType.equals("L")) {
			x = 952;
		}
		this.noteType = noteType;
	}
//	노트를 그리는 메소드
	public void screenDraw(Graphics2D g) {
		if(noteType.equals("Space")) {
			g.drawImage(noteBasicImage, x, y , null);
			g.drawImage(noteBasicImage, x+100, y, null);
		}
		else {
			g.drawImage(noteBasicImage, x, y, null);
		}
	}
//	노트가 판정을 지나가고서 없애는 메소드
	public void drop() {
		y += Main.NOTE_SPEED;
		if(y > 620) {
			System.out.println("Miss");
			close();
		}
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				drop(); 
				if(proceeded) {
					Thread.sleep(Main.SLEEP_TIME);	
				}
				else {
					interrupt();
					break; // 해당 노트가 움직이지 않도록 한다
				}
			}
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
//	노트 판정을 다루는 메소드
	public void judge() {
		if(y > 613) {
			System.out.println("Late");
			close();
		} else if(y >= 600) {
			System.out.println("Good");
			close();
		} else if(y >= 587) {
			System.out.println("Great");
			close();
		} else if(y >= 573) {
			System.out.println("Perfect");
			close();
		} else if(y >= 565) {
			System.out.println("Great");
			close();
		} else if(y >= 550) {
			System.out.println("Good");
			close();
		} else if(y >= 535) {
			System.out.println("Early");
			close();
		}
	}
	
}
