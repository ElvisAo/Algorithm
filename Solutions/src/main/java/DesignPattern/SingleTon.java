package DesignPattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingleTon {
    public static void main(String[] args) {
        SingleInstance_Static instance1 = SingleInstance_Static.getInstance();
        SingleInstance_Static instance2 = SingleInstance_Static.getInstance();
        System.out.println(instance1 == instance2);
        try {
            Class<SingleInstance_Static> instanceClass = SingleInstance_Static.class;
/*            Class<?>[] classes = instanceClass.getDeclaredClasses();
            for (Class clazz : classes) {
                Field instance = clazz.getDeclaredField("instance");
                instance.setAccessible(true);
                instance.set(clazz, null);  // 这里会报错，因为是final的，不能修改
            }*/
            Constructor<SingleInstance_Static> constructor = instanceClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            SingleInstance_Static instance3 = constructor.newInstance();
            System.out.println(instance1 == instance3);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
/*        SingleInstance_DoubleCheck instance1 = SingleInstance_DoubleCheck.getInstance();
        SingleInstance_DoubleCheck instance2 = SingleInstance_DoubleCheck.getInstance();
        System.out.println(instance1 == instance2);
        Class<SingleInstance_DoubleCheck> doubleCheckClass = SingleInstance_DoubleCheck.class;
        try {
            Field instance = doubleCheckClass.getDeclaredField("instance");
            instance.setAccessible(true);
            instance.set(SingleInstance_DoubleCheck.class, null);

            Constructor<SingleInstance_DoubleCheck> constructor = doubleCheckClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            SingleInstance_DoubleCheck instance3 = constructor.newInstance();
            // sout false， the reason lie in the instance is not final
            System.out.println(instance1 == instance3);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }*/
    }
}

/**
 * Perfect implementation of Singleton
 * 静态内部类+构造方法抛运行时异常
 */
class SingleInstance_Static {
    private static class SingleHolder {
        private static final SingleInstance_Static instance = new SingleInstance_Static();
    }

    /**
     * 注意：这里必须是RuntimeException，不然编译器会要求必须处理
     */
    private SingleInstance_Static() {
        if (SingleHolder.instance != null) throw new RuntimeException("operation is not supported");
    }

    public static final SingleInstance_Static getInstance() {
        return SingleHolder.instance;
    }
}

/**
 * 双重检查：It could be failed by reflection
 */
class SingleInstance_DoubleCheck {
    private volatile static SingleInstance_DoubleCheck instance;

    /**
     * 这里的抛异常是不必要的，因为instance不是final的，可以被反射指向null
     */
    private SingleInstance_DoubleCheck() {
        if (instance != null) {
            throw new RuntimeException("Operation is not supported");
        }
    }

    public static SingleInstance_DoubleCheck getInstance() {
        if (instance == null) {
            synchronized (SingleInstance_DoubleCheck.class) {
                if (instance == null) {
                    instance = new SingleInstance_DoubleCheck();
                }
            }
        }
        return instance;
    }
}