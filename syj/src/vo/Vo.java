package vo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;

public class Vo {
	
	public Vo setByResultSet(ResultSet resultSet) {
		
		try {
			
			ResultSetMetaData metaData = resultSet.getMetaData();
			
			for(int i = 1; i <= metaData.getColumnCount(); i++)
				callVoSetter(metaData.getColumnLabel(i), this, resultSet.getObject(i));
			
			
		}catch (SQLException e) { e.printStackTrace(); }
		
		return this;
		
	} //setByResultSet();
	
	private Object callVoSetter(String column, Object obj, Object value) {
		
		System.out.println(column);
		
		try {
			String[] splitArr = column.split("\\.", 2);
			System.out.println(Arrays.toString(splitArr));
			String setter = "set" + splitArr[0].substring(0, 1).toUpperCase() + splitArr[0].substring(1);
			
			Method method = null;
			for(Method _method : obj.getClass().getMethods())
				if(_method.getName().equals(setter)) { method = _method; break; }
			
			if(splitArr.length < 2) {
				switch(method.getParameters()[0].getType().toString()) {
				case "byte": case "class java.lang.Byte": value = value == null ? 0 : ((Integer)value).byteValue();
				case "char": case "class java.lang.Character": value = ((String)value).charAt(0); break;
				case "boolean": case "class java.lang.Boolean": value = value != null && ((Integer)value) != 0;
				}
				method.invoke(obj, value);
			}else {
				Object newInstance = method.getParameters()[0].getType().newInstance();
				method.invoke(obj, newInstance);
				callVoSetter(splitArr[1], newInstance, value);
			}
			
		}catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | InstantiationException e) { e.printStackTrace(); }
		
		return obj;
		
	} //callVoSetter();
	
} //class Vo;
