package robsense.roblogger.springWebAppDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import robsense.roblogger.springWebAppDemo.dao.DroneDAO;
import robsense.roblogger.springWebAppDemo.model.Drone;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class DroneService {
    private final DroneDAO droneDAO;

    @Autowired
    public DroneService(@Qualifier("dummyDao") DroneDAO droneDAO) {
        this.droneDAO = droneDAO;
    }

    //injection, using dummy data access as repository
    public int postDrone(Drone drone){
        return  droneDAO.postDrone(drone);
    }

    public List<Drone> getAllDrones(){
        return droneDAO.selectAllDrones();
    }

    public Optional<Drone> getDroneById(UUID id){
        return droneDAO.selectDroneById(id);
    }

    public int deleteDroneById(UUID id){
        return droneDAO.deleteDroneById(id);
    }

    public int updateDroneById(Drone drone, UUID id){
        return droneDAO.updateDroneById(drone, id);
    }
}
//test