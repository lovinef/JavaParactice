package Java;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileTest {
    public static void main(String[] args) throws IOException {
        // JAva 1.7
        File file = new File("C:\\FileListTest");
        if(file != null && file.isDirectory()){
            File[] files = file.listFiles();
            for(File f : files){
                if(f != null && f.isDirectory()){
                    System.out.println(f.getName());
                }
            }
        }

        System.out.println("---------------------------------------f");

        // Java 1.8
        try(Stream<Path> walk = Files.walk(Paths.get("C:\\FileListTest"))){
            List<String> folderNames = walk.filter(Files::isDirectory).map(f -> f.getFileName().toString()).collect(Collectors.toList());
            System.out.println(folderNames.toString());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
