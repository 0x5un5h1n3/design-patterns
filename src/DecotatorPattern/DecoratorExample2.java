package DecotatorPattern;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class newClass{
    public static void main(String[] args) throws FileNotFoundException, IOException {
        byte b[] = {65, 66, 67, 68, 69, 70};
        
        OutputStream out = new BufferedOutputStream(new FileOutputStream("D:\\Folder\\abc.txt"));
        out.write(b);
        out.flush();
        out.close();
        
        InputStream inp = new BufferedInputStream(new FileInputStream("D:\\Folder\\abc.txt"));
        int x = inp.read();
        
        while(x != -1){
            System.out.println((char)x);
            x = inp.read();
        }
        inp.close();
    }
}