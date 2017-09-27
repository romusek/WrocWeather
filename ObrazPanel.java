import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ObrazPanel extends JPanel {

	private BufferedImage image;

	public ObrazPanel() {
		super();

		try {
			//URL imageFile = new URL("http://new.meteo.pl/um/metco/mgram_pict.php?ntype=0u&fdate=2017081606&row=436&col=181&lang=pl");
			URL imageFile = new URL(DataObs.createLink());
			image = ImageIO.read(imageFile);
			if (image == null) System.out.println("puste");
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}

		Dimension dimension = new Dimension(image.getWidth(), image.getHeight());
		setPreferredSize(dimension);
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(image, 0, 0, this);
	}
}
