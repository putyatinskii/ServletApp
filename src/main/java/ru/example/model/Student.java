package ru.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private double mark;
    private Boolean isKnowBlockchain;
}
