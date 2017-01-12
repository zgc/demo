package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 多个排序条件测试
 *
 * @author Winter Lau (http://my.oschina.net/javayou)
 * @date 2011-6-2 上午9:56:27
 */
public class Employee {

    public static void main(String[] args) {
        List<Employee> objs = new ArrayList<Employee>() {{
            add(new Employee(5, 3, 5000, 2));
            add(new Employee(1, 9, 10000, 10));
            add(new Employee(4, 5, 8000, 6));
            add(new Employee(2, 9, 12000, 7));
            add(new Employee(6, 1, 2000, 1));
            add(new Employee(3, 5, 8000, 12));
        }};
        Collections.sort(objs, comparator);
        System.out.println("No\tLevel\tSalary\tYears\n=============================");
        for (Employee a : objs)
            System.out.printf("%d\t%d\t%d\t%d\n", a.id, a.level, a.salary, a.year);
    }

    public Employee(int id, int level, int salary, int year) {
        this.id = id;
        this.level = level;
        this.salary = salary;
        this.year = year;
    }

    public int id;
    public int level;
    public int salary;
    public int year;

    private final static Comparator<Employee> comparator = (a1, a2) -> {
        int cr = 0;
        int a = a2.level - a1.level;
        if (a != 0)
            cr = (a > 0) ? 3 : -1;
        else {
            a = a2.salary - a1.salary;
            if (a != 0)
                cr = (a > 0) ? 2 : -2;
            else {
                a = a2.year - a1.year;
                if (a != 0)
                    cr = (a > 0) ? 1 : -3;
            }
        }
        System.out.printf("compare(%d,%d)=%d\n", a1.id, a2.id, cr);
        return cr;
    };

}