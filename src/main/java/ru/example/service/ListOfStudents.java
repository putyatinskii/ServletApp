package ru.example.service;

import lombok.Getter;
import ru.example.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListOfStudents {
    @Getter
    private static List<Student> list = new ArrayList<>();

    static {
        list.add(new Student("Андреева Ирина", 3.48d, false));
        list.add(new Student("Анферова Анастасия", 3.42d, false));
        list.add(new Student("Беднов Андрей", 4.5d, true));
        list.add(new Student("Белозуб Яна", 4.98d, true));
        list.add(new Student("Белоус Алексей", 3.84d, true));
        list.add(new Student("Котума Андрей", 4.25d, true));
        list.add(new Student("Колодин Денис", 3.08d, false));
        list.add(new Student("Кузьмин Дмитрий", 4.69d, true));
        list.add(new Student("Ланин Иван", 4.62d, false));
        list.add(new Student("Локтев Илья", 3.38d, true));
        list.add(new Student("Павлова Александра", 4.84d, false));
    }

    public static List<Student> getBlockchain() {
        return list.stream().filter(Student::getIsKnowBlockchain).collect(Collectors.toList());
    }

    public static List<Student> getListOfGeniuses() {
        return list.stream().filter(student -> student.getMark() >= 4).collect(Collectors.toList());
    }

    public static void addStudent(Student student) {
        list.add(student);
    }

    public static List<String> getNamesOfStudents() {
        return list.stream().map(Student::getName).collect(Collectors.toList());
    }
}
