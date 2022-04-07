package Transaction;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.Semaphore;

public class TransactionOperations {
    List<String> queries;


    public void txnRollback() {
        queries.clear();
    }

    public void txnCommit() throws SQLException
    {

        Semaphore semaphore = new Semaphore(1);
        TransactionThread transaction = new TransactionThread(semaphore);
        transaction.start();
    }
    public void exit() {
       exit();
    }
}
