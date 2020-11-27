package grace.immanuel.ineffable.room;

import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

public class RoomMigrationsUtils {

    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            //执行与升级相关操作
            database.execSQL("CREATE TABLE temp_Student (" +
                    "id INTEGER PRIMARY KEY NOT NULL," +
                    "name TEXT," +
                    "age TEXT)");
            database.execSQL("INSERT INTO temp_Student (id,name,age)" +
                    "SELECT id,name,age FROM Student");
            database.execSQL("DROP TABLE Student");
            database.execSQL("ALTER TABLE temp_Student RENAME TO Student");
        }
    };

    public static Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            //执行与升级相关操作
        }
    };

    public static Migration MIGRATION_1_3 = new Migration(1, 3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            //执行与升级相关操作
        }
    };
} 