package events.huhackathon2022;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RequestDao {
    @Query("SELECT * FROM request")
    List<Request> getAll();

    @Query("SELECT * FROM request WHERE userID IN (:userIds)")
    List<Request> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM request WHERE user_name = (:userName) AND email_address = (:emailAddress)")
    List<Request> loadAllByNameAndEmailAddress(String userName, String emailAddress);

    @Insert
    void insert(Request request);

    @Delete
    void delete(Request request);
}