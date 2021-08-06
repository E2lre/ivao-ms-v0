package com.e2lre.ivaomsv0.service;

import javax.print.PrintException;
import java.io.IOException;

public interface IvaoPrintingService {
    public String printInfo(String info) throws PrintException, IOException;
}
