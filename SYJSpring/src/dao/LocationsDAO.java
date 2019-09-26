package dao;

import java.util.List;
import java.util.Map;

public interface LocationsDAO {
	
	public int selectMaxNo();
	public List<Map<String, Object>> selectLocations();
	
} //interface LocationsDAO
