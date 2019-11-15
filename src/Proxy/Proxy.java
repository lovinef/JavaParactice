package Proxy;

import javax.sql.rowset.serial.SerialBlob;

public class Proxy implements Service {
    ServiceImplement serviceImplement;

    @Override
    public String runSomething() {
        System.out.println("Proxy 호출");

        serviceImplement = new ServiceImplement();
        return serviceImplement.runSomething();
    }
}
