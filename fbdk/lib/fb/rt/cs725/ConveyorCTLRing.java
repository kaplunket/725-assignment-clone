/* Copyright (c)2020 Rockwell Automation. All rights reserved. */
package fb.rt.cs725;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK ConveyorCTLRing
  * @author JHC
  * @version 20201028/JHC
  */
public class ConveyorCTLRing extends FBInstance
{
/** Input event qualifier */
  public BOOL PE = new BOOL();
/** VAR Block */
  public BOOL Block = new BOOL();
/** VAR Candidate */
  public BOOL Candidate = new BOOL();
/** VAR TokenIn */
  public BOOL TokenIn = new BOOL();
/** VAR PE13CS */
  public BOOL PE13CS = new BOOL();
/** VAR InitToken */
  public BOOL InitToken = new BOOL();
/** VAR ConveyorNum */
  public INT ConveyorNum = new INT();
/** Output event qualifier */
  public BOOL MotoRotate = new BOOL();
/** VAR BlockCon */
  public BOOL BlockCon = new BOOL();
/** VAR TokenOut */
  public BOOL TokenOut = new BOOL();
/** VAR lastPE */
  public BOOL lastPE = new BOOL();
/** VAR lastBlock */
  public BOOL lastBlock = new BOOL();
/** VAR Token */
  public BOOL Token = new BOOL();
/** Initialization Request */
 public EventServer INIT = new EventInput(this);
/** Normal Execution Request */
 public EventServer REQ = new EventInput(this);
/** EVENT CAS_STOP */
 public EventServer CAS_STOP = new EventInput(this);
/** EVENT CAS_START */
 public EventServer CAS_START = new EventInput(this);
/** EVENT TokenEvent */
 public EventServer TokenEvent = new EventInput(this);
/** Initialization Confirm */
 public EventOutput INITO = new EventOutput();
/** Execution Confirmation */
 public EventOutput CNF = new EventOutput();
/** EVENT STOP */
 public EventOutput STOP = new EventOutput();
/** EVENT START */
 public EventOutput START = new EventOutput();
/** EVENT TokenEventOut */
 public EventOutput TokenEventOut = new EventOutput();
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
*/
  public EventServer eiNamed(String s){
    if("INIT".equals(s)) return INIT;
    if("REQ".equals(s)) return REQ;
    if("CAS_STOP".equals(s)) return CAS_STOP;
    if("CAS_START".equals(s)) return CAS_START;
    if("TokenEvent".equals(s)) return TokenEvent;
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
    if("TokenEventOut".equals(s)) return TokenEventOut;
    return super.eoNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
* @throws FBRManagementException {@inheritDoc}
*/
  public ANY ivNamed(String s) throws FBRManagementException{
    if("PE".equals(s)) return PE;
    if("Block".equals(s)) return Block;
    if("Candidate".equals(s)) return Candidate;
    if("TokenIn".equals(s)) return TokenIn;
    if("PE13CS".equals(s)) return PE13CS;
    if("InitToken".equals(s)) return InitToken;
    if("ConveyorNum".equals(s)) return ConveyorNum;
    return super.ivNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
* @throws FBRManagementException {@inheritDoc}
*/
  public ANY ovNamed(String s) throws FBRManagementException{
    if("MotoRotate".equals(s)) return MotoRotate;
    if("BlockCon".equals(s)) return BlockCon;
    if("TokenOut".equals(s)) return TokenOut;
    return super.ovNamed(s);}
/** {@inheritDoc}
* @param ivName {@inheritDoc}
* @param newIV {@inheritDoc}
* @throws FBRManagementException {@inheritDoc} */
  public void connectIV(String ivName, ANY newIV)
    throws FBRManagementException{
    if("PE".equals(ivName)) connect_PE((BOOL)newIV);
    else if("Block".equals(ivName)) connect_Block((BOOL)newIV);
    else if("Candidate".equals(ivName)) connect_Candidate((BOOL)newIV);
    else if("TokenIn".equals(ivName)) connect_TokenIn((BOOL)newIV);
    else if("PE13CS".equals(ivName)) connect_PE13CS((BOOL)newIV);
    else if("InitToken".equals(ivName)) connect_InitToken((BOOL)newIV);
    else if("ConveyorNum".equals(ivName)) connect_ConveyorNum((INT)newIV);
    else super.connectIV(ivName, newIV);
    }
/** Connect the given variable to the input variable PE
  * @param newIV The variable to connect
 */
  public void connect_PE(BOOL newIV){
    PE = newIV;
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
/** Connect the given variable to the input variable TokenIn
  * @param newIV The variable to connect
 */
  public void connect_TokenIn(BOOL newIV){
    TokenIn = newIV;
    }
/** Connect the given variable to the input variable PE13CS
  * @param newIV The variable to connect
 */
  public void connect_PE13CS(BOOL newIV){
    PE13CS = newIV;
    }
/** Connect the given variable to the input variable InitToken
  * @param newIV The variable to connect
 */
  public void connect_InitToken(BOOL newIV){
    InitToken = newIV;
    }
/** Connect the given variable to the input variable ConveyorNum
  * @param newIV The variable to connect
 */
  public void connect_ConveyorNum(INT newIV){
    ConveyorNum = newIV;
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
private static final int index_AccessCritical = 2;
private void state_AccessCritical(){
  eccState = index_AccessCritical;
  alg_START();
  CNF.serviceEvent(this);
  START.serviceEvent(this);
  alg_PrintToken();
  alg_PrintCriticalSection();
}
private static final int index_PassToken = 3;
private void state_PassToken(){
  eccState = index_PassToken;
  alg_START();
  TokenEventOut.serviceEvent(this);
  alg_SetTokenFalse();
  START.serviceEvent(this);
state_START();
}
private static final int index_AwaitToken = 4;
private void state_AwaitToken(){
  eccState = index_AwaitToken;
  alg_STOP();
  CNF.serviceEvent(this);
  STOP.serviceEvent(this);
}
private static final int index_Bag2Access = 5;
private void state_Bag2Access(){
  eccState = index_Bag2Access;
  alg_STOP();
  CNF.serviceEvent(this);
  STOP.serviceEvent(this);
}
private static final int index_ReleaseToken = 6;
private void state_ReleaseToken(){
  eccState = index_ReleaseToken;
  alg_STOP();
  TokenEventOut.serviceEvent(this);
  STOP.serviceEvent(this);
state_AwaitToken();
}
private static final int index_ACcessCriticalWaitBagClear = 7;
private void state_ACcessCriticalWaitBagClear(){
  eccState = index_ACcessCriticalWaitBagClear;
  CNF.serviceEvent(this);
}
private static final int index_SetToken = 8;
private void state_SetToken(){
  eccState = index_SetToken;
  alg_SetToken();
  TokenEventOut.serviceEvent(this);
  alg_PrintToken();
state_START();
}
/** The default constructor. */
public ConveyorCTLRing(){
    super();
    lastPE.initializeNoException("1");
    lastBlock.initializeNoException("0");
  }
/** {@inheritDoc}
* @param e {@inheritDoc} */
  public void serviceEvent(EventServer e){
    if (e == INIT) service_INIT();
    else if (e == REQ) service_REQ();
    else if (e == CAS_STOP) service_CAS_STOP();
    else if (e == CAS_START) service_CAS_START();
    else if (e == TokenEvent) service_TokenEvent();
  }
/** Services the INIT event. */
  public void service_INIT(){
    if ((eccState == index_START)) state_INIT();
  }
/** Services the REQ event. */
  public void service_REQ(){
    if ((eccState == index_AccessCritical) && (!PE13CS.value)) state_PassToken();
    else if ((eccState == index_START) && (!PE.value&!Token.value)) state_AwaitToken();
    else if ((eccState == index_START) && (PE.value&Token.value)) state_PassToken();
    else if ((eccState == index_Bag2Access) && (!PE13CS.value)) state_ReleaseToken();
    else if ((eccState == index_AccessCritical) && (!PE.value)) state_Bag2Access();
    else if ((eccState == index_START) && (!PE.value&Token.value)) state_ACcessCriticalWaitBagClear();
    else if ((eccState == index_ACcessCriticalWaitBagClear) && (PE.value)) state_AccessCritical();
  }
/** Services the CAS_STOP event. */
  public void service_CAS_STOP(){
  }
/** Services the CAS_START event. */
  public void service_CAS_START(){
  }
/** Services the TokenEvent event. */
  public void service_TokenEvent(){
    if ((eccState == index_AwaitToken)) state_AccessCritical();
    else if ((eccState == index_START)) state_SetToken();
  }
  /** ALGORITHM INIT IN Java*/
public void alg_INIT(){
MotoRotate.value=true;
Block.value=false;
Token.value=InitToken.value;

}
  /** ALGORITHM REQ IN Java*/
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
  /** ALGORITHM START IN Java*/
public void alg_START(){
MotoRotate.value=true;

}
  /** ALGORITHM STOP IN Java*/
public void alg_STOP(){
MotoRotate.value=false;

}
  /** ALGORITHM SetToken IN Java*/
public void alg_SetToken(){
Token.value = true;
MotoRotate.value=true;

}
  /** ALGORITHM SetTokenFalse IN Java*/
public void alg_SetTokenFalse(){
Token.value=false;

}
  /** ALGORITHM PrintCriticalSection IN Java*/
public void alg_PrintCriticalSection(){
System.out.println("Conveyor " + ConveyorNum.value + " has access to the critical section");

}
  /** ALGORITHM PrintToken IN Java*/
public void alg_PrintToken(){
System.out.println("Conveyor " + ConveyorNum.value + " has the token");

}
}
