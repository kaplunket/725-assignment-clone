/* Copyright (c)2020 Rockwell Automation. All rights reserved. */
package fb.rt.cs725;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK ThreeConCtl
  * @author JHC
  * @version 20201027/JHC
  */
public class ThreeConCtl extends FBInstance
{
/** VAR Candidate */
  public BOOL Candidate = new BOOL();
/** VAR Block */
  public BOOL Block = new BOOL();
/** VAR PE */
  public BOOL PE = new BOOL();
/** VAR PE13CS */
  public BOOL PE13CS = new BOOL();
/** VAR TokenIn */
  public BOOL TokenIn = new BOOL();
/** VAR InitToken */
  public BOOL InitToken = new BOOL();
/** VAR MotoRotate1 */
  public BOOL MotoRotate1 = new BOOL();
/** VAR MotoRotate2 */
  public BOOL MotoRotate2 = new BOOL();
/** VAR MotoRotate3 */
  public BOOL MotoRotate3 = new BOOL();
/** VAR BlockCon */
  public BOOL BlockCon = new BOOL();
/** VAR TokenOut */
  public BOOL TokenOut = new BOOL();
/** Initialization Request */
 public EventOutput INIT = new EventOutput();
/** Normal Execution Request */
 public EventOutput REQ = new EventOutput();
/** EVENT TokenEvent */
 public EventOutput TokenEvent = new EventOutput();
/** Initialization Confirm */
 public EventOutput INITO = new EventOutput();
/** Execution Confirmation */
 public EventOutput CNF = new EventOutput();
/** EVENT START */
 public EventOutput START = new EventOutput();
/** EVENT STOP */
 public EventOutput STOP = new EventOutput();
/** EVENT TokenEventOut */
 public EventOutput TokenEventOut = new EventOutput();
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventServer eiNamed(String s){
    if("INIT".equals(s)) return INIT;
    if("REQ".equals(s)) return REQ;
    if("TokenEvent".equals(s)) return TokenEvent;
    return super.eiNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventOutput eoNamed(String s){
    if("INITO".equals(s)) return INITO;
    if("CNF".equals(s)) return CNF;
    if("START".equals(s)) return START;
    if("STOP".equals(s)) return STOP;
    if("TokenEventOut".equals(s)) return TokenEventOut;
    return super.eoNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
* @throws FBRManagementException {@inheritDoc}
*/
  public ANY ivNamed(String s) throws FBRManagementException{
    if("Candidate".equals(s)) return Candidate;
    if("Block".equals(s)) return Block;
    if("PE".equals(s)) return PE;
    if("PE13CS".equals(s)) return PE13CS;
    if("TokenIn".equals(s)) return TokenIn;
    if("InitToken".equals(s)) return InitToken;
    return super.ivNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
* @throws FBRManagementException {@inheritDoc}
*/
  public ANY ovNamed(String s) throws FBRManagementException{
    if("MotoRotate1".equals(s)) return MotoRotate1;
    if("MotoRotate2".equals(s)) return MotoRotate2;
    if("MotoRotate3".equals(s)) return MotoRotate3;
    if("BlockCon".equals(s)) return BlockCon;
    if("TokenOut".equals(s)) return TokenOut;
    return super.ovNamed(s);}
/** {@inheritDoc}
* @param ivName {@inheritDoc}
* @param newIV {@inheritDoc}
* @throws FBRManagementException {@inheritDoc} */
  public void connectIV(String ivName, ANY newIV)
    throws FBRManagementException{
    if("Candidate".equals(ivName)) connect_Candidate((BOOL)newIV);
    else if("Block".equals(ivName)) connect_Block((BOOL)newIV);
    else if("PE".equals(ivName)) connect_PE((BOOL)newIV);
    else if("PE13CS".equals(ivName)) connect_PE13CS((BOOL)newIV);
    else if("TokenIn".equals(ivName)) connect_TokenIn((BOOL)newIV);
    else if("InitToken".equals(ivName)) connect_InitToken((BOOL)newIV);
    else super.connectIV(ivName, newIV);
    }
/** Connect the given variable to the input variable Candidate
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_Candidate(BOOL newIV) throws FBRManagementException{
    Candidate = newIV;
    FC11Ring.connectIVNoException("Candidate",Candidate);
    }
/** Connect the given variable to the input variable Block
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_Block(BOOL newIV) throws FBRManagementException{
    Block = newIV;
    FC11Ring.connectIVNoException("Block",Block);
    }
/** Connect the given variable to the input variable PE
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_PE(BOOL newIV) throws FBRManagementException{
    PE = newIV;
    FC11Ring.connectIVNoException("PE",PE);
    }
/** Connect the given variable to the input variable PE13CS
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_PE13CS(BOOL newIV) throws FBRManagementException{
    PE13CS = newIV;
    FC11Ring.connectIVNoException("PE13CS",PE13CS);
    }
/** Connect the given variable to the input variable TokenIn
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_TokenIn(BOOL newIV) throws FBRManagementException{
    TokenIn = newIV;
    FC11Ring.connectIVNoException("TokenIn",TokenIn);
    }
/** Connect the given variable to the input variable InitToken
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_InitToken(BOOL newIV) throws FBRManagementException{
    InitToken = newIV;
    FC11Ring.connectIVNoException("InitToken",InitToken);
    }
/** FB FC12 */
  protected ConveyorCTL FC12 = new ConveyorCTL() ;
/** FB FC13 */
  protected ConveyorCTL FC13 = new ConveyorCTL() ;
/** FB FC11Ring */
  protected ConveyorCTLRing FC11Ring = new ConveyorCTLRing() ;
/** The default constructor. */
public ThreeConCtl(){
    super();
    FC12.INITO.connectTo(FC13.INIT);
    FC13.INITO.connectTo(INITO);
    FC13.CNF.connectTo(CNF);
    REQ.connectTo(FC12.REQ);
    REQ.connectTo(FC13.REQ);
    FC12.CNF.connectTo(CNF);
    INIT.connectTo(FC11Ring.INIT);
    REQ.connectTo(FC11Ring.REQ);
    FC11Ring.CNF.connectTo(CNF);
    FC11Ring.STOP.connectTo(STOP);
    FC11Ring.START.connectTo(START);
    FC11Ring.INITO.connectTo(FC12.INIT);
    TokenEvent.connectTo(FC11Ring.TokenEvent);
    FC11Ring.TokenEventOut.connectTo(TokenEventOut);
    MotoRotate3 = (BOOL)FC13.ovNamedNoException("MotoRotate");
    MotoRotate2 = (BOOL)FC12.ovNamedNoException("MotoRotate");
    FC11Ring.connectIVNoException("PE",PE);
    FC11Ring.connectIVNoException("Block",Block);
    FC11Ring.connectIVNoException("Candidate",Candidate);
    MotoRotate1 = (BOOL)FC11Ring.ovNamedNoException("MotoRotate");
    BlockCon = (BOOL)FC11Ring.ovNamedNoException("BlockCon");
    TokenOut = (BOOL)FC11Ring.ovNamedNoException("TokenOut");
    FC11Ring.connectIVNoException("TokenIn",TokenIn);
    FC11Ring.connectIVNoException("PE13CS",PE13CS);
    FC11Ring.connectIVNoException("InitToken",InitToken);
    FC12.PE.initializeNoException("0");
    FC12.Block.initializeNoException("0");
    FC12.Candidate.initializeNoException("0");
    FC13.PE.initializeNoException("0");
    FC13.Block.initializeNoException("0");
    FC13.Candidate.initializeNoException("0");
  }
/** {@inheritDoc}
 * @param fbName {@inheritDoc}
 * @param r {@inheritDoc}
 * @throws FBRManagementException {@inheritDoc} */
  public void initialize(String fbName, Resource r)
  throws FBRManagementException{
    super.initialize(fbName,r);
    FC12.initialize("FC12",r);
    FC13.initialize("FC13",r);
    FC11Ring.initialize("FC11Ring",r);
}
/** Start the FB instances. */
public void start( ){
  FC12.start();
  FC13.start();
  FC11Ring.start();
}
/** Stop the FB instances. */
public void stop( ){
  FC12.stop();
  FC13.stop();
  FC11Ring.stop();
}
}
