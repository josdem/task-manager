package com.makingdevs.essentials;

import java.util.List;

public class TaskManager {

  private TaskStore taskStore;
  
  public TaskManager(){
    taskStore = new TaskStoreImpl();
  }

  public int howManyTasks() {
    return taskStore.count();
  }

  public void addTask(Task task) {
    taskStore.createTask(task);
  }
  
  public void addTask(String description) {
    Task task = new Task(description);
    taskStore.createTask(task);
  }

  public void addTask(List<Task> tasksToAdd) {
    for(Task task:tasksToAdd){
      taskStore.createTask(task);
    }
  }

  public Task getTaskAt(int i) {
    return taskStore.readTask(new Integer(i).longValue());
  }

  public Task findTask(String description) {
    return taskStore.findTask(description);
  }

  public List<Task> findTasks(String description) {
    return taskStore.findAllTasks(description);
  }
}