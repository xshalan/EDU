package com.example.myapplication.data.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.myapplication.data.model.LessonModel;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class LessonsDAO_Impl implements LessonsDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfLessonModel;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfLessonModel;

  private final SharedSQLiteStatement __preparedStmtOfUpdateProgressByLessonId;

  private final SharedSQLiteStatement __preparedStmtOfUpdateOpenByLessonId;

  private final SharedSQLiteStatement __preparedStmtOfUpdateDoneByLessonId;

  private final SharedSQLiteStatement __preparedStmtOfUpdateProgressableByLessonId;

  public LessonsDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLessonModel = new EntityInsertionAdapter<LessonModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Lessons`(`id`,`lessonTitle`,`isOpen`,`progress`,`isDone`,`isProgressable`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LessonModel value) {
        stmt.bindLong(1, value.getId());
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        final int _tmp;
        _tmp = value.isOpen() ? 1 : 0;
        stmt.bindLong(3, _tmp);
        stmt.bindLong(4, value.getProgress());
        final int _tmp_1;
        _tmp_1 = value.isDone() ? 1 : 0;
        stmt.bindLong(5, _tmp_1);
        final int _tmp_2;
        _tmp_2 = value.isProgressable() ? 1 : 0;
        stmt.bindLong(6, _tmp_2);
      }
    };
    this.__deletionAdapterOfLessonModel = new EntityDeletionOrUpdateAdapter<LessonModel>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Lessons` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LessonModel value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__preparedStmtOfUpdateProgressByLessonId = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Lessons SET progress=? WHERE id=?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateOpenByLessonId = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Lessons SET isOpen=? WHERE id=?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateDoneByLessonId = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Lessons SET isDone=? WHERE id=?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateProgressableByLessonId = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Lessons SET isProgressable=? WHERE id=?";
        return _query;
      }
    };
  }

  @Override
  public void insertLesson(LessonModel lessonModel) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfLessonModel.insert(lessonModel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteLesson(LessonModel lessonModel) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfLessonModel.handle(lessonModel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateProgressByLessonId(int progress, int id) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateProgressByLessonId.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      _stmt.bindLong(_argIndex, progress);
      _argIndex = 2;
      _stmt.bindLong(_argIndex, id);
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateProgressByLessonId.release(_stmt);
    }
  }

  @Override
  public void updateOpenByLessonId(boolean open, int id) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateOpenByLessonId.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      final int _tmp;
      _tmp = open ? 1 : 0;
      _stmt.bindLong(_argIndex, _tmp);
      _argIndex = 2;
      _stmt.bindLong(_argIndex, id);
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateOpenByLessonId.release(_stmt);
    }
  }

  @Override
  public void updateDoneByLessonId(boolean done, int id) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateDoneByLessonId.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      final int _tmp;
      _tmp = done ? 1 : 0;
      _stmt.bindLong(_argIndex, _tmp);
      _argIndex = 2;
      _stmt.bindLong(_argIndex, id);
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateDoneByLessonId.release(_stmt);
    }
  }

  @Override
  public void updateProgressableByLessonId(boolean progress, int id) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateProgressableByLessonId.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      final int _tmp;
      _tmp = progress ? 1 : 0;
      _stmt.bindLong(_argIndex, _tmp);
      _argIndex = 2;
      _stmt.bindLong(_argIndex, id);
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateProgressableByLessonId.release(_stmt);
    }
  }

  @Override
  public List<LessonModel> getAllLessons() {
    final String _sql = "SELECT * from Lessons";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfTitle = _cursor.getColumnIndexOrThrow("lessonTitle");
      final int _cursorIndexOfIsOpen = _cursor.getColumnIndexOrThrow("isOpen");
      final int _cursorIndexOfProgress = _cursor.getColumnIndexOrThrow("progress");
      final int _cursorIndexOfIsDone = _cursor.getColumnIndexOrThrow("isDone");
      final int _cursorIndexOfIsProgressable = _cursor.getColumnIndexOrThrow("isProgressable");
      final List<LessonModel> _result = new ArrayList<LessonModel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final LessonModel _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        _item = new LessonModel(_tmpId,_tmpTitle);
        final boolean _tmpIsOpen;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsOpen);
        _tmpIsOpen = _tmp != 0;
        _item.setOpen(_tmpIsOpen);
        final int _tmpProgress;
        _tmpProgress = _cursor.getInt(_cursorIndexOfProgress);
        _item.setProgress(_tmpProgress);
        final boolean _tmpIsDone;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsDone);
        _tmpIsDone = _tmp_1 != 0;
        _item.setDone(_tmpIsDone);
        final boolean _tmpIsProgressable;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfIsProgressable);
        _tmpIsProgressable = _tmp_2 != 0;
        _item.setProgressable(_tmpIsProgressable);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LessonModel getLessonById(int id) {
    final String _sql = "SELECT * from Lessons WHERE id = ? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfTitle = _cursor.getColumnIndexOrThrow("lessonTitle");
      final int _cursorIndexOfIsOpen = _cursor.getColumnIndexOrThrow("isOpen");
      final int _cursorIndexOfProgress = _cursor.getColumnIndexOrThrow("progress");
      final int _cursorIndexOfIsDone = _cursor.getColumnIndexOrThrow("isDone");
      final int _cursorIndexOfIsProgressable = _cursor.getColumnIndexOrThrow("isProgressable");
      final LessonModel _result;
      if(_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        _result = new LessonModel(_tmpId,_tmpTitle);
        final boolean _tmpIsOpen;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsOpen);
        _tmpIsOpen = _tmp != 0;
        _result.setOpen(_tmpIsOpen);
        final int _tmpProgress;
        _tmpProgress = _cursor.getInt(_cursorIndexOfProgress);
        _result.setProgress(_tmpProgress);
        final boolean _tmpIsDone;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsDone);
        _tmpIsDone = _tmp_1 != 0;
        _result.setDone(_tmpIsDone);
        final boolean _tmpIsProgressable;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfIsProgressable);
        _tmpIsProgressable = _tmp_2 != 0;
        _result.setProgressable(_tmpIsProgressable);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
