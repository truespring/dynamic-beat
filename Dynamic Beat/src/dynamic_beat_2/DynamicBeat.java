package dynamic_beat_2;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DynamicBeat extends JFrame {
	
	private Image screenImage;
	private Graphics screenGraphic;
	
	private Image introBackground;
	
	public DynamicBeat() {
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 게임창의 크기를 정한다
		setResizable(false); // 게임창의 크기를 고정시킨다
		setLocationRelativeTo(null); // 게임 실행 시 게임창을 화면의 정중앙에 위치시킨다
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 게임창을 종료했을 때 프로그램이 종료된다
		setVisible(true); // 게임창이 정상적으로 화면에 출력되게 한다 기본값은 false
		
		introBackground = new ImageIcon(Main.class.getResource("../images/introBackground(Title).png")).getImage();
//		메인 클래스 위치를 기반으로 이미지 파일을 얻어온 뒤에 이미지 인스턴스를 변수에 초기화시킨다
	}
	
	public void paint(Graphics g) { // GUI화면에서 가장 첫 번째로 이미지를 그려주는 메소드
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 프로그램 크기만큼 이미지를 생성한다 스크린 이미지의 크기
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic); // 스크린 이미지에 우리가 원하는 이미지를 그려준다
		g.drawImage(screenImage, 0, 0, null); // 스크린 이미지를 0, 0 에 그려준다
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null); // 인트로 이미지를 스크린 이미지에 그려준다
		this.repaint(); // 다시 paint 메소드를 부른다 
	} // 전체 화면 이미지를 매 순간마다 프로그램이 종료되는 순간까지 계속 반복해서 그려준다
}
