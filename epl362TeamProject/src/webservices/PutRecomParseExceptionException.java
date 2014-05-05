
/**
 * PutRecomParseExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package webservices;

public class PutRecomParseExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1399276755663L;
    
    private webservices.PutRecomStub.PutRecomParseException faultMessage;

    
        public PutRecomParseExceptionException() {
            super("PutRecomParseExceptionException");
        }

        public PutRecomParseExceptionException(java.lang.String s) {
           super(s);
        }

        public PutRecomParseExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public PutRecomParseExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(webservices.PutRecomStub.PutRecomParseException msg){
       faultMessage = msg;
    }
    
    public webservices.PutRecomStub.PutRecomParseException getFaultMessage(){
       return faultMessage;
    }
}
    