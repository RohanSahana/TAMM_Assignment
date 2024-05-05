package com.rohansahana.tamm_assignment.db;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.rohansahana.tamm_assignment.models.University;
import com.rohansahana.tamm_assignment.typeconverters.Converters;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class UniversityDAO_Impl implements UniversityDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<University> __insertionAdapterOfUniversity;

  public UniversityDAO_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUniversity = new EntityInsertionAdapter<University>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `University` (`name`,`alphaTwoCode`,`country`,`domains`,`stateProvince`,`webPages`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final University entity) {
        if (entity.getName() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getName());
        }
        if (entity.getAlphaTwoCode() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getAlphaTwoCode());
        }
        if (entity.getCountry() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getCountry());
        }
        final String _tmp = Converters.INSTANCE.fromList(entity.getDomains());
        if (_tmp == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, _tmp);
        }
        if (entity.getStateProvince() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getStateProvince());
        }
        final String _tmp_1 = Converters.INSTANCE.fromList(entity.getWebPages());
        if (_tmp_1 == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, _tmp_1);
        }
      }
    };
  }

  @Override
  public Object addUniversities(final List<University> universities,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfUniversity.insert(universities);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object getUniversities(final Continuation<? super List<University>> $completion) {
    final String _sql = "SELECT * FROM University";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<University>>() {
      @Override
      @NonNull
      public List<University> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAlphaTwoCode = CursorUtil.getColumnIndexOrThrow(_cursor, "alphaTwoCode");
          final int _cursorIndexOfCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "country");
          final int _cursorIndexOfDomains = CursorUtil.getColumnIndexOrThrow(_cursor, "domains");
          final int _cursorIndexOfStateProvince = CursorUtil.getColumnIndexOrThrow(_cursor, "stateProvince");
          final int _cursorIndexOfWebPages = CursorUtil.getColumnIndexOrThrow(_cursor, "webPages");
          final List<University> _result = new ArrayList<University>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final University _item;
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpAlphaTwoCode;
            if (_cursor.isNull(_cursorIndexOfAlphaTwoCode)) {
              _tmpAlphaTwoCode = null;
            } else {
              _tmpAlphaTwoCode = _cursor.getString(_cursorIndexOfAlphaTwoCode);
            }
            final String _tmpCountry;
            if (_cursor.isNull(_cursorIndexOfCountry)) {
              _tmpCountry = null;
            } else {
              _tmpCountry = _cursor.getString(_cursorIndexOfCountry);
            }
            final List<String> _tmpDomains;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfDomains)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfDomains);
            }
            _tmpDomains = Converters.INSTANCE.fromString(_tmp);
            final String _tmpStateProvince;
            if (_cursor.isNull(_cursorIndexOfStateProvince)) {
              _tmpStateProvince = null;
            } else {
              _tmpStateProvince = _cursor.getString(_cursorIndexOfStateProvince);
            }
            final List<String> _tmpWebPages;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfWebPages)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfWebPages);
            }
            _tmpWebPages = Converters.INSTANCE.fromString(_tmp_1);
            _item = new University(_tmpName,_tmpAlphaTwoCode,_tmpCountry,_tmpDomains,_tmpStateProvince,_tmpWebPages);
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
