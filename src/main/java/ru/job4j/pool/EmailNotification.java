package ru.job4j.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmailNotification {

    private final ExecutorService pool = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
    );

    public void emailTo(User user) {
        StringBuilder subject = new StringBuilder();
        StringBuilder body = new StringBuilder();
        String userName = user.getUsername();
        String email = user.getEmail();
        subject.append("Notification {");
        subject.append(userName);
        subject.append("} to email {");
        subject.append(email);
        subject.append("}.");
        body.append("Add a new event to {");
        body.append(userName);
        body.append("}");
        pool.submit(() -> send(subject.toString(), body.toString(), email));
    }

    public void close() {
        pool.shutdown();
        while (!pool.isTerminated()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void send(String subject, String body, String email) {

    }
}
