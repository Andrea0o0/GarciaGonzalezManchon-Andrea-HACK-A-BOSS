package com.practicalexercises.exercise1;

import com.practicalexercises.exercise1.models.Directory;


public class Exercise1 {

    public static void exploreDirectory(Directory directory, String indentation) {
        System.out.println(indentation + directory.name + "/");

        for (Directory subdirectory : directory.subdirectories) {
            exploreDirectory(subdirectory, indentation + "    ");
        }

        for (String file : directory.files) {
            System.out.println(indentation + "    " + file);
        }
    }

    public static void main(String[] args) {
        Directory root = new Directory("root");

        Directory dir1 = new Directory("directory 1");
        dir1.addFile("file1.txt");
        dir1.addFile("file2.txt");

        Directory dir2 = new Directory("directory 2");
        dir2.addSubdirectory(new Directory("directory 3"));
        dir2.addFile("file3.txt");

        root.addSubdirectory(dir1);
        root.addSubdirectory(dir2);

        // Recursion function
        exploreDirectory(root, "");
    }

}
