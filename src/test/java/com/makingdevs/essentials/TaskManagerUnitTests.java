package com.makingdevs.essentials;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TaskManagerUnitTests {

  @Mock
  TaskStore taskStore;

  @InjectMocks
  TaskManager taskManager = new TaskManager();

  @Test
  public void aTaskManagerWithZeroTasks(){
    when(taskStore.count()).thenReturn(0);
    assertTrue(taskManager.howManyTasks() == 0);
    verify(taskStore).count();
  }

  @Test
  public void aTaskManagerWithOneTasks(){
    Task taskMock = new Task();
    when(taskStore.count()).thenReturn(1);
    taskManager.addTask(taskMock);
    assertTrue(taskManager.howManyTasks() == 1);
    verify(taskStore).createTask(taskMock);
    verify(taskStore).count();
  }

  @Test
  public void addATaskFromAString(){
    Task taskMock = new Task();
    doNothing().when(taskStore).createTask(any(Task.class));
    when(taskStore.count()).thenReturn(1);
    taskManager.addTask("new task with String");
    assertTrue(taskManager.howManyTasks() == 1);
    verify(taskStore).createTask(any(Task.class));
    verify(taskStore).count();
  }

  @Test
  public void addATasksFromAList(){
    assertNotNull(taskManager);
    List<Task> tasksToAdd = new ArrayList<Task>();
    tasksToAdd.add(new Task());
    tasksToAdd.add(new Task());
    when(taskStore.count()).thenReturn(2);
    doNothing().when(taskStore).createTask(any(Task.class));
    taskManager.addTask(tasksToAdd);
    assertTrue(taskManager.howManyTasks() == 2);
    verify(taskStore,times(2)).createTask(any(Task.class));
    verify(taskStore).count();
    // atLeastOnce()
    // atLeast(2)
    // atMost(5)
  }

  @Test
  public void addATasksFromAFile(){
    // TODO: Implements the feature
    assertTrue(false);
  }

  @Test
  public void getATaskByIndex(){
    addATaskFromAString();
    when(taskStore.readTask(1L)).thenReturn(new Task());
    Task task = taskManager.getTaskAt(1);
    assertNotNull(task);
    verify(taskStore).readTask(1L);
  }

  @Test
  public void findTaskByDescription(){
    addATaskFromAString();
    when(taskStore.findTask("new task")).thenReturn(new Task());
    Task task = taskManager.findTask("new task");
    assertNotNull(task);
    verify(taskStore).findTask("new task");
  }

  @Test
  public void findAllTasksByDescription(){
    addATasksFromAList();
    List<Task> tasksMocked = new ArrayList<Task>();
    tasksMocked.add(new Task());
    tasksMocked.add(new Task());
    when(taskStore.findAllTasks("new task")).thenReturn(tasksMocked);
    List<Task> tasksFound = taskManager.findTasks("new task");
    assertTrue(tasksFound.size() == 2);
    verify(taskStore).findAllTasks("new task");
  }

}