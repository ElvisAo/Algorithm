package dsignPattern.templateDemo;

public class templateDemo {
    public static void main(String[] args) {
        System.out.println("-----制作红豆豆浆-----");
        new RedBeanSoyaMilk().make();
        System.out.println("-----制作花生豆浆-----");
        new PeanutSoyaMilk().make();
    }
}

abstract class SoyaMilk {
    // 模板方法，可以做成final以不让子类覆盖
    final void make() {
        select();
        addCondiments();
        soak();
        beat();
    }

    void select() {
        System.out.println("1. 挑选上好的黄豆");
    }

    // 添加不同的配料，让子类实现
    abstract void addCondiments();

    void soak() {
        System.out.println("3. 浸泡黄豆3小时");
    }

    void beat() {
        System.out.println("4. 打浆");
    }
}

class RedBeanSoyaMilk extends SoyaMilk {

    @Override
    void addCondiments() {
        System.out.println("2. 添加上好的红豆");
    }
}

class PeanutSoyaMilk extends SoyaMilk {

    @Override
    void addCondiments() {
        System.out.println("2. 添加上好的花生");
    }
}
