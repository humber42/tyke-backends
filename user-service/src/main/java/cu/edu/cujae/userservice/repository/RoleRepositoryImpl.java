package cu.edu.cujae.userservice.repository;

import cu.edu.cujae.userservice.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleRepositoryImpl implements RoleRepository{

    @Autowired
    private NamedParameterJdbcTemplate template;

    @Override
    public int assignRoleToUser(Long idRole, Long idUser) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("user_id",idUser);
        source.addValue("role_id",idRole);

        return template.update(
                "INSERT INTO \"user_role\"(user_id, role_id) " +
                        "VALUES (:user_id,:role_id)"
                ,source);
    }

    @Override
    public int deleteRole(long id) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("id",id);
        return template.update("DELETE FROM role where " +
                "id=:id",source);
    }

    @Override
    public int removeRoleToUser(Long idRole, Long idUser) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("user_id",idUser);
        source.addValue("role_id",idRole);

        return template.update(
                "DELETE FROM \"user_role\" where user_id=:user_id and role_id=:role_id"
                ,source);
    }

    @Override
    public int saveRole(Role role) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("role_name",role.getRoleName());
        source.addValue("description",role.getDescription());

        return template.update(
                "INSERT INTO role(role_name,description) " +
                        "VALUES (:role_name,:description)"
                ,source);
    }

    @Override
    public List<Role> getAllRols() {
        return template.query(
                "Select * From role",
                (rs,rowNum)->
                    new Role(
                            rs.getLong(1),
                            rs.getString(2),
                            rs.getString(3)
                    )

        );
    }
}
