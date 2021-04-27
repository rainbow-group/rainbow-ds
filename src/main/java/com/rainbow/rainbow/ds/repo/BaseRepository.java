package com.rainbow.rainbow.ds.repo;

import java.lang.reflect.Field;
import java.sql.ResultSet;

import com.rainbow.rainbow.annotation.Column;
import com.rainbow.rainbow.util.StrUtil;

public class BaseRepository extends BaseConnection {

	protected void fillData(Object object, ResultSet rs) {
		Class clz = object.getClass();
		Field[] fields = clz.getDeclaredFields();

		for (Field f : fields) {
			try {
				String columnName = f.getAnnotation(Column.class).name();
				Object rsValue = null;
				if (columnName != null && !columnName.equals("")) {
					Class fieldType = Class.forName(getFieldTypeClassName(f));
					if (rs.getObject(columnName) != null) {
						rsValue = ResultSet.class.getDeclaredMethod(getRsMethodNameByFieldType(f), String.class)
								.invoke(rs, columnName);
					}
					object.getClass().getMethod(getObjectSetMethodbyField(f), fieldType).invoke(object, rsValue);
				}

			} catch (Exception e) {
				continue;
			}

		}
	}

	protected void fillDataWithoutSpace(Object object, ResultSet rs) {
		Class clz = object.getClass();
		Field[] fields = clz.getDeclaredFields();

		for (Field f : fields) {
			try {
				String columnName = f.getAnnotation(Column.class).name();
				Object rsValue = null;
				if (columnName != null && !columnName.equals("")) {
					Class fieldType = Class.forName(getFieldTypeClassName(f));
					String typeName = StrUtil.toUpperCaseFirstOne(f.getGenericType().toString()
							.substring(f.getGenericType().toString().lastIndexOf(".") + 1).toLowerCase());

					if (rs.getObject(columnName) != null) {
						rsValue = ResultSet.class.getDeclaredMethod(getRsMethodNameByFieldType(f), String.class)
								.invoke(rs, columnName);
					}

					if (typeName.equalsIgnoreCase("String")) {
						if (rsValue != null && !String.valueOf(rsValue).trim().equals("")
								&& !String.valueOf(rsValue).equalsIgnoreCase("null")) {
							object.getClass().getMethod(getObjectSetMethodbyField(f), fieldType).invoke(object,
									rsValue);
						}
					} else {
						object.getClass().getMethod(getObjectSetMethodbyField(f), fieldType).invoke(object, rsValue);
					}
				}

			} catch (Exception e) {
				continue;
			}

		}
	}

	protected void fillDataWithTimestamp(Object object, ResultSet rs) {
		Class clz = object.getClass();
		Field[] fields = clz.getDeclaredFields();

		for (Field f : fields) {
			try {
				String columnName = f.getAnnotation(Column.class).name();
				Object rsValue = null;
				if (columnName != null && !columnName.equals("")) {
					Class fieldType = Class.forName(getFieldTypeClassName(f));
					if (rs.getObject(columnName) != null) {
						rsValue = ResultSet.class
								.getDeclaredMethod(getRsMethodNameByFieldTypeWithTimestamp(f), String.class)
								.invoke(rs, columnName);
					}
					object.getClass().getMethod(getObjectSetMethodbyField(f), fieldType).invoke(object, rsValue);
				}

			} catch (Exception e) {
				continue;
			}

		}
	}

	private String getRsMethodNameByFieldType(Field field) {
		String fieldType = field.getGenericType().toString();

		fieldType = StrUtil.toUpperCaseFirstOne(fieldType.substring(fieldType.lastIndexOf(".") + 1).toLowerCase());

		if (fieldType.equalsIgnoreCase("Integer")) {
			fieldType = "Int";
		}

		if (fieldType.equalsIgnoreCase("Bigdecimal")) {
			fieldType = "BigDecimal";
		}

		String methodName = "get" + fieldType;

		return methodName;
	}

	private String getRsMethodNameByFieldTypeWithTimestamp(Field field) {
		String fieldType = field.getGenericType().toString();

		fieldType = StrUtil.toUpperCaseFirstOne(fieldType.substring(fieldType.lastIndexOf(".") + 1).toLowerCase());

		if (fieldType.equalsIgnoreCase("Integer")) {
			fieldType = "Int";
		}

		if (fieldType.equalsIgnoreCase("Date")) {
			fieldType = "Timestamp";
		}

		String methodName = "get" + fieldType;

		return methodName;
	}

	private String getFieldTypeClassName(Field field) {
		String fieldType = field.getGenericType().toString().replace("class ", "");

		return fieldType;
	}

	private String getObjectSetMethodbyField(Field field) {
		String fieldName = field.getName();
		fieldName = StrUtil.toUpperCaseFirstOne(fieldName.substring(fieldName.lastIndexOf(".") + 1));

		String methodName = "set" + fieldName;

		return methodName;
	}

	protected String getContainsOperator(int contains, String fieldName, String value) {
		String s = "TRIM(UPPER(" + fieldName + "))";

		switch (contains) {
		case 1:
			s += " LIKE '" + value.trim().toUpperCase() + "%'";
			break;
		case 2:
			s += " LIKE '%" + value.trim().toUpperCase() + "'";
			break;
		case 3:
			s += " = '" + value.trim().toUpperCase() + "'";
			break;
		default:
			s += " LIKE '%" + value.trim().toUpperCase() + "%'";
			break;
		}

		return s;
	}
}
