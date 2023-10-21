import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void shouldMatchSimpleTaskWithQuery() {
        SimpleTask simpleTask = new SimpleTask(1, "Buy groceries");
        Assertions.assertTrue(simpleTask.matches("groceries"));
        Assertions.assertFalse(simpleTask.matches("vacation"));
    }

    @Test
    public void shouldMatchEpicWithQuery() {
        String[] subtasks = { "Task 1", "Task 2", "Task 3" };
        Epic epic = new Epic(2, subtasks);
        Assertions.assertTrue(epic.matches("Task 2"));
        Assertions.assertFalse(epic.matches("meeting"));
    }

    @Test
    public void shouldMatchMeetingWithQuery() {
        Meeting meeting = new Meeting(3, "Project Review", "Project A", "2023-01-15");
        Assertions.assertTrue(meeting.matches("Review"));
        Assertions.assertTrue(meeting.matches("A"));
        Assertions.assertFalse(meeting.matches("Task"));
    }
}
