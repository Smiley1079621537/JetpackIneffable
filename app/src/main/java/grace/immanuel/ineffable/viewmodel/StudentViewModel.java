package grace.immanuel.ineffable.viewmodel;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import grace.immanuel.ineffable.room.IneffableDatabase;
import grace.immanuel.ineffable.room.entity.Student;

public class StudentViewModel extends AndroidViewModel {

    private IneffableDatabase ineffableDatabase;
    private LiveData<List<Student>> liveDataStudents;

    public StudentViewModel(@NonNull Application application) {
        super(application);
        ineffableDatabase = IneffableDatabase.getInstance(application);
        liveDataStudents = ineffableDatabase.studentDao().getStudentList();
    }

    public LiveData<List<Student>> getLiveDataStudents() {
        return liveDataStudents;
    }
}