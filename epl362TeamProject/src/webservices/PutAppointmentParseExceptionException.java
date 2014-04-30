
/**
 * PutAppointmentParseExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package webservices;

public class PutAppointmentParseExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1398873005070L;
    
    private webservices.PutAppointmentStub.PutAppointmentParseException faultMessage;

    
        public PutAppointmentParseExceptionException() {
            super("PutAppointmentParseExceptionException");
        }

        public PutAppointmentParseExceptionException(java.lang.String s) {
           super(s);
        }

        public PutAppointmentParseExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public PutAppointmentParseExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(webservices.PutAppointmentStub.PutAppointmentParseException msg){
       faultMessage = msg;
    }
    
    public webservices.PutAppointmentStub.PutAppointmentParseException getFaultMessage(){
       return faultMessage;
    }
}
    