package core.helpers.fileHelpers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;


public final class FileHelper {

    public static boolean writeRecordToFile(String fileName, String recordToWrite){
        
        try{
            
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
