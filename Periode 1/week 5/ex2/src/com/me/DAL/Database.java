package com.me.DAL;

import com.me.models.Task;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Task> taskList = new ArrayList<>();

    public List<Task> getTaskList() {
        return taskList;
    }
}
