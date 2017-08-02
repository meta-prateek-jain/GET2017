package action;

/**
 * Class implements Action Interface and terminates the Application when its function called
 * @author Prateek Jain
 *
 */
public class ImplementExit implements Action{

	@Override
	public void performAction() {
		System.exit(0);
	}

}
