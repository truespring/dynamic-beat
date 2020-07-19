package dynamic_beat_15;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread {
//	게임을 구성하는 요소들을 다루는 클래스
	private Image noteRouteLine = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	private Image judgementLine = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	private Image noteRouteS = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteD = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteF = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace1 = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace2 = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteJ = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteK = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteL = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;

	ArrayList<Note> noteList = new ArrayList<Note>(); // 해당 곡의 노트를 담을 변수

	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);
	}

	public void screenDraw(Graphics2D g) {
//	게임 화면에 필요한 이미지들을 그려주는 메소드
		g.drawImage(noteRouteS, 228, 30, null);
		g.drawImage(noteRouteD, 332, 30, null);
		g.drawImage(noteRouteF, 436, 30, null);
		g.drawImage(noteRouteSpace1, 540, 30, null);
		g.drawImage(noteRouteSpace2, 640, 30, null);
		g.drawImage(noteRouteJ, 744, 30, null);
		g.drawImage(noteRouteK, 848, 30, null);
		g.drawImage(noteRouteL, 952, 30, null);
		g.drawImage(noteRouteLine, 224, 30, null);
		g.drawImage(noteRouteLine, 328, 30, null);
		g.drawImage(noteRouteLine, 432, 30, null);
		g.drawImage(noteRouteLine, 536, 30, null);
		g.drawImage(noteRouteLine, 740, 30, null);
		g.drawImage(noteRouteLine, 844, 30, null);
		g.drawImage(noteRouteLine, 948, 30, null);
		g.drawImage(noteRouteLine, 1052, 30, null);
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLine, 0, 580, null);
		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if(!note.isProceeded()) {
				noteList.remove(i);
				i--;
			} // 사용된 노트는 지워준다
			else {
				note.screenDraw(g);
			}
		}
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(titleName, 20, 702);
		g.drawString(difficulty, 1190, 702);
		g.setFont(new Font("Arial", Font.PLAIN, 26));
		g.setColor(Color.DARK_GRAY);
		g.drawString("S", 270, 609);
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("Space Bar", 580, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("Elephant", Font.BOLD, 30));
		g.drawString("0000000", 565, 702);

	}
//	버튼을 누르거나 뗐을 때 발생하는 이벤트 메소드
	public void pressS() {
		judge("S");
		noteRouteS = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}

	public void releaseS() {
		noteRouteS = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	public void pressD() {
		judge("D");
		noteRouteD = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}

	public void releaseD() {
		noteRouteD = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	public void pressF() {
		judge("F");
		noteRouteF = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}

	public void releaseF() {
		noteRouteF = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	public void pressSpace() {
		judge("Space");
		noteRouteSpace1 = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		noteRouteSpace2 = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumBig1.mp3", false).start();
	}

	public void releaseSpace() {
		noteRouteSpace1 = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		noteRouteSpace2 = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	public void pressJ() {
		judge("J");
		noteRouteJ = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}

	public void releaseJ() {
		noteRouteJ = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	public void pressK() {
		judge("K");
		noteRouteK = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}

	public void releaseK() {
		noteRouteK = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	public void pressL() {
		judge("L");
		noteRouteL = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}

	public void releaseL() {
		noteRouteL = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	@Override
	public void run() {
		dropNotes(this.titleName);
	}
//	게임을 시작했을 때 노트를 떨어뜨릴 수 있도록 하고 게임이 종료되면 닫아주는 메소드들
	public void close() {
		gameMusic.close();
		this.interrupt();
	}
//	해당 곡의 노트를 저장할 메소드
	public void dropNotes(String titleName) {
		Beat[] beats = null;
		if (titleName.equals("On my way") && difficulty.equals("Easy")) {
			int startTime = 4460 - Main.REACH_TIME * 1000;
			int gap = 125; // 박자를 위한 도구
			beats = new Beat[] { 
					new Beat(startTime, "S"), 
					new Beat(startTime + gap * 2, "Space"), 
					new Beat(startTime + gap * 4, "F"), 
					new Beat(startTime + gap * 6, "D"), 
					new Beat(startTime + gap * 8, "J"), 
					new Beat(startTime + gap * 10, "L"), 
					new Beat(startTime + gap * 12, "Space"), 
					new Beat(startTime + gap * 14, "F"), 
					new Beat(startTime + gap * 16, "K"), 
					new Beat(startTime + gap * 18, "L"), 
					new Beat(startTime + gap * 20, "J"), 
					new Beat(startTime + gap * 22, "S"), 
					new Beat(startTime + gap * 24, "F"), 
					new Beat(startTime + gap * 26, "D"), 
					new Beat(startTime + gap * 28, "J"), 
					new Beat(startTime + gap * 30, "L"), 
			};
		} else if (titleName.equals("On my way") && difficulty.equals("Easy")) {
			int startTime = 4460 - Main.REACH_TIME * 1000;
			int gap = 125; // 박자를 위한 도구
			beats = new Beat[] { 
					new Beat(startTime, "S"), 
					new Beat(startTime + gap * 2, "Space"), 
					new Beat(startTime + gap * 4, "F"), 
					new Beat(startTime + gap * 6, "D"), 
					new Beat(startTime + gap * 8, "J"), 
					new Beat(startTime + gap * 10, "L"), 
					new Beat(startTime + gap * 12, "Space"), 
					new Beat(startTime + gap * 14, "F"), 
					new Beat(startTime + gap * 16, "K"), 
					new Beat(startTime + gap * 18, "L"), 
					new Beat(startTime + gap * 20, "J"), 
					new Beat(startTime + gap * 22, "S"), 
					new Beat(startTime + gap * 24, "F"), 
					new Beat(startTime + gap * 26, "D"), 
					new Beat(startTime + gap * 28, "J"), 
					new Beat(startTime + gap * 30, "L"), 
			};
		} 
		else if (titleName.equals("Faded") && difficulty.equals("Easy")) {
			int startTime = 1000;
			beats = new Beat[] { 
					new Beat(startTime, "Space"), 
			};
		} 
		else if (titleName.equals("Faded") && difficulty.equals("Hard")) {
			int startTime = 1000;
			beats = new Beat[] { 
					new Beat(startTime, "Space"), 
			};
		} 
		else if (titleName.equals("The Spectre") && difficulty.equals("Easy")) {
			int startTime = 1000;
			beats = new Beat[] { 
					new Beat(startTime, "Space"), 
			};
		}
		else if (titleName.equals("The Spectre") && difficulty.equals("Hard")) {
			int startTime = 1000;
			beats = new Beat[] { 
					new Beat(startTime, "Space"), 
			};
		}
		int i = 0;
		gameMusic.start();
		while (i < beats.length && !isInterrupted()) { // player를 담당하는 라이브러리 새로 받아보기	
			boolean dropped = false;
			if (beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			if (!dropped) {
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
//	노트를 판정하는 메소드
	public void judge(String input) {
		for(int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if(input.equals(note.getNoteType())) {
				note.judge();
				break;
			}
		}
	}
}
