package com.finley.net;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @author zyf
 * @date 2017/9/15
 */
public class NetAddressTest {

    public static void main(String []args){
        try {
            InetAddress address= InetAddress.getByName("192.168.0.1");
            System.out.print(Arrays.toString(address.getAddress()));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
