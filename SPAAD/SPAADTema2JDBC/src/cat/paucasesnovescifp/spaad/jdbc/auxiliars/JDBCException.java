package cat.paucasesnovescifp.spaad.jdbc.auxiliars;

/**
 *
 * @author marta
 */
public class JDBCException extends Exception {

    /**
     * Creates a new instance of <code>JDBCException</code> without detail
     * message.
     */
    public JDBCException() {
    }

    /**
     * Constructs an instance of <code>JDBCException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public JDBCException(String msg) {
        super(msg);
    }
}
