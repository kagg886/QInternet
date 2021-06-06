package com.QR.To;

import java.lang.reflect.*;
import java.util.*;


public class ObjToString
{

	private static String fg="\n";
	public static String toString(Object objclass)
	{
		String str="";

		try
		{

			//获取数据
			for (Field f : objclass.getClass().getDeclaredFields())
			{

				f.setAccessible(true);
				boolean isStatic = Modifier.isStatic(f.getModifiers());
				if (!isStatic)
				{

					Object obj=f.get(objclass);
					String name=f.getName();
					/*if (obj instanceof byte[])
					 {
					 str += combination(name,HexUtil.bytesToHexStr((byte[])obj));
					 }
					 else */if (obj == null)
					{
						str += combination(name,"Unknown");
					}
					else
					{
						str += combination(name,obj);
					}
				}
			}
		}
		catch (IllegalAccessException e)
		{}
		return str;
	}

	private static String combination(String name,Object obj)
	{
		return name + " : " + obj.toString() + fg;
	}

}

