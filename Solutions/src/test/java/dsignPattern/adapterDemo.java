package dsignPattern;


interface Camera {
    void capture();
}

class HikCamera implements Camera {
    @Override
    public void capture() {
        System.out.println("普通拍照");
    }
}

interface AdCamera {
    void adCapture();
}

class AdHikCamera implements AdCamera {

    @Override
    public void adCapture() {
        System.out.println("高级拍照");
    }
}

class AdatedCamera extends AdHikCamera implements Camera {

    @Override
    public void capture() {
        adCapture();
    }
}

class CameraFactory {
    public static Camera build() {
        // 没有适配前
//        return new HikCamera();
        // 适配后
        return new AdatedCamera();
    }
}

public class adapterDemo {
    public static void main(String[] args) {
        Camera camera = CameraFactory.build();
        camera.capture();
    }
}
