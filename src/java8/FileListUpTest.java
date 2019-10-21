package java8;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.CheckedOutputStream;

public class FileListUpTest {
    public static void main(String[] args){
        long start = System.currentTimeMillis();
        Path path = Paths.get("D:\\Desktop\\새 폴더 (6)");
        Path movePath = Paths.get("D:\\Desktop\\moveHere");

        // walk test
        try(Stream<Path> stream = Files.walk(path)){
            stream.filter(s ->{
                return !Files.isDirectory(s) && s.getFileName().toString().startsWith("isTest");
            }).forEach(p ->{
                try {
                    Files.move(p, Paths.get(movePath.toString() + "\\" + p.getFileName()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("1 실행 시간 : " + ( System.currentTimeMillis() - start )/1000.0 );

        start = System.currentTimeMillis();
        try(Stream<Path> stream = Files.find(movePath, Integer.MAX_VALUE, (p, a) -> !a.isDirectory() && p.getFileName().toString().startsWith("isTest"))){
            stream.forEach(p ->{
                try {

                    Files.move(p, Paths.get(path.toString() + "\\" + p.getFileName()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("3 실행 시간 : " + ( System.currentTimeMillis() - start )/1000.0 );
    }
}
