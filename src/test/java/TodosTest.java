import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldSearchTasksByQueryWhenMultipleTasksMatch() {

        SimpleTask simpleTask1 = new SimpleTask(1, "Buy groceries");
        SimpleTask simpleTask2 = new SimpleTask(2, "Buy gifts");
        SimpleTask simpleTask3 = new SimpleTask(3, "Buy books");

        Todos todos = new Todos();
        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(simpleTask3);

        // Тест: Находится несколько задач
        Task[] groceryTasks = todos.search("Buy");
        Task[] expected = { simpleTask1, simpleTask2, simpleTask3 };
        Assertions.assertArrayEquals(expected, groceryTasks);
    }
    @Test
    public void shouldAddThreeTasksOfDifferentTypes() {

        SimpleTask simpleTask = new SimpleTask(1, "Buy groceries");
        String[] subtasks = {"Task 1", "Task 2", "Task 3"};
        Epic epic = new Epic(2, subtasks);
        Meeting meeting = new Meeting(3, "Project Review", "Project A", "2023-01-15");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);


        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTasksByQuery() {

        SimpleTask simpleTask = new SimpleTask(1, "Buy groceries");
        String[] subtasks = {"Task 1", "Task 2", "Task 3"};
        Epic epic = new Epic(2, subtasks);
        Meeting meeting = new Meeting(3, "Project Review", "Project A", "2023-01-15");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        // Тест 1: Находится несколько задач
        Task[] groceryTasks = todos.search("groceries");
        Assertions.assertArrayEquals(new Task[]{simpleTask}, groceryTasks);

        // Тест 2: Находится ровно одна задача
        Task[] reviewTasks = todos.search("Review");
        Assertions.assertArrayEquals(new Task[]{meeting}, reviewTasks);

        // Тест 3: Не находится ни одной задачи
        Task[] nonExistentTasks = todos.search("Vacation");
        Assertions.assertArrayEquals(new Task[0], nonExistentTasks);
    }
}
