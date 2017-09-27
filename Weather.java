import java.awt.EventQueue;

public class Weather {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ObrazFrame();
			}
		});
	}
}
