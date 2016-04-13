package com.makingdevs.essentials;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
  
  private List<Task> tasks = new ArrayList<Task>();
  private Scanner scanner;

  public int howManyTasks() {
    return tasks.size();
  }

  public void addTask(Task task) {
    tasks.add(task);
  }

  public void addTask(String string) {
    Task task = new Task(string);
    tasks.add(task);
  }

  public void addTask(List<Task> tasksToAdd) {
    for (Task task : tasksToAdd) {
      tasks.add(task);
    }
  }

  public Task getTaskAt(int i) {
    return tasks.get(i-1);
  }

  public Task findTask(String keyword) {
    for (Task task : tasks) {
      if(task.getTask().equals(keyword)){
        return task;
      }
    }
    return null;
  }

  public List<Task> findTasks(String keyword) {
    List<Task> tasksFound = new ArrayList<Task>();
    for (Task task : tasks) {
      if(task.getTask().equals(keyword)){
        tasksFound.add(task);
      }
    }
    return tasksFound;
  }

  public void addTask(File file) throws FileNotFoundException {
    scanner = new Scanner(file);
    while(scanner.hasNext()){
      addTask(scanner.nextLine());
    }
  }
}