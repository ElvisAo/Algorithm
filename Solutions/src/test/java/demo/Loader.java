package demo;

class Student implements Cloneable {
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    private Address addr;

    public Address getAddr() {
        return addr;
    }

    public void setAddr(Address addr) {
        this.addr = addr;
    }

    @Override
    public Object clone() {
        Student stu = null;
        try {
            stu = (Student) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return stu;
    }
}

class Address {
    private String add;

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }
}

public class Loader {
    private static final Loader loader = new Loader();

    private Loader() {
    }

    private static Loader getInstance() {
        return loader;
    }

    public static void main(String[] args) {
        Address addr = new Address();
        addr.setAdd("北京");
        Student stu1 = new Student();
        stu1.setAddr(addr);
        Student stu2 = (Student) stu1.clone();
        System.out.println("学生1:" + stu1.getAddr().getAdd());
        System.out.println("学生2:" + stu2.getAddr().getAdd());
        addr.setAdd("天津");
        System.out.println("学生1:" + stu1.getAddr().getAdd());
        System.out.println("学生2:" + stu2.getAddr().getAdd());


    }
}
