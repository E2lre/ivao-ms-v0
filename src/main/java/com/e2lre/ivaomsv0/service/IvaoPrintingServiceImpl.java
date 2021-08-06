package com.e2lre.ivaomsv0.service;

import org.springframework.stereotype.Service;

import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;
import javax.print.DocFlavor;
import java.io.IOException;

@Service
public class IvaoPrintingServiceImpl implements IvaoPrintingService {

    @Override
    public String printInfo(String info) throws PrintException, IOException {

// https://www.developer.com/java/data/how-to-add-java-print-services-to-your-java-application/

        PrintService ps= PrintServiceLookup.lookupDefaultPrintService();
        DocPrintJob job=ps.createPrintJob();
        job.addPrintJobListener(new PrintJobAdapter() {
            public void printDataTransferCompleted(PrintJobEvent event){
                System.out.println("data transfer complete");
            }
            public void printJobNoMoreEvents(PrintJobEvent event){
                System.out.println("received no more events");
            }
        });
       // FileInputStream fis=new FileInputStream("C:/test.jpg");
        Doc doc= new SimpleDoc (info.getBytes(), DocFlavor.BYTE_ARRAY.AUTOSENSE, null);
        // Doc doc=new SimpleDoc(fis, DocFlavor.INPUT_STREAM.JPEG, null);
        PrintRequestAttributeSet attrib=new HashPrintRequestAttributeSet();
        attrib.add(new Copies(1));
        job.print(doc, attrib);
        return info;
    }
}
