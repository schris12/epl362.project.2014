
/**
 * PutCaseParseExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package webservices;

public class PutCaseParseExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1398968974935L;
    
    private webservices.PutCaseStub.PutCaseParseException faultMessage;

    
        public PutCaseParseExceptionException() {
            super("PutCaseParseExceptionException");
        }

        public PutCaseParseExceptionException(java.lang.String s) {
           super(s);
        }

        public PutCaseParseExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public PutCaseParseExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(webservices.PutCaseStub.PutCaseParseException msg){
       faultMessage = msg;
    }
    
    public webservices.PutCaseStub.PutCaseParseException getFaultMessage(){
       return faultMessage;
    }
}
    