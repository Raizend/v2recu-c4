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

    public final MainMVP.View view;
    private  final MainMVP.Model model;

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
    public void taskItemClicked(TaskItem task) {
        String message = task.getState() == TaskState.PENDING
                ? "Desea marcar como terminada esta tarea"
                : "Desea marcar como pendiente esta tarea";
        view.showConfirmDialog(message, task);
    }

    @Override
    public void updateTask(TaskItem task) {
        task.setState(task.getState() == TaskState.PENDING ?  TaskState.DONE : TaskState.PENDING );

        model.updateTask(task);
        view.updateTask(task);
    }

    @Override
    public void taskItemLongClicked(TaskItem task) {
        String message = task.getState() == TaskState.PENDING
                ? "Desea marcar como terminada esta tarea"
                : "Desea marcar como pendiente esta tarea";

        view.showDeleteDialog(message, task);
    }

    @Override
    public void deleteTask(TaskItem task) {
        model.deleteTask(task);
        view.deleteTask(task);
    }
}
