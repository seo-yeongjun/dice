
public class Config {
	
	private static Profile profile = new Profile();
	private static NamePanel namePanel = new NamePanel();
	private static Dice dice = new Dice();
	private static BottomPanel bottomPanel = new BottomPanel();

	public NamePanel namePanel() {
		return Config.namePanel;
	}

	public Profile profile() {
		return Config.profile;
	}

	public Dice dice() {
		return Config.dice;
	}

	public BottomPanel bottomPanel() {
		return Config.bottomPanel;
	}
}
