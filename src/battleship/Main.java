package battleship;

import battleship.controller.GameController;
import battleship.controller.GameView;
import battleship.view.ConsoleView;

public class Main {

	public static void main(String[] args) {
		GameView view = new ConsoleView();
        GameController controller = new GameController(view);
        controller.run();
	}

}
