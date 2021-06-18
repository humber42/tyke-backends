package cu.edu.cujae.userservice.repository;

import cu.edu.cujae.userservice.domain.Role;
import cu.edu.cujae.userservice.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return jdbcTemplate
                .queryForObject("SELECT count(*) FROM \"user\"", Integer.class);
    }

    @Override
    public Optional<User> findById(Long id) {
        return namedParameterJdbcTemplate.queryForObject(
                "SELECT * FROM \"user\" where id = :id",
                new MapSqlParameterSource("id", id),
                (rs, rowNum) ->
                        Optional.of(new User(
                                rs.getLong("id"),
                                rs.getString("username"),
                                rs.getString("fullname"),
                                rs.getString("email"),
                                findRolesByUserId(id),
                                rs.getString("password"),
                                rs.getDate("dob"),
                                rs.getString("gender"),
                                rs.getString("lang"),
                                rs.getString("status"),
                                rs.getInt("login_attempts"),
                                rs.getInt("profile_id")
                        ))
        );
    }

    @Override
    public List<Role> findRolesByUserId(Long id) {
        return namedParameterJdbcTemplate.query(
                "SELECT r.id, r.role_name, r.description FROM role r inner join user_role ur on r.id = ur.role_id where ur.user_id = :id",
                new MapSqlParameterSource("id", id),
                (rs, rowNum) ->
                        new Role(
                                rs.getLong("id"),
                                rs.getString("role_name"),
                                rs.getString("description")
                        )
        );
    }

    /*@Override
    public int save(User user) { // otra variante para insertar una tupla
        return jdbcTemplate.update(
                "INSERT INTO \"user\" (username, full_name, email, password) VALUES (?,?,?,?)",
                user.getUsername(), user.getFull_name(), user.getEmail(), user.getPassword());
    }*/

    /**
     * This method insert a user on the table
     * @param user
     * @return int value 1 means success 0 means unsuccess
     */
    @Override
    public int save(User user) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("username", user.getUsername());
        mapSqlParameterSource.addValue("fullname", user.getFullname());
        mapSqlParameterSource.addValue("email", user.getEmail());
        mapSqlParameterSource.addValue("password", BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        mapSqlParameterSource.addValue("dob", user.getDob());
        mapSqlParameterSource.addValue("gender", user.getGender());
        mapSqlParameterSource.addValue("lang", user.getLang());
        mapSqlParameterSource.addValue("status","A");

        return namedParameterJdbcTemplate.update(
                "INSERT INTO \"user\" (username, fullname, email, password, dob, gender, lang,status) "
                        + "VALUES (:username, :fullname, :email, :password, :dob, :gender, :lang,:status)",
                mapSqlParameterSource);
    }

    /**
     * This method update an user
     */
    @Override
    public int update(User user) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        //add values to sql  
        mapSqlParameterSource.addValue("id", user.getId());
        mapSqlParameterSource.addValue("username", user.getUsername());
        mapSqlParameterSource.addValue("fullname", user.getFullname());
        mapSqlParameterSource.addValue("email", user.getEmail());
        mapSqlParameterSource.addValue("password", user.getPassword());
        mapSqlParameterSource.addValue("dob", user.getDob());
        mapSqlParameterSource.addValue("gender", user.getGender());
        mapSqlParameterSource.addValue("lang", user.getLang());
        mapSqlParameterSource.addValue("status", user.getStatus());
        mapSqlParameterSource.addValue("login_attempt", user.getLoginAttempt());

        //updating
        return namedParameterJdbcTemplate.update(
                "UPDATE \"user\" SET username = :username, fullname = :fullname, email = :email, password = :password, "
                        + "dob = :dob, gender = :gender, lang = :lang, status = :status, login_attempts = :login_attempt "
                        + "WHERE id = :id",
                mapSqlParameterSource);
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update(
                "DELETE FROM \"user\" WHERE id = ?",
                id);
    }

    @Override
    public List<User> findAll() {
        return namedParameterJdbcTemplate.query(
                "SELECT * FROM \"user\"",
                (rs, rowNum) ->
                        new User(
                                rs.getLong("id"),
                                rs.getString("username"),
                                rs.getString("fullname"),
                                rs.getString("email"),
                                findRolesByUserId(rs.getLong("id")),
                                rs.getString("password"),
                                rs.getDate("dob"),
                                rs.getString("gender"),
                                rs.getString("lang"),
                                rs.getString("status"),
                                rs.getInt("login_attempts"),
                                rs.getInt("profile_id")
                        )
        );
    }

    @Override
    public List<User> findByAttribute(String username, String full_name, String email) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("username", "%" + username + "%");
        mapSqlParameterSource.addValue("fullname", "%" + full_name + "%");
        mapSqlParameterSource.addValue("email", "%" + email + "%");

        return namedParameterJdbcTemplate.query(
                "SELECT * FROM \"user\" WHERE username like :username AND fullname like :fullname AND email like :email",
                mapSqlParameterSource,
                (rs, rowNum) ->
                        new User(
                                rs.getLong("id"),
                                rs.getString("username"),
                                rs.getString("fullname"),
                                rs.getString("email"),
                                findRolesByUserId(rs.getLong("id")),
                                rs.getString("password"),
                                rs.getDate("dob"),
                                rs.getString("gender"),
                                rs.getString("lang"),
                                rs.getString("status"),
                                rs.getInt("login_attempts"),
                                rs.getInt("profile_id")
                        )
        );
    }

    @Override
    public User findByUsername(String username) {
        try {
            return namedParameterJdbcTemplate.queryForObject(
                    "SELECT * FROM \"user\" where username = :username",
                    new MapSqlParameterSource("username", username),
                    (rs, rowNum) ->
                            new User(
                                    rs.getLong("id"),
                                    rs.getString("username"),
                                    rs.getString("fullname"),
                                    rs.getString("email"),
                                    findRolesByUserId(rs.getLong("id")),
                                    rs.getString("password"),
                                    rs.getDate("dob"),
                                    rs.getString("gender"),
                                    rs.getString("lang"),
                                    rs.getString("status"),
                                    rs.getInt("login_attempts"),
                                    rs.getInt("profile_id")
                            )
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public User findByFullname(String fullname) {
        try{
        return namedParameterJdbcTemplate.queryForObject(
                "SELECT * FROM \"user\" where fullname = :fullname",
                new MapSqlParameterSource("fullname", fullname),
                (rs, rowNum) ->
                        new User(
                                rs.getLong("id"),
                                rs.getString("username"),
                                rs.getString("fullname"),
                                rs.getString("email"),
                                findRolesByUserId(rs.getLong("id")),
                                rs.getString("password"),
                                rs.getDate("dob"),
                                rs.getString("gender"),
                                rs.getString("lang"),
                                rs.getString("status"),
                                rs.getInt("login_attempts"),
                                rs.getInt("profile_id")
                        )
        );
    } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public int changePassword(User user) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id", user.getId());
        mapSqlParameterSource.addValue("password", BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        return namedParameterJdbcTemplate.update(
                "UPDATE \"user\" SET password=:password " +
                        "WHERE id=:id"
                , mapSqlParameterSource);
    }


}
