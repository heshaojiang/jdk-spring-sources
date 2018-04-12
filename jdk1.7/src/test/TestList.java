package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;

public class TestList {
	@Test
	public void testToString(){
		List<String> list = new ArrayList<String>();
		list.add("hello");
		list.add(",");
		list.add("world");
		ListIterator<String> its = list.listIterator();
		System.out.println(its.next());
		System.out.println(its.next());
		System.out.println(its.nextIndex());
		System.out.println(its.previousIndex());
		System.out.println(its.previous());
		System.out.println(its.nextIndex());
		System.out.println(its.previousIndex());
		List<String> list1 = (List<String>) ((ArrayList<String>)list).clone();
		list1.add("123");
		System.out.println(list1.toString());
		System.out.println(list.toString());
		
	}
	
	public void testMock(){
	}
}
