package robsense.roblogger.springWebAppDemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import robsense.roblogger.springWebAppDemo.model.Drone;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgresDB")
public class DroneDataAccess implements DroneDAO{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DroneDataAccess(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int postDrone(Drone drone, UUID uuid) {
        return 0;
    }

    @Override
    public List<Drone> selectAllDrones() {
        final String getQuery = "SELECT lable FROM drone";
        return jdbcTemplate.query(getQuery, (resultSet, i) ->{
            String lable = resultSet.getString("lable");
            UUID id = UUID.fromString(resultSet.getString("id"));
            return new Drone(lable, id);
        });
    }

    @Override
    public Optional<Drone> selectDroneById(UUID id) {
        final String sql = "SELECT id, name FROM drone WHERE id = ?";
        Drone drone = jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) ->{
            String lable = resultSet.getString("lable");
            UUID newID = UUID.fromString(resultSet.getString("id"));
            return new Drone(lable, newID);
        });
        return Optional.ofNullable(drone);
    }

    @Override
    public int deleteDroneById(UUID id) {
        return 0;
    }

    @Override
    public int updateDroneById(Drone drone, UUID id) {
        return 0;
    }
}
