package com.example.jetpackcomponentsapp.room;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CustomDatabase_Impl extends CustomDatabase {
  private volatile CustomDAO _customDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(3) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `custom_table` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `Name` TEXT, `Icon` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '97d72d1e8a3e766f6c8f0b3f297c3ea6')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `custom_table`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
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
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsCustomTable = new HashMap<String, TableInfo.Column>(3);
        _columnsCustomTable.put("Id", new TableInfo.Column("Id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomTable.put("Name", new TableInfo.Column("Name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomTable.put("Icon", new TableInfo.Column("Icon", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCustomTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCustomTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCustomTable = new TableInfo("custom_table", _columnsCustomTable, _foreignKeysCustomTable, _indicesCustomTable);
        final TableInfo _existingCustomTable = TableInfo.read(_db, "custom_table");
        if (! _infoCustomTable.equals(_existingCustomTable)) {
          return new RoomOpenHelper.ValidationResult(false, "custom_table(com.example.jetpackcomponentsapp.room.CustomEntity).\n"
                  + " Expected:\n" + _infoCustomTable + "\n"
                  + " Found:\n" + _existingCustomTable);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "97d72d1e8a3e766f6c8f0b3f297c3ea6", "5649e0cbb118a186bc5d5b08c161e0c0");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "custom_table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `custom_table`");
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
  public CustomDAO customDAO() {
    if (_customDAO != null) {
      return _customDAO;
    } else {
      synchronized(this) {
        if(_customDAO == null) {
          _customDAO = new CustomDAO_Impl(this);
        }
        return _customDAO;
      }
    }
  }
}
