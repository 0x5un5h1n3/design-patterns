package ProxyPattern;

interface DatabaseExecuter {

    public void executeDatabase(String query) throws Exception;
}

class DatabaseExecuterImpl implements DatabaseExecuter {

    @Override
    public void executeDatabase(String query) throws Exception {
        System.out.println("Executing Query: " + query);
    }
}

class DatabaseExecuteProxy implements DatabaseExecuter {

    boolean ifAdmin;
    DatabaseExecuterImpl dbExecuter;

    public DatabaseExecuteProxy(String name, String passwd) {
        if (name == "Admin" && passwd == "Admin@123") {
            ifAdmin = true;
            dbExecuter = new DatabaseExecuterImpl();
        }
    }

    @Override
    public void executeDatabase(String query) throws Exception {
        if (ifAdmin) {
            dbExecuter.executeDatabase(query);
        } else {
            if (query.equals("DELETE")) {
                throw new Exception("DELETE not allowed for non-admin users");
            } else {
                dbExecuter.executeDatabase(query);
            }
        }
    }
}

class ProxyPatternExample {

    public static void main(String[] args) {
        try {
            //        DatabaseExecuter nonAdminExecuter = new DatabaseExecuteProxy("NonAdmin", "Admin123");
//        nonAdminExecuter.executeDatabase("DELETE");

            DatabaseExecuter adminExecuter = new DatabaseExecuteProxy("Admin", "Admin@123");
            adminExecuter.executeDatabase("DELETE"); // Executing Query: DELETE
        } catch (Exception ex) {
        }
    }
}
