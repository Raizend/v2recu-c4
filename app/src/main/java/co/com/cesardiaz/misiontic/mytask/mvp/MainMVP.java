package co.com.cesardiaz.misiontic.mytask.mvp;

import java.util.List;

import co.com.cesardiaz.misiontic.mytask.view.dto.TaskItem;

public interface MainMVP {

    interface Model {

        List<TaskItem> getTask();

        void saveTask(TaskItem task);

        void updateTask(TaskItem item);
    }

    interface Presenter {
        void loadTask();

        void addNewTask();

        void taskItemclicked(TaskItem item);
    }

    interface View {

        void showTaskList(List<TaskItem> items);

        String getTaskDescription();

        void addTaskToList(TaskItem task);

        void updateTask(TaskItem item);
    }

}
