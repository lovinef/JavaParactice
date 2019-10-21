package Java;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class IOTest {
    public static void main(String[] args) throws IOException {
        // Create Folder
        Path newFolderPath = Paths.get("D:\\Desktop\\test");
        if(Files.exists(newFolderPath) && Files.isDirectory(newFolderPath)){
            System.out.println("폴더가 존재합니다.");
        }else{
            Files.createDirectory(newFolderPath);
            System.out.println("폴더가 생성되었습니다.");
        }

        // Create File
        Path newPath = Paths.get("D:\\Desktop\\새 폴더 (6)\\isTest.txt");
        if(Files.exists(newPath)){
            System.out.println("파일이 존재합니다.");
        }else{
            Files.createFile(newPath);
            System.out.println("파일이 생성되었습니다.");
        }

        System.out.println("---------------------------------------------");

        long start = System.currentTimeMillis();
        // Folder File List 1
        Path path = Paths.get("D:\\Desktop\\새 폴더 (6)");
        DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
        directoryStream.forEach(ds ->{
            if(Files.isDirectory(ds)){
            }else{
            }
        });
        System.out.println("1 실행 시간 : " + ( System.currentTimeMillis() - start )/1000.0 );
        System.out.println("---------------------------------------------");

        // Folder Files List 2
        start = System.currentTimeMillis();

        try(Stream<Path> pathStream = Files.list(path)){
            pathStream.parallel().forEach(ds ->{
                if(Files.isDirectory(ds)){
                }else{
                }
            });
        }catch(Exception e){

        }
        System.out.println("2 실행 시간 : " + ( System.currentTimeMillis() - start )/1000.0 );
    }
}
