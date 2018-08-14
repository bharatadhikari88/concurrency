package com.spacetime.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableTest implements Serializable {
	String data ="abc";
	
	private Object writeReplace() {
		return new SerializableTestProxy(this);
	}
	
	static class  SerializableTestProxy implements Serializable{
		String data;
		
		public SerializableTestProxy(SerializableTest test) {
			this.data = test.data;
		}
		
		private Object readResolve() {
            return new SerializableTest();
        }
	}
	
	public static void main(String[] args) throws IOException,ClassNotFoundException{
		write();
		read();
	}

	private static void write() throws IOException{
		ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream("abcx45"));
		oo.writeObject(new SerializableTest());
		oo.close();
	}
	
	private static void read() throws IOException,ClassNotFoundException{
		ObjectInputStream oi = new ObjectInputStream(new FileInputStream("abcx45"));
		oi.readObject();
	}

}
