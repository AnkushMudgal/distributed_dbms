package Transaction;

import java.sql.SQLException;

public class TransactionManager {
static TransactionOperations txnOperations =new TransactionOperations();

    public static void transactionInput(String operation, Object transaction) throws SQLException {

        if(operation.equals("commit"))
        {
            txnOperations.txnCommit();

        }
        else if (operation.equals("rollback"))
        {
            txnOperations.txnRollback();
        }
        else if (operation.equals("exit"))
        {
            txnOperations.exit();
        }

    }
}
