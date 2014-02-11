package org.hasii.investigation.di.bean;


import org.hasii.investigation.di.writer.IWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpringBean {

    private IWriter _writer;

    @Autowired
    public void setWriter(IWriter theWriter) {
        _writer = theWriter;
    }
    public IWriter getWriter() {
        return _writer;
    }
    public void run() {
      String s = "This is my test";
      _writer.writer(s);
    }
}