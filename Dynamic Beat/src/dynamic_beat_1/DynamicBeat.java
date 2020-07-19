package dynamic_beat_1;

import javax.swing.JFrame;

public class DynamicBeat extends JFrame {
	
	public DynamicBeat() {
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 게임창의 크기를 정한다
		setResizable(false); // 게임창의 크기를 고정시킨다
		setLocationRelativeTo(null); // 게임 실행 시 게임창을 화면의 정중앙에 위치시킨다
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 게임창을 종료했을 때 프로그램이 종료된다
		setVisible(true); // 게임창이 정상적으로 화면에 출력되게 한다 기본값은 false
	}
}
