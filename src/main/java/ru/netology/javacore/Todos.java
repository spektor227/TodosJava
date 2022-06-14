package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {

    public List<String> tasks = new ArrayList<>();

    public void addTask(String task) {

        tasks.add(task);
    }

    public void removeTask(String task) {

        tasks.remove(task);
    }

    public String getAllTasks() {
        String result = tasks.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.joining(" "));

        return result;
    }
}