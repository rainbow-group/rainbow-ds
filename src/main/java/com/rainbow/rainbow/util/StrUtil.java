package com.rainbow.rainbow.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class StrUtil {

	public static String parseToHex(String str) {

		if (str != null && !str.equals("")) {

			byte[] plainText;
			try {
				plainText = str.getBytes("UTF-8");
				MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
				messageDigest.update(plainText);
				byte[] digest = messageDigest.digest();

				StringBuilder stringBuilder = new StringBuilder("");

				if (digest == null || digest.length <= 0) {
					return null;
				}
				for (int i = 0; i < digest.length; i++) {
					int v = digest[i] & 0xFF;
					String hv = Integer.toHexString(v);
					if (hv.length() < 2) {
						stringBuilder.append(0);
					}
					stringBuilder.append(hv);
				}
				return stringBuilder.toString().toUpperCase();

			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	public static String hideName(String name) {
		return name != null ? (name.trim().length() < 3 ? name.substring(0, 1) + "*" : name.substring(0, 1) + "*") : "";
	}

	public static String cutString(String str, int max, String instead) {
		if (str != null && str.length() > max) {
			return str.substring(0, max) + (instead == null ? "" : instead);
		} else {
			return str;
		}
	}

	public static String toLowerCaseFirstOne(String s) {
		if (Character.isLowerCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
	}

	public static String toUpperCaseFirstOne(String s) {
		if (Character.isUpperCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
	}

	public static Boolean hasValue(String str) {
		return (str != null && !str.trim().equals("") && !str.equalsIgnoreCase("null") && !str.equalsIgnoreCase("undefined"));
	}

	public static String translatePartString(String s) {
		if (s != null) {
			return s.replaceAll("[^a-zA-Z0-9]", "");
		}
		return "";
	}
	
	public static String concatString(String str) {
	    String concatStr = "";
	    String tempStr = "";
	    if (str != null) {
	      for (int len = 0; len < str.length(); len++) {
	        tempStr = str.substring(len,len+1);
	        if ((!tempStr.equals(" ")) && (!tempStr.equals("-")) && (!tempStr.equals("/"))&& (!tempStr.equals("'"))) {
	          concatStr += tempStr;
	        }
	      }
	    }
	    return concatStr;
	  }
	
	public static String list2StringFIn(List<String> s) {
		String val = null;
		if (s != null) {

			for (int i = 0; i < s.size(); i++) {
				if (i == 0) {
					val = "'"+s.get(i)+"'";
				} else {
					val += ",'" + s.get(i)+"'";
				}
			}
		}

		return "("+val+")";
	}

	public static String list2String(List<String> s) {
		String val = null;
		if (s != null) {

			for (int i = 0; i < s.size(); i++) {
				if (i == 0) {
					val = s.get(i);
				} else {
					val += "," + s.get(i);
				}
			}
		}

		return val;
	}
	
	public static String list2StringI(List<Integer> s) {
		String val = null;
		if (s != null) {

			for (int i = 0; i < s.size(); i++) {
				if (i == 0) {
					val = s.get(i) + "";
				} else {
					val += "," + s.get(i);
				}
			}
		}

		return val;
	}
	
	public static String parseStringArray(String input){
		if(input == null)
			return "";
		String[] array = input.split(",");
		if(array.length <2)
			return input;
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<array.length;i++){
			sb.append("'"+array[i]+"'");
			if(i!=array.length-1){
				sb.append(",");
			}
		}
		return sb.toString();
	}
	public static boolean isEmpty(final CharSequence cs) {
		return cs == null || ((String) cs).trim().length() == 0;
	}
	
	public static boolean isNotEmpty(final CharSequence cs) {
		return !isEmpty(cs);
	}
	
	public static String padRight(String s, int n) {
	     return String.format("%1$-" + n + "s", s);  
	}
	
	public static String padLeft(String s, int n) {
	    return String.format("%1$" + n + "s", s);  
	}

	public static String checkStr(String val) {
		if (val != null) {
			return " '" + val  + "' ";
		} else {
			return " null ";
		}
	}
	
	public static String convertMfgForDir(String mfg) {
		if(mfg != null) {
			String correctedMfg = " ";
			correctedMfg = mfg.replace(" ", "_");
			correctedMfg = correctedMfg.replace("'", "");
			correctedMfg = correctedMfg.replace("~", "");
			correctedMfg = correctedMfg.replace("`", "");
			correctedMfg = correctedMfg.replace(";", "");
			return correctedMfg;
		} else {
			return "UNKNOWN";
		}
		
	}
	
	public static String checkDate(Date date) {
		if (date != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return " to_date('"+formatter.format(date)+"', 'yyyy-MM-dd HH24:mi:ss') ";
		} else {
			return " null ";
		}
	}
}
