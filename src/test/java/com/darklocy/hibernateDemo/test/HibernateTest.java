package com.darklocy.hibernateDemo.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import com.darklovy.hibernateDemo.model.Student;

public class HibernateTest {

	@Test
	public void test() {
		// 1. 创建一个 SessionFactory 工厂类:通过它建立一个数据库连接会话，Session
		SessionFactory sessionFactory = null;
		// 1.1 SessionFactory需要一个配置类：封装有 hibernate.cfg.xml 中的配置信息
		// 返回回来的 configuration 对象包含配置文件里的具体信息
		Configuration configuration = new Configuration().configure();
		// 1.2 hibernate规定：所有的配置或服务，要生效就必须将配置或服务注册到一个注册服务类里面
		ServiceRegistry serviceRegistry = configuration.getStandardServiceRegistryBuilder().build();
		// 1.3 通过元数据拿到 SessionFactory
		sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();

		// 2. 通过工厂类开启 Session 对象
		Session session = sessionFactory.openSession();
		
		// 3. 开启事务处理
	    Transaction transaction = session.beginTransaction();
		
		// 4. 执行数据库操作
		Student student = new Student("张三", "男", new Date());
		session.save(student);
		// 5. 提交事务
		transaction.commit();
		// 6. 关闭 Session
		session.close();
		// 7. 关闭 工厂类
		sessionFactory.close();
	}
}
