package Test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import BankCard.Card;
import inter.CardDAO;

public class Test {
	public static void main(String[] args) {
		open();
	}
	public static void getBankCard() {
		try {
			InputStream inputStream = Resources.getResourceAsStream("config.xml");//这里添加的参数是写JDBC驱动的xml文件
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = ssf.openSession(true);
			/*
			 * 这里需要设置将SqlSession设置为true,就是自动提交如果不设置为true，它的默认为false,
			 * 如果不设置需要自己手动的提交在最后要添加session.commit(),所以最好在开始就设置为true
			 * 这和JDBC中的不一样，在JDBC中默认为自动
			 */
			CardDAO dao=session.getMapper(CardDAO.class);//添加DAO类
			Card card=dao.GetCard(800529, 1);//执行SQL获取结果根据返回类型
			System.out.println(card.getMony());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void changePassword() {
		try {
			InputStream inputStream = Resources.getResourceAsStream("config.xml");
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = ssf.openSession(true);
			CardDAO dao=session.getMapper(CardDAO.class);
			System.out.println(dao.modifyPassword(800523,"4444444"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void changeMoney() {
		try {
		InputStream inputStream = Resources.getResourceAsStream("config.xml");
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = ssf.openSession(true);
		CardDAO dao=session.getMapper(CardDAO.class);
		System.out.println(dao.modifyMoney(800523,200));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void open() {
		try {
			InputStream inputStream = Resources.getResourceAsStream("config.xml");
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = ssf.openSession(true);
			CardDAO dao=session.getMapper(CardDAO.class);
			Card card=new Card();
			card.setMoney(200);
			card.setNumber(3322);
			card.setPassword("33465565");
			dao.open(card);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
/*
 * Mybaties的最后Test语句程序比较固定,具体的格式要求见Mybaties。text文件中的中文文档
 */
