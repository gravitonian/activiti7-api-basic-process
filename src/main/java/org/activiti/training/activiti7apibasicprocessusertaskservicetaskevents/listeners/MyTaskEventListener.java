package org.activiti.training.activiti7apibasicprocessusertaskservicetaskevents.listeners;

import org.activiti.runtime.api.event.*;
import org.activiti.runtime.api.event.listener.TaskRuntimeEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MyTaskEventListener implements TaskRuntimeEventListener {
    private Logger logger = LoggerFactory.getLogger(MyTaskEventListener.class);

    @Override
    public void onEvent(RuntimeEvent runtimeEvent) {

        if (runtimeEvent instanceof TaskActivated)
            logger.info("Do something, task is activated: " + runtimeEvent.toString());
        else if (runtimeEvent instanceof TaskAssigned)
            logger.info("Do something, task is assigned: " + runtimeEvent.toString());
        else if (runtimeEvent instanceof TaskCancelled)
            logger.info("Do something, task is cancelled: " + runtimeEvent.toString());
        else if (runtimeEvent instanceof TaskCompleted)
            logger.info("Do something, task is completed: " + runtimeEvent.toString());
        else if (runtimeEvent instanceof TaskCreated)
            logger.info("Do something, task is created: " + runtimeEvent.toString());
        else if (runtimeEvent instanceof TaskSuspended)
            logger.info("Do something, task is suspended: " + runtimeEvent.toString());
        else
            logger.info("Unknown event: " + runtimeEvent.toString());

    }
}
