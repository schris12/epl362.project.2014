
/**
 * EditAppointmentParseExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package webservices;

public class EditAppointmentParseExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1398871518879L;
    
    private webservices.EditAppointmentStub.EditAppointmentParseException faultMessage;

    
        public EditAppointmentParseExceptionException() {
            super("EditAppointmentParseExceptionException");
        }

        public EditAppointmentParseExceptionException(java.lang.String s) {
           super(s);
        }

        public EditAppointmentParseExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public EditAppointmentParseExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(webservices.EditAppointmentStub.EditAppointmentParseException msg){
       faultMessage = msg;
    }
    
    public webservices.EditAppointmentStub.EditAppointmentParseException getFaultMessage(){
       return faultMessage;
    }
}
    