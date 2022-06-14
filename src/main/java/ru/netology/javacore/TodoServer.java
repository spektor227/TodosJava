package ru.netology.javacore;

import com.google.gson.Gson;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {

    private final Todos todos;
    private final int port;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        System.out.println("Запуск сервера! Порт: " + this.port + "...");

        try (ServerSocket serverSocket = new ServerSocket(this.port);) {
            while (true) {

                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream());
                )
                {
                    String request = in.readLine();
                    Task task = new Gson().fromJson(request, Task.class);

                    switch(task.type){
                        case "ADD":
                            todos.addTask(task.task);
                            break;
                        case "REMOVE":
                            todos.removeTask(task.task);
                            break;
                    }

                    System.out.printf("%s: %s",task.type,task.task);
                    out.println(todos.getAllTasks());
                }
            }
        }
        catch (IOException e) {
            System.out.println("Не могу стартовать сервер. Ошибка: " + e.getMessage());
        }
    }

    private class Task{
        String type;
        String task;
    }
}
