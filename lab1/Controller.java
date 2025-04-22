import Format.Formater;
import Parser.StreamParser;
import Report.ReportGenerator;
import StatWords.WordStat;

import java.io.*;

public class Controller {


    public void launch() {

        try (FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Андрей\\IdeaProjects\\parser\\in.txt")) {

            StreamParser parser = new StreamParser("C:\\Users\\Андрей\\IdeaProjects\\parser\\in.txt");
            WordStat map=new WordStat();
            String word;
            while ((word = parser.nextWord()) != null) {
                map.putting(word);
            }

            ReportGenerator list=new ReportGenerator();

            Formater print=new Formater();

            print.create(list.listGen(map));


        } catch (IOException e) {
            System.err.println("Error while reading file: " + e.getLocalizedMessage());
        }
    }
}
