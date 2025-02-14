package com.example.project.Student;
import java.util.ArrayList;
import java.util.Arrays;

public class Utility {

    public static ArrayList<Student> sortStudents(ArrayList<Student> list){
        int n = list.size();
        boolean swapped;
        swapped = false;
            for (int i = 0; i < n - 1; i++) {
                Student s1 = list.get(i);
                Student s2 = list.get(i + 1);
                int lastNameComparison = s1.getLastName().compareTo(s2.getLastName());
                if (lastNameComparison > 0 ||
                   (lastNameComparison == 0 && s1.getFirstName().compareTo(s2.getFirstName()) > 0) ||
                   (lastNameComparison == 0 && s1.getFirstName().equals(s2.getFirstName()) && s1.getGpa() < s2.getGpa())) {
                    list.set(i, s2);
                    list.set(i + 1, s1);
                    swapped = true;
                }
            }
            n--;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                Student s1 = list.get(i);
                Student s2 = list.get(i + 1);
                int compare = s1.getLastName().compareTo(s2.getLastName());
                if (compare > 0 ||
                   (compare == 0 && s1.getFirstName().compareTo(s2.getFirstName()) > 0) || (compare == 0 && s1.getFirstName().equals(s2.getFirstName()) && s1.getGpa() < s2.getGpa())) {
                    list.set(i, s2);
                    list.set(i + 1, s1);
                    swapped = true;
                }
            }
            n--; 
        }
        return list;
    }

}
