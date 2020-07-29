package tkpm.doan.student.injection;

import java.util.Arrays;
import java.util.List;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import tkpm.doan.student.data.models.Score;

@InstallIn(ApplicationComponent.class)
@Module
public class ScoreModule {
    @Provides
    List<Score> provideScores(Score score) {
        return Arrays.asList(score, score, score, score);
    }
}
