package dynamic_beat_3;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread {
	
	private Player player; // 라이브러리 중 하나
	private boolean isLoop; // 곡이 무한 반복인지 한 번만 실행되는지에 대한 설정
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop; // 변수 초기화
			file = new File(Main.class.getResource("../music/" + name).toURI()); // music폴더에 있는 해당 파일을 실행시킴 toURI는 해당 파일의 위치를 가져온다
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis); // 해당 파일을 버퍼에 담아서 읽어올 수 있도록 한다
			player = new Player(bis); // 해당 파일을 담을 수 있도록 한다
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int getTime() { // 현재 실행되고 있는 음악이 어떤 위치인지 알려준다
		if (player == null)
			return 0;
		return player.getPosition(); // 음악에 맞춰서 노트를 떨어뜨릴 때 getTime 메소드를 통해 시간을 분석한다
	}
	
	public void close() { // 실행 중인 음악을 항상 종료할 수 있도록 하는 메소드
		isLoop = false;
		player.close();
		this.interrupt(); // 해당 스레드를 중지상태로 만드는 메소드
	}
	
	@Override
	public void run() {
		try {
			do {
				player.play(); // 곡을 실행시킨다
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			} while (isLoop);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
