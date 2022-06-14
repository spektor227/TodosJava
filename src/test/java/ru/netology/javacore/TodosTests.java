package ru.netology.javacore;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class TodosTests {

    @BeforeEach
    public void init() {
        System.out.println("Test started");
    }

    @BeforeAll
    public static void started() {
        System.out.println("Tests started");
    }

    @AfterEach
    public void finished() {
        System.out.println("Test completed");
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println("Tests completed");
    }

    @Test
    public void testAddTask() {
        Todos todos = new Todos();
        todos.addTask("ZTask1");
        assertTrue(todos.getAllTasks().contains("ZTask1"),"Test AddTask no complete!");
        System.out.println("Test AddTask complete!");
    }

    @Test
    public void testRemoveTask() {
        Todos todos = new Todos();
        todos.addTask("ZTask1");
        todos.addTask("ATask2");
        todos.removeTask("ZTask1");
        assertFalse(todos.getAllTasks().contains("ZTask1"),"Test RemoveTask no complete!");
        System.out.println("Test RemoveTask complete!");

    }

    @Test
    public void testGetAllTasks() {
        Todos todos = new Todos();
        todos.addTask("ZTask1");
        todos.addTask("ATask2");
        todos.addTask("ATask1");
        todos.addTask("BTask3");
        String expected = "ATask1 ATask2 BTask3 ZTask1";
        assertEquals(expected,todos.getAllTasks(), "Test GetAllTasks no complete!");
        System.out.println("Test GetAllTasks complete!");
    }
}
