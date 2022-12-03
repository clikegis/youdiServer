package com.cy.youdi.utils;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Velocity {
    public double pl;
    public double pg;
    public double d;
    public double g;
    public double ug;

    Velocity() {
    }

    public double correlation() {
        double C = 0.34D;
        double w0 = 0.0D;
        double w = Math.pow(4.0D * g * d * (pl - pg) / (3.0D * C * pg), 0.5D);

        for(double i = 0.03D; Math.abs(w0 - w) > i; w = Math.pow(4.0D * g * d * (pl - pg) / (3.0D * C * pg), 0.5D)) {
            w0 = w;
            double Re = w * d * pg / ug;
            C = 24.0D / Re + 3.0D / Math.pow(Re, 0.5D) + 0.34D;
        }

        System.out.println("迭代试算法求得的油滴沉降速度为w=" + w + "m/s");
        return w;
    }

    public double flowpattern() {
        double w = 0.0D;
        double d1 = 3.3D * Math.pow(Math.pow(ug, 2.0D) / (pg * g * (pl - pg)), 0.33333333333333D);
        double d2 = 43.5D * Math.pow(Math.pow(ug, 2.0D) / (pg * g * (pl - pg)), 0.33333333333333D);
        if (d < d1) {
            w = g * Math.pow(d, 2.0D) * (pl - pg) / (18.0D * ug);
        } else if (d2 < d) {
            w = 1.74D * Math.pow(g * d * (pl - pg) / pg, 0.5D);
        } else {
            w = 0.153D * Math.pow(g, 0.714D) * Math.pow(d, 1.143D) * Math.pow(pl - pg, 0.714D) / (Math.pow(ug, 0.428D) * Math.pow(pg, 0.286D));
        }

        System.out.println("流态区分法求得的油滴沉降速度为w=" + w + "m/s");
        return w;
    }

    public double graphic() {
        double a1 = 3.96699D;
        double a2 = 22.56013D;
        double a3 = 96.46966D;
        double b1 = 1859.95045D;
        double b2 = 77.47627D;
        double b3 = 10.02429D;
        double x = 4.0D * g * Math.pow(d, 3.0D) * pg * (pl - pg) / (3.0D * Math.pow(ug, 2.0D));
        double C = a1 * Math.exp(-x / b1) + a2 * Math.exp(-x / b2) + a3 * Math.exp(-x / b3) + 0.62673D;
        double w = Math.pow(4.0D * g * d * (pl - pg) / (3.0D * C * pg), 0.5D);
        System.out.println("图解法求得的油滴沉降速度为w=" + w + "m/s");
        return w;
    }

    public double Ar() {
        double Ar = Math.pow(d, 3.0D) * (pl - pg) * g * pg / Math.pow(ug, 2.0D);
        double Re;
        if (Ar <= 36.0D) {
            Re = 0.056D * Ar;
        } else if (Ar > 83000.0D) {
            Re = 1.74D * Math.pow(Ar, 0.5D);
        } else {
            Re = 0.153D * Math.pow(Ar, 0.714D);
        }

        double w = Re * ug / (d * pg);
        System.out.println("阿基米德法求得的油滴沉降速度为w=" + w + "m/s");
        return w;
    }

    public List getAllVec(){
        List<Double> tempList = new ArrayList();
        tempList.add(this.correlation());
        tempList.add(this.flowpattern());
        tempList.add(this.graphic());
        tempList.add(this.Ar());

        return tempList;
    }
}

