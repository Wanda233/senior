package exer;

import javax.management.NotificationEmitter;
import javax.sound.midi.Soundbank;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        Employee employee1 = new Employee("tom",22,new MyDate(1994,1,7));
        Employee employee2 = new Employee("jerry",51,new MyDate(1994,1,3));
        Employee employee3 = new Employee("keven",21,new MyDate(1998,12,13));
        Employee employee4 = new Employee("mary",12,new MyDate(1985,11,23));
        Employee employee5 = new Employee("jack",23,new MyDate(1964,10,5));

        Comparator comparator = new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Employee && o2 instanceof Employee){
                    Employee e1 = (Employee)o1;
                    Employee e2 = (Employee)o2;
                    if(e1.getBirthday().equals(e2.getBirthday())){
                        return 0;
                    }
                    else {
                        if(Integer.compare(e1.getBirthday().getYear(),e2.getBirthday().getYear())==0){
                            if(Integer.compare(e1.getBirthday().getMonth(),e2.getBirthday().getMonth())==0){
                                return Integer.compare(e1.getBirthday().getDay(),e2.getBirthday().getDay());
                            }
                            else {
                                return Integer.compare(e1.getBirthday().getMonth(),e2.getBirthday().getMonth());
                            }
                        }
                        else {
                            return Integer.compare(e1.getBirthday().getYear(),e2.getBirthday().getYear());
                        }
                    }
                }
                else {
                    throw new RuntimeException("输入的数据类型不匹配");
                }
            }
        };
        TreeSet treeSet = new TreeSet(comparator);
        treeSet.add(employee1);
        treeSet.add(employee2);
        treeSet.add(employee3);
        treeSet.add(employee4);
        treeSet.add(employee5);

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }



    }

}
