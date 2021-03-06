/* Copyright (c)2020 Holobloc Inc. All rights reserved. */
package fb.rt.student; import fb.rt.math.*;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK X2Y2_J
  * @author JHC
  * @version 20201002/JHC
  */
public class X2Y2_J extends SimpleFB {
/** VAR X */
  public REAL X = new REAL();
/** VAR Y */
  public REAL Y = new REAL();
/** VAR OUT */
  public REAL OUT = new REAL();
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
/** The default constructor. */
public X2Y2_J(){
    super();
  }
/** {@inheritDoc}
* @param e {@inheritDoc} */
public void serviceEvent(EventServer e){
OUT.value = (X.value-Y.value)*(X.value+Y.value);
System.out.print("Hello world");
      CNF.serviceEvent(this);
}
}
