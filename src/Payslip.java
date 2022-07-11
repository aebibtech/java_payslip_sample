
public class Payslip {

  private String employeeName;
  private double basicSalary;
  private int otHours;
  private double withHoldingTax;
  private double grossIncome;
  private double otPay;
  private double netPay;
  private double sss;
  private double pagIbig;
  private double philHealth;

  public Payslip() {
  }

  public Payslip(String employeeName, double basicSalary, int otHours) {
    this.employeeName = employeeName;
    this.basicSalary = basicSalary;
    this.otHours = otHours;
    computeCompensation();
  }

  public void determineWithHoldingTax() {
    if (basicSalary <= 20000) {
      setWithHoldingTax(0.0);
    } else if (basicSalary > 20000 && basicSalary <= 31000) {
      setWithHoldingTax(0.2 * (basicSalary - 20000));
    } else if (basicSalary > 31000 && basicSalary <= 61000) {
      setWithHoldingTax(2300 + (0.25 * (basicSalary - 31000)));
    } else if (basicSalary > 61000 && basicSalary <= 154000) {
      setWithHoldingTax(10000 + (0.3 * (basicSalary - 61000)));
    } else if (basicSalary > 154000 && basicSalary <= 615000) {
      setWithHoldingTax(38000 + (0.32 * (basicSalary - 154000)));
    } else if (basicSalary > 615000) {
      setWithHoldingTax(185000 + (0.35 * (basicSalary - 615000)));
    }
  }

  private void computeCompensation() {
    setSss(0.13 * basicSalary);
    setPagIbig(0.02 * basicSalary);
    double phComp = 0.035 * basicSalary;
    setPhilHealth((phComp < 2450) ? phComp : 2450);

    setOtPay(otHours * 0.01 * basicSalary);
    setGrossIncome(basicSalary + otPay);
    determineWithHoldingTax();
    setNetPay(grossIncome - withHoldingTax - (sss + pagIbig + philHealth));
  }

  /**
   * @return the employeeName
   */
  public String getEmployeeName() {
    return employeeName;
  }

  /**
   * @param employeeName the employeeName to set
   */
  public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
  }

  /**
   * @return the basicSalary
   */
  public double getBasicSalary() {
    return basicSalary;
  }

  /**
   * @param basicSalary the basicSalary to set
   */
  public void setBasicSalary(double basicSalary) {
    this.basicSalary = basicSalary;
  }

  /**
   * @return the otHours
   */
  public int getOtHours() {
    return otHours;
  }

  /**
   * @param otHours the otHours to set
   */
  public void setOtHours(int otHours) {
    this.otHours = otHours;
  }

  /**
   * @return the withHoldingTax
   */
  public double getWithHoldingTax() {
    return withHoldingTax;
  }

  /**
   * @param withHoldingTax the withHoldingTax to set
   */
  public void setWithHoldingTax(double withHoldingTax) {
    this.withHoldingTax = withHoldingTax;
  }

  /**
   * @return the grossIncome
   */
  public double getGrossIncome() {
    return grossIncome;
  }

  /**
   * @param grossIncome the grossIncome to set
   */
  public void setGrossIncome(double grossIncome) {
    this.grossIncome = grossIncome;
  }

  /**
   * @return the otPay
   */
  public double getOtPay() {
    return otPay;
  }

  /**
   * @param otPay the otPay to set
   */
  public void setOtPay(double otPay) {
    this.otPay = otPay;
  }

  /**
   * @return the netPay
   */
  public double getNetPay() {
    return netPay;
  }

  /**
   * @param netPay the netPay to set
   */
  public void setNetPay(double netPay) {
    this.netPay = netPay;
  }

  /**
   * @return the sss
   */
  public double getSss() {
    return sss;
  }

  /**
   * @param sss the sss to set
   */
  public void setSss(double sss) {
    this.sss = sss;
  }

  /**
   * @return the pagIbig
   */
  public double getPagIbig() {
    return pagIbig;
  }

  /**
   * @param pagIbig the pagIbig to set
   */
  public void setPagIbig(double pagIbig) {
    this.pagIbig = pagIbig;
  }

  /**
   * @return the philHealth
   */
  public double getPhilHealth() {
    return philHealth;
  }

  /**
   * @param philHealth the philHealth to set
   */
  public void setPhilHealth(double philHealth) {
    this.philHealth = philHealth;
  }
  
  
}
