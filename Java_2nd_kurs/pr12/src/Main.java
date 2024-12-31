public class Main {
    public static void main(String[] args) {
        AppSettings as = AppSettings.getInstance();
        Thread thr = new Thread(new Runnable() {
            @Override
            public void run() {
                as.setSettings("brightness", 100);

            }
        });

        Thread thr2 = new Thread(new Runnable() {
            @Override
            public void run() {
                as.setSettings("sensetivity", 90);
            }
        });
        Thread t = Thread.currentThread();
        thr.start();
        thr2.start();
        try {
            t.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(as.getSettings("sensetivity"));
        System.out.println(as.getSettings("brightness"));
    }
}