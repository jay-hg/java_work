package com.study.collection;

import java.util.HashMap;
import java.util.Map;

public class MapStudy {

	public static void main(String[] args) {
		Map m = new HashMap();
		m.put("关羽", "云长");
		m.put("张飞", "翼德");
		m.put("赵云", "子龙");
		m.put("黄忠", "汉升");
		m.put("刘备", "贤德");

		Map map = new HashMap();
		map.put("诸葛亮", "孔明");
		map.put("司马懿", "仲达");
		map.put("庞统", "士元");
		System.out.println(m);
		
		System.out.println(m.get("赵云"));
		m.put("刘备", "孟德");
		System.out.println(m);
		
		m.remove("关羽");
		System.out.println(m);
		
		m.putAll(map);
		System.out.println(m);
		
		m.clear();
		System.out.println(m);
	}

}
