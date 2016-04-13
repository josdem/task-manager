package com.makingdevs.essentials;

import java.util.ArrayList;
import java.util.List;

public class TaskStoreImpl implements TaskStore {
  
  private List<Task> tasks = new ArrayList<Task>();

  @Override
  public void createTask(Task task) {
    tasks.add(task);
  }

  @Override
  public Task readTask(Long pk) {
    return tasks.get(new Long(pk-1L).intValue());
  }

  @Override
  public Task findTask(String description) {
    for (Task task : tasks) {
      if(task.getTask().equals(description)){
        return task;
      }
    }
    return null;
  }

  @Override
  public List<Task> findAllTasks(String description) {
    List<Task> taskFound = new ArrayList<Task>();
    for (Task task : tasks) {
      if(task.getTask().equals(description)){
        taskFound.add(task);
      }
    }
    return taskFound;
  }

  @Override
  public int count() {
    return tasks.size();
  }

}
