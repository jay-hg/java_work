package com.study.collection;

import java.util.HashMap;
import java.util.Map;

public class MapStudy {

	public static void main(String[] args) {
		Map m = new HashMap();
		m.put("����", "�Ƴ�");
		m.put("�ŷ�", "���");
		m.put("����", "����");
		m.put("����", "����");
		m.put("����", "�͵�");

		Map map = new HashMap();
		map.put("�����", "����");
		map.put("˾��ܲ", "�ٴ�");
		map.put("��ͳ", "ʿԪ");
		System.out.println(m);
		
		System.out.println(m.get("����"));
		m.put("����", "�ϵ�");
		System.out.println(m);
		
		m.remove("����");
		System.out.println(m);
		
		m.putAll(map);
		System.out.println(m);
		
		m.clear();
		System.out.println(m);
	}

}
