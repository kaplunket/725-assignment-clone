/* Copyright (c)2020 Rockwell Automation. All rights reserved. */
package fb.rt.cs725;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK TwoConCtlMulticast
  * @author JHC
  * @version 20201028/JHC
  */
public class TwoConCtlMulticast extends FBInstance
{
/** VAR Candidate */
  public BOOL Candidate = new BOOL();
/** VAR Block */
  public BOOL Block = new BOOL();
/** VAR PE */
  public BOOL PE = new BOOL();
/** VAR PECS */
  public BOOL PECS = new BOOL();
/** VAR LC */
  public INT LC = new INT();
/** VAR TRUMP */
  public BOOL TRUMP = new BOOL();
/** VAR MotoRotate1 */
  public BOOL MotoRotate1 = new BOOL();
/** VAR MotoRotate2 */
  public BOOL MotoRotate2 = new BOOL();
/** VAR BlockCon */
  public BOOL BlockCon = new BOOL();
/** VAR LC_OUT */
  public INT LC_OUT = new INT();
/** Initialization Request */
 public EventOutput INIT = new EventOutput();
/** Normal Execution Request */
 public EventOutput REQ = new EventOutput();
/** EVENT START */
 public EventOutput START = new EventOutput();
/** EVENT STOP */
 public EventOutput STOP = new EventOutput();
/** EVENT REC_REQ */
 public EventOutput REC_REQ = new EventOutput();
/** EVENT REPLY */
 public EventOutput REPLY = new EventOutput();
/** Initialization Confirm */
 public EventOutput INITO = new EventOutput();
/** Execution Confirmation */
 public EventOutput CNF = new EventOutput();
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
    if("START".equals(s)) return START;
    if("STOP".equals(s)) return STOP;
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
    if("PECS".equals(s)) return PECS;
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
    if("BlockCon".equals(s)) return BlockCon;
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
    else if("PECS".equals(ivName)) connect_PECS((BOOL)newIV);
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
    FC12Multicast.connectIVNoException("Candidate",Candidate);
    }
/** Connect the given variable to the input variable Block
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_Block(BOOL newIV) throws FBRManagementException{
    Block = newIV;
    FC12Multicast.connectIVNoException("Block",Block);
    }
/** Connect the given variable to the input variable PE
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_PE(BOOL newIV) throws FBRManagementException{
    PE = newIV;
    FC12Multicast.connectIVNoException("PE",PE);
    }
/** Connect the given variable to the input variable PECS
  * @param newIV The variable to connect
  * @throws FBRManagementException An internal connection failed.
 */
  public void connect_PECS(BOOL newIV) throws FBRManagementException{
    PECS = newIV;
    FC12Multicast.connectIVNoException("PECS",PECS);
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
/** FB FC11 */
  protected ConveyorCTL FC11 = new ConveyorCTL() ;
/** FB FC12Multicast */
  protected ConveyorCTLMulticast FC12Multicast = new ConveyorCTLMulticast() ;
/** The default constructor. */
public TwoConCtlMulticast(){
    super();
    INIT.connectTo(FC11.INIT);
    REQ.connectTo(FC11.REQ);
    FC11.INITO.connectTo(FC12Multicast.INIT);
    FC12Multicast.START.connectTo(FC11.CAS_START);
    FC12Multicast.STOP.connectTo(FC11.CAS_STOP);
    REQ.connectTo(FC12Multicast.REQ);
    FC12Multicast.ACK.connectTo(ACK);
    FC12Multicast.MULTICAST.connectTo(MULTICAST);
    REC_REQ.connectTo(FC12Multicast.REC_REQ);
    REPLY.connectTo(FC12Multicast.REPLY);
    MotoRotate1 = (BOOL)FC11.ovNamedNoException("MotoRotate");
    FC12Multicast.connectIVNoException("PE",PE);
    FC12Multicast.connectIVNoException("Block",Block);
    FC12Multicast.connectIVNoException("Candidate",Candidate);
    MotoRotate2 = (BOOL)FC12Multicast.ovNamedNoException("MotoRotate");
    BlockCon = (BOOL)FC12Multicast.ovNamedNoException("BlockCon");
    FC12Multicast.connectIVNoException("PECS",PECS);
    FC12Multicast.connectIVNoException("LC",LC);
    FC12Multicast.connectIVNoException("TRUMP",TRUMP);
    LC_OUT = (INT)FC12Multicast.ovNamedNoException("LC_OUT");
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
    FC12Multicast.initialize("FC12Multicast",r);
}
/** Start the FB instances. */
public void start( ){
  FC11.start();
  FC12Multicast.start();
}
/** Stop the FB instances. */
public void stop( ){
  FC11.stop();
  FC12Multicast.stop();
}
}
