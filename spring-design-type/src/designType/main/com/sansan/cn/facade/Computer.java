package designType.main.com.sansan.cn.facade;

public class Computer {
    private CPU cpu;
    private Memory memory;
    private Disk disk;

    public Computer() {
        cpu = new CPU();
        memory = new Memory();
        disk = new Disk();
    }

    public void startUp() {
        System.out.println("start the computer");
        cpu.startUp();
        memory.startUp();
        disk.startUp();
        System.out.println("start computer finished");
    }

    public void shutDown() {
        System.out.println("shutdwon the computer");
        cpu.shutDown();
        memory.shutDown();
        disk.shutDown();
        System.out.println("shutdown the computer finished");
    }
}
