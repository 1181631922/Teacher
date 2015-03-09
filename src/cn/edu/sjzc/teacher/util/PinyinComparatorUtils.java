package cn.edu.sjzc.teacher.util;

import java.util.Comparator;

import cn.edu.sjzc.teacher.bean.StudentUserBean;


public class PinyinComparatorUtils implements Comparator{

//	@Override
//	public int compare(Object o1, Object o2) {
//		 String str1 = PinyinUtils.getPingYin((String) o1);
//	     String str2 = PinyinUtils.getPingYin((String) o2);
//	     return str1.compareTo(str2);
//	}
//	
	@Override
	public int compare(Object o1, Object o2) {
		 String str1 = PinyinUtils.getPingYin(((StudentUserBean) o1).getPy());
	     String str2 = PinyinUtils.getPingYin(((StudentUserBean) o2).getPy());
	     return str1.compareTo(str2);
	}

}
