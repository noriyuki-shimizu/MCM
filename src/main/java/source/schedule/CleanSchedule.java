package source.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import source.usecases.ICleanUsecase;

@Component
public class CleanSchedule {
    @Autowired
    private ICleanUsecase usecase;

    @Scheduled(cron = "${cron.clean.tables}")
    public void cleanTables() {
        usecase.cleanTables();
    }
}
