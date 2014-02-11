package org.hasii.investigation.di.writer;

import org.springframework.stereotype.Service;


@Service
public class NiceWriter implements IWriter {

    public NiceWriter() {
    }
    @Override
    public void writer(String s) {
        System.out.println("The string is '" + s + "'");
    }

}