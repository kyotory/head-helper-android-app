package com.example.journal;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class DeviceDao_Impl implements DeviceDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Group> __insertionAdapterOfGroup;

  private final EntityInsertionAdapter<Student> __insertionAdapterOfStudent;

  private final EntityInsertionAdapter<Discipline> __insertionAdapterOfDiscipline;

  private final EntityInsertionAdapter<Schedule> __insertionAdapterOfSchedule;

  private final EntityInsertionAdapter<Attendance> __insertionAdapterOfAttendance;

  private final EntityDeletionOrUpdateAdapter<Student> __deletionAdapterOfStudent;

  private final EntityDeletionOrUpdateAdapter<Discipline> __deletionAdapterOfDiscipline;

  private final EntityDeletionOrUpdateAdapter<Schedule> __deletionAdapterOfSchedule;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllGroup;

  private final SharedSQLiteStatement __preparedStmtOfUpdateAttendance;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllDisciplines;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllSchedule;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAttendance;

  public DeviceDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfGroup = new EntityInsertionAdapter<Group>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `GROUPS` (`GROUP_NUMBER`,`AMOUNT_STUDENTS`) VALUES (?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Group entity) {
        statement.bindLong(1, entity.getGROUP_NUMBER());
        statement.bindLong(2, entity.getAMOUNT_STUDENTS());
      }
    };
    this.__insertionAdapterOfStudent = new EntityInsertionAdapter<Student>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `STUDENTS` (`ID_STUDENT`,`GROUP_NUMBER`,`NAME`,`SURNAME`,`PATRONYMIC`) VALUES (?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Student entity) {
        if (entity.getID_STUDENT() == null) {
          statement.bindNull(1);
        } else {
          statement.bindLong(1, entity.getID_STUDENT());
        }
        statement.bindLong(2, entity.getGROUP_NUMBER());
        statement.bindString(3, entity.getNAME());
        statement.bindString(4, entity.getSURNAME());
        statement.bindString(5, entity.getPATRONYMIC());
      }
    };
    this.__insertionAdapterOfDiscipline = new EntityInsertionAdapter<Discipline>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `DISCIPLINES` (`ID_DISCIPLINE`,`NAME`,`GROUP_NUMBER`) VALUES (?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Discipline entity) {
        if (entity.getID_DISCIPLINE() == null) {
          statement.bindNull(1);
        } else {
          statement.bindLong(1, entity.getID_DISCIPLINE());
        }
        statement.bindString(2, entity.getNAME());
        statement.bindLong(3, entity.getGROUP_NUMBER());
      }
    };
    this.__insertionAdapterOfSchedule = new EntityInsertionAdapter<Schedule>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `SCHEDULE` (`ID_PAIR`,`ID_DISCIPLINE`,`DATE_PAIR`,`TIME_PAIR`,`TYPE`) VALUES (?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Schedule entity) {
        if (entity.getID_PAIR() == null) {
          statement.bindNull(1);
        } else {
          statement.bindLong(1, entity.getID_PAIR());
        }
        statement.bindLong(2, entity.getID_DISCIPLINE());
        statement.bindString(3, entity.getDATE_PAIR());
        statement.bindString(4, entity.getTIME_PAIR());
        statement.bindString(5, entity.getTYPE());
      }
    };
    this.__insertionAdapterOfAttendance = new EntityInsertionAdapter<Attendance>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `ATTENDANCE` (`ID_STUDENT`,`ID_PAIR`,`Y/N`) VALUES (?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Attendance entity) {
        statement.bindLong(1, entity.getID_STUDENT());
        statement.bindLong(2, entity.getID_PAIR());
        statement.bindLong(3, entity.getYESORNO());
      }
    };
    this.__deletionAdapterOfStudent = new EntityDeletionOrUpdateAdapter<Student>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `STUDENTS` WHERE `ID_STUDENT` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Student entity) {
        if (entity.getID_STUDENT() == null) {
          statement.bindNull(1);
        } else {
          statement.bindLong(1, entity.getID_STUDENT());
        }
      }
    };
    this.__deletionAdapterOfDiscipline = new EntityDeletionOrUpdateAdapter<Discipline>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `DISCIPLINES` WHERE `ID_DISCIPLINE` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Discipline entity) {
        if (entity.getID_DISCIPLINE() == null) {
          statement.bindNull(1);
        } else {
          statement.bindLong(1, entity.getID_DISCIPLINE());
        }
      }
    };
    this.__deletionAdapterOfSchedule = new EntityDeletionOrUpdateAdapter<Schedule>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `SCHEDULE` WHERE `ID_PAIR` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Schedule entity) {
        if (entity.getID_PAIR() == null) {
          statement.bindNull(1);
        } else {
          statement.bindLong(1, entity.getID_PAIR());
        }
      }
    };
    this.__preparedStmtOfDeleteAllGroup = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM GROUPS";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateAttendance = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE ATTENDANCE SET `Y/N` =? WHERE ID_PAIR =? AND ID_STUDENT =?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAllDisciplines = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM DISCIPLINES";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAllSchedule = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM SCHEDULE";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAttendance = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM ATTENDANCE";
        return _query;
      }
    };
  }

  @Override
  public void insertGroup(final Group item) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfGroup.insert(item);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertStudent(final Student item) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfStudent.insert(item);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertDiscipline(final Discipline item) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfDiscipline.insert(item);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertSchedule(final Schedule item) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSchedule.insert(item);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Object insertAttendance(final Attendance attendance,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfAttendance.insert(attendance);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public void deleteStudent(final Student student) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfStudent.handle(student);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteDiscipline(final Discipline discipline) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfDiscipline.handle(discipline);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteSchedule(final Schedule schedule) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfSchedule.handle(schedule);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAllGroup() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllGroup.acquire();
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfDeleteAllGroup.release(_stmt);
    }
  }

  @Override
  public void updateAttendance(final int idOfPair, final int idOfStudent, final int count) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateAttendance.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, count);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, idOfPair);
    _argIndex = 3;
    _stmt.bindLong(_argIndex, idOfStudent);
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfUpdateAttendance.release(_stmt);
    }
  }

  @Override
  public void deleteAllDisciplines() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllDisciplines.acquire();
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfDeleteAllDisciplines.release(_stmt);
    }
  }

  @Override
  public void deleteAllSchedule() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllSchedule.acquire();
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfDeleteAllSchedule.release(_stmt);
    }
  }

  @Override
  public void deleteAttendance() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAttendance.acquire();
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfDeleteAttendance.release(_stmt);
    }
  }

  @Override
  public int selectGroupNumber() {
    final String _sql = "SELECT GROUP_NUMBER FROM GROUPS LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if (_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getGroupCount() {
    final String _sql = "SELECT COUNT(*) FROM GROUPS";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if (_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Flow<List<Group>> selectAllGroup() {
    final String _sql = "SELECT * FROM GROUPS";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"GROUPS"}, new Callable<List<Group>>() {
      @Override
      @NonNull
      public List<Group> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfGROUPNUMBER = CursorUtil.getColumnIndexOrThrow(_cursor, "GROUP_NUMBER");
          final int _cursorIndexOfAMOUNTSTUDENTS = CursorUtil.getColumnIndexOrThrow(_cursor, "AMOUNT_STUDENTS");
          final List<Group> _result = new ArrayList<Group>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Group _item;
            final int _tmpGROUP_NUMBER;
            _tmpGROUP_NUMBER = _cursor.getInt(_cursorIndexOfGROUPNUMBER);
            final int _tmpAMOUNT_STUDENTS;
            _tmpAMOUNT_STUDENTS = _cursor.getInt(_cursorIndexOfAMOUNTSTUDENTS);
            _item = new Group(_tmpGROUP_NUMBER,_tmpAMOUNT_STUDENTS);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<Student>> selectStudents() {
    final String _sql = "SELECT * FROM STUDENTS ORDER BY SURNAME";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"STUDENTS"}, new Callable<List<Student>>() {
      @Override
      @NonNull
      public List<Student> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfIDSTUDENT = CursorUtil.getColumnIndexOrThrow(_cursor, "ID_STUDENT");
          final int _cursorIndexOfGROUPNUMBER = CursorUtil.getColumnIndexOrThrow(_cursor, "GROUP_NUMBER");
          final int _cursorIndexOfNAME = CursorUtil.getColumnIndexOrThrow(_cursor, "NAME");
          final int _cursorIndexOfSURNAME = CursorUtil.getColumnIndexOrThrow(_cursor, "SURNAME");
          final int _cursorIndexOfPATRONYMIC = CursorUtil.getColumnIndexOrThrow(_cursor, "PATRONYMIC");
          final List<Student> _result = new ArrayList<Student>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Student _item;
            final Integer _tmpID_STUDENT;
            if (_cursor.isNull(_cursorIndexOfIDSTUDENT)) {
              _tmpID_STUDENT = null;
            } else {
              _tmpID_STUDENT = _cursor.getInt(_cursorIndexOfIDSTUDENT);
            }
            final int _tmpGROUP_NUMBER;
            _tmpGROUP_NUMBER = _cursor.getInt(_cursorIndexOfGROUPNUMBER);
            final String _tmpNAME;
            _tmpNAME = _cursor.getString(_cursorIndexOfNAME);
            final String _tmpSURNAME;
            _tmpSURNAME = _cursor.getString(_cursorIndexOfSURNAME);
            final String _tmpPATRONYMIC;
            _tmpPATRONYMIC = _cursor.getString(_cursorIndexOfPATRONYMIC);
            _item = new Student(_tmpID_STUDENT,_tmpGROUP_NUMBER,_tmpNAME,_tmpSURNAME,_tmpPATRONYMIC);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public List<PairWithDiscipline> getPair(final String date) {
    final String _sql = "\n"
            + "    SELECT s.ID_PAIR, d.NAME, s.TYPE \n"
            + "    FROM SCHEDULE s\n"
            + "    JOIN DISCIPLINES d ON s.ID_DISCIPLINE = d.ID_DISCIPLINE\n"
            + "    WHERE s.DATE_PAIR = ?\n"
            + "    ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, date);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfIDPAIR = 0;
      final int _cursorIndexOfNAME = 1;
      final int _cursorIndexOfTYPE = 2;
      final List<PairWithDiscipline> _result = new ArrayList<PairWithDiscipline>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final PairWithDiscipline _item;
        final int _tmpID_PAIR;
        _tmpID_PAIR = _cursor.getInt(_cursorIndexOfIDPAIR);
        final String _tmpNAME;
        _tmpNAME = _cursor.getString(_cursorIndexOfNAME);
        final String _tmpTYPE;
        _tmpTYPE = _cursor.getString(_cursorIndexOfTYPE);
        _item = new PairWithDiscipline(_tmpID_PAIR,_tmpNAME,_tmpTYPE);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<List<Attendance>> getAtt() {
    final String _sql = "SELECT * FROM ATTENDANCE";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"ATTENDANCE"}, false, new Callable<List<Attendance>>() {
      @Override
      @Nullable
      public List<Attendance> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfIDSTUDENT = CursorUtil.getColumnIndexOrThrow(_cursor, "ID_STUDENT");
          final int _cursorIndexOfIDPAIR = CursorUtil.getColumnIndexOrThrow(_cursor, "ID_PAIR");
          final int _cursorIndexOfYESORNO = CursorUtil.getColumnIndexOrThrow(_cursor, "Y/N");
          final List<Attendance> _result = new ArrayList<Attendance>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Attendance _item;
            final int _tmpID_STUDENT;
            _tmpID_STUDENT = _cursor.getInt(_cursorIndexOfIDSTUDENT);
            final int _tmpID_PAIR;
            _tmpID_PAIR = _cursor.getInt(_cursorIndexOfIDPAIR);
            final int _tmpYESORNO;
            _tmpYESORNO = _cursor.getInt(_cursorIndexOfYESORNO);
            _item = new Attendance(_tmpID_STUDENT,_tmpID_PAIR,_tmpYESORNO);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public List<Attendance> getAttDirect() {
    final String _sql = "SELECT * FROM ATTENDANCE";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfIDSTUDENT = CursorUtil.getColumnIndexOrThrow(_cursor, "ID_STUDENT");
      final int _cursorIndexOfIDPAIR = CursorUtil.getColumnIndexOrThrow(_cursor, "ID_PAIR");
      final int _cursorIndexOfYESORNO = CursorUtil.getColumnIndexOrThrow(_cursor, "Y/N");
      final List<Attendance> _result = new ArrayList<Attendance>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Attendance _item;
        final int _tmpID_STUDENT;
        _tmpID_STUDENT = _cursor.getInt(_cursorIndexOfIDSTUDENT);
        final int _tmpID_PAIR;
        _tmpID_PAIR = _cursor.getInt(_cursorIndexOfIDPAIR);
        final int _tmpYESORNO;
        _tmpYESORNO = _cursor.getInt(_cursorIndexOfYESORNO);
        _item = new Attendance(_tmpID_STUDENT,_tmpID_PAIR,_tmpYESORNO);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Student> getStudentsDirect() {
    final String _sql = "SELECT * FROM STUDENTS";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfIDSTUDENT = CursorUtil.getColumnIndexOrThrow(_cursor, "ID_STUDENT");
      final int _cursorIndexOfGROUPNUMBER = CursorUtil.getColumnIndexOrThrow(_cursor, "GROUP_NUMBER");
      final int _cursorIndexOfNAME = CursorUtil.getColumnIndexOrThrow(_cursor, "NAME");
      final int _cursorIndexOfSURNAME = CursorUtil.getColumnIndexOrThrow(_cursor, "SURNAME");
      final int _cursorIndexOfPATRONYMIC = CursorUtil.getColumnIndexOrThrow(_cursor, "PATRONYMIC");
      final List<Student> _result = new ArrayList<Student>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Student _item;
        final Integer _tmpID_STUDENT;
        if (_cursor.isNull(_cursorIndexOfIDSTUDENT)) {
          _tmpID_STUDENT = null;
        } else {
          _tmpID_STUDENT = _cursor.getInt(_cursorIndexOfIDSTUDENT);
        }
        final int _tmpGROUP_NUMBER;
        _tmpGROUP_NUMBER = _cursor.getInt(_cursorIndexOfGROUPNUMBER);
        final String _tmpNAME;
        _tmpNAME = _cursor.getString(_cursorIndexOfNAME);
        final String _tmpSURNAME;
        _tmpSURNAME = _cursor.getString(_cursorIndexOfSURNAME);
        final String _tmpPATRONYMIC;
        _tmpPATRONYMIC = _cursor.getString(_cursorIndexOfPATRONYMIC);
        _item = new Student(_tmpID_STUDENT,_tmpGROUP_NUMBER,_tmpNAME,_tmpSURNAME,_tmpPATRONYMIC);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Flow<List<Discipline>> selectDisciplines() {
    final String _sql = "SELECT * FROM DISCIPLINES";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"DISCIPLINES"}, new Callable<List<Discipline>>() {
      @Override
      @NonNull
      public List<Discipline> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfIDDISCIPLINE = CursorUtil.getColumnIndexOrThrow(_cursor, "ID_DISCIPLINE");
          final int _cursorIndexOfNAME = CursorUtil.getColumnIndexOrThrow(_cursor, "NAME");
          final int _cursorIndexOfGROUPNUMBER = CursorUtil.getColumnIndexOrThrow(_cursor, "GROUP_NUMBER");
          final List<Discipline> _result = new ArrayList<Discipline>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Discipline _item;
            final Integer _tmpID_DISCIPLINE;
            if (_cursor.isNull(_cursorIndexOfIDDISCIPLINE)) {
              _tmpID_DISCIPLINE = null;
            } else {
              _tmpID_DISCIPLINE = _cursor.getInt(_cursorIndexOfIDDISCIPLINE);
            }
            final String _tmpNAME;
            _tmpNAME = _cursor.getString(_cursorIndexOfNAME);
            final int _tmpGROUP_NUMBER;
            _tmpGROUP_NUMBER = _cursor.getInt(_cursorIndexOfGROUPNUMBER);
            _item = new Discipline(_tmpID_DISCIPLINE,_tmpNAME,_tmpGROUP_NUMBER);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getDisciplineIdByName(final String name,
      final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT ID_DISCIPLINE FROM DISCIPLINES WHERE NAME = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, name);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _result;
          if (_cursor.moveToFirst()) {
            _result = _cursor.getInt(0);
          } else {
            _result = 0;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<List<String>> selectAllDisciplineNames() {
    final String _sql = "SELECT NAME FROM DISCIPLINES";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"DISCIPLINES"}, false, new Callable<List<String>>() {
      @Override
      @Nullable
      public List<String> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final List<String> _result = new ArrayList<String>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final String _item;
            _item = _cursor.getString(0);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<Schedule>> selectAllSchedules() {
    final String _sql = "SELECT * FROM SCHEDULE";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"SCHEDULE"}, new Callable<List<Schedule>>() {
      @Override
      @NonNull
      public List<Schedule> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfIDPAIR = CursorUtil.getColumnIndexOrThrow(_cursor, "ID_PAIR");
          final int _cursorIndexOfIDDISCIPLINE = CursorUtil.getColumnIndexOrThrow(_cursor, "ID_DISCIPLINE");
          final int _cursorIndexOfDATEPAIR = CursorUtil.getColumnIndexOrThrow(_cursor, "DATE_PAIR");
          final int _cursorIndexOfTIMEPAIR = CursorUtil.getColumnIndexOrThrow(_cursor, "TIME_PAIR");
          final int _cursorIndexOfTYPE = CursorUtil.getColumnIndexOrThrow(_cursor, "TYPE");
          final List<Schedule> _result = new ArrayList<Schedule>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Schedule _item;
            final Integer _tmpID_PAIR;
            if (_cursor.isNull(_cursorIndexOfIDPAIR)) {
              _tmpID_PAIR = null;
            } else {
              _tmpID_PAIR = _cursor.getInt(_cursorIndexOfIDPAIR);
            }
            final int _tmpID_DISCIPLINE;
            _tmpID_DISCIPLINE = _cursor.getInt(_cursorIndexOfIDDISCIPLINE);
            final String _tmpDATE_PAIR;
            _tmpDATE_PAIR = _cursor.getString(_cursorIndexOfDATEPAIR);
            final String _tmpTIME_PAIR;
            _tmpTIME_PAIR = _cursor.getString(_cursorIndexOfTIMEPAIR);
            final String _tmpTYPE;
            _tmpTYPE = _cursor.getString(_cursorIndexOfTYPE);
            _item = new Schedule(_tmpID_PAIR,_tmpID_DISCIPLINE,_tmpDATE_PAIR,_tmpTIME_PAIR,_tmpTYPE);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object selectAttendanceByDisciplineAndDates(final int disciplineId, final String dateFrom,
      final String dateTo, final Continuation<? super List<Attendance>> $completion) {
    final String _sql = "\n"
            + "        SELECT A.* \n"
            + "        FROM ATTENDANCE A\n"
            + "        JOIN SCHEDULE S ON A.ID_PAIR = S.ID_PAIR\n"
            + "        WHERE S.ID_DISCIPLINE = ? \n"
            + "        AND S.DATE_PAIR BETWEEN ? AND ?\n"
            + "    ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, disciplineId);
    _argIndex = 2;
    _statement.bindString(_argIndex, dateFrom);
    _argIndex = 3;
    _statement.bindString(_argIndex, dateTo);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Attendance>>() {
      @Override
      @NonNull
      public List<Attendance> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfIDSTUDENT = CursorUtil.getColumnIndexOrThrow(_cursor, "ID_STUDENT");
          final int _cursorIndexOfIDPAIR = CursorUtil.getColumnIndexOrThrow(_cursor, "ID_PAIR");
          final int _cursorIndexOfYESORNO = CursorUtil.getColumnIndexOrThrow(_cursor, "Y/N");
          final List<Attendance> _result = new ArrayList<Attendance>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Attendance _item;
            final int _tmpID_STUDENT;
            _tmpID_STUDENT = _cursor.getInt(_cursorIndexOfIDSTUDENT);
            final int _tmpID_PAIR;
            _tmpID_PAIR = _cursor.getInt(_cursorIndexOfIDPAIR);
            final int _tmpYESORNO;
            _tmpYESORNO = _cursor.getInt(_cursorIndexOfYESORNO);
            _item = new Attendance(_tmpID_STUDENT,_tmpID_PAIR,_tmpYESORNO);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object selectAttendanceBetweenDates(final String dateFrom, final String dateTo,
      final Continuation<? super List<Attendance>> $completion) {
    final String _sql = "\n"
            + "        SELECT A.* \n"
            + "        FROM ATTENDANCE A\n"
            + "        JOIN SCHEDULE S ON A.ID_PAIR = S.ID_PAIR\n"
            + "        WHERE S.DATE_PAIR BETWEEN ? AND ?\n"
            + "    ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindString(_argIndex, dateFrom);
    _argIndex = 2;
    _statement.bindString(_argIndex, dateTo);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Attendance>>() {
      @Override
      @NonNull
      public List<Attendance> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfIDSTUDENT = CursorUtil.getColumnIndexOrThrow(_cursor, "ID_STUDENT");
          final int _cursorIndexOfIDPAIR = CursorUtil.getColumnIndexOrThrow(_cursor, "ID_PAIR");
          final int _cursorIndexOfYESORNO = CursorUtil.getColumnIndexOrThrow(_cursor, "Y/N");
          final List<Attendance> _result = new ArrayList<Attendance>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Attendance _item;
            final int _tmpID_STUDENT;
            _tmpID_STUDENT = _cursor.getInt(_cursorIndexOfIDSTUDENT);
            final int _tmpID_PAIR;
            _tmpID_PAIR = _cursor.getInt(_cursorIndexOfIDPAIR);
            final int _tmpYESORNO;
            _tmpYESORNO = _cursor.getInt(_cursorIndexOfYESORNO);
            _item = new Attendance(_tmpID_STUDENT,_tmpID_PAIR,_tmpYESORNO);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getAttendanceRecord(final int idOfPair, final int idOfStudent,
      final Continuation<? super Attendance> $completion) {
    final String _sql = "SELECT * FROM ATTENDANCE WHERE ID_PAIR = ? AND ID_STUDENT = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, idOfPair);
    _argIndex = 2;
    _statement.bindLong(_argIndex, idOfStudent);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Attendance>() {
      @Override
      @Nullable
      public Attendance call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfIDSTUDENT = CursorUtil.getColumnIndexOrThrow(_cursor, "ID_STUDENT");
          final int _cursorIndexOfIDPAIR = CursorUtil.getColumnIndexOrThrow(_cursor, "ID_PAIR");
          final int _cursorIndexOfYESORNO = CursorUtil.getColumnIndexOrThrow(_cursor, "Y/N");
          final Attendance _result;
          if (_cursor.moveToFirst()) {
            final int _tmpID_STUDENT;
            _tmpID_STUDENT = _cursor.getInt(_cursorIndexOfIDSTUDENT);
            final int _tmpID_PAIR;
            _tmpID_PAIR = _cursor.getInt(_cursorIndexOfIDPAIR);
            final int _tmpYESORNO;
            _tmpYESORNO = _cursor.getInt(_cursorIndexOfYESORNO);
            _result = new Attendance(_tmpID_STUDENT,_tmpID_PAIR,_tmpYESORNO);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object selectAllAttendance(final Continuation<? super List<Attendance>> $completion) {
    final String _sql = "SELECT * FROM ATTENDANCE";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Attendance>>() {
      @Override
      @NonNull
      public List<Attendance> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfIDSTUDENT = CursorUtil.getColumnIndexOrThrow(_cursor, "ID_STUDENT");
          final int _cursorIndexOfIDPAIR = CursorUtil.getColumnIndexOrThrow(_cursor, "ID_PAIR");
          final int _cursorIndexOfYESORNO = CursorUtil.getColumnIndexOrThrow(_cursor, "Y/N");
          final List<Attendance> _result = new ArrayList<Attendance>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Attendance _item;
            final int _tmpID_STUDENT;
            _tmpID_STUDENT = _cursor.getInt(_cursorIndexOfIDSTUDENT);
            final int _tmpID_PAIR;
            _tmpID_PAIR = _cursor.getInt(_cursorIndexOfIDPAIR);
            final int _tmpYESORNO;
            _tmpYESORNO = _cursor.getInt(_cursorIndexOfYESORNO);
            _item = new Attendance(_tmpID_STUDENT,_tmpID_PAIR,_tmpYESORNO);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object selectAttendanceByDiscipline(final int disciplineId,
      final Continuation<? super List<Attendance>> $completion) {
    final String _sql = "SELECT * FROM ATTENDANCE WHERE ID_PAIR IN (SELECT ID_PAIR FROM SCHEDULE WHERE ID_DISCIPLINE = ?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, disciplineId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Attendance>>() {
      @Override
      @NonNull
      public List<Attendance> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfIDSTUDENT = CursorUtil.getColumnIndexOrThrow(_cursor, "ID_STUDENT");
          final int _cursorIndexOfIDPAIR = CursorUtil.getColumnIndexOrThrow(_cursor, "ID_PAIR");
          final int _cursorIndexOfYESORNO = CursorUtil.getColumnIndexOrThrow(_cursor, "Y/N");
          final List<Attendance> _result = new ArrayList<Attendance>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Attendance _item;
            final int _tmpID_STUDENT;
            _tmpID_STUDENT = _cursor.getInt(_cursorIndexOfIDSTUDENT);
            final int _tmpID_PAIR;
            _tmpID_PAIR = _cursor.getInt(_cursorIndexOfIDPAIR);
            final int _tmpYESORNO;
            _tmpYESORNO = _cursor.getInt(_cursorIndexOfYESORNO);
            _item = new Attendance(_tmpID_STUDENT,_tmpID_PAIR,_tmpYESORNO);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
