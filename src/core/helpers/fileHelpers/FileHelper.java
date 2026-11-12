package core.helpers.fileHelpers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;


public final class FileHelper {

    public static boolean writeRecordToFile(String fileName, String recordToWrite){
        
        try{

            File parentDir = new File(fileName).getParentFile();
            if (parentDir != null && !parentDir.exists()) parentDir.mkdirs();
            
            BufferedWriter bWriter = new BufferedWriter(new FileWriter(fileName));
            
            bWriter.write(recordToWrite);

            bWriter.close();
            
            return true;
        }
        catch (Exception any){
                              
            return false;
            
        }
        
    }
    
    public static String readRecordFromFile(String fileName){
        
        try{
            
            return Files.readString(Path.of(fileName));
            
        }
        catch (Exception any){
                              
            return null;
            
        }
        
    }
    
}
