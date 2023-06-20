package org.campusmolndal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TodoTests {

 private Todo todoMock;

 @BeforeEach
 void setUp() {
  todoMock = mock(Todo.class);

  Todo mockedTodo = new Todo("mocked id", "mocked text", true);

  when(todoMock.getText()).thenReturn(mockedTodo.getText());
  when(todoMock.isDone()).thenReturn(mockedTodo.isDone());
  when(todoMock.get_id()).thenReturn(mockedTodo.get_id());
  when(todoMock.toString()).thenReturn("mocked text, true, mocked id");
 }

 @Test
 void getText() {
  String expectedText = "mocked text";
  String actualText = todoMock.getText();
  assertEquals(expectedText, actualText);
 }

 @Test
 void isDone() {
  boolean expectedDone = true;
  boolean actualDone = todoMock.isDone();
  assertEquals(expectedDone, actualDone);
 }

 @Test
 void get_id() {
  String expectedId = "mocked id";
  String actualId = todoMock.get_id();
  assertEquals(expectedId, actualId);
 }


}
