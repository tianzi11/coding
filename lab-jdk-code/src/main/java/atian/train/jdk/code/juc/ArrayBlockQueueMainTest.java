package atian.train.jdk.code.juc;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 阻塞队列主测试类;
 * 阻塞式队列、创建的时候需要指定队列的大小、一旦队列中的元素达到大小值、则后续的添加操作是添加不进去的{wait}
 *
 * @author zhouYang
 */
public class ArrayBlockQueueMainTest {

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(2);
        // put(arrayBlockingQueue);
        // offer(arrayBlockingQueue);
        // add(arrayBlockingQueue);
        // take(arrayBlockingQueue);
        // poll(arrayBlockingQueue);
        peek(arrayBlockingQueue);
    }

    /**
     * put操作是阻塞式操作、如果队列中满了、后续插入线程一直阻塞;
     */
    public static void put(ArrayBlockingQueue<Integer> arrayBlockingQueue) throws InterruptedException {
        arrayBlockingQueue.put(1);
        System.out.println("添加成功" + 1);
        arrayBlockingQueue.put(2);
        System.out.println("添加成功" + 2);
        arrayBlockingQueue.put(3);
        System.out.println("添加成功" + 3);
    }

    /**
     * offer操作式非阻塞式操作、如果队列中满了、立马返回fasle标识;
     * 同时也可以设置超时时间、达到超时时间之后还是满的、则直接返回false;
     */
    public static void offer(ArrayBlockingQueue<Integer> arrayBlockingQueue) throws InterruptedException {
        boolean offer1 = arrayBlockingQueue.offer(1);
        System.out.println("1添加" + offer1);
        boolean offer2 = arrayBlockingQueue.offer(2);
        System.out.println("1添加" + offer2);
        boolean offer3 = arrayBlockingQueue.offer(3);
        System.out.println("1添加" + offer3);
    }

    /**
     * add方法式非阻塞式操作、如果一旦队列满了再次添加、则立马进行爆出异常;
     */
    public static void add(ArrayBlockingQueue<Integer> arrayBlockingQueue) throws InterruptedException {
        boolean add1 = arrayBlockingQueue.add(1);
        System.out.println("1添加" + add1);
        boolean add2 = arrayBlockingQueue.add(2);
        System.out.println("1添加" + add2);
        boolean add3 = arrayBlockingQueue.add(3);
        System.out.println("1添加" + add3);
    }

    /**
     * take式读的阻塞操作、如果一旦队列空、再一次take线程一直阻塞、只要队列右值;
     */
    public static void take(ArrayBlockingQueue<Integer> arrayBlockingQueue) throws InterruptedException {
        boolean add1 = arrayBlockingQueue.add(1);
        System.out.println("1添加" + add1);
        boolean add2 = arrayBlockingQueue.add(2);
        System.out.println("1添加" + add2);
        Integer take1 = arrayBlockingQueue.take();
        System.out.println("atke出" + take1);
        Integer take2 = arrayBlockingQueue.take();
        System.out.println("atke出" + take2);
        Integer take3 = arrayBlockingQueue.take();
        System.out.println("atke出" + take3);

    }

    /**
     * poll式读的非阻塞操作、如果一旦队列为空、再一次poll立马返回null;
     * 也可以设置超时时间、在达到超时时间之后、还是为空、立马返回null;
     */
    public static void poll(ArrayBlockingQueue<Integer> arrayBlockingQueue) throws InterruptedException {
        boolean add1 = arrayBlockingQueue.add(1);
        System.out.println("1添加" + add1);
        boolean add2 = arrayBlockingQueue.add(2);
        System.out.println("1添加" + add2);
        Integer poll1 = arrayBlockingQueue.poll();
        System.out.println("atke出" + poll1);
        Integer poll2 = arrayBlockingQueue.poll();
        System.out.println("atke出" + poll2);
        Integer poll3 = arrayBlockingQueue.poll();
        System.out.println("atke出" + poll3);
    }

    /**
     * peek式是帮助debug测试的方法、每一次去除的都是头部元素、其实每一次取出、但是没有真正从队列中移除;
     */
    public static void peek(ArrayBlockingQueue<Integer> arrayBlockingQueue) throws InterruptedException {
        boolean add1 = arrayBlockingQueue.add(1);
        System.out.println("1添加" + add1);
        boolean add2 = arrayBlockingQueue.add(2);
        System.out.println("1添加" + add2);
        Integer peek1 = arrayBlockingQueue.peek();
        System.out.println("atke出" + peek1);
        Integer peek2 = arrayBlockingQueue.peek();
        System.out.println("atke出" + peek2);
        Integer peek3 = arrayBlockingQueue.peek();
        System.out.println("atke出" + peek3);
    }
}