package org.activiti.training.activiti7apibasicprocessusertaskservicetaskevents.listeners;

import org.activiti.runtime.api.event.*;
import org.activiti.runtime.api.event.listener.ProcessRuntimeEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MyProcessEventListener implements ProcessRuntimeEventListener {
    private Logger logger = LoggerFactory.getLogger(MyProcessEventListener.class);

    @Override
    public void onEvent(RuntimeEvent runtimeEvent) {

        if (runtimeEvent instanceof ProcessStarted)
            logger.info("Do something, process is started: " + runtimeEvent.toString());
        else if (runtimeEvent instanceof ProcessCompleted)
            logger.info("Do something, process is completed: " + runtimeEvent.toString());
        else if (runtimeEvent instanceof ProcessCancelled)
            logger.info("Do something, process is cancelled: " + runtimeEvent.toString());
        else if (runtimeEvent instanceof ProcessSuspended)
            logger.info("Do something, process is suspended: " + runtimeEvent.toString());
        else if (runtimeEvent instanceof ProcessResumed)
            logger.info("Do something, process is resumed: " + runtimeEvent.toString());
        else if (runtimeEvent instanceof ProcessCreated)
            logger.info("Do something, process is created: " + runtimeEvent.toString());
        else if (runtimeEvent instanceof SequenceFlowTaken)
            logger.info("Do something, sequence flow is taken: " + runtimeEvent.toString());
        else if (runtimeEvent instanceof VariableCreated)
            logger.info("Do something, variable was created: " + runtimeEvent.toString());
        else
            logger.info("Unknown event: " + runtimeEvent.toString());

    }
}
