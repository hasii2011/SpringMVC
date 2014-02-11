package org.hasii.investigation.di.writer;


public class Writer implements IWriter {

    public Writer() {
    }
    @Override
    public void writer(String s) {
        System.out.println(s);
    }

}