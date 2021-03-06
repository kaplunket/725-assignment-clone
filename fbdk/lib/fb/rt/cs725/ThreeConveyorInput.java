/* Copyright (c)2012 Rockwell Automation. All rights reserved. */
package fb.rt.cs725;import fb.rt.vhmi.*;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK ThreeConveyorInput
  * @author JHC
  * @version 20120225/JHC
  */
public class ThreeConveyorInput extends FBInstance
{
/** VAR name1 */
  public WSTRING name1 = new WSTRING();
/** VAR name2 */
  public WSTRING name2 = new WSTRING();
/** VAR name3 */
  public WSTRING name3 = new WSTRING();
/** VAR PosX1 */
  public UINT PosX1 = new UINT();
/** VAR PosY1 */
  public UINT PosY1 = new UINT();
/** VAR PosX2 */
  public UINT PosX2 = new UINT();
/** VAR PosY2 */
  public UINT PosY2 = new UINT();
/** VAR PosX3 */
  public UINT PosX3 = new UINT();
/** VAR PosY3 */
  public UINT PosY3 = new UINT();
/** Initialization Request */
 public EventOutput INIT = new EventOutput();
/** Normal Execution Request */
 public EventOutput ChangeXY = new EventOutput();
/** EVENT ChangeValidity */
 public EventOutput ChangeValidity = new EventOutput();
/** EVENT ChangePic */
 public EventOutput ChangePic = new EventOutput();
/** Initialization Confirm */
 public EventOutput INITO = new EventOutput();
/** Execution Confirmation */
 public EventOutput CNF = new EventOutput();
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventServer eiNamed(String s){
    if("INIT".equals(s)) return INIT;
    if("ChangeXY".equals(s)) return ChangeXY;
    if("ChangeValidity".equals(s)) return ChangeValidity;
    if("ChangePic".equals(s)) return ChangePic;
    return super.eiNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventOutput eoNamed(String s){
    if("INITO".equals(s)) return INITO;
    if("CNF".equals(s)) return CNF;
    return super.eoNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
* @throws FBRManagementException {@inheritDoc}
*/
  public ANY ivNamed(String s) throws FBRManagementException{
    if("name1".equals(s)) return name1;
    if("name2".equals(s)) return name2;
    if("name3".equals(s)) return name3;
    if("PosX1".equals(s)) return PosX1;
    if("PosY1".equals(s)) return PosY1;
    if("PosX2".equals(s)) return PosX2;
    if("PosY2".equals(s)) return PosY2;
    if("PosX3".equals(s)) return PosX3;
    if("PosY3".equals(s)) return PosY3;
    return super.ivNamed(s);}
/** {@inheritDoc}
* @param ivName {@inheritDoc}
* @param newIV {@inheritDoc}
* @throws FBRManagementException {@inheritDoc} */
  public void connectIV(String ivName, ANY newIV)
    throws FBRManagementException{
    if("name1".equals(ivName)) connect_name1((WSTRING)newIV);
    else if("name2".equals(ivName)) connect_name2((WSTRING)newIV);
    else if("name3".equals(ivName)) connect_name3((WSTRING)newIV);
    else if("PosX1".equals(ivName)) connect_PosX1((UINT)newIV);
    else if("PosY1".equals(ivName)) connect_PosY1((UINT)newIV);
    else if("PosX2".equals(ivName)) connect_PosX2((UINT)newIV);
    else if("PosY2".equals(ivName)) connect_PosY2((UINT)newIV);
    else if("PosX3".equals(ivName)) connect_PosX3((UINT)newIV);
    else if("PosY3".equals(ivName)) connect_PosY3((UINT)newIV);
    else super.connectIV(ivName, newIV);
    }
/** Connect the given variable to the input variable name1
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_name1(WSTRING newIV) throws FBRManagementException{
    name1 = newIV;
    FC1.connectIVNoException("name",name1);
    }
/** Connect the given variable to the input variable name2
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_name2(WSTRING newIV) throws FBRManagementException{
    name2 = newIV;
    FC2.connectIVNoException("name",name2);
    }
/** Connect the given variable to the input variable name3
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_name3(WSTRING newIV) throws FBRManagementException{
    name3 = newIV;
    FC3.connectIVNoException("name",name3);
    }
/** Connect the given variable to the input variable PosX1
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_PosX1(UINT newIV) throws FBRManagementException{
    PosX1 = newIV;
    FC1.connectIVNoException("PosX",PosX1);
    }
/** Connect the given variable to the input variable PosY1
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_PosY1(UINT newIV) throws FBRManagementException{
    PosY1 = newIV;
    FC1.connectIVNoException("PosY",PosY1);
    }
/** Connect the given variable to the input variable PosX2
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_PosX2(UINT newIV) throws FBRManagementException{
    PosX2 = newIV;
    FC2.connectIVNoException("PosX",PosX2);
    }
/** Connect the given variable to the input variable PosY2
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_PosY2(UINT newIV) throws FBRManagementException{
    PosY2 = newIV;
    FC2.connectIVNoException("PosY",PosY2);
    }
/** Connect the given variable to the input variable PosX3
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_PosX3(UINT newIV) throws FBRManagementException{
    PosX3 = newIV;
    FC3.connectIVNoException("PosX",PosX3);
    }
/** Connect the given variable to the input variable PosY3
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_PosY3(UINT newIV) throws FBRManagementException{
    PosY3 = newIV;
    FC3.connectIVNoException("PosY",PosY3);
    }
/** FB FC1 */
  protected RenderComp FC1 = new RenderComp() ;
/** FB FC2 */
  protected RenderComp FC2 = new RenderComp() ;
/** FB FC3 */
  protected RenderComp FC3 = new RenderComp() ;
/** The default constructor. */
public ThreeConveyorInput(){
    super();
    INIT.connectTo(FC1.INIT);
    ChangeXY.connectTo(FC1.ChangeXY);
    ChangeValidity.connectTo(FC1.ChangeValidity);
    ChangePic.connectTo(FC1.ChangePic);
    FC1.INITO.connectTo(FC2.INIT);
    FC2.INITO.connectTo(FC3.INIT);
    FC3.INITO.connectTo(INITO);
    FC3.CNF.connectTo(CNF);
    ChangeXY.connectTo(FC2.ChangeXY);
    ChangeValidity.connectTo(FC2.ChangeValidity);
    ChangePic.connectTo(FC2.ChangePic);
    ChangeXY.connectTo(FC3.ChangeXY);
    ChangeValidity.connectTo(FC3.ChangeValidity);
    ChangePic.connectTo(FC3.ChangePic);
    FC1.connectIVNoException("PosX",PosX1);
    FC1.connectIVNoException("PosY",PosY1);
    FC2.connectIVNoException("PosX",PosX2);
    FC2.connectIVNoException("PosY",PosY2);
    FC3.connectIVNoException("PosX",PosX3);
    FC3.connectIVNoException("PosY",PosY3);
    FC1.connectIVNoException("name",name1);
    FC2.connectIVNoException("name",name2);
    FC3.connectIVNoException("name",name3);
    FC1.Display.initializeNoException("1");
    FC1.Layer.initializeNoException("0");
    FC2.Display.initializeNoException("1");
    FC2.Layer.initializeNoException("0");
    FC3.Display.initializeNoException("1");
    FC3.Layer.initializeNoException("0");
  }
/** {@inheritDoc}
 * @param fbName {@inheritDoc}
 * @param r {@inheritDoc}
 * @throws FBRManagementException {@inheritDoc} */
  public void initialize(String fbName, Resource r)
  throws FBRManagementException{
    super.initialize(fbName,r);
    FC1.initialize("FC1",r);
    FC2.initialize("FC2",r);
    FC3.initialize("FC3",r);
}
/** Start the FB instances. */
public void start( ){
  FC1.start();
  FC2.start();
  FC3.start();
}
/** Stop the FB instances. */
public void stop( ){
  FC1.stop();
  FC2.stop();
  FC3.stop();
}
}
