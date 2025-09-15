package com.Scan_Train.Scan_Train;

import java.util.Random;

public class OTPUtil
{
    public static String generateOTP()
    {
        return String.valueOf(100000 + new Random().nextInt(900000));
    }
}
