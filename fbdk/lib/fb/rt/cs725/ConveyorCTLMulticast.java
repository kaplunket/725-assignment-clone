/* Copyright (c)2020 Rockwell Automation. All rights reserved. */
package fb.rt.cs725;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK ConveyorCTLMulticast
  * @author JHC
  * @version 20201028/JHC
  */
public class ConveyorCTLMulticast extends FBInstance
{
/** Input event qualifier */
  public BOOL PE = new BOOL();
/** VAR PECS */
  public BOOL PECS = new BOOL();
/** VAR LC */
  public INT LC = new INT();
/** VAR Block */
  public BOOL Block = new BOOL();
/** VAR Candidate */
  public BOOL Candidate = new BOOL();
/** VAR TRUMP */
  public BOOL TRUMP = new BOOL();
/** Output event qualifier */
  public BOOL MotoRotate = new BOOL();
/** VAR BlockCon */
  public BOOL BlockCon = new BOOL();
/** VAR LC_OUT */
  public INT LC_OUT = new INT();
/** VAR lastPE */
  public BOOL lastPE = new BOOL();
/** VAR lastBlock */
  public BOOL lastBlock = new BOOL();
/** VAR LAM_CLOCK */
  public INT LAM_CLOCK = new INT();
/** VAR HAS_TOKEN */
  public BOOL HAS_TOKEN = new BOOL();
/** Initialization Request */
 public EventServer INIT = new EventInput(this);
/** Normal Execution Request */
 public EventServer REQ = new EventInput(this);
/** EVENT REC_REQ */
 public EventServer REC_REQ = new EventInput(this);
/** EVENT REPLY */
 public EventServer REPLY = new EventInput(this);
/** EVENT CAS_STOP */
 public EventServer CAS_STOP = new EventInput(this);
/** EVENT CAS_START */
 public EventServer CAS_START = new EventInput(this);
/** Initialization Confirm */
 public EventOutput INITO = new EventOutput();
/** Execution Confirmation */
 public EventOutput CNF = new EventOutput();
/** EVENT STOP */
 public EventOutput STOP = new EventOutput();
/** EVENT START */
 public EventOutput START = new EventOutput();
/** EVENT ACK */
 public EventOutput ACK = new EventOutput();
/** EVENT MULTICAST */
 public EventOutput MULTICAST = new EventOutput();
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventServer eiNamed(String s){
    if("INIT".equals(s)) return INIT;
    if("REQ".equals(s)) return REQ;
    if("REC_REQ".equals(s)) return REC_REQ;
    if("REPLY".equals(s)) return REPLY;
    if("CAS_STOP".equals(s)) return CAS_STOP;
    if("CAS_START".equals(s)) return CAS_START;
    return super.eiNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventOutput eoNamed(String s){
    if("INITO".equals(s)) return INITO;
    if("CNF".equals(s)) return CNF;
    if("STOP".equals(s)) return STOP;
    if("START".equals(s)) return START;
    if("ACK".equals(s)) return ACK;
    if("MULTICAST".equals(s)) return MULTICAST;
    return super.eoNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
* @throws FBRManagementException {@inheritDoc}
*/
  public ANY ivNamed(String s) throws FBRManagementException{
    if("PE".equals(s)) return PE;
    if("PECS".equals(s)) return PECS;
    if("LC".equals(s)) return LC;
    if("Block".equals(s)) return Block;
    if("Candidate".equals(s)) return Candidate;
    if("TRUMP".equals(s)) return TRUMP;
    return super.ivNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
* @throws FBRManagementException {@inheritDoc}
*/
  public ANY ovNamed(String s) throws FBRManagementException{
    if("MotoRotate".equals(s)) return MotoRotate;
    if("BlockCon".equals(s)) return BlockCon;
    if("LC_OUT".equals(s)) return LC_OUT;
    return super.ovNamed(s);}
/** {@inheritDoc}
* @param ivName {@inheritDoc}
* @param newIV {@inheritDoc}
* @throws FBRManagementException {@inheritDoc} */
  public void connectIV(String ivName, ANY newIV)
    throws FBRManagementException{
    if("PE".equals(ivName)) connect_PE((BOOL)newIV);
    else if("PECS".equals(ivName)) connect_PECS((BOOL)newIV);
    else if("LC".equals(ivName)) connect_LC((INT)newIV);
    else if("Block".equals(ivName)) connect_Block((BOOL)newIV);
    else if("Candidate".equals(ivName)) connect_Candidate((BOOL)newIV);
    else if("TRUMP".equals(ivName)) connect_TRUMP((BOOL)newIV);
    else super.connectIV(ivName, newIV);
    }
/** Connect the given variable to the input variable PE
  * @param newIV The variable to connect
 */
  public void connect_PE(BOOL newIV){
    PE = newIV;
    }
/** Connect the given variable to the input variable PECS
  * @param newIV The variable to connect
 */
  public void connect_PECS(BOOL newIV){
    PECS = newIV;
    }
/** Connect the given variable to the input variable LC
  * @param newIV The variable to connect
 */
  public void connect_LC(INT newIV){
    LC = newIV;
    }
/** Connect the given variable to the input variable Block
  * @param newIV The variable to connect
 */
  public void connect_Block(BOOL newIV){
    Block = newIV;
    }
/** Connect the given variable to the input variable Candidate
  * @param newIV The variable to connect
 */
  public void connect_Candidate(BOOL newIV){
    Candidate = newIV;
    }
/** Connect the given variable to the input variable TRUMP
  * @param newIV The variable to connect
 */
  public void connect_TRUMP(BOOL newIV){
    TRUMP = newIV;
    }
private static final int index_START = 0;
private void state_START(){
  eccState = index_START;
}
private static final int index_INIT = 1;
private void state_INIT(){
  eccState = index_INIT;
  alg_INIT();
  INITO.serviceEvent(this);
  CNF.serviceEvent(this);
state_START();
}
private static final int index_CAS_START = 2;
private void state_CAS_START(){
  eccState = index_CAS_START;
  alg_START();
  START.serviceEvent(this);
  CNF.serviceEvent(this);
state_START();
}
private static final int index_CAS_STOP = 3;
private void state_CAS_STOP(){
  eccState = index_CAS_STOP;
  alg_STOP();
  STOP.serviceEvent(this);
  CNF.serviceEvent(this);
state_START();
}
private static final int index_MULTICAST = 4;
private void state_MULTICAST(){
  eccState = index_MULTICAST;
  alg_MAKE_REQUEST();
  MULTICAST.serviceEvent(this);
  CNF.serviceEvent(this);
}
private static final int index_ACCESS = 5;
private void state_ACCESS(){
  eccState = index_ACCESS;
}
private static final int index_RELEASED = 6;
private void state_RELEASED(){
  eccState = index_RELEASED;
  alg_EXIT_CS();
  ACK.serviceEvent(this);
  CNF.serviceEvent(this);
state_START();
}
private static final int index_RECEIVE = 7;
private void state_RECEIVE(){
  eccState = index_RECEIVE;
  alg_LC_CHECK();
  ACK.serviceEvent(this);
  CNF.serviceEvent(this);
state_START();
}
private static final int index_WAIT = 8;
private void state_WAIT(){
  eccState = index_WAIT;
  alg_STOP();
  CNF.serviceEvent(this);
}
private static final int index_ALT_RELEASED = 9;
private void state_ALT_RELEASED(){
  eccState = index_ALT_RELEASED;
  alg_EXIT_CS();
  ACK.serviceEvent(this);
  CNF.serviceEvent(this);
state_ACCESS();
}
private static final int index_TEMP = 10;
private void state_TEMP(){
  eccState = index_TEMP;
  alg_ENTER_CS();
  CNF.serviceEvent(this);
}
/** The default constructor. */
public ConveyorCTLMulticast(){
    super();
    lastPE.initializeNoException("1");
    lastBlock.initializeNoException("0");
  }
/** {@inheritDoc}
* @param e {@inheritDoc} */
  public void serviceEvent(EventServer e){
    if (e == INIT) service_INIT();
    else if (e == REQ) service_REQ();
    else if (e == REC_REQ) service_REC_REQ();
    else if (e == REPLY) service_REPLY();
    else if (e == CAS_STOP) service_CAS_STOP();
    else if (e == CAS_START) service_CAS_START();
  }
/** Services the INIT event. */
  public void service_INIT(){
    if ((eccState == index_START)) state_INIT();
  }
/** Services the REQ event. */
  public void service_REQ(){
    if ((eccState == index_START) && (!PE.value)) state_MULTICAST();
    else if ((eccState == index_ACCESS) && (!PECS.value)) state_RELEASED();
    else if ((eccState == index_ACCESS) && (HAS_TOKEN.value&!PE.value)) state_WAIT();
    else if ((eccState == index_WAIT) && (!PECS.value)) state_ALT_RELEASED();
    else if ((eccState == index_TEMP) && (PE.value)) state_ACCESS();
  }
/** Services the REC_REQ event. */
  public void service_REC_REQ(){
    if ((eccState == index_START) && (!HAS_TOKEN.value)) state_RECEIVE();
    else if ((eccState == index_MULTICAST) && (TRUMP.value)) state_TEMP();
  }
/** Services the REPLY event. */
  public void service_REPLY(){
    if ((eccState == index_MULTICAST) && (!HAS_TOKEN.value)) state_TEMP();
  }
/** Services the CAS_STOP event. */
  public void service_CAS_STOP(){
    if ((eccState == index_START)) state_CAS_STOP();
  }
/** Services the CAS_START event. */
  public void service_CAS_START(){
    if ((eccState == index_START)) state_CAS_START();
  }
  /** ALGORITHM INIT IN ST*/
public void alg_INIT(){
MotoRotate.value=true;
Block.value=false;
}
  /** ALGORITHM REQ IN ST*/
public void alg_REQ(){
if(Candidate.value){
if(lastPE.value!=PE.value){
if(!PE.value){
BlockCon.value=true;
}
else{
BlockCon.value=false;
}
lastPE.value=PE.value;
}
if(lastBlock.value!=Block.value){
if(Block.value){
STOP.serviceEvent(this);
MotoRotate.value=false;
}
else{
START.serviceEvent(this);
MotoRotate.value=true;
}
lastBlock.value=Block.value;
}
}
}
  /** ALGORITHM START IN ST*/
public void alg_START(){
MotoRotate.value=true;
}
  /** ALGORITHM STOP IN ST*/
public void alg_STOP(){
MotoRotate.value=false;
}
  /** ALGORITHM MAKE_REQUEST IN Java*/
public void alg_MAKE_REQUEST(){
LAM_CLOCK.value++;
LC_OUT.value = LAM_CLOCK.value;
MotoRotate.value = false;
System.out.printf("[MULTICAST] Request, LC:%d%n", LAM_CLOCK.value);

}
  /** ALGORITHM ENTER_CS IN Java*/
public void alg_ENTER_CS(){
HAS_TOKEN.value = true;
MotoRotate.value = true;
System.out.println("[MULTICAST] Enter CS");

}
  /** ALGORITHM EXIT_CS IN Java*/
public void alg_EXIT_CS(){
HAS_TOKEN.value = false;
System.out.println("[MULTICAST] Exit CS");

}
  /** ALGORITHM LC_CHECK IN Java*/
public void alg_LC_CHECK(){
System.out.println("[MULTICAST] Received request");
if (LC.value > LAM_CLOCK.value) {
LAM_CLOCK.value = LC.value;
System.out.println("[MULTICAST] LC Updated");
}

}
}
