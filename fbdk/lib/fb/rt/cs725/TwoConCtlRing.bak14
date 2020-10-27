/* Copyright (c)2020 Rockwell Automation. All rights reserved. */
package fb.rt.cs725;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK TwoConCtlRing
  * @author JHC
  * @version 20201027/JHC
  */
public class TwoConCtlRing extends FBInstance
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
/** VAR MotoRotate1 */
  public BOOL MotoRotate1 = new BOOL();
/** VAR MotoRotate2 */
  public BOOL MotoRotate2 = new BOOL();
/** VAR BlockCon */
  public BOOL BlockCon = new BOOL();
/** VAR TokenOut */
  public BOOL TokenOut = new BOOL();
/** Initialization Request */
 public EventOutput INIT = new EventOutput();
/** Normal Execution Request */
 public EventOutput REQ = new EventOutput();
/** EVENT START */
 public EventOutput START = new EventOutput();
/** EVENT STOP */
 public EventOutput STOP = new EventOutput();
/** EVENT TokenEvent */
 public EventOutput TokenEvent = new EventOutput();
/** Initialization Confirm */
 public EventOutput INITO = new EventOutput();
/** Execution Confirmation */
 public EventOutput CNF = new EventOutput();
/** EVENT TokenEventOut */
 public EventOutput TokenEventOut = new EventOutput();
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventServer eiNamed(String s){
    if("INIT".equals(s)) return INIT;
    if("REQ".equals(s)) return REQ;
    if("START".equals(s)) return START;
    if("STOP".equals(s)) return STOP;
    if("TokenEvent".equals(s)) return TokenEvent;
    return super.eiNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventOutput eoNamed(String s){
    if("INITO".equals(s)) return INITO;
    if("CNF".equals(s)) return CNF;
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
    return super.ivNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
* @throws FBRManagementException {@inheritDoc}
*/
  public ANY ovNamed(String s) throws FBRManagementException{
    if("MotoRotate1".equals(s)) return MotoRotate1;
    if("MotoRotate2".equals(s)) return MotoRotate2;
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
    else super.connectIV(ivName, newIV);
    }
/** Connect the given variable to the input variable Candidate
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_Candidate(BOOL newIV) throws FBRManagementException{
    Candidate = newIV;
    FC12Ring.connectIVNoException("Candidate",Candidate);
    }
/** Connect the given variable to the input variable Block
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_Block(BOOL newIV) throws FBRManagementException{
    Block = newIV;
    FC12Ring.connectIVNoException("Block",Block);
    }
/** Connect the given variable to the input variable PE
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_PE(BOOL newIV) throws FBRManagementException{
    PE = newIV;
    FC12Ring.connectIVNoException("PE",PE);
    }
/** Connect the given variable to the input variable PE13CS
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_PE13CS(BOOL newIV) throws FBRManagementException{
    PE13CS = newIV;
    FC12Ring.connectIVNoException("PE13CS",PE13CS);
    }
/** Connect the given variable to the input variable TokenIn
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_TokenIn(BOOL newIV) throws FBRManagementException{
    TokenIn = newIV;
    FC12Ring.connectIVNoException("TokenIn",TokenIn);
    }
/** FB FC11 */
  protected ConveyorCTL FC11 = new ConveyorCTL() ;
/** FB FC12Ring */
  protected ConveyorCTLRing FC12Ring = new ConveyorCTLRing() ;
/** The default constructor. */
public TwoConCtlRing(){
    super();
    INIT.connectTo(FC11.INIT);
    REQ.connectTo(FC11.REQ);
    REQ.connectTo(FC12Ring.REQ);
    STOP.connectTo(FC12Ring.CAS_STOP);
    START.connectTo(FC12Ring.CAS_START);
    TokenEvent.connectTo(FC12Ring.TokenEvent);
    FC12Ring.INITO.connectTo(INITO);
    FC12Ring.CNF.connectTo(CNF);
    FC12Ring.TokenEventOut.connectTo(TokenEventOut);
    FC11.INITO.connectTo(FC12Ring.INIT);
    FC12Ring.STOP.connectTo(FC11.CAS_STOP);
    FC12Ring.START.connectTo(FC11.CAS_START);
    MotoRotate1 = (BOOL)FC11.ovNamedNoException("MotoRotate");
    FC12Ring.connectIVNoException("PE",PE);
    FC12Ring.connectIVNoException("Block",Block);
    FC12Ring.connectIVNoException("Candidate",Candidate);
    FC12Ring.connectIVNoException("TokenIn",TokenIn);
    MotoRotate2 = (BOOL)FC12Ring.ovNamedNoException("MotoRotate");
    BlockCon = (BOOL)FC12Ring.ovNamedNoException("BlockCon");
    TokenOut = (BOOL)FC12Ring.ovNamedNoException("TokenOut");
    FC12Ring.connectIVNoException("PE13CS",PE13CS);
    FC11.PE.initializeNoException("0");
    FC11.Block.initializeNoException("0");
    FC11.Candidate.initializeNoException("0");
  }
/** {@inheritDoc}
 * @param fbName {@inheritDoc}
 * @param r {@inheritDoc}
 * @throws FBRManagementException {@inheritDoc} */
  public void initialize(String fbName, Resource r)
  throws FBRManagementException{
    super.initialize(fbName,r);
    FC11.initialize("FC11",r);
    FC12Ring.initialize("FC12Ring",r);
}
/** Start the FB instances. */
public void start( ){
  FC11.start();
  FC12Ring.start();
}
/** Stop the FB instances. */
public void stop( ){
  FC11.stop();
  FC12Ring.stop();
}
}
