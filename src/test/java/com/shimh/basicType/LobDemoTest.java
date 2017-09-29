package com.shimh.basicType;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;

import org.hibernate.Hibernate;
import org.junit.Test;

import com.shimh.BaseTest;
import com.shimh.customer.SexEnum;
import com.shimh.model.basicType.EnumDemo;
import com.shimh.model.basicType.LobDemo;


public class LobDemoTest extends BaseTest{
	
	@Test
	public void add() throws Exception{
		LobDemo demo = new LobDemo();
	    // 获取图片
        File f = new File("D:" + File.separator + "17_8_22_17_39_15.png");
        // 获取图片输入流
        InputStream input = new FileInputStream(f);
        // 创建Blob对象
        Blob image = Hibernate.getLobCreator(session).createBlob(input, input.available());
        
        Clob text = Hibernate.getLobCreator(session).createClob("我是clob");
        demo.setBlob(image);
        demo.setClob(text);
        
        // 保存图片
        session.save(demo);
	}
	
	@Test
	public void get() throws Exception{
		
		LobDemo demo = session.get(LobDemo.class, 1);
		System.out.println(demo.getClob().toString());
        Blob image = demo.getBlob();
        // 获取图片输入流
        InputStream input = image.getBinaryStream();
        File f = new File("D:" + File.separator + "2.png");
        OutputStream output = new FileOutputStream(f);
        // 创建缓冲区
        byte[] buff = new byte[input.available()];
        input.read(buff);
        output.write(buff);
        input.close();
        output.close();
	}
}

