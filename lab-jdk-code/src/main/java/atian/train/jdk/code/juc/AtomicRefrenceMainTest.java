package atian.train.jdk.code.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * juc原子类工具-类引用主测试类;
 * <p>
 * notes: AtomicReference原子引用类
 * 主要作用就是当一些类中的属性是不可能变的、但是需要进行修改;
 * 那么就是可以进行使用AtomicReference类进行替换
 * 底层交换方式使用的是CAS进行对比、交换更新;
 * </p>
 *
 * @author zhouYang
 */
public class AtomicRefrenceMainTest {

    private static AtomicReference<BankCount> reference = new AtomicReference<>(new BankCount("阿天", 0));

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                final BankCount bankCount = reference.get();
                BankCount newBankCount = new BankCount("阿天", bankCount.getAmount() + 10);
                while (reference.compareAndSet(bankCount, newBankCount)) {
                    System.out.println(newBankCount);
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }


    static class BankCount {

        private final String count;

        private final int amount;

        BankCount(String count, int amount) {
            this.count = count;
            this.amount = amount;
        }

        public String getCount() {
            return count;
        }

        public int getAmount() {
            return amount;
        }

        @Override
        public String toString() {
            return "BankCount{" +
                    "count='" + count + '\'' +
                    ", amount=" + amount +
                    '}';
        }
    }

}