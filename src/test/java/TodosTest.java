import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentTypes() {
        SimpleTask simpleTask = new SimpleTask(1, "Buy groceries");

        String[] subtasks = { "Task 1", "Task 2", "Task 3" };
        Epic epic = new Epic(2, subtasks);

        Meeting meeting = new Meeting(3, "Project Review", "Project A", "2023-01-15");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTasksByQuery() {
        SimpleTask simpleTask = new SimpleTask(1, "Buy groceries");

        String[] subtasks = { "Task 1", "Task 2", "Task 3" };
        Epic epic = new Epic(2, subtasks);

        Meeting meeting = new Meeting(3, "Project Review", "Project A", "2023-01-15");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };

        Task[] groceryTasks = todos.search("groceries");
        Assertions.assertArrayEquals(new Task[] { simpleTask }, groceryTasks);

        Task[] reviewTasks = todos.search("Review");
        Assertions.assertArrayEquals(new Task[] { meeting }, reviewTasks);
    }
}