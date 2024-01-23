package ru.netology.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);
    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    @Test
    public void shouldFindTaskInSimpleTask() {
        Boolean expected = true;
        Boolean actual = simpleTask.matches("Позвонить");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindTaskInSimpleTask() {
        Boolean expected = false;
        Boolean actual = simpleTask.matches("hello");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindTaskInEpic() {
        Boolean expected = true;
        Boolean actual = epic.matches("Хле");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindTaskInEpic() {
        Boolean expected = false;
        Boolean actual = epic.matches("Винишко");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindTaskInMeetingProject() {
        Boolean expected = true;
        Boolean actual = meeting.matches("НетоБанк");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindTaskInMeetingTopic() {
        Boolean expected = true;
        Boolean actual = meeting.matches("Выкатка");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindTaskInMeeting() {
        Boolean expected = false;
        Boolean actual = meeting.matches("СберБанк");

        Assertions.assertEquals(expected, actual);
    }
}
