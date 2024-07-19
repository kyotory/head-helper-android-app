package com.example.journal;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class MainDb_Impl extends MainDb {
  private volatile DeviceDao _deviceDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `GROUPS` (`GROUP_NUMBER` INTEGER NOT NULL, `AMOUNT_STUDENTS` INTEGER NOT NULL, PRIMARY KEY(`GROUP_NUMBER`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `STUDENTS` (`ID_STUDENT` INTEGER PRIMARY KEY AUTOINCREMENT, `GROUP_NUMBER` INTEGER NOT NULL, `NAME` TEXT NOT NULL, `SURNAME` TEXT NOT NULL, `PATRONYMIC` TEXT NOT NULL, FOREIGN KEY(`GROUP_NUMBER`) REFERENCES `GROUPS`(`GROUP_NUMBER`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_STUDENTS_GROUP_NUMBER` ON `STUDENTS` (`GROUP_NUMBER`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `DISCIPLINES` (`ID_DISCIPLINE` INTEGER PRIMARY KEY AUTOINCREMENT, `NAME` TEXT NOT NULL, `GROUP_NUMBER` INTEGER NOT NULL)");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_DISCIPLINES_GROUP_NUMBER` ON `DISCIPLINES` (`GROUP_NUMBER`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `ATTENDANCE` (`ID_STUDENT` INTEGER NOT NULL, `ID_PAIR` INTEGER NOT NULL, `Y/N` INTEGER NOT NULL, PRIMARY KEY(`ID_STUDENT`, `ID_PAIR`), FOREIGN KEY(`ID_PAIR`) REFERENCES `SCHEDULE`(`ID_PAIR`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`ID_STUDENT`) REFERENCES `STUDENTS`(`ID_STUDENT`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_ATTENDANCE_ID_PAIR` ON `ATTENDANCE` (`ID_PAIR`)");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_ATTENDANCE_ID_STUDENT` ON `ATTENDANCE` (`ID_STUDENT`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `SCHEDULE` (`ID_PAIR` INTEGER PRIMARY KEY AUTOINCREMENT, `ID_DISCIPLINE` INTEGER NOT NULL, `DATE_PAIR` TEXT NOT NULL, `TIME_PAIR` TEXT NOT NULL, `TYPE` TEXT NOT NULL, FOREIGN KEY(`ID_DISCIPLINE`) REFERENCES `DISCIPLINES`(`ID_DISCIPLINE`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_SCHEDULE_ID_DISCIPLINE` ON `SCHEDULE` (`ID_DISCIPLINE`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'f930b3e93f61d1b0774fa2a45a39f77a')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `GROUPS`");
        db.execSQL("DROP TABLE IF EXISTS `STUDENTS`");
        db.execSQL("DROP TABLE IF EXISTS `DISCIPLINES`");
        db.execSQL("DROP TABLE IF EXISTS `ATTENDANCE`");
        db.execSQL("DROP TABLE IF EXISTS `SCHEDULE`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsGROUPS = new HashMap<String, TableInfo.Column>(2);
        _columnsGROUPS.put("GROUP_NUMBER", new TableInfo.Column("GROUP_NUMBER", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGROUPS.put("AMOUNT_STUDENTS", new TableInfo.Column("AMOUNT_STUDENTS", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysGROUPS = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesGROUPS = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoGROUPS = new TableInfo("GROUPS", _columnsGROUPS, _foreignKeysGROUPS, _indicesGROUPS);
        final TableInfo _existingGROUPS = TableInfo.read(db, "GROUPS");
        if (!_infoGROUPS.equals(_existingGROUPS)) {
          return new RoomOpenHelper.ValidationResult(false, "GROUPS(com.example.journal.Group).\n"
                  + " Expected:\n" + _infoGROUPS + "\n"
                  + " Found:\n" + _existingGROUPS);
        }
        final HashMap<String, TableInfo.Column> _columnsSTUDENTS = new HashMap<String, TableInfo.Column>(5);
        _columnsSTUDENTS.put("ID_STUDENT", new TableInfo.Column("ID_STUDENT", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTUDENTS.put("GROUP_NUMBER", new TableInfo.Column("GROUP_NUMBER", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTUDENTS.put("NAME", new TableInfo.Column("NAME", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTUDENTS.put("SURNAME", new TableInfo.Column("SURNAME", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSTUDENTS.put("PATRONYMIC", new TableInfo.Column("PATRONYMIC", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSTUDENTS = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysSTUDENTS.add(new TableInfo.ForeignKey("GROUPS", "NO ACTION", "NO ACTION", Arrays.asList("GROUP_NUMBER"), Arrays.asList("GROUP_NUMBER")));
        final HashSet<TableInfo.Index> _indicesSTUDENTS = new HashSet<TableInfo.Index>(1);
        _indicesSTUDENTS.add(new TableInfo.Index("index_STUDENTS_GROUP_NUMBER", false, Arrays.asList("GROUP_NUMBER"), Arrays.asList("ASC")));
        final TableInfo _infoSTUDENTS = new TableInfo("STUDENTS", _columnsSTUDENTS, _foreignKeysSTUDENTS, _indicesSTUDENTS);
        final TableInfo _existingSTUDENTS = TableInfo.read(db, "STUDENTS");
        if (!_infoSTUDENTS.equals(_existingSTUDENTS)) {
          return new RoomOpenHelper.ValidationResult(false, "STUDENTS(com.example.journal.Student).\n"
                  + " Expected:\n" + _infoSTUDENTS + "\n"
                  + " Found:\n" + _existingSTUDENTS);
        }
        final HashMap<String, TableInfo.Column> _columnsDISCIPLINES = new HashMap<String, TableInfo.Column>(3);
        _columnsDISCIPLINES.put("ID_DISCIPLINE", new TableInfo.Column("ID_DISCIPLINE", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDISCIPLINES.put("NAME", new TableInfo.Column("NAME", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDISCIPLINES.put("GROUP_NUMBER", new TableInfo.Column("GROUP_NUMBER", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDISCIPLINES = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesDISCIPLINES = new HashSet<TableInfo.Index>(1);
        _indicesDISCIPLINES.add(new TableInfo.Index("index_DISCIPLINES_GROUP_NUMBER", false, Arrays.asList("GROUP_NUMBER"), Arrays.asList("ASC")));
        final TableInfo _infoDISCIPLINES = new TableInfo("DISCIPLINES", _columnsDISCIPLINES, _foreignKeysDISCIPLINES, _indicesDISCIPLINES);
        final TableInfo _existingDISCIPLINES = TableInfo.read(db, "DISCIPLINES");
        if (!_infoDISCIPLINES.equals(_existingDISCIPLINES)) {
          return new RoomOpenHelper.ValidationResult(false, "DISCIPLINES(com.example.journal.Discipline).\n"
                  + " Expected:\n" + _infoDISCIPLINES + "\n"
                  + " Found:\n" + _existingDISCIPLINES);
        }
        final HashMap<String, TableInfo.Column> _columnsATTENDANCE = new HashMap<String, TableInfo.Column>(3);
        _columnsATTENDANCE.put("ID_STUDENT", new TableInfo.Column("ID_STUDENT", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsATTENDANCE.put("ID_PAIR", new TableInfo.Column("ID_PAIR", "INTEGER", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsATTENDANCE.put("Y/N", new TableInfo.Column("Y/N", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysATTENDANCE = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysATTENDANCE.add(new TableInfo.ForeignKey("SCHEDULE", "NO ACTION", "NO ACTION", Arrays.asList("ID_PAIR"), Arrays.asList("ID_PAIR")));
        _foreignKeysATTENDANCE.add(new TableInfo.ForeignKey("STUDENTS", "NO ACTION", "NO ACTION", Arrays.asList("ID_STUDENT"), Arrays.asList("ID_STUDENT")));
        final HashSet<TableInfo.Index> _indicesATTENDANCE = new HashSet<TableInfo.Index>(2);
        _indicesATTENDANCE.add(new TableInfo.Index("index_ATTENDANCE_ID_PAIR", false, Arrays.asList("ID_PAIR"), Arrays.asList("ASC")));
        _indicesATTENDANCE.add(new TableInfo.Index("index_ATTENDANCE_ID_STUDENT", false, Arrays.asList("ID_STUDENT"), Arrays.asList("ASC")));
        final TableInfo _infoATTENDANCE = new TableInfo("ATTENDANCE", _columnsATTENDANCE, _foreignKeysATTENDANCE, _indicesATTENDANCE);
        final TableInfo _existingATTENDANCE = TableInfo.read(db, "ATTENDANCE");
        if (!_infoATTENDANCE.equals(_existingATTENDANCE)) {
          return new RoomOpenHelper.ValidationResult(false, "ATTENDANCE(com.example.journal.Attendance).\n"
                  + " Expected:\n" + _infoATTENDANCE + "\n"
                  + " Found:\n" + _existingATTENDANCE);
        }
        final HashMap<String, TableInfo.Column> _columnsSCHEDULE = new HashMap<String, TableInfo.Column>(5);
        _columnsSCHEDULE.put("ID_PAIR", new TableInfo.Column("ID_PAIR", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSCHEDULE.put("ID_DISCIPLINE", new TableInfo.Column("ID_DISCIPLINE", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSCHEDULE.put("DATE_PAIR", new TableInfo.Column("DATE_PAIR", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSCHEDULE.put("TIME_PAIR", new TableInfo.Column("TIME_PAIR", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSCHEDULE.put("TYPE", new TableInfo.Column("TYPE", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSCHEDULE = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysSCHEDULE.add(new TableInfo.ForeignKey("DISCIPLINES", "NO ACTION", "NO ACTION", Arrays.asList("ID_DISCIPLINE"), Arrays.asList("ID_DISCIPLINE")));
        final HashSet<TableInfo.Index> _indicesSCHEDULE = new HashSet<TableInfo.Index>(1);
        _indicesSCHEDULE.add(new TableInfo.Index("index_SCHEDULE_ID_DISCIPLINE", false, Arrays.asList("ID_DISCIPLINE"), Arrays.asList("ASC")));
        final TableInfo _infoSCHEDULE = new TableInfo("SCHEDULE", _columnsSCHEDULE, _foreignKeysSCHEDULE, _indicesSCHEDULE);
        final TableInfo _existingSCHEDULE = TableInfo.read(db, "SCHEDULE");
        if (!_infoSCHEDULE.equals(_existingSCHEDULE)) {
          return new RoomOpenHelper.ValidationResult(false, "SCHEDULE(com.example.journal.Schedule).\n"
                  + " Expected:\n" + _infoSCHEDULE + "\n"
                  + " Found:\n" + _existingSCHEDULE);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "f930b3e93f61d1b0774fa2a45a39f77a", "4d69df4d6c8e8d2243aec7ed82a00dcf");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "GROUPS","STUDENTS","DISCIPLINES","ATTENDANCE","SCHEDULE");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    final boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `STUDENTS`");
      _db.execSQL("DELETE FROM `GROUPS`");
      _db.execSQL("DELETE FROM `SCHEDULE`");
      _db.execSQL("DELETE FROM `DISCIPLINES`");
      _db.execSQL("DELETE FROM `ATTENDANCE`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(DeviceDao.class, DeviceDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public DeviceDao getDao() {
    if (_deviceDao != null) {
      return _deviceDao;
    } else {
      synchronized(this) {
        if(_deviceDao == null) {
          _deviceDao = new DeviceDao_Impl(this);
        }
        return _deviceDao;
      }
    }
  }
}
