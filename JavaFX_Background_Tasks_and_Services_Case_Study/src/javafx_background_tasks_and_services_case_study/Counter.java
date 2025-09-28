package javafx_background_tasks_and_services_case_study;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class Counter extends Service<Long> {

    private Long target;

    public Counter() {
    }

    public Counter(Long target) {
        this.target = target;
    }

    public Long getTarget() {
        return target;
    }

    public void setTarget(Long target) {
        this.target = target;
    }

    @Override
    protected Task<Long> createTask() {

        return new Task<Long>() {
            @Override
            protected Long call() throws Exception {
                for (long i = 0; i <= target; i++) {
                    if (isCancelled()) {
                        break;
                    }

                    updateValue(i);
                    updateProgress(i, target);
                }
                return target;
            }
        };
    }

}
