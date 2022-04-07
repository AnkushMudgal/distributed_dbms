package Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.Semaphore;

public class TransactionThread extends Thread {

        //todo: call connection object here
        public static Semaphore semaphore;

        //Constructor to call semaphore
        public TransactionThread(Semaphore semaphore) throws SQLException {
            this.semaphore = semaphore;
            //todo: set connection autocommit as false by default
            //connection.setAutoCommit(false);
        }

        // Method to acquire lock
        public void acquire_locks() {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Method to release lock
        public void release_locks() {
            semaphore.release();
        }

        @Override
        public void run() {

                System.out.println("Transaction begins");
                //acquiring the lock
                acquire_locks();
                System.out.println("Transaction acquires the lock and starts query execution");
                //TODO: query processing here

                release_locks();
                System.out.println("Lock released from Transaction 1 ");
            //todo: use connection to perform the functions below
//                    connection.commit();
//                    connection.setAutoCommit(true);
//                    connection.close();

            //Reference :https://www.javatpoint.com/java-semaphore
        }
    }


