package com.makingdevs.essentials;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

public class TaskManagerIntegrationTests {

  private TaskManager taskManager;

  @Before
  public void setup(){
    taskManager = new TaskManager();
  }

  @Test
  public void aTaskManagerWithZeroTasks(){
    assertNotNull(taskManager);
    assertTrue(taskManager.howManyTasks() == 0);
  }

  @Test
  public void aTaskManagerWithOneTasks(){
    assertNotNull(taskManager);
    taskManager.addTask(new Task());
    assertTrue(taskManager.howManyTasks() == 1);
  }

  @Test
  public void addATaskFromAString(){
    assertNotNull(taskManager);
    taskManager.addTask("new task with String");
    assertTrue(taskManager.howManyTasks() == 1);
  }

  @Test
  public void addATasksFromAList(){
    assertNotNull(taskManager);
    List<Task> tasksToAdd = new ArrayList<Task>();
    tasksToAdd.add(new Task());
    tasksToAdd.add(new Task());
    taskManager.addTask(tasksToAdd);
    assertTrue(taskManager.howManyTasks() == 2);
  }

  @Test
  public void addATasksFromAFile(){
    // TODO: Implements the feature
    assertTrue(false);
  }

  @Test
  public void getATaskByIndex(){
    addATaskFromAString();
    Task task = taskManager.getTaskAt(1);
    assertNotNull(task);
  }

  @Test
  public void findTaskByDescription(){
    addATaskFromAString();
    Task task = taskManager.findTask("new task");
    assertNotNull(task);
  }

  @Test
  public void findAllTasksByDescription(){
    addATasksFromAList();
    List<Task> tasksFound = taskManager.findTasks("new task");
    assertTrue(tasksFound.size() == 2);
  }

}
