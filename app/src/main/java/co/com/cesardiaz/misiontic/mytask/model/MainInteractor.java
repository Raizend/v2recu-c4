package co.com.cesardiaz.misiontic.mytask.model;

import java.util.ArrayList;
import java.util.List;

import co.com.cesardiaz.misiontic.mytask.mvp.MainMVP;
import co.com.cesardiaz.misiontic.mytask.view.dto.TaskItem;

public class MainInteractor implements MainMVP.Model {

    private List<TaskItem> tempItems;

    public MainInteractor() {
        tempItems = new ArrayList<>();
        tempItems.add(new TaskItem("do the shopping", "november 20, 2021") );

    }

    @Override
    public List<TaskItem> getTask() {
        return tempItems;
    }
}
