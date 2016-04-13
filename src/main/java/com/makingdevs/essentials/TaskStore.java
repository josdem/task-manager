package com.makingdevs.essentials;

import java.util.List;

public interface TaskStore {
  void createTask(Task task);
  Task readTask(Long pk);
  Task findTask(String description);
  List<Task> findAllTasks(String description);
  int count();
}