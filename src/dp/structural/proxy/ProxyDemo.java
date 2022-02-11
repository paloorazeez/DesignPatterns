package dp.structural.proxy;

public class ProxyDemo {

    public static void main(String[] args) {

        Report report = new ReportProxy();
        report.generate();
    }

}

interface Report{

    void generate();
}

class ReportImpl implements Report{

    @Override
    public void generate() {

        System.out.println("Generating the report");
    }
}

class ReportProxy extends ReportImpl{



    @Override
    public void generate() {
        System.out.println("Passing through proxy");
        super.generate();
    }
}
