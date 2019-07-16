package com.zh.learn.design_patterns.single_thread_execution;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-07-16
 */
public class FlightSecurityTest {

    public static void main(String[] args) {

        FlightSecurity flightSecurity = new FlightSecurity();
        Passenger passenger1 = new Passenger(flightSecurity, "A123", "A123");
        Passenger passenger2 = new Passenger(flightSecurity, "B123", "B123");
        Passenger passenger3 = new Passenger(flightSecurity, "C123", "C123");

        passenger1.start();
        passenger2.start();
        passenger3.start();


    }


    public static class Passenger extends Thread {

        private FlightSecurity flightSecurity;

        private final String idCard;

        private final String boardingPass;


        public Passenger(FlightSecurity flightSecurity, String idCard, String boardingPass) {
            this.flightSecurity = flightSecurity;
            this.idCard = idCard;
            this.boardingPass = boardingPass;
        }

        @Override
        public void run() {

            while (true) {

                flightSecurity.pass(boardingPass, idCard);
            }
        }
    }

}

