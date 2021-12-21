package co.com.cesardiaz.misiontic.mytask.mvp;

import java.util.List;

import co.com.cesardiaz.misiontic.mytask.view.dto.TaskItem;

public interface MainMVP {

    interface Model {

        List<TaskItem> getTask();
    }

    interface Presenter {
        void loadTask();

        void addNewTask();

    }

    interface View {

        void showTaskList(List<TaskItem> items);
    }

}
