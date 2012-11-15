package com.place.OpenTray;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CokeHolder extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image img;

	public CokeHolder(String path) throws IOException {
		img = ImageIO.read(new File(path));

	}
	
	public static void close(String drive) {
		try {
			File file = File.createTempFile("realhowto", ".vbs");
			file.deleteOnExit();
			FileWriter fw = new FileWriter(file);
			// to close a CD, we need eject two times!
			String vbs = "Set wmp = CreateObject(\"WMPlayer.OCX\") \n"
					+ "Set cd = wmp.cdromCollection.getByDriveSpecifier(\""
					+ drive + "\") \n" + "cd.Eject \n " + "cd.Eject ";
			fw.write(vbs);
			fw.close();
			Runtime.getRuntime().exec("wscript " + file.getPath()).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		try {

			JFrame f = new JFrame();

			CokeHolder panel = new CokeHolder("src/com/place/opentray/holder.jpg");
			
			CokeHolder.open("D:\\");
			

			f.getContentPane().add(panel);

			f.setBounds(0, 0, 620, 490);
			f.setVisible(true);
			

		} catch (Exception e) {
			System.out
					.println("Please verify the existance of the image you loaded.");
		}
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		if (img != null) {
			g.drawImage(img, 0, 0, this);
		}

	}

	public static void open(String drive) {

		try {
			File file = File.createTempFile("realhowto", ".vbs");
			file.deleteOnExit();
			FileWriter fw = new java.io.FileWriter(file);
			String vbs = "Set wmp = CreateObject(\"WMPlayer.OCX\") \n"
					+ "Set cd = wmp.cdromCollection.getByDriveSpecifier(\""
					+ drive + "\") \n" + "cd.Eject";
			fw.write(vbs);
			fw.close();
			Runtime.getRuntime().exec("wscript " + file.getPath()).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}