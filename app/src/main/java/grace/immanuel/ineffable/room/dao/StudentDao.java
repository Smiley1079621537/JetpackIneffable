package grace.immanuel.ineffable.room.dao;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import grace.immanuel.ineffable.room.entity.Student;

@Dao
public interface StudentDao {

    @Insert
    void insertStudent(Student student);

    @Delete
    void deleteStudent(Student student);

    //删全部
    @Query("DELETE FROM student")
    void deleteAll();

    @Update
    void updateStudent(Student student);

    @Query("SELECT * FROM student")
    LiveData<List<Student>> getStudentList();

    @Query("SELECT * FROM student WHERE id = :id")
    Student getStudentById(int id);
}
