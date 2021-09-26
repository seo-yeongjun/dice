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
