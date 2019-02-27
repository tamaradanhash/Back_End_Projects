package controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class StatisticsWriter {
    public static void writeStatistics(){
        List<String> lastBean = Processor.getLastBean().stream().map(e -> e.getColor()).collect(Collectors.toList());
        append("file/output.txt",lastBean);

    }
    private static void append( String filePath,List<String> lines) {
        try {
            Path path = Paths.get(filePath);
            Files.write(path, lines, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        writeStatistics();
    }
}
