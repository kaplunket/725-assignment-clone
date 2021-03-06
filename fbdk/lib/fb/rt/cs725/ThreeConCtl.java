/* Copyright (c)2020 Rockwell Automation. All rights reserved. */
package fb.rt.cs725;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK ThreeConCtl
  * @author JHC
  * @version 20201028/JHC
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
/** VAR PEM */
  public BOOL PEM = new BOOL();
/** VAR PEMCS */
  public BOOL PEMCS = new BOOL();
/** VAR LC */
  public INT LC = new INT();
/** VAR TRUMP */
  public BOOL TRUMP = new BOOL();
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
/** VAR LC_OUT */
  public INT LC_OUT = new INT();
/** Initialization Request */
 public EventOutput INIT = new EventOutput();
/** Normal Execution Request */
 public EventOutput REQ = new EventOutput();
/** EVENT TokenEvent */
 public EventOutput TokenEvent = new EventOutput();
/** EVENT REC_REQ */
 public EventOutput REC_REQ = new EventOutput();
/** EVENT REPLY */
 public EventOutput REPLY = new EventOutput();
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
/** EVENT MULTICAST */
 public EventOutput MULTICAST = new EventOutput();
/** EVENT ACK */
 public EventOutput ACK = new EventOutput();
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventServer eiNamed(String s){
    if("INIT".equals(s)) return INIT;
    if("REQ".equals(s)) return REQ;
    if("TokenEvent".equals(s)) return TokenEvent;
    if("REC_REQ".equals(s)) return REC_REQ;
    if("REPLY".equals(s)) return REPLY;
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
    if("MULTICAST".equals(s)) return MULTICAST;
    if("ACK".equals(s)) return ACK;
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
    if("PEM".equals(s)) return PEM;
    if("PEMCS".equals(s)) return PEMCS;
    if("LC".equals(s)) return LC;
    if("TRUMP".equals(s)) return TRUMP;
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
    if("LC_OUT".equals(s)) return LC_OUT;
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
    else if("PEM".equals(ivName)) connect_PEM((BOOL)newIV);
    else if("PEMCS".equals(ivName)) connect_PEMCS((BOOL)newIV);
    else if("LC".equals(ivName)) connect_LC((INT)newIV);
    else if("TRUMP".equals(ivName)) connect_TRUMP((BOOL)newIV);
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
/** Connect the given variable to the input variable PEM
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_PEM(BOOL newIV) throws FBRManagementException{
    PEM = newIV;
    FC12Multicast.connectIVNoException("PE",PEM);
    }
/** Connect the given variable to the input variable PEMCS
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_PEMCS(BOOL newIV) throws FBRManagementException{
    PEMCS = newIV;
    FC12Multicast.connectIVNoException("PECS",PEMCS);
    }
/** Connect the given variable to the input variable LC
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_LC(INT newIV) throws FBRManagementException{
    LC = newIV;
    FC12Multicast.connectIVNoException("LC",LC);
    }
/** Connect the given variable to the input variable TRUMP
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_TRUMP(BOOL newIV) throws FBRManagementException{
    TRUMP = newIV;
    FC12Multicast.connectIVNoException("TRUMP",TRUMP);
    }
/** FB FC12Multicast */
  protected ConveyorCTLMulticast FC12Multicast = new ConveyorCTLMulticast() ;
/** FB FC13 */
  protected ConveyorCTL FC13 = new ConveyorCTL() ;
/** FB FC11Ring */
  protected ConveyorCTLRing FC11Ring = new ConveyorCTLRing() ;
/** The default constructor. */
public ThreeConCtl(){
    super();
    FC12Multicast.INITO.connectTo(FC13.INIT);
    FC13.INITO.connectTo(INITO);
    FC13.CNF.connectTo(CNF);
    REQ.connectTo(FC12Multicast.REQ);
    REQ.connectTo(FC13.REQ);
    FC12Multicast.CNF.connectTo(CNF);
    INIT.connectTo(FC11Ring.INIT);
    REQ.connectTo(FC11Ring.REQ);
    FC11Ring.CNF.connectTo(CNF);
    FC11Ring.STOP.connectTo(STOP);
    FC11Ring.START.connectTo(START);
    FC11Ring.INITO.connectTo(FC12Multicast.INIT);
    TokenEvent.connectTo(FC11Ring.TokenEvent);
    FC11Ring.TokenEventOut.connectTo(TokenEventOut);
    REC_REQ.connectTo(FC12Multicast.REC_REQ);
    REPLY.connectTo(FC12Multicast.REPLY);
    FC12Multicast.ACK.connectTo(ACK);
    FC12Multicast.MULTICAST.connectTo(MULTICAST);
    MotoRotate3 = (BOOL)FC13.ovNamedNoException("MotoRotate");
    MotoRotate2 = (BOOL)FC12Multicast.ovNamedNoException("MotoRotate");
    FC11Ring.connectIVNoException("PE",PE);
    FC11Ring.connectIVNoException("Block",Block);
    FC11Ring.connectIVNoException("Candidate",Candidate);
    MotoRotate1 = (BOOL)FC11Ring.ovNamedNoException("MotoRotate");
    BlockCon = (BOOL)FC11Ring.ovNamedNoException("BlockCon");
    TokenOut = (BOOL)FC11Ring.ovNamedNoException("TokenOut");
    FC11Ring.connectIVNoException("TokenIn",TokenIn);
    FC11Ring.connectIVNoException("PE13CS",PE13CS);
    FC11Ring.connectIVNoException("InitToken",InitToken);
    FC12Multicast.connectIVNoException("PECS",PEMCS);
    FC12Multicast.connectIVNoException("PE",PEM);
    FC12Multicast.connectIVNoException("LC",LC);
    LC_OUT = (INT)FC12Multicast.ovNamedNoException("LC_OUT");
    FC12Multicast.connectIVNoException("TRUMP",TRUMP);
    FC12Multicast.Block.initializeNoException("0");
    FC12Multicast.Candidate.initializeNoException("0");
    FC13.PE.initializeNoException("0");
    FC13.Block.initializeNoException("0");
    FC13.Candidate.initializeNoException("0");
    FC11Ring.ConveyorNum.initializeNoException("7");
  }
/** {@inheritDoc}
 * @param fbName {@inheritDoc}
 * @param r {@inheritDoc}
 * @throws FBRManagementException {@inheritDoc} */
  public void initialize(String fbName, Resource r)
  throws FBRManagementException{
    super.initialize(fbName,r);
    FC12Multicast.initialize("FC12Multicast",r);
    FC13.initialize("FC13",r);
    FC11Ring.initialize("FC11Ring",r);
}
/** Start the FB instances. */
public void start( ){
  FC12Multicast.start();
  FC13.start();
  FC11Ring.start();
}
/** Stop the FB instances. */
public void stop( ){
  FC12Multicast.stop();
  FC13.stop();
  FC11Ring.stop();
}
}
