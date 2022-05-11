public class Salary {
    /**
     * Employee Salary (in thousands).
     */
    private int qtyK;

    /**
     * Getter for employee salary (in thousands).
     * @return employee salary (n thousands)
     */
    public int getAmount() { return this.qtyK; };

    /**
     * toString override for Salary
     * @return string version of salary
     */
    @Override
    public String toString() {
        return "$" + qtyK + "k";
    }

    /**
     * Constructor for salary.
     * @param qtyK quantity for salary (in thousands)
     */
    public Salary(int qtyK) {
        this.qtyK = qtyK;
    }
}
