package robsense.roblogger.springWebAppDemo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import robsense.roblogger.springWebAppDemo.model.Drone;
import robsense.roblogger.springWebAppDemo.service.DroneService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/drone")
@RestController
public class DroneController {
    private final DroneService droneService;
    @Autowired
    public DroneController(DroneService droneService) {
        this.droneService = droneService;
    }

    //Spring annotation, specify on the method in the controller, to map a HTTP request to the URL to this method
    //RequestBody in this case turning the Json object from user request into a Drone
    @PostMapping
    public void addDrone(@RequestBody Drone drone){
        droneService.postDrone(drone);
    }

    @GetMapping
    public List<Drone> getAllDrones(){
        return droneService.getAllDrones();
    }

    @GetMapping(path = "{id}")
    public Drone getDroneById(@Valid @NotNull @PathVariable("id") UUID id){
        return droneService.getDroneById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteDroneById(@PathVariable("id") UUID id){
        droneService.deleteDroneById(id);
    }

    @PutMapping(path = "{id}")
    public void updateDroneService(@Valid @NotNull @RequestBody Drone droneToUpdate, @PathVariable("id") UUID id){
        droneService.updateDroneById(droneToUpdate, id);
    }
}
