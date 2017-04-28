package com.gwy.utils;

import java.util.ArrayList;

/**
 * 对用户输入的字符串进行分词搜索
 * 
 * @author haitang
 *
 */
public class Dictionary {

	private final static String className = "女装男装男鞋女鞋鲜花零食";
	private final static String sort = "上衣裤子连衣裙半身裙高跟鞋平底鞋运动鞋皮鞋";
	private static ArrayList<String> classNameList;

	/**
	 * 对字符串进行分词查询，返回sql语句
	 * 
	 * @param word
	 * @return
	 */
	public static String matchBoth(String word) {
		init();
		boolean flag = false;
		boolean flag_class = false;
		boolean flag_sort = false;
		String selectSql = " select *from commodity where ";
		word = word + " ";
		// 先全匹配class_name
		for (int i = 0; i < word.length() - 1; i++) {
			String spilt = word.substring(i, i + 2);
			// 找到第一个匹配的字符串后就不再匹配
			if (classNameList.contains(spilt)) {
				selectSql = selectSql + " class_name like '%" + spilt + "%' ";
				flag = true;
				flag_class = true;
				break;
			}
		}
		// 全匹配不成功则模糊匹配class_name
		if (flag_class == false) {
			for (int i = 0; i < word.length(); i++) {
				// 找到第一个匹配的字符串后就不再匹配
				if (className.contains(word.charAt(i) + "")) {
					selectSql = selectSql + " class_name like '%" + word.charAt(i) + "%' ";
					flag = true;
					flag_class = true;
					break;
				}
			}
		}
		// 如果前面匹配到了class_name
		if (flag_class == true) {
			selectSql = selectSql + " and (";
		}

		// 匹配sort
		for (int i = 0; i < word.length(); i++) {
			if (sort.contains(word.charAt(i) + "")) {
				if (flag_sort == true) {
					selectSql = selectSql + " or ";
				}
				selectSql = selectSql + " sort like '%" + word.charAt(i) + "%' ";
				flag_sort = true;
				flag = true;
			}
		}

		// 如果前面匹配到了class_name
		if (flag_class == true) {
			selectSql = selectSql + " )";
		}
		if (flag == false) {
			selectSql = null;
		}
		return selectSql;
	}

	/**
	 * 只匹配class_name或者sort
	 * 
	 * @param word
	 * @return
	 */
	public static String match(String word) {
		boolean flag = false;
		String selectSql = "select *from commodity where ";
		for (int i = 0; i < word.length(); i++) {
			// 找到第一个匹配的字符串后就不再匹配
			if (className.contains(word.charAt(i) + "")) {
				if (flag == true) {
					selectSql = selectSql + " or ";
				}
				selectSql = selectSql + " class_name like '%" + word.charAt(i) + "%' ";
				flag = true;
			}
		}
		for (int i = 0; i < word.length(); i++) {
			// 找到第一个匹配的字符串后就不再匹配
			if (sort.contains(word.charAt(i) + "")) {
				if (flag == true) {
					selectSql = selectSql + " or ";
				}
				selectSql = selectSql + " sort like '%" + word.charAt(i) + "%' ";
				flag = true;
			}
		}
		if (flag == false) {
			selectSql = null;
		}
		return selectSql;
	}

	/**
	 * 初始化字典数据
	 */
	private static void init() {
		if (classNameList == null) {
			classNameList = new ArrayList<>();
			classNameList.add("女装");
			classNameList.add("男装");
			classNameList.add("女鞋");
			classNameList.add("男鞋");
			classNameList.add("零食");
			classNameList.add("鲜花");
		}
	}

	public static void main(String[] args) {
		System.out.println(Dictionary.match("鞋裤"));
	}
}
