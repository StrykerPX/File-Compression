package pakg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Compress {
	
	JFrame frame = new JFrame("File Compression");
	JFileChooser Fsource = new  JFileChooser();

	public static void compress(File source, File destination) throws IOException{
		
		int read;
		byte[] buffer = new byte[1024];
		
		FileInputStream fis = new FileInputStream(source);
		FileOutputStream fos = new FileOutputStream(destination);
		
		GZIPOutputStream gzos = new GZIPOutputStream(fos);
		
		while((read = fis.read(buffer)) != -1) {
			gzos.write(buffer, 0, read);
		}
		gzos.finish();
		gzos.close();
		fos.close();
		fis.close();
	}
	
	Compress(){
		Fsource.setFileFilter(Fsource.getAcceptAllFileFilter());
        int returnVal = Fsource.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " + Fsource.getSelectedFile().getName());
            
            File source = Fsource.getSelectedFile();
            File destination = new File("C:\\Users\\Stryker\\Desktop\\Compressed.jpg");
            
            try {
            	compress(source, destination);
            }catch(IOException e) {
            	System.out.println(e);
            }
        }
	}
}
