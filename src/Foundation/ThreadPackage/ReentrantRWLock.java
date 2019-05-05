package Foundation.ThreadPackage;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantRWLock {

    public static void main(String[] args) {
        ReentrantReadWriteLock rw = new ReentrantReadWriteLock();

        Lock readL = rw.readLock();
        Lock writeL = rw.writeLock();
        writeL.lock();
        readL.lock();
        readL.lock();
        writeL.lock();
        readL.unlock();

        try {
            Thread.currentThread().interrupt();
            readL.lockInterruptibly();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(rw.isWriteLocked());
//        writeL.unlock();
        System.out.println(rw.getReadHoldCount());
    }
}
