import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

//configuration
public class Config {

	private static Profile profile = new Profile();
	private static StartPanel startPanel = new StartPanel();
	private static Monster monster = new Monster();
	private static DungeonPanel dungeonPanel = new DungeonPanel();
	private static Dice dice = new Dice();
	private static StageScript stageScript = new StageScript();
	private static BottomPanel bottomPanel = new BottomPanel();
	private static MainFrame mainFrame = new MainFrame();
	private static int dungeonLevel = 0;
	private static WinFrame winFrame = new WinFrame();
	
	//https://www.codegrepper.com/code-examples/java/how+to+play+sound+in+java%27+mp3+swing 소스코드 이용
	//효과음 메서드
	public void music(int i) {
		Clip clip;
		URL[] file = {getClass().getResource("music/bgm.wav"),getClass().getResource("music/dice.wav"),getClass().getResource("music/atk.wav")};
		try {
			AudioInputStream input = AudioSystem.getAudioInputStream(file[i]);
			clip = AudioSystem.getClip();
			clip.open(input);
			clip.start();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	
	public StageScript stageScript() {
		return stageScript;
	}
		
	public WinFrame winFrame() {
		return winFrame;
	}
	
	public int getDungeonLevel() {
		return dungeonLevel;
	}

	public void setDungeonLevel() {
		dungeonLevel++;
	}

	public Monster monster() {
		return monster;
	}



	public StartPanel startPanel() {
		return startPanel;
	}

	public MainFrame mainFrame() {
		return mainFrame;
	}

	public DungeonPanel dungeonPanel() {
		return dungeonPanel;
	}

	public Profile profile() {
		return profile;
	}

	public Dice dice() {
		return dice;
	}

	public BottomPanel bottomPanel() {
		return bottomPanel;
	}

}
