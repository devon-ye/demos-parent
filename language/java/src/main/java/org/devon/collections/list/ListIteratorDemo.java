package org.devon.collections.list;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by lenovo on 2017/11/29.
 */
public class ListIteratorDemo {

    private static List<String> list = null;

    public static void main(String[] args) {
        list =new  LinkedList<String>();
        list.add("A");
        list.add("C");
        list.add("B");
        list.add("D");
        list.add("E");
        ListIterator<String> iterString = list.listIterator();

        while (iterString.hasNext())
        {
            System.out.println(iterString.next());
        }

        while(iterString.hasPrevious()){
            System.out.println(iterString.previous());
        }




    }


}
