/* Copyright (c)2020 Rockwell Automation. All rights reserved. */
package fb.rt.cs725;
import fb.datatype.*;
import fb.rt.*;
import fb.rt.events.*;
/** FUNCTION_BLOCK Central_Server
  * @author JHC
  * @version 20201028/JHC
  */
public class Central_Server extends FBInstance
{
/** VAR Con1 */
  public BOOL Con1 = new BOOL();
/** VAR Con2 */
  public BOOL Con2 = new BOOL();
/** VAR PE */
  public BOOL PE = new BOOL();
/** VAR Enable1 */
  public BOOL Enable1 = new BOOL();
/** VAR Enable2 */
  public BOOL Enable2 = new BOOL();
/** VAR Block */
  public BOOL Block = new BOOL();
/** VAR queue1 */
  public INT queue1 = new INT();
/** VAR queue2 */
  public INT queue2 = new INT();
/** VAR queue3 */
  public INT queue3 = new INT();
/** VAR token */
  public BOOL token = new BOOL();
/** VAR Con1_prev */
  public BOOL Con1_prev = new BOOL();
/** VAR Con2_prev */
  public BOOL Con2_prev = new BOOL();
/** VAR PE_prev */
  public BOOL PE_prev = new BOOL();
/** Initialization Request */
 public EventServer INIT = new EventInput(this);
/** Normal Execution Request */
 public EventServer REQ = new EventInput(this);
/** EVENT Release */
 public EventServer Release = new EventInput(this);
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
    if("REQ".equals(s)) return REQ;
    if("Release".equals(s)) return Release;
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
    if("Con1".equals(s)) return Con1;
    if("Con2".equals(s)) return Con2;
    if("PE".equals(s)) return PE;
    return super.ivNamed(s);}
/** {@inheritDoc}
* @param s {@inheritDoc}
* @return {@inheritDoc}
* @throws FBRManagementException {@inheritDoc}
*/
  public ANY ovNamed(String s) throws FBRManagementException{
    if("Enable1".equals(s)) return Enable1;
    if("Enable2".equals(s)) return Enable2;
    if("Block".equals(s)) return Block;
    return super.ovNamed(s);}
/** {@inheritDoc}
* @param ivName {@inheritDoc}
* @param newIV {@inheritDoc}
* @throws FBRManagementException {@inheritDoc} */
  public void connectIV(String ivName, ANY newIV)
    throws FBRManagementException{
    if("Con1".equals(ivName)) connect_Con1((BOOL)newIV);
    else if("Con2".equals(ivName)) connect_Con2((BOOL)newIV);
    else if("PE".equals(ivName)) connect_PE((BOOL)newIV);
    else super.connectIV(ivName, newIV);
    }
/** Connect the given variable to the input variable Con1
  * @param newIV The variable to connect
 */
  public void connect_Con1(BOOL newIV){
    Con1 = newIV;
    }
/** Connect the given variable to the input variable Con2
  * @param newIV The variable to connect
 */
  public void connect_Con2(BOOL newIV){
    Con2 = newIV;
    }
/** Connect the given variable to the input variable PE
  * @param newIV The variable to connect
 */
  public void connect_PE(BOOL newIV){
    PE = newIV;
    }
private static final int index_START = 0;
private void state_START(){
  eccState = index_START;
}
private static final int index_INIT = 1;
private void state_INIT(){
  eccState = index_INIT;
  alg_INIT();
  CNF.serviceEvent(this);
  alg_INIT();
  INITO.serviceEvent(this);
state_START();
}
private static final int index_REQ = 2;
private void state_REQ(){
  eccState = index_REQ;
  alg_REQ();
state_Update_Con();
}
private static final int index_Release = 3;
private void state_Release(){
  eccState = index_Release;
  alg_Release();
  CNF.serviceEvent(this);
state_START();
}
private static final int index_Check_Release = 4;
private void state_Check_Release(){
  eccState = index_Check_Release;
  alg_Check_Token_Release();
    if(token.value) state_Release();
    else if(!token.value) state_START();
}
private static final int index_Update_Con = 5;
private void state_Update_Con(){
  eccState = index_Update_Con;
  alg_Con_Prev_Update();
    if(Con2.value|Con1.value) state_Release();
    else if(!Con2.value&!Con1.value) state_START();
}
private static final int index_REQ2 = 6;
private void state_REQ2(){
  eccState = index_REQ2;
  alg_REQ2();
state_Update_Con();
}
/** The default constructor. */
public Central_Server(){
    super();
    queue1.initializeNoException("0");
    queue2.initializeNoException("0");
    queue3.initializeNoException("0");
  }
/** {@inheritDoc}
* @param e {@inheritDoc} */
  public void serviceEvent(EventServer e){
    if (e == INIT) service_INIT();
    else if (e == REQ) service_REQ();
    else if (e == Release) service_Release();
  }
/** Services the INIT event. */
  public void service_INIT(){
    if ((eccState == index_START)) state_INIT();
  }
/** Services the REQ event. */
  public void service_REQ(){
    if ((eccState == index_START) && ((!Con1.value==Con1_prev.value))) state_REQ();
    else if ((eccState == index_START) && ((!Con2.value==Con2_prev.value))) state_REQ2();
  }
/** Services the Release event. */
  public void service_Release(){
    if ((eccState == index_START)) state_Check_Release();
  }
  /** ALGORITHM INIT IN Java*/
public void alg_INIT(){
Enable1.value=false;
Enable2.value=false;
token.value=true;
Con1_prev.value=true;
Con2_prev.value=true;

}
  /** ALGORITHM REQ IN Java*/
public void alg_REQ(){
System.out.println("Request to server from conveyor 2");
System.out.print("Conveyor 2 bag status:");
System.out.println(Con1.value);

System.out.print("Conveyor 2 motor status:");
System.out.println(Enable1.value);
if (Con1.value){
if (queue1.value == 0){
queue1.value=1;
}else if (queue2.value == 0){
queue2.value=1;
}else{
queue3.value=1;
}
Enable1.value=true;
}
}
  /** ALGORITHM Release IN Java*/
public void alg_Release(){
if(token.value){
if(queue1.value!=0){

System.out.println("QUEUE:");
System.out.println(queue1);
System.out.println(queue2);
System.out.println(queue3);

System.out.print("RELEASE SENSOR:");
System.out.println(PE.value);

if(queue1.value==1){
Enable1.value=false;
System.out.print("Input 1 has accessed section");
}else{
Enable2.value=false;
System.out.print("Input 2 has accessed section");
}
token.value=false;
queue1.value=queue2.value;
queue2.value=queue3.value;
queue3.value=0;
}else{
Enable1.value=false;
Enable2.value=false;
}
}

}
  /** ALGORITHM Check_Token_Release IN Java*/
public void alg_Check_Token_Release(){
if(PE_prev.value != PE.value){
if(PE.value == false){
token.value=true;
System.out.println("Token has been released to server");
}
PE_prev.value=PE.value;
}
}
  /** ALGORITHM Con_Prev_Update IN Java*/
public void alg_Con_Prev_Update(){
Con1_prev.value=Con1.value;
Con2_prev.value=Con2.value;

}
  /** ALGORITHM REQ2 IN Java*/
public void alg_REQ2(){
System.out.println("Request to server from conveyor 6");

System.out.print("Conveyor 6 bag status:");
System.out.println(Con2.value);

System.out.print("Conveyor 6 motor status:");
System.out.println(Enable2.value);
if (Con2.value){
if (queue1.value == 0){
queue1.value=2;
}else if (queue2.value == 0){
queue2.value=2;
}else{
queue3.value=2;
}
Enable2.value=true;
}

}
}
