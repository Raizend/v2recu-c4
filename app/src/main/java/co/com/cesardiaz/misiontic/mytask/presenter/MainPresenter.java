package co.com.cesardiaz.misiontic.mytask.presenter;

import android.icu.util.ULocale;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import co.com.cesardiaz.misiontic.mytask.model.MainInteractor;
import co.com.cesardiaz.misiontic.mytask.mvp.MainMVP;
import co.com.cesardiaz.misiontic.mytask.view.dto.TaskItem;
import co.com.cesardiaz.misiontic.mytask.view.dto.TaskState;

public class MainPresenter implements MainMVP.Presenter {

    private MainMVP.View view;
    private MainMVP.Model model;

    public MainPresenter(MainMVP.View view){
        this.view = view;
        model = new MainInteractor() {
            @Override
            public void updateTask(TaskItem item) {

            }
        };
    }

    @Override
    public void loadTask() {
        List<TaskItem> items = model.getTask();

        view.showTaskList(items);
    }

    @Override
    public void addNewTask() {
        String description = view.getTaskDescription();
        String date = SimpleDateFormat.getDateTimeInstance().format(new Date());

        TaskItem task = new TaskItem(description, date);
        model.saveTask(task);
        view.addTaskToList(task);
    }

    @Override
    public void taskItemclicked(TaskItem item) {
        item.setState(TaskState.DONE);

        model.updateTask(item);
        view.updateTask(item);
    }
}
