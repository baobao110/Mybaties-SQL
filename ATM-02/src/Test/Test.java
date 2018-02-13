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
			InputStream inputStream = Resources.getResourceAsStream("config.xml");//������ӵĲ�����дJDBC������xml�ļ�
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = ssf.openSession(true);
			/*
			 * ������Ҫ���ý�SqlSession����Ϊtrue,�����Զ��ύ���������Ϊtrue������Ĭ��Ϊfalse,
			 * �����������Ҫ�Լ��ֶ����ύ�����Ҫ���session.commit(),��������ڿ�ʼ������Ϊtrue
			 * ���JDBC�еĲ�һ������JDBC��Ĭ��Ϊ�Զ�
			 */
			CardDAO dao=session.getMapper(CardDAO.class);//���DAO��
			Card card=dao.GetCard(800529, 1);//ִ��SQL��ȡ������ݷ�������
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
 * Mybaties�����Test������ȽϹ̶�,����ĸ�ʽҪ���Mybaties��text�ļ��е������ĵ�
 */
