package com.e2lre.ivaomsv0.service;

import org.springframework.stereotype.Service;

import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;
import javax.print.DocFlavor;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

@Service
public class IvaoPrintingServiceImpl implements IvaoPrintingService {

    @Override
    public String printInfo(String info) throws PrintException, IOException {

// https://www.developer.com/java/data/how-to-add-java-print-services-to-your-java-application/
  /*      DocPrintJob job = null;
        PrintService[] printServices =
                PrintServiceLookup.lookupPrintServices(null, null);
        System.out.println("Number of print services: " + printServices.length);
        for (PrintService printer : printServices) {
            System.out.println("Printer: " + printer.getName());
            if (printer.getName().contains("Canon")) {
                Arrays.stream(printer.getSupportedDocFlavors()).forEach(f->System.out.println(f.getMediaType() + ":" + f.getMimeType() + ":" + f.getRepresentationClassName()));
                String hello = "Hello";
                DocFlavor flavor = DocFlavor.STRING.TEXT_PLAIN;
                Doc doc = new SimpleDoc(hello, flavor, null);
                job = printer.createPrintJob();
                job.print(doc, null);
            }
        }
        return info;*/

        String defaultPrinter =
                PrintServiceLookup.lookupDefaultPrintService().getName();
        System.out.println("Default printer: " + defaultPrinter);
        PrintService service = PrintServiceLookup.lookupDefaultPrintService();
        InputStream is = new ByteArrayInputStream(info.getBytes("UTF8"));
        //InputStream is = new ByteArrayInputStream("hello world!".getBytes("UTF8"));

        PrintRequestAttributeSet  pras = new HashPrintRequestAttributeSet();
        pras.add(new Copies(1));
        //DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
        DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
        Doc doc = new SimpleDoc(is, flavor, null);
        DocPrintJob job = service.createPrintJob();

        PrintJobWatcher pjw = new PrintJobWatcher(job);
        job.print(doc, pras);
        pjw.waitForDone();
        is.close();

        return info;


/*
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
        //Doc doc= new SimpleDoc (info, DocFlavor.SERVICE_FORMATTED.PAGEABLE, null);
        // Doc doc=new SimpleDoc(fis, DocFlavor.INPUT_STREAM.JPEG, null);
        PrintRequestAttributeSet attrib=new HashPrintRequestAttributeSet();
        attrib.add(new Copies(1));
        job.print(doc, attrib);
        return info;

 */
/*
        try {
            PrintService pServices[] = PrintServiceLookup.lookupPrintServices(null, null);;
            PrintService printService = pServices[3];
            SimpleDoc doc;
            doc = new SimpleDoc(info.getBytes(),
                    DocFlavor.BYTE_ARRAY.TEXT_PLAIN_US_ASCII, null);
                   // javax.print.DocFlavor.BYTE_ARRAY.AUTOSENSE, null);
            DocPrintJob job = printService.createPrintJob();
            job.print(doc, new HashPrintRequestAttributeSet());
            System.out.println("Job sent to printer succesfully");
            return info;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            return info;
        }
*/

    }
}
    class PrintJobWatcher {
        boolean done = false;

        PrintJobWatcher(DocPrintJob job) {
            job.addPrintJobListener(new PrintJobAdapter() {
                public void printJobCanceled(PrintJobEvent pje) {
                    allDone();
                }

                public void printJobCompleted(PrintJobEvent pje) {
                    allDone();
                }

                public void printJobFailed(PrintJobEvent pje) {
                    allDone();
                }

                public void printJobNoMoreEvents(PrintJobEvent pje) {
                    allDone();
                }

                void allDone() {
                    synchronized (PrintJobWatcher.this) {
                        done = true;
                        System.out.println("Printing done ...");
                        PrintJobWatcher.this.notify();
                    }
                }
            });
        }

        public synchronized void waitForDone() {
            try {
                while (!done) {
                    wait();
                }
            } catch (InterruptedException e) {
            }
        }
    }

