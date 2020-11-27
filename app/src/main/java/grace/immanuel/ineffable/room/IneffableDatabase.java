package grace.immanuel.ineffable.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import grace.immanuel.ineffable.room.dao.StudentDao;
import grace.immanuel.ineffable.room.entity.Student;

import static grace.immanuel.ineffable.room.RoomMigrationsUtils.MIGRATION_1_2;
import static grace.immanuel.ineffable.room.RoomMigrationsUtils.MIGRATION_1_3;
import static grace.immanuel.ineffable.room.RoomMigrationsUtils.MIGRATION_2_3;

@Database(entities = {Student.class}, version = 1)
public abstract class IneffableDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "ineffable_db";
    private static IneffableDatabase ineffableDatabase;

    public static synchronized IneffableDatabase getInstance(Context context) {
        if (ineffableDatabase == null) {
            ineffableDatabase = Room.databaseBuilder(context.getApplicationContext(),
                    IneffableDatabase.class, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .addMigrations(MIGRATION_1_2, MIGRATION_2_3, MIGRATION_1_3)
                    .build();
        }
        return ineffableDatabase;
    }


    public abstract StudentDao studentDao();
}