package tkpm.doan.student.injection;

import java.util.Arrays;
import java.util.List;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import tkpm.doan.student.data.models.Comment;

@InstallIn(ApplicationComponent.class)
@Module
public class CommentModule {
    @Provides
    List<Comment> provideComments(Comment comment) {
        return Arrays.asList(comment, comment, comment, comment, comment);
    }
}
