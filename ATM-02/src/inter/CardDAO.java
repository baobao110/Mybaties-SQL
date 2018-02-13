package inter;

import java.sql.Connection;

import org.apache.ibatis.annotations.Param;

import BankCard.Card;

public interface CardDAO {
	public Card GetCard(@Param("number") int number,@Param("id") int id);
	/*
	 * �����DAO�����ǰJDBCʱ��һ����������Ϊ�ӿڣ�ֻ��Ҫ���巽���Ϳ���,ͬʱ��Ҫע�������@Param()�����Ǹ�������ע��
	 */
	public int modifyPassword(@Param("number")int number,@Param("password")String password);
	public int modifyMoney(@Param("number")int number,@Param("money")double money);
	public int open(Card card);
	/*
	 * �����DAO������������ݿ����������Mybaties�к�JDBCһ��Ҫ�������ݿ⽨����Ӧ���࣬һ�ű�һ����,DAO��ͬ���ǲ�����������ݿ���࣬��JDBC��ͬ������DAO���ǽӿ�ֻ��Ҫ����
	 * ����������Ҫʵ��,�������ݿ�Ĳ���д��Card.xml��ͬ����SQL���
	 */
}
