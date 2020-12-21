package robsense.roblogger.springWebAppDemo.dao;

import org.springframework.stereotype.Repository;
import robsense.roblogger.springWebAppDemo.model.Drone;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("dummyDao")
public class DummyDroneDataAccess implements DroneDAO {
    private static List<Drone> DB = new ArrayList<>();

    @Override
    public int postDrone(Drone drone, UUID uuid) {
        DB.add(new Drone(drone.getLable(),uuid));
        return 1;
    }

    @Override
    public List<Drone> selectAllDrones() {
        return DB;
    }

    @Override
    public Optional<Drone> selectDroneById(UUID id) {
        return DB.stream()
                .filter(drone -> drone.getUuid().equals(id))
                .findFirst();
    }

    @Override
    public int deleteDroneById(UUID id) {
        Optional<Drone> optionalDrone = selectDroneById(id);
        if(optionalDrone.isEmpty()){
            return 0;
        }
        DB.remove(optionalDrone.get());
        return 1;
    }

    @Override
    public int updateDroneById(Drone drone, UUID id) {
        return selectDroneById(id)
                .map(d ->{
                    int indexOfDroneToBeUpdated = DB.indexOf(d);
                    if(indexOfDroneToBeUpdated >= 0) {
                    DB.set(indexOfDroneToBeUpdated, new Drone(drone.getLable(), id));
                    return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

}
//test