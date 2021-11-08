package com.company;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

import static com.company.PathForFile.changeStr;
import static com.company.PathForFile.getFileName;

public class Main {

    public static void main(String[] args) throws IOException {


        PathForFile.setFileName("/home/user/Desktop/migration/marketMapping"); // Указываем путь к файлу
        //System.out.println(Arrays.toString(changeStr(getFileName()))); // Метод который перегоняет в массив
        //PathForFile.queryMapping(getFileName());
        //PathForFile.deletePartStr(getFileName()); //Метод который читает с файла и обрезает в строке по нужному индексу
        //System.out.println(Arrays.toString(PathForFile.newStr(changeStr(getFileName()))));
        PathForFile.writeInFile(getFileName()); // Метод который записывает в файл







    }
}
