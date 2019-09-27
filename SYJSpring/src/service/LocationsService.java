package service;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.LocationsDAO;
import vo.Location;

@Service
public class LocationsService {
	
	@Autowired
	private LocationsDAO locationsDAO;
	
	@PostConstruct
	public void init() { Location.setArray(getLocation()); }
	
	public String[] getLocation() {

		String[] array = new String[locationsDAO.selectMaxNo()];
		
		for(Map<String, Object> column : locationsDAO.selectLocations())
			array[(int)column.get("no")-1] = (String)column.get("name");
		
		return array;
		
	} //getLocation();
	
} //class LocationsService
