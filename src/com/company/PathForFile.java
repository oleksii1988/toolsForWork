package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class PathForFile {

    static String fileName;
    static String str1;
    static String[] array = new String[180];

    public static String getStr1() {
        return str1;
    }

    public static void setFileName(String fileName) {
        PathForFile.fileName = fileName;
    }

    public static String getFileName() {
        return fileName;
    }


    public static String[] changeStr(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        //Files.readAllLines(Paths.get(fileName))  решение от Леши Фенина.
        // .forEach(string -> System.out.println(string.substring(27, 31) + ","));
        Scanner scanner = new Scanner(path);
        scanner.useDelimiter(System.getProperty("line.separator"));
        for (int i = 0; scanner.hasNext(); i++) {
            str1 = scanner.next();
            array[i] = str1;
            /*System.out.println(array[i]);
            System.out.println(array[i].replace("Under/Exactly/Over","Total-3way")
                    .replace("Home Team","(Competitor1)")
                    .replace("Away Team","(Competitor2)")
                    .replace("Under/Over","Total")
                    .replace("Including Overtime","(incl.overtime)")
                    .replace("1X2","Match Winner"));
*/
            //System.out.println(str1.substring(27, 31) + ",");

        }

        return array;
    }


    public static void deletePartStr(String fileName) throws IOException {

        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
        scanner.useDelimiter(System.getProperty("line.separator"));
        for (int i = 0; scanner.hasNext(); i++) {
            str1 = scanner.next();

            System.out.print(i + ")" + str1.substring(27, 31) + ",");
        }

    }

    public static void queryMapping(String fileName) throws IOException {

        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
        scanner.useDelimiter(System.getProperty("line.separator"));
        for (int i = 0; scanner.hasNext(); i++) {
            str1 = scanner.next();
            String insert = ("INSERT INTO market_type_mapping (external_id, mapped_id, provider)");

            System.out.println(insert);
            System.out.println("VALUES (" + str1 + ", 'lsport');");
        }

    }


    public static void writeInFile(String fileName) throws IOException {

        File file = new File("mappingFile");
        PrintWriter pw = new PrintWriter(file);

        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
        scanner.useDelimiter(System.getProperty("line.separator"));
        while (scanner.hasNext()) {
            str1 = scanner.next();
            String insert = ("INSERT INTO market_type_mapping (external_id, mapped_id, provider)");
            pw.println(insert);
            pw.println("VALUES (" + str1 + ", 'lsport');");

        }

        pw.close();


    }


    public static String[] newStr(String[] oldArray) {

        for (int i = 0; i < oldArray.length; i++) {
            int id = i;

            oldArray[i] = oldArray[i].replace("Under/Over", "Total")
                    .replace("Under/Exactly/Over", "Total-3way")
                    .replace("Home Team", "(Competitor1)")
                    .replace("Away Team", "(Competitor2)")
                    .replace("Under/Over", "Total")
                    .replace("Including Overtime", "(incl.overtime)")
                    .replace("1X2", "Match Winner");


            if (oldArray[i].equals("lsport:131506:1194\tTotal Player Passing Touchdowns")) {
                System.out.println("INSERT INTO market_type (id,name,sport_id,period_type_id)\n" +
                        "VALUES(" + id + oldArray[i] + " 3, " + " 1)");
            }


        }
        return oldArray;
    }


}