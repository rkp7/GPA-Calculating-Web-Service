
/**
 * GPACalculatorCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.4  Built on : Dec 28, 2015 (10:03:39 GMT)
 */

    package org.apache.ws.axis2;

    /**
     *  GPACalculatorCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class GPACalculatorCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public GPACalculatorCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public GPACalculatorCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for setCourse method
            * override this method for handling normal response from setCourse operation
            */
           public void receiveResultsetCourse(
                    org.apache.ws.axis2.GPACalculatorStub.SetCourseResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setCourse operation
           */
            public void receiveErrorsetCourse(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for assignGradePoint method
            * override this method for handling normal response from assignGradePoint operation
            */
           public void receiveResultassignGradePoint(
                    org.apache.ws.axis2.GPACalculatorStub.AssignGradePointResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from assignGradePoint operation
           */
            public void receiveErrorassignGradePoint(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for calculateGPA method
            * override this method for handling normal response from calculateGPA operation
            */
           public void receiveResultcalculateGPA(
                    org.apache.ws.axis2.GPACalculatorStub.CalculateGPAResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from calculateGPA operation
           */
            public void receiveErrorcalculateGPA(java.lang.Exception e) {
            }
                
               // No methods generated for meps other than in-out
                


    }
    