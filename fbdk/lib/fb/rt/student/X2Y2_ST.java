/* Copyright (c)2020 Rockwell Automation. All rights reserved. */
package fb.rt.student;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK X2Y2_ST
  * @author JHC
  * @version 20200925/JHC
  */
public class X2Y2_ST extends FBInstance
{
/** VAR X */
  public REAL X = new REAL();
/** VAR Y */
  public REAL Y = new REAL();
/** VAR OUT */
  public REAL OUT = new REAL();
/** EVENT REQ */
 public EventServer REQ = new EventInput(this);
/** EVENT CNF */
 public EventOutput CNF = new EventOutput();
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventServer eiNamed(String s){
    if("REQ".equals(s)) return REQ;
    return super.eiNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventOutput eoNamed(String s){
    if("CNF".equals(s)) return CNF;
    return super.eoNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
* @throws FBRManagementException {@inheritDoc}
*/
  public ANY ivNamed(String s) throws FBRManagementException{
    if("X".equals(s)) return X;
    if("Y".equals(s)) return Y;
    return super.ivNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
* @throws FBRManagementException {@inheritDoc}
*/
  public ANY ovNamed(String s) throws FBRManagementException{
    if("OUT".equals(s)) return OUT;
    return super.ovNamed(s);}
/** {@inheritDoc}
* @param ivName {@inheritDoc}
* @param newIV {@inheritDoc}
* @throws FBRManagementException {@inheritDoc} */
  public void connectIV(String ivName, ANY newIV)
    throws FBRManagementException{
    if("X".equals(ivName)) connect_X((REAL)newIV);
    else if("Y".equals(ivName)) connect_Y((REAL)newIV);
    else super.connectIV(ivName, newIV);
    }
/** Connect the given variable to the input variable X
  * @param newIV The variable to connect
 */
  public void connect_X(REAL newIV){
    X = newIV;
    }
/** Connect the given variable to the input variable Y
  * @param newIV The variable to connect
 */
  public void connect_Y(REAL newIV){
    Y = newIV;
    }
private static final int index_START = 0;
private void state_START(){
  eccState = index_START;
}
private static final int index_REQ = 1;
private void state_REQ(){
  eccState = index_REQ;
  alg_REQ();
  CNF.serviceEvent(this);
state_START();
}
/** The default constructor. */
public X2Y2_ST(){
    super();
  }
/** {@inheritDoc}
* @param e {@inheritDoc} */
  public void serviceEvent(EventServer e){
    if (e == REQ) service_REQ();
  }
/** Services the REQ event. */
  public void service_REQ(){
    if ((eccState == index_START)) state_REQ();
  }
  /** ALGORITHM REQ IN ST*/
public void alg_REQ(){
OUT.value=(float)((X.value-Y.value)*(X.value+Y.value));
}
}
