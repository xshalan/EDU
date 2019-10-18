package com.example.myapplication.data.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.example.myapplication.data.dao.LessonsDAO;
import com.example.myapplication.data.dao.LessonsDAO_Impl;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public final class LessonsDatabase_Impl extends LessonsDatabase {
  private volatile LessonsDAO _lessonsDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Lessons` (`id` INTEGER NOT NULL, `lessonTitle` TEXT, `isOpen` INTEGER NOT NULL, `progress` INTEGER NOT NULL, `isDone` INTEGER NOT NULL, `isProgressable` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"fa74188feb1ca627e3df3ee89193e6ef\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Lessons`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsLessons = new HashMap<String, TableInfo.Column>(6);
        _columnsLessons.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsLessons.put("lessonTitle", new TableInfo.Column("lessonTitle", "TEXT", false, 0));
        _columnsLessons.put("isOpen", new TableInfo.Column("isOpen", "INTEGER", true, 0));
        _columnsLessons.put("progress", new TableInfo.Column("progress", "INTEGER", true, 0));
        _columnsLessons.put("isDone", new TableInfo.Column("isDone", "INTEGER", true, 0));
        _columnsLessons.put("isProgressable", new TableInfo.Column("isProgressable", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLessons = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLessons = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLessons = new TableInfo("Lessons", _columnsLessons, _foreignKeysLessons, _indicesLessons);
        final TableInfo _existingLessons = TableInfo.read(_db, "Lessons");
        if (! _infoLessons.equals(_existingLessons)) {
          throw new IllegalStateException("Migration didn't properly handle Lessons(com.example.myapplication.data.model.LessonModel).\n"
                  + " Expected:\n" + _infoLessons + "\n"
                  + " Found:\n" + _existingLessons);
        }
      }
    }, "fa74188feb1ca627e3df3ee89193e6ef", "fcd8c71023dba1c89e432db437dcc449");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "Lessons");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Lessons`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public LessonsDAO lessonsDAO() {
    if (_lessonsDAO != null) {
      return _lessonsDAO;
    } else {
      synchronized(this) {
        if(_lessonsDAO == null) {
          _lessonsDAO = new LessonsDAO_Impl(this);
        }
        return _lessonsDAO;
      }
    }
  }
}
