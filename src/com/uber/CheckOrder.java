package com.uber;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public class CheckOrder {
    public static void main(String[] args) {
        CheckOrder c=new CheckOrder();
        System.out.println(c.isFollowingOrder("abcde","aabcdgfhreggjkabcde"));
    }
        public boolean isFollowingOrder(String order, String text) {

            int chunkSize = 10;
            int chunkCount = (text.length() + chunkSize - 1) / chunkSize;
            CountDownLatch latch = new CountDownLatch(chunkCount);
            AtomicBoolean result = new AtomicBoolean(true);

            for (int i = 0; i < chunkCount; i++) {
                int start = i * chunkSize;
                int end = Math.min((i + 1) * chunkSize, text.length());
                String chunk = text.substring(start, end);
                new Thread(() -> {
                    if (!checkChunk(order, chunk)) {
                        result.set(false);
                    }
                    latch.countDown();
                }).start();
            }

            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return result.get();
        }

        private boolean checkChunk(String order, String chunk) {
            int[] index = new int[256];
            for (int i = 0; i < order.length(); i++) {
                index[order.charAt(i)] = i;
            }

            for (int i = 0; i < chunk.length() - 1; i++) {
                if (index[chunk.charAt(i)] > index[chunk.charAt(i + 1)]) {
                    return false;
                }
            }
            return true;
        }

}
